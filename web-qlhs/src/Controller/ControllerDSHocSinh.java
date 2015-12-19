package Controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;






import Model.ModelDiem;
import Model.ModelHS;
import Model.ModelLop;
import dto.dtoDiem;
import dto.dtoHocSinh;

/**
 * Servlet implementation class ControllerDSHocSinh
 */
@WebServlet("/ControllerDSHocSinh")
public class ControllerDSHocSinh extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControllerDSHocSinh() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		
		
		request.getRequestDispatcher("view/dshocsinh.jsp").include(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
				
		
		if(request.getParameter("btn_change")!= null)
		{
			String from = request.getParameter("from");
			String to = request.getParameter("to");
			
			ModelHS hs = new ModelHS();
			ModelDiem diem = new ModelDiem();
			List<dtoHocSinh> ds = hs.getDSHS(from);
			int count = 0;
			for(dtoHocSinh i : ds)
			{
				dtoDiem d = diem.getDiem(i.getMaHS(),from);				
				int tb= Integer.parseInt(d.getTapLamVan())+Integer.parseInt(d.getTiengViet())+Integer.parseInt(d.getToan());
				if(tb >= 15){
					diem.create(i.getMaHS(), to);
					count++;
				}
			}				
			request.setAttribute("count", count);
		}
		
		if(request.getParameter("btn_submit")!= null)
		{
			String hoten = request.getParameter("hoten");
			String ngaysinh = request.getParameter("ngaysinh");
			String gioitinh = request.getParameter("gioitinh");
			String dantoc = request.getParameter("dantoc");
			String tongiao = request.getParameter("tongiao");
			String diachi = request.getParameter("diachi");
			String sdt = request.getParameter("sdt");
			String lop = request.getParameter("lop");
			dtoHocSinh dto = new dtoHocSinh();
			
			dto.setDanToc(dantoc);
			dto.setDiaChi(diachi);
			dto.setHoTen(hoten);
			dto.setNgaySinh(ngaysinh);
			dto.setLop(lop);
			dto.setGioiTinh(gioitinh);
			dto.setTonGiao(tongiao);
			dto.setSdt(sdt);
			
			ModelHS model = new ModelHS();
			if(model.add(dto))
				request.setAttribute("ss", "Thêm thành công");
			else
				request.setAttribute("ss", "Thêm thất bại");
		}
		
		
		request.getRequestDispatcher("view/dshocsinh.jsp").include(request, response);
		
		
		
	}

}

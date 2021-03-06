package Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.ModelLop;
import dto.dtoLop;

/**
 * Servlet implementation class ControllerDSLop
 */
@WebServlet("/ControllerDSLop")
public class ControllerDSLop extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private ModelLop mdLop = new ModelLop();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControllerDSLop() {
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
		request.getRequestDispatcher("view/dslop.jsp").include(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		int num_row = 0;
		if(request.getParameter("btnSubmit") != null){
			dtoLop lop = new dtoLop();
			lop.setGiaoVien(request.getParameter("txtGV"));			
			lop.setTenLop(request.getParameter("txtLop"));
			lop.setNamHoc(request.getParameter("txtnh"));
			lop.setSiSo(request.getParameter("txtss"));
			num_row = mdLop.AddLop(lop);
		}
		if(num_row > 0)
		{
			request.setAttribute("add_status", "yes");			
		}
		else
		{
			request.setAttribute("add_status", "no");
		}
		request.getRequestDispatcher("view/dslop.jsp").include(request, response);
	}

}

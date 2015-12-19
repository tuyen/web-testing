package Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import Model.ModelDiem;
import dto.dtoDiem;
import dto.dtoLop;

/**
 * Servlet implementation class ControllerLop
 */
@WebServlet("/ControllerLop")
public class ControllerLop extends HttpServlet {
	private static final long serialVersionUID = 1L;
       private ModelDiem mdd = new ModelDiem();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControllerLop() {
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
		request.getRequestDispatcher("view/lop.jsp").include(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		if(request.getParameter("btnSubmit") != null){
			dtoDiem d = new dtoDiem();
			d.setMaHS(request.getParameter("txths"));			
			d.setMaLop(request.getParameter("txtmalop"));
			d.setTapLamVan(request.getParameter("txttlv"));
			d.setTiengViet(request.getParameter("txtTV"));
			d.setToan(request.getParameter("txtToan"));
			mdd.updateDiem(d);
			HttpSession session  = request.getSession();
			session.setAttribute("turn", "ok");
		}
		
//		request.getRequestDispatcher("view/lop.jsp").include(request, response);
		response.sendRedirect("ControllerLop?lop="+request.getParameter("txtmalop"));
	}

}

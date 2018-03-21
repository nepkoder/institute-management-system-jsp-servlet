package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CourseDAO;
import dao.RelationDAO;
import dao.StudentDAO;

/**
 * Servlet implementation class RelationController
 */
@WebServlet({"/admin/relation/add","/admin/relation/display"})
public class RelationController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RelationController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		String urll = request.getRequestURI();
		String cp = request.getContextPath();
		
		 if (urll.equals(cp+"/admin/relation/add")) {
			request.setAttribute("studentdata", StudentDAO.selectAll());
			request.setAttribute("coursedata", CourseDAO.selectAll());
			
			request.getRequestDispatcher("/coursestudent.jsp").forward(request, response);
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String urll = request.getRequestURI();
		String cp = request.getContextPath();
		
		if (urll.equals(cp+"/admin/relation/add")) {
			int sid = Integer.parseInt(request.getParameter("sid"));
			int cid = Integer.parseInt(request.getParameter("cid"));
			
			RelationDAO.AddRelation(sid, cid);
			
			response.sendRedirect(cp+"/admin/relation/display");
			
		}
		
		
		doGet(request, response);
	}

}

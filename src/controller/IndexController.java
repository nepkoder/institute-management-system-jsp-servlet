package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class IndexController
 */
@WebServlet({"/404","/login","/logout"})
public class IndexController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public IndexController() {
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

		if (request.getRequestURI().equals(request.getContextPath() + "/404")) {
			RequestDispatcher rd = request.getRequestDispatcher("/404.jsp");
			rd.forward(request, response);
		} 
		else if (request.getRequestURI().equals(request.getContextPath()+"/login")) {
			RequestDispatcher rd = request.getRequestDispatcher("/login.jsp");
			rd.forward(request, response);
		}
		else if(request.getRequestURI().equals(request.getContextPath()+"/logout")) {
			
			HttpSession session = request.getSession(false);
			session.invalidate();		// remove session
			response.sendRedirect(request.getContextPath()+"/admin/login?logout");
		}
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url = request.getRequestURI();
		String cp = request.getContextPath();
		if (url.equals(cp+"/login")) {
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			
			if (username.equals("admin") && password.equals("admin")) {
				HttpSession session = request.getSession();
				session.setAttribute("user", "admin");
				System.out.println("Login successful");
				response.sendRedirect(cp+"/admin/dashboard");
				
			}
		}
	}

}

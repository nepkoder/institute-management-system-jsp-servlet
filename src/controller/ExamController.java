package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ExamDAO;
import dao.StudentDAO;
import model.Answer;
import model.ExamModel;
import model.StudentModel;

/**
 * Servlet implementation class ExamController
 */
@WebServlet({"/admin/exam/add", "/admin/exam/take"})
public class ExamController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ExamController() {
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

		if (request.getRequestURI().equals(request.getContextPath() + "/admin/exam/take")) {			
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("/takeExam.jsp");
			requestDispatcher.forward(request, response);
		}
		
		 if (request.getRequestURI().equals(request.getContextPath() + "/admin/exam/add")) {
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("/addExam.jsp");
			requestDispatcher.forward(request, response);
		}
	

		else if (request.getRequestURI().equals(request.getContextPath() + "/admin/exam/take")) {
			// fetch all course information from database
			ArrayList<ExamModel> arrayList = ExamDAO.getExamDetails();

			for (ExamModel e : arrayList) {
				System.out.println(e.getAnswer() + " " + e.getQuestion() + " " + e.getEid());
			}

			request.setAttribute("qa", arrayList);
			// forwarding to the display page
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("/takeExam.jsp");
			requestDispatcher.forward(request, response);

		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
		if (request.getRequestURI().equals(request.getContextPath() + "/admin/exam/add")) {
            String q = request.getParameter("question");
//        float coursePrice = Float.parseFloat(request.getParameter("cPrice"));
            String a1 = request.getParameter("ans1");
            String a2 = request.getParameter("ans2");
            String a3 = request.getParameter("ans3");
            String a4 = request.getParameter("ans4");
            String r = request.getParameter("right");
            
            Answer a = new Answer(a1,a2,a3,a4,r);          
            ExamModel em = new ExamModel(q, a);
            
            ExamDAO.insert(em);
            response.sendRedirect(request.getContextPath() + "/admin/exam/add");

            
		}

	}

}

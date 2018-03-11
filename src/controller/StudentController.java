package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CourseDAO;
import model.CourseModel;
import model.StudentModel;

/**
 * Servlet implementation class StudentController
 */
@WebServlet({"/admin/student/add","/admin/student/display","/admin/student/delete","/admin/student/edit"})
public class StudentController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		 if (request.getRequestURI().equals(request.getContextPath()+"/admin/student/add")){
	            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/addStudent.jsp");
	            requestDispatcher.forward(request,response);
	        }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
		if (request.getRequestURI().equals(request.getContextPath() + "/admin/student/add")) {
            String stdName = request.getParameter("sname");
//        float coursePrice = Float.parseFloat(request.getParameter("cPrice"));
            String stdGender = request.getParameter("sgender");
            String stdCountry = request.getParameter("scountry");
            String[] stdHobbies = request.getParameterValues("shobbies");

//            System.out.println(courseTitle + " " + coursePrice + " " + courseDuration);

            //create model object and insert these values in its fields
            
            StudentModel studentModel = new StudentModel(stdName, stdCountry, stdGender, stdHobbies);

            //send this model to dao in order to save
//            if( CourseDAO.insert(studentModel) == true ) {
//                //redirect to add course page
//                response.sendRedirect(request.getContextPath() + "/admin/student/add");
//            }
		
	}

}

package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CourseDAO;
import model.CourseModel;

/**
 * Servlet implementation class cservlet
 */
@WebServlet({"/admin/course/add","/admin/course/display","/admin/course/edit","/admin/course/delete"})
public class CourseController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CourseController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		 if (request.getRequestURI().equals(request.getContextPath()+"/admin/course/add")){
	            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/addCourse.jsp");
	            requestDispatcher.forward(request,response);
	        }
	        else if (request.getRequestURI().equals(request.getContextPath()+"/admin/course/display")){
	            // fetch all course information from database
	            ArrayList<CourseModel> arrayList = CourseDAO.selectAll();

	            for(CourseModel courseModel : arrayList){
	                System.out.println(courseModel.getId()+" "+courseModel.getTitle()+" "+courseModel.getPrice()+" "+courseModel.getDuration());
	            }

	            request.setAttribute("CourseData",arrayList);
	            //forwarding to the display page
	            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/displayCourse.jsp");
	            requestDispatcher.forward(request,response);
	        }
	        else if (request.getRequestURI().equals(request.getContextPath()+"/admin/course/edit")){
	            int id = Integer.parseInt(request.getParameter("id"));
	            ArrayList<CourseModel> arrayList = CourseDAO.getById(id);
	            request.setAttribute("editDetails",arrayList);

	            request.getRequestDispatcher("/editCourse.jsp").forward(request,response);
	        }
	        else if(request.getRequestURI().equals(request.getContextPath()+"/admin/course/delete")){
	            int id = Integer.parseInt(request.getParameter("id"));
	            if( CourseDAO.DeleteContent(id) == true ){
	                System.out.println("One row deleted !!!");
	                response.sendRedirect(request.getContextPath()+"/admin/course/display");
	            }
//	            else {
//	                processRequest(request,response,"Process Delete failed !!!");
//	            }
	        }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
		if (request.getRequestURI().equals(request.getContextPath() + "/admin/course/add")) {
            String courseTitle = request.getParameter("cTitle");
//        float coursePrice = Float.parseFloat(request.getParameter("cPrice"));
            float coursePrice = Float.valueOf(request.getParameter("cPrice"));
            String courseDuration = request.getParameter("cDuration");

            System.out.println(courseTitle + " " + coursePrice + " " + courseDuration);

            //create model object and insert these values in its fields
            CourseModel courseModel = new CourseModel(courseTitle, coursePrice, courseDuration);

            //send this model to dao in order to save
            if( CourseDAO.insert(courseModel) == true ) {
                //redirect to add course page
                response.sendRedirect(request.getContextPath() + "/admin/course/add");
            }
//            else
//            {
//                processRequest(request,response,"Data insertion failed");
//            }
        }
        else if (request.getRequestURI().equals(request.getContextPath()+"/admin/course/edit")){
            int id = Integer.parseInt(request.getParameter("cId"));
            String title = request.getParameter("cTitle");
            float price = Float.parseFloat(request.getParameter("cPrice"));
            String duration = request.getParameter("cDuration");

            CourseModel courseModel = new CourseModel(id,title,price,duration);

            //updating the data in Database
            if (CourseDAO.update(courseModel) == true){
                System.out.println("One row updated !!!");
                response.sendRedirect(request.getContextPath()+"/admin/course/display");
            }
//            else{
//                processRequest(request,response,"Failed to update the data !!!");
//            }
        }

	}

}

package controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 * Servlet implementation class FileUploadController
 */
@WebServlet("/admin/fileupload")

@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2, // 2mb
		maxFileSize = 1024 * 1024 * 10, // 10mb
		maxRequestSize = 1024 * 1024 * 50) // 50mb
public class FileUploadController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static final String SAVE_DIR = "uploadFiles";

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public FileUploadController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, H
	 *      <div class="card card-register mx-auto mt-5"> ttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		if (request.getRequestURI().equals(request.getContextPath() + "/admin/fileupload")) {
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("/fileupload.jsp");
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
//		doGet(request, response);

		// gets absolute path of the web application
		String appPath = request.getServletContext().getRealPath("");
		// constructs path of the directory to save uploaded file
		String savePath = appPath + File.separator + SAVE_DIR;

		// creates the save directory if it does not exists
		File fileSaveDir = new File(savePath);
		if (!fileSaveDir.exists()) {
			fileSaveDir.mkdir();
		}
		for (Part part : request.getParts()) {
			if (part.getName().equals("file")) {

				String fileName = extractFileName(part);
				// refines the fileName in case it is an absolute path
				fileName = new File(fileName).getName();
				part.write(savePath + File.separator + fileName);
			} else if (part.getName().equals("username")) {
				System.out.println(request.getParameter("username"));
				
			} else if (part.getName().equals(request.getParameter("userrole"))) {
				System.out.println(request.getParameter("userrole"));
			}
		}
		request.setAttribute("message", "Upload has been done successfully");
		request.setAttribute("location", appPath);
		request.getRequestDispatcher("/message.jsp").forward(request, response);
//		getServletContext().getRequestDispatcher("/message.jsp").forward(request, response);

	}

	private String extractFileName(Part part) {
		String contentDisp = part.getHeader("content-disposition");
		String[] items = contentDisp.split(";");
		for (String s : items) {
			if (s.trim().startsWith("filename")) {
				return s.substring(s.indexOf("=") + 2, s.length() - 1);
			}
		}
		return "";

	}

}

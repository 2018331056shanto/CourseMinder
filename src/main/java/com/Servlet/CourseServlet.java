package com.Servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import com.Dao.CourseDao;
import com.Dao.RegistrationDao;
import com.Entity.Course;
import com.Entity.Registration;

/**
 * Servlet implementation class CourseServlet
 */
public class CourseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CourseServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		RegistrationDao registrationDao=new RegistrationDao();
		CourseDao courseDao=new CourseDao();
		try {
			
			Map<Course,Long> registrations=registrationDao.getRegistration();
			List<Course> courses=courseDao.getCourses();
			System.out.println(registrations);
			request.setAttribute("courses", courses);
			request.setAttribute("map", registrations);
			RequestDispatcher view =request.getRequestDispatcher("/pages/AdminCourse.jsp");
			view.forward(request, response);

			
		}
		catch(Exception e)
		{
			
			e.printStackTrace();
			response.sendRedirect(request.getContextPath()+"/in/admin");
		}
		
//		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String course=request.getParameter("course");
		String courseId=request.getParameter("courseid");
		System.out.println(course);
		CourseDao courseDao=new CourseDao();
		courseDao.saveCourse(course,courseId);
		
		doGet(request, response);
	}

}

package com.Servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import com.Dao.CourseDao;
import com.Dao.RegistrationDao;
import com.Entity.Course;
import com.Entity.Student;

/**
 * Servlet implementation class TeacherStudentServlet
 */
public class TeacherStudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TeacherStudentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String[] url=request.getRequestURI().split("/");
		String courseId=url[url.length-1];
		RegistrationDao registrationDao=new RegistrationDao();
		CourseDao courseDao=new CourseDao();
		
		
		try {
			List<Student>students=registrationDao.getRegisterStudentsToACourse(courseId);
			
			Course course=courseDao.getCourseById(courseId);
			request.setAttribute("students", students);
			request.setAttribute("noOfStudents", students.size());
			request.setAttribute("courseName", course.getName());
			RequestDispatcher view=request.getRequestDispatcher("/pages/TeacherStudentPage.jsp");
			view.forward(request, response);
		} catch (Exception e) {
			
			e.printStackTrace();
			// TODO: handle exception
		}
//		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

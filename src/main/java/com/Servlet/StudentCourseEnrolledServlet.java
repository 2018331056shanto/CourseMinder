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
import com.Entity.Teacher;

/**
 * Servlet implementation class StudentCourseEnrolledServlet
 */
public class StudentCourseEnrolledServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentCourseEnrolledServlet() {
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
		String[] url=request.getRequestURI().split("/");
		
		String id=url[url.length-1];
		System.out.println(id);
		try {
			
			List<Student> students=registrationDao.getRegisterStudentsToACourse(id);
			Course course=courseDao.getCourseById(id);
			
			Teacher teacher=courseDao.getCourseTeacher(id);
		
			request.setAttribute("students", students.size());
			request.setAttribute("teacher", teacher.getName());
			request.setAttribute("deptname", teacher.getDepartment().getName().toUpperCase());
			request.setAttribute("courseName",course.getName());
			RequestDispatcher view=request.getRequestDispatcher("/pages/StudentCourse.jsp");
			view.forward(request, response);
			
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

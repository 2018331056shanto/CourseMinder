package com.Servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

import com.Dao.CourseDao;
import com.Dao.RegistrationDao;
import com.Dao.StudentDao;
import com.Entity.Course;
import com.Entity.Registration;
import com.Entity.Student;
import com.Entity.Teacher;
import com.Entity.User;

/**
 * Servlet implementation class StudentAddToCourseServlet
 */
public class StudentAddToCourseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentAddToCourseServlet() {
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
//		DepartmentDao departmentDao=new DepartmentDao();
		String[] url=request.getRequestURI().split("/");
		
		String id=url[url.length-1];
		System.out.println(id);
		try {
			
			List<Student> students=registrationDao.getRegisterStudentsToACourse(id);
			Course course=courseDao.getCourseById(id);
			
			Teacher teacher=courseDao.getCourseTeacher(id);
//		System.out.println("teacher "teacher);
//			String departmentName=departmentDao.getDeptName(teacher.getDepartment());
			request.setAttribute("courseid",id);
			request.setAttribute("students", students.size());
			request.setAttribute("courseName",course.getName());
			if(teacher!=null) {
				request.setAttribute("deptname", teacher.getDepartment().getName().toUpperCase());
				request.setAttribute("teacher", teacher.getName());

				
			} else
				request.setAttribute("teacher", "No Teacher Assigned");
			
			RequestDispatcher view=request.getRequestDispatcher("/pages/StudentAddToCourse.jsp");
			view.forward(request, response);
			
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		
//		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String[] url=request.getRequestURI().split("/");
		
		String id=url[url.length-1];
		
		
		HttpSession session=request.getSession();
		
		User user=(User)session.getAttribute("loggedinuser");
		StudentDao studentDao=new StudentDao();
		CourseDao courseDao=new CourseDao();
		RegistrationDao registrationDao=new RegistrationDao();
		try {
			
			Student student=studentDao.getStudentById(user.getId());
			Course course=courseDao.getCourseById(id);
			
			UUID uuid=UUID.randomUUID();
			Registration registration=new Registration(uuid.toString(),student,course);
			registrationDao.registerStudentToaCourse(registration);
			
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		
		response.sendRedirect(request.getContextPath()+"/in/student");
	}

}

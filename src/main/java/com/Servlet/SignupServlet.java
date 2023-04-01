package com.Servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.UUID;

import com.Dao.DepartmentDao;
import com.Dao.StudentDao;
import com.Dao.TeacherDao;
import com.Dao.UserDao;
import com.Entity.Department;
import com.Entity.Student;
import com.Entity.Teacher;
import com.Entity.User;
import com.Utils.EncoderDecoder;

/**
 * Servlet implementation class SignupServlet
 * 
 */
public class SignupServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SignupServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		RequestDispatcher view=request.getRequestDispatcher("/pages/Signup.jsp");
		view.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String name=request.getParameter("name");
		String userName=request.getParameter("email");
		String department=request.getParameter("department");
		String type=request.getParameter("type");
		String password=request.getParameter("password");
		String confPassword=request.getParameter("confpassword");
	
		if(password==confPassword)
		{
		
//			System.out.println(request.getContextPath());
			response.sendRedirect(request.getContextPath()+"/signup");

		}
		else
		{
			EncoderDecoder encoderDecoder=new EncoderDecoder();
			String hashPass=encoderDecoder.stringEncoder(password);
			UUID uuid=UUID.randomUUID();
			User user=new User(uuid.toString(),userName,hashPass,type);
			
			UserDao userDao=new UserDao();
			
			try {
				userDao.saveUser(user);
				UUID uuid2=UUID.randomUUID();
				
				Department department2=new Department(uuid2.toString(),department);
				
				DepartmentDao departmentDao=new DepartmentDao();
				departmentDao.saveDepartment(department2);
				System.out.println(type);
				if(type.toString()=="student") {
					
					UUID uuid3= UUID.randomUUID();
					Student student=new Student(uuid3.toString(),name,department2);
					StudentDao studentDao=new StudentDao();
					studentDao.saveStudent(student);
				}
				else
				{
					UUID uuid3=UUID.randomUUID();
					Teacher teacher=new Teacher(uuid3.toString(),name,department2);
					TeacherDao teacherDao=new TeacherDao();
					teacherDao.saveTeacher(teacher);
				}
				System.out.println("Everything is done");

			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			
			
		}


		doGet(request, response);
	}

}

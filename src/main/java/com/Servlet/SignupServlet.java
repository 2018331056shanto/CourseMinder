package com.Servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.UUID;

import javax.persistence.PersistenceException;

import org.hibernate.exception.ConstraintViolationException;

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
		String department=request.getParameter("department").toUpperCase();
		String type=request.getParameter("type");
		String password=request.getParameter("password");
		String confPassword=request.getParameter("confpassword");

		if(!password.equals(confPassword))
		{
		
			request.setAttribute("mismatch", "Password Did not match");
			
			doGet(request,response);

		}
		else
		{
			EncoderDecoder encoderDecoder=new EncoderDecoder();
			
			String hashPass=encoderDecoder.stringEncoder(password);
			
			UUID uuid=UUID.randomUUID();
			
			
			UserDao userDao=new UserDao();
			
			try {
				
				UUID uuid2=UUID.randomUUID();
				
				Department department2=new Department(uuid2.toString(),department);
				
				DepartmentDao departmentDao=new DepartmentDao();
				
				
				if(type.equals("student")) {
					
					String id=request.getParameter("id");
					
					User user=new User(id,userName,hashPass,type);
					try {
						userDao.saveUser(user);
						
						departmentDao.saveDepartment(department2);

						Student student=new Student(id,name,department2,user);
						
						StudentDao studentDao=new StudentDao();
						
						studentDao.saveStudent(student);
						doGet(request, response);
						
					}
					catch (Exception e) {
						if (e.getCause() instanceof ConstraintViolationException) {
					        ConstraintViolationException cve = (ConstraintViolationException) e.getCause();
					        String errorMessage = cve.getSQLException().getMessage();
					       
					        String newError=errorMessage.substring(0, errorMessage.indexOf("for"));
//					        System.out.println(newError);
					        request.setAttribute("mismatch", newError);
					        doGet(request, response);
					    } 
					}
				
				}
				else
				{
					User user=new User(uuid.toString(),userName,hashPass,type);
					try {
						userDao.saveUser(user);
						departmentDao.saveDepartment(department2);

						Teacher teacher=new Teacher(uuid.toString(),name,department2,user);
						
						TeacherDao teacherDao=new TeacherDao();
						
						teacherDao.saveTeacher(teacher);
						doGet(request, response);

					}
					catch (Exception e) {
						if (e.getCause() instanceof ConstraintViolationException) {
					        ConstraintViolationException cve = (ConstraintViolationException) e.getCause();
					        String errorMessage = cve.getSQLException().getMessage();
					       
					        String newError=errorMessage.substring(0, errorMessage.indexOf("for"));
					        request.setAttribute("mismatch", newError);
					        doGet(request, response);
					    } 
					}
					
				}


			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			
			
		}


//		doGet(request, response);
	}

}

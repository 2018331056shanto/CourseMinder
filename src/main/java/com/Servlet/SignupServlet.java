package com.Servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import com.Dao.UserDao;
import com.Entity.User;
import com.Entity.User.UserType;

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
		// TODO Auto-generated method stub
		System.out.println("kemon acho ");
		User user=new User();
		
		user.setUsername("Shanto");
		user.setPassword("hlahd");
		user.setUserType(UserType.STUDENT);
		UserDao userDao=new UserDao();
		userDao.saveUser(user);
//		User user1=new User("13","Saiful",22);
//		userDao.saveUser(user1);
//		List<User>users=userDao.getUsers();
		System.out.println("fuck all of you");

//		users.forEach(x->System.out.println(x.getName()));
		response.getWriter().append("<h1>Hello World</h1>").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
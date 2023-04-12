package com.Servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import org.hibernate.exception.ConstraintViolationException;

import com.Dao.UserDao;
import com.Entity.User;
import com.Utils.EncoderDecoder;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher view=request.getRequestDispatcher("/pages/Login.jsp");
		view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession httpSession=request.getSession();
		
		String email=request.getParameter("email");
		String password=request.getParameter("password");
		UserDao userDao=new UserDao();
		
		try {
			
				User user=userDao.getUser(email);
//				System.out.println(user.getUsername());
				EncoderDecoder decoder=new EncoderDecoder();
				
				boolean match=decoder.stringDecoder(password, user.getPassword());
				if(match)
				{
					if(user.getType().equals("student"))
					{
						httpSession.setAttribute("loggedinuser", user);
						response.sendRedirect(request.getContextPath()+"/in/student");
						
					}
					else if(user.getType().equals("teacher")) {
						httpSession.setAttribute("loggedinuser", user);

						response.sendRedirect(request.getContextPath()+"/in/teacher");

					}
					else
					{
						httpSession.setAttribute("loggedinuser", user);

						response.sendRedirect(request.getContextPath()+"/in/admin");

					}
				}
				else
				{
					request.setAttribute("mismatch", "Incorrect Password");
					doGet(request, response);
				}
//				doGet(request, response);
			
		}
		catch (Exception e) {

			System.out.println(e.getMessage());

				request.setAttribute("mismatch", "User Not Found!!!");
		        doGet(request, response);
	    
		}

	}

}

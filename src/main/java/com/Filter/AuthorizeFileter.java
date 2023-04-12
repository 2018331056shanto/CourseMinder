package com.Filter;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import com.Entity.User;

/**
 * Servlet Filter implementation class AuthorizeFileter
 */
@WebFilter("/in/*")
public class AuthorizeFileter extends HttpFilter implements Filter {
       
    /**
     * @see HttpFilter#HttpFilter()
     */
    public AuthorizeFileter() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here
		HttpServletRequest request2=(HttpServletRequest)request;
		HttpServletResponse response2=(HttpServletResponse)response;
		String [] url=request2.getRequestURI().split("/");
		
//		System.out.println(url);
//		for (String string : url) {
//			System.out.println(string);
//		}
//		System.out.println("i am in filter");
		HttpSession session=request2.getSession(false);
//		System.out.println(session);
		if(session==null||session.getAttribute("loggedinuser")==null)
		{
			response2.sendRedirect(request2.getContextPath()+"/login");
		}
		else
		{
			
			User user=(User)session.getAttribute("loggedinuser");
			System.out.println(url[3]);
			if(user.getType().equals(url[3]))
			{
				chain.doFilter(request2, response2);

			}
			
			else {
			 
				
				response2.sendRedirect(request2.getContextPath()+"/login");

			}

			
		}
		// pass the request along the filter chain
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}

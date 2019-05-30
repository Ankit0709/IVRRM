package services;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;

import beans.User;

@WebServlet("/registerDetails")
public class RegisterDetails extends HttpServlet
{  static Session session=null;
	@Override
	public void init() throws ServletException 
	{   
		 session=HibernateSessionProvider.getSession();
	}
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) 
			throws ServletException, IOException
	{
		
	 String name=req.getParameter("name");
	 int m=1010;
		String user_id="CUS"+name.substring(0,3)+(++m);
	 String email=req.getParameter("email");
	 String mobile=req.getParameter("mobile");
	 String password=req.getParameter("password");
	 User user=new User(user_id,email,name,password,mobile);
	 session.save(user);
	 session.beginTransaction().commit();
	 session.getSessionFactory().close();
		session.close();
	 res.sendRedirect("login.jsp");
	 
	
	}

		

}

package com.hms.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.connector.Request;

//import com.hms.bo.LoginBO;
import com.hms.vo.LoginVO;
import com.sun.jndi.url.ldaps.ldapsURLContextFactory;
import com.hms.vo.LoginVO;

/**
 * Servlet implementation class LoginController
 */
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	//Logger LOG=Logger.getLogger(LoggerInitializer.class);
	
	LoginVO lvo= new LoginVO();
	
	public final String UName="admin";
	public final String PWd="admin";
    																			
    public LoginController() {
        super();
        // TODO Auto-generated constructor stub
    }
                                                                                                        
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub                                      
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		lvo.setAdminName(request.getParameter("UserName"));
		lvo.setPassword(request.getParameter("Password"));
	if(lvo.getAdminName().equals(UName) && lvo.getPassword().equals(PWd))
	{
		//LOG.info("The login details have been validated.");
		response.sendRedirect("LoginSuccess.jsp");
		//LOG.info("The control has been redirected to LoginSuccess.jsp.");
	}
	else
	{
		//LOG.info("The login details are invalid.");
		response.sendRedirect("Login.jsp");
		//LOG.info("The control has been redirected back to Login.jsp.");
	}
              
	}

}

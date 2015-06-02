package com.hms.controller;



import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.hms.bo.PatientBO;
import com.hms.vo.PatientVo;
import com.hms.vo.PatienterrorVO;

public class PatientCont extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
	public static final Logger LOG = Logger.getLogger("PatientCon");
	
	PatientVo patient=new PatientVo();
	PatientBO bo=new PatientBO();
	
	
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		LOG.info("patient controller entered");
		
		LOG.info("value object values set");
		patient.setFname(request.getParameter("fname"));
		patient.setLname(request.getParameter("lname"));
		patient.setDob(request.getParameter("dob"));
		patient.setEmail(request.getParameter("email"));
		patient.setPno(request.getParameter("pno"));
		patient.setState(request.getParameter("state"));
		patient.setPlan(request.getParameter("plan"));
		
		PatienterrorVO paterror=new PatienterrorVO();
	
			try {
				LOG.info("patient controller exited ");
				bo.verification(patient,paterror);
		        LOG.info("error messages retrieved");
		        
		        
			   
				List<String> errorlist=new ArrayList<String>(); 
			         if(paterror.first_name.length()!=0)
				      {
				        errorlist.add(paterror.first_name);
				      }
				    if(paterror.last_name.length()!=0)
				      {
				    	errorlist.add(paterror.last_name);	
				      }
				    if(paterror.date_of_birth.length()!=0)
				      {
				    	errorlist.add(paterror.date_of_birth);
				      }
				    if(paterror.phone_number.length()!=0)
				      {
				    	errorlist.add(paterror.phone_number);
				      }
				    if(paterror.email.length()!=0)
				      {
				    	errorlist.add(paterror.email);
				      }
				    if(paterror.namealreadyexist.length()!=0)
				      {
				    	errorlist.add(paterror.namealreadyexist);
				      }
				   	    
				
				    if(errorlist.size()>=1)
				   {
				    RequestDispatcher requestDispatcher = request.getRequestDispatcher("errormessages.jsp");
				    request.setAttribute("errors", errorlist);
				    requestDispatcher.forward(request, response);
				   }
				   else 
				    {
				     RequestDispatcher requestDispatcher = request.getRequestDispatcher("success.jsp");
				     requestDispatcher.forward(request, response);  
					}
				
				    
				 /*   for(String s : errorlist)
				    {
				    	System.out.println(s);
				    }
			   */
		
			
			} 
			catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			    }
            }	    
      }


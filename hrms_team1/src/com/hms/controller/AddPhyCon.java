package com.hms.controller;


import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.hms.bo.AddPhyBO;
import com.hms.vo.addphyVO;


public class AddPhyCon extends HttpServlet {
	public static final Logger LOG = Logger.getLogger("AddPhyCon");
	
    addphyVO avo=new addphyVO();   
    AddPhyBO abo=new AddPhyBO();
    
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("entered get");
		
		LOG.info("Inside - method doGet in AddPhyCon controller");
		
		avo.setPhysicianID(request.getParameter("Physician_id"));
		avo.setFirstName(request.getParameter("firstname"));
		avo.setLastName(request.getParameter("lastname"));
		avo.setDepartmentID(request.getParameter("department"));
		avo.setQualification(request.getParameter("qualification"));
		avo.setExperience(Integer.parseInt(request.getParameter("experience")));
		avo.setState(request.getParameter("State"));
		avo.setPlan(request.getParameter("Plan"));
		
		int check;
		check=abo.validate(avo);
		if(check==1)
		{
			response.sendRedirect("successphyc.html");
		}
		//else if(check==2)
		//{
		//	response.sendRedirect("Error1.html");
		//}
		else if(check==0)
		{
			response.sendRedirect("Error.html");
		}
		//else if(check==3)
		//{
		//	response.sendRedirect("Error2.html");
		//}
		//else if(check==4)
		//{
		//	response.sendRedirect("Error3.html");
		//}
		LOG.info("Exiting - method doGet in AddPhyCon controller");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}

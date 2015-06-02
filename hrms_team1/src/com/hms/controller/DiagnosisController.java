package com.hms.controller;
import com.hms.vo.*;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.hms.bo.*;
import com.log.LoggerInitializer;
/**
 * Servlet implementation class DiagnosisController
 */
public class DiagnosisController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       diagnosisBO diagbo=new diagnosisBO();
     Logger LOG=Logger.getLogger(LoggerInitializer.class);

       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DiagnosisController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		LOG.info(" entered into doPost method of diagnosisController");
		
		PrintWriter out=response.getWriter();
		
         diagnosisVO diagvo= new diagnosisVO();
         
         
         diagvo.setPatient_id(request.getParameter("patient_id"));
         
         diagvo.setDate_of_diagnosis(request.getParameter("date_of_diagnosis"));
         
         diagvo.setDiagnosisProvided(request.getParameter("diagnosisProvided"));
         
         diagvo.setFollow_up_date(request.getParameter("follow_up_date"));
         
         diagvo.setPhysician_id(request.getParameter("physician_id"));
         
         diagvo.setSymptoms(request.getParameter("symptoms"));
         
         if(request.getParameter("radio").toString().equals("yes"))
        	 diagvo.setFollowup_required("yes");
         else
        	 diagvo.setFollowup_required("no");
         
         
         
         
         
		
		
	/*	String patient_id = request.getParameter("patient_id");
		
		String symptoms= request.getParameter("symptoms");
		
	String	diagnosisProvided= request.getParameter("diagnosisProvided");
	
	String  physician_id= request.getParameter("physician_id");
	
	String date_of_diagnosis= request.getParameter("date_of_diagnosis");
	
	String follow_up_date= request.getParameter("follow_up_date");
	
		*/
		
		
		
	
	
		if(diagbo.checkPatient(diagvo))
		{
			
		//	RequestDispatcher rd=request.getRequestDispatcher("billingDetails.jsp");
			
		//	rd.include(request,response);
			
			HttpSession session = request.getSession();
			
			session.setAttribute("diagvo",diagvo);
			
		//	session.setAttribute("pid",patient_id);
			
			response.sendRedirect("billingDetails.jsp");
			
			
		}
		
		else
		{  
			String errmsg="patient not present";
			
	            response.sendRedirect("diagnosisDetails.jsp?errormsg=" + errmsg  + "");
			
			//out.print("diagnosiscontroller");
			
			
		}
		
		
		LOG.info(" exiting from doPost method of diagnosisController");
	}

}

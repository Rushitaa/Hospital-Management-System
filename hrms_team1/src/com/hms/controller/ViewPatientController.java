package com.hms.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hms.bo.ViewPatientBO;
import com.hms.vo.ViewPatientVO;


public class ViewPatientController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	ViewPatientBO vbo=new ViewPatientBO();
	 // Logger LOG=Logger.getLogger(LoggerInitializer.class);
	ViewPatientVO vpvo=new ViewPatientVO();
	
	
    public ViewPatientController() {
  
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//Log.info(" Entered into dopost method of ViewPatientController class");
		
		
		
		
		
		
		if(request.getParameter("PatientID")!=null)
		vpvo.setPatient_id(request.getParameter("PatientID"));
		
		if(request.getParameter("FirstName")!=null)
		vpvo.setFirst_name(request.getParameter("FirstName"));
		
		if(request.getParameter("LastName")!=null)
		vpvo.setLast_name(request.getParameter("LastName"));
	
		//System.out.println(vpvo.getFirst_name());
		//System.out.println(vpvo.getLast_name());
		//System.out.println(vpvo.getPatient_id());
		
		
		if(request.getParameter("radio").toString().equals("inp1"))
		{
			vpvo=vbo.viewpatientbo(vpvo,1);
			
		}
		else
		{
			vpvo=vbo.viewpatientbo(vpvo,2);
		}  
		
		
		
			HttpSession httpsession=request.getSession();
			httpsession.setAttribute("ViewPatient", vpvo);
			if(vpvo.getFirst_name().equals(""))
			{
				
				String errmsg="No Match Found";
				response.sendRedirect("view_patient_login.jsp?errormsg=" + errmsg  + "");
			}
			else
			{
				response.sendRedirect("display_patient_history.jsp");
			}
		
			//Log.info(" Exited into dopost method of ViewPatientController class");
	}

}

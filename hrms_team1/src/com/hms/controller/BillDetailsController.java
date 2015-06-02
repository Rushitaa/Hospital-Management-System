package com.hms.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.hms.bo.diagnosisBO;
import com.hms.vo.diagnosisVO;
import com.log.LoggerInitializer;

/**
 * Servlet implementation class BillDetailsController
 */
public class BillDetailsController extends HttpServlet {
	private static final long serialVersionUID = 1L;
      diagnosisBO diagbo=new diagnosisBO();
      
      Logger Log=Logger.getLogger(LoggerInitializer.class);

      
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BillDetailsController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Log.info(" entered into doPost method of BillDetailsController");
      PrintWriter out=response.getWriter();
		
	//	String patient_id = request.getParameter("patient_id");
			
      
      HttpSession session=request.getSession();
      
      
    /* String patient_id = (String)session.getAttribute("pid");
      
		String bill_ammount=request.getParameter("bill_ammount");
		
		out.print(" " + patient_id + " " + bill_ammount);  */
      
      
      
      diagnosisVO diagvo=(diagnosisVO)session.getAttribute("diagvo");
      
      diagvo.setBill_ammount(Integer.parseInt(request.getParameter("bill_ammount")));
      diagvo.setMode_of_payment(request.getParameter("payment_mode"));
      
      diagvo.setCard_number(request.getParameter("card_number"));
      
      session.setAttribute("diagvo1", diagvo);
      
      
	boolean b=	diagbo.insertDiagDetails(diagvo);
		
	String successmsg="diagnosis details entered successfully";
	
    response.sendRedirect("diagnosisDetails.jsp?successmsg=" + successmsg  + "");

    Log.info(" exiting from doPost method of BillDetailsController");
		
		
		
	}

}

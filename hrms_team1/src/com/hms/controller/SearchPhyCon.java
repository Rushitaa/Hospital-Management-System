package com.hms.controller;

import java.io.IOException;
//import java.io.PrintWriter;
//import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import com.hms.vo.SearchPhyVo;
import com.hms.bo.SearchPhyBo;
import com.hms.dto.PhyDTO;
public class SearchPhyCon extends HttpServlet {
	public static final Logger LOG = Logger.getLogger("SearchPhyCon");
	SearchPhyVo svo=new SearchPhyVo();
	SearchPhyBo sbo=new SearchPhyBo();
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		LOG.info("Inside - method doGet in SearchPhyCon controller");
				
		//PrintWriter out=response.getWriter();
		svo.setState(request.getParameter("State"));
		svo.setPlan(request.getParameter("Plan"));
		svo.setDept(request.getParameter("Dept"));
		//System.out.println(svo.getDept());
		//System.out.println(svo.getPlan());
		//System.out.println(svo.getState());
		PhyDTO alcon=sbo.validate(svo);
		System.out.println(alcon.getPal().size());
		int size=alcon.getPal().size();
		if(size>0)
		{
		HttpSession ses= request.getSession();
		
		ses.setAttribute("physicianlist", alcon);
		
		response.sendRedirect("physiciandisplay.jsp");
		}
		else
			response.sendRedirect("DataNotFound.jsp");
		
		
		//out.print("<html><body>");
		//out.print("<table align="/"center"/">");
		LOG.info("Existing - method doGet in SearchPhyCon controller");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}

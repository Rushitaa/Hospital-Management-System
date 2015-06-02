package com.hms.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.log4j.Logger;

import com.hms.vo.diagnosisVO;
import com.log.LoggerInitializer;

public class DiagnosisDAO {
	 Logger Log=Logger.getLogger(LoggerInitializer.class);
	public boolean pateintExists(String patient_id)
	{
		
		Log.info(" entered into pateintExists  method of diagnosisdDAO");
	  boolean ans=false;
	  
	 // System.out.println(patient_id + "hii1");
	
	  
	  
	  try{
			Connection con=ConnManager.getConnection();
			//System.out.println("hell");
			String query="select * from patient_details";  //patient_details  from dump36
			
			Statement st=con.createStatement();
			//System.out.println(patient_id + "hii1");
			ResultSet rs= st.executeQuery(query);
			//System.out.println(patient_id + "hii2");
			int pid =Integer.parseInt(patient_id);
			//System.out.println(patient_id + "hii");
			while(rs.next())
			{   //System.out.println(rs.getInt("patient_id"));
				if(pid==rs.getInt("patient_id"))
				//if(patient_id.equals((rs.getInt("patient_details")))//patient_id
						{
				           // System.out.println(rs.getInt("patient_id"));
					         ans=true;
					         break;
					
						}
			      }
			
			
			}
			
			catch(Exception e)
			{
				
				
				//System.out.println("fail");
			}
			
			
	finally{
		
		Log.info(" exiting from pateintExists method of diagnosisdDAO");
		//System.out.println("dao ends here");
	 return ans;
	  
	}
		
		
	}
	
	public boolean diagDetailInsertion(diagnosisVO diagvo)
	{    
		Log.info(" entered into  diagDetailInsertion method of diagnosisdDAO");
		//System.out.println("insertion start" );
	
			
		/*System.out.println(diagvo.getCard_number());
		System.out.println(diagvo.getFollow_up_date());
		
		System.out.println(diagvo.getSymptoms());
		
		System.out.println(diagvo.getBill_ammount());
		System.out.println("insertion done");
		*/
	Connection con;
	try{
	 con=ConnManager.getConnection();
	
	String querydiag="select * from patient_diagnosis_team1 order by diagnosis_id";
	
	Statement s1=con.createStatement();
	
	ResultSet rs=s1.executeQuery(querydiag);
	int did=0;
	while(rs.next())
	{
		
		did=rs.getInt("diagnosis_id");
		//System.out.println(did);
		
	}
String querybill="select * from billing_team1 order by bill_id";
	
	Statement s2=con.createStatement();
	
	ResultSet rs2=s1.executeQuery(querybill);
	int bid=0;
	while(rs2.next())
	{
		
		bid=rs2.getInt("bill_id");
		//System.out.println(bid);
	}
	
	bid++;
	did++;
	
	
	
   String query1="insert into patient_diagnosis_team1 values(?,?,?,?,?,?,?)";
	PreparedStatement state=con.prepareStatement(query1);
	
	state.setInt(1,did);
	state.setString(2,diagvo.getSymptoms());
	state.setString(3,diagvo.getDiagnosisProvided());
	state.setString(4,diagvo.getPhysician_id());
	state.setString(5,diagvo.getDate_of_diagnosis());
	state.setString(6,diagvo.getFollowup_required());
	state.setString(7,diagvo.getFollow_up_date());
	
	state.executeUpdate();
	
	//System.out.println("table1");
	 String query2="insert into billing_team1 values(?,?,?,?)";
		PreparedStatement state2=con.prepareStatement(query2);
		
		state2.setInt(1,bid);
		state2.setInt(2,diagvo.getBill_ammount());
		state2.setString(3,diagvo.getCard_number());
		state2.setString(4,diagvo.getMode_of_payment());
		
		state2.executeUpdate();
		//System.out.println("table2");
		 String query3="insert into diagnosis_bill_mapping_team1 values(?,?,?)";
			PreparedStatement state3=con.prepareStatement(query3);
			
			state3.setInt(1,did);
			state3.setInt(2,bid);
			state3.setInt(3,Integer.parseInt(diagvo.getPatient_id()));
			
			state3.executeUpdate();
	
		//	System.out.println("table3");
	
	
	}
	catch(Exception e)
	{
		e.printStackTrace();
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	Log.info(" exiting from diagDetailInsertion method of diagnosisdDAO");
	
	
	 return true;
	
	}
	
	
	
	

}

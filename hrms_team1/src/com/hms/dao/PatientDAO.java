package com.hms.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.apache.log4j.Logger;
import com.hms.vo.PatientVo;



public class PatientDAO {
	public static final Logger LOG = Logger.getLogger(PatientDAO.class);
	
	public void insertion(PatientVo patient) throws SQLException{
		
	LOG.info("patient DAO class entered");
		
		Connection connection = ConnManager.getConnection();
	//System.out.println(connection);
	
		try {
			String insertquery="insert into patient_details values(id_next.nextval,?,?,?,?,?,?,?)";
			PreparedStatement statement = connection.prepareStatement(insertquery);
			statement.setString(1,patient.fname);
			statement.setString(2,patient.lname);
			statement.setString(3,patient.dob);
			statement.setString(4,patient.pno);
			statement.setString(5,patient.email);
			statement.setString(6,patient.state);
			statement.setString(7,patient.plan);
			
			if(statement.executeUpdate()>0)
			{
				LOG.info("successfuly inserted into the datebase");
			}
			
		    } 
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		   }

		}
  
   public ResultSet checkexisting() throws SQLException
   {
	  
	  Connection connection = ConnManager.getConnection();
	  
     String quer="select * from patient_details";
     PreparedStatement statement=connection.prepareStatement(quer);
	 ResultSet result=statement.executeQuery();
	 
	  /* while(result.next())
	   {
		   System.out.println(result.getString("fname")+"   "+result.getString("lname"));
	       System.out.println("from Dao");
		   System.out.println("fname"+result.getString("first_name")+"   "+"lname"+result.getString("last_name"));
	   }*/
	    
	 return result;
   }
	
}

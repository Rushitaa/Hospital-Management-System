package com.hms.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.hms.vo.ViewPatientVO;

public class ViewPatientDAO {

	 // Logger LOG=Logger.getLogger(LoggerInitializer.class);
	public ViewPatientVO viewPatHisID(ViewPatientVO vpvo)
	{
		//Log.info(" Entered into viewPatHisID method of ViewPatientDAO class");
		boolean flag=true;
		int Diagnosis_id=1,Bill_id=1,Patient_id=1;;
		try
		{
			Connection con=ConnManager.getConnection();
			
			String query="select Diagnosis_id,Bill_id,Patient_id from DIAGNOSIS_BILL_MAPPING_TEAM1 " +
					"where Patient_id=?";
			PreparedStatement state1=con.prepareStatement(query);
			state1.setInt(1,Integer.parseInt(vpvo.getPatient_id()));
			//state1.setInt(1,pid);
			ResultSet rs1=state1.executeQuery();
			while(rs1.next())
			{
				Patient_id=rs1.getInt(3);
				Diagnosis_id=rs1.getInt(1);
				Bill_id=rs1.getInt(2);				
			}
			
			
			String sq_diagnosis="select Symptoms,Diagnosis_Provided,Administered_by,Date_of_Diagnosis,Date_of_Follow_up from PATIENT_DIAGNOSIS_TEAM1 where Diagnosis_id=?";
			
			PreparedStatement state2=con.prepareStatement(sq_diagnosis);
			state2.setInt(1, Diagnosis_id);
			ResultSet rs2=state2.executeQuery();
			while(rs2.next())
			{
				vpvo.setDate_of_diagnosis(rs2.getString(4));				
				vpvo.setPhysician_id(rs2.getString(3));
				vpvo.setSymptoms(rs2.getString(1));
				vpvo.setDiagnosis(rs2.getString(2));
				vpvo.setFollow_up_date(rs2.getString(5));
				
				 String symptoms=rs2.getString(1);
				 String diagnosis=rs2.getString(2);
				 String administered_by=rs2.getString(3);
				 String date_of_diagnosis=rs2.getString(4);
				 String date_of_follow_up=rs2.getString(5);
				
			}
		
			
			String sq_billing="select Bill_Amount from BILLING_TEAM1 where Bill_id=?";
			

			PreparedStatement state3=con.prepareStatement(sq_billing);
			state3.setInt(1, Bill_id);
			ResultSet rs3=state3.executeQuery();
			while(rs3.next())
			{
				vpvo.setBill_amount(rs3.getString(1));
				String bill_amount=rs3.getString(1);
			}
			
		
			String sq_mapping2="select patient_id,first_name,last_name from patient_details " +
			"where patient_id=?";
	PreparedStatement state5=con.prepareStatement(sq_mapping2);
	
	state5.setInt(1, Patient_id);
	ResultSet rs5=state5.executeQuery();
	while(rs5.next())
	{
		vpvo.setFirst_name(rs5.getString(2));
		vpvo.setLast_name(rs5.getString(3));
		String first_name=rs5.getString(2);
		String last_name=rs5.getString(3);
		
	}			
		}
		catch(Exception e)
		{
			e.printStackTrace();
			flag=false;
			
		}
		//Log.info(" Exited from viewPatHisID method of ViewPatientDAO class");
		return vpvo;
		
	}	
	public ViewPatientVO viewPatHisName(ViewPatientVO vpvo)
	{
		//Log.info(" Entered into viewPatHisName method of ViewPatientDAO class");
		boolean flag=false;
		int Patient_id=1;
		try
		{
			Connection con=ConnManager.getConnection();
			String sq_mapping1="select patient_id,first_name,last_name from patient_details " +
			"where first_name=? and last_name=?";
	PreparedStatement state4=con.prepareStatement(sq_mapping1);
	System.out.println(vpvo.getFirst_name());
	state4.setString(1,vpvo.getFirst_name());
	state4.setString(2, vpvo.getLast_name());
	
	ResultSet rs4=state4.executeQuery();
	while(rs4.next())
	{
		Patient_id=rs4.getInt(1);
		System.out.println(Patient_id);
	}
	Integer pid1=Patient_id;
	
	vpvo.setPatient_id(pid1.toString());
	
	viewPatHisID(vpvo);
	//System.out.println("end");
			
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
			flag=false;
			
			
		}
		//Log.info(" Exited from viewPatHisName method of ViewPatientDAO class");
		return vpvo;
		
	}	
/*	public static void main(String[] args) {
		ViewPatientDAO vdao1=new ViewPatientDAO();
		
		//System.out.println(vdao1.viewPatHisID(1000));
		vdao1.viewPatHisID(new ViewPatientVO());
	}
	*/
	
}

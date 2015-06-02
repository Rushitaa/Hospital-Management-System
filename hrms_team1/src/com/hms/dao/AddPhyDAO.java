package com.hms.dao;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.apache.log4j.Logger;

import com.hms.vo.addphyVO;

public class AddPhyDAO
{
	public static final Logger LOG = Logger.getLogger("AddPhyDAO");
	int count1=-1;
	public  String s="PR000";
	public String generateId(String s,int count)
	{
		LOG.info("Inside - method generateID in AddPhyDAO controller");
	//	int id=Integer.parseInt(s.substring(2,s.length()));
		//id++;
		StringBuffer sb=new StringBuffer();
		sb.append("PR");
		count++;
		sb.append(count);
		String str=sb.toString();
		
		LOG.info("exiting - method generateID in AddPhyDAO controller");
		return str;
	}
	
	public boolean insertPHY(addphyVO avo)
	{
		boolean flag=false;
		LOG.info("Inside - method insertPHY in AddPhyDAO controller");
		
		try
		{
			Connection con=ConnManager.getConnection();
			String query1="select count(*) from physician_data";
			PreparedStatement state1=con.prepareStatement(query1);
			ResultSet rs=state1.executeQuery();
			while(rs.next())
			{
				count1=rs.getInt(1);
			}
			System.out.println(count1);
			s=generateId(s,count1);
			String query="insert into physician_data values(?,?,?,?,?,?,?,?)";
			PreparedStatement state=con.prepareStatement(query);
			state.setString(1,s);
			state.setString(2,avo.getFirstName());
			state.setString(3,avo.getLastName());
			state.setString(4,avo.getDepartmentID());
			state.setString(5,avo.getQualification());
			state.setDouble(6,avo.getExperience());
			state.setString(7,avo.getState());
			state.setString(8,avo.getPlan());
			if(state.executeUpdate()>0)
			{
				flag=true;
				System.out.println(flag);
					
			}
			
			//boolean rowc=state.execute(query);
				
				//System.out.println(rowc);*/
			
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
			System.out.println("Exception catched");
			
			
		}
		LOG.info("exiting method insertPHY in AddPhyDAO controller");
		return flag;
		
		//return avo;
	}
	
	
/*	public static void main(String[] args) {
		AddPhyDAO adao1=new AddPhyDAO();
		addphyVO avo1=new addphyVO();
		avo1.setDepartmentID("d001");
		avo1.setExperience(10);
		avo1.setFirstName("rasika");
		avo1.setLastName("guptha");
		avo1.setPhysicianID("p000007");
		avo1.setPlan("p01");
		avo1.setQualification("mbbs,frcs");
		avo1.setState("CA");
		adao1.insertPHY(avo1);	
		
		
	}*/
	
	
	
	
	
	
}

package com.hms.dao;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import org.apache.log4j.Logger;

import com.hms.vo.addphyVO;

public class CheckPhyDAO
{
	public static final Logger LOG = Logger.getLogger("CheckPhyDAO");
	public boolean checkPhysician(addphyVO avo)
	{
		LOG.info("Inside - method checkPhysician in CheckPhyDAO controller");
		
		boolean flag=true;
		try
		{
			
			Connection con=ConnManager.getConnection();
			String query="select firstname, lastname from physician_data where firstname=? and lastname=?";
			PreparedStatement state=con.prepareStatement(query);
			state.setString(1,avo.getFirstName());
			state.setString(2,avo.getLastName());
		
//			Statement state=con.createStatement();
//			ResultSet rs = state.executeQuery(query);
			
			if(state.executeQuery().next())
			{
				flag=false;
				
								
			}
			System.out.println(flag);
			
		}

	catch(Exception e)
	{
		e.printStackTrace();
	}
	LOG.info("Exiting - method checkPhysician in CheckPhyDAO controller");
	return flag;
	}
	/*public static void main(String[] args) {
		CheckPhyDAO cdao1=new CheckPhyDAO();
		addphyVO avo1=new addphyVO();
		avo1.setDepartmentID("d001");
		avo1.setExperience(10);
		avo1.setFirstName("rasika");
		avo1.setLastName("guptha");
		avo1.setPhysicianID("p001");
		avo1.setPlan("p01");
		avo1.setQualification("mbbs,frcs");
		avo1.setState("CA");
		cdao1.checkPhysician(avo1);	
	}*/
}

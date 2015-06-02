package com.hms.bo;


import org.apache.catalina.connector.Request;
import org.apache.log4j.Logger;
import com.hms.dao.AddPhyDAO;
import com.hms.dao.CheckPhyDAO;
import com.hms.vo.addphyVO;
public class AddPhyBO
{
	public static final Logger LOG = Logger.getLogger("AddPhyBO");
	AddPhyDAO adao=new AddPhyDAO();
	CheckPhyDAO cdao=new CheckPhyDAO();
	
	public int validate(addphyVO avo)
	{
		LOG.info("Inside - method validate in AddPhyBO controller");
		
		        
		boolean check;
		int x=0;
		check=cdao.checkPhysician(avo);
		if(check)
		{		
			boolean flag=adao.insertPHY(avo);
			if(flag)
			{
				x=1;
				return x;
			}
			else 
				return x;
						
		}
				
		LOG.info("Exiting - method validate in AddPhyBO controller");
		return x;
	}
}

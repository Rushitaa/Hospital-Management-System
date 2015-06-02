package com.hms.bo;

import com.hms.dao.ViewPatientDAO;
import com.hms.vo.ViewPatientVO;

public class ViewPatientBO {

	 // Logger LOG=Logger.getLogger(LoggerInitializer.class);
	ViewPatientDAO vpdao=new ViewPatientDAO();
	ViewPatientVO vpvo=new ViewPatientVO();
	

	
	public ViewPatientVO viewpatientbo(ViewPatientVO vpvo,int n)
	{
		//Log.info(" Entered into viewpatientbo method of ViewPatientBO class");

		if(n==1)
		{ 
			
			vpvo=vpdao.viewPatHisID(vpvo);
			
			
		}
		else			
		{  
			
			vpvo=vpdao.viewPatHisName(vpvo);
		}
		//Log.info(" Exited from viewpatientbo method of ViewPatientBO class");
		return vpvo;
	}
	
}

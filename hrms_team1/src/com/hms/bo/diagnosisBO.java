package com.hms.bo;

import org.apache.log4j.Logger;

import com.hms.dao.DiagnosisDAO;
import com.hms.vo.diagnosisVO;
import com.log.LoggerInitializer;

public class diagnosisBO {
	
	DiagnosisDAO diagdao= new DiagnosisDAO();
	
  Logger Log=Logger.getLogger(LoggerInitializer.class);
	
	public boolean checkPatient(diagnosisVO diagvo)
	{ 
		Log.info(" entered into checkPatient  method of diagnosisBO");
		boolean ans=false;
	
		
		ans=diagdao.pateintExists(diagvo.getPatient_id());
		
		
		Log.info(" exiting from checkPatient method of diagnosisBO");
		return ans;
		
	}
	
	public boolean insertDiagDetails(diagnosisVO diagvo)
	{
		Log.info(" entered into insertDiagDetails  method of diagnosisBO");
		boolean ans=false;
		
		ans=diagdao.diagDetailInsertion( diagvo);
		
		Log.info(" exiting from insertDiagDetails method of diagnosisBO");
		return ans;
	}
	
	
	

}

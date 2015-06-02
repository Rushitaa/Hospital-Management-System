package com.hms.bo;



import java.util.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.apache.log4j.Logger;
import com.hms.dao.PatientDAO;
import com.hms.vo.PatientVo;
import com.hms.vo.PatienterrorVO;

public class PatientBO {
	
	 boolean invaliddateformat=false;
	 boolean validnames=true;
	 boolean validemail=true;
     boolean validnumber=true;
     boolean validdob=true;
     boolean validnameinput=false;
	 boolean validfirstname=true;
	 boolean validlastname=true;
	 
	 public static final Logger LOG = Logger.getLogger(PatientBO.class);
	 
 	 PatientDAO tempdao=new PatientDAO();
 	
	public void verification(PatientVo patient,PatienterrorVO paterror) throws SQLException{
	
		
		LOG.info("Patient business object class entered");
		String fname=patient.fname;
		String lname=patient.lname;
		String email=patient.email;
		String pno=patient.pno;
		String date=patient.dob;
		
	   
	    //verification of names     
	if (!(charverify(fname)==true))
		{
		validfirstname=false;
		paterror.first_name="Error in first name.Please enter only charecters";
		
		}
	if(!(charverify(lname)==true))
	{
		validlastname=false;
	    paterror.last_name="Error in last name.Please enter only charecters";
	}
	
	if(validfirstname==true && validlastname==true)
		validnames=true;	
	else 
		validnames=false;		
	
	    //validation of email
	if(emailverify(email)==true)
	    validemail=true;
	else 
	{
		validemail=false;
	    paterror.email="Error in email address.Please enter in format of username@emailprovider.com/in";
	}
	    //validation of phone number 
	if(numberverify(pno)==true)
	    validnumber=true;
	else 
	{
		validnumber=false;
	    paterror.email="Error in phone number.Please enter only digits";
	}
	   //validation of date
	if(datevalidation(date)==true)
		validdob=true;
	else
	{
		validdob=false;
	    paterror.date_of_birth="Error in date of birth.Please enter a valid date";
	}
	
	
	//validation of names not existing in db
	  if(namenotexist(fname,lname)==true)
		validnameinput=true;	
      else 
      {
        validnameinput=false;
        paterror.namealreadyexist="Error in entry.Name already exists in the database";
      }
	  
	/*  
	System.out.println("fname"+validfirstname);
	System.out.println("lname"+validlastname);
    System.out.println("valid name  "+patient.fname+"   "+patient.lname+"  "+validnames);
	System.out.println("valid dob   "+patient.dob+"    "+validdob);
	System.out.println("valid email  "+patient.email+"   "+validemail);
	System.out.println("valid number  "+patient.pno+"   "+validnumber);
	System.out.println("valid state   "+patient.state);
	System.out.println("valid plan   "+patient.plan);
    System.out.println("valid name input  "+validnameinput);
    */

    
      if(validnames==true && validdob==true && validemail==true && validnumber==true && validnameinput==true)
      {
    	  //System.out.println("all fields valid");
    	  LOG.info("patient business object class exited");
	      tempdao.insertion(patient);
          LOG.info("patient business object class re entrered after insertion");
      }
        else 
	      //System.out.println("error in some input fields");
        	LOG.info("error in user input error messages are set");
	  }

	
	
	public boolean charverify(String str)
	{
		char[] s=str.toCharArray();
		boolean charflag=true;
		for(char c: s)
		{
		   if(!Character.isLetter(c))
			{
			charflag=false;
			}
		}
		return charflag;
	}
	
	
	
	public boolean emailverify(String str)
	{
		
		if(str.matches("^[\\w'.']*[@]{1}[\\w]*[.]{1}[\\D]*"))
			return true;
		else 
			return false;	
	}
	
	
	
	public boolean numberverify(String str)
	{
		if(str.matches("^[\\d]*"))
			return true;
		else 
		    return false;
	}
	
	
	public boolean datevalidation(String str)
	{
		boolean flag=true;
		DateFormat dateFormat=new SimpleDateFormat("MM/dd/yy");
		Date now=new Date();
		try {
			Date userdob=dateFormat.parse(str);
			if(invaliddateformat!=true)
			{
				if(userdob.after(now))
				{
					flag=false;
				}
			}
				else 
				{
					flag=true;
		        }
		}
		catch (ParseException e) {
			// TODO Auto-generated catch block
			invaliddateformat=true;	
			flag=false;
		   }
		return flag;
	}
	
	
	
	public boolean namenotexist(String fname,String lname) throws SQLException
	{   
	    boolean matchnotfound=true;
		boolean firstequal=false;
		boolean lastequal=false;
		ResultSet resultset=tempdao.checkexisting();
		
		while(resultset.next())
		{ 
	    	String first=resultset.getString("first_name");
	    	String last=resultset.getString("last_name");
	    	
	    	if(fname.equals(first))
	    	{
	    		firstequal=true;
	    	}
	    	if(lname.equals(last))
	    	{
	    		lastequal=true;	
	    	}
	    	if(firstequal==true && lastequal==true)
	    	{
	    		matchnotfound=false;
	    	}
		}
		 return matchnotfound;
	} 
	
	
	
}

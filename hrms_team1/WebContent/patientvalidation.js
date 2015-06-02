/**
 * 
 */

function patientvalidation()
{
	var a=true;
	var fields=[];
	//alert("alert");
	   var fname = document.getElementById("fname").value;
	   var lname = document.getElementById("lname").value;
  	   var dob   = document.getElementById("dob").value;
	   var email = document.getElementById("pno").value;
	   var state = document.getElementById("state").value; 
	   var plan  = document.getElementById("plan").value;
	 
	   
	   if(fname.length==0 || fname==null)
		  {
		    fields.push("first name");
		  }
	   if(lname.length==0 || lname==null)
		  {
		    fields.push(" last name ");
		  }
	   if(dob.length==0 || dob==null)
		  {
			fields.push(" date of birth ");
		  }
	   if(email.length==0 || email==null)
	      {
		    fields.push(" email ");
		  }
	   if(state.length==0 || state=="  ")
		  {
		    fields.push(" state ");
		  }
	   if(plan.length==0 || plan=="  ")
		  {
		    fields.push(" plan ");
		  }
	
	   if(fields.length>1)
		{
		alert("fields "+fields+" are empty.Please enter the empty fields");
		return false;
		}
	   else if(fields.length==1)
		{
		 alert("field"+fields+" is empty.Please enter the empty field"); 
		return false;
		}
	
}
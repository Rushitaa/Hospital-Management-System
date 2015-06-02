/**
 * 
 */
function validate()
{
	var valid=true;
	var num_chk=/^[0-9]*$/;
	var name_chk=/^[A-Za-z]*$/;
	var alphnum_chk=/^[A-Za-z0-9]*$/;
	
	
  var pid=	diagnosis_details_form.patient_id.value;
 var symptom=	diagnosis_details_form.symptoms.value;
var diag_provided=	diagnosis_details_form.diagnosisProvided.value;
var date_diag=	diagnosis_details_form.date_of_diagnosis.value;
var date_follow=	diagnosis_details_form.follow_up_date.value;
	
	
	//radio
	
	
	if(pid==0)
	{
		alert("patient is empty");
		valid=false;
	}
	if(symptom==0)
	{
		alert("symptom is empty");
		valid=false;
	
	}
	if( diag_provided==0)
	{
		alert("diagnosis is empty");
		valid=false;
	
	}
	if(date_diag==0)
	{
		alert(" date of diagnosis provided is empty");
		valid=false;
	
	}
	if(date_follow==0 &&   diagnosis_details_form.getElementById("rdone").checked)
	{
		alert(" follow up date is empty");
		valid=false;
	
	}
	
	if(!alphnum_chk.test(symptom))
	{
		alert(" symptom should contain alphanumeric field only");
		valid=false;
	
		
	}
	if(!alphnum_chk.test(symptom))
	{
		alert(" symptom should contain alphanumeric field only");
		valid=false;
	
		
	}
	
	
	var validformat=/^\d{2}-\d{2}\-\d{4}$/ //Basic check for format validity
		
	
		if (!validformat.test(date_diag))
		{alert("Invalid Date Format for date of diagnosis ..insert in dd-mm-yyyy format");
		
		valid=false;
		}
	
		else{
			
			var day=date_diag.split("-")[0];
			var month=date_diag.split("-")[1];
			var year=date_diag.split("-")[2];

			
			
			var x=new Date();
			 x.setFullYear(year,month-1,day);
			var today = new Date();

			 if (x>today)
			   {
			   alert("date of diagnosis should come before present day");
			   valid=false;
			   
			   }
			
			}

	if (!validformat.test(date_follow))
	{alert("Invalid Date Format for follow up date ..insert in dd-mm-yyyy format");
	
	valid=false;
	}
	
	else
		{
		var day=date_follow.split("-")[0];
		var month=date_follow.split("-")[1];
		var year=date_follow.split("-")[2];

		
		
		var x=new Date();
		 x.setFullYear(year,month-1,day);
		var today = new Date();

		 if (x<today)
		   {
		   alert("follow up date should come after present day");
		   valid=false;
		   }
		
		
		
		}
		
	
	

	
	return valid;
}
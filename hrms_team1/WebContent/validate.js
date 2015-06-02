/**
 * 
 */
function validate()
{
	
	var valid=true;
	var num_chk=/^[0-9]*$/;
	var name_chk=/^[A-Za-z]*$/;
	var space_chk=/^[A-Za-z\s]*$/;
		
	var fir_nam=physician_form.firstname.value;
	var las_nam=physician_form.lastname.value;
	var exp=physician_form.experience.value;
	var qualification=physician_form.qualification.value;
	
	if((fir_nam==0))
		{
		alert("FirstName should be given");
		valid=false;
		} 
	if(las_nam==0)
			{
			alert("LastName should be given");
			valid=false;
			}
	if(exp==0)
		{
		alert("experience should be given");
		valid=false;
		}
	if(qualification==0)
		{
		alert("qualification  should be given");
		valid=false;
		}
		if(!num_chk.test(exp))
		{
			alert("EXPERIENCE should only be numeric");
			valid=false;
		}
	if(!name_chk.test(fir_nam))
		{
			alert("First Name should have only alphabets");
			valid=false;
		}
	if(!name_chk.test(las_nam))
	{
		alert("Last Name should have only alphabets");
		valid=false;
	}
	if(!space_chk.test(qualification))
		{
		alert("qualifications should have only alphabets and white spaces");
		valid=false;
		}
	
	return valid;
}
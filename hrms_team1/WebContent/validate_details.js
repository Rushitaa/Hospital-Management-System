/**
 * 
 */
function validate()
{
	var valid=true;
	var num_chk=/^[0-9]*$/;
	var name_chk=/^[A-Za-z]*$/;
	
	var pat_id=patient_form.PatientID.value;
	var fir_nam=patient_form.FirstName.value;
	var las_nam=patient_form.LastName.value;
	
	if((pat_id)==0 && (fir_nam)==0 && (las_nam)==0)
		{
			alert("Either Patient Id or FirstName and LastName should be given");
			valid=false;
		}
	if(!num_chk.test(pat_id))
		{
			alert("Patient ID should only be numeric");
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
	return valid;
}
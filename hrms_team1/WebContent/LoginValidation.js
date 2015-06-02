/**
 * 
 */

function loginValidate()
{
	var valid=true;
	
	var uname=loginform.UserName.value;
	var pwd=loginform.Password.value;

	var ck_name = /^[A-Za-z0-9 ]*$/;
	var uname=loginform.UserName.value;
	 
	
	if (!ck_name.test(uname) && uname.length!=0)
		{
			alert("The UserName must contain only alphabets.");
			valid=false;
		 }
	if (!ck_name.test(pwd) && pwd.length!=0)
	{
		alert("The Password must contain only alphabets.");
		valid=false;
	 }
	
	 
	if(loginform.UserName.value.length==0 && loginform.Password.value.length!=0)
		{
			alert("Please Enter The UserName.");
			valid=false;
		}
	if(loginform.Password.value.length==0 && loginform.UserName.value.length!=0)
		{
			
			alert("Please Enter the Password.");
			valid=false;
		}
	if(loginform.Password.value.length==0 && loginform.UserName.value.length==0)
		{
		
			alert("The fields have been left empty.Please Enter the UserName and Password.");
			valid=false;
		}
	
	return valid;
}
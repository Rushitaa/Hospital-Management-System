/**
 * 
 */

function validate()
{
	var valid=true;
	var num_chk=/^[0-9]*$/;
	var name_chk=/^[A-Za-z]*$/;
	var alphnum_chk=/^[A-Za-z0-9]*$/;
	
	
  var bill_ammount=	billing_details_form.bill_ammount.value;
 var card_number=	billing_details_form.card_number.value;
 var payment_mode=billing_details_form.payment_mode.value;
 
 
 if(bill_ammount==0)
	 {
	 alert("bill_ammount is empty");
		valid=false;
	 }
 
 if(card_number==0 && payment_mode=="card" )
 {
 alert("card_number is empty");
	valid=false;
 }

 
 if(!num_chk.test(bill_ammount))
 {
 alert("bill_ammount should be number");
	valid=false;
 }
 
 
 return valid;
 
}
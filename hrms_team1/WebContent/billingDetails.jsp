<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript" src="http://localhost:8080/hrms_team1/billDetailValid.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form name="billing_details_form" action="BillDetailsController" method="post" onsubmit="return validate();">
<a href="LoginSuccess.jsp"><h3>HOME</h3></a>
<center>

<h1>Add Billing Details</h1>

<table>
<tr>
<td>
Bill Ammount:
</td>
<td>
<input type="text"  name="bill_ammount" >
</td>

<tr>
<td>
payment_mode:
</td>
<td>
<select name="payment_mode">
   <option value="card">card</option>
   <option value="cash">cash</option>
   
   </select>
</td>
</tr>







</tr>
<tr>
<td>
Card Number:
</td>
<td>
<input type="text"  name="card_number" >
</td>
</tr>
</table>

<input type="submit" value="submit">
</center>

</body>
</html>
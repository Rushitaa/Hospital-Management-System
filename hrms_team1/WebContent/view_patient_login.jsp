<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script type="text/javascript" src="http://localhost:2821/hms_team1/validate_details.js"></script>
<title></title>

<body>
<a href="LoginSuccess.jsp"><h3>HOME</h3></a>

<h2 align="center">VIEW PATIENT HISTORY</h2>
<form name="patient_form" action="ViewPatientController" method="post" onsubmit="return validate();">

<table align="Center">


<tr><td><input type="radio" name="radio" value="inp1"></td><td> Patient ID</td><td><input type="text" name="PatientID"></td></tr>
<tr><td></td><td>Patient First Name</td><td><input type="text" name="FirstName"></td></tr>
<tr><td><input type="radio" name="radio" value="inp2"></td><td></td><td></td></tr>

<tr><td></td><td>Patient Last Name</td><td><input type="text" name="LastName"></td></tr>

<tr><td></td><td><input type="submit" value="Search"></td>
<td><input type="reset" value="Reset"></td></tr>
</table>

 <% 
    if(request.getParameter("errormsg")!=null)
    {
    	%>
    	
    	
    	<script type="text/javascript">
    	alert("No Match Found");
            </script>
    	
    	
    	
    	<%
    	
    	
    }

 %>
</form>
</body>
</html>
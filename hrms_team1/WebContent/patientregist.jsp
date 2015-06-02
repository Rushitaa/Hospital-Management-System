<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />





<script type="text/javascript" src="/hrms_team1/patientvalidation.js"></script>


<title >Patient registration</title>
</head>
<body>
<h2 align=center>Patient Registration</h2>


<form name="inputform" action="PatientCont" method="post" onsubmit="return patientvalidation();">

<a href="LoginSuccess.jsp"><h3>HOME</h3></a>

<table align=center>
  <tr>
   <td>First Name</td><td><input type="text" name="fname" id="fname" /></td>
  </tr>
  <tr>
   <td>Last Name</td><td><input type="text" name="lname" id="lname" /></td>
 </tr>
 <tr>
   <td>Date of Birth</td><td><input type="text" name="dob" id="dob" /></td>
 </tr>
 <tr>
   <td>Email Id</td><td><input type="text" name="email" id="email" /></td>
 </tr>
 <tr>
   <td>Phone Number</td><td><input type="text" name="pno" id="pno" /></td>
 </tr>
 <tr>
   <td>State</td>
   <td><select name=state id="state">
   <option value=""> </option>
   <option value="AL">Alabama</option>
   <option value="AK">Alaska</option>
   <option value="AZ">Arizona</option>
   <option value="AR">Arkansas</option>
   <option value="CA">California</option>
   <option value="CO">Colorado</option>
   <option value="CT">Conneticut</option>
   <option value="DE">Delaware</option>
   <option value="GA">Georgia</option>
   </select></td>
 </tr>
 <tr>
   <td>Plan</td>
   <td><select name=plan id="plan">
   <option value="  "> </option>
   <option value="P001">Plan A</option>
   <option value="P002">Plan B</option>
   <option value="P003">Plan C</option>
   <option value="P004">Plan D</option>
   <option value="P005">Plan E</option>
   <option value="P006">Plan F</option>
   </select></td>
 </tr>
 <tr><td><input type="submit" value="Register"/></td>
 <td><input type="reset" value="Reset"/></td></tr>
</table>
</form>
</body>
</html>
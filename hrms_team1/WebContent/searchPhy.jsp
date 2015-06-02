<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Physician Search</title>
</head>
<body>
<a href="LoginSuccess.jsp"><h3>HOME</h3></a>
<form action="SearchCon" method="get">
<h1>Search Physician</h1>
<table align="center">
<tr>
<td>Enter State</td>
<td><select name="State">
	<option value="AL">AL</option>
	<option value="AK">AK</option>
	<option value="AZ">AZ</option>
	<option value="AR">AR</option>
	<option value="CA">CA</option>
	<option value="CO">CO</option>
	<option value="CT">CT</option>
	<option value="GA">GA</option>
	<option value="DE">DE</option>	
	
	</select></td>
</tr>
<tr>
<td> Enter Plan</td>
<td>
<select name="Plan">
   <option value="Plan A">Plan A</option>
   <option value="Plan B">Plan B</option>
   <option value="Plan C">Plan C</option>
   <option value="Plan D">Plan D</option>
   <option value="Plan E">Plan E</option>
   <option value="Plan F">Plan F</option>
   </select>
</td>
</tr>
<tr> 
<td>Enter Department</td>
<td> 
<select name="Dept">
   <option value="D001">D001</option>
   <option value="D002">D002</option>
   <option value="D003">D003</option>
   </select>
   </td>
   </tr>
   <tr>
   <td><input type="submit" value="Search"></td>
   <td><input type="reset" value="Reset"></td>   
   </tr>
</table>



</form>
</body>
</html>


<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script type="text/javascript" src="http://localhost:8080/hrms_team1/diagDetailValid.js"></script>
<title>Insert title here</title>
</head>
<body>
<a href="LoginSuccess.jsp"><h3>HOME</h3></a>
<center>

<form name="diagnosis_details_form" action="DiagnosisController"   method="post" onsubmit="return validate();">
<h1>Add Patient Diagnosis</h1>

<table>
<tr>
<td>
Patient ID:
</td>
<td>
<input type="text"  name="patient_id"  value="1104" >
</td>
</tr>

<tr>
<td>
symptoms:
</td>
<td>
<input type="text"  name="symptoms" >
</td>
</tr>



<tr>
<td>
diagnosis provided:
</td>
<td>
<input type="text"  name="diagnosisProvided" >
</td>
</tr>



<tr>
<td>
physician:
</td>
<td>
<select name="physician_id">
   <option value="PR001">PR001-Chang</option>
   <option value="PR002">PR002-Lori</option>
   
   </select>
</td>
</tr>

<tr>
<td>
date of diagnosis :
</td>
<td>
<input type="text"  name="date_of_diagnosis"  value="20-09-2013">
</td>
</tr>

<tr>
<td>
follow up required
</td>
<td>
<input id="rdone" type="radio" name="radio" value="yes"/>yes
            <input id="rdtwo" type="radio" name="radio" value="no"/>no

</td>
</tr>

<tr>
<td>
follow up date :
</td>
<td>
<input type="text"  name="follow_up_date" value="20-09-2014">
</td>
</tr>

<tr>
<td>
<input type="submit"  value="submit"  >
</td>
<td>
<input type="reset" value="reset" >
</td>
</tr>





</table>

<% 
    if(request.getParameter("errormsg")!=null)
    {
    	%>
    	
    	
    	<script type="text/javascript">
    	alert("patient not present with this id");
            </script>
    	
    	
    	
    	<%
    	
    	
    }



if(request.getParameter("successmsg")!=null)
{
	%>
	
	
	<script type="text/javascript">
	alert("diagnosis details entered successfully");
        </script>
	
	
	
	<%
	
	
}

%>

</form>
</center>





</body>
</html>
<%@page import="com.hms.vo.ViewPatientVO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<h2 align="center">PATIENT HISTORY</h2>
</head>
<body>
<a href="LoginSuccess.jsp"><h3>HOME</h3></a>
<table align="center">
<tr>
<td bgcolor="silver">Patient_id</td>
<td bgcolor="silver">First_name</td>
<td bgcolor="silver">Last_name</td>
<td bgcolor="silver">Date_of_diagnosis</td>
<td bgcolor="silver">Physician_id</td>
<td bgcolor="silver">Symptoms</td>
<td bgcolor="silver">Diagnosis</td>
<td bgcolor="silver">Follow_up_date</td>
<td bgcolor="silver">Bill_amount</td>
</tr>
<%
HttpSession httpSession=request.getSession();
ViewPatientVO vpvo=(ViewPatientVO)httpSession.getAttribute("ViewPatient");

%>
<tr>
<td><%=vpvo.getPatient_id()%></td>
<td><%=vpvo.getFirst_name()%></td>
<td><%=vpvo.getLast_name()%></td>
<td><%=vpvo.getDate_of_diagnosis()%></td>
<td><%=vpvo.getPhysician_id()%></td>
<td><%=vpvo.getSymptoms()%></td>
<td><%=vpvo.getDiagnosis()%></td>
<td><%=vpvo.getFollow_up_date()%></td>
<td><%=vpvo.getBill_amount()%></td>
</tr>


</table>
</body>
</html>

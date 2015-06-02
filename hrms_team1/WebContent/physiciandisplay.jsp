<%@page import="com.hms.vo.PhyDetailVO"%>
<%@page import="com.hms.dto.PhyDTO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Physician Details</title>
</head>
<body>
<a href="LoginSuccess.jsp"><h3>HOME</h3></a>
<table align="center" bgcolor="7070DB" border="1px" cellpadding="5px" bordercolor="black">
<tr>
<th> PhyId</th>
<th> FirstName</th>
<th> LastName</th>
<th>DeptId </th>
<th>Qualification</th>
<th>Experience</th>
<th>State</th>
<th>Plan</th>
</tr>
<%

HttpSession ses= request.getSession();

PhyDTO plist=(PhyDTO)ses.getAttribute("physicianlist");
ArrayList<PhyDetailVO> al=plist.getPal();
System.out.println(al.size());


for (PhyDetailVO phyDetailVO : al)
{
%>

<tr>
<td><font color="white"> <%= phyDetailVO.getPhyId()%></td>
<td> <font color="white"><%= phyDetailVO.getFirstName() %></td>
<td> <font color="white"><%=phyDetailVO.getLastName() %></td>
<td> <font color="white"><%=phyDetailVO.getDeptId() %></td>
<td> <font color="white"><%=phyDetailVO.getQualification() %></td>
<td> <font color="white"><%=phyDetailVO.getExperience() %></td>
<td> <font color="white"><%=phyDetailVO.getState()%></td>
<td> <font color="white"><%=phyDetailVO.getPlan() %></td>
</tr>

<%}
al.clear();
%>
</table>

</body>
</html>
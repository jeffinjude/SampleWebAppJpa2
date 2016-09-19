<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Data List</title>
</head>
<body>
<table>
		<tr class="headingTr">
			<td><b>Policy Name</b></td>
			<td>&nbsp;</td>
			<td><b>Party Name</b></td>
			<td>&nbsp;</td>
			<td><b>Vehicle Name</b></td>
			<td>&nbsp;</td>
			<td><b>Address Name</b></td>
		</tr>
		<%
			List<Object[]> fetchedData = (List<Object[]>)request.getAttribute("fetchedData");
			for(Object[] data : fetchedData) {
		%>
		<tr>
			<td><%=data[0]%></td>
			<td>&nbsp;</td>
			<td><%=data[1]%></td>
			<td>&nbsp;</td>
			<td><%=data[2]%></td>
			<td>&nbsp;</td>
			<td><%=data[3]%></td>
		</tr>
		<%
		}
		%>
		
	</table>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List" %>
<%@ page import="main.java.models.Policy" %>
<%@ page import="main.java.models.Party" %>
<%@ page import="main.java.models.Vehicle" %>
<%@ page import="main.java.models.Address" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Data List</title>
</head>
<body>
	<b>Successfully persisted the data.</b>
	<br>
	<b>Policy Table:</b>
	<table>
		<tr class="headingTr">
			<td><b>POLICY_ID</b></td>
			<td>&nbsp;</td>
			<td><b>POLICY_NAME</b></td>
		</tr>
		<%
			List<Policy> fetchedPolicies = (List<Policy>)request.getAttribute("fetchedPolicies");
			if(!fetchedPolicies.isEmpty())
			{
				for(Policy data : fetchedPolicies) {
		%>
		<tr>
			<td><%=data.getId()%></td>
			<td>&nbsp;</td>
			<td><%=data.getName()%></td>
		</tr>
		<%
				}
			}
		%>
	</table>
	<br>
	<b>Party Table:</b>
	<table>
		<tr class="headingTr">
			<td><b>PARTY_ID</b></td>
			<td>&nbsp;</td>
			<td><b>PARTY_NAME</b></td>
			<td>&nbsp;</td>
			<td><b>POLICY_ID</b></td>
		</tr>
		<%
			List<Party> fetchedParties = (List<Party>)request.getAttribute("fetchedParties");
			if(!fetchedParties.isEmpty())
			{
				for(Party data : fetchedParties) {
		%>
		<tr>
			<td><%=data.getId()%></td>
			<td>&nbsp;</td>
			<td><%=data.getName()%></td>
			<td>&nbsp;</td>
			<td><%=data.getPolicy().getId()%></td>
		</tr>
		<%
				}
			}
		%>
	</table>
	<br>
	<b>Vehicle Table:</b>
	<table>
		<tr class="headingTr">
			<td><b>VEHICLE_ID</b></td>
			<td>&nbsp;</td>
			<td><b>VEHICLE_NAME</b></td>
			<td>&nbsp;</td>
			<td><b>POLICY_ID</b></td>
		</tr>
		<%
			List<Vehicle> fetchedVehicles = (List<Vehicle>)request.getAttribute("fetchedVehicles");
			if(!fetchedVehicles.isEmpty())
			{
				for(Vehicle data : fetchedVehicles) {
		%>
		<tr>
			<td><%=data.getId()%></td>
			<td>&nbsp;</td>
			<td><%=data.getVehicleName()%></td>
			<td>&nbsp;</td>
			<td><%=data.getPolicy().getId()%></td>
		</tr>
		<%
				}
			}
		%>
	</table>
	<br>
	<b>Address Table:</b>
	<table>
		<tr class="headingTr">
			<td><b>ADDRESS_ID</b></td>
			<td>&nbsp;</td>
			<td><b>CITY</b></td>
			<td>&nbsp;</td>
			<td><b>STATE</b></td>
			<td>&nbsp;</td>
			<td><b>VEHICLE_ID</b></td>
		</tr>
		<%
			List<Address> fetchedAddresses = (List<Address>)request.getAttribute("fetchedAddresses");
			if(!fetchedAddresses.isEmpty())
			{
				for(Address data : fetchedAddresses) {
		%>
		<tr>
			<td><%=data.getId()%></td>
			<td>&nbsp;</td>
			<td><%=data.getCity()%></td>
			<td>&nbsp;</td>
			<td><%=data.getState()%></td>
			<td>&nbsp;</td>
			<td><%=data.getVehicle().getId()%></td>
		</tr>
		<%
				}
			}
		%>
	</table>
	<br>
	<b>Joined Data:</b>
	<table>
		<tr class="headingTr">
			<td><b>Policy Name</b></td>
			<td>&nbsp;</td>
			<td><b>Party Name</b></td>
			<td>&nbsp;</td>
			<td><b>Vehicle Name</b></td>
			<td>&nbsp;</td>
			<td><b>City</b></td>
			<td>&nbsp;</td>
			<td><b>State</b></td>
		</tr>
		<%
			List<Object[]> fetchedData = (List<Object[]>)request.getAttribute("fetchedData");
			if(!fetchedData.isEmpty())
			{
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
			<td>&nbsp;</td>
			<td><%=data[4]%></td>
		</tr>
		<%
				}
			}
		%>
	</table>
</body>
</html>
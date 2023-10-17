<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/index.css">

 <title>Doctors Care</title>

</head>
<body>
<div class= "container">
	<span style="font-size: xxx-large;">Doctor Appointment Dashboard</span><br/>
	<span style="font-size: xx-large;">Live a Healthy Life</span> <br/>
	<span style="color: red; font-size: large">${registerError}</span><br/><br/>	
	<form:form method="post" action="/doctor/register" modelAttribute="registerUser">
	     <table class="left">
	        <tr>
	            <th colspan="4" style="text-align: left; font-weight:bold; font-size: x-large">Doctor Register </th>
	        </tr>
	        <tr>
	            <td>
	                <form:label path="userName">Name: </form:label>
	            </td>
	            <td>
	                <form:input path="userName" class="form-control text-input" />
	            </td>
	        </tr>
	        <tr>
	            <td>
	                <form:label path="email">Email: </form:label>
	            </td>
	            <td>
	                <form:input path="email" class="form-control text-input"/>
	            </td>
	        </tr>
	        <tr>
	            <td>
	                <form:label path="password">Password: </form:label>
	            </td>
	            <td>
	                <form:input path="password" type="password" class="form-control text-input"/>
	            </td>
	        </tr>
	        <tr>
	            <td>
	                <form:label path="confirmPassword" >Confirm PW: </form:label>
	            </td>
	            <td>
	                <form:input path="confirmPassword" type="password" class="form-control text-input"/>
	            </td>
	        </tr>
	        <tr>
	            <td colspan="2">
	                <p><form:button class = "submit styled-input">Register</form:button></p>
	            </td>
	        </tr>
	    </table>
	</form:form>
	</div>
	<form:form method="post" action="/patient/register" modelAttribute="registerUser">
	    <table class="right">
	        <tr>
	            <th colspan="4" style="text-align: left; font-weight:bold; font-size: x-large">Patient Register </th>
	        </tr>
	        <tr>
	            <td>
	                <form:label path="userName">Name: </form:label>
	            </td>
	            <td>
	                <form:input path="userName" class="form-control text-input"/>
	            </td>
	        </tr>
	        <tr>
	            <td>
	                <form:label path="email">Email: </form:label>
	            </td>
	            <td>
	                <form:input path="email" class="form-control text-input"/>
	            </td>
	        </tr>
	        <tr>
	            <td>
	                <form:label path="password">Password: </form:label>
	            </td>
	            <td>
	                <form:input path="password" type="password" class="form-control text-input"/>
	            </td>
	        </tr>
	        <tr>
	            <td>
	                <form:label path="confirmPassword" >Confirm PW: </form:label>
	            </td>
	            <td>
	                <form:input path="confirmPassword" type="password" class="form-control text-input"/>
	            </td>
	        </tr>
	        <tr>
	            <td colspan="2">
	                <p><form:button class = "submit styled-input">Register</form:button></p>
	            </td>
	        </tr>
	    </table>
	</form:form>
	<br/>
	<span style="color: red; font-size: large">${loginError}</span><br/>
	<form:form method="post" action="/login" modelAttribute="loginUser">
	     <table class="left">
	        <tr>
	            <th colspan="2" style="text-align: left; margin-top: 10px; font-weight:bold; font-size: x-large"> Log In </th>
	        </tr>
	        <tr>
	            <td>
	                <form:label path="email">Email: </form:label>
	            </td>
	            <td>
	                <form:input path="email" class="form-control text-input"/>
	            </td>
	        </tr>
	        <tr>
	            <td>
	                <form:label path="password" >Password: </form:label>
	            </td>
	            <td>
	                <form:input path="password" type="password" class="form-control text-input"/>
	            </td>
	        </tr>
	        <tr>
	            <td colspan="2">
	                <form:select path="type" style="background-color:lightgreen">
	                    <form:option value="Doctor" label="Doctor" />
	                    <form:option value="Patient" label="Patient"/>
	                </form:select>
	            </td>
	        </tr>
	        <tr>
	            <td colspan="2">
	                <form:button class = "submit styled-linput">LogIN</form:button>
	            </td>
	        </tr>
	    </table>
	</form:form>

</body>

<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/index.css">
    <title>Patient Dashboard</title>
</head>
<body>
<div style="position: relative;">
    <span style="color: black; font-size: xx-large; font-weight:bold; text-align: center;">Hello, ${patient.userName}</span>
    <span style="float: right; font-size: large;"> <a href="/logout"> Back to login </a> </span>
    <br/><br/>
    <span style="color: black; font-size: x-large; font-weight:bold; text-align: center;">Let's take care of your health !</span>
    <br/><br/>

   <!--  <table style="border: 3px solid black; width: 40%"> -->
    <table class = "patient">
        <tr>
            <th>
                Date
            </th>
            <th>
                Doctor
            </th>
            <th>
                Time slot
            </th>
        </tr>
        <c:forEach var="appointment" items="${appointmentList}">
            <tr>
                <td>
                    <c:out value="${appointment.createAt}" />
                </td>
                <td>
                    <c:out value="${appointment.doctorName}" />
                </td>
                <td>
                    <c:out value="${appointment.timeSlot}" />
                </td>
            </tr>
        </c:forEach>
    </table>
    <br/> <br/>
    <span style="font-size: large;"> <a href="/patient/book-appointment">Book an appointment</a> </span>
</div>
</body>

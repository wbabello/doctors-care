<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
    <title>Patient Dashboard</title>
</head>
<body>
<div style="position: relative;">
    <span style="color: black; font-size: xxx-large; font-weight:bold; text-align: center;">Hi, Patient</span>
    <span style="float: right; font-size: large;"> <a href="/logout"> Logout </a> </span>
    <br/><br/>
    <span style="color: black; font-size: xx-large; font-weight:bold; text-align: center;">Health is important</span>
    <br/><br/>

    <table style="border: 3px solid black; width: 40%">
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
    <span style="font-size: large;"> <a href="/patient/book-appointment">Book a appointment</a> </span>
</div>
</body>

<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
 <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/index.css">
 <title>Doctor's Dashboard</title>
</head>
<body>
<div style="position: relative;">
    <span style="color: black; font-size: xx-large; font-weight:bold; text-align: center;">Hi ${doctor.userName}, Your availability for:</span>
    <span style="float: right; font-size: large;"> <a href="/logout"> Logout </a> </span>
    <br/><br/>
    <span style="color: black; font-size: x-large; font-weight:bold; text-align: center;">${currentDate}</span>
    <br/><br/>

    <table style="border: 3px solid black; width: 40%">
        <tr>
            <td>
                Morning
            </td>
            <c:forEach var="availability" items="${morningAvailability}">
                <td>
                    <a href="/doctor/availability/${availability.id}" style="color: #CF5C36; text-decoration: none; font-weight:bold;">
                        <c:out value="${availability.value}" />
                    </a>
                </td>
            </c:forEach>
        </tr>

        <tr>
            <td>
                Afternoon
            </td>
            <c:forEach var="availability" items="${afternoonAvailability}">
                <td>
                    <a href="/doctor/availability/${availability.id}" style="color: #CF5C36; text-decoration: none; font-weight:bold;">
                        <c:out value="${availability.value}" />
                    </a>
                </td>
            </c:forEach>
        </tr>

        <tr>
            <td>
                Evening
            </td>
            <c:forEach var="availability" items="${eveningAvailability}">
                <td>
                    <a href="/doctor/availability/${availability.id}" style="color: #CF5C36; text-decoration: none; font-weight:bold;">
                        <c:out value="${availability.value}" />
                    </a>
                </td>
            </c:forEach>
        </tr>

    </table>
    <br/> <br/>
    <span style="font-size: large;"> <a href="/doctor/availability/new">Add Availability</a> </span>
</div>
</body>

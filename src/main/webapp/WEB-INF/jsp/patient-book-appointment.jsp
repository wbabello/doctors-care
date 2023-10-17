<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/index.css">
    <title>Patient Dashboard</title>
</head>
<body>
<div style="position: relative;">
    <span style="color: black; font-size: xx-large; font-weight:bold;">Book An Appointment</span>
    <span style="float: right; font-size: large;"> <a href="/logout"> Back to Login </a> </span>

    <form:form method="post" action="/patient/book-appointment" modelAttribute="appointment">
         <table class="left">
            <tr>
                <td>
                    <form:label path="doctorName">Doctor </form:label>
                </td>
                <td>
                    <form:select path="doctorName" class="form-control text-input">
                        <c:forEach var="dcotor" items="${doctorList}">
                            <form:option value="${dcotor}" label="${dcotor}"/>
                        </c:forEach>
                    </form:select>
                </td>
            </tr>
            <tr>
                <td>
                    <form:label path="timeSlot">Time Slot </form:label>
                </td>
                <td>
                    <form:select path="timeSlot" class="form-control text-input">
                        <c:forEach var="addAvailabilities" items="${addAvailabilitiesList}">
                            <form:option value="${addAvailabilities.time}" label="${addAvailabilities.time}"/>
                        </c:forEach>
                    </form:select>
                </td>
            </tr>
            <tr>
                <td>
                    <form:label path="comment">Comment </form:label>
                </td>
                <td>
                    <form:textarea path="comment" class="form-control text-input"/>
                </td>
            </tr>
            <tr>
                <td colspan="2">
                    <form:button style="margin-right: 50px" class="styled-input">Book</form:button>
                </td>
            </tr>
        </table>
    </form:form>

</div>
</body>

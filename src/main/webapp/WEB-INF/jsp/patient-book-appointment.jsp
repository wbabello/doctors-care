<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
    <title>Patient Dashboard</title>
</head>
<body>
<div style="position: relative;">
    <span style="color: black; font-size: xx-large; font-weight:bold;">Book An Appointment</span>

    <form:form method="post" action="/patient/book-appointment" modelAttribute="appointment">
        <table style="width: 40%">
            <tr>
                <td>
                    <form:label path="doctorName">Doctor </form:label>
                </td>
                <td>
                    <form:select path="doctorName">
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
                    <form:select path="timeSlot">
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
                    <form:textarea path="comment"/>
                </td>
            </tr>
            <tr>
                <td colspan="2">
                    <form:button style="margin-right: 50px">Book</form:button>
                </td>
            </tr>
        </table>
    </form:form>

</div>
</body>

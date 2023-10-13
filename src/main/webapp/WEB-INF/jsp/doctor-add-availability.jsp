<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
    <title>Doctor's Dashboard</title>
</head>
<body>
<div style="position: relative;">
    <span style="color: black; font-size: xx-large; font-weight:bold;">Add Availability</span>

    <form:form method="post" action="/doctor/availability/new" modelAttribute="addAvailability">
        <table style="width: 40%">
            <tr>
                <td>
                    <form:label path="time">Time </form:label>
                </td>
                <td>
                    <form:input path="time" />
                </td>
            </tr>
            <tr>
                <td>
                    <form:label path="period">Period </form:label>
                </td>
                <td>
                    <form:select path="period">
                        <form:option value="Morning" label="Morning"/>
                        <form:option value="Afternoon" label="Afternoon"/>
                        <form:option value="Evening" label="Evening"/>
                    </form:select>
                </td>
            </tr>
            <tr>
                <td colspan="2">
                    <form:button style="margin-right: 50px">Add</form:button>
                </td>
            </tr>
        </table>
    </form:form>

</div>
</body>

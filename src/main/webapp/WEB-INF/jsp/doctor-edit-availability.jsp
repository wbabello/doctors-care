<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
    <style>
        .cancel-button {
            padding: 12px 50px;
            border-radius: 4px;
            background: gray;
            color: white;
            box-sizing: border-box;
            cursor: pointer;
            margin-left: 30%;
            line-height: 40px;
            text-decoration: none;
        }

        .delete-button {
            padding: 12px 50px;
            border-radius: 4px;
            background: darkred;
            color: white;
            box-sizing: border-box;
            cursor: pointer;
            line-height: 40px;
            text-decoration: none;
        }
    </style>
    <title>Doctor's Dashboard</title>
</head>
<body>
<div style="position: relative;">
    <span style="color: black; font-size: xx-large; font-weight:bold;">Update Availability</span>

    <form:form method="post" action="/doctor/availability/${addAvailability.id}" modelAttribute="addAvailability">
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
                    <span><a href="/doctor/availability/${addAvailability.id}/delete" class="delete-button">Delete</a> </span>
                    <span><a href="/doctor/availability" class="cancel-button">Cancel</a> </span>
                    <form:button style="margin-right: 50px">update</form:button>
                </td>
            </tr>
        </table>
    </form:form>

</div>
</body>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<script type="text/javascript" src="../../jquery-2.1.4.js"></script>
<script type="text/javascript">

</script>

<form:form id="myForm" commandName="message" method="post" action="broadcast">
<table>
<tr><td>Message Type</td><td><form:select path="messageType" items="${messageTypes}"></form:select> </td><td></td></tr>
<tr><td>Content</td><td><form:textarea path="content"/> </td><td></td></tr>
<tr><td></td><td></td><td><input type="submit"  value="Submit"></td></tr>
</table>
</form:form>
</body>
</html>
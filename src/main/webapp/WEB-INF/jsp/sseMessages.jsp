<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<script type="text/javascript" src="../../jquery-2.1.4.js"></script>
<script type="text/javascript">
$(document).ready(function(){
	
	var source = new EventSource("register");
	source.addEventListener('spring', function (e) {
		$("#springMessages").append('<tr><td>'+e.data+'</td></tr>');
		console.log(e.data);

	});
	source.addEventListener('hibernate', function (e) {
		$("#hibernateMessages").append('<tr><td>'+e.data+'</td></tr>');
	});
	
	source.addEventListener( function (e) {
		$("#springMessages").append('<tr><td>'+e.data+'</td></tr>');
		$("#hibernateMessages").append('<tr><td>'+e.data+'</td></tr>');
	});
	
});


</script>
<table id="springMessages">
<tr><td>Spring Messages</td></tr>
</table>
<br>
<table id="hibernateMessages">
<tr><td>Hibernate Messages</td></tr>
</table>
</body>
</html>
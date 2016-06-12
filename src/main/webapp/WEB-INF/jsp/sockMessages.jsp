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
	<script type="text/javascript" src="../../sockjs.js"></script>
	<script type="text/javascript">
		var ws;
		$(document).ready(
				function() {

					ws = new SockJS("/sockregister");
					ws.onmessage = function(event) {
						$("#springMessages").append(
								'<tr><td>' + event.data + '</td></tr>');
						console.log(event.data);
					}
					ws.onopen = function() {
						console.log("ws connection established ");
					}
					ws.onclose = function(event) {
						console.log("ws connection closed");
					}

				});

		function sendMessage() {
			ws.send($("#message").val());
			$("#message").val("");
		}
	</script>
	<textarea id="message" rows="3" cols="5"></textarea>
	<button onclick="sendMessage()">Send</button>
	<table id="springMessages">
		<tr>
			<td>Spring Messages</td>
		</tr>
	</table>
	<br>
<!-- 	<table id="hibernateMessages">
		<tr>
			<td>Hibernate Messages</td>
		</tr>
	</table> -->
</body>
</html>
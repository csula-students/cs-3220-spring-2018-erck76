<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
		<html lang="en">
		<head>
			<meta charset="UTF-8">
			<title>Incremental-Game</title>
		</head>
		<header><h1><p></p>Incremental Game Framework</p></h1></header>
		<link rel="stylesheet" type="text/css" href="app.css">
		
		<body>
			<nav>
			<a href="action">Game Information</a> |
				<a href="action">Generators</a> |
					<a href="action">Events</a>
			</nav>");
		
		<form method="POST">
			<label for="eventname">Event Name</label><br>
			<input type="text" name="name" id="eventname"><br>
		
			<label for="eventDescription">Event Description</label><br>
			<textarea name="description" id="eventDescription"></textarea><br>
		
			<label for="triggerAt">Trigger at</label><br>");
			<input type="number" name="triggerAt" id="triggerAt"><br>
		
			<button>{Add|Edit}</button>
		</form>");
		
		 	<table id="tab" align="center" border="1">
			<tr>
					<th>Name</th>
						<th>Description</th> 
						<th>TriggerAt</th>
					</tr>
		
		<c:forEach items="${events}" var="event">
			<tr>
						<td>${event.getId()}</td>
						<td>${event.getName()}</td>
						<td>${event.getDescription()}</td>
						<td>${event.getTriggerAt()}</td>

						<td>
							<a href="./events/edit?id=${event.getId()}">Edit</a> | 
							<a href="./events/remove?id=${event.getId()}">Delete</a>
						</td>
					</tr>
				</c:forEach>
		</table>
		</body>
		</html>

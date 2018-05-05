<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
		<html lang="en">
		<head>
		<meta charset="UTF-8">
		<title>Incremental-Game Generator</title>
		</head>
		<header><h1><p></p>Incremental Game Framework Gen</p></h1></header>
		<link rel="stylesheet" type="text/css" href="app.css">
		
		<body>
			<nav>
				<a href="action">Game Information</a> |
				<a href="action">Generators</a> |
				<a href="action">Events</a>
			</nav>
		
		
		<main>
		<form method= "POST">
			<label for="name">Generator Name</label>
			<input type="text" id="name" name = "name">
		
			<label for="description">Generator Description</label>
			<textarea id="description" name = "description"></textarea>
		
		
			<label for="rate">Generator rate</label>
			<input type="number" id="rate" name = "rate">
		
			<label for="cost">Base cost</label>
			<input type="number" id="cost" name = "cost">
		
			<label for="unlock_at">Unlock At</label>");
			<input type="number" id="unlock_at" name = "unlock">");
		
			<button>Save</button>
		</form>
		
			<table id="tab" align="center" border="1">
		<thead>
			<tr>
				<th>Name</th>
				<th>Description</th>
				<th>Rate</th>
				<th>Cost</th>
				<th>Unlock</th>
				<th>Action</th>
				</tr>
		</thead>
		<tbody>
		
		  <c:forEach items="${generatorEntry}" var="generator">
			<tr>
				<td>${generator.getName()}</td>
                <td>${generator.getDescription()}</td>
                <td>${generator.getRate()}</td>
                <td>${generator.getBaseCost()}</td>
                <td>${generator.getUnlockAt()}</td>
			<td>
				<a href="EditGeneratorServlet?id="=${generator.getId()}">Edit</a>|
				<a href="DeleteGeneratorServlet?id="=${generator.getId()}">Delete</a>
			</tr>
			</c:forEach>
		
		</tbody>
		</table>
		</main>
		</body>
		</html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
		<html lang="en">
		<head>
			<meta charset="UTF-8">
			<title>Edit Incremental-Game Generator</title>
		</head>
		<header><h1><p></p>Incremental Game Framework Gen</p></h1></header>
		<link rel="stylesheet" type="text/css" href="app.css">
		
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
		
			<label for="unlock_at">Unlock At</label>
			<input type="number" id="unlock_at" name = "unlock">
		
		<button>Save</button>
		</form>
		
		</main>
		</body>
		</html>
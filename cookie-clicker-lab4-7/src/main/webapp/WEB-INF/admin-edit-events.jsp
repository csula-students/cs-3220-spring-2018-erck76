<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html lang="en">
		<head>
		<meta charset="UTF-8">
		<title>Incremental game framework - game information Edit</title>"
		<link rel="stylesheet" href="../app.css">
		</head>
		
		<header>
			<h1>Incremental game framework</h1>
		</header>
		
		
		<body>
		
		
		<form method='POST'>
			<h2>Edit</h2>
				<label for='name'>Name: </label>
				<input type='text'name='name' id='eventname'>
		
			<label for='eventdes'>Event Description</label><br>
			<textarea name='description' id='eventdes'></textarea>
		
				<label for='triggerAt'>Trigger At</label><br>
				<input type='number' name='triggerAt' id='trigAt'><br>
		
			<button>Submit</button>
		</form>
		
		</body>

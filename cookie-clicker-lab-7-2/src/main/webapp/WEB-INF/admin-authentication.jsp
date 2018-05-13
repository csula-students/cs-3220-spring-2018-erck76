<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
	<html lang="en">
		<head>
		<meta charset="UTF-8">
		<title>Incremental Game Login</title>
		<link rel="stylesheet" href="../app.css">
		
		</head>
		<header>
		<h1>Incremental game framework login</h1>
		</header>
		
		<main>
		<form class="card" method="POST">
			<div class="form-group">
				<label for="name">Username:</label>
				<input type="text" name = "username" id="name">
				</div>
		
		<div class="form-group">
			<label for="password">Password: </label><br>
					<input type="password" name="password" id="pins"><br>
		</div>
		
			<div class="actions">
				<input type="submit" value="Log in">
				</div>
			</form>
		</main>
		</body>
		</html>
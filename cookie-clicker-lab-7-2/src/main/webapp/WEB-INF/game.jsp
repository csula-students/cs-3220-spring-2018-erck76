<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<link rel="stylesheet" type="text/css" href="game.css">
	<title>Nightbringers</title>
	<script>
		state = ${state};
		window.defaultState = state;
	</script>
</head>
<body>
		<header><h1>{Nightbringers}</h1></header>
		<div class="vertical-menu">
				<c:forEach items="${events}" var="event">
			<p>${event.name}</p>
			</c:forEach>
			</div>
	<main>
		<button id="but">{Kill}</button>
		<p><h2 id="counter">Skulls: Start killing to gain skulls!</h2></p>
		<c:forEach var = "i" begin = "0" end = "${genIndex}">
         	<game-generator data-id="${i}"></game-generator>
      	</c:forEach>

		&emsp;

		<div class="card" var="generator">
				<div class="container"> 
					<h3><b>${generator.name}</b></h3> 
					<p>${generator.description}</p>
					<button ${generator.rate}>10 Skulls</button>
					<p><h5>${generator.baseCost}</h5></p>
				</div>
			</div>

			<div class="card2">
					<div class="container" var="generator">
							<h3><b>${generator.name}</b></h3> 
						<p>${generator.description}</p>
						<button ${generator.rate}>10 Skulls</button>
						<p><h5>${generator.baseCost}</h5></p>
					</div>
				</div>

			<div class="card3" var="generator">
					<div class="container">
						<h3><b>${generator.name}</b></h3> 
						<p>${generator.description}</p>
						<button ${generator.rate}>10 Skulls</button>
						<p><h5>${generator.baseCost}</h5></p>
					</div>
				</div>

		<footer><p><h6>&copy; Erick C. 2018</h6></p></footer>

	</main>
<script src="https://cdnjs.cloudflare.com/ajax/libs/webcomponentsjs/1.1.0/webcomponents-lite.js"></script>
<script  src = "app.bundle.js"></script>
	
</body>
</html>

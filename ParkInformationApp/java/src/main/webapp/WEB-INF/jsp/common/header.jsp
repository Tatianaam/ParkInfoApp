<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" name="viewport"
	content="width=device-width, initial-scale=1">
<meta charset="UTF-8">
<title>National Park App</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bulma@0.8.0/css/bulma.min.css">
<script defer
	src="https://use.fontawesome.com/releases/v5.3.1/js/all.js"></script>
<!--   <c:url value="/css/nationalpark.css" var="cssHref" />  
    <link rel="stylesheet" href="${cssHref}"> -->
</head>

<body style="background-color:#effaf3;">
	<header>
		<br>
		<c:url value="/" var="homePageHref" />
		<c:url value="/img/logo.png" var="logoSrc" />

		<div class="tile is-ancestor">
			<div class="tile is-parent is-1"></div>
			<div class="tile is-parent is-10">
				<article class="tile is-child box">
					<nav class="level">
						<figure class="image is-4by2 is-centered">
							<img style="width: 60% !important;" src="${logoSrc}"
								alt="Solar System Geek logo" />
						</figure>

						<div class="level-right">
							<div class="level-right buttons">
								<a class="button is-success is-light" href="${homePageHref}">Home</a>

								<a class="button is-success is-light" id="surveyLink" href="surveyInput">Survey</a>
							</div>
						</div>
					</nav>


				</article>
			</div>
			<div class="tile is-parent is-1"></div>
		</div>
	</header>
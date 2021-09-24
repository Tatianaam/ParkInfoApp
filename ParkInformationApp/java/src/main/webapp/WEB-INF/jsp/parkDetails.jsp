<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<c:import url="/WEB-INF/jsp/common/header.jsp" />

<c:url var="postURL" value="/parkDetails" />
<form method="POST" action="${postURL}">
	<br>
	<div class="tile is-ancestor ">
		<div class="tile is-parent is-1"></div>
		<div class="tile is-parent is-10">
			<div class="tile is-child box">
				<h1 class="title is-2 has-text-success has-text-centered is-italic has-text-weight-light">${park.name}</h1>
			</div>
		</div>
		<div class="tile is-parent is-1"></div>
	</div>

	<div class="tile is-ancestor ">
		<div class="tile is-parent is-1"></div>
		<div class="tile is-parent is-5">
			<article class="tile is-child box">
				<figure class="image is-4by2">
					<a href="parkDetails?parkcode=${park.parkCode}"> <c:url
							var="parkImgUrl" value="img/parks/${park.parkImgCode}.jpg" /> <img
						src="${parkImgUrl}" id = "detailSParkImg"/>
					</a>
				</figure>
			</article>
		</div>
		<div class="tile is-parent is-5">
			<article class="tile is-child box content is-medium">
				<p class="title is-4 has-text-black" id="detailsParkName">
					<c:out value="${park.name}, ${park.state }" />
				</p>

				<p class="has-text-black">
					<c:out value="${park.parkDescription }" />
				</p>
			</article>
		</div>
		<div class="tile is-parent is-1"></div>
	</div>

	<div class="tile is-ancestor ">
		<div class="tile is-parent is-1"></div>
		<div class="tile is-parent is-10">
			<div class="tile is-child box">
				<h1 class="title is-4 has-text-success has-text-centered is-italic has-text-weight-light" id="inspQuote">
					${park.inspirationalQuote} -${park.inspirationalQuoteSource}</h1>
			</div>
		</div>
		<div class="tile is-parent is-1"></div>
	</div>

	<div class="tile is-ancestor content is-medium">
		<div class="tile is-parent is-1"></div>
		<div class="tile is-parent is-10">
			<div class="tile is-child box">
				<article class="has-text-black">
					<div class="table-container">
						<table class="table is-narrow">
							<tbody>
								<tr>
									<td>State: ${park.state}</td>
									<td>Acreage: ${park.acreage}</td>
								</tr>
								<tr>
									<td>Elevation in Feet: ${park.elevationInFeet}</td>
									<td>Miles of Trail: ${park.milesOfTrail}</td>
								</tr>
								<tr>
									<td>Campsites: ${park.numberOfCampsites}</td>
									<td>Climate: ${park.climate}</td>
								</tr>
								<tr>
									<td>Year Founded: ${park.yearFounded}</td>
									<td>Annual Visitors: ${park.annualVisitorCount}</td>
								</tr>
								<tr>
									<td>Entry Fee: $${park.entryFee}</td>
									<td>Biodiversity: ${park.numberOfAnimalSpecies}</td>
								</tr>

							</tbody>
						</table>
					</div>
				</article>
			</div>
		</div>
		<div class="tile is-parent is-1"></div>
	</div>


	<c:url var="postURL" value="/parkDetails" />
	<form method="POST" action="${postURL}">

		<div class="tile is-ancestor ">
			<div class="tile is-parent is-1"></div>
			<div class="tile is-parent is-10">
				<div class="tile is-child box has-text-info">
					<h1 class=" title is-4 has-text-info has-text-centered ">
						<p>
							<span>&nbsp &nbsp &nbsp &nbsp &nbsp &nbsp <input
								type="radio" name="preference" id="preference" value="false">
								Celsius </input>
							</span> &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp
							&nbsp<span> <input type="radio" name="preference"
								id="preference" value="true"> Fahrenheit </input>&nbsp &nbsp
								&nbsp
							</span>
						</p>
						<br> <input class="button is-link is-light " type="submit"
							value="Set Preference" /> <input type="hidden" name="parkCode"
							value="${park.parkCode}" />
					</h1>
				</div>
			</div>
			<div class="tile is-parent is-1"></div>
		</div>
	</form>

	<BR>


	<div class="tile is-ancestor ">
		<div class="tile is-parent is-1"></div>

		<c:forEach items="${forecasts}" var="day">

			<div class="tile is-parent is-2">
				<div class="tile is-child box has-text-black has-text-centered">

					<c:url var="weatherImgUrl" value="img/weather/${day.forecastImg}" />
					<img src="${weatherImgUrl}" /> <span class="has-text-link">${day.low}</span>
					&nbsp <span class="has-text-danger">${day.high}</span> <br>
					<div class="has-text-info is-capitalized has-text-weight-bold">
						${day.forecast} <br>
					</div>
					<div class="has-text-grey">
						<c:forEach items="${day.advisory}" var="phrase">
					${phrase}
						</c:forEach>
					</div>
				</div>
			</div>

		</c:forEach>

		<div class="tile is-parent is-1"></div>
	</div>

	<c:import url="/WEB-INF/jsp/common/footer.jsp" />
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<c:import url="/WEB-INF/jsp/common/header.jsp" />


<c:forEach items="${parks}" var="park">

	<div class="tile is-ancestor has-text-centered">
		<div class="tile is-parent is-1"></div>
		<div class="tile is-parent is-5">
			<article class="tile is-child box">
				<figure class="image is-4by2">
					<a href="parkDetails?parkcode=${park.parkCode}"> <img
						src="<c:url value="img/parks/${park.parkImgCode}.jpg" />" />
					</a>
				</figure>
			</article>
		</div>
		<div class="tile is-parent is-5">
			<article class="tile is-child box content is-small">
			<br> 
				<h1 class="has-text-black is-italic has-text-weight-light">
					<c:out value="${park.name}, ${park.state }" />
				</h1>
				<br>
				<h1 class="has-text-black is-italic has-text-weight-light">
					<c:out value="Number of votes: ${favorites.get(park.parkCode)}" />
				</h1>
			</article>
		</div>
		<div class="tile is-parent is-1"></div>
	</div>

</c:forEach>


<c:import url="/WEB-INF/jsp/common/footer.jsp" />
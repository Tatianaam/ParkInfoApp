<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<c:import url="/WEB-INF/jsp/common/header.jsp" />


<c:forEach items="${parks}" var="park">

	<c:url var="parkImgUrl" value="img/parks/${park.parkImgCode}.jpg" />

	<div class="tile is-ancestor ">
	<div class="tile is-parent is-1"></div>
		<div class="tile is-parent is-4">
			<article class="tile is-child box">
				<figure class="image is-4by2">
					<a  id="homeParkImgLink" href="parkDetails?parkcode=${park.parkCode}"> <img
						src="${parkImgUrl}" alt="${park.name}" />
					</a>
				</figure>
			</article>
		</div>
		<div class="tile is-parent is-6">
			<article class="tile is-child box content is-medium">
				<h1 class="title is-4 has-text-black" id="parkName">
					<c:out value="${park.name}, ${park.state }" />
				</h1>
				<br>
				<p class="has-text-black">
					<c:out value="${park.parkDescription }" />
				</p>
			</article>
		</div>
		<div class="tile is-parent is-1"></div>
	</div>

</c:forEach>



<c:import url="/WEB-INF/jsp/common/footer.jsp" />
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<c:import url="/WEB-INF/jsp/common/header.jsp" />

<div class="tile is-ancestor ">
	<div class="tile is-parent is-1"></div>
	<div class="tile is-parent is-10">
		<div class="tile is-child box">
			<h1 class="title is-4 has-text-success has-text-centered" 
			id="question">Whats your favorite park?</h1>
		</div>
	</div>
	<div class="tile is-parent is-1"></div>
</div>


<div class="tile is-ancestor ">
	<div class="tile is-parent is-1"></div>
	<div class="tile is-parent is-10 has-text-centered">
		<div
			class="tile is-child box content is-centered is-medium has-text-black">
			<c:url var="surveyResult" value="/surveyInput" />
			<form:form method="POST" action="${surveyResult}"
				modelAttribute="surveyResult">
				<div class="field content">
					<div class="control">
						<div class="select is-success">
							<select name="parkCode">
								<c:forEach items="${parks}" var="park">
									<option value="${park.parkCode}">${park.name}</option>
								</c:forEach>
							</select>
						</div>
					</div>
				</div>


				<div class="field">
					<div class="control">
						<input class="input is-success" type="text" path="email"
							name="email" placeholder="Email" id="emailField"> 
						<form:errors class="has-text-danger" path="email" />
					</div>
				</div>



				<div class="field content is-centered">
					<div class="control">
						<div class="select is-success">
							<select name="state" id="state">
								<option value="AK">AK</option>
								<option value="AL">AL</option>
								<option value="AR">AR</option>
								<option value="AZ">AZ</option>
								<option value="CA">CA</option>
								<option value="CO">CO</option>
								<option value="CT">CT</option>
								<option value="DC">DC</option>
								<option value="DE">DE</option>
								<option value="FL">FL</option>
								<option value="GA">GA</option>
								<option value="HI">HI</option>
								<option value="IA">IA</option>
								<option value="ID">ID</option>
								<option value="IL">IL</option>
								<option value="IN">IN</option>
								<option value="KS">KS</option>
								<option value="KY">KY</option>
								<option value="LA">LA</option>
								<option value="MA">MA</option>
								<option value="MD">MD</option>
								<option value="ME">ME</option>
								<option value="MI">MI</option>
								<option value="MN">MN</option>
								<option value="MO">MO</option>
								<option value="MS">MS</option>
								<option value="MT">MT</option>
								<option value="NC">NC</option>
								<option value="ND">ND</option>
								<option value="NE">NE</option>
								<option value="NH">NH</option>
								<option value="NJ">NJ</option>
								<option value="NM">NM</option>
								<option value="NV">NV</option>
								<option value="NY">NY</option>
								<option value="OH">OH</option>
								<option value="OK">OK</option>
								<option value="OR">OR</option>
								<option value="PA">PA</option>
								<option value="RI">RI</option>
								<option value="SC">SC</option>
								<option value="SD">SD</option>
								<option value="TN">TN</option>
								<option value="TX">TX</option>
								<option value="UT">UT</option>
								<option value="VA">VA</option>
								<option value="VT">VT</option>
								<option value="WA">WA</option>
								<option value="WI">WI</option>
								<option value="WV">WV</option>
								<option value="WY">WY</option>
							</select>
						</div>
					</div>
				</div>
				<div class="has-text-success">
					<label for="activityLevel">What is your activity level?
						&nbsp &nbsp </label> <input type="radio" name="activityLevel"
						value="Inactive" id="activity"> Inactive &nbsp &nbsp</input> <input type="radio"
						name="activityLevel" value="Sedentary"> Sedentary &nbsp
					&nbsp</input> <input type="radio" name="activityLevel" value="Active">
					Active &nbsp &nbsp</input> <input type="radio" name="activityLevel"
						value="Extremely active"> Extremely active </input> <br>
					<form:errors class="has-text-danger" path="activityLevel" />
				</div>
				<br>
				<input class="button is-success is-light is-centered" type="submit"
					value="Submit!" id="submitButton" />

			</form:form>
		</div>
	</div>
</div>
<div class="tile is-parent is-1"></div>
</div>





<c:import url="/WEB-INF/jsp/common/footer.jsp" />
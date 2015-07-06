<%@ include file="/common/taglibs.jsp"%>

<div
	class='col-lg-offset-2 col-md-offset-2 col-sm-offset-2 col-xs-offset-1 col-lg-8 col-md-8 col-sm-8 col-xs-10'>
	<form action="/vote" class="require-validation" id="adviseForm"
		method="post">
		<div class='form-row'>
			<div class='form-group'>
				<div class="checkbox">
					<label><input type="checkbox" name="wantOrganicFood"
						value="true"><strong>I want fresh and healthy
							organic vegetables daily with less price.</strong></label>
				</div>
			</div>
		</div>
		<div class='form-row'>
			<div class='form-group'>
				<div class="checkbox">
					<label><input type="checkbox" name="likeToDoAgri"
						value="true"><strong>I don't know about
							agriculture, but if i get chance am ready to do agriculture with
							guidance.</strong></label>
				</div>
			</div>
		</div>
		<div class='form-row'>
			<div class='form-group'>
				<div class="checkbox">
					<label><input type="checkbox" name="supportFinancially"
						value="true"><strong>I support agriculture, but i
							can't or not interest to do agriculture in field but am ready to
							support financially.</strong> (daily 1 Rs also financial support)</label>
				</div>
			</div>
		</div>
		<div class='form-row'>
			<div class='form-group'>
				<div class="checkbox">
					<label><input type="checkbox" name="supportByLand"
						value="true"><strong>I Have some land and am
							ready to give that land for agriculture in lease basis.</strong></label>
				</div>
			</div>
		</div>
		<div class='form-row'>
			<div class='form-group'>
				<div class="checkbox">
					<label><input type="checkbox" name="supportTechnically"
						value="true"><strong>Am ready to support
							agriculture technically like R&D, mechanical, electrical,
							software etc... </strong></label>
				</div>
				<div class='form-row'>
					<div class='form-group'>
						<div class="checkbox">
							<label><input type="checkbox" name="partTimeSupport"
								value="true"><strong>Am ready to support
									agriculture in my free time neither technically nor man power.</strong>
								(Part time basis)</label>
						</div>
					</div>
				</div>
				<div class='form-row'>
					<div class='form-group'>
						<div class="checkbox">
							<label><input type="checkbox" name="monthlySalariedAgri"
								value="true"><strong>If i get promising monthly
									income from agriculture am ready to take agriculture as my
									profession. (monthly salary for agriculture)</strong></label>
						</div>
					</div>
				</div>
			</div>
		</div>
		<div class='form-row'>
			<div class='form-group col-lg-8 col-md-8 col-sm-10 col-xs-12'>
				<input class='form-control' name="email" id="adviserEmail"
					placeholder="Email" type='email' required='required'>
			</div>
		</div>
		<div class='form-row'>
			<div class='col-lg-3 col-md-3 col-sm-4 col-xs-6 pull-right'>
				<button class='form-control btn btn-danger submit-button'
					type='submit'>Vote</button>
			</div>
		</div>
	</form>
</div>
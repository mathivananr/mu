<%@ include file="/common/taglibs.jsp"%>
<br>
<div class="panel panel-danger"></div>
<div class="container">
	<div class="row">
		<!-- Navigation Buttons -->
		<div class="col-md-2">
			<ul class="nav nav-pills nav-stacked" id="paymentTabs">
				<li class="active"><a class="payment-link-text" href="#cc">Credit
						Card</a></li>
				<li><a class="payment-link-text" href="#nb">Net Banking</a></li>
				<li><a class="payment-link-text" href="#dc">Debit Card</a></li>
			</ul>
		</div>

		<!-- Content -->
		<div class="col-md-10">
			<div class="tab-content">
				<div class="tab-pane active" id="cc">
					<form accept-charset="UTF-8" action="/proceedPayment"
						class="require-validation" data-cc-on-file="false"
						id="payment-form" method="post">
						<input type="hidden" id="rechargeId" name="rechargeId" value="${recharge.id}">
						<div class='form-row'>
							<div class='col-xs-12 form-group required'>
								<label class='control-label'>Name on Card</label> <input
									class='form-control' size='4' type='text'>
							</div>
						</div>
						<div class='form-row'>
							<div class='col-xs-12 form-group card required'>
								<label class='control-label'>Card Number</label> <input
									autocomplete='off' class='form-control card-number' size='20'
									type='text'>
							</div>
						</div>
						<div class='form-row'>
							<div class='col-xs-4 form-group cvc required'>
								<label class='control-label'>CVV</label> <input
									autocomplete='off' class='form-control card-cvc'
									placeholder='ex. 311' size='4' type='text'>
							</div>
							<div class='col-xs-4 form-group expiration required'>
								<label class='control-label'>Expiration</label> <input
									class='form-control card-expiry-month' placeholder='MM'
									size='2' type='text'>
							</div>
							<div class='col-xs-4 form-group expiration required'>
								<label class='control-label'> </label> <input
									class='form-control card-expiry-year' placeholder='YYYY'
									size='4' type='text'>
							</div>
						</div>


						<div class='form-row'>
							<div class='col-md-12 form-group'>
								<hr class="featurette-divider"></hr>
								<button class='form-control btn btn-success submit-button'
									disabled>
									<span class="badge">Your total today: $300</span>
								</button>
								<button class='form-control btn btn-primary submit-button'
									type='submit'>Pay »</button>

							</div>
						</div>

						<div class='form-row'>
							<div class='col-md-12 error form-group hide'>
								<div class='alert-danger alert'>Please correct the errors
									and try again.</div>
							</div>
						</div>
					</form>
				</div>
				<div class="tab-pane" id="nb">nb</div>
				<div class="tab-pane" id="dc">
					<form accept-charset="UTF-8" action="/proceedPayment"
						class="require-validation" data-cc-on-file="false"
						id="payment-form" method="post">
						<input type="hidden" id="rechargeId" name="rechargeId" value="${recharge.id}">
						<div class='form-row'>
							<div class='col-xs-12 form-group required'>
								<label class='control-label'>Name on Card</label> <input
									class='form-control' size='4' type='text'>
							</div>
						</div>
						<div class='form-row'>
							<div class='col-xs-12 form-group card required'>
								<label class='control-label'>Card Number</label> <input
									autocomplete='off' class='form-control card-number' size='20'
									type='text'>
							</div>
						</div>
						<div class='form-row'>
							<div class='col-xs-4 form-group cvc required'>
								<label class='control-label'>CVV</label> <input
									autocomplete='off' class='form-control card-cvc'
									placeholder='ex. 311' size='4' type='text'>
							</div>
							<div class='col-xs-4 form-group expiration required'>
								<label class='control-label'>Expiration</label> <input
									class='form-control card-expiry-month' placeholder='MM'
									size='2' type='text'>
							</div>
							<div class='col-xs-4 form-group expiration required'>
								<label class='control-label'> </label> <input
									class='form-control card-expiry-year' placeholder='YYYY'
									size='4' type='text'>
							</div>
						</div>


						<div class='form-row'>
							<div class='col-md-12 form-group'>
								<hr class="featurette-divider"></hr>
								<button class='form-control btn btn-success submit-button'
									disabled>
									<span class="badge">Your total today: $300</span>
								</button>
								<button class='form-control btn btn-primary submit-button'
									type='submit'>Pay »</button>

							</div>
						</div>

						<div class='form-row'>
							<div class='col-md-12 error form-group hide'>
								<div class='alert-danger alert'>Please correct the errors
									and try again.</div>
							</div>
						</div>
					</form>
				</div>
			</div>
		</div>

	</div>
</div>
<br>
<div class="panel panel-danger"></div>
<%@ include file="/common/taglibs.jsp"%>
<!-- recharge form -->
<div class='row'>
	<div
		class='col-lg-offset-4 col-md-offset-4 col-sm-offset-3 col-xs-offset-1 col-lg-4 col-md-4 col-sm-6 col-xs-10'>
<!-- 		<div class="col-lg-offset-3 col-md-offset-3">
			<p>For every recharge Rs.1 extra.</p>
		</div>
 -->		<div role="tabpanel">

			<!-- Nav tabs -->
			<ul class="nav nav-tabs margin-bottom10" role="tablist">
				<li role="presentation" class="active"><a href="#mobile"
					class="link-color" aria-controls="mobile" role="tab"
					data-toggle="tab">Mobile</a></li>
				<li role="presentation"><a href="#dataCard" class="link-color"
					aria-controls="dataCard" role="tab" data-toggle="tab">Data Card</a></li>
				<li role="presentation"><a href="#dth" class="link-color"
					aria-controls="dth" role="tab" data-toggle="tab">DTH</a></li>
			</ul>

			<!-- Tab panes -->
			<div class="tab-content">
				<div role="tabpanel" class="tab-pane active" id="mobile">
					<form action="/initiatePayment" class="require-validation"
						id="rechargeForm" method="post">
						<input type="hidden" name="rechargeType" value="mobile"/>
						<div class='form-row'>
							<div class='form-group'>
								<input class='form-control' name="email" id="email"
									placeholder="Email" type='email' required="required">
							</div>
						</div>
						<div class='form-row'>
							<div class='form-group'>
								<input class='form-control' name="phoneNumber" id="phoneNumber"
									placeholder="Phone Number" type='text' required="required">
							</div>
						</div>
						<div class='form-row'>
							<div class='form-group'>
								<select name="operator" id="mobileOperator" class="form-control" required="required">
									<c:forEach items="${mobileOperators}" var="operator">
										<option value="${operator.value}">${operator.label}</option>
									</c:forEach>
								</select>
							</div>
							<div class='form-group'>
								<input type="text" name="amount" id="amount"
									placeholder="Amount" class="form-control" value="${recharge.amount}" readonly required="required">
							</div>
						</div>
						<div class='form-row'>
							<div class='col-lg-4 col-md-4 col-sm-4 col-xs-6 pull-right'>
								<button class='form-control btn btn-danger submit-button'
									type='submit'>Proceed</button>
							</div>
						</div>
					</form>
				</div>
				<div role="tabpanel" class="tab-pane" id="dataCard">
					<form action="/initiatePayment" class="require-validation"
						id="rechargeForm" method="post">
						<input type="hidden" name="rechargeType" value="dataCard"/>
						<div class='form-row'>
							<div class='form-group'>
								<input class='form-control' name="email" id="email"
									placeholder="Email" type='email' required="required">
							</div>
						</div>
						<div class='form-row'>
							<div class='form-group'>
								<input class='form-control' name="phoneNumber" id="phoneNumber"
									placeholder="Data Card Number" type='text' required="required">
							</div>
						</div>
						<div class='form-row'>
							<div class='form-group'>
								<select name="operator" id="dataCarOperator"
									class="form-control" required="required">
									<c:forEach items="${datacardOperators}" var="operator">
										<option value="${operator.value}">${operator.label}</option>
									</c:forEach>
								</select>
							</div>
							<div class='form-group'>
								<input type="text" name="amount" id="amount"
									placeholder="Amount" class="form-control" value="${recharge.amount}" readonly required="required">
							</div>
						</div>
						<div class='form-row'>
							<div class='col-lg-4 col-md-4 col-sm-4 col-xs-6 pull-right'>
								<button class='form-control btn btn-danger submit-button'
									type='submit'>Proceed</button>
							</div>
						</div>
					</form>
				</div>
				<div role="tabpanel" class="tab-pane" id="dth">
					<form action="/initiatePayment" class="require-validation"
						id="rechargeForm" method="post">
						<input type="hidden" name="rechargeType" value="dth"/>
						<div class='form-row'>
							<div class='form-group'>
								<input class='form-control' name="email" id="email"
									placeholder="Email" type='email' required="required">
							</div>
						</div>
						<div class='form-row'>
							<div class='form-group'>
								<input class='form-control' name="phoneNumber" id="phoneNumber"
									placeholder="DTH Number" type='text' required="required">
							</div>
						</div>
						<div class='form-row'>
							<div class='form-group'>
								<select name="operator" id="dthOperator" class="form-control" required="required">
									<c:forEach items="${dthOperators}" var="operator">
										<option value="${operator.value}">${operator.label}</option>
									</c:forEach>
								</select>
							</div>
							<div class='form-group'>
								<input type="text" name="amount" id="amount"
									placeholder="Amount" class="form-control" value="${recharge.amount}" readonly required="required">
							</div>
						</div>
						<div class='form-row'>
							<div class='col-lg-4 col-md-4 col-sm-4 col-xs-6 pull-right'>
								<button class='form-control btn btn-danger submit-button'
									type='submit'>Proceed</button>
							</div>
						</div>
					</form>
				</div>
			</div>

		</div>
	</div>
</div>
<!-- end recharge form -->
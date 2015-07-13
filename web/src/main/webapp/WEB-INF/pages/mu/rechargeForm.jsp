<%@ include file="/common/taglibs.jsp"%>
<!-- recharge form -->
<div class='row'>
	<div
		class='col-lg-offset-4 col-md-offset-4 col-sm-offset-3 col-xs-offset-1 col-lg-4 col-md-4 col-sm-6 col-xs-10'>
		<!-- 		<div class="col-lg-offset-3 col-md-offset-3">
			<p>For every recharge Rs.1 extra.</p>
		</div>
 -->
		<div class="row">
			<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
				<div class="row text-center">
					<small>Click your favorite site and continue your recharge</small>
				</div>
			</div>

			<c:forEach var="merchant" items="${merchantType.merchants}">
				<div class="col-lg-4 col-md-4 col-sm-4 col-xs-4">
					<div class="thumbnail">
						<a href="${merchant.targetLink}"><img
							src="${merchant.logoPath}" alt="${merchant.merchantName}"
							width="100%" class="slider-store-image"> </a>
					</div>
				</div>
			</c:forEach>
		</div>

		<div class="row">
			<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
				<div class="row text-center">
					<strong> ( or ) </strong>
				</div>
			</div>
		</div>
		<div class="row text-center">
			<small> Recharge here </small>
		</div>
		<div class="row">
			<div role="tabpanel">

				<!-- Nav tabs -->
				<ul class="nav nav-tabs margin-bottom10 sec-sub-title"
					role="tablist">
					<li role="presentation" class="active"><a href="#mobile"
						class="link-color" aria-controls="mobile" role="tab"
						data-toggle="tab"><p>Mobile</p></a></li>
					<li role="presentation"><a href="#dataCard" class="link-color"
						aria-controls="dataCard" role="tab" data-toggle="tab"><p>Data
								Card</p></a></li>
					<li role="presentation"><a href="#dth" class="link-color"
						aria-controls="dth" role="tab" data-toggle="tab"><p>DTH</p></a></li>
				</ul>

				<!-- Tab panes -->
				<div class="tab-content">
					<div role="tabpanel" class="tab-pane active" id="mobile">
						<form action="/initiatePayment" class="require-validation"
							id="rechargeForm" method="post">
							<input type="hidden" name="rechargeType" value="mobile" />
							<div class='form-row'>
								<div class='form-group'>
									<input class='form-control input-lg' name="email" id="email"
										placeholder="Email" type='email' required="required">
								</div>
							</div>
							<div class='form-row'>
								<div class='form-group'>
									<input class='form-control input-lg' name="phoneNumber"
										id="phoneNumber" placeholder="Phone Number" type='text'
										required="required">
								</div>
							</div>
							<div class='form-row'>
								<div class='form-group'>
									<select name="operator" id="mobileOperator"
										class="form-control input-lg" required="required">
										<c:forEach items="${mobileOperators}" var="operator">
											<option value="${operator.value}">${operator.label}</option>
										</c:forEach>
									</select>
								</div>
								<div class='form-group'>
									<input type="text" name="amount" id="amount"
										placeholder="Amount" class="input-lg form-control"
										value="${recharge.amount}" readonly required="required">
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
							<input type="hidden" name="rechargeType" value="dataCard" />
							<div class='form-row'>
								<div class='form-group'>
									<input class='form-control input-lg' name="email" id="email"
										placeholder="Email" type='email' required="required">
								</div>
							</div>
							<div class='form-row'>
								<div class='form-group'>
									<input class='form-control input-lg' name="phoneNumber"
										id="phoneNumber" placeholder="Data Card Number" type='text'
										required="required">
								</div>
							</div>
							<div class='form-row'>
								<div class='form-group'>
									<select name="operator" id="dataCarOperator"
										class="form-control input-lg" required="required">
										<c:forEach items="${datacardOperators}" var="operator">
											<option value="${operator.value}">${operator.label}</option>
										</c:forEach>
									</select>
								</div>
								<div class='form-group'>
									<input type="text" name="amount" id="amount"
										placeholder="Amount" class="input-lg form-control"
										value="${recharge.amount}" readonly required="required">
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
							<input type="hidden" name="rechargeType" value="dth" />
							<div class='form-row'>
								<div class='form-group'>
									<input class='form-control input-lg' name="email" id="email"
										placeholder="Email" type='email' required="required">
								</div>
							</div>
							<div class='form-row'>
								<div class='form-group'>
									<input class='form-control input-lg' name="phoneNumber"
										id="phoneNumber" placeholder="DTH Number" type='text'
										required="required">
								</div>
							</div>
							<div class='form-row'>
								<div class='form-group'>
									<select name="operator" id="dthOperator"
										class="input-lg form-control" required="required">
										<c:forEach items="${dthOperators}" var="operator">
											<option value="${operator.value}">${operator.label}</option>
										</c:forEach>
									</select>
								</div>
								<div class='form-group'>
									<input type="text" name="amount" id="amount"
										placeholder="Amount" class="form-control input-lg"
										value="${recharge.amount}" readonly required="required">
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
</div>
<!-- end recharge form -->
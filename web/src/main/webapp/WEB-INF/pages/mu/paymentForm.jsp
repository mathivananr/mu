<%@ include file="/common/taglibs.jsp"%>
<div class="panel panel-danger"></div>
<div class="container">
	<div class="row">
		<form action="${paymentURL}"
			class="require-validation" id="payment-form" method="post">
			<input type="hidden" name="key" value="${payment.key}" /> <input
				type="hidden" name="txnid" value="${payment.txnid}" /> <input
				type="hidden" name="amount" value="${payment.amount}" />
			<%-- <input type="hidden" name="firstname" value="${payment.firstname}" /> --%>
			<input type="hidden" name="productinfo"
				value="${payment.productinfo}" /> <input type="hidden" name="email"
				value="${payment.email}" /> <input type="hidden" name="phone"
				value="${payment.phone}" /> <input type="hidden" name="surl"
				value="${payment.surl}" /> <input type="hidden" name="furl"
				value="${payment.furl}" /> <input type="hidden" name="hash"
				value="${payment.hash}" /> <input type="hidden"
				name="service_provider" value="${payment.service_provider}" />
			<div class='form-row'>
				<div class='col-xs-12 form-group required'>
					<!-- <label class='control-label'>Name on Card</label> <input
								class='form-control' size='4' type='text'> -->
				</div>
			</div>
			<div class="row">
				<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
					<div class="panel panel-default">
						<div class="panel-heading">
							<h3 class="text-center">
								<strong>Order summary</strong>
							</h3>
						</div>
						<div class="panel-body">
							<div class="table-responsive">
								<table class="table table-condensed">
									<thead>
										<tr>
											<td class="text-center"><strong>Order No</strong></td>
											<td class="text-center"><strong>Number</strong></td>
											<td class="text-center"><strong>Amount</strong></td>
											<td class="text-center"><strong>MU Charge</strong></td>
											<td class="text-right"><strong>Total</strong></td>
										</tr>
									</thead>
									<tbody>
										<tr>
											<td class="text-center">${recharge.rechargeId}</td>
											<td class="text-center">${recharge.phoneNumber}</td>
											<td class="text-center">Rs ${recharge.amount}</td>
											<td class="text-center">Rs 1</td>
											<td class="text-right"><strong>Rs ${payment.amount}</strong></td>
										</tr>
									</tbody>
								</table>
							</div>
						</div>
					</div>
				</div>
			</div>
			<div class='form-row'>
				<div
					class='col-md-offset-lg col-lg-4 col-md-offset-4 col-md-4 col-sm-offset-3 col-sm-6 col-xs-12 form-group'>
					<hr class="featurette-divider"></hr>
					<button class='form-control btn btn-primary submit-button'
						type='submit'>Pay »</button>

				</div>
			</div>
		</form>

		<%-- <form action="https://secure.payu.in/_payment" method="post"
			name="payuForm">
			<input type="hidden" name="key" value="UOgXBC" /> 
			<input type="hidden" name="txnid" value="60470852" />
			<input type="hidden" name="amount" value="1" />
			<input type="hidden" name="productinfo" value="test recharge" />
			<input type="hidden" name="firstname" value="mathivanan" />
			<input type="hidden" name="email" value="mathivanan18@gmail.com" />
			<input type="hidden" name="phone" value="9894317212" />
			<input type="hidden" name="surl" value="http://demo.muniyamma.com" />
			<input type="hidden" name="furl" value="http://demo.muniyamma.com" />
			<input type="hidden" name="hash" value="<%=hash%>" />
			<!-- <input type="hidden" name="udf2" value="MU1" /> -->
			<input type="hidden" name="service_provider" value="payu_paisa" />
			<input type="submit" value="Submit" />
		</form> --%>
	</div>
</div>
<br>
<div class="panel panel-danger"></div>

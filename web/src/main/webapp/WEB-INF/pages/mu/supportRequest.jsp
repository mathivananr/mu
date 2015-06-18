<META HTTP-EQUIV="Content-Type" CONTENT="text/html" ; charset="utf-8" />
<%@ include file="/common/taglibs.jsp"%>
<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
	<div class="">
		<div class="row" id="supportRequestForm">
			<div
				class='col-lg-offset-2 col-md-offset-2 col-sm-offset-2 col-xs-offset-1 col-lg-8 col-md-8 col-sm-8 col-xs-10'>
				<form action="/riseSupportRequest" class="require-validation"
					id="supportRequestForm" method="post">
					<input type="hidden" name="id" id="id" />
					<div class='form-row'>
						<div class='form-group'>
							<input class='form-control' name="rechargeId" id="rechargeId"
								placeholder="Order No" type='text' required='required'>
						</div>
					</div>
					<div class='form-row'>
						<div class='form-group'>
							<input class='form-control' name="email" id="adviserEmail"
								placeholder="Email" type='email' required='required'>
						</div>
					</div>
					<div class='form-row'>
						<div class='form-group'>
							<textarea class="form-control" cols="50" id="description"
								name="description" placeholder="Details"
								rows="10" required='required'></textarea>
						</div>
					</div>
					<div class='form-row'>
						<!-- <div class='col-lg-10 col-md-10 col-sm-8 col-xs-8'>
							<div class='col-lg-6 col-md-6 col-sm-10 col-xs-12 pull-right'>
								<input class='form-control' name="secretKey" id="secretKey"
									placeholder="Secret key to edit " type='text'
									required='required'>
							</div>
						</div> -->
						<div class='col-lg-2 col-md-2 col-sm-4 col-xs-4'>
							<button class='form-control btn btn-danger submit-button'
								type='submit'>Post</button>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>
</div>
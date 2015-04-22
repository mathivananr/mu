<%@ include file="/common/taglibs.jsp"%>
<div
	class='col-lg-offset-2 col-md-offset-2 col-sm-offset-2 col-xs-offset-1 col-lg-8 col-md-8 col-sm-8 col-xs-10'>
	<form action="/postAdvise" class="require-validation" id="adviseForm"
		method="post">
		<div class='form-row'>
			<div class='form-group'>
				<input class='form-control' name="adviserName" id="adviserName"
					placeholder="Display Name" type='text'>
			</div>
		</div>
		<div class='form-row'>
			<div class='form-group'>
				<input class='form-control' name="email" id="email"
					placeholder="Email" type='email'>
			</div>
		</div>
		<div class='form-row'>
			<div class='form-group'>
				<textarea class="form-control" cols="50" id="description"
					name="description" placeholder="Write your advise here..."
					rows="10"></textarea>
			</div>
		</div>
		<div class='form-row'>
			<div class='col-lg-10 col-md-10 col-sm-8 col-xs-8'>
				<div class='col-lg-6 col-md-6 col-sm-10 col-xs-12 pull-right'>
					<input class='form-control' name="secretKey" id="secretKey"
						placeholder="Secret key to edit " type='text'>
				</div>
			</div>
			<div class='col-lg-2 col-md-2 col-sm-4 col-xs-4'>
				<button class='form-control btn btn-danger submit-button'
					type='submit'>Post</button>
			</div>
		</div>
	</form>
</div>
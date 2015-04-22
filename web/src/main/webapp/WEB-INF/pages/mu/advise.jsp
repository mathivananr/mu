<META HTTP-EQUIV="Content-Type" CONTENT="text/html" ; charset="utf-8" />
<%@ include file="/common/taglibs.jsp"%>
<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
	<div class="collapse-group">
		<div class="row" id="writeButton">
			<div
				class="col-lg-offset-1 col-md-offset-1 col-lg-10 col-md-10 col-sm-12 col-xs-12">
				<!-- Button trigger modal -->
				<button type="button" class="btn btn-danger btn-lg pull-right"
					data-toggle="collapse" data-target="#adviseForm"
					id="collapseAdvise">Write Advise</button>
				<!-- Modal -->
				<!-- <div class="modal fade" id="adviseModal" tabindex="-1" role="dialog"
				aria-labelledby="adviseModalLabel" aria-hidden="true">
				<div class="modal-dialog">
					<div class="modal-content">
						<div class="modal-header">
							<button type="button" class="close" data-dismiss="modal"
								aria-label="Close">
								<span aria-hidden="true">&times;</span>
							</button>
							<h4 class="modal-title" id="adviseModalLabel">Write Advise</h4>
						</div>
						<div class="modal-body">
							<div class="row form" id="adviseForm">
								<div class="form-group">
									<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
										<input type="text" class="form-control" id="adviserName"
											name="adviserName" placeholder="Name"></input>
									</div>
								</div>
								<div class="form-group">
									<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
										<input type="email" class="form-control" id="email"
											name="email" placeholder="Email (not visible for public)"></input>
									</div>
								</div>
								<div class="form-group">
									<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
										<textarea class="form-control" cols="50" id="description"
											name="description" placeholder="Write your advise here..."
											rows="10"></textarea>
									</div>
								</div>
							</div>
							<div class="modal-footer">
								<button type="button" class="btn btn-danger"
									data-dismiss="modal">Close</button>
								<button type="button" class="btn btn-success" id="postAdvise">Post</button>
							</div>
						</div>
					</div>
				</div>
			</div> -->
			</div>
		</div>
		<hr />
		<div class="row collapse" id="adviseForm">
			<div
				class='col-lg-offset-2 col-md-offset-2 col-sm-offset-2 col-xs-offset-1 col-lg-8 col-md-8 col-sm-8 col-xs-10'>
				<form action="/postAdvise" class="require-validation"
					id="adviseForm" method="post">
					<input type="hidden" name="id" id="adviseId" />
					<div class='form-row'>
						<div class='form-group'>
							<input class='form-control' name="adviserName" id="adviserName"
								placeholder="Display Name" type='text' required='required'>
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
							<textarea class="form-control" cols="50" id="adviseDescription"
								name="description" placeholder="Write your advise here..."
								rows="10" required='required'></textarea>
						</div>
					</div>
					<div class='form-row'>
						<div class='col-lg-10 col-md-10 col-sm-8 col-xs-8'>
							<div class='col-lg-6 col-md-6 col-sm-10 col-xs-12 pull-right'>
								<input class='form-control' name="secretKey" id="secretKey"
									placeholder="Secret key to edit " type='text'
									required='required'>
							</div>
						</div>
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
<div id='advise-list' class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
	<c:forEach var="advise" items="${advises}">
		<div class="row" id="advise-${advise.id}">
			<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
				<div class="col-lg-10 col-md-10 col-sm-10 col-xs-12">
					<h4>
						<strong>${advise.adviserName}</strong>
					</h4>
				</div>
				<div class="col-lg-2 col-md-2 col-sm-2 col-xs-12 pull-right">
					<ul class="nav navbar-nav pull-right">
						<li class="dropdown"><a data-toggle="dropdown"
							class="dropdown-toggle link-color" href="#"><b class="caret"></b></a>
							<ul class="dropdown-menu">
								<li><a href='#' id='adviseEditLink' onclick="javascript:getAdvise(${advise.id});">Edit</a></li>
							</ul></li>
					</ul>
				</div>
				<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
					<pre class="pad-10 advise-content">${advise.description}</pre>
				</div>
			</div>
		</div>
		<hr />
	</c:forEach>
</div>
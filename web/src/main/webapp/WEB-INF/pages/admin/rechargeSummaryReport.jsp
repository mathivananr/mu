<%@ include file="/common/taglibs.jsp"%>
<div class="row">
	<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
		<div class="row">
			<form method="get" action="${ctx}/admin/rechargeSummaryReport" id="searchForm"
				class="form-inline">
				<div id="rechargeFilter">
					<input class="form-control input-sm" type="text" name="fromDate"
						id="fromDate" placeholder="From Date"> 
					<input class="form-control input-sm" type="text" name="toDate"
						id="toDate" placeholder="To Date"> 
					<select	class="form-control input-sm" id="status" name="status">
						<option value="all">All</option>
						<option value="failed">Failed</option>
						<option value="success">Success</option>
					</select>
					<button id="button.search" class="btn btn-default btn-sm"
						type="submit">
						<i class="icon-search"></i>
						<fmt:message key="button.search" />
					</button>
				</div>
			</form>
		</div>
		<div class="row">
			<div class="panel panel-default">
				<div class="panel-heading">
					<h3 class="text-center">
						<strong>Recharge summary</strong>
					</h3>
				</div>
				<div class="panel-body">
					<div class="table-responsive">
						<table class="table table-condensed">
							<thead>
								<tr>
									<td class="text-center"><strong>Operator Name</strong></td>
									<td class="text-center"><strong>Number of
											Recharge</strong></td>
									<td class="text-center"><strong>Amount</strong></td>
								</tr>
							</thead>
							<tbody>
								<c:forEach var="rechargeSummary" items="${rechargeSummaries}">
									<tr>
										<td class="text-center"><a href="/admin/recharges"
											title="${rechargeSummary.operatorName} recharge">${rechargeSummary.operatorName}</a></td>
										<td class="text-center">${rechargeSummary.rechargeCount}</td>
										<td class="text-center">Rs ${rechargeSummary.amount}</td>

									</tr>
								</c:forEach>
								<tr>
									<td class="text-center" colspan="2"></td>
									<td class="text-center">Rs ${totalAmount}</td>

								</tr>
							</tbody>
						</table>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
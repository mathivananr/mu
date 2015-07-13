<%@ include file="/common/taglibs.jsp"%>

<head>
<title><fmt:message key="rechargeList.title" /></title>
</head>

<c:if test="${not empty searchError}">
	<div class="alert alert-danger alert-dismissable">
		<a href="#" data-dismiss="alert" class="close">&times;</a>
		<c:out value="${searchError}" />
	</div>
</c:if>

<div class="col-sm-12">
	<h2>
		<fmt:message key="rechargeList.heading" />
	</h2>
	<div id="actions" class="btn-group">
		<a class="btn btn-primary"
			href="<c:url value='/admin/recharge?method=Add&from=list'/>"> <i
			class="icon-plus icon-white"></i> <fmt:message key="button.add" /></a> <a
			class="btn btn-default" href="<c:url value='/home'/>"> <i
			class="icon-ok"></i> <fmt:message key="button.done" /></a>
	</div>
	<div class="col-sm-12">
		<form method="get" action="${ctx}/admin/recharges" id="searchForm"
			class="form-inline">
			<%-- <div id="search" class="text-right">
	        <span class="col-sm-9">
	            <input type="text" size="20" name="q" id="query" value="${param.q}"
	                   placeholder="<fmt:message key="search.enterTerms"/>" class="form-control input-sm">
	        </span>
	        <button id="button.search" class="btn btn-default btn-sm" type="submit">
	            <i class="icon-search"></i> <fmt:message key="button.search"/>
	        </button>
	    </div> --%>
			<div id="rechargeFilter">
				<input class="form-control input-sm" type="text" name="fromDate"
					id="fromDate" placeholder="From Date"> <input class="form-control input-sm"
					type="text" name="toDate" id="toDate" placeholder="To Date"> 
					<input class="form-control input-sm"
					type="text" name="email" id="email" placeholder="Email">
					<input class="form-control input-sm"
					type="text" name="phoneNumber" id="phoneNumber" placeholder="Phone Number">
					<select name="operator" id="mobileOperator" class="form-control" required="required">
						<c:forEach items="${mobileOperators}" var="operator">
							<option value="${operator.value}">${operator.label}</option>
						</c:forEach>
					</select>
					<select
					class="form-control input-sm" id="status" name="status">
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
	<br />
	<display:table name="rechargeList" cellspacing="0" cellpadding="0"
		requestURI="" defaultsort="9" id="recharges" pagesize="25"
		class="table table-condensed table-striped table-hover" export="true">
		<display:column property="rechargeId" escapeXml="true" sortable="true"
			titleKey="recharges.rechargeId" style="width: 10%" />
		<display:column property="email" escapeXml="true" sortable="true"
			titleKey="recharges.email" style="width: 8%" />
		<display:column property="phoneNumber" escapeXml="true"
			sortable="true" titleKey="recharges.number" style="width: 8%" />
		<display:column property="operator" escapeXml="true" sortable="true"
			titleKey="recharges.operator" style="width: 5%" />
		<display:column property="amount" escapeXml="true" sortable="true"
			titleKey="recharges.amount" style="width: 5%" />
		<display:column property="status" escapeXml="true" sortable="true"
			titleKey="recharges.status" style="width: 5%" />
		<display:column property="rechargeSummary" escapeXml="true"
			sortable="true" titleKey="recharges.rechargeSummary"
			style="width: 20%" />
		<display:column property="createdOn.time"
			format="{0,date,dd-MM-yyyy HH:mm:ss}" escapeXml="true"
			sortable="true" titleKey="recharges.createdOn" style="width: 15%" />
		<display:column property="updatedOn.time"
			format="{0,date,dd-MM-yyyy HH:mm:ss}" escapeXml="true"
			sortable="true" titleKey="recharges.updatedOn" style="width: 15%" />
		<display:column sortProperty="status" sortable="true"
			titleKey="recharge.success" style="width: 10%; padding-left: 15px"
			media="html">
			<input type="checkbox" onclick="completeRecharge(${recharges.id});"
				id="rechargeDone-${recharges.id}" data-id="${recharges.id}"
				<c:if test="${recharges.status == 'success'}">disabled="disabled"</c:if>
				<c:if test="${recharges.status == 'success'}">checked="checked"</c:if> />
		</display:column>
		<display:column property="enabled" titleKey="recharge.enabled"
			media="csv xml excel pdf" />

		<display:setProperty name="paging.banner.item_name">
			<fmt:message key="rechargeList.recharge" />
		</display:setProperty>
		<display:setProperty name="paging.banner.items_name">
			<fmt:message key="rechargeList.recharges" />
		</display:setProperty>

		<display:setProperty name="export.excel.filename"
			value="Recharge List.xls" />
		<display:setProperty name="export.csv.filename"
			value="Recharge List.csv" />
		<display:setProperty name="export.pdf.filename"
			value="Recharge List.pdf" />
	</display:table>
</div>
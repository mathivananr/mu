<%@ include file="/common/taglibs.jsp"%>

<head>
<title><fmt:message key="networkOperator.title" /></title>
</head>

<div class="col-sm-2">
	<h2>
		<fmt:message key="networkOperator.heading" />
	</h2>
</div>
<div class="col-sm-7">
	<spring:bind path="networkOperator.*">
		<c:if test="${not empty status.errorMessages}">
			<div class="alert alert-danger alert-dismissable">
				<a href="#" data-dismiss="alert" class="close">&times;</a>
				<c:forEach var="error" items="${status.errorMessages}">
					<c:out value="${error}" escapeXml="false" />
					<br />
				</c:forEach>
			</div>
		</c:if>
	</spring:bind>

	<form:form commandName="networkOperator" method="post"
		enctype="multipart/form-data" action="/admin/saveNetworkOperator"
		id="networkOperatorForm" autocomplete="off" cssClass="well">
		<form:hidden path="id" />
		<div class="row">
			<div class="form-group">
				<form:input cssClass="form-control" path="operatorName"
					id="operatorName" placeholder="Name" />
			</div>
		</div>
		<div class="row">
			<div class="form-group">
				<form:input cssClass="form-control" path="operatorCode"
					id="operatorCode" placeholder="Code" />
			</div>
		</div>
		<div class="row">
			<div class="form-group">
				<select id="operatorType" name="operatorType" class="form-control">
					<option value="mobile">Mobile</option>
					<option value="DTH">DTH</option>
					<option value="datacard">DataCard</option>
				</select>
			</div>
		</div>
		<div class="row">
			<div class="form-group">
				<label class="checkbox-inline"> <form:checkbox
						path="enabled" id="enabled" /> <fmt:message
						key="networkOperator.enabled" />
				</label>
			</div>
		</div>
		<div class="row">
			<div class="form-group">
				<button type="submit" class="btn btn-primary" name="save"
					onclick="bCancel=false">
					<i class="icon-ok icon-white"></i>
					<fmt:message key="button.save" />
				</button>
				<button type="submit" class="btn btn-default" name="cancel"
					onclick="bCancel=true">
					<i class="icon-remove"></i>
					<fmt:message key="button.cancel" />
				</button>
			</div>
		</div>
	</form:form>
</div>
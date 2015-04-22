<%@ include file="/common/taglibs.jsp"%>

<head>
<title><fmt:message key="rcErrorCode.title" /></title>
</head>

<div class="col-sm-2">
	<h2>
		<fmt:message key="rcErrorCode.heading" />
	</h2>
</div>
<div class="col-sm-7">
	<spring:bind path="rcErrorCode.*">
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

	<form:form commandName="rcErrorCode" method="post"
		enctype="multipart/form-data" action="/admin/saveRcErrorCode"
		id="rcErrorCodeForm" autocomplete="off" cssClass="well">
		<form:hidden path="id" />
		<div class="row">
			<div class="form-group">
				<form:input cssClass="form-control" path="errorCode" id="errorCode"
					placeholder="Code" />
			</div>
		</div>
		<div class="row">
			<div class="form-group">
				<form:textarea cssClass="form-control" path="description"
					id="description" placeholder="Description" />
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
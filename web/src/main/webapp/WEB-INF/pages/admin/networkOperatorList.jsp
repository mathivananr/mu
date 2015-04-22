<%@ include file="/common/taglibs.jsp" %>

<head>
    <title><fmt:message key="networkOperatorList.title"/></title>
</head>

<c:if test="${not empty searchError}">
    <div class="alert alert-danger alert-dismissable">
        <a href="#" data-dismiss="alert" class="close">&times;</a>
        <c:out value="${searchError}"/>
    </div>
</c:if>

<div class="col-sm-10">
    <h2><fmt:message key="networkOperatorList.heading"/></h2>

    <form method="get" action="${ctx}/admin/networkOperators" id="searchForm" class="form-inline">
    <div id="search" class="text-right">
        <span class="col-sm-9">
            <input type="text" size="20" name="q" id="query" value="${param.q}"
                   placeholder="<fmt:message key="search.enterTerms"/>" class="form-control input-sm">
        </span>
        <button id="button.search" class="btn btn-default btn-sm" type="submit">
            <i class="icon-search"></i> <fmt:message key="button.search"/>
        </button>
    </div>
    </form>

    <div id="actions" class="btn-group">
        <a class="btn btn-primary" href="<c:url value='/admin/networkOperator?method=Add&from=list'/>">
            <i class="icon-plus icon-white"></i> <fmt:message key="button.add"/></a>

        <a class="btn btn-default" href="<c:url value='/home'/>">
            <i class="icon-ok"></i> <fmt:message key="button.done"/></a>
    </div>

    <display:table name="networkOperatorList" cellspacing="0" cellpadding="0" requestURI=""
                   defaultsort="1" id="networkOperators" pagesize="25" class="table table-condensed table-striped table-hover" export="true">
        <display:column property="operatorName" escapeXml="true" sortable="true" titleKey="networkOperators.networkOperatorName" style="width: 25%"
                        url="/admin/networkOperator?from=list" paramId="id" paramProperty="id"/>
        <display:column property="operatorType" escapeXml="true" sortable="true" titleKey="networkOperators.networkOperatorType"
                        style="width: 34%"/>
        <display:column property="operatorCode" escapeXml="true" sortable="true" titleKey="networkOperators.networkOperatorCode"
        style="width: 34%"/>
        <display:column sortProperty="enabled" sortable="true" titleKey="networkOperator.enabled"
                        style="width: 16%; padding-left: 15px" media="html">
            <input type="checkbox" disabled="disabled" <c:if test="${networkOperators.enabled}">checked="checked"</c:if>/>
        </display:column>
        <display:column property="enabled" titleKey="networkOperator.enabled" media="csv xml excel pdf"/>

        <display:setProperty name="paging.banner.item_name"><fmt:message key="networkOperatorList.networkOperator"/></display:setProperty>
        <display:setProperty name="paging.banner.items_name"><fmt:message key="networkOperatorList.networkOperators"/></display:setProperty>

        <display:setProperty name="export.excel.filename" value="NetworkOperator List.xls"/>
        <display:setProperty name="export.csv.filename" value="NetworkOperator List.csv"/>
        <display:setProperty name="export.pdf.filename" value="NetworkOperator List.pdf"/>
    </display:table>
</div>

<%@ include file="/common/taglibs.jsp"%>

<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
	<div class="col-lg-offset-4 col-md-offset-4">
		<p>Click your favorite site and continue your successful shopping.</p>
	</div>
	<c:forEach var="merchantType" items="${merchantTypeList}">
		<div class="row">
			<div class="page-header">
				<h3>${merchantType.typeName}</h3>
			</div>
			<c:forEach var="merchant" items="${merchantType.merchants}">
				<div class="col-lg-2 col-md-2 col-sm-3 col-xs-4">
					<div class="thumbnail">
						<a title="${merchant.description}" href="${merchant.targetLink}"><img
							src="${merchant.logoPath}" alt="click ${merchant.merchantName} and start your booking"
							width="100%" class="slider-store-image"> </a>
					</div>
				</div>
			</c:forEach>
		</div>
		<br />
	</c:forEach>
</div>
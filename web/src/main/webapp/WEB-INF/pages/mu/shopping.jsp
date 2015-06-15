<%@ include file="/common/taglibs.jsp"%>

<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
	<div class="col-lg-offset-4 col-md-offset-4">
		<p>Click your favorite site and continue your successful shopping.</p>
	</div>
	<c:forEach var="merchantType" items="${merchantTypeList}">
		<div class="row">
			<div class="page-header">
				<h1>${merchantType.typeName}</h1>
			</div>
			<c:forEach var="merchant" items="${merchantType.merchants}">
				<div class="col-lg-2 col-md-2 col-sm-3 col-xs-12">
					<div class="thumbnail">
						<a href="${merchant.targetLink}"><img
							src="${merchant.logoPath}"
							alt="${merchant.merchantName}" width="100%" class="slider-store-image">
						</a>
					</div>
				</div>
			 </c:forEach>
		 </div>
		 <br/>
	 </c:forEach>
	<!-- <div class="col-lg-2 col-md-2 col-sm-3 col-xs-12">
		<div class="thumbnail">
			<a href="http://www.coupondunia.in/jabong?src=most_popular"><img
				src="http://cdn01.coupondunia.in/sitespecific/media/generated/merchantlogos/logo_2741ba5_395.jpg?v=1413531813"
				alt="Jabong" width="100%" class="slider-store-image"></a>
		</div>
	</div>
	<div class="col-lg-2 col-md-2 col-sm-3 col-xs-12">
		<div class="thumbnail">
			<a href="http://www.coupondunia.in/ebay?src=most_popular"><img
				src="http://cdn01.coupondunia.in/sitespecific/media/generated/merchantlogos/logo_5e29580_97.jpg?v=1413531812"
				alt="eBay" width="100%" class="slider-store-image"></a>
		</div>
	</div>
	<div class="col-lg-2 col-md-2 col-sm-3 col-xs-12">
		<div class="thumbnail">
			<a href="http://www.coupondunia.in/flipkart?src=most_popular"><img
				src="http://cdn01.coupondunia.in/sitespecific/media/generated/merchantlogos/logo_5972793_1.jpg?v=1416212070"
				alt="Flipkart" width="100%" class="slider-store-image"></a>
		</div>
	</div>
	<div class="col-lg-2 col-md-2 col-sm-3 col-xs-12">
		<div class="thumbnail">
			<a href="http://www.coupondunia.in/foodpanda?src=most_popular"><img
				src="http://cdn01.coupondunia.in/sitespecific/media/generated/merchantlogos/logo_7cc0d32_477.jpg?v=1416212583"
				alt="foodpanda" width="100%" class="slider-store-image"></a>
		</div>
	</div>
	<div class="col-lg-2 col-md-2 col-sm-3 col-xs-12">
		<div class="thumbnail">
			<a href="http://www.coupondunia.in/fabfurnish?src=most_popular"><img
				src="http://cdn01.coupondunia.in/sitespecific/media/generated/merchantlogos/logo_2dcc6fe_456.jpg?v=1416212070"
				alt="FabFurnish" width="100%" class="slider-store-image"></a>
		</div>
	</div>
	<div class="col-lg-2 col-md-2 col-sm-3 col-xs-12">
		<div class="thumbnail">
			<a href="http://www.coupondunia.in/pepperfry?src=most_popular"><img
				src="http://cdn01.coupondunia.in/sitespecific/media/generated/merchantlogos/logo_780e8ac_388.jpg?v=1421830202"
				alt="Pepperfry" width="100%" class="slider-store-image"></a>
		</div>
	</div>
	<div class="col-lg-2 col-md-2 col-sm-3 col-xs-12">
		<div class="thumbnail">
			<a href="http://www.coupondunia.in/dominos?src=most_popular"><img
				src="http://cdn01.coupondunia.in/sitespecific/media/generated/merchantlogos/logo_199d2cd_82.jpg?v=1413531812"
				alt="Dominos Pizza" width="100%" class="slider-store-image"></a>
		</div>
	</div>
	<div class="col-lg-2 col-md-2 col-sm-3 col-xs-12">
		<div class="thumbnail">
			<a href="http://www.coupondunia.in/paytm?src=most_popular"><img
				src="http://cdn01.coupondunia.in/sitespecific/media/generated/merchantlogos/logo_a5af6bd_351.jpg?v=1418892002"
				alt="Paytm" width="100%" class="slider-store-image"></a>
		</div>
	</div>
	<div class="col-lg-2 col-md-2 col-sm-3 col-xs-12">
		<div class="thumbnail">
			<a href="http://www.coupondunia.in/lenskart?src=most_popular"><img
				src="http://cdn01.coupondunia.in/sitespecific/media/generated/merchantlogos/logo_ff8c95a_237.jpg?v=1413531812"
				alt="Lenskart.com" width="100%" class="slider-store-image"></a>
		</div>
	</div>
	<div class="col-lg-2 col-md-2 col-sm-3 col-xs-12">
		<div class="thumbnail">
			<a href="http://www.coupondunia.in/snapdeal?src=most_popular"><img
				src="http://cdn01.coupondunia.in/sitespecific/media/generated/merchantlogos/logo_053b926_80.jpg?v=1416212070"
				alt="SnapDeal" width="100%" class="slider-store-image"></a>
		</div>
	</div>
	<div class="col-lg-2 col-md-2 col-sm-3 col-xs-12">
		<div class="thumbnail">
			<a href="http://www.coupondunia.in/shopclues?src=most_popular"><img
				src="http://cdn01.coupondunia.in/sitespecific/media/generated/merchantlogos/logo_3edd69e_431.jpg?v=1416212070"
				alt="ShopClues" width="100%" class="slider-store-image"></a>
		</div>
	</div> -->
</div>

<!-- <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
	<div class="page-header">
		<h1>Travel Booking</h1>
	</div>
	<div class="col-lg-2 col-md-2 col-sm-3 col-xs-12">
		<div class="thumbnail">
			<a href="http://www.coupondunia.in/amazon?src=most_popular"><img
				src="http://cdn01.coupondunia.in/sitespecific/media/generated/merchantlogos/logo_2d0d480_289.jpg?v=1413531812"
				alt="Amazon" width="100%" class="slider-store-image"></a>
		</div>
	</div>
	<div class="col-lg-2 col-md-2 col-sm-3 col-xs-12">
		<div class="thumbnail">
			<a href="http://www.coupondunia.in/jabong?src=most_popular"><img
				src="http://cdn01.coupondunia.in/sitespecific/media/generated/merchantlogos/logo_2741ba5_395.jpg?v=1413531813"
				alt="Jabong" width="100%" class="slider-store-image"></a>
		</div>
	</div>
	<div class="col-lg-2 col-md-2 col-sm-3 col-xs-12">
		<div class="thumbnail">
			<a href="http://www.coupondunia.in/ebay?src=most_popular"><img
				src="http://cdn01.coupondunia.in/sitespecific/media/generated/merchantlogos/logo_5e29580_97.jpg?v=1413531812"
				alt="eBay" width="100%" class="slider-store-image"></a>
		</div>
	</div>
	<div class="col-lg-2 col-md-2 col-sm-3 col-xs-12">
		<div class="thumbnail">
			<a href="http://www.coupondunia.in/flipkart?src=most_popular"><img
				src="http://cdn01.coupondunia.in/sitespecific/media/generated/merchantlogos/logo_5972793_1.jpg?v=1416212070"
				alt="Flipkart" width="100%" class="slider-store-image"></a>
		</div>
	</div>
	<div class="col-lg-2 col-md-2 col-sm-3 col-xs-12">
		<div class="thumbnail">
			<a href="http://www.coupondunia.in/foodpanda?src=most_popular"><img
				src="http://cdn01.coupondunia.in/sitespecific/media/generated/merchantlogos/logo_7cc0d32_477.jpg?v=1416212583"
				alt="foodpanda" width="100%" class="slider-store-image"></a>
		</div>
	</div>
	<div class="col-lg-2 col-md-2 col-sm-3 col-xs-12">
		<div class="thumbnail">
			<a href="http://www.coupondunia.in/fabfurnish?src=most_popular"><img
				src="http://cdn01.coupondunia.in/sitespecific/media/generated/merchantlogos/logo_2dcc6fe_456.jpg?v=1416212070"
				alt="FabFurnish" width="100%" class="slider-store-image"></a>
		</div>
	</div>
	<div class="col-lg-2 col-md-2 col-sm-3 col-xs-12">
		<div class="thumbnail">
			<a href="http://www.coupondunia.in/pepperfry?src=most_popular"><img
				src="http://cdn01.coupondunia.in/sitespecific/media/generated/merchantlogos/logo_780e8ac_388.jpg?v=1421830202"
				alt="Pepperfry" width="100%" class="slider-store-image"></a>
		</div>
	</div>
	<div class="col-lg-2 col-md-2 col-sm-3 col-xs-12">
		<div class="thumbnail">
			<a href="http://www.coupondunia.in/dominos?src=most_popular"><img
				src="http://cdn01.coupondunia.in/sitespecific/media/generated/merchantlogos/logo_199d2cd_82.jpg?v=1413531812"
				alt="Dominos Pizza" width="100%" class="slider-store-image"></a>
		</div>
	</div>
	<div class="col-lg-2 col-md-2 col-sm-3 col-xs-12">
		<div class="thumbnail">
			<a href="http://www.coupondunia.in/paytm?src=most_popular"><img
				src="http://cdn01.coupondunia.in/sitespecific/media/generated/merchantlogos/logo_a5af6bd_351.jpg?v=1418892002"
				alt="Paytm" width="100%" class="slider-store-image"></a>
		</div>
	</div>
</div> -->
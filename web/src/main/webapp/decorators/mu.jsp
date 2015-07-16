<%@ include file="/common/taglibs.jsp"%>
<%-- <c:redirect url="/home"/> --%>
<!DOCTYPE html>
<!--[if lt IE 7]>      <html lang="en" class="no-js lt-ie9 lt-ie8 lt-ie7"> <![endif]-->
<!--[if IE 7]>         <html lang="en" class="no-js lt-ie9 lt-ie8"> <![endif]-->
<!--[if IE 8]>         <html lang="en" class="no-js lt-ie9"> <![endif]-->
<!--[if gt IE 8]><!-->
<html lang="en" class="no-js">
<!--<![endif]-->
<head>
<!-- meta charec set -->
<meta charset="utf-8">
<!-- Always force latest IE rendering engine or request Chrome Frame -->
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<!-- Page Title -->
<title>MU</title>
<!-- Meta Description -->
<meta property="og:title"
	content="Support a software engineer tp become farmer" />
<meta property="og:image"
	content="${applicationUrl}/images/favicon.ico" />
<meta property="og:description"
	content="Your Regular expense will change someone life. Make someone dream true via Online Recharge of Prepaid Mobile, Datacard, DTH and online shopping referral" />

<meta name="description"
	content="Your Regular expense will change someone life. Make someone dream true via Online Recharge of Prepaid Mobile, Datacard, DTH and online shopping referral">
<meta name="keywords"
	content="muniyamma, munima, muniyama, online, recharge, online recharge, online shopping, shopping referral, farmer, agriculture, muniyamma recharge">
<meta name="author" content="Muniyamma">
<!-- <meta property="og:url" content="https://www.mathnuggets.com/" />
		<meta property="og:image" content="https://www.mathnuggets.com/images/fb-logo.jpg" />
		<meta property="og:title" content="Support a software engineer become formar" />
		<meta property="og:description" content="Support a software engineer become formar by recharge or shopping" /> -->
<!-- Mobile Specific Meta -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="icon" href="/images/favicon.ico" />
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/assets/v/${applicationScope.assetsVersion}/mu.css" />
<script>
		  (function(i,s,o,g,r,a,m){i['GoogleAnalyticsObject']=r;i[r]=i[r]||function(){
		  (i[r].q=i[r].q||[]).push(arguments)},i[r].l=1*new Date();a=s.createElement(o),
		  m=s.getElementsByTagName(o)[0];a.async=1;a.src=g;m.parentNode.insertBefore(a,m)
		  })(window,document,'script','//www.google-analytics.com/analytics.js','ga');
	
		  ga('create', 'UA-64946971-1', 'auto');
		  ga('send', 'pageview');
	
		</script>
</head>

<body id="body">
	<input type="hidden" id="active-menu" value="${activeMenu}">
	<!-- preloader -->
	<div id="preloader">
		<img src="/images/core/preloader.gif" alt="Preloader">
	</div>
	<!-- end preloader -->

	<!-- 
        Fixed Navigation
        ==================================== -->
	<!-- <header id="navigation" class="navbar-fixed-top navbar">
            <div class="container">
                <div class="navbar-header">
                    responsive nav button
					<button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                        <span class="sr-only">Toggle navigation</span>
                        <i class="fa fa-bars fa-2x"></i>
                    </button>
					/responsive nav button
					
					logo
                    <a class="navbar-brand" href="#body">
						<h1 id="logo">
							<img src="images/core/logo.png" alt="Brandi">
						</h1>
					</a>
					/logo
                </div>

				main nav
                <nav class="collapse navbar-collapse navbar-right" role="navigation">
                    <ul id="nav" class="nav navbar-nav">
                        <li class="current"><a href="#body">Home</a></li>
                        <li><a href="#features">Features</a></li>
                        <li><a href="#works">Work</a></li>
                        <li><a href="#team">Team</a></li>
                        <li><a href="#contact">Contact</a></li>
                    </ul>
                </nav>
				/main nav
				
            </div>
        </header> -->
	<!--
        End Fixed Navigation
        ==================================== -->
	<div class="pull-right right-strap">
		<img alt="beta version" src="/images/beta.png" height="70" width="70" />
	</div>
	<!--
        Our Works
        ==================================== -->
	<section id="works" class="works clearfix">
		<div class="container">
			<div class="row">
				<div class="sec-title text-center">
					<small> support 180 days from start </small>
					<h2>
						<span id="clock">Coming Soon</span>
					</h2>
					<div class="devider">
						<i class="fa fa-heart-o fa-lg"></i>
					</div>
				</div>

				<div class="sec-sub-title text-center">
					<p>
						Your regular expense may change someone's life. <a
							class="link-color" title="how story link" href="${applicationUrl}/story">How?</a>
					</p>
				</div>
				<div class="row text-center">
					<!-- Facebook -->
					<a href="javascript:void(0);"
						onclick="return window.open(
        'http://www.facebook.com/sharer.php?s=100&p[title]=Muniyamma&p[summary]=Support a software engineer become farmer by recharge or shopping &p[url]=${applicationUrl}/story&p[images][0]=${applicationUrl}/images/favicon.ico',
        'facebook-share-dialog',
        'width=626,height=436');"
						title="Share on Facebook" class="btn btn-facebook"><i
						class="fa fa-facebook"></i> Facebook</a>
					<!-- Twitter -->
					<a href="javascript:tweetWindow()" title="Share on Twitter"
						class="btn btn-twitter"><i class="fa fa-twitter"></i> Twitter</a>
					<!-- Google+ -->

					<a
						onclick="javascript:window.open('https://plus.google.com/share?url=${applicationUrl}/story','',
  'menubar=no,toolbar=no,resizable=yes,scrollbars=yes,height=600,width=600');
  return false;"
						title="Share on Google+" class="btn btn-googleplus"><i
						class="fa fa-google-plus"></i> Google+</a>
				</div>
				<hr />
				<div class="work-filter wow fadeInRight animated"
					data-wow-duration="500ms">
					<ul class="text-center">
						<li><a title="recharge menu" id="recharge-link"
							href="${applicationUrl}/rechargeForm" class="active filter">Recharge</a></li>
						<li><a title="shopping menu" id="shopping-link"
							href="${applicationUrl}/shopping" class="filter">Shopping</a></li>
						<li><a title="advise menu" id="advise-link" href="${applicationUrl}/advise"
							class="filter">Advise</a></li>
						<!-- <li><a id="video-link" href="/video" class="filter">Video</a></li> -->
						<li><a title="vote menu" id="vote-link" href="${applicationUrl}/vote"
							class="filter">Vote</a></li>
						<li><a title="story menu" id="about-link" href="${applicationUrl}/story"
							class="filter">Story</a></li>
					</ul>
				</div>
			</div>
		</div>
		<div class="project-wrapper">
			<div class="container">
				<%@ include file="/common/messages.jsp"%>
				<div class="row mb50" id="main-content">
					<decorator:body />
				</div>
			</div>
		</div>
	</section>
	<!--
        End Our Works
        ==================================== -->

	<footer id="footer" class="footer">
		<div class="container">
			<div class="col-md-3 col-sm-6 col-xs-12">
				<div class="row">
					<div class="footer-single">
						<!-- <img src="images/core/footer-logo.png" alt=""> -->
						<h2>
							<a title="muniyamma home" href="${applicationUrl}">Muniyamma</a>
						</h2>
						<!-- <p class="col-md-8 col-sm-9 col-xs-9 pull-right">Define Soon.</p> -->
					</div>
				</div>
			</div>
			<div class="col-md-9 col-sm-6 col-xs-12">
				<div class="row">
					<div class="text-center">
						<a title="about menu" href="${applicationUrl}/site/about">About</a> |
						<a title="contact menu" href="${applicationUrl}/site/contact">Contact</a> |
						<a title="terms and conditions menu"
							href="${applicationUrl}/site/termsAndConditions">Terms and
							Conditions</a> | <a title="privacy policy menu"
							href="${applicationUrl}/site/privacyPolicy">Privacy Policy</a> |
						<a title="faq menu" href="${applicationUrl}/site/faq">FAQ</a> | 
						<a title="recharge complaints menu"
							href="${applicationUrl}/site/supportRequest">Recharge
							Complaints</a>
					</div>
				</div>
				<div class="row">
					<p class="text-center">
						Copyright <i class="fa fa-copyright"></i> 2015 <a
							title="copy rights" href="${applicationUrl}/">Muniyamma</a>. All rights
						reserved. Designed & developed by <a title="developed by"
							href="${applicationUrl}/">Muniyamma</a>
					</p>
				</div>
			</div>
		</div>
	</footer>

	<a href="javascript:void(0);" id="back-top"><i
		class="fa fa-angle-up fa-3x"></i></a>

	<!-- Essential jQuery Plugins
		================================================== -->
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/assets/v/${applicationScope.assetsVersion}/mu.js"></script>
	<script>
			var wow = new WOW ({
				boxClass:     'wow',      // animated element css class (default is wow)
				animateClass: 'animated', // animation css class (default is animated)
				offset:       120,          // distance to the element when triggering the animation (default is 0)
				mobile:       false,       // trigger animations on mobile devices (default is true)
				live:         true        // act on asynchronously loaded content (default is true)
			  }
			);
			wow.init();
		</script>
</body>
</html>

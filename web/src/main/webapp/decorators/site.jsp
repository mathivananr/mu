<%@ include file="/common/taglibs.jsp"%>
<%-- <c:redirect url="/home"/> --%>
<!DOCTYPE html>
<!--[if lt IE 7]>      <html lang="en" class="no-js lt-ie9 lt-ie8 lt-ie7"> <![endif]-->
<!--[if IE 7]>         <html lang="en" class="no-js lt-ie9 lt-ie8"> <![endif]-->
<!--[if IE 8]>         <html lang="en" class="no-js lt-ie9"> <![endif]-->
<!--[if gt IE 8]><!--> <html lang="en" class="no-js"> <!--<![endif]-->
    <head>
    	<!-- meta charec set -->
        <meta charset="utf-8">
		<!-- Always force latest IE rendering engine or request Chrome Frame -->
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
		<!-- Page Title -->
        <title>MU</title>		
		<!-- Meta Description -->
        <meta name="description" content="Your Regular expense will change someone life. Make someone dream true via Online Recharge of Prepaid Mobile, Datacard, DTH and online shopping referral">
        <meta name="keywords" content="muniyamma, munima, muniyama, online, recharge, online recharge, online shopping, shopping referral, farmer, agriculture">
        <meta name="author" content="Muniyamma">
		<!-- Mobile Specific Meta -->
        <meta name="viewport" content="width=device-width, initial-scale=1">
		
		<!-- Google Font -->
		
		<!-- <link href='http://fonts.googleapis.com/css?family=Open+Sans:400,300,600,700,800' rel='stylesheet' type='text/css'> -->

		<!-- CSS
		================================================== -->
		<!-- Fontawesome Icon font -->
        <link rel="stylesheet" href="/styles/core/font-awesome.min.css">
		<!-- Twitter Bootstrap css -->
        <link rel="stylesheet" href="/styles/core/bootstrap.min.css">
		<!-- jquery.fancybox  -->
        <link rel="stylesheet" href="/styles/core/jquery.fancybox.css">
		<!-- animate -->
        <link rel="stylesheet" href="/styles/core/animate.css">
		<!-- Main Stylesheet -->
        <link rel="stylesheet" href="/styles/core/main.css">
        <!-- timeline Stylesheet -->
        <link rel="stylesheet" href="/styles/core/timeline.css">
		<!-- media-queries -->
        <link rel="stylesheet" href="/styles/core/media-queries.css">

		<!-- Modernizer Script for old Browsers -->
        <script src="/scripts/core/modernizr-2.6.2.min.js"></script>

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
				
        <!--
        Our Works
        ==================================== -->
		
		<section id="works" class="works clearfix">
			<div class="project-wrapper">
				<div class="container">
					<%@ include file="/common/messages.jsp" %>
					<div class="row mb50" id="main-content">
						<decorator:body/>
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
							<h2><a href="/">Muniyamma</a></h2>
							<p class="col-md-8 col-sm-9 col-xs-9 pull-right">Define Soon.</p>
						</div>
					</div>
				
					<!-- <div class="col-md-3 col-sm-6 col-xs-12 wow fadeInUp animated" data-wow-duration="500ms" data-wow-delay="300ms">
						<div class="footer-single">
							<h6>Subscribe </h6>
							<form action="#" class="subscribe">
								<input type="text" name="subscribe" id="subscribe">
								<input type="submit" value="&#8594;" id="subs">
							</form>
						</div>
					</div> -->
				</div>
				<div class="col-md-9 col-sm-6 col-xs-12">
					<div class="row">
						<div class="text-center">
							<!-- <h6>Support</h6> -->
							<a href="/site/about">About</a> |
							<a href="/site/contact">Contact Us</a> |
							<a href="/site/termsAndConditions">Terms and Conditions</a> |
							<a href="/site/privacyPolicy">Privacy Policy</a>
							<!-- <ul>
								<li><a href="/site/contact">Contact Us</a></li>
								<li><a href="/site/termsAndConditions">Terms and Conditions</a></li>
								<li><a href="/site/privacyPolicy">Privacy Policy</a></li>
							</ul> -->
						</div>
					</div>
					<div class="row">
						<p class="text-center">
							Copyright © 2015 <a href="http://muniyamma.com/">Muniyamma</a>. All rights reserved. Designed & developed by <a href="http://muniyamma.com/">Muniyamma</a>
						</p>
					</div>
				</div>
			</div>
		</footer>
		
		<a href="javascript:void(0);" id="back-top"><i class="fa fa-angle-up fa-3x"></i></a>

		<!-- Essential jQuery Plugins
		================================================== -->
		<!-- Main jQuery -->
        <script src="/scripts/core/jquery-1.11.1.min.js"></script>
		<!-- Single Page Nav -->
        <script src="/scripts/core/jquery.singlePageNav.min.js"></script>
		<!-- Twitter Bootstrap -->
        <script src="/scripts/core/bootstrap.min.js"></script>
		<!-- jquery.fancybox.pack -->
        <script src="/scripts/core/jquery.fancybox.pack.js"></script>
		<!-- jquery.mixitup.min -->
        <script src="/scripts/core/jquery.mixitup.min.js"></script>
		<!-- jquery.parallax -->
        <script src="/scripts/core/jquery.parallax-1.1.3.js"></script>
		<!-- jquery.countTo -->
        <script src="/scripts/core/jquery-countTo.js"></script>
		<!-- jquery.appear -->
        <script src="/scripts/core/jquery.appear.js"></script>
		<!-- Contact form validation -->
		<!-- <script src="http://cdnjs.cloudflare.com/ajax/libs/jquery.form/3.32/jquery.form.js"></script>
		<script src="http://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.11.1/jquery.validate.min.js"></script> -->
		<!-- Google Map -->
        <!-- <script type="text/javascript" src="http://maps.googleapis.com/maps/api/js?sensor=false"></script> -->
		<!-- jquery easing -->
        <script src="/scripts/core/jquery.easing.min.js"></script>
		<!-- jquery easing -->
        <script src="/scripts/core/wow.min.js"></script>
        <script src="/scripts/core/jquery.countdown.js"></script>
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
		<!-- Custom Functions -->
        <script src="/scripts/core/custom.js"></script>
    </body>
</html>

/* ========================================================================= */
/*	Preloader
 /* ========================================================================= */

jQuery(window).load(function() {

	$("#preloader").fadeOut("slow");

});

$(document)
		.ready(
				function() {

					/* ========================================================================= */
					/*
					 * Menu item highlighting /*
					 * =========================================================================
					 */

					jQuery('#nav').singlePageNav({
						offset : jQuery('#nav').outerHeight(),
						filter : ':not(.external)',
						speed : 1200,
						currentClass : 'current',
						easing : 'easeInOutExpo',
						updateHash : true,
						beforeStart : function() {
							console.log('begin scrolling');
						},
						onComplete : function() {
							console.log('done scrolling');
						}
					});

					/*
					 * $(window).scroll(function () { if ($(window).scrollTop() >
					 * 400) {
					 * $("#navigation").css("background-color","#0EB493"); }
					 * else { $("#navigation").css("background-color","rgba(16,
					 * 22, 54, 0.2)"); } });
					 */

					/* ========================================================================= */
					/*
					 * Fix Slider Height /*
					 * =========================================================================
					 */

					var slideHeight = $(window).height();

					$(
							'#slider, .carousel.slide, .carousel-inner, .carousel-inner .item')
							.css('height', slideHeight);

					$(window)
							.resize(
									function() {
												'use strict',
												$(
														'#slider, .carousel.slide, .carousel-inner, .carousel-inner .item')
														.css('height',
																slideHeight);
									});

					/* ========================================================================= */
					/*
					 * Portfolio Filtering /*
					 * =========================================================================
					 */

					// portfolio filtering
					$(".project-wrapper").mixItUp();

					$(".fancybox").fancybox({
						padding : 0,

						openEffect : 'elastic',
						openSpeed : 650,

						closeEffect : 'elastic',
						closeSpeed : 550,

						closeClick : true,
					});

					/* ========================================================================= */
					/*
					 * Parallax /*
					 * =========================================================================
					 */

					$('#facts').parallax("50%", 0.3);

					/* ========================================================================= */
					/*
					 * Timer count /*
					 * =========================================================================
					 */

					"use strict";
					$(".number-counters").appear(function() {
						$(".number-counters [data-to]").each(function() {
							var e = $(this).attr("data-to");
							$(this).delay(6e3).countTo({
								from : 50,
								to : e,
								speed : 3e3,
								refreshInterval : 50
							})
						})
					});

					/* ========================================================================= */
					/*
					 * Back to Top /*
					 * =========================================================================
					 */

					$(window).scroll(function() {
						if ($(window).scrollTop() > 400) {
							$("#back-top").fadeIn(200)
						} else {
							$("#back-top").fadeOut(200)
						}
					});
					$("#back-top").click(function() {
						$("html, body").stop().animate({
							scrollTop : 0
						}, 1500, "easeInOutExpo")
					});

					$('#clock').countdown('2015/5/10', function(event) {
						// $(this).html(event.strftime('%D days left
						// %H:%M:%S'));
					});

					/* ========================================================================= */
					/*
					 * Active Menu item highlighting /*
					 * =========================================================================
					 */
					$('#' + $('#active-menu').val()).addClass('active');
					/***********************************************************
					 * Activate Pop over
					 */
					$('[data-toggle="popover"]').popover({
						trigger : 'hover'
					})
				});

// ========== START GOOGLE MAP ========== //
function initialize() {
	var myLatLng = new google.maps.LatLng(22.402789, 91.822156);

	var mapOptions = {
		zoom : 14,
		center : myLatLng,
		disableDefaultUI : true,
		scrollwheel : false,
		navigationControl : false,
		mapTypeControl : false,
		scaleControl : false,
		draggable : false,
		mapTypeControlOptions : {
			mapTypeIds : [ google.maps.MapTypeId.ROADMAP, 'roadatlas' ]
		}
	};

	var map = new google.maps.Map(document.getElementById('map_canvas'),
			mapOptions);

	var marker = new google.maps.Marker({
		position : myLatLng,
		map : map,
		icon : 'img/location-icon.png',
		title : '',
	});

}

// google.maps.event.addDomListener(window, "load", initialize);
// ========== END GOOGLE MAP ========== //

$("#postAdvise").click(function() {
	postAdvise();
});

// post advise
function postAdvise() {
	// get the form values
	var adviserName = $('#adviserName').val();
	var email = $('#email').val();
	var description = $('#description').val();

	$
			.ajax({
				type : "POST",
				url : "/postAdvise",
				data : "adviserName=" + adviserName + "&email=" + email
						+ "&description=" + description,
				success : function(response) {
					// we have the response
					if (response.status == "SUCCESS") {
						var adviseHtml = '<div class="row"><div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">'
								+ '<h4><strong>'
								+ $('#adviserName').val()
								+ '</strong></h4>'
								+ '<p class="pad-10">'
								+ $('#description').val()
								+ '</p>'
								+ '</div></div><hr/>';
						$('#advise-list').prepend(adviseHtml);
						$('#adviseModal').modal('hide');
					} else {
						//console.log("Error: " + response);
					}
				},
				error : function(e) {
					//console.log('Error: ' + e);
				}
			});
}

$("#collapseAdvise").click(function() {
	getAdvise('');
});

$("#adviseEditLink").click(function() {
	/*
	 * alert($(this).attr('data-id')); getAdvise($(this).attr('data-id'));
	 */
});

function getAdvise(adviseId) {
	$
			.ajax({
				type : "GET",
				url : "/getAdvise",
				data : "adviseId=" + adviseId,
				success : function(response) {
					if (response.status == "SUCCESS") {
						if (adviseId != undefined && adviseId != null
								&& adviseId != '') {
							$('.collapse').collapse()
							$('#adviseId').val(response.result.id);
							$('#adviserName').val(response.result.adviserName);
							$('#adviserEmail').val(response.result.email);
							$('#adviseDescription').val(
									response.result.description);
						}
					} else {
						//console.log("Error: " + response);
					}
				},
				error : function(e) {
					//console.log('Error: ' + e);
				}
			});
}

var tweetWindow = function() {
	window
			.open(
					"http://twitter.com/share?url="
							+ encodeURIComponent("http://www.muniyamma.com/story")
							+ "&text="
							+ encodeURIComponent("Support a software engineer to become farmer.  @wemuniyamma #muniyamma")
							+ "&count=none/", "tweet",
					"height=300,width=550,resizable=1")
}

$('#paymentTabs a').click(function(e) {
	e.preventDefault()
	$(this).tab('show')
});

function getOperator() {
	if ($("#rechargeType").val() == "mobile") {
		var number = $("#phoneNumber").val();
		if (number.length == 4) {
			$.ajax({
				type : "GET",
				url : "/getOperator",
				data : "number=" + number,
				success : function(response) {
					if (response.networkOperator != undefined
							&& response.networkOperator != null
							&& response.networkOperator != '') {
						$('#mobileOperator').val(
								response.networkOperator.operatorCode);
						$('#operatorFinderCode').val(
								response.networkOperator.operatorFinderCode);
						$('#circleCode').val(response.circleCode);
						if (response.enableSpecial != undefined
								&& response.enableSpecial != null
								&& response.enableSpecial == true
								|| response.enableSpecial == 'true') {
							$('#specialRechargeDiv').removeClass('hidden');
						} else {
							$('#isSpecialRecharge').prop('checked', false);
							$('#specialRechargeDiv').addClass('hidden');
						}
					} else {
						//console.log("Error: " + response);
					}
				},
				error : function(e) {
					//console.log('Error: ' + e);
				}
			});
		}
	}
}

$('#isSpecialRecharge').change(
	function() {
		if ($(this).is(":checked")) {
			var newOperator = $('#mobileOperator').val() + 'S';
			if ($("#mobileOperator option[value='" + newOperator
					+ "']").length > 0) {
				$('#mobileOperator').val(newOperator);
			}
		} else {
			var operator = $('#mobileOperator').val();
			operator = operator.substring(0, operator.length - 1);
			if ($("#mobileOperator option[value='" + operator
					+ "']").length > 0) {
				$('#mobileOperator').val(operator);
			}
		}
	});

$('#mobileOperator').change(function() {
	$('#operatorFinderCode').val('');
	$('#circleCode').val('');
	var operator = $('#mobileOperator').val();
	var newOperator = operator + 'S';
	if(operator.slice(-1) == 'S') {
		operator = operator.substring(0, operator.length - 1);
		if ($("#mobileOperator option[value='" + operator
				+ "']").length > 0) {
			console.log(1);
			$('#isSpecialRecharge').prop('checked', true);
			$('#specialRechargeDiv').removeClass('hidden');
		}
	} else if($("#mobileOperator option[value='" + newOperator
				+ "']").length > 0) {
			console.log(1);
			$('#specialRechargeDiv').removeClass('hidden');
			$('#isSpecialRecharge').prop('checked', false);
	} else {
		$('#isSpecialRecharge').prop('checked', false);
		$('#specialRechargeDiv').addClass('hidden');
	}
});

$('a').click(
		function(e) {
			var link = $(this).attr('href');
			var title = $(this).attr('title');
			//console.log(link + ":: " + title);
			if (title != undefined && title != null && title != ''
					&& link != undefined && link != null && link != '') {
				$.ajax({
					type : "GET",
					url : "/log",
					data : "title=" + title + "&link=" + link,
					success : function(response) {
						//console.log("success");
					},
					error : function(e) {
						//console.log('Error: ' + e);
					}
				});
		}
});
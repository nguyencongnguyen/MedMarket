$(document).ready(function() {
	$("#productImage").attr("src", $(".imageUrl").first().val());
	$(".imageView").click(function() {
		$("#productImage").attr("src", $(this).next().val());
	});
	if ($("#similar ul li").size() > 6) {
		$("#similar").jCarouselLite({
			btnPrev: $(".prev"),
			btnNext: $(".next"),
		    visible: 6
		});
	} else {
		 $(".prev").hide();
		 $(".next").hide();
	}
});
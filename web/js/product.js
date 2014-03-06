$(document).ready(function() {
	$("#productImage").attr("src", $(".imageUrl").first().val());
	$(".imageView").click(function() {
		$("#productImage").attr("src", $(this).next().val());
	});
	
	$("#similar").jCarouselLite({
		btnPrev: $(".prev"),
		btnNext: $(".next"),
	    visible: 6
	});
});
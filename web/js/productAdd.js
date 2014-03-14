$(document).ready(function() {
	if ($(".upload").attr("disabled") == "disabled") {
		$(".upload").attr("disabled", "");
	}
    $("#createForm").validate({
        rules: {
            username: {
                required: true
            },
            password: {
                required: true
            },
            repassword: {
                required: true,
                equalTo: "#password"
            },
            contactName: {
                required: true
            },
            contactPhone: {
                required: true,
                digits: true
            },
            contactEmail: {
                required: true,
                email: true
            },
            name: {
                required: true
            },
            price: {
                digits: true
            },
            description: {
                required: true
            },
            image: {
                required: true
            },
            uploadedImages: {
            	required: true
            }, 
			accept: {
				required: true
			}
        },
        messages: {
            username: {
                required: "Vui lòng nhập email"
            },
            password: {
                required: "Vui lòng nhập mật khẩu"
            },
            repassword: {
                required: "Vui lòng nhập lại mật khẩu",
                equalTo: "Mật khẩu nhập lại không đúng"
            },
            contactName: {
                required: "Vui lòng nhập tên"
            },
            contactPhone: {
                required: "Vui lòng nhập số điện thoại",
                digits: "Số điện thoại không đúng"
            },
            contactEmail: {
            	required: "Vui lòng nhập email",
            	email: "Email không hợp lệ"
            },
            name: {
                required: "Vui lòng nhập tên sản phẩm"
            },
            price: {
                required: "Giá sản phẩm không hợp lệ"
            },
            description: {
                required: "Vui lòng nhập mô tả sản phẩm"
            },
            image: {
                required: "Vui lòng đăng ít nhất 1 hình ảnh về sản phẩm"
            },
            uploadedImages: {
            	required: "Bạn cần phải đăng ít nhất 1 hình ảnh của sản phẩm"
            },
			accept: "Bạn phải đồng ý với các điều khoản"
        },
        submitHandler: function(form) {
        	$(".upload").attr("disabled", "disabled");
            form.submit();
        },
        ignore: []
    });

    $("#uploadImage").on("change", ".upload", function(){
    	$('.loading').unbind('ajaxStart');
    	$('.loading').unbind('ajaxComplete');
        $(this).next().next().ajaxStart(function(){
            $(this).show();
        }).ajaxComplete(function(){
            $(this).hide();
            $(this).prev().show();
            $(this).prev().prev().hide();
            $(this).next().show();
        });
        var fileNameContainer = $(this).parent().find("span");
        $.ajaxFileUpload( {
            url:'/home/ajaxUploadImg',
            secureuri:false,
            fileElementId: $(this).attr("id"),
            dataType: 'json',
            success: function (data, status) {
            	$("#uploadedImages").val($("#uploadedImages").val() + data.url + ",");
            	fileNameContainer.html(data.url);
            	$(this).replaceWith('<input type="file" id="' + $(this).attr("id") + '" name="fileToUpload" class="upload" />');
            }
        });
        return false;
    });
    
    $(".delUpload").click(function() {
    	var name = $(this).parent().find("span").html() + ",";
    	$(this).parent().find("span").hide();
    	$(this).hide();
    	var value = $("#uploadedImages").val();
    	value = value.replace(name,"");
    	$("#uploadedImages").val(value);
    	var control = $(this).parent().find("input");
    	control.show();
    });
    
    var uploadedImages = $("#uploadedImages").val();
    if (uploadedImages != "") {
    	var images = uploadedImages.split(",");
    	for (var i=1; i<=images.length; i++) {
    		if(images[i-1] != "") {
    			$("#imageName" + i).html(images[i-1]);
	    		$("#image" + i).find(".uploaded").show();
	    		$("#image" + i).find(".upload").hide();
    		}
    	}
    }
    
    $("#viewRules").click(function() {
		$("#rules").slideDown();
	});
});
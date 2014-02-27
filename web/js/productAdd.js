$(document).ready(function() {
    $("#loginForm").validate({
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
            }
        },
        submitHandler: function(form) {
            form.submit();
        }
    });

    function ajaxFileUpload() {
        $("#loading").ajaxStart(function(){
            $(this).show();
        }).ajaxComplete(function(){
            $(this).hide();
        });
        $.ajaxFileUpload( {
            url:'doajaxfileupload.php',
            secureuri:false,
            fileElementId:'fileToUpload',
            dataType: 'json',
            success: function (data, status) {
                if(typeof(data.error) != 'undefined') {
                    if(data.error != '') {
                        alert(data.error);
                    } else {
                        alert(data.msg);
                    }
                }
            },
            error: function (data, status, e) {
                alert(e);
            }
        });
        return false;
    }
});
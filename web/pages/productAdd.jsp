<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<link href="<%= request.getContextPath() %>/css/jquery-ui.css" rel="stylesheet" type="text/css"/>
<script type="text/javascript" src="<%= request.getContextPath() %>/js/jquery.validate.min.js"></script>

<script type="text/javascript">

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
				required: "Giá sản phẩm không đúng"
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
});
</script>
<div class="content">
<h2>Đăng sản phẩm</h2>
<s:form action="/home/postProduct" method="post" id="loginForm">
<div class="error"><s:actionmessage /></div>
<div class="left">
    <h2>Mật khẩu (sử dụng để cập nhật/xóa tin khi cần)</h2>
    <div><span class="requried">*</span>Mật khẩu</div>
    <div><s:password name="password" id="password" /></div>
    <div><span class="requried">*</span>Nhập lại mật khẩu</div>
    <div><s:password name="repassword" id="repassword" /></div>
    <h2>Thông tin liên hệ</h2>
    <div><span class="requried">*</span>Tên</div>
    <div><s:textfield name="contactName" id="contactName" /></div>
    <div><span class="requried">*</span>Điện thoại</div>
    <div><s:textfield name="contactPhone" id="contactPhone" /></div>
    <div><span class="requried">*</span>Email</div>
    <div><s:textfield name="contactEmail" id="contactEmail" /></div>
    <div>Địa chỉ</div>
    <div><s:textfield name="contactAddress" id="contactAddress" /></div>
</div>
<div class="left divider">
</div>
<div class="left description">
    <h2>Thông tin sản phẩm</h2>
	<div><span class="requried">*</span>Tên sản phẩm</div>
	<div><s:textfield name="name" id="name" /></div>
	<div>Giá (để trống nếu muốn báo giá sản phẩm khi người mua liên hệ)</div>
	<div><s:textfield name="price" id="price" /></div>
    <div><span class="requried">*</span>Loại sản phẩm</div>
    <div><s:select list="categories" name="catId" id="catId" listKey="catId" listValue="name"></s:select></div>
    <div><span class="requried">*</span>Nơi mua bán</div>
    <div><s:select list="provinces" name="provinceId" id="provinceId" listKey="provinceId" listValue="name"></s:select></div>
    <div><span class="requried">*</span>Thông tin mô tả sản phẩm</div>
    <div><s:textarea name="description" id="description"></s:textarea></div>
    <div><span class="requried">*</span>Hình ảnh</div>
	<div></div>
	<div><input type="submit" value="Đăng sản phẩm"  /></div>
	<br/>
  	<span class="requried">*</span> Thông tin bắt buộc nhập
</div>
</s:form>
</div>
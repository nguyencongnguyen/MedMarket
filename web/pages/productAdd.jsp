<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<link href="<%= request.getContextPath() %>/css/jquery-ui.css" rel="stylesheet" type="text/css"/>
<script type="text/javascript" src="<%= request.getContextPath() %>/js/jquery.validate.min.js"></script>
<script type="text/javascript" src="<%= request.getContextPath() %>/js/productAdd.js"></script>
<script type="text/javascript" src="<%= request.getContextPath() %>/js/ajaxfileupload.js"></script>
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
    <div><span class="requried">*</span>Phạm vi giao dịch</div>
    <div><s:select list="provinces" name="provinceId" id="provinceId" listKey="provinceId" listValue="name"></s:select></div>
    <div><span class="requried">*</span>Thông tin mô tả sản phẩm</div>
    <div><s:textarea name="description" id="description"></s:textarea></div>
    <div><span class="requried">*</span>Hình ảnh</div>
    <div><input type="file" id="fileToUpload" name="fileToUpload" />
    <input type="hidden" name="uploadedImages" /></div>
	<div></div>
	<div><input type="submit" value="Đăng sản phẩm"  /></div>
	<br/>
  	<span class="requried">*</span> Thông tin bắt buộc nhập
</div>
</s:form>
</div>
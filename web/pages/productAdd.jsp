<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<link href="<%= request.getContextPath() %>/css/jquery-ui.css" rel="stylesheet" type="text/css"/>
<script type="text/javascript" src="<%= request.getContextPath() %>/js/jquery.validate.min.js"></script>
<script type="text/javascript" src="<%= request.getContextPath() %>/js/productAdd.js"></script>
<script type="text/javascript" src="<%= request.getContextPath() %>/js/ajaxfileupload.js"></script>
<div class="content">
<h2>Đăng sản phẩm</h2>
<s:form action="/home/postProduct" method="post" id="createForm">
<div class="error"><s:actionmessage /></div>
<div class="left">
    <div><span class="requried">*</span>Mật khẩu (sử dụng để cập nhật/xóa tin)</div>
    <div><s:password name="password" id="password" /></div>
    <div><span class="requried">*</span>Nhập lại mật khẩu</div>
    <div><s:password name="repassword" id="repassword" /></div>
    <h3>Thông tin liên hệ</h3>
    <div><span class="requried">*</span>Tên</div>
    <div><s:textfield name="contactName" id="contactName" /></div>
    <div><span class="requried">*</span>Điện thoại</div>
    <div><s:textfield name="contactPhone" id="contactPhone" /></div>
    <div><span class="requried">*</span>Email</div>
    <div><s:textfield name="contactEmail" id="contactEmail" /></div>
    <div>Địa chỉ</div>
    <div><s:textfield name="contactAddress" id="contactAddress" /></div>
    <br/>
    <span class="requried">*</span> Thông tin bắt buộc nhập<br/><br/>
</div>
<div class="left divider">
</div>
<div class="left description">
    <h3>Thông tin sản phẩm</h3>
	<div><span class="requried">*</span>Tên sản phẩm</div>
	<div><s:textfield name="name" id="name" /></div>
	<div>Giá (để trống nếu muốn báo giá sản phẩm khi người mua liên hệ)</div>
	<div><s:textfield name="price" id="price" /></div>
    <div><span class="requried">*</span>Loại sản phẩm</div>
    <div><s:select list="categories" name="catId" id="catId" listKey="catId" listValue="name"></s:select></div>
    <div><span class="requried">*</span>Phạm vi giao dịch</div>
    <div><s:select list="provinces" name="provinceId" id="provinceId" listKey="provinceId" listValue="name"></s:select></div>
    <div><br/><span class="requried">*</span>Thông tin mô tả sản phẩm</div>
    <div><s:textarea name="description" id="description" rows="7" cols="50" maxlength="4000"></s:textarea></div>
    <div><span class="requried">*</span>Hình ảnh</div>
    <div><input type="file" id="fileToUpload" name="fileToUpload" /><input type="button" value="up" id="upload"/>
    <input type="hidden" id="uploadedImages" name="uploadedImages" /></div>
	<div></div>
	<div><input type="submit" value="Đăng sản phẩm"  /></div>
	<br/>
  	
</div>
</s:form>
</div>
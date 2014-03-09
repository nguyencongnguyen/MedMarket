<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
</head>

<body>
<div style="width: 940px; height: 80px; text-align: center; margin-top: 100px;">
	<s:if test="msgId == 1">
		<h3>Rao vặt sản phẩm của bạn đang chờ kiểm duyệt, sản phẩm của bạn sẽ được đăng trên website ngay khi quá trình kiểm duyệt hoàn tất.</h3>
	    <br/>Bạn muốn <a href="/home/addProduct">tiếp tục đăng tin rao vặt sản phẩm?</a>
    </s:if>
    <s:if test="msgId == 2">
		<h3>Mật khẩu đã được gửi qua email, vui lòng kiểm tra email.</h3>
    </s:if>
    <s:if test="msgId == 3">
		<h3>Cập nhật sản phẩm thành công.</h3>
	    <br/>Bạn muốn <a href="/home/addProduct">đăng thêm sản phẩm khác?</a>
    </s:if>
    <s:if test="msgId == 4">
		<h3>Sản phẩm đã được xóa thành công.</h3>
	    <br/>Bạn muốn <a href="/home/addProduct">đăng sản phẩm khác?</a>
    </s:if>
</div>
</body>
</html>
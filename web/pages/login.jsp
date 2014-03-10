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
			}
		},
		messages: {
			username: {
				required: "Vui lòng nhập tên đăng nhập"
			},
			password: {
				required: "Vui lòng nhập mật khẩu"
			}
		},
	 	submitHandler: function(form) {
	 		form.submit();
	 	}
	});
});
</script>
<div class="content">		
<h2>Đăng nhập</h2>

<div class="error"><s:actionmessage /></div>
<div class="left">
<s:form action="/home/loginSubmit" method="post" id="loginForm">  
	<div><span class="requried">*</span>Tên đăng nhập</div>
	<div><s:textfield name="username" id="username" /></div>
	<div><span class="requried">*</span>Mật khẩu</div>
	<div><s:password name="password" id="password" /></div>
	<div></div>
	<div><input type="submit" value="Đăng nhập"  />
	</div>
	<br/>
  	<span class="requried">*</span> Thông tin bắt buộc nhập
</s:form>

</div>
<div class="left divider">
</div>
<div class="left description">
</div>
</div>
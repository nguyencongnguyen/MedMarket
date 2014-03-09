<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<link href="<%= request.getContextPath() %>/css/jquery-ui.css" rel="stylesheet" type="text/css"/>
<script type="text/javascript" src="<%= request.getContextPath() %>/js/jquery.validate.min.js"></script> 

<script type="text/javascript">

$(document).ready(function() {
	$("#emailForm").validate({
		rules: {
			contactEmail: {
				required: true
			}
		},
		messages: {
			contactEmail: {
				required: "Vui lòng nhập mật khẩu"
			}
		},
	 	submitHandler: function(form) {
	 		form.submit();
	 	}
	});
	$("#passForm").validate({
		rules: {
			password: {
				required: true
			}
		},
		messages: {
			password: {
				required: "Vui lòng nhập mật khẩu"
			}
		},
	 	submitHandler: function(form) {
	 		form.submit();
	 	}
	});
	
	$("#forgotPass").click(function() {
		$(".forgotForm").show();
	});
	
	if ($("#errorForgot").html() != "" && $("#errorForgot").html().indexOf("email") > 0) {
		$(".forgotForm").show();
		$("#passError").hide();
	}
});
</script>
<div class="left">
	<h3>Xác nhận mật khẩu</h3>
	<p>Trước tiên bạn cần xác nhận lại mật khẩu <br/>đã cung cấp khi tạo sản phẩm.
	<a href="javascript:;" id="forgotPass">(Quên mật khẩu?)</a></p>
	<br/><br/>
	<div class="left forgotForm" style="display: none;">	
		<h3>Quên mật khẩu? Gửi lại mật khẩu qua email:</h3>
		<div id="errorForgot" class="error"><s:actionmessage /></div>
		<s:form action="/home/productLogin" method="post" id="emailForm">  
			<s:hidden name="productId" id="productId" />
			<s:hidden name="update" id="update" />
			<div><span class="requried">*</span>Email</div>
			<div><s:textfield name="contactEmail" id="contactEmail" /></div>
			<div></div>
			<div><input type="submit" value="Lấy lại mật khẩu"  />
			</div>
			<br/>
	  	</s:form>
	</div>
</div>
<div class="left divider">
	
</div>
<div class="left description">
	<div id="passError" class="error"><s:actionmessage /></div>
		<s:form action="/home/productLogin" method="post" id="passForm">
			  
			<s:hidden name="productId" id="productId" />
			<s:hidden name="update" id="update" />
			<div><span class="requried">*</span>Mật khẩu</div>
			<div><s:password name="password" id="password" /></div>
			<div></div>
			<div><input type="submit" value="Tiếp tục" /></div>
			<br/>
		  	<span class="requried">*</span> Thông tin bắt buộc nhập
		</s:form>
</div>

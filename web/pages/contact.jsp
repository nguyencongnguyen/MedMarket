<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<script type="text/javascript" src="<%= request.getContextPath() %>/js/jquery.validate.min.js"></script> 
<script type="text/javascript">

$(document).ready(function() {
	$("#form").validate({
		rules: {
			name: {
				required: true
			},
			email: {
				required: true,
				email: true
			},
			body: {
				required: true
			},
			captcha: {
				required: true
			}
		},
		messages: {
			name: {
				required: "Vui lòng nhập tên"
			},
			email: {
				required: "Vui lòng nhập email",
				email: "Email không đúng"
			},
			body: {
				required: "Vui lòng nhập nội dung"
			},
			captcha: {
				required: "Vui lòng nhập mã kiểm tra"
			}
		},
	 	submitHandler: function(form) {
	 		form.submit();
	 	}
	});
});
</script>
<div class="left left-content wrapperBox">
<h2>Liên hệ</h2>

<div class="error"><s:actionmessage /></div>
<div class="left">
<s:form action="/home/contactSubmit" method="post" id="form">  
	<div><span class="requried">*</span>Họ và tên</div>
	<div><s:textfield name="name" id="name" /></div>
	<div><span class="requried">*</span>Email</div>
	<div><s:textfield name="email" id="email" /></div>
	<div><span class="requried">*</span>Nội dung</div>
	<div><s:textarea name="body" id="body" rows="10" cols="60" /></div>
	<br/>
	<div>
		<div><img src="<%= request.getContextPath() %>/Captcha.jpg" border="0"></div>
	</div>
	<div><span class="requried">*</span>Nhập mã ở trên</div>
	<div><s:textfield label="Code" name="captcha" id="captcha" size="20" maxlength="10"/></div>
	<div><input type="submit" value="Gửi liên hệ"  /></div>
	<br/>
  	<span class="requried">*</span> Thông tin bắt buộc nhập
</s:form>

</div>
</div>
<jsp:include page="include/right-ads.jsp"></jsp:include>
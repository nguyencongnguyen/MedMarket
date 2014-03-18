<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator" prefix="decorator"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
 <head>
 	<title><decorator:title default="Hẹn khám trực tuyến" /></title>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
	<link rel="icon" href="<%= request.getContextPath() %>/images/favicon.png" type="image/png"/>
	<script type="text/javascript" src="<%= request.getContextPath() %>/js/jquery.min.js"></script>
    <link href="<%= request.getContextPath() %>/css/style.css" rel="stylesheet" type="text/css" />
  	<decorator:head />
 </head>
  <body>
  	<jsp:include page="../pages/include/top.jsp"></jsp:include>
    <div id="bannerContainer">    	    
		<div class="banner">
			<a href="<%=request.getContextPath() %>/home"><img src="<%= request.getContextPath() %>/images/logo.png" class="mainLogo" /></a>
			<div style="float: right; background-color: #FFF; width: 300px; height: 150px; padding: 20px;">
				<div style="color: #F5983B; font-size: 18px; font-weight: bold;">Chuyên trang rao vặt y khoa.</div>
				<p style="font-size: 15px;">Chuyên trang rao vặt các loại sản phẩm, máy móc, dịch vụ y khoa với đa dạng các danh mục.</p>
				<a href="/home/addProduct" class="button">Đăng tin miễn phí</a>
			</div>
		</div>
	</div>
	<div id="aggregateHeaderWrapper">
		<div id="aggregateHeader">
			<h2>RAO VẶT Y KHOA</h2>
		</div>
	</div>
	<div id="content">
        <decorator:body />
    </div>

	<jsp:include page="../pages/include/bottom.jsp" />
  </body>
</html>
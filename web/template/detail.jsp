<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator" prefix="decorator"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
			<img src="<%= request.getContextPath() %>/images/hospital_banner.jpg" class="mainBanner" />
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
    <jsp:include page="../pages/include/bottom.jsp"></jsp:include>	
  </body>
</html>
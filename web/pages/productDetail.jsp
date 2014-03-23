<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
	<title>Rao vặt y khoa - <s:property value="product.name"/></title>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
	<meta name="description" content='<s:property value="product.name"/> <s:property value="product.category.name"/>' />
	<meta name="keywords" content='Rao vặt,y khoa,<s:property value="@com.med.market.util.CommonUtil@genKeyword(product.name)"/>' />
	<link href="<%= request.getContextPath() %>/css/product.css" rel="stylesheet" type="text/css" />
	<script type="text/javascript" src="<%= request.getContextPath() %>/js/product.js"></script>
	<script type="text/javascript" src="<%= request.getContextPath() %>/js/jcarousellite_1.0.1.js"></script> 
	
	<script type="text/javascript">var switchTo5x=true;</script>
	<script type="text/javascript" src="http://w.sharethis.com/button/buttons.js"></script>
	<script type="text/javascript">stLight.options({publisher: "ae8ccf5f-b83a-41ea-9bf6-a27e07297edd", doNotHash: false, doNotCopy: false, hashAddressBar: false});</script>
</head>
<body>
<jsp:include page="include/breadcrum.jsp"></jsp:include>
<div class="left left-content">
<div class="productInfo wrapperBox">
	<div class="image">
		<div class="imageContainer"><img id="productImage" src="" style="max-width: 300px; max-height: 300px;" /></div>
	</div>
	<div class="detail">
		<h2><s:property value="product.name"/></h2>	
		Giá:
        <s:if test="%{product.price > 0}">
			<s:property value="product.price"/><br />
        </s:if>
        <s:else>
            Call<br />
        </s:else>
        Loại sản phẩm: <s:property value="product.category.name"/><br />
		Phạm vi giao dịch: <s:property value="product.province.name"/><br />
		<br/>
		<label>Liên hệ:</label><br/>
		Người liên hệ: <s:property value="product.contactName"/><br/>
		Điện thoại: <s:property value="product.contactPhone"/><br/>
		Email: <s:property value="product.contactEmail"/><br/>
		<s:if test="%{product.contactAddress != ''}">
		Địa chỉ: <s:property value="product.contactAddress"/><br/>
		</s:if>
		<br/>
			<span class='st_sharethis_large' displayText='ShareThis'></span>
			<span class='st_facebook_large' displayText='Facebook'></span>
			<span class='st_twitter_large' displayText='Tweet'></span>
			<span class='st_linkedin_large' displayText='LinkedIn'></span>
			<span class='st_pinterest_large' displayText='Pinterest'></span>
			<span class='st_email_large' displayText='Email'></span>
		<br/><br/>
		<a class="button" href='/home/updateProduct?update=true&productId=<s:property value="product.productId"/>'>Cập nhật tin</a>&nbsp;&nbsp;
		<a class="button" href='/home/updateProduct?update=false&productId=<s:property value="product.productId"/>'>Xóa tin</a>
	</div>
	<div class="imageList">
		<ul>
			<s:iterator value="images" status="image">
				<li><img class="imageView" src='<s:property value="thumbnail"/>' alt='<s:property value="product.name"/>' height="50" />
				<input class="imageUrl" type="hidden" value='<s:property value="url"/>'/></li>
			</s:iterator>
		</ul>
	</div>
	<div class="infoDetail">
		<br/><label>Thông tin sản phẩm:</label><br/><br/>
		<s:property value="product.description"/><br/>
	</div>
</div>
<s:if test="%{similar.size() > 1}">
	<div class="productInfo wrapperBox">
	<div class="left" style="width: 100%; margin-top: 10px;"><label>Có thể bạn quan tâm:</label></div>
	<div class='prev'><img src="<%= request.getContextPath() %>/images/carPrev-on.png" /></div>
	<div id="similar">
		<ul>
			<s:iterator value="similar" status="product">
				<li><a href='/<s:property value="friendlyUrl"/>'>
				<img class="imageView" src='<s:property value="defaultThumnbail"/>' alt='<s:property value="name"/>' height="60" border="0"/></a><br/>
				<s:property value="name"/><br/>
				<s:if test="%{price > 0}">
					<s:property value="price"/><br />
		        </s:if>
		        <s:else>
		            Call<br />
		        </s:else></li>
			</s:iterator>
		</ul>
	</div>
	<div class='next'><img src="<%= request.getContextPath() %>/images/carouNext-on.png" /></div>
	</div>
</s:if>
</div>

<jsp:include page="include/right-ads.jsp"></jsp:include>

</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<link href="<%= request.getContextPath() %>/css/product.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="<%= request.getContextPath() %>/js/product.js"></script>
<script type="text/javascript" src="<%= request.getContextPath() %>/js/jcarousellite_1.0.1.js"></script> 

<div class="left left-content">
	<div class="image">
		<div class="imageContainer"><img id="productImage" src="" width="300" /></div>
		<div class="imageList">
			<ul>
				<s:iterator value="images" status="image">
					<li><img class="imageView" src='<s:property value="thumbnail"/>' alt='<s:property value="product.name"/>' width="70" />
					<input class="imageUrl" type="hidden" value='<s:property value="url"/>'/></li>
				</s:iterator>
			</ul>
		</div>
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
		<b>Liên hệ:</b><br/>
		Người liên hệ: <s:property value="product.contactName"/><br/>
		Điện thoại: <s:property value="product.contactPhone"/><br/>
		Email: <s:property value="product.contactEmail"/><br/>
		<s:if test="%{product.contactAddress != ''}">
		Địa chỉ: <s:property value="product.contactAddress"/><br/>
		</s:if>
	</div>
	<div class="description">
		<br/><s:property value="product.description"/><br/>
	</div>
</div>
<s:if test="%{similar.size() > 0}">
	<div class="left" style="width: 100%; margin-top: 30px;"><p>Có thể bạn quan tâm:</div>
	<div class='prev'><img src="<%= request.getContextPath() %>/images/carPrev-on.png" /></div>
	<div id="similar">
		<ul>
			<s:iterator value="similar" status="product">
				<li><img class="imageView" src='<s:property value="defaultThumnbail"/>' alt='<s:property value="name"/>' height="60" /><br/>
				<s:property value="name"/><br/>
				<s:property value="price"/></li>
			</s:iterator>
		</ul>
	</div>
	<div class='next'><img src="<%= request.getContextPath() %>/images/carouNext-on.png" /></div>
</s:if>
<jsp:include page="include/right-ads.jsp"></jsp:include>

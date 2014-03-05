<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<link href="<%= request.getContextPath() %>/css/product.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="<%= request.getContextPath() %>/js/product.js"></script>

<div class="left left-content">
	<div class="image">
		<div class="imageContainer"><img id="productImage" src="" width="300" /></div>
		<div class="imageList">
			<ul>
				<s:iterator value="images" status="image">
					<li><img class="imageView" src='<s:property value="thumbnail"/>' width="70" />
					<input class="imageUrl" type="hidden" value='<s:property value="url"/>'/></li>
				</s:iterator>
			</ul>
		</div>
	</div>
	<div class="detail">
		<h3><s:property value="product.name"/></h3>	
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

<jsp:include page="include/right-ads.jsp"></jsp:include>

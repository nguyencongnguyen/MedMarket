<%@ taglib prefix="s" uri="/struts-tags" %>
<div id="breadcrum">
	<ul>
		<li><a href='/home/search?catId=<s:property value="product.category.catId"/>&provinceId=-1&keyword='><s:property value="product.category.name"/></a></li>
		<li class="arrow"></li>
		<li><s:property value="product.name"/></li>
	</ul>
</div>
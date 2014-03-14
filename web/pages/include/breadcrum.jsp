<%@ taglib prefix="s" uri="/struts-tags" %>
<div id="breadcrum">
	<ul>
		<li>
			<span itemscope itemtype="http://data-vocabulary.org/Breadcrumb">
			<a itemprop="url" href='/home/search?catId=<s:property value="product.category.catId"/>&provinceId=-1&keyword='>
			<span itemprop="title"><s:property value="product.category.name"/></span></a>
			</span>
		</li>
		<li class="arrow"></li>
		<li>
			<s:property value="product.name"/>
		</li>
	</ul>
</div>
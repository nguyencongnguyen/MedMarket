<%@ taglib prefix="s" uri="/struts-tags" %>
<div id="catList">
	<ul>
		<s:iterator value="topCats">
			<li><a href='/home/search?catId=<s:property value="catId"/>&provinceId=-1&keyword='><s:property value="name"/></a></li>
		</s:iterator>
	</ul>
</div>
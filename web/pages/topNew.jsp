<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
<link href="<%= request.getContextPath() %>/css/product.css" rel="stylesheet" type="text/css" />
<link href="<%= request.getContextPath() %>/css/style.css" rel="stylesheet" type="text/css" />
</head>
<body style="background-color: #FFF;">
<div style="width: 785px; float: left; background-color: #FFF;">
	<s:if test="%{result.size() > 0}">
		<ul style="margin: 0; padding: 0">
		<s:iterator value="result" status="product" id="aProduct">
			<li style="list-style:none; float: left; text-align: center; width: 135px; margin: 5px 5px; padding: 5px;">
				<div class="left">
					<div style="height: 135px; width: 135px; background-color: #FFF;">
					<a href='<s:property value="domain"/>/<s:property value="friendlyUrl"/>' target="_blank">
						<img src='<s:property value="defaultThumnbail"/>' width="100" border="0" alt='<s:property value="name"/>' title='<s:property value="description"/>' />
					</a>
					</div>
					<div class="itemTitle" style="color: #F5983B; margin: 5px 0; font-weight: bold;">
                           <s:if test="%{price > 0}">
						    <s:property value="@com.med.market.fo.action.SearchAction@formatPrice(price)"/>
                           </s:if>
                           <s:else>
                               Call
                           </s:else>
                          </div>
					<div style="height: 50px;"><a href='<s:property value="domain"/>/<s:property value="friendlyUrl"/>' target="_blank">
					<s:property value="name"/></a></div>
				</div>
			</li>
		</s:iterator>
		</ul>
	</s:if>
</div>
</body>
</html>
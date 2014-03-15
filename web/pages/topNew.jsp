<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
<link href="<%= request.getContextPath() %>/css/product.css" rel="stylesheet" type="text/css" />
<link href="<%= request.getContextPath() %>/css/style.css" rel="stylesheet" type="text/css" />
</head>
<body style="">
<div style="width: 940px; float: left;">
	<s:if test="%{result.size() > 0}">
		<ul>
		<s:iterator value="result" status="product" id="aProduct">
			<li style="list-style:none; float: left; text-align: center; margin: 5px; width: 140px; padding: 5px;">
				<div class="left">
					<div style="height: 140px; width: 140px; background-color: #FFF; border: 1px solid #DDD;">
					<a href='/<s:property value="friendlyUrl"/>' >
						<img src='<s:property value="defaultThumnbail"/>' width="100" alt='<s:property value="name"/>' title='<s:property value="description"/>' />
					</a><br />
					</div>
					<div class="itemTitle" style="color: #F5983B; margin: 5px 0; font-weight: bold;">
                           <s:if test="%{price > 0}">
						    <s:property value="@com.med.market.fo.action.SearchAction@formatPrice(price)"/>
                           </s:if>
                           <s:else>
                               Call
                           </s:else>
                          </div>
					<a href='/<s:property value="friendlyUrl"/>' >
					<s:property value="name"/></a>
					<br />
				</div>
			</li>
		</s:iterator>
		</ul>
	</s:if>
</div>
</body>
</html>
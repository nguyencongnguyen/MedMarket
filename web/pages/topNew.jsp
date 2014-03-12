<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<link href="<%= request.getContextPath() %>/css/product.css" rel="stylesheet" type="text/css" />
<link href="<%= request.getContextPath() %>/css/style.css" rel="stylesheet" type="text/css" />

<div style="width: 400px;">
	<s:if test="%{result.size() > 0}">
		<ul>
		<s:iterator value="result" status="product" id="aProduct">
			<li style="list-style:none; float: left; text-align: center; margin: 10px;">
				<div class="left">
					<div style="height: 80px;">
					<a href='/<s:property value="friendlyUrl"/>' >
						<img src='<s:property value="defaultThumnbail"/>' height="80" />
					</a><br />
					</div>
					<div class="itemTitle">
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

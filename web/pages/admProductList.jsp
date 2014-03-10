<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<link href="<%= request.getContextPath() %>/css/product.css" rel="stylesheet" type="text/css" />
<script type="text/javascript">

$(document).ready(function() {
	$(".button").click(function () {
		var button = $(this).closest(".item");
		var ok = $(this).hasClass("del") ? "no" : "yes";
		var action = '<%=request.getContextPath() %>/home/admApprove.action?productId=' + $(this).parent().find(".hidden").val() + '&approve=' + ok;
		$.ajax({
	       type: 'GET',
	       url: action,
	       dataType: 'json',
	       success: function(data){
	    	   button.remove();
	       }
		});
	});
});
</script>
<div class="left">
	<div class="searchResult">
		<div class="seachHeading">List</div>
		<div class="resultList">
			<s:if test="%{result.size() > 0}">
				<ul>
				<s:iterator value="result" status="product" id="aProduct">
					<li class="item">
						<div class="left" style="width: 640px">
							<s:property value="name"/>
							<br />
							Loại sản phẩm: <s:property value="categoryName"/><br />
							<div class="info"><s:property value="description"/></div>
							<div><a href='javascript:;' class="button">Approve</a> <a href='javascript:;' class="button del">DELETE</a>
							<input type="hidden" name="prodId" class="hidden" value='<s:property value="productId" />'></div>
						</div>
					</li>
				</s:iterator>
				</ul>
			</s:if>
			<s:if test="%{result.size() == 0}">
				Không có san pham moi
			</s:if>
		</div>
	</div>
</div>

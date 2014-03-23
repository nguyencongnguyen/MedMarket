<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<link href="<%= request.getContextPath() %>/css/product.css" rel="stylesheet" type="text/css" />
<link href="<%= request.getContextPath() %>/css/right-ads.css" rel="stylesheet" type="text/css" />
<jsp:include page="include/topCats.jsp"></jsp:include>
<div class="left left-content wrapperBox">
	<div id="searchBox">
		<div class="searchForm">
			<s:form action="/home/search" method="get">
			<s:textfield id="keyword" name="keyword" size="50" />
			<input type="submit" value="Tìm kiếm">
			<br/>
			Loại sản phẩm <s:select list="categories" name="catId" id="catId" listKey="catId" listValue="name"></s:select>
			Tỉnh thành <s:select list="provinces" name="provinceId" id="provinceId" listKey="provinceId" listValue="name"></s:select>
			</s:form>
		</div>
	</div>
	<div class="searchResult">
		<div class="seachHeading"></div>
		<div class="resultList">
			<s:if test="%{result.size() > 0}">
				<ul>
				<s:iterator value="result" status="product" id="aProduct">
					<s:if test="#product.odd == true">
					<li>
					</s:if>
						<div class="left" style="margin-right: 10px;">
							<a href='/<s:property value="friendlyUrl"/>' >
								<img src='<s:property value="defaultThumnbail"/>' width="120" />
							</a><br />
							<div class="itemTitle price">
	                            <s:if test="%{price > 0}">
								    <s:property value="@com.med.market.fo.action.SearchAction@formatPrice(price)"/>
	                            </s:if>
	                            <s:else>
	                                Call
	                            </s:else>
                            </div>
						</div>
						<div class="left" style="width: 230px; margin-bottom: 20px;">
							<a class="productName" href='/<s:property value="friendlyUrl"/>' >
							<s:property value="name"/></a>
							<br />
							<span class="itemTitle">Loại: <s:property value="categoryName"/></span><br />
							<div class="info"><s:property value="description"/></div><br />
							<div><a href='/<s:property value="friendlyUrl"/>' class="button-org">Xem chi tiết</a></div>
						</div>
					<s:if test="#product.odd == false">
					</li>
					</s:if>
				</s:iterator>
				</ul>
			</s:if>
			<s:if test="%{result.size() == 0}">
				Không có kết quả nào phù hợp
			</s:if>
		</div>
		<s:if test="%{totalPage > 1}">
		<div class="pagination left">
			<s:url forceAddSchemeHostAndPort="true" includeParams="all" var="url"/>
			<ul>
				<s:if test="%{page > 1}">
					<li>
						<a href='<s:property value="@com.med.market.fo.action.SearchAction@addPageParam(#url)"/><s:property value="page - 1"/>'><span class="prev"><<</span></a>
					</li>
				</s:if>

				<s:iterator begin="%{begin}" end="%{end}">
					<s:if test="%{page == top}">
						<li>
							<span class="page curpage"><s:property value="top"/></span>
						</li>
					</s:if>
					<s:else>
						<li>
							<a href='<s:property value="@com.med.market.fo.action.SearchAction@addPageParam(#url)"/><s:property value="top"/>'><span class="page"><s:property value="top"/></span></a>
						</li>
					</s:else>
				</s:iterator>

				<s:if test="%{page < totalPage}">
					<li>
						<a href='<s:property value="@com.med.market.fo.action.SearchAction@addPageParam(#url)"/><s:property value="page + 1"/>'><span class="next">>></span></a>
					</li>
				</s:if>
			</ul>
		</div>
		</s:if>
	</div>
</div>
<jsp:include page="include/right-ads.jsp"></jsp:include>

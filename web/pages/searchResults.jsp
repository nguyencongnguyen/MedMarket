﻿<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<link href="<%= request.getContextPath() %>/css/schedule.css" rel="stylesheet" type="text/css" />

<div class="left left-content">
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
		<div class="seachHeading">Kết quả tìm kiếm</div>
		<div class="resultList">
			<s:if test="%{result.size() > 0}">
				<ul>
				<s:iterator value="result" status="product" id="aProduct">
					<li>
						<div class="left">
							<s:if test='%imageUrl != null && imageUrl != ""'>
								<img src='/home/getImage?pic=<s:property value="imageUrl" />' width="100" />
							</s:if>
							<s:else>
								<img src='<%=request.getContextPath() %>/images/hospital-default.png' width="100" />
							</s:else>
						</div>
						<div class="left" style="width: 440px">
							<a href='/<s:property value="friendlyUrl"/>' >
							<s:property value="name"/></a>
							<br />
                            Giá:
                            <s:if test="%{price > 0}">
							    <s:property value="price"/><br />
                            </s:if>
                            <s:else>
                                Call
                            </s:else>
							Loại sản phẩm: <s:property value="category.name"/><br />
							Phạm vi giao dịch: <s:property value="province.name"/><br />
							<div class="info"><s:property value="description"/></div>
							<div><a href='/<s:property value="friendlyUrl"/>' class="button">Xem chi tiết</a></div>
						</div>
					</li>
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
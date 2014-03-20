<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<link href="<%= request.getContextPath() %>/css/product.css" rel="stylesheet" type="text/css"/>
<script type="text/javascript" src="<%= request.getContextPath() %>/js/jquery.validate.min.js"></script>
<script type="text/javascript" src="<%= request.getContextPath() %>/js/productAdd.js"></script>
<script type="text/javascript" src="<%= request.getContextPath() %>/js/ajaxfileupload.js"></script>
<div class="content">
<s:if test="%{uploadedImages != ''}">
	<h2>Cập nhật sản phẩm</h2>
</s:if>
<s:else>
	<h2>Đăng sản phẩm</h2>
</s:else>
<s:form action="/home/postProduct" method="post" id="createForm">
<div class="error"><s:actionmessage /></div>
<div class="left">
<s:if test="%{uploadedImages == ''}">
    <div><span class="requried">*</span>Mật khẩu (sử dụng để cập nhật/xóa tin)</div>
    <div><s:password name="password" id="password" /></div>
    <div><span class="requried">*</span>Nhập lại mật khẩu</div>
    <div><s:password name="repassword" id="repassword" /></div>
</s:if>
    <h3>Thông tin liên hệ</h3>
    <div><span class="requried">*</span>Tên</div>
    <div><s:textfield name="contactName" id="contactName" /></div>
    <div><span class="requried">*</span>Điện thoại</div>
    <div><s:textfield name="contactPhone" id="contactPhone" /></div>
    <div><span class="requried">*</span>Email</div>
    <div><s:textfield name="contactEmail" id="contactEmail" /></div>
    <div>Địa chỉ</div>
    <div><s:textfield name="contactAddress" id="contactAddress" /></div>
    <br/>
    <span class="requried">*</span> Thông tin bắt buộc nhập<br/><br/>
</div>
<div class="left divider">
</div>
<div class="left description">
    <h3>Thông tin sản phẩm</h3>
	<div><span class="requried">*</span>Tên sản phẩm</div>
	<div><s:textfield name="name" id="name" /></div>
	<div>Giá (để trống nếu muốn báo giá sản phẩm khi người mua liên hệ)</div>
	<div><s:textfield name="price" id="price" /></div>
    <div><span class="requried">*</span>Loại sản phẩm</div>
    <div><s:select list="categories" name="catId" id="catId" listKey="catId" listValue="name"></s:select></div>
    <div><span class="requried">*</span>Phạm vi giao dịch</div>
    <div><s:select list="provinces" name="provinceId" id="provinceId" listKey="provinceId" listValue="name"></s:select></div>
    <div><br/><span class="requried">*</span>Thông tin mô tả sản phẩm</div>
    <div><s:textarea name="description" id="description" rows="7" cols="50" maxlength="4000"></s:textarea></div><br/>
    <div><span class="requried">*</span>Hình ảnh (kích thước tối đa 2Mb)</div>
    <div id="uploadImage">
    <ul>
    	<li id="image1">
    		Hình 1: <input type="file" id="fileToUpload1" name="fileToUpload" class="upload" /><span id="imageName1" style="display: none;" class="uploaded"></span>
    		<img id="loading1" src="<%=request.getContextPath() %>/images/LoadingIcon.gif" width="20px" style="display: none;" class="loading" />
    		<img id="delete1" src="<%=request.getContextPath() %>/images/delete.png" title="Xóa hình" style="display: none;" class="delUpload uploaded" /><br/>
    	</li>
    	<li id="image2">
    		Hình 2: <input type="file" id="fileToUpload2" name="fileToUpload" class="upload" /><span id="imageName2" style="display: none;" class="uploaded"></span>
    		<img id="loading2" src="<%=request.getContextPath() %>/images/LoadingIcon.gif" width="20px" style="display: none;" class="loading" />
    		<img id="delete2" src="<%=request.getContextPath() %>/images/delete.png" title="Xóa hình" style="display: none;" class="delUpload uploaded" /><br/>
    	</li>
    	<li id="image3">
   	 		Hình 3: <input type="file" id="fileToUpload3" name="fileToUpload" class="upload" /><span id="imageName3" style="display: none;" class="uploaded" ></span>
   			<img id="loading3" src="<%=request.getContextPath() %>/images/LoadingIcon.gif" width="20px" style="display: none;" class="loading" />
   		 	<img id="delete3" src="<%=request.getContextPath() %>/images/delete.png" title="Xóa hình" style="display: none;" class="delUpload uploaded" /><br/>
    	</li>
    	<li id="image4">
    		Hình 4: <input type="file" id="fileToUpload4" name="fileToUpload" class="upload" /><span id="imageName4" style="display: none;" class="uploaded" ></span>
    		<img id="loading4" src="<%=request.getContextPath() %>/images/LoadingIcon.gif" width="20px" style="display: none;" class="loading" />
    		<img id="delete4" src="<%=request.getContextPath() %>/images/delete.png" title="Xóa hình" style="display: none;" class="delUpload uploaded" /><br/>
    	</li>
    	<li id="image5">
    		Hình 5: <input type="file" id="fileToUpload5" name="fileToUpload" class="upload" /><span id="imageName5" style="display: none;" class="uploaded" ></span>
    		<img id="loading5" src="<%=request.getContextPath() %>/images/LoadingIcon.gif" width="20px" style="display: none;" class="loading" />
    		<img id="delete5" src="<%=request.getContextPath() %>/images/delete.png" title="Xóa hình" style="display: none;" class="delUpload uploaded" /><br/>
    	</li>
    </ul>
    <s:hidden id="productId" name="productId" />
    <s:hidden id="uploadedImages" name="uploadedImages" /></div>
	<div></div>
	<div>
		<s:if test="%{uploadedImages != ''}">
			<input type="submit" value="Cập nhật sản phẩm"  />
		</s:if>
		<s:else>
			<div><span class="requried">*</span>Điều khoản (<a id="viewRules" href="javascript:;">xem điều khoản</a>)</div>
			<div id="rules" class="hidden scrollable">Bạn cần xem và đồng ý với các điều khoản sau:
			<ul>
				<li>Người dùng có thể đăng tin trên trang web nếu thỏa mãn các yêu cầu của trang web đặt ra.</li>
				<li>Người dùng có quyền tự do mua bán với nhau các mặt hàng dịch vụ phù hợp với quy chế này và pháp luật Việt Nam hiện hành.</li>
				<li>Người mua có quyền khiếu nại người bán nếu chất lượng hàng hóa dịch vụ không đảm bảo.</li>
				<li>Người mua có quyền yêu cầu cơ quan pháp luật bảo vệ quyền lợi nếu bị Người bán lừa gạt.</li>
				<li>Bản thân Người dùng phải chịu trách nhiệm đối với việc sử dụng Trang web và/hoặc Các dịch vụ của mình. Người dùng phải chịu mọi rủi ro trong quá trình sử dụng Trang web và/hoặc Các dịch vụ.</li>
				<li>Người dùng phải tuân theo quy trình, quy định đăng tin. Người dùng phải chịu toàn bộ trách nhiệm đối với tính chính xác của Thông tin đã được đề cập.</li>
				<li>Công ty có quyền rà soát thường xuyên các hoạt động đăng tin trên mạng bằng các biện pháp cần thiết. Mọi hành vi đăng sai sự thật, vi phạm quy chế hoặc lừa đảo sẽ bị xử lý theo quy chế này và pháp luật Việt Nam</li>
				<li>Chúng tôi có thể loại trừ những tin đăng không hợp lệ, sai nội dung.</li>
				<li>Không sử dụng dịch vụ với dữ liệu, thông tin không có thật.</li>
				<li>Những thông tin về sản phẩm có thể được hiển thị trên các trang tìm kiếm (Google, Yahoo, Bing...)
				<li>Không được tìm cách phá hệ thống hoặc thay đổi dữ liệu</li>
				<li>Chúng tôi không chịu trách nhiệm trước những vấn đề trong việc kinh doanh của bạn khi sử dụng hệ thống</li>
				<li>Chúng tôi không ngừng thay đổi và cải tiến dịch vụ của mình. Chúng tôi có thể thêm hoặc xóa các chức năng hoặc tính năng và chúng tôi cũng có thể tạm ngừng hoặc ngừng hoàn toàn một dịch vụ.</li>
			</ul></div>
			<div><input type="checkbox" id="accept" name="accept"/><label for="accept">Tôi đã đọc và đồng ý với các điều khoản trên</label></div><br/><br/>
			<input type="submit" value="Đăng sản phẩm"  />
		</s:else>
	</div>
	<br/>
  	
</div>
</s:form>
</div>
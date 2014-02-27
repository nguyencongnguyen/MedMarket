<div id="top-nav-menu">
   	<div class="topContent">
   		<ul>
   			<li class="first"><a href="/home/search">Tìm phòng khám</a></li>
   			<li><a href="/video">Tư vấn sức khoẻ</a></li>
   			<li><a href="/home/about">Giới thiệu</a></li>
   			<li><a href="/home/contact" rel="nofollow">Liên hệ</a></li>
   			<% if (session.getAttribute("username") == null) { %>
	    			<li class="last"><a href="/home/login" rel="nofollow">Đăng nhập</a></li>
	    			<li><a href="/home/register" rel="nofollow">Đăng kí</a></li>
	    	<% } else { %>
	    			<li class="last"><a href="/home/logout" rel="nofollow">Đăng xuất</a></li>
	    			<li class="last"><a href="/home/profile" rel="nofollow">Quản lý phòng khám</a></li>
	    			<li><div>Chào mừng <%=session.getAttribute("username") %></div></li>
	    	<% } %>
   		</ul>
   	</div>	    	
  </div>
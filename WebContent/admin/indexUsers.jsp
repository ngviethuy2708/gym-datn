<%@page import="library.TimeConvert"%>
<%@page import="bean.Users"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/templates/admin/inc/header.jsp" %>
	<!-- body -->
	<div class="container">
		<div class="row">
			<!-- main -->
			<div class="col-md-10 main">
				<div class="search-form">
					<div class="col-md-2">
						<p>
							<a href="<%=request.getContextPath()%>/admin/addUsers" class="btn btn-success create-button">Create</a>
		        		</p>
		    		</div>
		    		<!--search form  -->
		    		<div class="col-md-10">
		    			<form class="form-inline" role="form" action="<%=request.getContextPath()%>/admin/searchUsers" method="post">
 							<div class="form-group">
								<div name="type" class="radio">
  									<label><input type="radio" value="1" name="optradio" checked="checked"><strong>Đă đăng ký</strong></label>
								</div>
								<div name="type" class="radio">
  									<label><input type="radio" value="0" name="optradio"><strong>Chưa đăng ký</strong></label>
								</div> 
       						 </div>
  							<div class="form-group">
    							<input name="something" type="text" class="form-control" id="exampleInputPassword2" placeholder="Something.....">
  							</div>
  							<input class="button-add btn btn-primary create-button" name="submit" type="submit" value="Tìm kiếm" /> 
						</form>
		    		</div>
				</div>
				<!-- end search form -->
				<div class="table-main">
					<table class="table table-bordered table-hover">
					<thead>
						<tr>
							<th>Id</th>
							<th>Username</th>
							<th>Họ tên</th>
							<th>Ngày sinh</th>
							<th>Địa chỉ</th>
							<th>Số điện thoại</th>
							<th>Tình trạng</th>
							<th style="width:10px;">Sửa</th>
							<th style="width:10px;">Xóa</th>
							
						</tr>
					</thead>
					<tbody>
					<%
					ArrayList<Users> alUsers = (ArrayList<Users>)request.getAttribute("alUsers");
					for(Users objUsers:alUsers){
					%>
						<tr>
							<td><%=objUsers.getIdUser() %></td>
							<td><%=objUsers.getUserName() %></td>
							<td><%=objUsers.getFullName() %></td>
							<td><%=TimeConvert.getStringDatetime(objUsers.getBirthDay()) %></td>
							<td><%=objUsers.getAddDress() %></td>
							<td><%=objUsers.getPhoneNumber() %></td>
							<td>
								<%if(objUsers.isRegister()==false){ %>
								<img src="<%=request.getContextPath()%>/templates/admin/images/icon-fail.png" style="width:30px; height:30px;">
								<%}else{%> 
								<img src="<%=request.getContextPath()%>/templates/admin/images/icon-success.png" style="width:30px; height:30px;">
								<%} %>
							</td>
							<td><a href="<%=request.getContextPath()%>/admin/editUsers?uid=<%=objUsers.getIdUser()%>"><i class="fa fa-edit"></i></a></td>
							<td><a onclick="return confirm('bạn có muốn xóa ko?')" href="<%=request.getContextPath()%>/admin/deleteUsers?uid=<%=objUsers.getIdUser()%>"><i class="fa fa-times"></i></a></td>
						</tr>
					<%} %>

					</tbody>
				</table>
				</div>
				<div class="pagi">
					<ul class="pagination">
					<%
					String active="";
					int curentPage = (Integer)request.getAttribute("page");
					int soTrang = (Integer)request.getAttribute("soTrang");
					for(int i=1;i<=soTrang;i++){
						if(curentPage==i){
							active = "class=\"active\"";
						}else{
							active ="";
						}
					%>
  						<li <%=active %>><a href="<%=request.getContextPath() %>/admin/indexUsers?page=<%=i%>"><%=i %></a></li>
  					<%} %>
					</ul>
				</div>	
			</div>
			<!-- end main -->
			<%@include file="/templates/admin/inc/rightbar.jsp" %>
		</div>
		
	</div>
	<!-- end body -->
</body>
</html>

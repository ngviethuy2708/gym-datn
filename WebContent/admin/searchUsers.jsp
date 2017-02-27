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
			</div>
			<!-- end main -->
			<%@include file="/templates/admin/inc/rightbar.jsp" %>
		</div>
		
	</div>
	<!-- end body -->
</body>
</html>

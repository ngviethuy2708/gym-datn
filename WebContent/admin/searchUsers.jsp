<%@page import="bean.User"%>
<%@page import="library.TimeConvert"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/templates/admin/inc/header.jsp" %>
	<!-- body -->
	<div class="container">
		<div class="row">
			<!-- main -->
			<div class="col-md-10 main">
				<div class="col-md-2">
					<p>
						<a href="<%=request.getContextPath()%>/admin/indexUsers" class="btn btn-success create-button" style="margin-left: -16px; margin-top: 41px;">Quay lại</a>
		        	</p>
		    	</div>	
				<!-- end search form -->
				<div class="table-main">
					<table class="table table-bordered table-hover">
					<thead>
						<tr>
							<th>Id</th>
							<th style="width: 121px;">Username</th>
							<th style="width:121px;">Họ tên</th>
							<th style="width:121px;">Ngày sinh</th>
							<th style="width: 153px;">Địa chỉ</th>
							<th style="width: 123px">Số điện thoại</th>
							<th>Hội viên</th>
							<th style="width:10px;">Sửa</th>
							<th style="width:10px;">Xóa</th>
							
						</tr>
					</thead>
					<tbody>
					<%
					ArrayList<User> alUser = (ArrayList<User>)request.getAttribute("alUser");
					for(User objUser:alUser){
						String imgActive = "";
						String isActive = "";
						int type;
						if(objUser.isMember()==true){
							isActive = "Kích hoạt";
							imgActive = request.getContextPath() + "/templates/admin/images/icon-success.png";
							type = 1;
						}else{
							isActive = "Ngừng kích hoạt";
							imgActive = request.getContextPath() + "/templates/admin/images/icon-fail.png";
							type = 0;
						}
					%>
						<tr>
							<td><%=objUser.getId() %></td>
							<td><%=objUser.getUserName() %></td>
							<td><%=objUser.getFullName() %></td>
							<td><%=TimeConvert.getStringDatetime(objUser.getBirthDay()) %></td>
							<td><%=objUser.getAddDress() %></td>
							<td><%=objUser.getPhoneNumber() %></td>
							<td class="align-center" id="setactive-<%=objUser.getId() %>">
							<a href="javascript:void(0)" onclick="return setActive(<%=objUser.getId() %>, <%=type %>)" title="<%=isActive %>"><img style="width:30px; height:30px;" src="<%=imgActive %>" alt=""></a>
							</td>
							<td><a href="<%=request.getContextPath()%>/admin/editUsers?uid=<%=objUser.getId()%>"><i class="fa fa-edit"></i></a></td>
							<td><a onclick="return confirm('bạn có muốn xóa ko?')" href="<%=request.getContextPath()%>/admin/deleteUsers?uid=<%=objUser.getId()%>"><i class="fa fa-times"></i></a></td>
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
<script type="text/javascript">
	function setActive(id, active){
		if(active == 0){
			$.ajax({
				url: '<%=request.getContextPath() %>/admin/activeMember',
				type: 'POST',
				cache: false,
				data: {
					aid: id,
					aactive: active,
					},
				success: function(data){
					$('#setactive-' + id).html(data);
				},
				error: function (){
					alert('Có lỗi xảy ra');
				}
			});
		}else{
			alert('thành viên này đã được kích hoạt');
		}
		
		return false;
	}
	</script>
</html>

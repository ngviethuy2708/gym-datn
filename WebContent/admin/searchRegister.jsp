<%@page import="java.util.Date"%>
<%@page import="bean.Register"%>
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
							<th>Số điện thoại</th>
							<th>Lịch tập</th>
							<th>Số ngày tập</th>
							<th>Số tiền</th>
							<th>Ngày bắt đầu</th>
							<th>Ngày kết thúc</th>
							<th>Nộp tiền</th>
							<th style="width:10px;">Sửa</th>
							<th style="width:10px;">Xóa</th>
							
						</tr>
					</thead>
					<tbody>
							<%
							TimeConvert cv = new TimeConvert();
							String dateStr = cv.getDateNow();
							Date dateNow = cv.getDateTime(dateStr);
					ArrayList<Register> alRegis = (ArrayList<Register>)request.getAttribute("alRegis");
					for(Register objRegis:alRegis){
						String imgActive = "";
						String isActive = "";
						int type;
						if(objRegis.isType()==true){
							isActive = "Kích hoạt";
							imgActive = request.getContextPath() + "/templates/admin/images/icon-success.png";
							type = 1;
						}else{
							isActive = "Ngừng kích hoạt";
							imgActive = request.getContextPath() + "/templates/admin/images/icon-fail.png";
							type = 0;
						}
						java.sql.Date dateSql = objRegis.getEndDate();
						Date objDate = cv.getNormalDate(dateSql);
					%>
						<tr>
							<td><%=objRegis.getIdRegister() %></td>
							<td><%=objRegis.getUserName() %></td>
							<td><%=objRegis.getFullName() %></td>
							<td><%=TimeConvert.getStringDatetime(objRegis.getBirthDay()) %></td>
							<td><%=objRegis.getPhoneNumber() %></td>
							<td><%=objRegis.getTrainingName() %></td>
							<td><%=objRegis.getTrainingDay() %></td>
							<td><%=objRegis.getTrainingPrice() %></td>
							<td><%=cv.getStringDatetime(objRegis.getBeginDate())%> </td>
							<% if(objDate.before(dateNow)) {%>
							<td><p style="color:red;"><%=cv.getStringDatetime(objRegis.getEndDate()) %></p></td>
							<%} else{ %>
							<td><%=cv.getStringDatetime(objRegis.getEndDate()) %></td>
							<%} %>
							<td class="align-center" id="setactive-<%=objRegis.getIdRegister() %>">
							<a href="javascript:void(0)" onclick="return setActive(<%=objRegis.getIdRegister() %>, <%=type %>)" title="<%=isActive %>"><img style="width:30px; height:30px;" src="<%=imgActive %>" alt=""></a>
							</td>
							<td><a href="<%=request.getContextPath()%>/admin/editRegister?rid=<%=objRegis.getIdRegister()%>"><i class="fa fa-edit"></i></a></td>
							<td><a onclick="return confirm('bạn có muốn xóa ko?')" href="<%=request.getContextPath()%>/admin/deleteRegister?rid=<%=objRegis.getIdRegister()%>"><i class="fa fa-times"></i></a></td>
						</tr>
					<%} %>					
						
					</tbody>
				</table>
				</div>
			</div>
			<script type="text/javascript">
	function setActive(id, active){
		$.ajax({
			url: '<%=request.getContextPath() %>/admin/ajaxRegister',
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
		return false;
	}
	</script>
			<!-- end main -->
			<%@include file="/templates/admin/inc/rightbar.jsp" %>
		</div>
		
	</div>
	<!-- end body -->
</body>
</html>

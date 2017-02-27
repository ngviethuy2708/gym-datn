<%@page import="bean.Training"%>
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
							<a href="<%=request.getContextPath()%>/admin/addTraining" class="btn btn-success create-button">Create</a>
		        		</p>
		    		</div>
		    	</div>
				<!-- end search form -->
				<div class="table-main">
					<table class="table table-bordered table-hover">
					<thead>
						<tr>
							<th>Id</th>
							<th>Tên lịch tập</th>
							<th>Số ngày tập</th>
							<th>Giá</th>
							<th style="width:10px;">Sửa</th>
							<th style="width:10px;">Xóa</th>
							
						</tr>
					</thead>
					<tbody>
					<%
					ArrayList<Training> alTraining = (ArrayList<Training>)request.getAttribute("alTraining");
					for(Training objTraining:alTraining){
					%>
						<tr>
							<td><%=objTraining.getIdTraining() %></td>
							<td><%=objTraining.getNameTraining() %></td>
							<td><%=objTraining.getDayTraining() %></td>
							<td><%=objTraining.getPriceTraining() %></td>
							<td><a href="<%=request.getContextPath()%>/admin/editTraining?tid=<%=objTraining.getIdTraining()%>"><i class="fa fa-edit"></i></a></td>
							<td><a onclick="return confirm('bạn có muốn xóa ko?')" href="<%=request.getContextPath()%>/admin/deleteTraining?tid=<%=objTraining.getIdTraining()%>"><i class="fa fa-times"></i></a></td>
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

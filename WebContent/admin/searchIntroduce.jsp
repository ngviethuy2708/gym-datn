<%@page import="bean.Introduce"%>
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
							<th>Lời giới thiệu</th>
							<th>Mô tả</th>
							<th>Hình ảnh</th>
							<th style="width:10px;">Sửa</th>
							<th style="width:10px;">Xóa</th>
							
						</tr>
					</thead>
					<tbody>
					<%
					ArrayList<Introduce> alIntro = (ArrayList<Introduce>)request.getAttribute("alIntro");
					for(Introduce objIntro:alIntro){
					%>
						<tr>
							<td><%=objIntro.getIdIntroduce() %></td>
							<td><%=objIntro.getNameIntroduce() %></td>
							<td><%=objIntro.getPreviewIntroduce() %></td>
							<td><img class="img-rounded" src="<%=request.getContextPath()%>/files/<%=objIntro.getPicture()%>" width="100px" height ="80px"></td>
							
							<td><a href="<%=request.getContextPath()%>/admin/editIntroduce?iid=<%=objIntro.getIdIntroduce()%>&type=load"><i class="fa fa-edit"></i></a></td>
							<td><a onclick="return confirm('bạn có muốn xóa ko?')" href="<%=request.getContextPath()%>/admin/deleteIntroduce?iid=<%=objIntro.getIdIntroduce()%>"><i class="fa fa-times"></i></a></td>
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

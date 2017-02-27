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
				<div class="search-form">
					<div class="col-md-4">
						<p>
							<a href="<%=request.getContextPath()%>/admin/addIntroduce?type=load" class="btn btn-success create-button">Create</a>
		        		</p>
		    		</div>
		    		<!--search form  -->
		    		<div class="col-md-5">
		    			<form class="form-inline" role="form" action="<%=request.getContextPath()%>/admin/searchIntroduce" method="post">
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
  						<li <%=active %>><a href="<%=request.getContextPath() %>/admin/indexIntroduce?page=<%=i%>"><%=i %></a></li>
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

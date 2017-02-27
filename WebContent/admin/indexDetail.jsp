<%@page import="bean.DetailBill"%>
<%@page import="bean.Product"%>
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
							<th>Số thứ tự</th>
							<th>Tên sản phẩm</th>
							<th>Hình ảnh</th>
							<th>Giá </th>
							<th>Số lượng</th>
							<th>Thành tiền</th>
						</tr>
					</thead>
					<tbody>
					
					<%
					int total = 0;
					ArrayList<DetailBill> alDetail = (ArrayList<DetailBill>)request.getAttribute("alDetail");
					for(DetailBill objDetail:alDetail){
						total += objDetail.getIntoMoney();
					%>
						<tr>
							<td><%=objDetail.getId() %></td>
							<td><%=objDetail.getNameProduct() %></td>
							<td><img class="img-rounded" src="<%=request.getContextPath()%>/files/<%=objDetail.getPictureProduct()%>" width="100px" height ="80px"></td>
							<td><%=objDetail.getPriceProduct() %></td>
							<td><%=objDetail.getNumOfProduct()%></td>
							<td><%=objDetail.getIntoMoney() %></td>
						</tr>
					<%} %>
						<tr class="danger" >
						<td><strong>Tổng tiền:</strong></td>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
						<td><span style="color:red;"><%=total %></span></td>
						</tr>

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

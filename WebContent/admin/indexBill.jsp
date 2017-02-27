<%@page import="java.rmi.server.ObjID"%>
<%@page import="bean.Bill"%>
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
		    		</div>
		    		<!--search form  -->
		    		<div class="col-md-10">
		    			<form class="form-inline" role="form" action="<%=request.getContextPath()%>/admin/searchBill" method="post">
 							<div class="form-group">
								<div name="type" class="radio">
  									<label><input type="radio" value="1" name="optradio" checked="checked"><strong>Đă thanh toán</strong></label>
								</div>
								<div name="type" class="radio">
  									<label><input type="radio" value="0" name="optradio"><strong>Chưa thanh toán</strong></label>
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
							<th>Thông tin thêm</th>
							<th>Phương thức thanh toán</th>
							<th>Ngày đặt hàng</th>
							<th>Thanh toán</th>
							<th>Chuyển hàng</th>
							<th style="width:10px;">Chi tiết</th>
							<th style="width:10px;">Xóa</th>
							
						</tr>
					</thead>
					<tbody>
					<%
					ArrayList<Bill> alBill = (ArrayList<Bill>)request.getAttribute("alBill");
					for(Bill objBill:alBill){
						String imgActive1 = "";
						String imgActive2 = "";
						String isActive = "";
						int type1;
						int type2;
						if(objBill.isTranfer()==true){
							isActive = "Kích hoạt";
							imgActive1 = request.getContextPath() + "/templates/admin/images/icon-success.png";
							type1 = 1;
						}else{
							isActive = "Ngừng kích hoạt";
							imgActive1 = request.getContextPath() + "/templates/admin/images/icon-fail.png";
							type1 = 0;
						}
						if(objBill.isShip()==true){
							isActive = "Kích hoạt";
							imgActive2 = request.getContextPath() + "/templates/admin/images/icon-success.png";
							type2 = 1;
						}else{
							isActive = "Ngừng kích hoạt";
							imgActive2 = request.getContextPath() + "/templates/admin/images/icon-fail.png";
							type2 = 0;
						}
					%>
						<tr>
							<td><%=objBill.getIdBill()%></td>
							<td><%=objBill.getUserName() %></td>
							<td><%=objBill.getFullName() %></td>
							<td><%=TimeConvert.getStringDatetime(objBill.getBirthDay()) %></td>
							<td><%=objBill.getAddress() %></td>
							<td><%=objBill.getPhone()%></td>
							<td><%=objBill.getInformation() %>
							<td><%=objBill.getNamePayment() %></td>
							<td><%=TimeConvert.getStringDatetime(objBill.getDateOrder()) %></td>
							<td class="align-center" id="setactive1-<%=objBill.getIdBill() %>">
							<a href="javascript:void(0)" onclick="return setActive1(<%=objBill.getIdBill() %>, <%=type1 %>)" title="<%=isActive %>"><img style="width:30px; height:30px;" src="<%=imgActive1 %>" alt=""></a>
							</td>
							<td class="align-center" id="setactive2-<%=objBill.getIdBill() %>">
							<a href="javascript:void(0)" onclick="return setActive2(<%=objBill.getIdBill() %>, <%=type2 %>)" title="<%=isActive %>"><img style="width:30px; height:30px;" src="<%=imgActive2 %>" alt=""></a>
							</td>
							<td><a href="<%=request.getContextPath()%>/admin/detailBill?bid=<%=objBill.getIdBill()%>"><i class="fa fa-eye"></i></a></td>
							<td><a onclick="return confirm('bạn có muốn xóa ko?')" href="<%=request.getContextPath()%>/admin/deleteBill?bid=<%=objBill.getIdBill()%>"><i class="fa fa-times"></i></a></td>
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
  						<li <%=active %>><a href="<%=request.getContextPath() %>/admin/indexBill?page=<%=i%>"><%=i %></a></li>
  					<%} %>
					</ul>
				</div>	
			</div>
			<!-- end main -->
				<script type="text/javascript">
	function setActive1(id, active){
		$.ajax({
			url: '<%=request.getContextPath() %>/admin/ajaxTranfer',
			type: 'POST',
			cache: false,
			data: {
				aid: id,
				aactive: active,
				},
			success: function(data){
				$('#setactive1-' + id).html(data);
			},
			error: function (){
				alert('Có lỗi xảy ra');
			}
		});
		return false;
	}
	function setActive2(id, active){
		$.ajax({
			url: '<%=request.getContextPath() %>/admin/ajaxShip',
			type: 'POST',
			cache: false,
			data: {
				aid: id,
				aactive: active,
				},
			success: function(data){
				$('#setactive2-' + id).html(data);
			},
			error: function (){
				alert('Có lỗi xảy ra');
			}
		});
		return false;
	}
	</script>
			<%@include file="/templates/admin/inc/rightbar.jsp" %>
		</div>
		
	</div>
	<!-- end body -->
</body>
</html>

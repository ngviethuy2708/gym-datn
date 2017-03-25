<%@page import="bean.Training"%>
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
				<div class="search-form">
					<div class="col-md-2">
						<p>
							<a href="<%=request.getContextPath()%>/admin/addUsers" class="btn btn-success create-button" style="margin-left: -16px;">Thêm người dùng</a>
		        		</p>
		    		</div>
		    		<!--search form  -->
		    		<div class="col-md-10">
		    			<form class="form-inline" role="form" action="<%=request.getContextPath()%>/admin/searchUsers" method="post">
 							<div class="form-group">
								<div name="type" class="radio">
  									<label><input type="radio" value="1" name="optradio" checked="checked"><strong>Hội viên</strong></label>
								</div>
								<div name="type" class="radio">
  									<label><input type="radio" value="0" name="optradio"><strong>Khách hàng</strong></label>
								</div> 
       						 </div>
  							<div class="form-group">
    							<input name="something" type="text" class="form-control" id="exampleInputPassword2" placeholder=".....">
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
							<th>ID</th>
							<th style="width:100px;">USERNAME</th>
							<th style="width: 121px;">HỌ TÊN</th>
							<th style="width:121px;">NGÀY SINH</th>
							<th style="width:150px;">ĐỊA CHỈ</th>
							<th style="width: 123px;">SỐ ĐIỆN THOẠI</th>
							<th>HỘI VIÊN</th>
							<th style="width:10px;">SỬA</th>
							<th style="width:10px;">XÓA</th>
							
						</tr>
					</thead>
					<tbody>
					<%
					ArrayList<User> alUser = (ArrayList<User>)request.getAttribute("alUser");
					for(User objUser:alUser){
					%>
						<tr>
							<td><%=objUser.getId() %></td>
							<td><%=objUser.getUserName() %></td>
							<td><%=objUser.getFullName() %></td>
							<td><%=TimeConvert.getStringDatetime(objUser.getBirthDay()) %></td>
							<td><%=objUser.getAddDress() %></td>
							<td><%=objUser.getPhoneNumber() %></td>
							<%if(objUser.isMember() == false){ %>
								<td><a href="" id="userId" data-id="<%=objUser.getId() %>"  data-toggle="modal" data-target="#Member"><img style="width:30px; height:30px;" src="<%=request.getContextPath() %>/templates/admin/images/icon-fail.png" alt=""></a></td>
							<%}else{ %>
								<td><img style="width:30px; height:30px;" src="<%=request.getContextPath() %>/templates/admin/images/icon-success.png" alt=""></td>
							<%} %>
							<td><a href="<%=request.getContextPath()%>/admin/editUsers?uid=<%=objUser.getId()%>"><i class="fa fa-edit"></i></a></td>
							<td><a onclick="return confirm('bạn có muốn xóa ko?')" href="<%=request.getContextPath()%>/admin/deleteUsers?uid=<%=objUser.getId()%>"><i class="fa fa-times"></i></a></td>
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
<!-- Modal -->
<div class="modal fade" id="Member" tabindex="-1" role="dialog" aria-labelledby="loginLabel">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header" style="background-color: #787878;">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="loginlLabel" style = "font-weight:bold; text-align:center; color:white;">LỊCH TẬP</h4>
      </div>
      <div class="modal-body">
		<input type="hidden" name="userID" value="">
       	<form class="form-horizontal form_register" role="form" method="post">
         	<div class="form-group">
    			<label for="inputEmail3" class="col-sm-3 control-label">Chọn lịch tập:</label>
   				<div class="col-sm-9">
      				<select id="training" style="width: 373px; height: 30px;">
      					<%
      					ArrayList<Training> alTraining = (ArrayList<Training>)request.getAttribute("alTraining");
      					for(Training objTraining:alTraining){
      					%>
      					<option id="<%=objTraining.getId() %>" discount="<%=objTraining.getDiscount()%>" price="<%=objTraining.getPrice()%>" idPrice="<%=objTraining.getPriceId()%>" idSale="<%=objTraining.getSaleId()%>" dateFrom="<%=objTraining.getFromDate()%>" dateTo="<%=objTraining.getToDate()%>" day_of_training="<%=objTraining.getDayOfTraining()%>"><%=objTraining.getName()%></option>
      					<%} %>
      				</select>
    			</div>
    			<div class="form-group" >
    				<label for="inputEmail3" class="col-sm-3 control-label" style="margin-left: -32px;">Giá gốc:</label>
   					<div class="col-sm-9" style="margin-top:8px;">
      					<span id="price" style="margin-left: 39px;"></span>
    				</div>
 				</div>
 				<div class="form-group">
    				<label for="inputEmail3" class="col-sm-3 control-label" style="margin-left: -25px;     margin-top: -13px;" >Giảm giá:</label>
   					<div class="col-sm-9" style="margin-top: -5px;">
      					<span id="discount" style="margin-left: 33px;"></span>
    				</div>
 				</div>
 				<div class="form-group">
    				<label for="inputEmail3" class="col-sm-3 control-label" style="margin-left: 29px; float: left; margin-top: -12px;">Giá sau khi giảm:</label>
   					<div class="col-sm-9" style="left: -196px; margin-top: -20px;">
      					<span id="curent_price" style="float:right;"></span>
    				</div>
 				</div>
 				<div class="form-group">
    				<label for="inputEmail3" class="col-sm-3 control-label" style="margin-left: -4px; float: left; margin-top: -12px;">Số ngày tập:</label>
   					<div class="col-sm-9" style="left: -376px; margin-top: -5px;">
      					<span id="day_of_training" style="float:right;"></span>
    				</div>
 				</div>
 			</div>
 			<div class="" style="text-align: right;">
        		<button type="button" class="btn btn-danger" data-dismiss="modal">Đóng</button>
       			<a id="addMember"><input class="button-add btn btn-success create-button" name="submit" type="submit" value="Xác nhận" /></a> 
     		</div>
        </form>
      </div>
    </div>
  </div>
</div>
<script>
function parseDate(dateStr) {
    var parts = dateStr.split("-");
    return new Date(parts[2], parts[1] - 1, parts[0]);
}
select_training();
$('#training').change(function(){
	select_training();
});
function select_training(){
	var training = $('#training option:selected');
	if (training) {
		var idTraining = training.attr('id');
		var price = training.attr('price');
		var discount = training.attr('discount');
		var priceId = training.attr('idPrice');
		var saleID = training.attr('idSale');
		
		var dateFrom = new Date(training.attr('dateFrom')).getTime();
		var dateTo = new Date(training.attr('dateTo')).getTime();
		
		var day_of_training = training.attr('day_of_training');
		
		var current_date = new Date().getTime();
		/* current_date.setHours(0, 0, 0, 0); */
		
		console.log(dateFrom);
		console.log(dateTo);
		console.log(current_date);
		if(saleID != 0){
			if((dateFrom <= current_date ) && (current_date <= dateTo  )){
				var curent_price = price - ((price*discount)/100);
				$('#price').html(price+" VNĐ");
				$('#discount').html(discount+" %");
				$('#curent_price').html(curent_price+" VNĐ");
				$('#day_of_training').html(day_of_training+" ngày");
			}else{
				$('#price').html(price+" VNĐ");
				$('#discount').html("0 %");
				$('#curent_price').html(price+" VNĐ");
				$('#day_of_training').html(day_of_training+" ngày");
			}
		}else{
			$('#price').html(price+" VNĐ");
			$('#discount').html("0 %");
			$('#curent_price').html(price+" VNĐ");
			$('#day_of_training').html(day_of_training+" ngày");
		}	
	}
}
</script>
<script>
$('#addMember').on('click', function() {
    var user_id =  $("#userId").attr("data-id");
	var training = $('#training option:selected');
	var training_id = 0;
	var price_id = 0;
	var sale_id = 0;
	if(training){
		training_id = training.attr('id');
		price_id = training.attr('idPrice');
		sale_id = training.attr('idSale');
	}
	$.ajax({
		type: 'GET',
		url: '<%=request.getContextPath() %>/admin/activeMember',
		data: {'userId': user_id, 'trainingId': training_id, 'priceId': price_id, 'saleId': sale_id },
		success: function(response) {
			console.log('abc');
		}
	});
});
</script>
</html>

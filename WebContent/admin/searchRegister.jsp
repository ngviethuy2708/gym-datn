<%@page import="bean.Training"%>
<%@page import="bean.Member"%>
<%@page import="java.util.Date"%>
<%@page import="library.TimeConvert"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<style>
</style>
<%@include file="/templates/admin/inc/header.jsp"%>
<!-- body -->
<div class="container">
	<div class="row">
		<!-- main -->
		<div class="col-md-10 main">
			<div class="col-md-2">
					<p>
						<a href="<%=request.getContextPath()%>/admin/indexRegister" class="btn btn-success create-button" style="margin-left: -16px; margin-top: 41px;">Quay lại</a>
		        	</p>
		    	</div>	
			<!-- end search form -->
			<span id="addHistoryErr" style="color: red;"></span>
			<div class="table-main">
				<table class="table table-bordered table-hover">
					<thead>
						<tr>
							<th><span style="font-size: 13px;">ID</span></th>
							<th><span style="font-size: 13px;">USERNAME</span></th>
							<th><span style="font-size: 13px;">HỌ TÊN</span></th>
							<th><span style="font-size: 13px;">lỊCH TẬP</span></th>
							<th style="width: 107px; text-align: center;"><span
								style="font-size: 13px;">SỐ NGÀY TẬP</span></th>
							<th style="width: 113px; text-align: center;"><span
								style="font-size: 13px;">SỐ NGÀY NGHỈ</span></th>
							<th style="width: 115px; text-align: center;"><span
								style="font-size: 13px;">NGÀY BẮT ĐẦU</span></th>
							<th style="width: 123px; text-align: center;"><span
								style="font-size: 13px;">NGÀY KẾT THÚC</span></th>
							<th style="width: 91px; text-align: center;"><span
								style="font-size: 13px;">THÔNG TIN</span></th>
							<!-- <th style="width: 91px; text-align: center;"><span
								style="font-size: 13px;">THÔNG TIN</span></th> -->
						</tr>
					</thead>
					<tbody>
						<%
						/* 	ArrayList<Member> alMember = (ArrayList<Member>)request.getAttribute("alMember"); 
													String color = "";
													for(Member objMember:alMember){
														if(objMember.getIsExpired() == false){
															color = "red";
														}else{
															color = "";
														} */
						ArrayList<Member> alMember = (ArrayList<Member>)request.getAttribute("alMember"); 
						String color = "";
						for(Member objMember:alMember){
								if(objMember.getIsExpired() == false){
									color = "red";
								}else{
									color = "";
								}
						%>
						<tr style="color:<%=color%>;">
							<td><%=objMember.getId()%></td>
							<td style="white-space: nowrap;"><%=objMember.getUserName()%></td>
							<td style="white-space: nowrap;"><%=objMember.getFullName()%></td>
							<td id="trainingName_<%=objMember.getId() %>"><%=objMember.getTrainingName()%></td>
							<td id="dayOfTraining_<%=objMember.getId()%>"><%=objMember.getDayOfTraining()%> ngày</td>
							<td id="dayOff_<%=objMember.getId()%>"><%=objMember.getDayOff()%> ngày</td>
							<td id="beginDate_<%=objMember.getId()%>"><%=TimeConvert.getStringDatetime(objMember.getBeginDay())%></td>
							<td id= "endDate_<%=objMember.getId()%>"><%=TimeConvert.getStringDatetime(objMember.getEndDay())%></td>
							<td style="text-align: center;"><a href="#"
								onclick="addHistory(<%=objMember.getIsExpired()%>,<%=objMember.getId()%>)"><i
									class="fa fa-plus"></i></a> / <a href="<%=request.getContextPath()%>/admin/viewHistory?mid=<%=objMember.getId()%>"><i class="fa fa-eye"></i></a>
							</td>
						<%-- 	<td style="text-align: center;"><a href="#"
								onclick="addHistory(<%=objMember.getIsExpired()%>,<%=objMember.getId()%>)"><i
									class="fa fa-plus"></i></a> / <a href="<%=request.getContextPath()%>/admin/viewHistory?mid=<%=objMember.getId()%>"><i class="fa fa-eye"></i></a>
							</td> --%>
							<%-- 	<td><%=objRegis.getTrainingPrice() %></td>
							<td><%=cv.getStringDatetime(objRegis.getBeginDate()) %></td>
							<% if(objDate.before(dateNow)) {%>
							<td><p style="color:red;"><%=cv.getStringDatetime(objRegis.getEndDate()) %></p></td>
							<%} else{ %>
							<td><%=cv.getStringDatetime(objRegis.getEndDate()) %></td>
							<%} %>
							<td class="align-center" id="setactive-<%=objRegis.getIdRegister() %>">
							<a href="javascript:void(0)" onclick="return setActive(<%=objRegis.getIdRegister() %>, <%=type %>)" title="<%=isActive %>"><img style="width:30px; height:30px;" src="<%=imgActive %>" alt=""></a>
							</td>
							<td><a href="<%=request.getContextPath()%>/admin/editRegister?rid=<%=objRegis.getIdRegister()%>"><i class="fa fa-edit"></i></a></td>
							<td><a onclick="return confirm('bạn có muốn xóa ko?')" href="<%=request.getContextPath()%>/admin/deleteRegister?rid=<%=objRegis.getIdRegister()%>"><i class="fa fa-times"></i></a></td> --%>
						</tr>
						<%
							}
						%>

					</tbody>
				</table>
			</div>
		</div>
		<!-- end main -->
		<!-- Modal -->
		<div class="modal fade" id="addHistory" tabindex="-1" role="dialog"
			aria-labelledby="loginLabel">
			<div class="modal-dialog" role="document">
				<div class="modal-content">
					<div class="modal-header" style="background-color: #787878;">
						<button type="button" class="close" data-dismiss="modal"
							aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
						<h4 class="modal-title" id="loginlLabel"
							style="font-weight: bold; text-align: center; color: white;">LỊCH
							TẬP</h4>
					</div>
					<div class="modal-body">
						<input type="hidden" name="userID" value="">
						<form id="form_active" class="form-horizontal form_register" role="form"
							action= "<%=request.getContextPath() %>/admin/addHistoryMemberForSort" method="post">
							<div class="form-group">
								<label for="inputEmail3" class="col-sm-3 control-label">Chọn
									lịch tập:</label>
								<div class="col-sm-9">
									<select id="training" style="width: 373px; height: 30px;">
										<%
											ArrayList<Training> alTraining = (ArrayList<Training>)request.getAttribute("alTraining");
																		      					for(Training objTraining:alTraining){
										%>
										<option training_name="<%=objTraining.getName()%>"
											day_of_training="<%=objTraining.getDayOfTraining()%>"
											id="<%=objTraining.getId()%>"
											discount="<%=objTraining.getDiscount()%>"
											price="<%=objTraining.getPrice()%>"
											idPrice="<%=objTraining.getPriceId()%>"
											idSale="<%=objTraining.getSaleId()%>"
											dateFrom="<%=objTraining.getFromDate()%>"
											dateTo="<%=objTraining.getToDate()%>"
											day_of_training="<%=objTraining.getDayOfTraining()%>"><%=objTraining.getName()%></option>
										<%
											}
										%>
									</select>
								</div>
								<div class="form-group">
									<label for="inputEmail3" class="col-sm-3 control-label"
										style="margin-left: -32px;">Giá gốc:</label>
									<div class="col-sm-9" style="margin-top: 8px;">
										<span id="price" style="margin-left: 39px;"></span>
									</div>
								</div>
								<div class="form-group">
									<label for="inputEmail3" class="col-sm-3 control-label"
										style="margin-left: -25px; margin-top: -13px;">Giảm
										giá:</label>
									<div class="col-sm-9" style="margin-top: -5px;">
										<span id="discount" style="margin-left: 33px;"></span>
									</div>
								</div>
								<div class="form-group">
									<label for="inputEmail3" class="col-sm-3 control-label"
										style="margin-left: 29px; float: left; margin-top: -12px;">Giá
										sau khi giảm:</label>
									<div class="col-sm-9" style="left: -196px; margin-top: -20px;">
										<span id="curent_price" style="float: right;"></span>
									</div>
								</div>
								<div class="form-group">
									<label for="inputEmail3" class="col-sm-3 control-label"
										style="margin-left: -4px; float: left; margin-top: -12px;">Số
										ngày tập:</label>
									<div class="col-sm-9" style="left: -376px; margin-top: -5px;">
										<span id="day_of_training" style="float: right;"></span>
									</div>
								</div>
							</div>
							<div class="" style="text-align: right;">
								<button type="button" class="btn btn-danger"
									data-dismiss="modal">Đóng</button>
								<a href="#" id="addMember"><input
									class="button-add btn btn-success create-button" name="submit"
									type="submit" value="Xác nhận" /></a>
							</div>
							<input type="hidden" id="member_id" name="memberId" value="">
     						<input type="hidden" id="training_id" name="trainingId" value="">
     						<input type="hidden" id="price_id" name="priceId" value="">
     						<input type="hidden" id="sale_iD" name="saleId" value="">
						</form>
					</div>
				</div>
			</div>
		</div>
<script type="text/javascript">
	select_training();
	$('#training').change(function(){
		select_training();
	});
	function select_training(){
		var training = $('#training option:selected');
		if (training) {
			var idTraining = training.attr('id');
			$('#training_id').val(idTraining);
			var price = training.attr('price');
			var discount = training.attr('discount');
			var priceId = training.attr('idPrice');
			$('#price_id').val(priceId);
			var saleID = training.attr('idSale');
			$('#sale_iD').val(saleID);
			var dateFrom = new Date(training.attr('dateFrom')).getTime();
			var dateTo = new Date(training.attr('dateTo')).getTime();
			
			var day_of_training = training.attr('day_of_training');
			
			var current_date = new Date().getTime();
			/* current_date.setHours(0, 0, 0, 0); */
			if(saleID != 0){
				if((dateFrom < current_date || dateFrom == current_date ) && (current_date < dateTo || current_date == dateTo )){
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
	function addHistory(is_expired,id_member){
		if(is_expired == true){
			swal({   title: "Hội viên chưa hết hạn",   text: "",   timer: 2000,   showConfirmButton: false });
		}else if(is_expired == false){
			$('#addHistory').modal('show');
			$('#member_id').val(id_member);
			$('#form_active').submit();
		}
	};
	</script>
		<%@include file="/templates/admin/inc/rightbar.jsp"%>
	</div>

</div>
<!-- end body -->
</body>
</html>

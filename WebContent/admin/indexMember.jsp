<%@page import="java.util.Date"%>
<%@page import="bean.Training"%>
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
							<a href="<%=request.getContextPath()%>/admin/addTraining?type=load" class="btn btn-success create-button" style="margin-left: -13px;">Tạo gói tập</a>
		        		</p>
		    		</div>
		    		<!--search form  -->
		    		<div class="col-md-10">
		    			<form class="form-inline" role="form" action="<%=request.getContextPath()%>/admin/searchTraining" method="post">
 							<div class="form-group">
								<div name="type" class="radio">
  									<label><input type="radio" value="1" name="optradio" checked="checked"><strong>Đã kích hoạt</strong></label>
								</div>
								<div name="type" class="radio">
  									<label><input type="radio" value="0" name="optradio"><strong>Chưa kích hoạt</strong></label>
								</div> 
       						 </div>
  							<div class="form-group">
    							<input name="something" type="text" class="form-control" id="exampleInputPassword2" placeholder=".....">
  							</div>
  							<input class="button-add btn btn-primary create-button" name="submit" type="submit" value="Tìm kiếm" /> 
						</form>
		    		</div>
		    	</div>
		    	
				<div class="table-main">
					<table class="table table-bordered table-hover">
					<thead>
						<tr>
							<th>USERNAME</th>
							<th>HỌ VÀ TÊN</th>
							<th>TÊN LỊCH TẬP</th>
							<th>SỐ NGÀY TẬP</th>
							<th>NGÀY BĂT ĐẦU</th>
							<th>NGÀY KẾT THÚC</th>
						</tr>
					</thead>
					<tbody>
					<%
					ArrayList<Training> alTraining = (ArrayList<Training>)request.getAttribute("alTraining");
					for(Training objTraining:alTraining){
						String imgActive = "";
						String isActive = "";
						int type;
						if(objTraining.isActive() == true){
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
							<td><%=objTraining.getId() %></td>
							<td><img class="img-rounded" src="<%=request.getContextPath()%>/files/<%=objTraining.getPicture()%>" width="100px" height ="80px"></td>
							<td><%=objTraining.getName()%></td>
							<td><%=TimeConvert.getStringDatetime(objTraining.getDateCreate())%></td>
							<td><%=objTraining.getPreview() %></td>
							<td><%=objTraining.getDayOfTraining() %> ngày</td> 
							<td>
							<%if(objTraining.getDiscount()!=0) {%>
							<%=objTraining.getPrice()%> VNĐ (Đang giảm giá <%=objTraining.getDiscount()%>%)
							<%}else{ %>
							<%=objTraining.getPrice()%> VNĐ
							<%} %>
							</td>
							<td class="align-center" id="setactive-<%=objTraining.getId() %>">
								<a href="javascript:void(0)" onclick="return setActive(<%=objTraining.getId() %>, <%=type %>)" title="<%=isActive %>"><img style="width:30px; height:30px;" src="<%=imgActive %>" alt=""></a>
							</td>
							<td><a href="<%=request.getContextPath()%>/admin/editTraining?tid=<%=objTraining.getId()%>&type=load"><i class="fa fa-edit"></i></a></td>
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
  						<li <%=active %>><a href="<%=request.getContextPath() %>/admin/indexTraining?page=<%=i%>"><%=i %></a></li>
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
<script type="text/javascript">
	function setActive(id, active){
		$.ajax({
			url: '<%=request.getContextPath() %>/admin/activeTraining',
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
</html>

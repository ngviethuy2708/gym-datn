<%@page import="bean.Training"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/templates/admin/inc/header.jsp" %>
	
	<%
	String output = "";
	if(request.getParameter("msg") != null){
						String msg = request.getParameter("msg");
						if("edit0".equals(msg)){
							output ="lịch tập đã tồn tại!";
						}
	}
	Training objTraining = (Training)request.getAttribute("objTraining");
	%>
	<div class="container">
		<div class="row body-form">
			<div class="col-md-12">
				<form class="form-horizontal form_editTraining" role="form" method="post" action="<%=request.getContextPath() %>/admin/editTraining?tid=<%=objTraining.getIdTraining()%>">
					<div class="form-group">
    					<label for="inputEmail3" class="col-sm-2 control-label">Tên lịch tập</label>
   						<div class="col-sm-10">
      						<input type="text" name="trainingName" value="<%=objTraining.getNameTraining() %>" class="form-control required" id="username" placeholder="">
      						<% if(!output.equals("")){%>
      						<p style="color:red;" >
								<%=output %>
								</p>
      						<%} %>
    					</div>
 					</div>
 					<div class="form-group">
    					<label for="inputEmail3" class="col-sm-2 control-label">Số ngày tập</label>
   						<div class="col-sm-10">
      						<input type="text" name="trainingDay" value="<%=objTraining.getDayTraining() %>" class="form-control" id="password" placeholder="">
      						
    					</div>
 					</div>
 					<div class="form-group">
    					<label for="inputEmail3" class="col-sm-2 control-label">Giá</label>
   						<div class="col-sm-10">
      						<input type="text" name="trainingPrice" value="<%=objTraining.getPriceTraining() %>" class="form-control" id="fullname" placeholder="">
      						
    					</div>
 					 </div>
 					<div class="form-group">
    					<div class="col-sm-offset-2 col-sm-10">
     						<p>
								<input class="button-add btn btn-success create-button" name="sua" type="submit" value="Sửa" /> 
		        			</p>
    					</div>
  					</div>
  					
				</form>
				<script type="text/javascript">
$( document ).ready(function() {
	$(".form_editTraining").validate({
		rules: {
			trainingName: {
				required: true,
			},
			trainingDay: {
				required: true,
				number: true
			},
			trainingPrice: {
				required: true,
				number: true
			}
		},
		messages: {
			trainingName: {
				required: "<span style='color:red;font-weight:bold;font-size:13px;'>Vui lòng nhập lịch tập!</span>",
			},
			trainingDay: {
				required: "<span style='color:red;font-weight:bold;font-size:13px;'>Vui lòng nhập số ngày tập!</span>",
				number: "<span style='color:red;font-weight:bold;font-size:13px;'>Kiểu dữ liệu không phải là số!</span>",
			},
			trainingPrice: {
				required: "<span style='color:red;font-weight:bold;font-size:13px;'>Vui lòng nhập giá!</span>",
				number: "<span style='color:red;font-weight:bold;font-size:13px;'>Kiểu dữ liệu không phải là số!</span>",
			}
		}
	});
});
</script>

			</div>
		</div>
	</div>
	
</body>
</html>
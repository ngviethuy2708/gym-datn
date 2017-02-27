<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/templates/admin/inc/header.jsp" %>
	
	<%
	String output = "";
	if(request.getParameter("msg") != null){
						String msg = request.getParameter("msg");
						if("add0".equals(msg)){
							output ="Lịch tập đã tồn tại!";
						}
	}					
	%>
	<div class="container">
		<div class="row body-form">
			<div class="col-md-12">
				<form  novalidate="novalidate "  class="form-horizontal form_addTraining" role="form" method="post" action="<%=request.getContextPath() %>/admin/addTraining">
					<div class="form-group">
    					<label for="inputEmail3" class="col-sm-2 control-label">Tên lịch tập</label>
   						<div class="col-sm-10">
      						<input type="text" name="trainingName" class="form-control required" id="username" placeholder="" >
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
      						<input type="text" name="trainingDay" class="form-control"  placeholder="">
    					</div>
 					</div>
 					<div class="form-group">
    					<label for="inputEmail3" class="col-sm-2 control-label">Giá</label>
   						<div class="col-sm-10">
      						<input type="text" name="trainingPrice" class="form-control"  placeholder="">
    					</div>
 					 </div>
 					<div class="form-group">
    					<div class="col-sm-offset-2 col-sm-10">
     						<p>
								<input class="button-add btn btn-success create-button" name="submit" type="submit" value="Thêm" /> 
		        			</p>
    					</div>
  					</div>
  					
				</form>

			</div>
		</div>
	</div>
	<script type="text/javascript">
$( document ).ready(function() {
	$(".form_addTraining").validate({
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
</body>
</html>
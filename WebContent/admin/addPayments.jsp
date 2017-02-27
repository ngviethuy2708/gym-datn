<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/templates/admin/inc/header.jsp" %>
	
	<%
	String output = "";
	if(request.getParameter("msg") != null){
						String msg = request.getParameter("msg");
						if("add0".equals(msg)){
							output ="Hình thức thanh toán đã tồn tại";
						}
	}					
	%>
	<div class="container">
		<div class="row body-form">
			<div class="col-md-12">
				<form  novalidate="novalidate "  class="form-horizontal form_addPayments" role="form" method="post" action="<%=request.getContextPath() %>/admin/addPayments">
					<div class="form-group">
    					<label for="inputEmail3" class="col-sm-2 control-label">Hình thức thanh toán</label>
   						<div class="col-sm-10">
      						<input style="width: 500px;"  type="text" name="paymentsName" class="form-control required" id="username" placeholder="" >
      						<% if(!output.equals("")){%>
      						<p style="color:red;" >
								
								<%=output %>
								</p>
      						<%} %>
    					</div>
 					</div>
 					<div class="form-group">
    					<label for="inputEmail3" class="col-sm-2 control-label">Chi tiết thanh toán</label>
   						<div class="col-sm-10">
      						<input style="width: 500px;" type="text" name="paymentsDetail" class="form-control required" id="username" placeholder="" >
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
	$(".form_addPayments").validate({
		rules: {
			paymentsName: {
				required: true,
			}
		},
		messages: {
			paymentsName: {
				required: "<span style='color:red;font-weight:bold;font-size:13px;'>Vui lòng nhập hình thức thanh toán!</span>",
			}
		}
	});
});
</script>
</body>
</html>
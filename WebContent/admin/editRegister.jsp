<%@page import="bean.Register"%>
<%@page import="bean.Training"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Date"%>
<%@page import="library.TimeConvert"%>
<%@page import="bean.Users"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/templates/admin/inc/header.jsp" %>
	
	<%
	ArrayList<Training> alTraining = (ArrayList<Training>)request.getAttribute("alTraining");
	TimeConvert cv = new TimeConvert();
	Register objRegister = (Register)request.getAttribute("objRegis");
	Date date1 = objRegister.getBeginDate();
	String beginDate = cv.getStringDatetime(date1);
	Date  date2 = objRegister.getEndDate();
	String endDate = cv.getStringDatetime(date2);
	%>
	<div class="container">
		<div class="row body-form">
			<div class="col-md-12">
				<form class="form-horizontal form_editRegister" role="form" method="post" action="<%=request.getContextPath() %>/admin/editRegister?rid=<%=objRegister.getIdRegister()%>">
					<input type ="hidden" name="idUsers" value="<%=objRegister.getIdUsers()%>"></span>
					<div class="form-group">
    					<label for="inputEmail3" class="col-sm-2 control-label">Username</label>
   						<div class="col-sm-10">
      						<input type="text" name="userName" value = "<%=objRegister.getUserName() %>" disabled class="form-control" id="password" placeholder="Email">
      						<span id="passWord_error"></span>
    					</div>
 					</div>
 					<div class="form-group">
    					<label for="inputEmail3" class="col-sm-2 control-label">Fullname</label>
   						<div class="col-sm-10">
      						<input type="text" name="beginDate" value = "<%=objRegister.getFullName() %>" disabled class="form-control" id="password" placeholder="Email">
      						<span id="passWord_error"></span>
    					</div>
 					</div>
					<div class="form-group">
    					<label for="inputEmail3" class="col-sm-2 control-label">Lịch tập</label>
					<div class ="col-sm-3">
   						<select class="btn btn-primary" name="combobox"  >
  							<%
  							String active = "";
  							for(Training objTraining:alTraining){ 
  								if(objRegister.getIdTraining() ==  objTraining.getIdTraining()){
  									active = "selected";
  								}else{
  									active = "";
  								}
  							%>
  							<option value="<%=objTraining.getIdTraining()%>" <%=active %>><%=objTraining.getNameTraining() %></option>
 							<%} %>
						</select>
						</div>
 					</div>
 					
 					<div class="form-group">
    					<label for="inputEmail3" class="col-sm-2 control-label">Ngày bắt đầu</label>
   						<div class="col-sm-10">
      						<input type="text" name="beginDate" value = "<%=beginDate %>" class="form-control myDateFormat" id="password" placeholder="dd/MM/yyyy">
      						<span id="passWord_error"></span>
    					</div>
 					</div>
 					<div class="form-group">
    					<label for="inputEmail3" class="col-sm-2 control-label">Ngày kết thúc</label>
   						<div class="col-sm-10">
      						<input type="text" name="endDate" value = "<%=endDate %>" class="form-control myDateFormat" id="fullname" placeholder="dd/MM/yyyy">
      						<span id="fullName_error"></span>
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
		$.validator.addMethod(
			    "myDateFormat",
			    function(value, element) {
			        // yyyy-mm-dd
			        var re = /^(\d{1,2})(\/|-)(\d{1,2})(\/|-)(\d{4})$/;

			        // valid if optional and empty OR if it passes the regex test
			        return (this.optional(element) && value=="") || re.test(value);
			    }
			);
		$( document ).ready(function() {
			$(".form_editRegister").validate({
				rules: {
					beginDate: {
						required: true,
						date: true
					},
					endDate: {
						required: true,
						date: true
					},
					
				},
				messages: {
				
					beginDate: {
						required: "<span style='color:red;font-weight:bold;font-size:13px;'>Vui lòng nhập ngày bắt đầu!</span>",
						myDateFormat : "<span style='color:red;font-weight:bold;font-size:13px;'>Sai định dạng ngày tháng năm(dd/MM/YYYY)</span>"
					},
					endDate: {
						required: "<span style='color:red;font-weight:bold;font-size:13px;'>Vui lòng nhập ngày kết thúc!</span>",
						myDateFormat : "<span style='color:red;font-weight:bold;font-size:13px;'>Sai định dạng ngày tháng năm(dd/MM/YYYY)</span>"
					},
					
				}
			});
		});
</script>
			</div>
		</div>
	</div>
	
</body>
</html>
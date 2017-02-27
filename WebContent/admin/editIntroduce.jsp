<%@page import="bean.Introduce"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/templates/admin/inc/header.jsp" %>
	
<%
Introduce objIntro = (Introduce)request.getAttribute("objIntro");
%>
	<div class="container">
		<div class="row body-form">
			<div class="col-md-12">
				<form class="form-horizontal form_editIntroduce" enctype="multipart/form-data" role="form" method="post" action="<%=request.getContextPath() %>/admin/editIntroduce?iid=<%=objIntro.getIdIntroduce()%>">
					<div class="form-group">
    					<label for="inputEmail3" class="col-sm-2 control-label">lời giới thiệu</label>
   						<div class="col-sm-10">
      						<input type="text" value= "<%=objIntro.getNameIntroduce() %>" name="nameIntroduce" style="width:587px;" class="form-control required" id="username" placeholder="">
    					</div>
 					</div>
 					<div class="form-group">
    					<label for="inputEmail3" class="col-sm-2 control-label">Mô tả</label>
   						<div class="col-sm-10">
      						<textarea name="preview"  rows="7" cols="90" class="input-medium"><%=objIntro.getPreviewIntroduce() %></textarea>
    					</div>
 					</div>
 					<div class="form-group">
    					<label for="inputEmail3" class="col-sm-2 control-label">Chi tiết</label>
   						<div class="col-sm-10">
      						<textarea name="detail"  rows="7" cols="90" class="input-medium"><%=objIntro.getDetailIntroduce() %></textarea>
    					</div>
 					 </div>
 					<div class="form-group">
    					<label for="inputEmail3" class="col-sm-2 control-label">Hình ảnh</label>
   						<div class="col-sm-10">
   						<%if (!objIntro.getPicture().isEmpty()) {
   							String imgPath = request.getContextPath() + "/files/" + objIntro.getPicture();
   						 %>
   						 <input type="hidden" name="pictureOld" value="<%=objIntro.getPicture()%>" />
   						 <img class="img-rounded"  src="<%=imgPath%>" width="100px" height ="80px">
   						 <%} %>
      						<input type="file"  name="picture" value="" />
    					</div>
 					</div>
 					<div class="form-group">
    					<div class="col-sm-offset-2 col-sm-10">
     						<p>
								<input class="button-add btn btn-success create-button" name="submit" type="submit" value="Sửa" /> 
		        			</p>
    					</div>
  					</div>
  					
				</form>
				<script type="text/javascript">
				CKEDITOR.replace( 'detail' );
$( document ).ready(function() {
	$(".form_editIntroduce").validate({
		rules: {
			nameIntroduce: {
				required: true,
			},
			preview: {
				required: true,
			},
			detail: {
				required: true,
			}
		},
		messages: {
			nameIntroduce: {
				required: "<span style='color:red;font-weight:bold;font-size:13px;'>Vui lòng nhập lời giới thiệu!</span>",
			},
			preview: {
				required: "<span style='color:red;font-weight:bold;font-size:13px;'>Vui lòng nhập mô tả!</span>",
			},
			detail: {
				required: "<span style='color:red;font-weight:bold;font-size:13px;'>Vui lòng nhập chi tiết</span>"	
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
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/templates/admin/inc/header.jsp" %>
	

	<div class="container">
		<div class="row body-form">
			<div class="col-md-12">
				<form class="form-horizontal form_addProduct" enctype="multipart/form-data" role="form" method="post" action="<%=request.getContextPath() %>/admin/addProduct">
					<div class="form-group">
    					<label for="inputEmail3" class="col-sm-2 control-label">Tên sản phẩm</label>
   						<div class="col-sm-10">
      						<input type="text" name="nameProduct" style="width:587px;" class="form-control required" id="username" placeholder="">
    					</div>
 					</div>
 					<div class="form-group">
    					<label for="inputEmail3" class="col-sm-2 control-label">Mô tả</label>
   						<div class="col-sm-10">
      						<textarea name="preview"  rows="7" cols="90" class="input-medium"></textarea>
    					</div>
 					</div>
 					<div class="form-group">
    					<label for="inputEmail3" class="col-sm-2 control-label">Chi tiết</label>
   						<div class="col-sm-10">
      						<textarea name="detail"  rows="7" cols="90" class="input-medium"></textarea>
    					</div>
 					 </div>
 					 <div class="form-group">
    					<label for="inputEmail3" class="col-sm-2 control-label">Giá</label>
   						<div class="col-sm-10">
      						<textarea name="price"  rows="7" cols="90" class="input-medium"></textarea>
    					</div>
 					 </div>
 					<div class="form-group">
    					<label for="inputEmail3" class="col-sm-2 control-label">Hình ảnh</label>
   						<div class="col-sm-10">
      						<input type="file"  name="picture" value="" />
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
				<script type="text/javascript">
				CKEDITOR.replace( 'detail' );
$( document ).ready(function() {
	$(".form_addProduct").validate({
		rules: {
			nameProduct: {
				required: true,
			},
			preview: {
				required: true,
			},
			detail: {
				required: true,
			},
			price: {
				required: true,
				number: true
			}
		},
		messages: {
			nameProduct: {
				required: "<span style='color:red;font-weight:bold;font-size:13px;'>Vui lòng nhập lời giới thiệu!</span>"
			},
			preview: {
				required: "<span style='color:red;font-weight:bold;font-size:13px;'>Vui lòng nhập mô tả!</span>"
			},
			detail: {
				required: "<span style='color:red;font-weight:bold;font-size:13px;'>Vui lòng nhập chi tiết</span>"	
			},
			price: {
				required: "<span style='color:red;font-weight:bold;font-size:13px;'>Vui lòng nhập giá bán</span>",
				number:  "<span style='color:red;font-weight:bold;font-size:13px;'>Dữ liệu bạn nhập không phải là số</span>"	
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
<%@page import="model.ModelProduct"%>
<%@page import="bean.Product"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<!-- right bar -->
					<div class="col-md-4">
					<div class="title-section-rb">
						<nav class="navbar navbar-inverse">
							<p style="margin-top:10px;"><i class="fa fa-cart-plus"></i><span style="margin-left:5px;"class="animated flash animation-delay-11">GIỎ HÀNG</span></p>
						</nav>
					</div>
					<div class="row main-section-rb">
						<div class="col-md-12" style="">
							<div class="row detail-section-rb">
								<div id = "Cart">
								<%
								HttpSession ss = request.getSession();
								ArrayList<Product> alCart2 = (ArrayList<Product>)ss.getAttribute("alCart");
								if(alCart2 != null && alCart2.size() > 0){
								%>
								<% int tongtien = 0; %>
									<table class="table table-bordered " style="margin-top: 24px; margin-left: -14px;">
										<thead>
											<tr>
											<th>Sản phẩm</th>
											<th>Số lượng</th>
											<th>Thành tiền</th>
											</tr>
										</thead>
										<tbody>
											<%for(Product objPro2:alCart2){ %>
											<%tongtien += objPro2.getPriceBuy(); %>
											<tr>
											<td><%=objPro2.getNameProduct() %></td>
											<td><%=objPro2.getNumber() %></td>
											<td><%=objPro2.getPriceBuy() %></td>
											</tr>
											<%} %>
											<tr>
											<td colspan = 2 style="font-weight:bold;">Tổng tiền</td>
											<td><%=tongtien%></td>
											</tr>
										</tbody>
									</table>
									<p>
										<a href="<%=request.getContextPath() %>/indexCart" style ="font-weight:bold; color:#337AB7; margin-left:30px;">+ Xem giỏ hàng</a>
									</p>
								<%}else{ %> 
								<span style="position: relative; bottom: -6px;left: 64px;">Rỗng,chưa có sản phẩm nào!</span>
								<%} %>
								</div>
							</div>
						</div>
					</div>

				</div>
				<div class="col-md-4">
					<div class="title-section-rb">
						<nav class="navbar navbar-inverse">
							<p style="margin-top:10px;"><i class="fa fa-search"></i><span style="margin-left:5px;"class="animated flash animation-delay-11">TÌM KIẾM SẢN PHẨM</span></p>
						</nav>
					</div>
					<div class="row main-section-rb" style="position:absolute;">
						<div class="col-md-12">
							<div class="row detail-section-rb">
							<form class="form-inline" role="form" action="<%=request.getContextPath()%>/searchProduct" method="post" style="margin-top:13px;">
									<div class="form-group">
										Sản phẩm 									
										<input style="width:90px;"name="proCategories" type="text" class="form-control"  placeholder="">
										sản xuất tại 
										<input style="width:90px;"name="madeIn" type="text" class="form-control"  placeholder="">
									</div>
									<input style="margin-top:20px; margin-left:120px;" class="button-add btn btn-primary create-button" name="submit" type="submit" value="Tìm kiếm" /> 
								</form>
							</div>
						</div>
					</div>

				</div>
					<!-- end rightbar -->
<script type="text/javascript">
	function buyProduct(id,name,picture,price){
		var number = $('#number').val();
		$.ajax({
			url: '<%=request.getContextPath() %>/ajaxBuyProduct',
			type: 'POST',
			cache: false,
			data: {
				aid : id,
				aname : name,
				apicture : picture,
				aprice : price,
				anumber : number
				},
			success: function(data){
				$('#Cart').html(data);
			},
			error: function (){
				alert('Có lỗi xảy ra');
			}
		});
		return false;
	}
</script>
				</div>
			</div>
		</div><!-- end body -->
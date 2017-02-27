<%@page import="bean.News"%>
<%@page import="bean.Introduce"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@include file="/templates/public/inc/header.jsp" %>
	<!-- body -->
	<div class="main-content">
			<div class="container">
				<div class="row main-section">
					<div class="col-md-8">
					<!-- section1 -->
						<div class="section">
						 	<div class="title-section">
						 		<div class="col-md-12">	
						 			<nav class="navbar navbar-inverse">
  										<p><span class="animated flash animation-delay-11">CHI TIẾT SẢN PHẨM</span></p>
									</nav>
							
								</div>
							</div>
							<div class="row main-section">
							<%
							Product objPro = (Product)request.getAttribute("objPro");
							%>
								<div class="col-md-12">
									<div class="row detail-section-index">
										<div class="col-md-12">
											<a href="#" class=""><h4><%=objPro.getNameProduct() %></h4></a>
										</div>
										<div class="review">
											
										<div class="col-md-6">
											<div class="col-md-12">
												<img class="img-rounded" src="<%=request.getContextPath()%>/files/<%=objPro.getPicture()%>" width="300px" height ="200px">
											</div>
										</div>
										<div class="col-md-6">
											<p><%=objPro.getPreviewProduct()%></p>
											<div class="wraper">
											<%if(objPro.isTypeProduct() == true){ %>
												<span style="font-weight:bold;">Giá:</span>
												<span style="color:red;"><%=objPro.getPriceProduct() %> VNĐ</span>
												<form class="form-horizontal form_addUsers" role="form" method="post" action="">
													<label style="margin-left: -33px;" class=" col-sm-4 control-label">Số lượng</label>
													<input type="text" name="number" class="form-control required col-sm-4" id="number" placeholder="" style="width:50px;">
												</form>
												<%
												HttpSession ss = request.getSession();
												if(ss.getAttribute("objUser") == null){%>
												<a href="<%=request.getContextPath()%>/checkLoginBuyProduct"  style="margin-left: 75px;"><button type="button" class="btn btn-info">Đặt mua</button></a>
												<%}else{ %>
												<a href="javascript:void(0)" onclick = "return buyProduct('<%=objPro.getIdProduct() %>','<%=objPro.getNameProduct() %>','<%=objPro.getPicture() %>','<%=objPro.getPriceProduct() %>')"  style="margin-left: 75px;"><button type="button" class="btn btn-info">Đặt mua</button></a>
												<%} %>
											<%}else{ %>
												<a href="#"  style="margin-left: 173px;"><button type="button" class="btn btn-danger">Đã hết hàng</button></a>
											<%} %>
											</div>
										</div>
										</div>
									</div>
								</div>
								<div class ="col-md-12">
									<div class ="detail-section-product">
										<p><%=objPro.getDetailProduct() %></p>
									</div>
								</div>

							</div>
						</div>
						<!-- end section 1 -->
						
					</div>
					<%@include file="/templates/public/inc/rightbarProduct.jsp" %>

		<%@include file="/templates/public/inc/footer.jsp" %>
<%@page import="bean.Excercises"%>
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
  										<p><span class="animated flash animation-delay-11">BÀI TẬP GYM</span></p>
									</nav>
							
								</div>
							</div>
							<div class="row main-section">
							<%
							Excercises objEx = (Excercises)request.getAttribute("objEx");
							%>
								<div class="col-md-12">
									<div class="row detail">
										<div class="col-md-12">
											<h4><%=objEx.getNameExcercise() %></h4>
										</div>
										<div class="col-md-6">
											<p><%=objEx.getDetailExcercise() %></p>
										</div>
									</div>
								</div>			
							</div>
						</div>
						<!-- end section 1 -->
						
					</div>
					<%@include file="/templates/public/inc/rightbar.jsp" %>
		<%@include file="/templates/public/inc/footer.jsp" %>
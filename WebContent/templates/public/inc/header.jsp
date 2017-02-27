<%@page import="library.TimeConvert"%>
<%@page import="bean.Users"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta charset="utf-8">
	<title>Gym</title>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7" crossorigin="anonymous">
	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/templates/public/css/style.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
  	<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
  	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/templates/public/css/animate.css">
  	<link rel="stylesheet" href="http://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.6.3/css/font-awesome.min.css">
	<script type="text/javascript" src="https://code.jquery.com/jquery-3.1.0.min.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/templates/admin/js/jquery.validate.js"></script>
  	<script src="<%=request.getContextPath() %>/templates/public/sweetalert-master/dist/sweetalert.min.js"></script>
  	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/templates/public/sweetalert-master/dist/sweetalert.css">
</head>
<body>
	<!-- header -->
	<header id="header">
		<nav class="navbar st-navbar ">
			<div class="container">
				<div class="navbar-header">
					<img class="logo" src="<%=request.getContextPath() %>/templates/public/images/logo-gym.png">
				</div>
				<div class="nav navbar-nav navbar-right ">
					<div class="header-login dropdown animated fadeInDown animation-delay-11">	
						<%
						Users objUsers = (Users)session.getAttribute("objUser");
						if(objUsers!=null){
						%>
						<a href="" data-toggle="modal" data-target="#editUsers" ><i class="fa fa-user"></i><%=objUsers.getFullName() %></a>
						<a href="<%=request.getContextPath()%>/logout"> <span style="font-weight:bold">Log out</span></a>
						<%}else{ %>
						<a href="#" ><i class="fa fa-user"></i>Khách</a>
						<a <%-- href="<%=request.getContextPath()%>/login" --%> href="" data-toggle="modal" data-target="#login"> <span style="font-weight:bold">Login</span></a>
						<%} %>
					</div>
				</div>
				<div class="collapse navbar-collapse" id="bs-example-navbar-collapse">
			 		<ul class="nav navbar-nav navbar-right">
			  			<li><a href="<%=request.getContextPath()%>/index">TRANG CHỦ</a></li>
			  			<li><a href="<%=request.getContextPath()%>/indexIntroduce">GIỚI THIỆU</a></li>
			  			<li><a href="<%=request.getContextPath()%>/indexNews">TIN TỨC</a></li>
			  			<li><a href="<%=request.getContextPath()%>/indexExcercises">Bài tập</a></li>
			  			<li><a href="<%=request.getContextPath()%>/indexProduct">SẢN PHẨM</a></li>
			  			<li><a href="<%=request.getContextPath()%>/registerTrainning">ĐĂNG KÝ TẬP</a></li>
			  			<li><a href="" data-toggle="modal" data-target="#signup">THÀNH VIÊN</a></li>
			  		</ul>
				</div>
			</div>
		</nav>
	</header>
	<!-- slider -->
	<section id="slider">
		<div id="myCarousel" class="carousel slide" data-ride="carousel">
  			<!-- Indicators -->
 			<ol class="carousel-indicators">
    			<li data-target="#myCarousel" data-slide-to="0" class="active"></li>
   			 	<li data-target="#myCarousel" data-slide-to="1"></li>
    			<li data-target="#myCarousel" data-slide-to="2"></li>
 			</ol>
 			<div class="carousel-inner" role="listbox">
    			<div class="item active">
     				<img src="<%=request.getContextPath() %>/templates/public/images/daidien1.jpg" alt="Chania">
    			</div>

    			<div class="item">
      				<img src="<%=request.getContextPath() %>/templates/public/images/daidien2.jpg" alt="Chania">
    			</div>

    			<div class="item">
     				<img src="<%=request.getContextPath() %>/templates/public/images/daidien3.jpg" alt="Flower">
    			</div>
  			</div>

  			<!-- Left and right controls -->
 			<a class="left carousel-control" href="#myCarousel" role="button" data-slide="prev">
    			<span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
    			<span class="sr-only">Previous</span>
 			</a>
  			<a class="right carousel-control" href="#myCarousel" role="button" data-slide="next">
    			<span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
   				 <span class="sr-only">Next</span>
  			</a>
		</div>
	</section><!-- End Left and right controls --> <!-- end slider --><!-- end-header -->
<div class="modal fade" id="login" tabindex="-1" role="dialog" aria-labelledby="loginLabel">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="loginlLabel" style = "margin-left: 186px;">WEBSITE TẬP THỂ HÌNH</h4>
      </div>
      <div class="modal-body">
        <form class="form-horizontal form-login" role="form" method="post" action="<%=request.getContextPath() %>/login">
         	<div class="form-group">
    			<label for="inputEmail3" class="col-sm-3 control-label">Username:</label>
   				<div class="col-sm-9">
      				<input type="text" name="userName" class="form-control required" id="username" placeholder="" style="width:300px;">
    			</div>
 			</div>
 			<div class="form-group">
    			<label for="inputEmail3" class="col-sm-3 control-label">Password:</label>
   				<div class="col-sm-9">
      				<input type="password" name="passWord" class="form-control" id="password" placeholder="" style="width:300px;">
    			</div>
 			</div>
 			<div class="modal-footer">
        		<button type="button" class="btn btn-danger" data-dismiss="modal">Close</button>
       			<input class="button-add btn btn-success create-button" name="submit" type="submit" value="Đăng nhập" /> 
     		 </div>
        </form>
      </div>
    </div>
  </div>
</div>
<div class="modal fade" id="signup" tabindex="-1" role="dialog" aria-labelledby="loginLabel">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="loginlLabel" style = "margin-left: 186px;">ĐĂNG KÝ THÀNH VIÊN</h4>
      </div>
      <div class="modal-body">
       	<form class="form-horizontal form_register" role="form" method="post" action="<%=request.getContextPath() %>/register">
         	<div class="form-group">
    					<label for="inputEmail3" class="col-sm-3 control-label">Username:</label>
   						<div class="col-sm-9">
      						<input  style = "width:300px;"type="text" name="userName" class="form-control required" id="username" placeholder="">
    					</div>
 					</div>
 					<div class="form-group">
    					<label for="inputEmail3" class="col-sm-3 control-label">Password:</label>
   						<div class="col-sm-9">
      						<input style = "width:300px;" type="password" name="passWord" class="form-control" id="password" placeholder="">
    					</div>
 					</div>
 					<div class="form-group">
    					<label for="inputEmail3" class="col-sm-3 control-label">Họ tên:</label>
   						<div class="col-sm-9">
      						<input style = "width:300px;" type="text" name="fullName" class="form-control" id="fullname" placeholder="">
    					</div>
 					 </div>
 					<div class="form-group">
    					<label for="inputEmail3" class="col-sm-3 control-label">Ngày sinh:</label>
   						<div class="col-sm-9">
      						<input style = "width:300px;" type="text" name="birthDay" class="form-control myDateFormat" id="birthday" placeholder="dd/MM/yyyy">
    					</div>
 					</div>
 						<div class="form-group">
    					<label for="inputEmail3" class="col-sm-3 control-label">Địa chỉ:</label>
   						<div class="col-sm-9">
      						<input style = "width:300px;" type="text" name="address" class="form-control" id="address" placeholder="">
    					</div>
 					</div>
 						<div class="form-group">
    					<label for="inputEmail3" class="col-sm-3 control-label">Điện thoại:</label>
   						<div class="col-sm-9">
      						<input style = "width:300px;"  type="text" name="phoneNumber" class="form-control" id="phone" placeholder="">
    					</div>
 					</div>
 					<div class="modal-footer">
        				<button type="button" class="btn btn-danger" data-dismiss="modal">Close</button>
       					<input class="button-add btn btn-success create-button" name="submit" type="submit" value="Đăng ký" /> 
     				 </div>
        </form>
      </div>
    </div>
  </div>
</div>
<%if(objUsers != null){ %>
	<div class="modal fade" id="editUsers" tabindex="-1" role="dialog" aria-labelledby="loginLabel">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="loginlLabel" style = "margin-left: 186px;">THÔNG TIN THÀNH VIÊN</h4>
      </div>
      <div class="modal-body">
       	<form class="form-horizontal form_register" role="form" method="post" action="<%=request.getContextPath() %>/editUsers">
         	<div class="form-group">
    					<label for="inputEmail3" class="col-sm-3 control-label">Username:</label>
   						<div class="col-sm-9">
      						<input  style = "width:300px;"type="text" name="userName" value="<%=objUsers.getUserName() %>" class="form-control required" id="username" placeholder="">
    					</div>
 					</div>
 					<div class="form-group">
    					<label for="inputEmail3" class="col-sm-3 control-label">Password:</label>
   						<div class="col-sm-9">
      						<input style = "width:300px;" type="password" name="passWord" value="<%=objUsers.getPassWord() %>" class="form-control" id="password" placeholder="">
    					</div>
 					</div>
 					<div class="form-group">
    					<label for="inputEmail3" class="col-sm-3 control-label">Họ tên:</label>
   						<div class="col-sm-9">
      						<input style = "width:300px;" type="text" name="fullName" value="<%=objUsers.getFullName() %>" class="form-control" id="fullname" placeholder="">
    					</div>
 					 </div>
 					<div class="form-group">
    					<label for="inputEmail3" class="col-sm-3 control-label">Ngày sinh:</label>
   						<div class="col-sm-9">
      						<input style = "width:300px;" type="text" name="birthDay" value="<%=TimeConvert.getStringDatetime(objUsers.getBirthDay()) %>" class="form-control myDateFormat" id="birthday" placeholder="dd/MM/yyyy">
    					</div>
 					</div>
 						<div class="form-group">
    					<label for="inputEmail3" class="col-sm-3 control-label">Địa chỉ:</label>
   						<div class="col-sm-9">
      						<input style = "width:300px;" type="text" name="address" value="<%=objUsers.getAddDress() %>" class="form-control" id="address" placeholder="">
    					</div>
 					</div>
 						<div class="form-group">
    					<label for="inputEmail3" class="col-sm-3 control-label">Điện thoại:</label>
   						<div class="col-sm-9">
      						<input style = "width:300px;"  type="text" name="phoneNumber" value="<%=objUsers.getPhoneNumber() %>" class="form-control" id="phone" placeholder="">
      						<input style = "width:300px;"  type="hidden" name="uid" value="<%=objUsers.getIdUser() %>" class="form-control" id="phone" placeholder="">
    					</div>
 					</div>
 					<div class="modal-footer">
        				<button type="button" class="btn btn-danger" data-dismiss="modal">Close</button>
       					<input class="button-add btn btn-success create-button" name="submit" type="submit" value="Sửa thông tin" /> 
     				 </div>
        </form>
      </div>
    </div>
  </div>
</div>
<%} %>
<%
  String msg = "";
    if(request.getParameter("msg")!=null){
    	msg = request.getParameter("msg");
    }else if(request.getParameter("login")!=null){
    	msg = request.getParameter("login");
    }else if(request.getParameter("buy")!=null){
    	msg = request.getParameter("buy");
    }else if(request.getParameter("training")!=null){
    	msg = request.getParameter("training");
    }
 	if(msg.equals("register")){
%>
	<script type="text/javascript">
	swal({   title: "Chúc mừng bạn đã đăng ký là hội viên thành công!",   text: "Xin hãy <a href = '' data-toggle ='modal' data-target='#login' style='color:#F8BB86'>đăng nhập</a> lại để xem thông tin đăng ký.",   html: true });
	</script>
	<%}else if(msg.equals("login0")){ %>
	<script type="text/javascript">
	swal("Có lỗi xảy ra!", "Tên đăng nhập hoặc mật khẩu không đúng.")
	</script>
	<%}else if(msg.equals("buy0")){ %>
	<script type="text/javascript">
	swal("Có lỗi xảy ra!", "Đăng nhập trước khi mua hàng.")
	</script>
	<%}else if(msg.equals("training0")){%>
	<script type="text/javascript">
	swal("Có lỗi xảy ra!", "Đăng nhập trước khi đăng ký hội viên.")
	</script>
	<%}else if(msg.equals("register0")){ %>
	<script>
	swal("Có lỗi xảy ra!", "Ngày đăng ký của bạn phải lớn hơn hoặc bằng ngày hiện tại!.")
	</script>
	<%} %>
<script>

$('#login').on('show.bs.modal', function (event) {
	  var button = $(event.relatedTarget) // Button that triggered the modal
	  var recipient = button.data('whatever') // Extract info from data-* attributes
	  // If necessary, you could initiate an AJAX request here (and then do the updating in a callback).
	  // Update the modal's content. We'll use jQuery here, but you could use a data binding library or other methods instead.
	  var modal = $(this)
	  modal.find('.modal-title').text('New message to ' + recipient)
	  modal.find('.modal-body input').val(recipient)
	})
</script>
<script>
$('#signup').on('show.bs.modal', function (event) {
	  var button = $(event.relatedTarget) // Button that triggered the modal
	  var recipient = button.data('whatever') // Extract info from data-* attributes
	  // If necessary, you could initiate an AJAX request here (and then do the updating in a callback).
	  // Update the modal's content. We'll use jQuery here, but you could use a data binding library or other methods instead.
	  var modal = $(this)
	  modal.find('.modal-title').text('New message to ' + recipient)
	  modal.find('.modal-body input').val(recipient)
	})
</script>
<script>
$('#editUsers').on('show.bs.modal', function (event) {
	  var button = $(event.relatedTarget) // Button that triggered the modal
	  var recipient = button.data('whatever') // Extract info from data-* attributes
	  // If necessary, you could initiate an AJAX request here (and then do the updating in a callback).
	  // Update the modal's content. We'll use jQuery here, but you could use a data binding library or other methods instead.
	  var modal = $(this)
	  modal.find('.modal-title').text('New message to ' + recipient)
	  modal.find('.modal-body input').val(recipient)
	})
</script>
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
	$(".form_register").validate({
		rules: {
			userName: {
				required: true,
			},
			passWord: {
				required: true,
			},
			fullName: {
				required: true,
			},
			birthDay: {
				required: true,
				date: true,
			},
			address: {
				required: true,
			},
			phoneNumber:{
				required: true,
				number: true
			}
		},
		messages: {
			userName: {
				required: "<span style='color:red;font-weight:bold;font-size:13px;'>Vui lòng nhập username!</span>",
			},
			passWord: {
				required: "<span style='color:red;font-weight:bold;font-size:13px;'>Vui lòng nhập password!</span>",
			},
			fullName: {
				required: "<span style='color:red;font-weight:bold;font-size:13px;'>Vui lòng nhập họ tên!</span>"	
			},
			birthDay: {
				required: "<span style='color:red;font-weight:bold;font-size:13px;'>Vui lòng nhập ngày tháng năm sinh!</span>",
				myDateFormat: "<span style='color:red;font-weight:bold;font-size:13px;'>Sai định dạng ngày tháng năm(dd/MM/YYYY)</span>"
			},
			address: {
				required: "<span style='color:red;font-weight:bold;font-size:13px;'>Vui lòng nhập địa chỉ!</span>",
			},
			phoneNumber: {
				required: "<span style='color:red;font-weight:bold;font-size:13px;'>Vui lòng nhập số điện thoại!</span>",
				number: "<span style='color:red;font-weight:bold;font-size:13px;'>Dữ liệu bạn nhập không phải là số!</span>",
			}
		}
	});
});
</script>
	<script type="text/javascript">
$( document ).ready(function() {
	$(".form-login").validate({
		rules: {
			userName: {
				required: true,
			},
			passWord: {
				required: true,
			}
			
		},
		messages: {
			userName: {
				required: "<span style='color:red;font-weight:bold;font-size:13px;'>Vui lòng nhập username</span>",
			},
			passWord: {
				required: "<span style='color:red;font-weight:bold;font-size:13px;'>Vui lòng nhập password</span>",
			},
			
		}
	});
});
</script>
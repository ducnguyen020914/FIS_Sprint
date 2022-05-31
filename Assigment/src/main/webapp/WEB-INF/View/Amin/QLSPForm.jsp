<%@ page language="java" session="true"
	contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form"  prefix="form"%>
<main>

	<div class="container-fluid">
		<div class="row">
			<h1>Danh sách sản phẩm</h1>
			<div class="col-12" style="background-color: rgb(233, 233, 232);">
				<h5 class="mt-3 mb-3">Trang chủ / Quản lý Sản phẩm</h5>
			</div>
		  <div class="col-8 offset-2 me-5 mt-5 ">
		  	<form:form action="/product/store" modelAttribute="productDTO" method="post"
				enctype="multipart/form-data">
				<div class="row">
						<div class="col-5">
							<div class="form-input-group mt-4 mb-3">
							<img alt="" src="/storage/heo1.jpg" class="img-fluid">
							
								<div class="">
								<label for="">Hình ảnh</label> <form:input type="file" path="image"  name="image"
									 />
								</div>
							</div>
						</div>
						<div class="col-7 mt-4">
					<div class="row">
					
					<div class="col-7">	<label for="">Tên Sản phẩm</label> 
					<form:input 
						path="name"	class="form-control"/>
						<form:errors element="small" path="name"/>
						</div>
					
					
					<div class="col-5">
						<label for="">Thể loại</label>
						 <form:select name="categoryID" path="category.id" class="form-select">
						  <form:options  items="${categories }" itemLabel="name" itemValue="id"/>
						</form:select>
					</div>
					
				</div>
				<div class="row">
				
					<div class="col-12">
						<div class="mt-3">	<label for="">Ngày Tạo</label>	<form:input type="date"
						path="createDate"	class="form-control"/><form:errors element="small" path="createDate"/></div>
					<div class="mt-3">	<label for="">Số lượng</label>	<form:input 
						path="quantity"	class="form-control"/><form:errors element="small" path="quantity"/></div>
					<div class="mt-3">
						<label for="">Đơn giá</label> 	<form:input 
						path="price"	class="form-control"/>
						<form:errors element="small" path="price"/>
					</div>
				
					 </div>
					 	<div class="col-12  mx-5 mt-3">
					 		<button type="button" class="btn btn-secondary"
					>Reset</button> 
					<button class="btn btn-success">Quản lý sản phẩm</button>
				<button class="btn btn-primary">Thêm mới</button>
					 	</div>
				</div>
			
				</div>
				</div>
			
				


		

			</form:form>
		  </div>

		</div>
	</div>

</main>
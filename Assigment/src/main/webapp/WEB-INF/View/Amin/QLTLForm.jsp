<%@ page language="java" session="true"
	contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<main>
	<div class="container-fluid mb-5" style="background-color:  rgb(233, 233, 232);">
		<div class="row" >
			<h1> Quản lý Thể loại </h1>
			<div class="col-12" style="background-color:lightgray;">
				<h5 class="mt-3 mb-3">Trang chủ / Quản lý Thể loại</h5>
			</div>
		    <div class="col-8 offset-4 mt-5 fw-bold">
		    <h1> Form Quản lý Thể loại</h1>
		         <form:form action="/category/${ sessionScope.save }" modelAttribute="categoryDTO" method="POST">
		            <div class="col-6 form-group-input">
		             <label>Category ID</label>
		             <form:input path="id" disabled="${sessionScope.save == 'store' ? 'true' :'false' }" class="form-control"/>
		             
		            </div>
		            <br>
		             <div class="col-6 form-group-input">
		             <label>Tên thể loại</label>
		              <form:input path="name" class="form-control"/>
		              <form:errors path="name" element="small" class="text-danger"/>
		            </div>
		             <br>
		             <div class="col-6 form-group-input">
		             <label>Ghi chú</label>
		             <form:input path="note" class="form-control"/>
		            </div>
		             <br>
		              <div class="col-6 form-group-input mt-4 mb-5">
		            <a href="/category/create" class="btn btn-secondary">Reset</a>
		             <a href="/category/index" class="btn btn-success">Quản lý thể loại</a>
		              <button class="btn btn-primary">${sessionScope.save == 'store' ? 'Save':'Update' }</button>
		            </div>
		         </form:form>
		    </div>
		</div>
	    
	     </div>
	      

		
</main>
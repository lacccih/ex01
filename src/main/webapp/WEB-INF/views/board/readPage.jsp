<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%@ include file="../include/header.jsp" %>

<form role="form" method="post">
	<input name="bno" type="hidden" value="${boardVO.bno }">
	<input name="page" type="hidden" value="${cri.page }">
	<input name="perPageNum" type="hidden" value="${cri.perPageNum }">
</form>
	<div class="box-body">
		<div class="form-group">
			<label for="exampleInputEmail1">Title</label>
			<input type="text" name="title" class="form-control" placeholder="Enter Title" readonly="readonly" value="${boardVO.title }">
		</div>
		<div class="form-group">
			<label for="exampleInputPassword1">Content</label>
			<textarea rows="3" class="form-control" name="content" placeholder="Enter..." readonly="readonly">${boardVO.content }</textarea>
		</div>
		<div class="form-group">
			<label for="exampleInputEmail1">Writer</label>
			<input type="text" name="writer" class="form-control" placeholder="Enter Writer" readonly="readonly" value="${boardVO.writer }">
		</div>
	</div>
	<!-- /.box-body -->
	
	<div class="box-footer">
		<button type="submit" class="btn btn-warning">MODIFY</button>
		<button type="submit" class="btn btn-danger">REMOVE</button>
		<button type="submit" class="btn btn-primary">LIST ALL</button>
	</div>


<%@ include file="../include/footer.jsp" %>

<script type="text/javascript">

	$(document).ready(function() {

		var formObj = $("form[role='form']");

		$(".btn-warning").on("click", function() {
			formObj.attr("action", "/board/modifyPage");
			formObj.attr("method", "get");
			formObj.submit();
		});

		$(".btn-danger").on("click", function() {
			formObj.attr("action", "/board/removePage");
			formObj.submit();
		});

		$(".btn-primary").on("click", function() {
			formObj.attr("action", "/board/listPage");
			formObj.attr("method", "get");
			formObj.submit();
		});
		
	});

</script>
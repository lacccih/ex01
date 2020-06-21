<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%@ include file="../include/header.jsp" %>

<table class="table table-bordered">
  <tr>
    <th style="width: 10px">BNO</th>
    <th>TITLE</th>
    <th>CONTENT</th>
    <th>WRITER</th>
    <th style="width: 40px">VIEWCNT</th>
</table>

<%@ include file="../include/footer.jsp" %>

<script>
	var result = "${msg}";
	if(result == "success") alert("처리가 완료되었습니다.");
</script>
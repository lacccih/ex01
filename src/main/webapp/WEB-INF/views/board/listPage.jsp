<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page session="false" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%@ include file="../include/header.jsp" %>

<table class="table table-bordered">
  	<tr>
	    <th style="width: 10px">BNO</th>
	    <th>TITLE</th>
	    <th>CONTENT</th>
	    <th>WRITER</th>
	    <th>REGDATE</th>
	    <th style="width: 40px">VIEWCNT</th>
	</tr>
	<c:forEach items="${list }" var="boardVO">
	<tr>
		<td>${boardVO.bno }</td>
		<td><a href="/board/readPage${pageMaker.makeQuery(pageMaker.cri.getPage()) }&bno=${boardVO.bno }">${boardVO.title }</a></td>
		<td>${boardVO.content }</td>
		<td>${boardVO.writer }</td>
		<td>${boardVO.regdate }</td>
		<td><span class="badge bg-red">${boardVO.viewcnt }</span></td>
	</tr>
	</c:forEach>
</table>
<div class="text-center">
	<ul class="pagination">
		
		<c:if test="${pageMaker.prev }">
			<li><a href="listPage${pageMaker.makeQuery(pageMaker.startPage - 1) }">&laquo;</a></li>
		</c:if>
		
		<c:forEach begin="${pageMaker.startPage }" end="${pageMaker.endPage }" var="idx">
			<li <c:out value="${pageMaker.cri.page == idx ? 'class=active' : '' }"/>>
				<a href="listPage${pageMaker.makeQuery(idx) }">${idx }</a>
			</li>
		</c:forEach>
		
		<c:if test="${pageMaker.next && pageMaker.endPage > 0 }">
			<li><a href="listPage${pageMaker.makeQuery(pageMaker.endPage + 1) }">&raquo;</a></li>
		</c:if>
		
	</ul>
</div>

<%@ include file="../include/footer.jsp" %>

<script type="text/javascript">
	var result = "${msg}";
	if(result == "success") alert("처리가 완료되었습니다.");
</script>
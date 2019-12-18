<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<%@ taglib uri="/struts-tags" prefix="s" %>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
	<h3>照片展示</h3>
	<a href="add.jsp">增加图片</a>
	<table width="600px" border="1px">
		<thead>
			<tr>
				<th>序号</th>
				<th>图片</th>
				<th>状态</th>
				<th>审核</th>
				
			</tr>
		</thead>
		<tbody>
		<%-- <c:forEach items="${list }" var="g"> --%>
			
			<s:iterator value="list" status="i">
			
			<tr>
				<th><s:property value="#i.count" /></th>
				<th><img src="upload/<s:property value="photo" />" width="100" height="75" /></th>
				<th><s:property value="prole" /></th>
				<th><s:property value="pstate" /></th>
				
			</tr>
			
			
			
			<%-- <tr>
				<th>${g.uid}</th>
				<th>${g.photo}</th>
				<th>${g.prole}</th>
				<th>${g.pstate}</th>
				
			</tr> --%>
			</s:iterator>
			
		<%-- </c:forEach> --%>
		</tbody>
	
	</table>
</body>
</html>
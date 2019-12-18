<%@ page language="java" pageEncoding="utf-8"%>
    
<%@ taglib uri="/struts-tags" prefix="s" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
	<h3>增加用户</h3>
	<s:form action="add.action" enctype="multipart/form-data">
		<s:file name="photo" label="用户照片"></s:file>
		<s:textfield name="uphoto.uid" label="上传用户id"></s:textfield>	
		<s:textfield name="uphoto.prole" label="状态"></s:textfield>	
		<s:textfield name="uphoto.pstate" label="审核"></s:textfield>		
		<s:submit value="注册"></s:submit>
		<s:reset></s:reset>
	</s:form>
</body>
</html>
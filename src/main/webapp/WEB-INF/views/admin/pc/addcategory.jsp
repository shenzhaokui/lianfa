<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/taglib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>添加商品分类</title>
</head>
<body>
<p>添加商品分类</p>
<p>父级分类：${parentcategory.categoryName }<c:if test="${parentcategory ==null }">0</c:if></p>

<form:form modelAttribute="category" method="post" action="${adminPrefix}/addcategory">
	分类名称：<form:input path="categoryName"/> <br>
	<input type="hidden" name="parentid" value="${parentid}">
	<input type="submit" value="提交">
</form:form>

<script src="${ctxStatic}/js/jquery-3.2.1.min.js" type="text/javascript" charset="utf-8"></script>
<script type="text/javascript">
	$(function(){
		
		var error = '${error}';
		if(error != ''){
			alert(error);
		}
		
		
	});
</script>
</body>
</html>
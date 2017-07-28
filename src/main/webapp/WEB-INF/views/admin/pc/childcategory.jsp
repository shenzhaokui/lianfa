<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/taglib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>商品分类管理</title>
</head>
<body>
<p>父分类名称：${parentcategory.categoryName }</p>
<p><a href="${adminPrefix}/addcategory?parentid=${parentcategory.id }">继续添加</a></p>
<table width="625" border="1">
  <tr>
    <td>分类名称</td>
    <td>上级分类</td>
    <td>操作</td>
  </tr>
  <c:forEach items="${categorylist}" var="item">
	  <tr>
	    <td>${item.categoryName }</td>
	    <td>${parentcategory.categoryName }</td>
	    <td><a href="${adminPrefix}/updatecategory?categoryid=${item.id}">编辑</a> <a href="${adminPrefix}/deletecategory?categoryid=${item.id}">删除</a> <a href="${adminPrefix}/addcategory?parentid=${item.id}">添加子分类</a> <a href="${adminPrefix}/showchildcategory?parentid=${item.id}">查看子分类</a></td>
	  </tr>
  </c:forEach>
</table>
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
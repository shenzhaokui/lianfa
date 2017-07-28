<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/taglib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>商品管理</title>
</head>
<body>
<p>商品管理</p>
<p><a href="${adminPrefix }/addproduct">添加商品</a></p>
<table width="625" border="1">
  <tr>
    <td>商品名称</td>
    <td>分类名称</td>
    <td>操作</td>
  </tr>
  <c:forEach items="${productlist}" var="item">
	  <tr>
	    <td>${item.productName }</td>
	    <td>${item.productCategoryName }</td>
	    <td><a href="${adminPrefix }/productinfo?pid=${item.id}">详情</a> <a href="${adminPrefix }/updateuroduct?pid=${item.id}">更新</a></td>
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
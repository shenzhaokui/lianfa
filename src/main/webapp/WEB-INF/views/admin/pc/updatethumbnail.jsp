<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/taglib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>商品分类修改</title>
</head>
<body>
<form:form action="${adminPrefix}/updatethumbnail" method="post" enctype="multipart/form-data">
	<table width="625" border="1">
	  <tr>
	    <td><img src="${img}/${thumbnail.thumbnailUrl }" width="400px"></td> 
	  </tr>
	  <tr>
		<td><input name="file" type="file"></td>
	  </tr>
	</table>
	<input type="hidden" name="id" value="${thumbnail.id }">
	<input type="submit" value="提交修改">
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
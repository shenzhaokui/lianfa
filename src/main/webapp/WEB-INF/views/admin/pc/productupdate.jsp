<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/taglib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>商品编辑</title>
</head>
<body>

<form:form action="${adminPrefix}/updateuroduct" method="post" modelAttribute="product" enctype="multipart/form-data">
	<form:hidden path="id"/>
	<p>商品名称：<form:input path="productName"/></p> 
	<p>商品描述：<form:textarea path="productDescription"/></p>
	<p>商品所属分类：<form:select path="productCategoryId">
					<form:options items="${categorys}" itemValue="id" itemLabel="categoryName"/>
	
				</form:select></p> 
				
	<p>佣金分成类型：<form:select path="productCommissionType">
					<form:option value="0">固定金额</form:option>
					<form:option value="1">固定比例</form:option>
				</form:select></p>
				
	<p>产品大图：<img alt="" src="${img }/${product.bigPicUrl }" width="350px"><br><input name="file1" type="file"></p>
	<p>产品小图：<img alt="" src="${img }/${product.smallPicUrl }" width="350px"><br><input name="file2" type="file"></p>
	<form:hidden path="bigPicUrl"/><form:hidden path="smallPicUrl"/>
	
	
	<p>缩略图列表：</p>
	<c:forEach items="${product.thumbnails}" var="item">
		<p><img alt="" src="${img }/${item.thumbnailUrl }" width="150px"></p> 
		<p><a href="${adminPrefix}/updatethumbnail?id=${item.id}">更新缩略图</a> <a href="${adminPrefix}/deletethumbnail?id=${item.id}">删除缩略图</a></p>
	</c:forEach>
	<p>新增缩略图:<input name="file3" type="file"></p>
	<hr>
	<p>商品颜色分类列表：</p>
	<c:forEach items="${product.typeList}" var="item">
		<p><img alt="" src="${img }/${item.imgUrl }" width="50px"></p>
		<p>${item.typeName }</p>
		<p><a href="${adminPrefix}/deleteproducttype?typeid=${item.id}">删除该颜色分类</a></p>
	</c:forEach>
	<p>新增商品颜色分类:<input name="file4" type="file"></p>
	<p>分类名称:<input name="typeName" type="text"></p>
	<hr>
	<p>上一级提成百分比：<form:input path="productUpOneLevelPercentage"/></p>
	<p>上二级提成百分比：<form:input path="productUpTwoLevelPercentage"/></p>
	<p>上三级提成百分比：<form:input path="productUpThreeLevelPercentage"/></p>
	<p>上四级提成百分比：<form:input path="productUpFourLevelPercentage"/></p>
	<p>上五级提成百分比：<form:input path="productUpFiveLevelPercentage"/></p>
	
	<hr>
	<p>上一级提成固定数额：<form:input path="productUpOneLevelFixedAmount"/></p>
	<p>上二级提成固定数额：<form:input path="productUpTwoLevelFixedAmount"/></p>
	<p>上三级提成固定数额：<form:input path="productUpThreeLevelFixedAmount"/></p>
	<p>上四级提成固定数额：<form:input path="productUpFourLevelFixedAmount"/></p>
	<p>上五级提成固定数额：<form:input path="productUpFiveLevelFixedAmount"/></p>
	
	<hr>
	<p>库存计量单位：<form:input path="measurementUnit"/></p>
	<form:hidden path="productStock"/>
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
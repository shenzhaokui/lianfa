<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/taglib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>商品编辑</title>
</head>
<body>

<form:form action="${adminPrefix}/addproduct" method="post" modelAttribute="product"  enctype="multipart/form-data">
	<p>商品名称：<form:input path="productName"/></p> 
	<p>商品描述：<form:textarea path="productDescription"/></p>
	<p>商品所属分类：<form:select path="productCategoryId">
					<form:option value="-1">--</form:option>
					<form:options items="${categorys}" itemValue="id" itemLabel="categoryName"/>
	
				</form:select></p> 
				
	<p>佣金分成类型：<form:select path="productCommissionType">
					<form:option value="-1">--</form:option>
					<form:option value="0">固定金额</form:option>
					<form:option value="1">固定比例</form:option>
				</form:select></p>
				
	<p>产品大图：<input name="file1" type="file"></p>
	<p>产品小图：<input name="file2" type="file"></p>
	
	<p>缩略图列表：</p>
	<p>缩略图一：<input name="thumbnail1" type="file"></p>
	<p>缩略图二：<input name="thumbnail2" type="file"></p>
	<p>缩略图三：<input name="thumbnail3" type="file"></p>
	<p>缩略图四：<input name="thumbnail4" type="file"></p>
	<p>缩略图五：<input name="thumbnail5" type="file"></p>
	<p>缩略图六：<input name="thumbnail6" type="file"></p>

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
	<p>库存：<form:input path="productStock"/></p>
	
	<p>原价：<form:input path="originalPrice"/></p>
	<p>现价：<form:input path="currentPrice"/></p>
	
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
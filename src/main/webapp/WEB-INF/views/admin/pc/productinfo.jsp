<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/taglib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>商品详情</title>
</head>
<body>
<p>商品名称：${product.productName }</p>
<p>商品描述：${product.productDescription }</p>
<p>所属分类ID：${product.productCategoryId }</p>
<p>所属分类名称：${product.productCategoryName }</p>
<p>佣金分成类型：${product.productCommissionType }</p>
<hr>
<p>产品大图：<img alt="" src="${img }/${product.bigPicUrl }" width="350px"></p> 
<p>产品小图：<img alt="" src="${img }/${product.smallPicUrl }" width="350px"></p> 

<p>缩略图列表：</p>
<c:forEach items="${product.thumbnails}" var="item">
<p><img alt="" src="${img }/${item.thumbnailUrl }" width="150px"></p>  
</c:forEach>

<hr>
<p>商品颜色分类列表：</p>
<c:forEach items="${product.typeList}" var="item">
<p><img alt="" src="${img }/${item.imgUrl }" width="50px"></p>
<p>${item.typeName }</p>
</c:forEach>

<hr>
<p>上一级提成百分比：${product.productUpOneLevelPercentage }</p>
<p>上二级提成百分比：${product.productUpTwoLevelPercentage }</p>
<p>上三级提成百分比：${product.productUpThreeLevelPercentage }</p>
<p>上四级提成百分比：${product.productUpFourLevelPercentage }</p>
<p>上五级提成百分比：${product.productUpFiveLevelPercentage }</p>
<hr>
<p>上一级提成固定数额：${product.productUpOneLevelFixedAmount }</p>
<p>上二级提成固定数额：${product.productUpTwoLevelFixedAmount }</p>
<p>上三级提成固定数额：${product.productUpThreeLevelFixedAmount }</p>
<p>上四级提成固定数额：${product.productUpFourLevelFixedAmount }</p>
<p>上五级提成固定数额：${product.productUpFiveLevelFixedAmount }</p>
<hr>
<p>库存：${product.productStock }</p>
<p>库存计量单位：${product.measurementUnit }</p>


<p><a href="javascript:history.go(-1)">返回</a></p>

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
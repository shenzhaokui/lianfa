<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/taglib.jsp"%>
<!DOCTYPE html>
<html lang="zh-CN">
	<head>
		<meta charset="utf-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
    	<meta name="viewport" content="width=device-width, initial-scale=1">
    	<link rel="stylesheet" type="text/css" href="${ctxStatic}/css/bootstrap.min.css"/>
		<title>404</title>
	</head>
	<body style="background-color: #F5F5F5;">
		<div class="col-xs-12 text-center" style="margin-top: 50px;">
			<img src="${ctxStatic}/img/error.png"/>
		</div>
		
		<div class="col-xs-6 col-xs-offset-3" style="margin-top: 30px;">
			<div class="alert alert-warning text-center">
				您访问的页面不存在，请核对后重新输入。
			</div>
		</div>
		
		<div class="col-xs-12 text-center" style="margin-top: 40px;">
			<a href="${ctx }" class="btn btn-default">返回首页</a>
		</div>
		
		
		
		
		
		
		
		
		<!--
        	作者：sinnk@163.com
        	时间：2017-02-24
        	描述：JS 文件引入
        -->
        <script src="${ctxStatic}/js/jqUSERy-3.1.1.min.js"></script>
        <script src="${ctxStatic}/js/bootstrap.min.js"></script>
        <script>
        	$(function(){
        		
        	});
        </script>
	</body>
</html>

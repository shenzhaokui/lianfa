<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/taglib.jsp"%>
<div class="toppest">
	<div class="container toppest">
		<div class="span-1">
			<ul class="horizontal">
				<shiro:notAuthenticated>
					<li><a href="${userPrefix}/login">您好，请登录</a></li>
					<li class="last"><a href="${userPrefix}/register" class="note">免费注册</a></li>
				</shiro:notAuthenticated>
				<shiro:authenticated>
					<li><span class="loginname">您好！<shiro:principal></shiro:principal></span></li>
					<li class="last"><a href="${userPrefix}/logout" class="note">退出登录</a></li>
				</shiro:authenticated>
			</ul>
		</div>
		<div class="span-11 last text-right">
			<ul class="horizontal line">
				<li><a href="${userPrefix}/showorder">我的订单</a></li>
				<li><a href="${ctx}/user">我的联发</a></li>
				<li><a href="javascript:void(0)">联发会员</a></li>
				<li><a href="javascript:void(0)">客户服务</a></li>
				<li><a href="javascript:void(0)">网站导航</a></li>
				<li class="last"><a href="javascript:void(0)">手机商城</a></li>
			</ul>
		</div>
	</div>
</div>
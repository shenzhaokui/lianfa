<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/taglib.jsp"%>
<div class="toppest">
	<div class="container toppest">
		<div class="usertop-left">
			<ul class="horizontal">
				<li><span class="userinfo">您好！<shiro:principal></shiro:principal></span></li>
				<li><img src="${ctxStatic}/img/xiaoxi.png" /><a
					href="javascript:void(0)">我的消息<span class="xiaoxi">0</span></a></li>
				<li class="last"><a href="${authcUserPrefix}/logout">退出登录</a></li>
			</ul>
		</div>
		<div class="usertop-right">
			<ul class="horizontal line">
				<li><a href="${shopPrefix }">商城首页</a></li>
				<li><a href="${ctx }/user">我的联发</a></li>
				<li><a href="javascript:void(0)">购物车<span class="xiaoxi">0</span></a></li>
				<li><a href="${ctx}/user/favorite">收藏夹</a></li>
				<li><a href="javascript:void(0)">联系客服</a></li>
				<li class="last"><a href="javascript:void(0)">网站导航</a></li>
			</ul>
		</div>
	</div>
</div>

<div class="user-head">
	<div class="container user-head">

		<div class="logo-lianfa">
			<a href="${ctx }/user"><img
				src="${ctxStatic}/img/wodelianfa.png" /></a>
		</div>

		<div class="logo-lianfa-info">
			<ul class="horizontal wode">
				<li><a href="${ctx }/user">首页</a></li>
				<li><a href="${ctx}/user/showorder">我的订单</a></li>
				<li><a href="${ctx}/user/favorite">我的收藏</a></li>
				
				<shiro:hasRole name="seller">
					<li><a href="${ctx}/user/sellorder">我的店铺</a></li>
					<li><a href="${ctx}/user/mycash">我的财务</a></li>
					<li><a href="${ctx}/user/spread">我的推广码</a></li>
				</shiro:hasRole>
				
				<li><a href="${ctx}/user/profile">修改资料</a></li>
			</ul>
		</div>

	</div>
</div>
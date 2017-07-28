<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/taglib.jsp"%>
<ul class="ucenter">
	<li>
		<p>
			<img src="${ctxStatic}/img/sj.png" />我的订单
		</p>
	</li>
	<li><a href="${ctx}/user/showorder?type=all">所有订单</a></li>
	<li><a href="${ctx}/user/showorder?type=waitpay">待付款</a></li>
	<li><a href="${ctx}/user/showorder?type=waitsend">待发货</a></li>
	<li><a href="${ctx}/user/showorder?type=waitget">待收货</a></li>
	<li class="pd">
		<p>
			<img src="${ctxStatic}/img/sj.png" />我的收藏
		</p>
	</li>
	<li><a href="${ctx}/user/favorite">我收藏的宝贝</a></li>
	
	<shiro:hasRole name="seller">
	
		<li class="pd">
			<p>
				<img src="${ctxStatic}/img/sj.png" />我的店铺
			</p>
		</li>
		<li><a href="${ctx}/user/sellorder?type=all">所有订单</a></li>
		<li><a href="${ctx}/user/sellorder?type=waitpay">待发货</a></li>
		<li><a href="${ctx}/user/sellorder?type=waitsend">待收货</a></li>
		<li><a href="${ctx}/user/myshop">我的连锁店</a></li>
		<li class="pd">
			<p>
				<img src="${ctxStatic}/img/sj.png" />我的财务
			</p>
		</li>
		<li><a href="${ctx}/user/mycash">我的佣金</a></li>
		<li><a href="${ctx}/user/withdrawlist">提现记录</a></li>
		<li><a href="${ctx}/user/incomelist">收入明细</a></li>
		<li class="pd">
			<p>
				<img src="${ctxStatic}/img/sj.png" />我的推广码
			</p>
		</li>
		<li><a href="${ctx}/user/spread">推广链接</a></li>
	
	</shiro:hasRole>
	
	<li class="pd">
		<p>
			<img src="${ctxStatic}/img/sj.png" />修改资料
		</p>
	</li>
	<li><a href="${ctx}/user/profile">个人资料变更</a></li>

</ul>
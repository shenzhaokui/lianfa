<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/taglib.jsp"%>
<!--
        	作者：sinnk@163.com
        	时间：2017-02-24
        	描述：top
        -->
		<div class="container-fluid">
			<div class="row" style="background-color: #E7E7E7;padding-top: 2px;padding-bottom: 2px;border-bottom: solid 1px #ccc;">
				<div class="col-xs-12">
					<div class="container">
						<div class="row">
							<div class="col-xs-12 text-right">
								<ul class="list-inline" style="margin-bottom: 0;">
									<li>
										<a href="${userPrefix }/register" style="color: #757575;">注册</a>
									</li>
									<li>
										<a href="${userPrefix }/login" style="color: #757575;">登录</a>
									</li>
								</ul>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>

		<div class="container">
			<div class="row" style="margin-top: 20px;margin-bottom: 20px;">
				<div class="col-sm-4">
					<img src="${ctxStatic}/img/logo.png" />
				</div>
				<div class="col-sm-8" style="margin-top: 15px;">
					<ul class="list-inline" id="menu">
						<li>
							<a href="${frontPrefix}/index">平台首页</a>
						</li>
						<li>
							<a href="${frontPrefix}/about">在线商城</a>
						</li>
						<li>
							<a href="#">加盟代理</a>
						</li>
						<li>
							<a href="#">联系我们</a>
						</li>
						<li>
							<a href="#">网站地图</a>
						</li>
						<li>
							<a href="#">网站地图</a>
						</li>
						<li>
							<a href="#">网站地图</a>
						</li>
					</ul>
				</div>
			</div>
		</div>
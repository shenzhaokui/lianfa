<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/taglib.jsp"%>
<!DOCTYPE html>
<html lang="zh-CN">

	<head>
		<meta charset="utf-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
		<meta name="keywords" content="联发商城">
		<meta name="description" content="一个可以赚钱的商城">
		<title>用户注册 | 联发商城</title>
		<link rel="stylesheet" type="text/css" href="${ctxStatic}/css/lianfa.css" />
	</head>

	<body class="bgwhite">

		<div class="subhead">
			<div class="container subhead">
				<div class="span-2">
					<div class="logo pull-10">
						<a href="${shopPrefix}"><img src="${ctxStatic}/img/logo_s.png" /></a>
					</div>
				</div>
			</div>
		</div>

		<div class="container pull-20">
			<ul class="horizontal text-center zhuce">
				<li><span>1</span>设置用户名</li>
				<li><span>2</span>填写账号信息</li>
				<li class="last s"><span>3</span>完成注册</li>
			</ul>
		</div>

		<div class="container pull-50">
			<div class="querenxinxi">
				请核对以下注册信息是否正确，确认无误请点击下方红色按钮，提交注册
			</div>
			<table width="400" align="center">
				
				<tr>
					<td align="right" valign="middle" class="dengluming">登录名</td>
					<td><input type="text" id="dengluming" value="${user.username }" class="mingcheng"  disabled="disabled"/></td>
				</tr>
				<tr>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
				</tr>
				<tr>
					<td align="right" valign="middle" class="dengluming">登录密码</td>
					<td><input type="text" id="mima" value="${user.password }" class="mingcheng" disabled="disabled" /></td>
				</tr>
				<tr>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
				</tr>
				
				<tr>
					<td align="right" valign="middle" class="dengluming">收件人姓名</td>
					<td><input type="text" id="shoujianren" value="${user.deliveryName }" class="mingcheng" disabled="disabled" /></td>
				</tr>
				<tr>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
				</tr>
				<tr>
					<td align="right" valign="middle" class="dengluming">联系电话</td>
					<td><input type="text" id="lianxidianhua" value="${user.deliveryPhone }" class="mingcheng" disabled="disabled" /></td>
				</tr>
				<tr>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
				</tr>
				<tr>
					<td align="right" valign="top" class="dengluming dengluming2">收件地址</td>
					<td><textarea name="" rows="" cols="" class="mingcheng" id="shoujiandizhi" disabled="disabled">${user.deliveryAddress }</textarea></td>
				</tr>
				<tr>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
				</tr>
				<tr>
					<td>&nbsp;</td>
					<td>
						<a href="${userPrefix }/updatereg" class="btn-denglu btn-zhuce" id="btn-zhuce">提交注册</a>
					</td>
				</tr>
				<tr>
					<td>&nbsp;</td>
					<td><a href="${userPrefix }/register"  id="btn-rezhuce">返回重新填写</a></td>
				</tr>
			</table>
		</div>

		<div class="foot">
			<div class="container white">
				<div class="row">
					<ul class="horizontal line text-center line-sm">
						<li>
							<a href="javascript:void(0)">关于我们</a>
						</li>
						<li>
							<a href="javascript:void(0)">联系我们</a>
						</li>
						<li>
							<a href="javascript:void(0)">在线客服</a>
						</li>
						<li>
							<a href="javascript:void(0)">合作加盟</a>
						</li>
						<li>
							<a href="javascript:void(0)">手机联发</a>
						</li>
						<li>
							<a href="javascript:void(0)">联发社区</a>
						</li>
						<li>
							<a href="javascript:void(0)">隐私政策</a>
						</li>
						<li>
							<a href="javascript:void(0)">营销中心</a>
						</li>
						<li>
							<a href="javascript:void(0)">合作伙伴</a>
						</li>
						<li>
							<a href="javascript:void(0)">法律声明</a>
						</li>
						<li>
							<a href="javascript:void(0)">知识产权</a>
						</li>
						<li>
							<a href="javascript:void(0)">诚征英才</a>
						</li>
						<li>
							<a href="javascript:void(0)">网站地图</a>
						</li>
						<li class="last">
							<a href="javascript:void(0)">联发公益</a>
						</li>
					</ul>
				</div>

				<div class="row">
					<ul class="horizontal  text-center ">
						<li><i class="guohui"></i>
							<a href="javascript:void(0)">鲁ICP备15029251号</a>
						</li>
						<li class="last">
							<a href="javascript:void(0)">经营证照</a>
						</li>
					</ul>
					<p class="copyright">Copyright &copy; 青岛联发网络科技有限公司版权所有</p>
				</div>

				<div class="row push-15">
					<ul class="horizontal  text-center ">
						<li><img src="${ctxStatic}/img/ico1.png" /></li>
						<li><img src="${ctxStatic}/img/ico2.png" /></li>
						<li><img src="${ctxStatic}/img/ico3.jpg" /></li>
						<li><img src="${ctxStatic}/img/ico4.png" /></li>
						<li><img src="${ctxStatic}/img/ico5.jpg" /></li>
						<li><img src="${ctxStatic}/img/ico6.jpg" /></li>
					</ul>
				</div>
			</div>
		</div>

		<div class="mask">

		</div>

		<script src="${ctxStatic}/js/jquery-3.2.1.min.js" type="text/javascript" charset="utf-8"></script>
		<script type="text/javascript">
			$(function() {
				
			});
		</script>
	</body>

</html>

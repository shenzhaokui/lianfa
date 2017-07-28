<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/taglib.jsp"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
<meta name="keywords" content="联发商城">
<meta name="description" content="一个可以赚钱的商城">
<title>用户注册 | 联发商城</title>
<link rel="stylesheet" type="text/css"
	href="${ctxStatic}/css/lianfa.css" />
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
			<li class="s"><span>1</span>设置用户名</li>
			<li><span>2</span>填写账号信息</li>
			<li class="last"><span>3</span>完成注册</li>
		</ul>
	</div>


	<div class="container pull-50">
	
		<form:form action="${userPrefix}/regstepone" method="post" modelAttribute="user" id="stepone">
	
			<table width="400" align="center">
				<tr>
					<td align="right" valign="middle" class="dengluming">登录名</td>
					<td><input type="text" id="yonghuming" value="${user.username}"
						class="mingcheng" name="username"/></td>
				</tr>
				<tr>
					<td>&nbsp;</td>
					<td><p class="zhucetishi">登录名只能由字母数字和下划线组成</p>
						<p class="zhucetishi">开头只能以字母开头</p>
						<p class="zhucetishi">登录名长度在5到16位之间，不区分大小写</p></td>
				</tr>
				<tr>
					<td>&nbsp;</td>
					<td><a href="javascript:void(0)" class="btn-denglu btn-zhuce" id="btn-zhuce">下一步</a></td>
				</tr>
				<tr>
					<td>&nbsp;</td>
					<td><p class="zhuceerror">你输入的用户名已存在，请尝试其他用户名！</p></td>
				</tr>
			</table>
		
		</form:form>
	</div>



	<div class="foot">
		<div class="container white">
			<div class="row">
				<ul class="horizontal line text-center line-sm">
					<li><a href="javascript:void(0)">关于我们</a></li>
					<li><a href="javascript:void(0)">联系我们</a></li>
					<li><a href="javascript:void(0)">在线客服</a></li>
					<li><a href="javascript:void(0)">合作加盟</a></li>
					<li><a href="javascript:void(0)">手机联发</a></li>
					<li><a href="javascript:void(0)">联发社区</a></li>
					<li><a href="javascript:void(0)">隐私政策</a></li>
					<li><a href="javascript:void(0)">营销中心</a></li>
					<li><a href="javascript:void(0)">合作伙伴</a></li>
					<li><a href="javascript:void(0)">法律声明</a></li>
					<li><a href="javascript:void(0)">知识产权</a></li>
					<li><a href="javascript:void(0)">诚征英才</a></li>
					<li><a href="javascript:void(0)">网站地图</a></li>
					<li class="last"><a href="javascript:void(0)">联发公益</a></li>
				</ul>
			</div>

			<div class="row">
				<ul class="horizontal  text-center ">
					<li><i class="guohui"></i><a href="javascript:void(0)">鲁ICP备15029251号</a></li>
					<li class="last"><a href="javascript:void(0)">经营证照</a></li>
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



	<div class="mask"></div>


	<script src="${ctxStatic}/js/jquery-3.2.1.min.js"
		type="text/javascript" charset="utf-8"></script>
	<script type="text/javascript">
		$(function() {

			/**
			 * sort 
			 */
			$(".sort-detail-block ul li").mouseenter(function(event) {
				$(this).addClass("mouseup");

				if ($(this).index() == 0) {
					$(".catedetail").hide();
					$("#jiadianshuma").show();
				} else if ($(this).index() == 1) {
					$(".catedetail").hide();
					$("#diannaobangong").show();
				} else if ($(this).index() == 2) {
					$(".catedetail").hide();
					$("#jiaju").show();
				} else if ($(this).index() == 3) {
					$(".catedetail").hide();
					$("#nanzhuang").show();
				} else if ($(this).index() == 4) {
					$(".catedetail").hide();
					$("#xiexue").show();
				} else if ($(this).index() == 5) {
					$(".catedetail").hide();
					$("#meizhuang").show();
				} else if ($(this).index() == 6) {
					$(".catedetail").hide();
					$("#zhubao").show();
				} else if ($(this).index() == 7) {
					$(".catedetail").hide();
					$("#yundong").show();
				} else if ($(this).index() == 8) {
					$(".catedetail").hide();
					$("#youxi").show();
				} else if ($(this).index() == 9) {
					$(".catedetail").hide();
					$("#meishi").show();
				} else if ($(this).index() == 10) {
					$(".catedetail").hide();
					$("#xianhua").show();
				} else if ($(this).index() == 11) {
					$(".catedetail").hide();
					$("#fangchan").show();
				} else if ($(this).index() == 12) {
					$(".catedetail").hide();
					$("#jiajujiashi").show();
				} else if ($(this).index() == 13) {
					$(".catedetail").hide();
					$("#qiche").show();
				} else if ($(this).index() == 14) {
					$(".catedetail").hide();
					$("#wujin").show();
				} else if ($(this).index() == 15) {
					$(".catedetail").hide();
					$("#baihuo").show();
				} else if ($(this).index() == 16) {
					$(".catedetail").hide();
					$("#xuexi").show();
				}

			}).mouseleave(function(event) {
				$(this).removeClass("mouseup");
				if (event.clientY <= 202) {
					$(".catedetail").hide();
				}

				if (event.clientX <= $(this).offset().left) {
					$(".catedetail").hide();
				}

				if (event.clientY + $(document).scrollTop() > 670) {
					$(".catedetail").hide();
				}

			});

			/**
			 * tab change
			 */
			$(".tab-title li a").mouseenter(function() {
				$xuhao = $(".tab-title li").index($(this).parent("li"));
				$(".tab-title li a").removeClass("active");
				$(this).addClass("active");

				$(".tab-content").addClass("hide");
				$(".tab-content").eq($xuhao).removeClass("hide");

			});

			$(".miaosha-content-block-img img").mouseenter(function() {
				$(this).animate({
					top : "-5px"
				}, 150).animate({
					top : "0px"
				}, 150);
			}).mouseleave(function() {
				$(this).stop(false, true);
			});

			$(".catedetail").mouseleave(
					function(event) {

						if (event.clientY + $(document).scrollTop() <= $(this)
								.offset().top) {
							$(".catedetail").hide();
						}

						if (event.clientY + $(document).scrollTop() >= $(this)
								.offset().top
								+ $(this).height() + 4) {
							$(".catedetail").hide();
						}

						if (event.clientX >= $(this).offset().left
								+ $(this).width()) {
							$(".catedetail").hide();
						}

					});


			$("#yonghuming").focus(function() {
				$(this).addClass("dianji");
				$(".zhucetishi").show();
			}).blur(function() {
				$(this).removeClass("dianji");
			});
			
			
			
			$("#btn-zhuce").click(function(){
				$("#stepone").submit();
			});
			
			
			var error = '${error}';
			if(error != ''){
				$(".zhuceerror").html(error).show();
				$("#yonghuming").addClass("mingcheng-error");
			}

		});
	</script>
</body>
</html>

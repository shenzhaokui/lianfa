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
		<title>我的联发 - 个人资料</title>
		<link rel="stylesheet" type="text/css" href="${ctxStatic}/css/lianfa.css" />
	</head>

	<body>
		
		<!-- user head -->
		<jsp:include page="/WEB-INF/views/common/include/user/pc/userhead.jsp"></jsp:include>

		<div class="container">
			<div class="wode-left">
				
				<!-- menu -->
				<jsp:include page="/WEB-INF/views/common/include/user/pc/usermenu.jsp"></jsp:include>

			</div>

			<div class="wode-right">
				
				<shiro:hasRole name="seller">
				<div class="wode-content clearfix pull-10">
					<div class="wode-content-head wode-content-head-2 clearfix">
						<div class="wode-content-head-left">
							身份信息
						</div>
					</div>
					<div class="wode-content-detail tongji">
						<p>登录账号：topszk</p>
						<p>真实姓名：申**</p>
						<p>身份证号码：3708**********7412</p>
						<p class="pull-10"><span class="red">注意：真是身份一经填写不能修改，它将作为该账号归属的最终凭据。如果填写错误，请与平台客服人员联系。</span></p>
						<p class="lv">为安全起见，您的真实姓名和身份证号码，部分内容以"*"号代替。即便账号被盗，盗号者也无法查看。</p>
					</div>
				</div>
				</shiro:hasRole>
				
				<div class="wode-content clearfix pull-10">
					<div class="wode-content-head wode-content-head-2 clearfix">
						<div class="wode-content-head-left">
							登录密码
						</div>
					</div>
					<div class="wode-content-detail tongji">
						
						<p>登录密码已设置，如需修改，请点击下面的按钮。</p>
						
						<p class="pull-10"><a href="#" class="querenshouhuo tixian">修改密码</a></p>
					</div>
				</div>
				
				<shiro:hasRole name="seller">
				<div class="wode-content clearfix pull-10">
					<div class="wode-content-head wode-content-head-2 clearfix">
						<div class="wode-content-head-left">
							绑定手机
						</div>
					</div>
					<div class="wode-content-detail tongji">
						
						<p>您已绑定手机：156*****391</p>
						<p><span class="red">注意：绑定的手机号码是您密码找回的重要方式，账号的敏感操作也需要手机验证码</span></p>
						<p class="lv">为安全起见，您绑定的手机号码，部分内容以"*"号代替。即便账号被盗，盗号者也无法查看。</p>
						<p class="pull-10"><a href="#" class="querenshouhuo tixian">修改绑定手机</a></p>
					</div>
				</div>
				
				<div class="wode-content clearfix pull-10">
					<div class="wode-content-head wode-content-head-2 clearfix">
						<div class="wode-content-head-left">
							绑定电子邮箱
						</div>
					</div>
					<div class="wode-content-detail tongji">
						
						<p>您已绑定邮箱：s***k@163.com</p>
						<p><span class="red">注意：绑定的邮箱可以用于密码找回，以及接收重要通知的途径。</span></p>
						<p class="lv">为安全起见，您绑定的电子邮箱，部分内容以"*"号代替。即便账号被盗，盗号者也无法查看。</p>
						<p class="pull-10"><a href="#" class="querenshouhuo tixian">修改绑定手机</a></p>
					</div>
				</div>
				
				<div class="wode-content clearfix pull-10">
					<div class="wode-content-head wode-content-head-2 clearfix">
						<div class="wode-content-head-left">
							收款方式
						</div>
					</div>
					<div class="wode-content-detail tongji">
						
						<p>您已绑定支付宝账号：s***k@163.com （申**）</p>
						<p><span class="red">注意：收款方式支持银行卡、支付宝、微信。请如实填写以免提款无法到账。</span></p>
						<p class="lv">为安全起见，您绑定的收款方式，部分内容以"*"号代替。即便账号被盗，盗号者也无法查看。</p>
						<p class="pull-10"><a href="#" class="querenshouhuo tixian">修改收款方式</a></p>
					</div>
				</div>
				</shiro:hasRole>
				
				<div class="wode-content clearfix pull-10">
					<div class="wode-content-head wode-content-head-2 clearfix">
						<div class="wode-content-head-left">
							收货地址
						</div>
					</div>
					<div class="wode-content-detail tongji">
						
						<p>青岛开发区西海景苑4号楼1303户</p>
						<p>收货人姓名：申兆魁</p>
						<p>手机：15653251391</p>
						<p><span class="red">注意：本地址，是您在平台购物的默认收货地址，请认真填写以免宝贝无法准确送达。</span></p>
						<p class="pull-10"><a href="#" class="querenshouhuo tixian">修改收款方式</a></p>
					</div>
				</div>
				

			</div>
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
				
				$("ul.wode li a:contains('修改资料')").addClass("xuanzhong");

				/**
				 * sort 
				 */
				$(".sort-detail-block ul li").mouseenter(function(event) {
					$(this).addClass("mouseup");

					if($(this).index() == 0) {
						$(".catedetail").hide();
						$("#jiadianshuma").show();
					} else if($(this).index() == 1) {
						$(".catedetail").hide();
						$("#diannaobangong").show();
					} else if($(this).index() == 2) {
						$(".catedetail").hide();
						$("#jiaju").show();
					} else if($(this).index() == 3) {
						$(".catedetail").hide();
						$("#nanzhuang").show();
					} else if($(this).index() == 4) {
						$(".catedetail").hide();
						$("#xiexue").show();
					} else if($(this).index() == 5) {
						$(".catedetail").hide();
						$("#meizhuang").show();
					} else if($(this).index() == 6) {
						$(".catedetail").hide();
						$("#zhubao").show();
					} else if($(this).index() == 7) {
						$(".catedetail").hide();
						$("#yundong").show();
					} else if($(this).index() == 8) {
						$(".catedetail").hide();
						$("#youxi").show();
					} else if($(this).index() == 9) {
						$(".catedetail").hide();
						$("#meishi").show();
					} else if($(this).index() == 10) {
						$(".catedetail").hide();
						$("#xianhua").show();
					} else if($(this).index() == 11) {
						$(".catedetail").hide();
						$("#fangchan").show();
					} else if($(this).index() == 12) {
						$(".catedetail").hide();
						$("#jiajujiashi").show();
					} else if($(this).index() == 13) {
						$(".catedetail").hide();
						$("#qiche").show();
					} else if($(this).index() == 14) {
						$(".catedetail").hide();
						$("#wujin").show();
					} else if($(this).index() == 15) {
						$(".catedetail").hide();
						$("#baihuo").show();
					} else if($(this).index() == 16) {
						$(".catedetail").hide();
						$("#xuexi").show();
					}

				}).mouseleave(function(event) {
					$(this).removeClass("mouseup");
					if(event.clientY <= 202) {
						$(".catedetail").hide();
					}

					if(event.clientX <= $(this).offset().left) {
						$(".catedetail").hide();
					}

					if(event.clientY + $(document).scrollTop() > 670) {
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
						top: "-5px"
					}, 150).animate({
						top: "0px"
					}, 150);
				}).mouseleave(function() {
					$(this).stop(false, true);
				});

				$(".catedetail").mouseleave(function(event) {

					if(event.clientY + $(document).scrollTop() <= $(this).offset().top) {
						$(".catedetail").hide();
					}

					if(event.clientY + $(document).scrollTop() >= $(this).offset().top + $(this).height() + 4) {
						$(".catedetail").hide();
					}

					if(event.clientX >= $(this).offset().left + $(this).width()) {
						$(".catedetail").hide();
					}

				});

				//				$(".mask").height($(document).height()).css("opacity",0.7).show();

			});
		</script>
	</body>

</html>
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
		<title>用户登录</title>
		<link rel="stylesheet" type="text/css" href="${ctxStatic}/css/lianfa.css"/>
	</head>
	<body class="bgwhite">
		
		
		<div class="subhead">
			<div class="container subhead">
				<div class="span-2">
					<div class="logo pull-10">
						<a href="${shopPrefix}"><img src="${ctxStatic}/img/logo_s.png"/></a>
					</div>
				</div>
			</div>
		</div>
		
		
		
		<div class="loginbg">
			<div class="container">
				
				<form:form action="${userPrefix}/login" method="post" id="loginform">
				
					<div class="loginblock">
						<p class="denglu"><img src="${ctxStatic}/img/denglu.png"/></p>
						<div class="notice">
							${msg}
						</div>
						<div class="logininputbox">
							<div class="logininputbox-yonghuming"></div>
							<div class="logininputbox-right">
								<input type="text" name="username" id="" value="${username}" class="logininput" placeholder="会员名/手机号/邮箱" maxlength="16"/>
							</div>
						</div>
						
						<div class="logininputbox">
							<div class="logininputbox-mima"></div>
							<div class="logininputbox-right">
								<input type="password" name="password" id="" value="" class="logininput" maxlength="18"/>
							</div>
						</div>
						
						
						
						<a href="javascript:void(0)" class="btn-denglu" id="btn-denglu">登录</a>
						
						<div style="margin-top: 30px;">
							<ul class="horizontal text-right">
								<li><a href="#">忘记密码</a></li>
								<li><a href="${authcUserPrefix}/register">免费注册</a></li>
							</ul>
						</div>
						
					</div>
				
				</form:form>
				
			</div>
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
						<li><img src="${ctxStatic}/img/ico1.png"/></li>
						<li><img src="${ctxStatic}/img/ico2.png"/></li>
						<li><img src="${ctxStatic}/img/ico3.jpg"/></li>
						<li><img src="${ctxStatic}/img/ico4.png"/></li>
						<li><img src="${ctxStatic}/img/ico5.jpg"/></li>
						<li><img src="${ctxStatic}/img/ico6.jpg"/></li>
					</ul>
				</div>
			</div>
		</div>
		
		
		
		<div class="mask">
			
		</div>
		
		
		<script src="${ctxStatic}/js/jquery-3.2.1.min.js" type="text/javascript" charset="utf-8"></script>
		<script type="text/javascript">
			$(function(){
				
				/**
				 * sort 
				 */
				$(".sort-detail-block ul li").mouseenter(function(event){
					$(this).addClass("mouseup");
					
					if($(this).index() == 0){
						$(".catedetail").hide();
						$("#jiadianshuma").show();
					}else if($(this).index() == 1){
						$(".catedetail").hide();
						$("#diannaobangong").show();
					}else if($(this).index() == 2){
						$(".catedetail").hide();
						$("#jiaju").show();
					}else if($(this).index() == 3){
						$(".catedetail").hide();
						$("#nanzhuang").show();
					}else if($(this).index() == 4){
						$(".catedetail").hide();
						$("#xiexue").show();
					}else if($(this).index() == 5){
						$(".catedetail").hide();
						$("#meizhuang").show();
					}else if($(this).index() == 6){
						$(".catedetail").hide();
						$("#zhubao").show();
					}else if($(this).index() == 7){
						$(".catedetail").hide();
						$("#yundong").show();
					}else if($(this).index() == 8){
						$(".catedetail").hide();
						$("#youxi").show();
					}else if($(this).index() == 9){
						$(".catedetail").hide();
						$("#meishi").show();
					}else if($(this).index() == 10){
						$(".catedetail").hide();
						$("#xianhua").show();
					}else if($(this).index() == 11){
						$(".catedetail").hide();
						$("#fangchan").show();
					}else if($(this).index() == 12){
						$(".catedetail").hide();
						$("#jiajujiashi").show();
					}else if($(this).index() == 13){
						$(".catedetail").hide();
						$("#qiche").show();
					}else if($(this).index() == 14){
						$(".catedetail").hide();
						$("#wujin").show();
					}else if($(this).index() == 15){
						$(".catedetail").hide();
						$("#baihuo").show();
					}else if($(this).index() == 16){
						$(".catedetail").hide();
						$("#xuexi").show();
					}
					
					
				}).mouseleave(function(event){
					$(this).removeClass("mouseup");
					if(event.clientY <= 202){
						$(".catedetail").hide();
					}
					
					if(event.clientX <= $(this).offset().left){
						$(".catedetail").hide();
					}
					
					if(event.clientY + $(document).scrollTop() > 670){
						$(".catedetail").hide();
					}
					
				});
				
				/**
				 * tab change
				 */
				$(".tab-title li a").mouseenter(function(){
					$xuhao = $(".tab-title li").index($(this).parent("li"));
					$(".tab-title li a").removeClass("active");
					$(this).addClass("active");
					
					$(".tab-content").addClass("hide");
					$(".tab-content").eq($xuhao).removeClass("hide");
					
				});
				
				
				
				$(".miaosha-content-block-img img").mouseenter(function(){
					$(this).animate({
						top:"-5px"
					},150).animate({
						top:"0px"
					},150);
				}).mouseleave(function(){
					$(this).stop(false,true);
				});
				
				
				
				$(".catedetail").mouseleave(function(event){
				
					if(event.clientY + $(document).scrollTop() <= $(this).offset().top){
						$(".catedetail").hide();
					}
					
					if(event.clientY + $(document).scrollTop() >= $(this).offset().top + $(this).height() + 4){
						$(".catedetail").hide();
					}
					
					
					if(event.clientX >= $(this).offset().left + $(this).width()){
						$(".catedetail").hide();
					}
					
				});
				
				
//				$(".mask").height($(document).height()).css("opacity",0.7).show();
				
				
				
				$("#btn-denglu").click(function(){
					$("#loginform").submit();
				});
				
				
				var msg = '${msg}';
				if(msg != ''){
					$("p.denglu").hide();
					$("div.notice").show();
				}
				
				
			});
		</script>
	</body>
</html>

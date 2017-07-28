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
		<title>我的联发 - 收入明细</title>
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
				
				
				
				<div class="wode-content clearfix pull-10">
					<div class="wode-content-head wode-content-head-2 clearfix">
						<div class="wode-content-head-left">
							收入明细
						</div>
					</div>

					<div class="wode-content-detail tongji">
						<table class="xiaxian">
							<tr>
								<td>#</td>
								<td>订单号</td>
								<td>订单金额</td>
								<td>销售店面</td>
								<td>佣金</td>
								<td>订单日期</td>
								<td>订单状态</td>
								<td>佣金状态</td>
								<td>操作</td>
							</tr>
							<tr>
								<td>1</td>
								<td>256665566666</td>
								<td>3650.85</td>
								<td>刘** （一级连锁店）</td>
								<td><span class="red">360.5</span></td>
								<td>2017-06-11</td>
								<td><span class="red">待发货</span></td>
								<td><span class="red">待确认</span></td>
								<td><a href="#">查看详情</a></td>
							</tr>
							<tr>
								<td>1</td>
								<td>256665566666</td>
								<td>3650.85</td>
								<td>刘** （一级连锁店）</td>
								<td><span class="red">360.5</span></td>
								<td>2017-06-11</td>
								<td><span class="lan">已发货</span></td>
								<td><span class="red">待确认</span></td>
								<td><a href="#">查看详情</a></td>
							</tr>
							<tr>
								<td>1</td>
								<td>256665566666</td>
								<td>3650.85</td>
								<td>刘** （一级连锁店）</td>
								<td><span class="red">360.5</span></td>
								<td>2017-06-11</td>
								<td><span class="lv">已签收</span></td>
								<td><span class="red">待确认</span> <span class="hui">（剩余6天）</span></td>
								<td><a href="#">查看详情</a></td>
							</tr>
							<tr>
								<td>1</td>
								<td>256665566666</td>
								<td>3650.85</td>
								<td>刘** （一级连锁店）</td>
								<td><span class="red">360.5</span></td>
								<td>2017-06-11</td>
								<td><span class="lv">已签收</span></td>
								<td><span class="red">待确认</span> <span class="hui">（剩余3天）</span></td>
								<td><a href="#">查看详情</a></td>
							</tr>
							<tr>
								<td>1</td>
								<td>256665566666</td>
								<td>3650.85</td>
								<td>周** （一级连锁店）</td>
								<td><span class="red">360.5</span></td>
								<td>2017-06-11</td>
								<td><span class="lv">已签收</span></td>
								<td><span class="lv">已确认</span></td>
								<td><a href="#">查看详情</a></td>
							</tr>
							<tr>
								<td>1</td>
								<td>256665566666</td>
								<td>3650.85</td>
								<td>刘** （本店）</td>
								<td><span class="red">360.5</span></td>
								<td>2017-06-11</td>
								<td><span class="lv">已签收</span></td>
								<td><span class="red">待确认</span> <span class="hui">（剩余6天）</span></td>
								<td><a href="#">查看详情</a></td>
							</tr>
							<tr>
								<td>1</td>
								<td>256665566666</td>
								<td>3650.85</td>
								<td>王** （二级连锁店）</td>
								<td><span class="red">360.5</span></td>
								<td>2017-06-11</td>
								<td><span class="lv">已签收</span></td>
								<td><span class="red">待确认</span> <span class="hui">（剩余6天）</span></td>
								<td><a href="#">查看详情</a></td>
							</tr>
							<tr>
								<td>1</td>
								<td>256665566666</td>
								<td>3650.85</td>
								<td>王** （三级连锁店）</td>
								<td><span class="red">360.5</span></td>
								<td>2017-06-11</td>
								<td><span class="lv">已签收</span></td>
								<td><span class="red">待确认</span> <span class="hui">（剩余6天）</span></td>
								<td><a href="#">查看详情</a></td>
							</tr>
							<tr>
								<td>1</td>
								<td>256665566666</td>
								<td>3650.85</td>
								<td>刘** （一级连锁店）</td>
								<td><span class="red">360.5</span></td>
								<td>2017-06-11</td>
								<td><span class="lv">已签收</span></td>
								<td><span class="red">待确认</span> <span class="hui">（剩余3天）</span></td>
								<td><a href="#">查看详情</a></td>
							</tr>
							<tr>
								<td>1</td>
								<td>256665566666</td>
								<td>3650.85</td>
								<td>刘** （一级连锁店）</td>
								<td><span class="red">360.5</span></td>
								<td>2017-06-11</td>
								<td><span class="lv">已签收</span></td>
								<td><span class="red">待确认</span> <span class="hui">（剩余3天）</span></td>
								<td><a href="#">查看详情</a></td>
							</tr>
							<tr>
								<td>1</td>
								<td>256665566666</td>
								<td>3650.85</td>
								<td>刘** （一级连锁店）</td>
								<td><span class="red">360.5</span></td>
								<td>2017-06-11</td>
								<td><span class="lv">已签收</span></td>
								<td><span class="red">待确认</span> <span class="hui">（剩余3天）</span></td>
								<td><a href="#">查看详情</a></td>
							</tr>
							<tr>
								<td>1</td>
								<td>256665566666</td>
								<td>3650.85</td>
								<td>刘** （一级连锁店）</td>
								<td><span class="red">360.5</span></td>
								<td>2017-06-11</td>
								<td><span class="lv">已签收</span></td>
								<td><span class="red">待确认</span> <span class="hui">（剩余3天）</span></td>
								<td><a href="#">查看详情</a></td>
							</tr>
							<tr>
								<td>1</td>
								<td>256665566666</td>
								<td>3650.85</td>
								<td>刘** （一级连锁店）</td>
								<td><span class="red">360.5</span></td>
								<td>2017-06-11</td>
								<td><span class="lv">已签收</span></td>
								<td><span class="red">待确认</span> <span class="hui">（剩余3天）</span></td>
								<td><a href="#">查看详情</a></td>
							</tr>
						</table>
					</div>

				</div>

				<div class="pull-20 text-right bottom-10">
					<ul class="fenye clearfix">
						<li>
							<a href="javascript:void(0)">首页</a>
						</li>
						<li>
							<a href="javascript:void(0)">上一页</a>
						</li>
						<li>
							<a href="javascript:void(0)">1</a>
						</li>
						<li>
							<a href="javascript:void(0)">2</a>
						</li>
						<li>
							<a href="javascript:void(0)">3</a>
						</li>
						<li>
							<a href="javascript:void(0)">4</a>
						</li>
						<li>
							<a href="javascript:void(0)">5</a>
						</li>
						<li>
							<a href="javascript:void(0)">6</a>
						</li>
						<li>
							<a href="javascript:void(0)">7</a>
						</li>
						<li>
							<a href="javascript:void(0)">8</a>
						</li>
						<li>
							<a href="javascript:void(0)">...</a>
						</li>
						<li>
							<a href="javascript:void(0)">9</a>
						</li>
						<li>
							<a href="javascript:void(0)">下一页</a>
						</li>
						<li class="last">
							<a href="javascript:void(0)">尾页</a>
						</li>
					</ul>
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
				
				$("ul.wode li a:contains('我的财务')").addClass("xuanzhong");

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
				
				
				
				$("table.xiaxian tr").mouseenter(function(){
					$(this).addClass("tr");
				}).mouseleave(function(){
					$(this).removeClass("tr");
				});

			});
		</script>
	</body>

</html>
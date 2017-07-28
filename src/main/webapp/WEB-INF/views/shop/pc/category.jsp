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
		<title>联发商城 - 宝贝分类</title>
		<link rel="stylesheet" type="text/css" href="${ctxStatic}/css/lianfa.css" />
	</head>

	<body class="bgwhite">
		<!-- tophead -->
		<jsp:include page="/WEB-INF/views/common/include/shop/pc/tophead.jsp"></jsp:include>

		<!-- subhead -->
		<jsp:include page="/WEB-INF/views/common/include/shop/pc/subhead2.jsp"></jsp:include>
		
		
		
		
		

		<div class="container">

			<div id="hidden-sort">
				<div class="sort-detail-block">
					<ul>
						<li><i>&gt;</i>
							<a href="${shopPrefix}/category?id=6df7ce0ec3984e70bc83e981bea0df8e">家电</a> <span>/</span>
							<a href="${shopPrefix}/category">数码</a> <span>/</span>
							<a href="${shopPrefix}/category">手机</a>
						</li>
						<li><i>&gt;</i>
							<a href="${shopPrefix}/category">电脑</a> <span>/</span>
							<a href="${shopPrefix}/category">办公</a>
						</li>
						<li><i>&gt;</i>
							<a href="${shopPrefix}/category">家居</a> <span>/</span>
							<a href="${shopPrefix}/category">家具</a> <span>/</span>
							<a href="${shopPrefix}/category">家装</a> <span>/</span>
							<a href="${shopPrefix}/category">厨具</a>
						</li>
						<li><i>&gt;</i>
							<a href="${shopPrefix}/category">男装</a> <span>/</span>
							<a href="${shopPrefix}/category">女装</a> <span>/</span>
							<a href="${shopPrefix}/category">童装</a> <span>/</span>
							<a href="${shopPrefix}/category">内衣</a>
						</li>
						<li><i>&gt;</i>
							<a href="${shopPrefix}/category">鞋靴</a> <span>/</span>
							<a href="${shopPrefix}/category">箱包</a> <span>/</span>
							<a href="${shopPrefix}/category">配件</a> <span>/</span>
							<a href="${shopPrefix}/category">配饰</a>
						</li>
						<li><i>&gt;</i>
							<a href="${shopPrefix}/category">美妆</a> <span>/</span>
							<a href="${shopPrefix}/category">洗护</a> <span>/</span>
							<a href="${shopPrefix}/category">保健品</a>
						</li>
						<li><i>&gt;</i>
							<a href="${shopPrefix}/category">珠宝</a> <span>/</span>
							<a href="${shopPrefix}/category">眼镜</a> <span>/</span>
							<a href="${shopPrefix}/category">手表</a>
						</li>
						<li><i>&gt;</i>
							<a href="${shopPrefix}/category">运动</a> <span>/</span>
							<a href="${shopPrefix}/category">户外</a> <span>/</span>
							<a href="${shopPrefix}/category">乐器</a>
						</li>
						<li><i>&gt;</i>
							<a href="${shopPrefix}/category">游戏</a> <span>/</span>
							<a href="${shopPrefix}/category">动漫</a> <span>/</span>
							<a href="${shopPrefix}/category">影视</a>
						</li>
						<li><i>&gt;</i>
							<a href="${shopPrefix}/category">美食</a> <span>/</span>
							<a href="${shopPrefix}/category">生鲜</a> <span>/</span>
							<a href="${shopPrefix}/category">零食</a>
						</li>
						<li><i>&gt;</i>
							<a href="${shopPrefix}/category">鲜花</a> <span>/</span>
							<a href="${shopPrefix}/category">宠物</a> <span>/</span>
							<a href="${shopPrefix}/category">农资</a>
						</li>
						<li><i>&gt;</i>
							<a href="${shopPrefix}/category">房产</a> <span>/</span>
							<a href="${shopPrefix}/category">装修</a> <span>/</span>
							<a href="${shopPrefix}/category">建材</a>
						</li>
						<li><i>&gt;</i>
							<a href="${shopPrefix}/category">家具</a> <span>/</span>
							<a href="${shopPrefix}/category">家饰</a> <span>/</span>
							<a href="${shopPrefix}/category">家纺</a>
						</li>
						<li><i>&gt;</i>
							<a href="${shopPrefix}/category">汽车</a> <span>/</span>
							<a href="${shopPrefix}/category">汽车用品</a>
						</li>
						<li><i>&gt;</i>
							<a href="${shopPrefix}/category">五金电子</a> <span>/</span>
							<a href="${shopPrefix}/category">DIY</a>
						</li>
						<li><i>&gt;</i>
							<a href="${shopPrefix}/category">百货</a> <span>/</span>
							<a href="${shopPrefix}/category">餐厨</a> <span>/</span>
							<a href="${shopPrefix}/category">家庭保健</a>
						</li>
						<li><i>&gt;</i>
							<a href="${shopPrefix}/category">学习</a> <span>/</span>
							<a href="${shopPrefix}/category">卡券</a> <span>/</span>
							<a href="${shopPrefix}/category">本地服务</a>
						</li>
					</ul>
				</div>
			</div>
			

		</div>
		
		
		<!--
        	作者：sinnk@163.com
        	时间：2017-05-28
        	描述：分类导航
        -->
		<div class="category-bg">
			<div class="container category-block">
				<a href="javascript:void(0)">所有分类</a>
				<span>&gt;</span>
				<c:if test="${fatherCategory != null }">
					<a href="${shopPrefix}/category?id=${fatherCategory.id}">${fatherCategory.categoryName }</a>
					<span>&gt;</span>
				</c:if>
				<a href="${shopPrefix}/category?id=${category.id}">${category.categoryName }</a>
			</div>
		</div>
		
		<div class="container">
			<div class="span-row">
				<div class="category-content pull-10 clearfix">
					<div class="category-content-left">
						<ul class="horizontal">
							<li>相关分类：</li>
						</ul>
					</div>
					<div class="category-content-right">
						<ul class="horizontal">
							<c:forEach items="${list}" var="item">
								<li><a href="${shopPrefix}/category?id=${item.id}">${item.categoryName }</a></li>
							</c:forEach>
						</ul>
					</div>
				</div>
			</div>
			
			<div class="span-row pull-10">
				<div class="paiming-content">
					<ul class="clearfix">
						<li><a href="javascript:void(0)" class="bg_bai"><i><img src="${ctxStatic}/img/sanjiao.png"/></i>综合排名</a></li>
						<li><a href="javascript:void(0)"><i><img src="${ctxStatic}/img/sanjiao.png"/></i>销量</a></li>
						<li><a href="javascript:void(0)"><i><img src="${ctxStatic}/img/sanjiao.png"/></i>价格</a></li>
						<li><a href="javascript:void(0)"><i><img src="${ctxStatic}/img/sanjiao.png"/></i>新品</a></li>
						<li><a href="javascript:void(0)"><i><img src="${ctxStatic}/img/sanjiao.png"/></i>评论数</a></li>
					</ul>
				</div>
			</div>
			
			
			
			<div class="span-row pull-10">
			
			<c:forEach items="${productList}" var="item" varStatus="status">
			
				<div class="item-list <c:if test="${status.index > 0 and status.index % 3 == 0 }">item-list-last</c:if>">
					<div class="item-list-img">
						<a href="${shopPrefix}/item?id=${item.id}"><img src="${img}/${item.smallPicUrl}"/></a>
					</div>
					<div class="clearfix">
						<div class="item-list-left">
							&yen; ${item.currentPrice}<span>包邮</span> 
						</div>
						<div class="item-list-right">
							128人付款
						</div>
					</div>
					<p><a href="${shopPrefix}/item?id=${item.id}">${item.productName }</a></p>
					<div class="clearfix pai">
						<a href="#" class="btn">立即购买</a>
						<a href="#" class="btn">加入购物车</a>
						<a href="#" class="btn">收藏</a>
					</div>
				</div>
				
			</c:forEach>
			
			
				
				
				
				
				
				
			</div>
			
			
			
			<div class="span-row pull-10 text-right bottom-10">
				<ul class="fenye clearfix">
					<li><a href="javascript:void(0)">首页</a></li>
					<li><a href="javascript:void(0)">上一页</a></li>
					<li><a href="javascript:void(0)">1</a></li>
					<li><a href="javascript:void(0)">2</a></li>
					<li><a href="javascript:void(0)">3</a></li>
					<li><a href="javascript:void(0)">4</a></li>
					<li><a href="javascript:void(0)">5</a></li>
					<li><a href="javascript:void(0)">6</a></li>
					<li><a href="javascript:void(0)">7</a></li>
					<li><a href="javascript:void(0)">8</a></li>
					<li><a href="javascript:void(0)">...</a></li>
					<li><a href="javascript:void(0)">9</a></li>
					<li><a href="javascript:void(0)">下一页</a></li>
					<li class="last"><a href="javascript:void(0)">尾页</a></li>
				</ul>
			</div>
			
		</div>

		<!--
        	作者：sinnk@163.com
        	时间：2017-05-12
        	描述：尾部
        -->
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

		<script src="${ctxStatic}/js/jquery-3.2.1.min.js" type="text/javascript" charset="utf-8"></script>
		<script type="text/javascript">
			$(function() {

				/**
				 * sort 
				 */
				$(".sort-detail-block ul li").mouseenter(function() {
					$(this).addClass("mouseup");
				}).mouseleave(function() {
					$(this).removeClass("mouseup");
				});

				$(".sort-title").mouseenter(function() {
					$("#hidden-sort").show();
				}).mouseleave(function(event) {
					
					if(event.clientY + $(document).scrollTop() >= $("#hidden-sort").offset().top + $("#hidden-sort").height()) {
						$("#hidden-sort").hide();
					}
					
					if(event.clientY + $(document).scrollTop() <= $(this).offset().top){
						$("#hidden-sort").hide();
					}
					
					if(event.clientX <= $(this).offset().left){
						$("#hidden-sort").hide();
					}

				});

				$("#hidden-sort").mouseleave(function(event) {

					if(event.clientX < $(this).offset().left || event.clientY + $(document).scrollTop() >= ($(this).offset().top + $(this).height())) {
						$(this).hide();
					}

				});
				
				
				
				$(".yanse li a").click(function(){
					$(".yanse li a").removeClass("clicked");
					$(this).addClass("clicked");
				});
				
				
				
				$("ul.xiangqing li a").click(function(){
					$xuhao = $(this).parent("li").index();
					
					$("ul.xiangqing li a").removeClass("select");
					
					$(this).addClass("select")
					
					if($xuhao != 0){
						$("ul.xiangqing li:first a").addClass("first");
					}else{
						$("ul.xiangqing li:first a").removeClass("first");
						$("#leijipinglun,#xiaoshoujilu").addClass("hide");
						$("#baobeixiangqing").removeClass("hide");
					}
					
					if($xuhao == 1){
						$("#baobeixiangqing,#xiaoshoujilu").addClass("hide");
						$("#leijipinglun").removeClass("hide");
					}
					
					if($xuhao == 2){
						$("#baobeixiangqing,#leijipinglun").addClass("hide");
						$("#xiaoshoujilu").removeClass("hide");
					}
					
				});
				
				
				
				$(".item-list").mouseenter(function(){
					$(this).addClass("item-list-active")
				}).mouseleave(function(){
					$(this).removeClass("item-list-active")
				});

			});
		</script>
	</body>

</html>
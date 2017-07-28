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
		<title>联发商城 - 宝贝详情</title>
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
							<a href="${shopPrefix}/category">家电</a> <span>/</span>
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

			<div class="span-400 pull-10">
				<div class="goodpic">
					<img src="${img}/${product.bigPicUrl}" />
					<ul class="horizontal pull-10 suoluetu">
						<c:forEach items="${product.thumbnails}" var="item" varStatus="status">
						<li <c:if test="${status.last }">class="last"</c:if>> 
							<a href="${shopPrefix}/item"><img src="${img}/${item.thumbnailUrl}" /></a>
						</li>
						</c:forEach>
						
					</ul>
					<ul class="horizontal pull-10 line">
						<li><i><img src="${ctxStatic}/img/shoucang.png"/></i>
							<a href="${shopPrefix}/item">收藏宝贝（1233人气）</a>
						</li>
						<li class="last"><i><img src="${ctxStatic}/img/fenxiang.png"/></i>
							<a href="${shopPrefix}/item">分享宝贝</a>
						</li>
					</ul>
				</div>
			</div>

			<div class="span-433 pull-10">
				<div class="gooddetail">
					<h1>${product.productName }</h1>
					<table width="100%" border="0" class="pull-10">
						<tr class="hong1">
							<td width="60">价格</td>
							<td width="110"><span>&yen;</span> <del>${product.originalPrice }</del></td>
							<td>
								<ul class="horizontal text-right table">
									<li class="text-center"><a href="${shopPrefix}/item"><span class="pinglun">3006</span><br/>累计评论</a></li>
									<li class="text-center last"><span class="pinglun">384</span><br/>交易成功</li>
								</ul>
							</td>
						</tr>
						<tr class="hong1">
							<td>折扣价</td>
							<td><span class="price">&yen; ${product.currentPrice }</span></td>
							<td>&nbsp;</td>
						</tr>
						<tr class="hong2 youhui">
							<td>优惠</td>
							<td colspan="2"><fmt:formatNumber maxFractionDigits="1">${product.currentPrice / product.originalPrice *10 }</fmt:formatNumber> 折</td> 
						</tr>
						<tr class="peisong">
							<td>配送</td>
							<td colspan="2">快递全国包邮</td>
						</tr>
						<tr class="youhui">
							<td valign="top">颜色分类</td>
							<td colspan="2">
								<ul class="horizontal yanse">
									<c:forEach items="${product.typeList}" var="item">
									<li><a href="javascript:void(0);"><img src="${img}/${item.imgUrl}"/></a></li>
									</c:forEach>
									
								</ul>
							</td>
						</tr>
						<tr class="youhui">
							<td>数量</td>
							<td colspan="2">
								<div class="shuliang">
									<div class="shuliang-jian">
										<a href="javascript:void(0);"><img src="${ctxStatic}/img/jianhao.png"/></a>
									</div>
									<div class="shuliang-middle">
										<input type="text"  value="1" />
									</div>
									<div class="shuliang-jia">
										<a href="javascript:void(0);"><img src="${ctxStatic}/img/jiahao.png"/></a>
									</div>
								</div>
								<div class="shuliang-kucun">
									件 （库存<span>1556</span>件）
								</div>
							</td>
						</tr>
						<tr>
							<td colspan="3">
								<div class="lijigoumai">
									<a href="${userPrefix }/createsingleorder?productid=${product.id}">立即购买</a>
								</div>
								<div class="jiarushoucang">
									<a href="javascript:void(0)">加入购物车</a>
								</div>
							</td>
						</tr>
						<tr class="youhui">
							<td>承诺</td>
							<td colspan="2">
								<ul class="horizontal">
									<li class="chengnuo"><img src="${ctxStatic}/img/7day.jpg"/>7天无理由退换</li>
									<li class="chengnuo"><img src="${ctxStatic}/img/48hour.png"/>24小时发货</li>
								</ul>
							</td>
						</tr>
						<tr class="youhui">
							<td>支付</td>
							<td colspan="2">
								<ul class="horizontal">
									<li class="chengnuo"><img src="${ctxStatic}/img/yue.png"/>余额支付</li>
									<li class="chengnuo"><img src="${ctxStatic}/img/weixinzhifu.png"/>微信支付</li>
									<li class="chengnuo"><img src="${ctxStatic}/img/alipay.png"/>支付宝</li>
								</ul>
							</td>
						</tr>
					</table>
				</div>
			</div>

			<div class="span-139 pull-10 last">
				<div class="xiangguan">
					<img src="${ctxStatic}/img/kanleyoukan.png"/>
					<p>
						<a href="${shopPrefix}/item"><img src="${ctxStatic}/img/1281.jpg" /></a>
					</p>
					<p>
						<a href="${shopPrefix}/item"><img src="${ctxStatic}/img/1282.jpg" /></a>
					</p>
					<p class="last">
						<a href="${shopPrefix}/item"><img src="${ctxStatic}/img/1283.jpg" /></a>
					</p>
				</div>
			</div>
			
			<div class="span-row bottomsolid">
				
			</div>
			
			
			
			<div class="span-210 row">
				<div class="tuijianbaobei">
					推荐宝贝
				</div>
				<ul class="tuijian">
					<li>
						<a href="javascript:void(0)"><img src="${ctxStatic}/img/210.jpg"/></a>
						<a href="javascript:void(0)">VOLUSPA大浮雕玻璃杯进口代购精油大浮雕玻璃杯进口代购精油</a>
						<p>&yen; 233</p>
					</li>
					<li>
						<a href="javascript:void(0)"><img src="${ctxStatic}/img/210.jpg"/></a>
						<a href="javascript:void(0)">VOLUSPA大浮雕玻璃杯进口代购精油大浮雕玻璃杯进口代购精油</a>
						<p>&yen; 233</p>
					</li>
					<li>
						<a href="javascript:void(0)"><img src="${ctxStatic}/img/210.jpg"/></a>
						<a href="javascript:void(0)">VOLUSPA大浮雕玻璃杯进口代购精油大浮雕玻璃杯进口代购精油</a>
						<p>&yen; 233</p>
					</li>
				</ul>
			</div>
			
			<div class="span-772 row">
				<ul class="horizontal xiangqing">
					<li><a href="javascript:void(0)" class="select">宝贝详情</a></li>
					<li><a href="javascript:void(0)">累计评论</a></li>
					<li><a href="javascript:void(0)">成交记录</a></li>
				</ul>
				<!--
                	作者：sinnk@163.com
                	时间：2017-05-19
                	描述：宝贝详情
                -->
				<div id="baobeixiangqing" class="baobeixiangqing">
					<img src="${ctxStatic}/img/1b.jpg"/>
					<img src="${ctxStatic}/img/2b.jpg"/>
					<img src="${ctxStatic}/img/3b.jpg"/>
					<img src="${ctxStatic}/img/4b.jpg"/>
					<img src="${ctxStatic}/img/5b.jpg"/>
					<img src="${ctxStatic}/img/6b.jpg"/>
					<img src="${ctxStatic}/img/7b.jpg"/>
					<img src="${ctxStatic}/img/8b.jpg"/>
					<img src="${ctxStatic}/img/9b.jpg"/>
					<img src="${ctxStatic}/img/10b.jpg"/>
					<img src="${ctxStatic}/img/11b.jpg"/>
					<img src="${ctxStatic}/img/12b.jpg"/>
				</div>
				<div id="leijipinglun" class="baobeixiangqing hide">
					<div class="pinglun-content clearfix">
						<div class="pingjia-left">
							<img src="${ctxStatic}/img/t40.png"/>
							<p>topszk</p>
							<p><img src="${ctxStatic}/img/zuanshi.gif"/></p>
						</div>
						<div class="pingjia-right">
							东西已经在用了，和图片一样，拿到手里沉甸甸的，就是挂的那个勾有点短了感觉，再长一点比较好用，因为男人的手比较大嘛，总体来说挺满意，价格实惠，推荐购买。
							<p>2017年5月20日 10:25:20</p>
						</div>
					</div>
					
					<div class="pinglun-content clearfix">
						<div class="pingjia-left">
							<img src="${ctxStatic}/img/t40.png"/>
							<p>topszk</p>
							<p><img src="${ctxStatic}/img/zuanshi.gif"/></p>
						</div>
						<div class="pingjia-right">
							东西已经在用了，和图片一样，拿到手里沉甸甸的，就是挂的那个勾有点短了感觉，再长一点比较好用，因为男人的手比较大嘛，总体来说挺满意，价格实惠，推荐购买。
							<p>2017年5月20日 10:25:20</p>
						</div>
					</div>
					
					<div class="pinglun-content clearfix">
						<div class="pingjia-left">
							<img src="${ctxStatic}/img/t40.png"/>
							<p>topszk</p>
							<p><img src="${ctxStatic}/img/zuanshi.gif"/></p>
						</div>
						<div class="pingjia-right">
							东西已经在用了，和图片一样，拿到手里沉甸甸的，就是挂的那个勾有点短了感觉，再长一点比较好用，因为男人的手比较大嘛，总体来说挺满意，价格实惠，推荐购买。
							<p>2017年5月20日 10:25:20</p>
						</div>
					</div>
					
					<div class="pinglun-content clearfix">
						<div class="pingjia-left">
							<img src="${ctxStatic}/img/t40.png"/>
							<p>topszk</p>
							<p><img src="${ctxStatic}/img/zuanshi.gif"/></p>
						</div>
						<div class="pingjia-right">
							东西已经在用了，和图片一样，拿到手里沉甸甸的，就是挂的那个勾有点短了感觉，再长一点比较好用，因为男人的手比较大嘛，总体来说挺满意，价格实惠，推荐购买。
							<p>2017年5月20日 10:25:20</p>
						</div>
					</div>
					
					<div class="pinglun-content clearfix">
						<div class="pingjia-left">
							<img src="${ctxStatic}/img/t40.png"/>
							<p>topszk</p>
							<p><img src="${ctxStatic}/img/zuanshi.gif"/></p>
						</div>
						<div class="pingjia-right">
							东西已经在用了，和图片一样，拿到手里沉甸甸的，就是挂的那个勾有点短了感觉，再长一点比较好用，因为男人的手比较大嘛，总体来说挺满意，价格实惠，推荐购买。
							<p>2017年5月20日 10:25:20</p>
						</div>
					</div>
					
					<div class="pinglun-content clearfix">
						<div class="pingjia-left">
							<img src="${ctxStatic}/img/t40.png"/>
							<p>topszk</p>
							<p><img src="${ctxStatic}/img/zuanshi.gif"/></p>
						</div>
						<div class="pingjia-right">
							东西已经在用了，和图片一样，拿到手里沉甸甸的，就是挂的那个勾有点短了感觉，再长一点比较好用，因为男人的手比较大嘛，总体来说挺满意，价格实惠，推荐购买。
							<p>2017年5月20日 10:25:20</p>
						</div>
					</div>
					
					<div class="pinglun-content clearfix">
						<div class="pingjia-left">
							<img src="${ctxStatic}/img/t40.png"/>
							<p>topszk</p>
							<p><img src="${ctxStatic}/img/zuanshi.gif"/></p>
						</div>
						<div class="pingjia-right">
							东西已经在用了，和图片一样，拿到手里沉甸甸的，就是挂的那个勾有点短了感觉，再长一点比较好用，因为男人的手比较大嘛，总体来说挺满意，价格实惠，推荐购买。
							<p>2017年5月20日 10:25:20</p>
						</div>
					</div>
					
					<div class="pinglun-content clearfix">
						<div class="pingjia-left">
							<img src="${ctxStatic}/img/t40.png"/>
							<p>topszk</p>
							<p><img src="${ctxStatic}/img/zuanshi.gif"/></p>
						</div>
						<div class="pingjia-right">
							东西已经在用了，和图片一样，拿到手里沉甸甸的，就是挂的那个勾有点短了感觉，再长一点比较好用，因为男人的手比较大嘛，总体来说挺满意，价格实惠，推荐购买。
							<p>2017年5月20日 10:25:20</p>
						</div>
					</div>
					
					<div class="pinglun-content clearfix">
						<div class="pingjia-left">
							<img src="${ctxStatic}/img/t40.png"/>
							<p>topszk</p>
							<p><img src="${ctxStatic}/img/zuanshi.gif"/></p>
						</div>
						<div class="pingjia-right">
							东西已经在用了，和图片一样，拿到手里沉甸甸的，就是挂的那个勾有点短了感觉，再长一点比较好用，因为男人的手比较大嘛，总体来说挺满意，价格实惠，推荐购买。
							<p>2017年5月20日 10:25:20</p>
						</div>
					</div>
					
					<div class="pinglun-content clearfix">
						<div class="pingjia-left">
							<img src="${ctxStatic}/img/t40.png"/>
							<p>topszk</p>
							<p><img src="${ctxStatic}/img/zuanshi.gif"/></p>
						</div>
						<div class="pingjia-right">
							东西已经在用了，和图片一样，拿到手里沉甸甸的，就是挂的那个勾有点短了感觉，再长一点比较好用，因为男人的手比较大嘛，总体来说挺满意，价格实惠，推荐购买。
							<p>2017年5月20日 10:25:20</p>
						</div>
					</div>
					
					
					<div class="pull-20 bottom-10 text-right">
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
				<div id="xiaoshoujilu" class="baobeixiangqing hide">
					<div class="pinglun-content clearfix">
						<div class="pingjia-left">
							<img src="${ctxStatic}/img/t40.png"/>
							<p>t***k</p>
							<p><img src="${ctxStatic}/img/zuanshi.gif"/></p>
						</div>
						<div class="pingjia-right">
							<p class="jilu">颜色分类：A带开瓶器散装-不能刻字</p>
							<p>2017年5月20日 10:25:20</p>
						</div>
					</div>
					
					<div class="pinglun-content clearfix">
						<div class="pingjia-left">
							<img src="${ctxStatic}/img/t40.png"/>
							<p>t***k</p>
							<p><img src="${ctxStatic}/img/zuanshi.gif"/></p>
						</div>
						<div class="pingjia-right">
							<p class="jilu">颜色分类：A带开瓶器散装-不能刻字</p>
							<p>2017年5月20日 10:25:20</p>
						</div>
					</div>
					
					<div class="pinglun-content clearfix">
						<div class="pingjia-left">
							<img src="${ctxStatic}/img/t40.png"/>
							<p>t***k</p>
							<p><img src="${ctxStatic}/img/zuanshi.gif"/></p>
						</div>
						<div class="pingjia-right">
							<p class="jilu">颜色分类：A带开瓶器散装-不能刻字</p>
							<p>2017年5月20日 10:25:20</p>
						</div>
					</div>
					
					<div class="pinglun-content clearfix">
						<div class="pingjia-left">
							<img src="${ctxStatic}/img/t40.png"/>
							<p>t***k</p>
							<p><img src="${ctxStatic}/img/zuanshi.gif"/></p>
						</div>
						<div class="pingjia-right">
							<p class="jilu">颜色分类：A带开瓶器散装-不能刻字</p>
							<p>2017年5月20日 10:25:20</p>
						</div>
					</div>
					
					<div class="pinglun-content clearfix">
						<div class="pingjia-left">
							<img src="${ctxStatic}/img/t40.png"/>
							<p>t***k</p>
							<p><img src="${ctxStatic}/img/zuanshi.gif"/></p>
						</div>
						<div class="pingjia-right">
							<p class="jilu">颜色分类：A带开瓶器散装-不能刻字</p>
							<p>2017年5月20日 10:25:20</p>
						</div>
					</div>
					
					<div class="pinglun-content clearfix">
						<div class="pingjia-left">
							<img src="${ctxStatic}/img/t40.png"/>
							<p>t***k</p>
							<p><img src="${ctxStatic}/img/zuanshi.gif"/></p>
						</div>
						<div class="pingjia-right">
							<p class="jilu">颜色分类：A带开瓶器散装-不能刻字</p>
							<p>2017年5月20日 10:25:20</p>
						</div>
					</div>
					
					<div class="pinglun-content clearfix">
						<div class="pingjia-left">
							<img src="${ctxStatic}/img/t40.png"/>
							<p>t***k</p>
							<p><img src="${ctxStatic}/img/zuanshi.gif"/></p>
						</div>
						<div class="pingjia-right">
							<p class="jilu">颜色分类：A带开瓶器散装-不能刻字</p>
							<p>2017年5月20日 10:25:20</p>
						</div>
					</div>
					
					<div class="pinglun-content clearfix">
						<div class="pingjia-left">
							<img src="${ctxStatic}/img/t40.png"/>
							<p>t***k</p>
							<p><img src="${ctxStatic}/img/zuanshi.gif"/></p>
						</div>
						<div class="pingjia-right">
							<p class="jilu">颜色分类：A带开瓶器散装-不能刻字</p>
							<p>2017年5月20日 10:25:20</p>
						</div>
					</div>
					
					<div class="pinglun-content clearfix">
						<div class="pingjia-left">
							<img src="${ctxStatic}/img/t40.png"/>
							<p>t***k</p>
							<p><img src="${ctxStatic}/img/zuanshi.gif"/></p>
						</div>
						<div class="pingjia-right">
							<p class="jilu">颜色分类：A带开瓶器散装-不能刻字</p>
							<p>2017年5月20日 10:25:20</p>
						</div>
					</div>
					
					<div class="pinglun-content clearfix">
						<div class="pingjia-left">
							<img src="${ctxStatic}/img/t40.png"/>
							<p>t***k</p>
							<p><img src="${ctxStatic}/img/zuanshi.gif"/></p>
						</div>
						<div class="pingjia-right">
							<p class="jilu">颜色分类：A带开瓶器散装-不能刻字</p>
							<p>2017年5月20日 10:25:20</p>
						</div>
					</div>
					
					
					<div class="pull-20 bottom-10 text-right">
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
				
				var error = '${error}';
				if(error != ''){
					alert(error);
				}
				
				

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

			});
		</script>
	</body>

</html>
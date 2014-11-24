<!doctype html>
<html>
<head>

<title>武汉汇海天下广告有限责任公司</title>
<@d.head/>
</head>
<body>

<!--导入头部导航-->
<@d.top/>
<!--导入头部导航 end-->



	<div id="banner1">
		<img src="picture/case2.jpg" width="1425px" height="238px"/>
	</div>

	<div id="mainbox">
		<!--侧边栏导航 start -->
	<div id="siderbar">
        <div id="sidernav">
            <h2 class="head">真实案例</h2>
   <ul class="list">
	<li>
		<div class="text">
			<h2><a href="/case?type=14">立体发光字工程</a></h2>
		</div>
	</li>
	<li>
		<div class="text">
			<h2><a href="/case?type=15">楼盘包装及工地围栏工程</a></h2>
		</div>
	</li>
	<li>
		<div class="text">
			<h2><a href="/case?type=13">大型广告牌工程</a></h2>
		</div>
	</li>
	<li>
		<div class="text">
			<h2><a href="/case?type=16">外立面灯箱工程</a></h2>
		</div>
	</li>
	<li>
		<div class="text">
			<h2><a href="/case?type=12">导视系统工程</a></h2>
		</div>
	</li>
	<li>
		<div class="text">
			<h2><a href="/case?type=11">标识标牌工程</a></h2>
		</div>
	</li>
</ul>
        </div>
								
        
    </div>
    <!--侧边栏导航 end -->
		
			<div id="content">
			<div class="bread">
				<h3><a href='/'>首页</a> &gt; <a href='/strength'>真实案例</a> &gt; <a href='#'><#if picture_list?size!=0>${picture_list[0].name}</#if></a></h3>
			</div>
		
			<div class="about ydjj">
									<h2><#if picture_list?size!=0>${picture_list[0].name}</#if></h2>

							</div>

<div class="detail_context_pic">
	
	<div class="detail_context_pic_top">
		<a href="#"><img src="" alt="" id="pic1" curindex="0" /></a>
		<a id="preArrow" href="javascript:void(0)" class="contextDiv" title="上一张"><span id="preArrow_A"></span></a>
		<a id="nextArrow" href="javascript:void(0)" class="contextDiv" title="上一张"><span id="nextArrow_A"></span></a> 
		<div id="miaoshuwarp">
			<div class="miaoshu"></div>
		</div>
	</div>
	
	<div class="detail_context_pic_bot">
		<div class="detail_picbot_left"><a href="javascript:void(0)" id="preArrow_B"><img src="images/left1.jpg" alt="上一个" /></a></div>
		<div class="detail_picbot_mid">
			<ul>
			<#if picture_list?size!=0>
		<#list picture_list as picture>
				<li><a href='javascript:void(0);'><img src='${picture.path}' width='90px' height='60px' title='${picture.name}' alt='${picture.name}' bigimg='${picture.path}' text='${picture.name}' /></a></li>
			</#list>
		</#if>		</ul>
		</div>
		<div class="detail_picbot_right"><a href="javascript:void(0)" id="nextArrow_B"><img src="images/right1.jpg" alt="下一个" /></a></div>
	</div>
	
</div>


		
		</div>
		<!-- content结束 -->
		
		<div class="clearfloat"></div>
		
	</div>
	<!-- mainbox结束 -->
	
<!--footer-->
<@d.foot/>
<!--/footer-->
    <script type="text/javascript">
$(window).load(function(){

    $('.flexslider').flexslider({
        animation: "slide",
        controlNav: "thumbnails"
    });
	
});
</script>
</body>
</html>
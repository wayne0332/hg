<!doctype html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="initial-scale=1.0, user-scalable=no" />
<title>武汉汇海天下广告有限责任公司</title>
<link rel="shortcut icon" type="image/x-icon" href="../../../picture/32X32ico.ico" >
<script type="text/javascript" src="js/7d4da6228f2b470cb2eaaa5822c08aad.js"></script>
<script type="text/javascript" src="js/searchinfowindow_min.js"></script>
<script type="text/javascript" src="js/jquery-1.9.1.min.js"></script>
<script type="text/javascript" src="js/slide.js"></script>
<script type="text/javascript" src="js/common.js"></script>
<script type="text/javascript" src="js/jwplayer.js"></script>
<script type="text/javascript" src="js/jquery.flexslider.js"></script>


<link rel="stylesheet" href="css/searchinfowindow_min.css" />
<link type="text/css" href="css/api.css" rel="stylesheet" />

<link type="text/css" href="css/style.css" rel="stylesheet" />  

<link type="text/css" href="css/style_1.css" rel="stylesheet" />


<link href="css/move.css" type="text/css" rel="stylesheet" />
<link type="text/css" rel="stylesheet" href="css/flexslider.css" />
<style type="text/css">
/* ----- Slider ----- */
.flexslider{margin-top:45px;margin-bottom:55px;border:6px solid #fff;-moz-border-radius:0;-webkit-border-radius:0;border-radius:0;-moz-box-shadow:0 5px 15px 0 rgba(0,0,0,.05),0 -5px 15px 0 rgba(0,0,0,.05);-webkit-box-shadow:0 5px 15px 0 rgba(0,0,0,.05),0 -5px 15px 0 rgba(0,0,0,.05);box-shadow:0 5px 15px 0 rgba(0,0,0,.05),0 -5px 15px 0 rgba(0,0,0,.05);}
.flex-caption {position:absolute;bottom:20px;max-width:920px;padding:10px 20px;margin:0;background:#1d1d1d;/* browsers that don't support rgba */background:rgba(0, 0, 0, .7);font-size:14px;line-height:24px;color:#eaeaea;text-align:left;font-style:italic;}
</style>
</head>
<body>

<!--导入头部导航-->
<#include "topbar.ftl">
<!--导入头部导航 end-->



	<div id="banner1">
		<img src="picture/52b160f707f.png" />
	</div>

	<div id="mainbox">
		<!--侧边栏导航 start -->
	<div id="siderbar">
        <div id="sidernav">
            <h2>实力展示</h2>
   <ul class="list">
	<li>
		<div class="text">
			<h2><a  href="/strength?type=1">钣金车间</a></h2>
			<h3>home</h3>
		</div>
	</li>
	<li>
		<div class="text">
			<h2><a href="/strength?type=2">包装车间</a></h2>
			
		</div>
	</li>
	<li>
		<div class="text">
			<h2><a href="/strength?type=3">雕刻车间</a></h2>
		</div>
	</li>
	<li>
		<div class="text">
			<h2><a href="/strength?type=4">吊装车间</a></h2>
			
		</div>
	</li>
	<li>
		<div class="text">
			<h2><a href="/strength?type=5">激光雕刻车间</a></h2>
			
		</div>
	</li>
	<li>
		<div class="text">
			<h2><a href="/strength?type=6">激光切割车间</a></h2>
			
		</div>
	</li>
	<li>
		<div class="text">
			<h2><a href="/strength?type=7">喷印车间</a></h2>
			
		</div>
	</li>
	<li>
		<div class="text">
			<h2><a href="/strength?type=8">制字车间</a></h2>
			
		</div>
	</li>
	<li>
		<div class="text">
			<h2><a href="/strength?type=9">组装车间</a></h2>
			
		</div>
	</li>
	<li>
		<div class="text">
			<h2><a href="/strength?type=10">设计事务所</a></h2>
		</div>
	</li>
</ul>
        </div>
								
        
    </div>
    <!--侧边栏导航 end -->
		
		<div id="content">
			<div class="bread">
				<h3><a href='/'>首页</a> &gt; <a href='/strength'>实力展示</a> &gt; <a href='#'>${picture_list[0].name}</a></h3>
			</div>
		
			<div class="about ydjj">
									<h2>${picture_list[0].name}</h2>

							</div>
							
							<div class="flexslider" >
	<ul class="slides">
		<#list picture_list as picture>
			<li data-thumb="${picture.path}">
			<img src="${picture.path}">
			<p class="flex-caption">${picture.name}</p>
		</li>
		</#list>
	</ul>
</div>
		
		</div>
		<!-- content结束 -->
		
		<div class="clearfloat"></div>
		
	</div>
	<!-- mainbox结束 -->
	
<!--footer-->
<#include "footer.ftl">
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
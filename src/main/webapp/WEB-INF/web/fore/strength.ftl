<!doctype html>
<html>
<head>
<#if i_path=="strength">
 	<#assign t_name = "实力展示">
 </#if>
  <#if i_path=="case">
 	<#assign t_name = "真实案例">
 </#if>

<#assign home = "http://localhost:8080/">
<title>武汉汇海天下广告有限责任公司</title>
<@d.head/>
</head>
<body>

<!--导入头部导航-->
<@d.top/>
<!--导入头部导航 end-->



	<div id="banner1">
			<img src="${home}picture/strength3.jpg" width="1425px" height="238px"/>
	</div>

	<div id="mainbox">
		<!--侧边栏导航 start -->
	<div id="siderbar">
        <div id="sidernav">
            <h2 class="head">${t_name?if_exists}</h2>
   <ul class="list">
 	 <#if picture_bar?exists>
                <#list picture_bar?keys as key> 
   	<li>
		<div class="text">
			<h2><a  href="/img/${i_path?if_exists}?type=${key}">${picture_bar[key]?if_exists}</a></h2>
		</div>
	</li>
                </#list>
            </#if>
</ul>
        </div>
								
        
    </div>
    <!--侧边栏导航 end -->
		
		<div id="content">
			<div class="bread">
				<h3><a href='/'>首页</a> &gt; <a href='/img/${i_path?if_exists}'>${t_name?if_exists}</a> &gt; <a href='#'>${img_name?if_exists}</a></h3>
			</div>
		
			<div class="about ydjj">
									<h2>${img_name?if_exists}</h2>

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
		<div class="detail_picbot_left"><a href="javascript:void(0)" id="preArrow_B"><img src="${home}images/left1.jpg" alt="上一个" /></a></div>
		<div class="detail_picbot_mid">
			<ul>
			<#if picture_list?size!=0>
		<#list picture_list as picture>
				<li><a href='javascript:void(0);'><img src='${home}${picture.path}' width='90px' height='60px' title='${descript_map["${picture.id}"]?if_exists}' alt='${descript_map["${picture.id}"]?if_exists}' bigimg='${home}${picture.path}' text='${descript_map["${picture.id}"]?if_exists}' /></a></li>
			</#list>
		</#if>		</ul>
		</div>
		<div class="detail_picbot_right"><a href="javascript:void(0)" id="nextArrow_B"><img src="${home}images/right1.jpg" alt="下一个" /></a></div>
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
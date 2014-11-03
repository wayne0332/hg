<!doctype html>
<html>
<meta charset="utf-8">
<meta name="viewport" content="initial-scale=1.0, user-scalable=no" />
<title>武汉汇海天下广告有限责任公司</title>

<script type="text/javascript" src="/js/4ce26076e427402e8daf3118ab8b3174.js"></script>
<script type="text/javascript" src="/js/searchinfowindow_min.js"></script>
<script type="text/javascript" src="/js/jquery-1.9.1.min.js"></script>
<script type="text/javascript" src="/js/slide.js"></script>
<script type="text/javascript" src="/js/common.js"></script>
<script type="text/javascript" src="/js/jwplayer.js"></script>
<link rel="shortcut icon" type="image/x-icon" href="../../../picture/32X32ico.ico" >


<link rel="stylesheet" href="/css/searchinfowindow_min.css" />
<link type="text/css" href="/css/api.css" rel="stylesheet" />



<link type="text/css" href="/css/style_1.css" rel="stylesheet" />

<link rel="stylesheet" href="/css/responsiveslides.css">

<link rel="stylesheet" href="/css/style3.css">
<script type="text/javascript" src="/js/responsiveslides.min.js"></script>
<script type="text/javascript">
function autoScroll() {
	var indexScroll = document.getElementById('indexScroll');
	if(indexScroll.scrollTop > indexScroll.scrollHeight*2/8) {
		indexScroll.scrollTop = 0;
	}
	indexScroll.scrollTop++;
}
$(function () {
  // Slideshow 4
  $("#slider4").responsiveSlides({
	auto: false,
	pager: false,
	nav: true,
	speed: 500,
	namespace: "callbacks",
	before: function () {
	  $('.events').append("<li>before event fired.</li>");
	},
	after: function () {
	  $('.events').append("<li>after event fired.</li>");
	}
  });

});
</script>
</script>
   <style>
	#indexScroll { width:468px; height:233px; overflow:hidden; font:14px "微软雅黑";}
	#indexScroll a{color:black;}
	</style>
</head>
<body>
<!--导入头部导航-->
<#include "topbar.ftl">
<!--导入头部导航 end-->

    <!--通栏轮播图-->
     
    <div id="banner">
        <div class="hd"><li></li><li></li><li></li></div>
        <div class="bd">
            <ul>
                                <li>
                    <a href="/activity.php"><img src="picture/54081c9e03a.jpg" /></a>
                </li>
                                <li>
                    <a href="/index.php/52aec02607f"><img src="picture/54081c9e03a.jpg" /></a>
                </li>
                                <li>
                    <a href="/index.php/52b432e507f"><img src="picture/52b947d20a.png" /></a>
                </li>
                                <li>
                    <a href="##"><img src="picture/52b947de0a.png" /></a>
                </li>
                            </ul>
        </div>
    </div>
    
    <!-- 通栏轮播图结束 -->

    <!-- 公司动态等 -->
<div class="sec">
<div class="sectionx">

    <div class="left">
        <h3><span><a href="/aboutus"> more </a></span>公司简介</h3>
			<div id="indexScroll">
                <span>${description.text}</span>
           </div>
        <script>
			var aboutTime = setInterval("autoScroll()",100);
		</script>					
    </div>
        
    <div class="center">
        <h3><span><a href="/strength"> more </a></span>实力展示</h3>
                
    <div class="callbacks_container">
		<ul class="rslides" id="slider4">
		<#if picture_list?size!=0>
			<#list picture_list as picture>
			<li>
				<img src="${picture.path}" alt="${picture.name}" style="height:233px;">
				<p class="caption">${picture.name}</p>
			</li>
		</#list>
		</#if>
		</ul>
	</div>  
                    </div>
					
 
    <div class="clearfloat"></div>
</div>
</div>
<!-- /公司动态等 -->





<!-- 服务客户 -->
<div class="slide-head">
    <h2>服务客户</h2>
    <span><a href="#"> more </a></span>
</div>
<div class="slide-box" style="margin-top:10px;">
    <a class="prev" href="javascript:void(0)"></a>
    <a class="next" href="javascript:void(0)"></a>  
    <div class="bd">
        
                    <ul>
                    
            <#if picture_bag?size!=0>
                    <#list picture_bag as picture_list>
                        <li><#list picture_list as picture>
                                 <#if picture.name?ends_with("logo")>
               						 <img src="${picture.path}" />
                				 </#if>
                				</#list>
                				
                                <div class="mask-box">
                                    <div class="tFocus">
                                        <div class="prev" class="prev"></div>
                                        <div class="next" class="next"></div>
                                        <ul class="tFocus-pic">
                                        <#list picture_list as picture>
                                          	<#if picture.name?ends_with("logo")> <#else>  
                                          	<li> <a href="#"> <img src="${picture.path}" alt="00" /> </a> 
                                          	<div href="#" class="gray_box">${picture.name}</div> </li>
                                             </#if>
                                             </#list>
                                             </ul>
                                             
                                        <div class="tFocusBtn">
                                            <a href="javascript:void(0);" class="prev_ tFocus-leftbtn">上一张</a>
                                            <div class="tFocus-btn">
                                                <ul>
                                                <#list picture_list as picture>
                                         	 	<#if picture.name?ends_with("logo")> <#else>
                                                      <li class="active"><img src="${picture.path}" alt="00" /></li>
                                                            </#if></#list>  </ul>
                                            </div>
                                            <a href="javascript:void(0);" class="next_ tFocus-rightbtn">下一张</a>
                                        </div>

                                    </div>
                                    <div class="close"></div>
                                </div>
                <div class="mask"></div>
            </li>
            </#list>
            </#if>
                   
                                
    </div>
</div>
<!-- /永达案例 -->

<!--footer-->
<#include "footer.ftl">
<!--/footer-->
</body>
</html>
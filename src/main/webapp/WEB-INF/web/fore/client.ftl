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
		<img src="picture/52b160f707f.png" />
	</div>

	<div id="mainbox">
		<!--侧边栏导航 start -->
	<div id="siderbar">
        <div id="sidernav">
            <h2 class="head">关于我们</h2>
   <ul class="list">
	<li>
		<div class="text">
			<h2><a href="/aboutus">公司简介</a></h2>
			<h3>home</h3>
		</div>
	</li>
	<li>
		<div class="text">
			<h2><a href="/client">服务客户</a></h2>
			<h3>contact us</h3>
		</div>
	</li>
</ul>
        </div>
								
        
    </div>
    <!--侧边栏导航 end -->
		
		<div id="content">
			<div class="bread">
				<h3><a href='/'>首页</a> &gt; <a href='/aboutus'>关于我们</a> &gt; <a href='/client'>服务客户</a></h3>
			</div>
		
			<div class="about ydjj">
				<h2>优质客户</h2>
			</div>
			<div class="case cgal">
   				<div class="tablist">
            <div class="muskbg"></div>
                <ul>
         <#if picture_bag?size!=0>
                    <#list picture_bag as picture_list>
                            <li style="margin-right:5px; margin-bottom:5px;">
                            <#list picture_list as picture>
                                 <#if picture.name?ends_with("logo")>
                                  <img style="width:173px;height:108px;border:1px solid #ddd; " src="${picture.path}" />
                				 </#if>
                				</#list>
                            </li>
                            
                            
                            <div class="musk">
                                <span class="bg2"></span>
                                <div class="muskhead">
                                    <a class="close" href="javascript:void(0)"><img src="images/close.png" /></a>
                                </div>
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
                                        <a href="javascript:void(0);" class="prev tFocus-leftbtn">上一张</a>
                                        <div class="tFocus-btn">
                                            <ul>
                                                                                           <#list picture_list as picture>
                                         	 	<#if picture.name?ends_with("logo")> <#else>
                                                      <li class="active"><img src="${picture.path}" alt="00" /></li>
                                                            </#if></#list>  
                                                                                            </ul>
                                        </div>
                                        <a href="javascript:void(0);" class="next tFocus-rightbtn">下一张</a>
                                    </div>

                                </div>
                            <!--tFocus end-->
                            </div>
                            <!-- musk close -->
                                   </#list>
            </#if>
                            </ul>
                            </div>
							</div>
		 <script src="js/tabshow2.js"></script>
		</div>
		<!-- content结束 -->
		
		<div class="clearfloat" ></div>
		
	</div>
	<!-- mainbox结束 -->
<!--footer-->
<@d.foot/>
<!--/footer-->
</body>
</html>
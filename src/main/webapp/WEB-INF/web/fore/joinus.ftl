﻿<!doctype html>
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
            <h2>社会招聘</h2>
   <ul class="list">
   <#if recruit_list?size!=0>
   	<#list recruit_list as recruit>
	<li>
		<div class="text">
			<h2><a href="/joinus?type=${recruit.id}">${recruit.position}</a></h2>
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
				<h3><a href='/index.php/52a97b8a07f'>首页</a> &gt; <a href='/index.php/52aedcc907f'>社会招聘</a> </h3>
				<p>人才招聘</p>
			</div>
		
			<div class="joinus zp_content">
				<h2>${recruit_record.position}<span>招聘人数&nbsp;${recruit_record.requireCount}人</span></h2>
<#if recruit_description?exists>
				<h3>	职位描述：</h3>
<p>
${recruit_description}
</p>
</#if>
<h3>
	任职条件：
</h3>
<p>
${recruit_record.ability}
</p>
<h3>
	待遇：
</h3>
<p>
薪资：${recruit_record.salary}<br/>
</p>
<h3>
	如何申请：
</h3>
<p>
1.将您的个人简历以电子邮箱的形式发送至xxxx@xxxx.com<br />
2.简历投递成功后，我们会尽快与您联系。
</p></h3>
					</div>
			<!-- joinus zp_content close -->
		
		
		</div>
		<!-- content结束 -->
		
		<div class="clearfloat"></div>
		
	</div>
	<!-- mainbox结束 -->
<!--footer-->
<@d.foot/>
<!--/footer-->
</body>
</html>
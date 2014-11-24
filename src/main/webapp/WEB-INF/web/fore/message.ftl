<!doctype html>
<html>
<head>
<title>武汉汇海天下广告有限责任公司</title>
<@d.head/>
<style>
.mes{
margin-top:50px;
}

input:focus,  textarea:focus {
    border: 1px solid #f36e1d;
}
.form-group{
margin:18px;
font-size:18px;
width:715px;
}
.form-control{
padding:5px;
border:1px gray solid;
height:28px;
width:350px;
 border-radius:4px;
}
.form-control2{
 border-radius:4px;
padding:5px;
border:1px gray solid;
height:58px;
width:350px;
}
.button{
cursor: pointer;
border:0px;
 border-radius:4px;
 background:#f36e1d;
 width:80px;
 height:40px;
color:white;
margin-left:230px;
}
label{
margin:2px;
}
</style>
</head>
<body>
<!--导入头部导航-->
<@d.top/>
<!--导入头部导航 end-->



	<div id="banner1">
		<img src="picture/contactus1.jpg" width="1425px" height="238px"/>
	</div>

	<div id="mainbox">
		<!--侧边栏导航 start -->
	<div id="siderbar">
        <div id="sidernav">
            <h2 class="head">联系我们</h2>
   <ul class="list">
	<li>
		<div class="text">
			<h2><a href="/contact">联系方式</a></h2>
			<h3>home</h3>
		</div>
	</li>
	<li>
		<div class="text">
			<h2><a href="/message">留言</a></h2>
			<h3>contact us</h3>
		</div>
	</li>
</ul>
        </div>


    </div>
    <!--侧边栏导航 end -->
		<div id="content">
			<div class="bread">
				<h3><a href='/'>首页</a> &gt; <a href='/contact'>联系我们</a> &gt; <a href='/message'>留言</a></h3>
			</div>

			<div class="about ydjj">
        <h2>留言</h2>
        <div class="mes">
        <form action="/message" method="post">
         <div class="form-group">
 		  <label for="name">您的姓名</label>
   		 <input type="text" name="name"  class="form-control" id="name" >
  		</div>
  		 <div class="form-group">
 		  <label for="email">您的邮件</label>
   		 <input type="email" name="email"  class="form-control" id="email" >
  		</div>
  		 <div class="form-group">
 		  <label for="phone">联系电话</label>
   		 <input type="text" name="phone"  class="form-control" id="phone"  >
  		</div>
  		 <div class="form-group">
 		  <label for="content">您的留言</label>
 		  <textarea name="content" rows="20" cols="100" class="form-control2"></textarea>
  		</div>
            <input type="submit" class="button" value="提交" />
        </form>
        </div>
							</div>

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
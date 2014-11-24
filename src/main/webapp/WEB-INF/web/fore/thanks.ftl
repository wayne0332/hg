<!doctype html>
<html>
<head>
    <title>武汉汇海天下广告有限责任公司</title>
<@d.head/>
    <script type="text/javascript" src="http://api.map.baidu.com/api?v=2.0&ak=VuTyZfAGQ01vwbpL7gALtH8B"></script>
    </script>
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
            <h2>${name} 感谢您的留言,我们会尽快联系您。</h2>
            <h3 style="white-space:normal;">
    </div>

    </div>
        <!-- content结束 -->

    <div class="clearfloat" ></div>

    </div>
        <!-- mainbox结束 -->
        <!--footer-->
    <@d.foot/>
        <!--/footer-->

    <script type="text/javascript">
    // 百度地图API功能
    var map = new BMap.Map("allmap");
    var point = new BMap.Point(114.305503,30.554765);
    var marker = new BMap.Marker(point);  // 创建标注
    map.addOverlay(marker);              // 将标注添加到地图中
    map.centerAndZoom(point, 15);
    var opts = {
        width : 200,     // 信息窗口宽度
        height: 100,     // 信息窗口高度
        title : "武汉汇海天下广告有限公司" , // 信息窗口标题
        enableMessage:true,//设置允许信息窗发送短息
        message:"武汉汇海天下广告有限公司"
    }
    var infoWindow = new BMap.InfoWindow("地址：武汉市武昌区临江大道60号", opts);  // 创建信息窗口对象
    map.openInfoWindow(infoWindow,point); //开启信息窗口
    marker.addEventListener("click", function(){
        map.openInfoWindow(infoWindow,point); //开启信息窗口
    });
    map.addControl(new BMap.NavigationControl({type:BMAP_NAVIGATION_CONTROL_ZOOM}));
    </script>
    </body>
</html>
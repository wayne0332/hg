<!DOCTYPE html>
<html>
<meta charset="utf-8">
<meta name="viewport" content="initial-scale=1.0, user-scalable=no" />
<head>
    <title>实力展示</title>
    <#assign
 ctx=request.contextPath>
    <style>
    	.ui_btn_1{
    	font-size:15px;
    	color:white;
    	width:170px;
    	height:40px;
    	background-color:#0099FF;
    	border:0px;
    	}
    	
    	.ui_inp_1{
    	font-size:15px;
    	color:black;
    	width:170px;
    	height:40px;
    	border:1px solid #0099FF;
    	text-align:center;
    	}
    	
    	.btn_bianji{
    	background-color:#00FF99;
    	}
    	.btn_delete{
    	background-color:#CCFF00;
    	}
    	img{
    	margin:7px;border:solid 0px #666666;
    	}
    	
    	#leibie_ul div{
    	margin-top:-9px;
    	position:relative;
    	width:170px;
    	height:40px;
    	}
    	
    	#leibie_ul li{
    	height:60px;
    	}
    	
    	
    	.ul_delete{
    	width:20px;
    	height:20px;
    	position:absolute;
    	top:-17px;
    	left:151px;
    	cursor:pointer;
    	}
    	 .ul_save{
    	width:17px;
    	height:17px;
    	position:absolute;
    	top:-17px;
    	left:-15px;
    	cursor:pointer;
    	}
    </style>
</head>
<body>
<div class="col-md-10">
    <div class="row">
        <div class="col-lg-12">
            <div class="page-header bootstrap-admin-content-title">
                <h1>实力展示</h1>
            </div>
        </div>
    </div>
    <div class="row">
        <div class="col-lg-12">
            <div class="panel panel-info">
                <div class="bootstrap-admin-panel-content">
                			
                			<div class="container">
	<div class="row clearfix">
		<div class="col-md-2 column" style="position:relative;">
			<h3 class="muted">
				部门类别
			</h3>
			</br>
			<ul class="list-unstyled" id="leibie_ul">
			<#list picture_bar as bar>
			<li>
					<p>
 						 <button type="button" class="ui_btn_1" onclick="window.location('/manager/strength?type=${bar.type}');">${bar.name}</button>
 						 <div>
 						 <input type="text" value="${bar.name}" class="ui_inp_1">
 						 <img src="http://localhost:8080/picture/delete.png"  class="ul_delete">
 						 <img src="http://localhost:8080/picture/save.png" class="ul_save">
 						 </div>
					</p>
				</li>
			</#list>
				<li>
					<p>
 						 <button type="button" class="ui_btn_1">包装车间</button>
 						 <div>
 						 <input type="text" value="包装车间" class="ui_inp_1">
 						 <img src="http://localhost:8080/picture/delete.png"  class="ul_delete">
 						 <img src="http://localhost:8080/picture/save.png" class="ul_save">
 						 </div>
					</p>
				</li>
			</ul> 
			<button id="edit_btn" type="button" class="ui_btn_1 btn_bianji" style="top:726px;position:absolute;" onclick="editall();">编辑</button>
			<button id="save_btn" type="button" class="ui_btn_1 btn_bianji" style="top:726px;position:absolute;" onclick="save();">保存</button>
		</div>
			<h3 class="muted">
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;图片
			</h3>
			</br>
		<div class="col-md-7 column " style="border:0.1px solid #00CC99;height:730px;margin-left:40px;">
			<div class="row clearfix">
				<div class="col-md-12 column">
					<#if picture_list?size!=0>
					<#list picture_list as picture>
						<img id="${picture.id}" onclick="chose_img('${picture.id}')" alt="${request.contextPath}" src="http://localhost:8080/${picture.path}"  width="200px" height="150px"/>
					</#list>
					</#if>
				</div>
			</div>
			<div class="row clearfix"  style="bottom:20px;position:absolute;left:150px;">
				<div class="col-md-6 column" style="text-align:center;">
					 <button type="button" class="ui_btn_1 btn_bianji">上传图片</button>
				</div>
				<div class="col-md-6 column" style="text-align:center;">
					 <button type="button" class="ui_btn_1 btn_delete">删除</button>
				</div>
			</div>
		</div>
	</div>
	<div class="row clearfix">
		<div class="col-md-12 column">
			<h3>
				提示
			</h3>
			<h4>类别最多不超过10个，每个类别下图片不超过10张。</h4>
		</div>
	</div>
</div>
                			
                </div>
            </div>
        </div>
    </div>
</div>
<script type="text/javascript" src="/js/jquery-1.9.1.min.js"></script>
<script type="text/javascript" src="/js/bootstrap.min.js"></script>
<script>
$(document).ready(function(){
  $("#leibie_ul div").hide();
  $("#save_btn").hide();
});
 function chose_img(id)
 {
 	if($("#"+id).css("borderTopWidth")=="0px"){
 	 	$("#"+id).css("border","3px solid #0099FF");
 	}else{
 		$("#"+id).css("border","0px solid #0099FF")
 	}
 }
 
 function editall(){
  $("#leibie_ul button").hide();
    $("#leibie_ul div").show();
      $("#save_btn").show();
        $("#edit_btn").hide();
 }
 
 function save(){
   $("#leibie_ul div").hide();
    $("#leibie_ul button").show();
      $("#save_btn").hide();
        $("#edit_btn").show();
    
 }
</script>
</body>
</html>

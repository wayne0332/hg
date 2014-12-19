<!DOCTYPE html>
<html>
<meta charset="utf-8">
<meta name="viewport" content="initial-scale=1.0, user-scalable=no" />
<head>
 <#if t_path=="strength">
 	<#assign t_name = "实力展示">
 </#if>
  <#if t_path=="case">
 	<#assign t_name = "真实案例">
 </#if>
    <title>汇海天下-${t_name?if_exists}</title>
    <#assign
 ctx=request.contextPath>

 
</head>
<body>
<div class="col-md-10">
    <div class="row">
        <div class="col-lg-12">
            <div class="page-header bootstrap-admin-content-title">
                <h1>${t_name?if_exists}</h1>
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
				栏目类别
			</h3>
			</br>
			<ul class="list-unstyled" id="leibie_ul">
			 <#if picture_bar?exists>
                <#list picture_bar?keys as key> 
                	<li>
					<p>
 						 <button type="button" class="ui_btn_1" onclick="window.location('/manager/img/${t_path?if_exists}?type=${key}');">${picture_bar[key]?if_exists}</button>
 						 <div>
 						 <input type="text" value="${picture_bar[key]?if_exists}" class="ui_inp_1" id="${key}">
 						 <img src="http://localhost:8080/picture/delete.png"  class="ul_delete" onclick="strength_delete('${key}')">
 						 <img src="http://localhost:8080/picture/save.png" class="ul_save" onclick="strength_save('${key}')">
 						 </div>
					</p>
				</li>
                </#list>
            </#if>
               <li>
					<p>
 						 <div>
 						 <input id="add_input"  type="text"  class="ui_inp_1"   placeholder="添加部门">
 						 <img src="http://localhost:8080/picture/save.png" class="ul_save" onclick="strength_add()">
 						 </div>
					</p>
				</li>
			</ul> 
			<button id="edit_btn" type="button" class="ui_btn_1 btn_bianji" style="top:726px;position:absolute;" onclick="editall();">编辑</button>
			<button id="save_btn" type="button" class="ui_btn_1 btn_bianji" style="left:15px;top:726px;position:absolute;" onclick="save();">保存</button>
		</div>
			<h3 class="muted">
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${img_name?if_exists}
			</h3>
			</br>
		<div class="col-md-7 column " style="border:0.1px solid #00CC99;height:730px;margin-left:40px;">
			<div class="row clearfix">
				<div class="col-md-12 column">
					<#if picture_list?size!=0>
					<#list picture_list as picture>
					<div style="float:left;">
						<img id="${picture.id}" onclick="chose_img('${picture.id}','${picture.descriptionId?if_exists}','${picture.type?if_exists}')"  src="http://localhost:8080/${picture.path}"  width="203px" height="150px" />
						<div style="width:100%;text-align:center;"><input type="checkbox" name="dimg" value="${picture.id}" ></div>
						<input type="hidden" id="${picture.id}_des"  value="${descript_map["${picture.id}"]?if_exists}">
						<input type="hidden" id="${picture.id}_desid"  value="${picture.descriptionId?if_exists}">
						</div>
					</#list>
					</#if>
				</div>
			</div>
			
			<div class="row clearfix"  style="bottom:68px;position:absolute;left:80px;">
			 &nbsp;&nbsp;&nbsp;&nbsp;图片描述:	
				<div class="col-md-12 column" >
					 <input id="apply"  type="text" contenteditable="true"  style="width:400px;float:left;margin-right:10px;height:30px;margin-top:2px;" onkeydown="change();">
					 <button id="btn_update"  type="button" class="btn btn-default" onclick="update_des();" disabled="true">修改描述</button>
					 <input type="hidden" value="" id="update_des_id">
					 <input type="hidden" value="" id="update_pic_id">
					 <input type="hidden" value="" id="update_str_type">
				</div>
			</div>
			
			<div class="row clearfix"  style="bottom:20px;position:absolute;left:150px;">
				<div class="col-md-6 column" style="text-align:center;">
					 <button type="button" class="ui_btn_1 btn_bianji" onclick="javascript:$('#img_file').click();">上传图片</button>
				</div>
				<div class="col-md-6 column" style="text-align:center;">
					 <button type="button" class="ui_btn_1 btn_delete" onclick="delete_img();">删除</button>
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
<form action="/manager/upload_img?type=${t_path?if_exists}"  method="POST"  enctype="multipart/form-data">
<input type="file" style="display:none" onchange="upload()" id="img_file" name="file">
<input type="hidden" value="${img_key?if_exists}" name="pic_type">
</form>
<script type="text/javascript" src="/js/jquery-1.9.1.min.js"></script>
<script type="text/javascript" src="/js/bootstrap.min.js"></script>
<script>
$(document).ready(function(){
  $("#leibie_ul div").hide();
  $("#save_btn").hide();
  $("#add_input").hide();
});
 function chose_img(id,des_id,type)
 {
 	$("#btn_update").attr("disabled","disabled");
 	$("#apply").val($("#"+id+"_des").val());
 	$("#update_des_id").val(des_id);
 	$("#update_pic_id").val(id);
 	$("#update_str_type").val(type);
 	$("img").css("border","0px solid #0099FF")
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
      $("#add_input").show();
        $("#edit_btn").hide();
 }
 
 function save(){
   $("#leibie_ul div").hide();
    $("#leibie_ul button").show();
      $("#save_btn").hide();
      $("#add_input").hide();
        $("#edit_btn").show();
        window.location("/manager/img/${t_path?if_exists}");
 }
 function update_des(){
 if($("#update_pic_id").val()==""){
 	alert("请选择图片！");
 	return false;
 }
 if($("#apply").val().trim()==""){
  	alert("请输入描述信息！");
 	return false;
 }
  	$.ajax({
 	url:"/manager/update_description",
 	type:"post",
 	data:{"id":$("#update_pic_id").val(),"des_id":$("#update_des_id").val(),"content":$("#apply").val()},
 	success:function(data){
 		alert(data);
 		window.location("/manager/img/${t_path?if_exists}?type=<#if picture_list?size!=0>${picture_list[0].groupId?if_exists}</#if>");
 	}
 	});
 }
 function change(){
	$("#btn_update").attr("disabled",false);
 }
 function delete_img(){
 	      var str="";
            $("input[name='dimg']").each(function(){ 
             if($(this).is(":checked")){
                    str += $(this).val()+","
                }
            });
          if(str==""){
          alert("请选择图片！");
          return false;
          }
  if(confirm("确定删除？")){
    $.ajax({
 	url:"/manager/delete_img",
 	type:"post",
 	data:{"id":str},
 	success:function(data){
 		alert(data);
 		window.location("/manager/img/${t_path?if_exists}?type=${img_key}");
 	}
 	});
 	}
 }
 function upload(){
		$("form").submit();
 }
 
   function strength_delete(id){
		 if(confirm("确定删除？")){
  			$.ajax({
 			url:"/manager/strength_update",
 			type:"post",
		 	data:{"id":id},
 			success:function(data){
 				alert(data);
 				save();
 		}
 		});
	 	}
	 }
 
  function strength_save(id){
	if($("#"+id).val().trim().length==0){
	alert("名称不能为空！");
	return false;
	}
 	$.ajax({
 	url:"/manager/strength_update",
 	type:"post",
 	data:{"id":id,"value":$("#"+id).val()},
 	success:function(data){
 		alert(data);
 		save();
 	}
 	});
 }
 
 function strength_add(){
 if($("#add_input").val().trim().length==0){
 	alert("名称不能为空！");
 	return false;
 }
  	$.ajax({
 	url:"/manager/img_add/${t_path?if_exists}",
 	type:"post",
 	data:{"name":$("#add_input").val()},
 	success:function(data){
 		alert(data);
 		save();
 	}
 	});
 }

</script>
</body>
</html>

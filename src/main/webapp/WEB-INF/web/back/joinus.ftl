<!DOCTYPE html>
<html>
<#import "/spring.ftl" as spring/>  
<meta charset="utf-8">
<meta name="viewport" content="initial-scale=1.0, user-scalable=no" />
<head>
    <title>汇海天下-社会招聘</title>
    <#assign
 ctx=request.contextPath>
</head>
<body>
<div class="col-md-10">
    <div class="row">
        <div class="col-lg-12">
            <div class="page-header bootstrap-admin-content-title">
                <h1>社会招聘</h1>
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
				职位名称
			</h3>
			</br>
			<ul class="list-unstyled" id="leibie_ul">
			<#list  recruit_list as recruit>
			<li>
					<p>
 						 <button type="button" class="ui_btn_1" onclick="window.location('/manager/joinus?type=${recruit.id?if_exists}');" >${recruit.position?if_exists}</button>
 						 <input type="text" value="${recruit.id?if_exists}"   name="id" style="display:none;">
 						 <div>
 						 <input type="text" value="${recruit.position?if_exists}" class="ui_inp_1" name="position" id="${recruit.id?if_exists}">
 						 <img src="http://localhost:8080/picture/delete.png"  class="ul_delete" onclick="position_delete('${recruit.id?if_exists}')">
 						 <img src="http://localhost:8080/picture/save.png" class="ul_save" onclick="position_save('${recruit.id?if_exists}')">
 						 </div>
					</p>
				</li>
			</#list>
			</ul> 
			<button id="edit_btn" type="button" class="ui_btn_1 btn_bianji" style="margin-top:50px;" onclick="editall();">编辑</button>
			<button id="add_btn" type="button" class="ui_btn_1 btn_bianji" style="margin-top:50px;" onclick="add();">新增</button>
			<button id="save_btn" type="button" class="ui_btn_1 btn_bianji" style="margin-top:10px;" onclick="save();">保存</button>
		</div>
			<h3 class="muted">
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${recruitRecord.position?if_exists}
			</h3>
			</br>
		<div class="col-md-7 column " style="margin-left:40px;border-left:0.1px solid #00CC99">
			<div class="row clearfix">
				<div class="col-md-12 column">
					<!--表单-->
					<br>
					<form action="/manager/joinus_update" method="post"  class="form-horizontal" role="form" >
					   	<input type="hidden"   name="id" value="${recruitRecord.id?if_exists}">
					   	<input type="hidden"   name="position" value="${recruitRecord.position?if_exists}">
					   	<input type="hidden"   name="descriptionId" value="${recruitRecord.descriptionId?if_exists}">
						 <div class="form-group">
    						<label for="require_count" class="col-sm-2 control-label">招聘人数</label>
  						  <div class="col-sm-10">
     						 <input type="text" class="form-control" id="require_count" name="require_count" value="${recruitRecord.requireCount?if_exists}">
     						  	<@spring.bind "recruitRecord.requireCount" />
								<font style="color:red;"><#list spring.status.errorMessages as error> ${error} 
								</#list></font>
   							 </div></div>
   							 
 						 <div class="form-group">
    						<label for="description_content" class="col-sm-2 control-label">职位描述</label>
  						  <div class="col-sm-10">
     						 <textarea id="description_content" contenteditable="true" name="descriptionContent">${recruit_description?if_exists}</textarea>
     						 <@spring.bind "recruitRecord.descriptionId" />
								<font style="color:red;"><#list spring.status.errorMessages as error> ${error} 
								</#list></font>
   							 </div></div>
   							 
 						 <div class="form-group">
    						<label for="ability" class="col-sm-2 control-label">任职条件</label>
  						  <div class="col-sm-10">
     						 <textarea id="ability" contenteditable="true" name="ability">${recruitRecord.ability?if_exists}</textarea>
     						 <@spring.bind "recruitRecord.ability" />
								<font style="color:red;"><#list spring.status.errorMessages as error> ${error} 
								</#list></font>
   							 </div></div>
   							 
   							 <div class="form-group">
    						<label for="salary" class="col-sm-2 control-label">待遇</label>
  							  <div class="col-sm-10">
     							 <input type="text" class="form-control" id="salary" name="salary" value="${recruitRecord.salary?if_exists}">
   							 </div></div>
   							 
   							 <div class="form-group">
    						<label for="apply" class="col-sm-2 control-label">如何申请</label>
  							  <div class="col-sm-10">
     							 	 <textarea id="apply" contenteditable="true" name="apply">${recruitRecord.apply?if_exists}</textarea>
   							 </div></div>
   							 
					</form>
				</div>
			</div>
			<div class="row clearfix"  style="margin-top:50px;">
				<div class="col-md-12 column" style="text-align:center;">
					 <button type="button" class="ui_btn_1 btn_bianji" onclick="position_update()">确认修改</button>
				</div>
			</div>
		</div>
	</div>
	<div class="row clearfix">
		<div class="col-md-12 column">
			<h3>
				提示
			</h3>
			<h4>社会招聘提示。</h4>
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
<script type="text/javascript" src="/js/twitter-bootstrap-hover-dropdown.min.js"></script>
<script type="text/javascript" src="/js/bootstrap-admin-theme-change-size.js"></script>

<script src="/ckeditor/ckeditor.js"></script>
<script src="/ckeditor/adapters/jquery.js"></script>

<script type="text/javascript">
    CKEDITOR.disableAutoInline = false;

    $(document).ready(function () {
              $("#leibie_ul div").hide();
  			$("#save_btn").hide();
  			$("#add_btn").hide();
        $('textarea').ckeditor();
    });
    CKEDITOR.inline('description_content');
    CKEDITOR.inline('ability');
    CKEDITOR.inline('apply');
</script>
<script>
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
       $("#add_btn").show();
        $("#edit_btn").hide();
 }
 
 function save(){
   $("#leibie_ul div").hide();
    $("#leibie_ul button").show();
      $("#save_btn").hide();
        $("#add_btn").hide();
        $("#edit_btn").show();
        	window.location("/manager/joinus");
 }
 function position_save(id){
 	$.ajax({
 	url:"/manager/joinus_position",
 	type:"post",
 	data:{"id":id,"position":$("#"+id).val()},
 	success:function(data){
 		alert(data);
 		save();
 	}
 	});
 }
 function add(){
 	window.location("/manager/joinus_add");
 }
 function position_delete(id){
 if(confirm("确定删除？")){
  	$.ajax({
 	url:"/manager/joinus_delete",
 	type:"post",
 	data:{"id":id,"position":$("#"+id).val()},
 	success:function(data){
 		alert(data);
 		save();
 	}
 	});
 	}
 }
 function position_update(){
 	$("form").submit();
 }
</script>
</body>
</html>

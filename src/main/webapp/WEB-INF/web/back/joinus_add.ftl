<!DOCTYPE html>
<html>
<#import "/spring.ftl" as spring/>  
<meta charset="utf-8">
<meta name="viewport" content="initial-scale=1.0, user-scalable=no" />
<head>
    <title>汇海天下-社会招聘-新增</title>
    <#assign
 ctx=request.contextPath>
</head>
<body>
<form action="/manager/joinus_add" method="post" class="form-horizontal" role="form">
<div class="col-md-10">
    <div class="row">
        <div class="col-lg-12">
            <div class="page-header bootstrap-admin-content-title">
                <h1>社会招聘-新增</h1>
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
			<li>
					<p>
					</br>
					</br>
 						 <input type="text"   class="ui_inp_1" name="position"  value="${(recruitRecord.position)?if_exists}" placeholder="职位名称">
 						 <@spring.bind "recruitRecord.position" />
								<font style="color:red;"><#list spring.status.errorMessages as error> ${error} 
							</#list></font>
					</p>
				</li>
			</ul> 
		</div>
			<h3 class="muted">
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;职位详细
			</h3>
			</br>
		<div class="col-md-7 column " style="border-left:0.1px solid #00CC99;height:530px;margin-left:40px;">
			<div class="row clearfix">
				<div class="col-md-12 column">
					<!--表单-->
					<br>
						 <div class="form-group">
    						<label for="require_count" class="col-sm-2 control-label">*招聘人数</label>
  						  <div class="col-sm-10">
     						 <input type="text" class="form-control" id="require_count" name="require_count"  value="${(recruitRecord.requireCount)?if_exists}" >
     						 	<@spring.bind "recruitRecord.requireCount" />
								<font style="color:red;"><#list spring.status.errorMessages as error> ${error} 
								</#list></font>
   							 </div></div>
   							 
 						 <div class="form-group">
    						<label for="description_content" class="col-sm-2 control-label">*职位描述</label>
  						  <div class="col-sm-10">
     						 <textarea id="description_content" contenteditable="true" name="descriptionContent">${(descriptionContent)?if_exists} </textarea>
     						 <@spring.bind "recruitRecord.descriptionId" />
								<font style="color:red;"><#list spring.status.errorMessages as error> ${error} 
								</#list></font>
   							 </div></div>
   							 
 						 <div class="form-group">
    						<label for="ability" class="col-sm-2 control-label">*任职条件</label>
  						  <div class="col-sm-10">
     						 <textarea id="ability" contenteditable="true" name="ability">${(recruitRecord.ability)?if_exists} </textarea>
     						 <@spring.bind "recruitRecord.ability" />
								<font style="color:red;"><#list spring.status.errorMessages as error> ${error} 
								</#list></font>
   							 </div></div>
   							 
   							 <div class="form-group">
    						<label for="salary" class="col-sm-2 control-label">待遇</label>
  							  <div class="col-sm-10">
     							 <input type="text" class="form-control" id="salary" name="salary" value="${(recruitRecord.salary)?if_exists}" >
   							 </div></div>
   							 
   							 <div class="form-group">
    						<label for="apply" class="col-sm-2 control-label">如何申请</label>
  							  <div class="col-sm-10">
     							<textarea id="apply" contenteditable="true" name="apply">${recruitRecord.apply?if_exists}</textarea>
   							 </div></div>
   							 
				</div>
			</div>
			<div class="row clearfix"  style="margin-top:50px;">
				<div class="col-md-12 column" style="text-align:center;">
					 <button type="button" class="ui_btn_1 btn_bianji"  onclick="add();">确认添加</button>
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
</form>
<script type="text/javascript" src="/js/jquery-1.9.1.min.js"></script>
<script type="text/javascript" src="/js/bootstrap.min.js"></script>
<script type="text/javascript" src="/js/twitter-bootstrap-hover-dropdown.min.js"></script>
<script type="text/javascript" src="/js/bootstrap-admin-theme-change-size.js"></script>

<script src="/ckeditor/ckeditor.js"></script>
<script src="/ckeditor/adapters/jquery.js"></script>

<script type="text/javascript">
    CKEDITOR.disableAutoInline = false;

    $(document).ready(function () {
   		 $("#count_error").hide();
        $('textarea').ckeditor();
    });
    CKEDITOR.inline('description_content');
    CKEDITOR.inline('ability');
    CKEDITOR.inline('apply');
</script>
<script>
 function add(){
 $("form").submit();
 }
</script>
</body>
</html>

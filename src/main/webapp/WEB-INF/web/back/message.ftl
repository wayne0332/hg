<!DOCTYPE html>
<html>
<head>
    <title>留言</title>
</head>
<body>
<div class="col-md-10">
    <div class="row">
        <div class="col-lg-12">
            <div class="page-header bootstrap-admin-content-title">
                <h1>留言</h1>
            </div>
        </div>
    </div>
    <div class="row">
        <div class="col-lg-12">
            <div class="panel panel-info">
                <div class="bootstrap-admin-panel-content">
                    
							<table class="table table-hover">
									<tr class="active">
									<td>姓名</td>
									<td>Email</td>
									<td>电话</td>
									<td>留言</td>
									<td>日期</td>
									</tr>
									<#list message_list as message>
										<tr>
										<td>${message.name?if_exists}</td>
										<td>${message.email?if_exists}</td>
										<td>${message.phone?if_exists}</td>
										<td>${message.content?if_exists}</td>
										<td>${message.timeStamp?if_exists?string("yyyy-MM-dd HH:mm:ss")}</td>
										</tr>
									</#list>
							</table>

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
        $('textarea#text').ckeditor();
    });
    CKEDITOR.inline('text');
</script>
</body>
</html>

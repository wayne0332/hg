<!DOCTYPE html>
<html>
<head>
    <title>简介</title>
</head>
<body>
<div class="col-md-10">
    <div class="row">
        <div class="col-lg-12">
            <div class="page-header bootstrap-admin-content-title">
                <h1>公司简介</h1>
            </div>
        </div>
    </div>
    <div class="row">
        <div class="col-lg-12">
            <div class="panel panel-info">
                <div class="bootstrap-admin-panel-content">
                    <textarea id="text" contenteditable="true">${description.text}</textarea>
                </div>
            </div>
        </div>
    </div>
</div>
<script type="text/javascript" src="http://code.jquery.com/jquery-2.0.3.min.js"></script>
<script type="text/javascript" src="/js/bootstrap.min.js"></script>
<script type="text/javascript" src="/js/twitter-bootstrap-hover-dropdown.min.js"></script>
<script type="text/javascript" src="/js/bootstrap-admin-theme-change-size.js"></script>

<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
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

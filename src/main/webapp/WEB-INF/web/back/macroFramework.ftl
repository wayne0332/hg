<#macro appendBody body>
    <@navbar/>
    <@leftSide body=body/>
</#macro>
<#macro navbar>
<nav class="navbar navbar-default navbar-fixed-top bootstrap-admin-navbar" role="navigation">
    <div class="container">
        <div class="row">
            <div class="col-lg-12">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle" data-toggle="collapse"
                            data-target=".main-navbar-collapse">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <span class="navbar-brand">汇海天下</span>
                </div>
                <#--<div class="collapse navbar-collapse main-navbar-collapse">-->
                    <#--<ul class="nav navbar-nav">-->
                        <#--<li class="active"><a href="#">Link</a></li>-->
                        <#--<li><a href="#">Link</a></li>-->
                        <#--<li class="dropdown">-->
                            <#--<a href="#" class="dropdown-toggle" data-hover="dropdown">Dropdown <b class="caret"></b></a>-->
                            <#--<ul class="dropdown-menu">-->
                                <#--<li role="presentation" class="dropdown-header">Dropdown header</li>-->
                                <#--<li><a href="#">Action</a></li>-->
                                <#--<li><a href="#">Another action</a></li>-->
                                <#--<li><a href="#">Something else here</a></li>-->
                                <#--<li role="presentation" class="divider"></li>-->
                                <#--<li role="presentation" class="dropdown-header">Dropdown header</li>-->
                                <#--<li><a href="#">Separated link</a></li>-->
                                <#--<li><a href="#">One more separated link</a></li>-->
                            <#--</ul>-->
                        <#--</li>-->
                    <#--</ul>-->

                    <ul class="nav navbar-nav navbar-right">
                        <li class="dropdown">
                            <a href="#" role="button" class="dropdown-toggle" data-hover="dropdown"> <i
                                    class="glyphicon glyphicon-user"></i> ${manager.name} <i class="caret"></i></a>
                            <ul class="dropdown-menu">
                                <li><a href="#">修改密码</a></li>
                                <li><a href="#">其他账号</a></li>
                                <li role="presentation" class="divider"></li>
                                <li><a href="index.html">注销</a></li>
                            </ul>
                        </li>
                    </ul>
                </div>
                <!-- /.navbar-collapse -->
            </div>
        </div>
    </div>
    <!-- /.container -->
</nav>
</#macro>
<#macro leftSide body>
<!-- main / large navbar -->
<div class="container">
    <!-- left, vertical navbar & content -->
    <div class="row">
        <!-- left, vertical navbar -->
        <div class="col-md-2 bootstrap-admin-col-left">
            <ul class="nav navbar-collapse collapse bootstrap-admin-navbar-side">
                <li class="active">
                    <a href="/manager/aboutUs"><i class="glyphicon glyphicon-chevron-right"></i>简介</a>
                </li>
                <li>
                    <a href="/manager/strength"><i class="glyphicon glyphicon-chevron-right"></i> 实力展示 </a>
                </li>
               <li>
                    <a href="/manager/joinus"><i class="glyphicon glyphicon-chevron-right"></i> 社会招聘 </a>
                </li>
              <li>
                    <a href="/manager/message"><i class="glyphicon glyphicon-chevron-right"></i> 留言管理 </a>
                </li>
                <li class="disabled">
                    <a href="#"><i class="glyphicon glyphicon-chevron-right"></i> Calendar</a><!-- calendar.html -->
                </li>
                <li class="disabled">
                    <a href="#"><i class="glyphicon glyphicon-chevron-right"></i> Statistics (Charts)</a><!-- stats.html -->
                </li>
                <li>
                    <a href="forms.html"><i class="glyphicon glyphicon-chevron-right"></i> Forms</a>
                </li>
                <li>
                    <a href="tables.html"><i class="glyphicon glyphicon-chevron-right"></i> Tables</a>
                </li>
                <li>
                    <a href="buttons-and-icons.html"><i class="glyphicon glyphicon-chevron-right"></i> Buttons &amp;
                        Icons</a>
                </li>
                <li>
                    <a href="edit"><i class="glyphicon glyphicon-chevron-right"></i> WYSIWYG Editors</a>
                </li>
                <li>
                    <a href="ui-and-interface.html"><i class="glyphicon glyphicon-chevron-right"></i> UI &amp; Interface</a>
                </li>
                <li>
                    <a href="error-pages.html"><i class="glyphicon glyphicon-chevron-right"></i> Error pages</a>
                </li>
                <li>
                    <a href="#"><span class="badge pull-right">731</span> Orders</a>
                </li>
                <li>
                    <a href="#"><span class="badge pull-right">812</span> Invoices</a>
                </li>
                <li>
                    <a href="#"><span class="badge pull-right">27</span> Clients</a>
                </li>
                <li>
                    <a href="#"><span class="badge pull-right">1,234</span> Users</a>
                </li>
                <li>
                    <a href="#"><span class="badge pull-right">2,221</span> Messages</a>
                </li>
                <li>
                    <a href="#"><span class="badge pull-right">11</span> Reports</a>
                </li>
                <li>
                    <a href="#"><span class="badge pull-right">83</span> Errors</a>
                </li>
                <li>
                    <a href="#"><span class="badge pull-right">4,231</span> Logs</a>
                </li>
            </ul>
        </div>

        <!-- content -->
    ${body}
    </div>
</div>
</#macro>
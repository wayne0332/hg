<!DOCTYPE html>
<html class="bootstrap-admin-vertical-centered">
    <head>
        <title>后台登陆</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">

        <!-- Bootstrap -->
        <link rel="stylesheet" media="screen" href="/css/bootstrap.min.css">
        <link rel="stylesheet" media="screen" href="/css/bootstrap-theme.min.css">

        <!-- Bootstrap Admin Theme -->
        <link rel="stylesheet" media="screen" href="/css/bootstrap-admin-theme.css">

        <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
        <!--[if lt IE 9]>
           <script type="text/javascript" src="/js/html5shiv.js"></script>
           <script type="text/javascript" src="/js/respond.min.js"></script>
        <![endif]-->
    </head>
    <body class="bootstrap-admin-without-padding">
        <div class="container">
            <div class="row">
                <div class="col-lg-12">
                    <form method="post" action="/manager/login" class="bootstrap-admin-login-form">
                        <h1>Login</h1>
                        <div class="form-group">
                            <input class="form-control" type="text" name="name" placeholder="E-mail">
                        </div>
                        <div class="form-group">
                            <input class="form-control" type="password" name="password" placeholder="Password">
                        </div>
                        <button class="btn btn-lg btn-primary" type="submit">Submit</button>
                    </form>
                </div>
            </div>
        </div>

        <script type="text/javascript" src="http://code.jquery.com/jquery-2.0.3.min.js"></script>
        <script type="text/javascript" src="/js/bootstrap.min.js"></script>
    </body>
</html>

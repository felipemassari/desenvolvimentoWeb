<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Falha no Login</title>
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/style.css" rel="stylesheet">

  </head>
  <body>

    <div class="container-fluid">
	<div class="row">
		<div class="col-md-4">
		</div>
		<div class="col-md-4">
                    <center>
                        <h2 style="margin:5%;">Email ou senha incorretos</h2>
                        <img src="./images/sad.jpg" class="rounded-circle">     

			<p>Clique no botão <strong>Login</strong> para tentar novamente ou clique no botão <strong>loja</strong>, para navegar nos itens do site.</p> 
                        
                        <a href="./login.jsp" class="btn btn-primary" type="button">Login</a>
                        <a href="/ecommerce" class="btn btn-primary" type="button" style="margin:3%;">Loja</a>
                        </center>
		</div>
		<div class="col-md-4">
		</div>
	</div>
</div>

    <script src="js/jquery.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script src="js/scripts.js"></script>
  </body>
</html>
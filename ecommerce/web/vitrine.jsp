<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<jsp:useBean id="Cliente" type="br.edu.ufabc.ecommerce.model.Cliente" scope="session"/>
<jsp:useBean id="Lista" type="java.util.List" scope="session"/>

<html>
    <head>
        <script src="js/jquery.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
        <script src="js/scripts.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
        <meta name="viewport" content="width=device-width, initial-scale=1">

        <title>.: Loja Virtual Gamer :.</title>
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <link href="css/style.css" rel="stylesheet">

    </head>
    <body>

        <div class="container-fluid">
            <div class="row" id="titulo">
               
                <div class="col-md-2">
                    <a href="./vitrine"><img src="./icons/logo.png" id="iconHome"></a>                   
                </div>
                <div class="col-md-6">
                    <h1 class="text-center">
                        Bem vindos &agrave; nossa Loja Virtual
                    </h1>
                </div>
                <div class="col-md-2">
                    <a href="./meuCarrinho"><img src="./icons/cart.png" id="iconCarrinho"></a>
                    <label>Meu Carrinho</label>
                </div>
                <c:choose>
                    <c:when test="${Cliente.nome == null}">
                       <div class="col-md-2">
                            <a href="./login.jsp"><img src="./icons/avatar.png" id="iconCarrinho"></a>
                            <label>Login</label>
                        </div>
                    </c:when>
                    <c:otherwise>
                        <div class="col-md-2">
                            <a href="./minhaconta.jsp"><img src="./icons/avatar.png" id="iconCarrinho"></a>
                            <label>${Cliente.nome}</label>
                        </div>
                    </c:otherwise>
                </c:choose>
                    
            </div>
            <!-- row dos produtos -->
            <div class="container" style="margin-top: 2%; width: 80%; padding: 1%">
                <div class="card-deck">
                    
                    <c:forEach var="produto" items="${Lista}">
                  
                        <div class="card mb-4 col-md-10 col-md-offset-2">
                            <img class="card-img-top img-fluid" src="${produto.urlFoto1}">
                            <div class="card-body mx-auto">
                              <h5 class="card-title text-center"><a href="detalheProduto?id=${produto.id}">${produto.titulo}</a></h5>
                              <p class="card-text text-center font-weight-bold"><a>R$ ${produto.preco}</a></p>
                              <a href="detalheProduto?id=${produto.id}" ><input style="margin:10%;" type="button" value="Ver Produto" class="btn mx-auto btn-outline-primary"></a>
                            </div>
                        </div>
                    </c:forEach>
                </div>
            </div>
            
            
            <div class="row" id="rodape">
                <div class="col-md-12" id="rodapetxt">
                    <h4> Fale conosco </h4>
                    <p> Estamos localizados na Av. dos Estados 5.000 em Sto Andre. </p>
                    <p> Nosso email <a href="mailto:faleco@nosco.com">faleco@nosco.com</a></p> 
                </div>
            </div>
        </div>


    </body>
</html>









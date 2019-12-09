<!DOCTYPE html>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<jsp:useBean id="Cliente" type="br.edu.ufabc.ecommerce.model.Cliente" scope="session"/>
<jsp:useBean id="DetalheProduto" type="br.edu.ufabc.ecommerce.model.Produto" scope="session"/>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">

        <title>.: Detalhe do Produto :. </title>

        <meta name="description" content="Source code generated using layoutit.com">
        <meta name="author" content="LayoutIt!">

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
                            <a href="./login.jsp"><img src="./icons/avatar.png" id="iconCarrinho"></a>
                            <label>${Cliente.nome}</label>
                        </div>
                    </c:otherwise>
                </c:choose>
            </div>
            <div class="row">
                <div class="col-md-12">
                    <h3>
                        ${DetalheProduto.titulo}
                    </h3>
                    <p>
                        ${DetalheProduto.descricao}
                    </p>
                    <h4> R$ ${DetalheProduto.preco}</h4>
                    <form role="form" action="./adicionarCarrinho" method="post">
                        <div class="form-group">
                            <label for="quantidade">Quantidade</label>
                            <input type="number" class="form-control" id="txtQuandidade" name="txtQtde" min="1" value="1">
                        </div>
                        <button type="submit" class="btn btn-primary">Adicionar ao Carrinho</button>
                    </form>
                </div>
            </div>
            <div class="row">
                <div class="col-md-4">
                    <img src="${DetalheProduto.urlFoto1}" width="70%"/>
                </div>
                <div class="col-md-4">
                    <img src="${DetalheProduto.urlFoto2}" width="70%"/>
                </div>
                <div class="col-md-4">
                    <img src="${DetalheProduto.urlFoto3}" width="70%"/>
                </div>
            </div>
        </div>

        <script src="js/jquery.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
        <script src="js/scripts.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
    </body>
</html>
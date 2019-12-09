<!DOCTYPE html>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<jsp:useBean id="Cliente" type="br.edu.ufabc.ecommerce.model.Cliente" scope="session"/>
<jsp:useBean id="Lista" type="java.util.List" scope="session"/>
<jsp:useBean id="Endereco" type="br.edu.ufabc.ecommerce.model.Endereco" scope="session"/>
<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <link href="css/style.css" rel="stylesheet">

        <script type="text/javascript">
            function buscaEndereco() {
                var cep = document.getElementById("cep").value;
                var xmlhttp = new XMLHttpRequest();
                var url = "http://cep.republicavirtual.com.br/web_cep.php?cep=" + cep + "&formato=json";
                xmlhttp.onreadystatechange = function () {
                    if (xmlhttp.status === 200) {
                        if (xmlhttp.readyState === 4) {
                            var endereco = JSON.parse(xmlhttp.responseText);
                            if (endereco.resultado == "1") {
                                document.getElementById("tipoLogradouro").value = endereco.tipo_logradouro;
                                document.getElementById("logradouro").value = endereco.logradouro;
                                document.getElementById("bairro").value = endereco.bairro;
                                document.getElementById("cidade").value = endereco.cidade;
                                document.getElementById("estado").value = endereco.uf;
                            } else {
                                alert("Endereco nao encontrado pelo CEP informado");
                            }
                        }
                    }
                };
                xmlhttp.open("GET", url, true);
                xmlhttp.send();
            }
        </script>

    </head>
    <body>

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
        <div>
            <center>
                <h2>Dados Cadastrais</h2>
            </center>
        </div>

        <div class="container-fluid" style="margin:2%;">
            <div class="row">
                <div class="col-md-1">
                </div>
                <div class="col-md-10">
                    <form role="form" class="form-inline">
                        <div class="form-group">
                            <label for="Nome">Nome</label>
                            <input type="text" class="form-control" id="nome" name="txtNome" placeholder="${Cliente.nome}"/>
                        </div>				
                    </form>

                    <form role="form" class="form-inline">
                        <div class="form-group">
                            <label for="Email1">Email address</label>
                            <input type="email" class="form-control" id="email" name="txtEmail" placeholder="${Cliente.email}"/>
                        </div>
                        <div class="form-group">
                            <label for="Senha">Password</label>
                            <input type="password" class="form-control" id="senha" name="txtSenha" placeholder="********"/>
                        </div>
                    </form>

                    <form role="form">
                        <div class="form-group">
                            <label for="cep">CEP</label>
                            <input type="text" class="form-control" id="cep" name="txtCep" onblur="buscaEndereco();" placeholder="${Endereco.cep}"/> 
                        </div>
                    </form>

                    <form role="form" class="form-inline">
                        <div class="form-group">
                            <label for="tipoLogradouro">Tipo do Logradouro</label>
                            <input type="text" readonly="true" class="form-control" id="tipoLogradouro" name="txtTipoLogradouro" placeholder="${Endereco.tipoLogradouro()}"/>
                        </div>
                        <div class="form-group">
                            <label for="logradouro">Endereço</label>
                            <input type="text" readonly="true" class="form-control" id="logradouro" name="txtLogradouro" placeholder="${Endereco.logradouro}"/>
                        </div>
                    </form>

                    <form role="form" class="form-inline">
                        <div class="form-group">
                            <label for="numero">Numero</label>
                            <input type="text" class="form-control" id="numero" name="txtNumero" required placeholder="${Endereco.numero}"/>
                        </div>
                        <div class="form-group">
                            <label for="complemento">Complemento</label>
                            <input type="text" class="form-control" id="complemento" name="txtComplemento" placeholder="${Endereco.complemento}"/>
                        </div>
                    </form>

                    <form role="form" class="form-inline">
                        <div class="form-group">
                            <label for="cidade">Cidade</label>
                            <<input type="text" class="form-control" id="cidade" name="txtCidade" placeholder="${Endereco.cidade}"/>
                        </div>
                        <div class="form-group">
                            <label for="bairro">Bairro</label>
                            <input type="text" class="form-control" id="bairro" name="txtBairro" placeholder="${Endereco.bairro}"/>
                        </div>
                        <div class="form-group col-md-4">
                            <label for="estado">Estado</label>
                            <select id="estado" class="form-control" required placeholder="${Endereco.estado}"/>
                            <option value="AC">Acre</option>
                            <option value="AL">Alagoas</option>
                            <option value="AP">Amapá</option>
                            <option value="AM">Amazonas</option>
                            <option value="BA">Bahia</option>
                            <option value="CE">Ceará</option>
                            <option value="DF">Distrito Federal</option>
                            <option value="ES">Espírito Santo</option>
                            <option value="GO">Goiás</option>
                            <option value="MA">Maranhão</option>
                            <option value="MT">Mato Grosso</option>
                            <option value="MS">Mato Grosso do Sul</option>
                            <option value="MG">Minas Gerais</option>
                            <option value="PA">Pará</option>
                            <option value="PB">Paraíba</option>
                            <option value="PR">Paraná</option>
                            <option value="PE">Pernambuco</option>
                            <option value="PI">Piauí</option>
                            <option value="RJ">Rio de Janeiro</option>
                            <option value="RN">Rio Grande do Norte</option>
                            <option value="RS">Rio Grande do Sul</option>
                            <option value="RO">Rondônia</option>
                            <option value="RR">Roraima</option>
                            <option value="SC">Santa Catarina</option>
                            <option value="SP">São Paulo</option>
                            <option value="SE">Sergipe</option>
                            <option value="TO">Tocantins</option>
                            </select>
                        </div>
                    </form>
                </div>
            </div>
            <div>
                <form>
                    <center style="margin:1%;">
                        <button type="submit" class="btn btn-primary">Alterar</button>
                    </center>
                </form>
            </div> 
            <div>
                <div style="margin:3%;">
                    <center>
                        <h2>Lista de Pedidos</h2>
                    </center>
                </div>
                
                <c:forEach var="produto" items="${Lista}">
                    <div class="card mb-4 col-md-10 col-md-offset-2">
                     <h5 class="card-title text-center"><a href="detalheProduto?id=${produto.id}">${produto.titulo}</a></h5>
                              <p class="card-text text-center font-weight-bold"><a>R$ ${produto.preco}</a></p>
                  
                    </c:forEach>
            </div>


            <div class="col-md-1">
            </div>
        </div>
    </body>
</html>

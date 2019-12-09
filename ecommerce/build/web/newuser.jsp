<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
    <head>
        <script src="js/jquery.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
        <script src="js/scripts.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
        <meta name="viewport" content="width=device-width, initial-scale=1">

        <title>.: Loja Virtual Gamer :.</title>
        <link href="main.css?version=12" />
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
                <div class="col-md-2">
                    <a href="./login.jsp"><img src="./icons/avatar.png" id="iconCarrinho"></a>
                    <label>Login</label>
                </div>
            </div>
        </div>

        <div class="conteiner-fluid">
            <div class="row">
                <div class="col-md-2">
                </div>
                <div class="col-md-10">

                    <form role="form" method="POST" action="newUser">
                        <div class="form-group col-md-6">
                            <label for="Nome">Seu Nome</label>
                            <input type="text" class="form-control" id="nome" name="txtNome" required/>
                        </div>

                        <div class="form-row">
                            <div class="form-group col-md-4">
                                <label for="Email">Email</label>
                                <input type="email" class="form-control" id="email" name="txtEmail" placeholder="Email" required/>
                            </div>
                            <div class="form-group col-md-4">
                                <label for="Senha">Senha</label>
                                <input type="password" class="form-control" id="senha" name="txtSenha" placeholder="Senha" required/>
                            </div>
                        </div>

                        <div class="form-group col-md-4">
                            <label for="cep">CEP</label>
                            <input type="text" class="form-control" id="cep" name="txtCep" onblur="buscaEndereco();" required/> 
                        </div>

                        <div class="form-row">
                            <div class="form-group col-md-2">
                                <label for="tipoLogradouro">Tipo do Logradouro</label>
                                <input type="text" readonly="true" class="form-control" id="tipoLogradouro" name="txtTipoLogradouro"/>
                            </div>
                            <div class="form-group col-md-6">
                                <label for="logradouro">Endereço</label>
                                <input type="text" readonly="true" class="form-control" id="logradouro" name="txtLogradouro"/>
                            </div>
                            <div class="form-group col-md-2">
                                <label for="numero">Numero</label>
                                <input type="text" class="form-control" id="numero" name="txtNumero" required/>
                            </div>
                            <div class="form-group col-md-2">
                                <label for="complemento">Complemento</label>
                                <input type="text" class="form-control" id="complemento" name="txtComplemento" />
                            </div>
                            <div class="form-group col-md-2">
                                <label for="bairro">Bairro</label>
                                <input type="text" class="form-control" id="bairro" name="txtBairro" required/>
                        </div> 
                        <div class="form-row">
                            <div class="form-group col-md-4">
                                <label for="cidade">Cidade</label>
                                <input type="text" class="form-control" id="cidade" name="txtCidade" required/>
                            </div>
                            <div class="form-group col-md-4">
                                <label for="estado">Estado</label>
                                <select id="estado" class="form-control" id="estado" name="txtEstado" required>
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

                        </div>
                        <button type="submit" class="btn btn-primary">Enviar Dados</button>
                    </form>
                </div>
            </div>
        </div>

        <div class="container-fluid">
            <div class="row" id="rodape">
                <div class="col-md-12 text-center" id="rodapetxt">
                    <h4> Fale conosco </h4>
                    <p> Estamos localizados na Av. dos Estados 5.000 em Sto Andre. </p>
                    <p> Nosso email <a href="mailto:faleco@nosco.com">faleco@nosco.com</a></p> 
                </div>
            </div>
        </div>
    </body>
</html>









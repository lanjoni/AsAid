<?php session_start(); 
include_once '../dao/produtoDAO.php';
?>

<!-- 
Os autores:
    João Augusto Lissoni Lanjoni
    Paulo Junior Walbueno dos Santos

Alunos do Técnico em Informática Integrado ao Ensino Médio do IFSP Câmpus Votuporanga.
Trabalho de Conclusão de Curso do ano de 2021.

-->

<html>

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="author" content="Paulo Junior">
    <meta name="author" content="João Augusto">
    <title>AsAid</title>
    <link href="../css-bootstrap/bootstrap.min.css" rel="stylesheet" type="text/css" />
    <link href="../css/css_paginaInicial.css" rel="stylesheet" type="text/css" />
    <?php include_once '../config/bdconfig.php';

        ?>
    
</head>

<body>
    
    <form class="form" method="POST" action="../controller/produtoCTR.php">
        
    <!-- <div class="col-100 footer-2"> -->
    <header class="header-1">
        <div class="logo box">
            <a href='paginaInicial.php'><img class="img-logo" src="../img/asaidlogo1.png" alt="logo AsAid" /></a>
        </div>
    </header>
    <div class="container">
        <div class="row">
            <div class="col-5 espaco">
                <div class="distancia">
                    <h1 class="white digitar">
                        A MELHOR OPÇÃO PARA REPAROS VOCÊ ENCONTRA AQUI!
                    </h1>
                </div>
            </div>
            <div class="col-7">
                <div class="espaco col-12" id="blue">
                    <h1 id="small">ACOMPANHE SEU PEDIDO</h1>
                     <input type="hidden" name='id_produto' 
                                        placeholder="id_produto" id="id_produto"  style="height: 40px">
                    <label id="small2">Informe o código do seu pedido:</label>
                    <br />
                    <input type="text" class="form-control" id="transpa" name="cod_produto" placeholder="Digite aqui o código do pedido!">
                    <br />
                    <label id="small5">Informe a chave de acesso: </label>
                    <br />
                    <input type="password" class="form-control" id="transpa" name="sen_produto"
                        placeholder="Digite aqui a chave de acesso!">
                    <div class="alinhab">
                        <a><button type="submit" class="btn-lg btn-primary mb-2"
                                name="login" id="btn">Enviar</button></a>
                    </div>
                    <br />
                    <div class="alinhac">
                        <h3 id="small3">Entre em contato conosco!</h3>
                        <br />
                        <h3 class="small4">Telefone: (17) 3836-1122</h3>
                        <h3 class="small4">Av. Damião Gonzalez Martinez, 446 - 15530-000 - Cosmorama - SP</h3>
                    </div>
                </div>
                <div class="black box2">

                </div>
            </div>
        </div>
        <!-- </div> -->
    </div>

    <script>
        function typeWriter(elemento) {
            const textoArray = elemento.innerHTML.split('');
            elemento.innerHTML = '';
            textoArray.forEach((letra, i) => {
                setTimeout(function () {
                    elemento.innerHTML += letra;
                }, 70 * i)
            });
        }

        const test = document.querySelector('.digitar');
        typeWriter(test);
    </script>
    </form>
</body>

</html>


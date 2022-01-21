<html>
    <head>
        <title>Produto Controller</title>
        <?php
       
        include_once '../dao/produtoDAO.php';
        ?>
    </head>
    <body>
        <div class='container'> 
            <div class='row clearfix'> 
                <div class='w-100'>

                    <?php



        if (isset($_POST['login'])) {
            if (login($_POST['cod_produto'], $_POST['sen_produto'])) {
                    

        } else {
                echo "<center><h3>Código do produto ou Senha do produto Inválido</h3></center></div>";
            }
        } 
        
//        
//                  if (isset($_POST['cadastrar'])) {
//                        if (inserir_produto()):
//                            echo "<h1 class= 'text-center' > Produto inserido com sucesso </h1>";
//                        else:
//                            echo "<h1 class= 'text-center' > Produto não foi inserido </h1>";
//                        endif;
//                    }else if (isset($_GET['apagar'])) {
//                        if (apagar_produto()):
//                            echo "<h1 class= 'text-center' > Produto removido com sucesso </h1>";
//                        else:
//                            echo "<h1 class= 'text-center' > Produto não foi removido ou o Produto não foi encontrado </h1>";
//                        endif;
//                    } else if (isset($_POST['update'])) {
//                        if (atualizar_produto()):
//                            echo "<h1 class= 'text-center' > Registro atualizado com sucesso </h1>";
//                        else:
//                            echo "<h1 class= 'text-center' > Registro não atualizado </h1>";
//                        endif;
//                    } else {
//                        //caso produtoCTR seja chamado mas não entre em update, apagar, ou cadastrar informar que a rota não foi identificada
//                        echo "<h1 class= 'text-center' > Rota Não identificada  </h1>";
//                    }                  
                    ?>
                    <a class='btn btn-primary float-right' href='../view/paginaInicial.php'> Voltar </a>
                </div>
            </div>
        </div>
    </body>
</html>



<?php
include_once '../dao/produtoDAO.php';
include_once '../config/bdconfig.php';

// Aqui possui os codigos para chamar os atributos status e obs_assist do 
//método (function) consulta_assistencia que está no produtoDAO:
/*  function consulta_assistencia($campos = '*') {   
  $sql = "select $campos from assistencia";
  $conexao = conexao();
  $stmt = $conexao->prepare($sql);
  $stmt->execute();
  return $stmt->fetchAll(PDO::FETCH_ASSOC);
 * Esse é o método consulta_assistencia que está no produtoDAO, Não tira esse 
  comentário pois essa function já está em produtoDAO.
  } */



//Aqui que chamo os atributos da tabela assistencia.
  $consulta = 'select as status, obs_assist as obs_assist';
  $campos = 'status as status, obs_assist as obs_assist';
  $resultado = consulta_assistencia('*');
  $linha = $resultado[2];

//$assistencia = array($id_assist, $status, $dathor_ent, $obs_assist, $id_produto, $id_cliente);


/* $consulta = 'status  as status,obs_assist as obs_assist';
  $campos = 'status  as status,obs_assist as obs_assist';
  $resultado = consulta_assistencia($campos);

  if (count($resultado) > 0) {
  $linha = $resultado[0];
  } */
?>


<html>
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="author" content="Paulo Junior">
        <meta name="author" content="João Augusto">
        <title>Seu pedido!</title>
        <link href="../css-bootstrap/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <link href="../css/css_paginaAcompanhamento.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <header class="header-1">
            <div class="logo">
                <a href='paginaInicial.php'><img class="img-logo" src="../img/asaidlogo1.png" alt="logo AsAid"/></a>
            </div>
        </header>
        <div class="container">
            <div class="row">
                <div id="blue">
                    <div class="seupedido">
                        <h3 id="small">SEU PEDIDO!</h3>
                    </div>
                   
                    <div id="dark" >
                         <div class="col-md-5">
                        <div>
                            <h3 id="small2"><?php echo $linha["status"] ?></h3>
                        </div>
                             
                        <div id="small3">
                          <br><h4 id="small2"> <?php echo $linha["obs_assist"] ?> </h4>
                        </div>
                    </div>
                    </div>

                </div>



            </div>


        </div>

    </body>
</html>




<?php

const DRIVE = "pgsql";
const ENDERECO = "localhost";
const PORTA = "5432";
const DBNAME = "AsAidbanco";
const USER = "postgres";
const PASSWORD = "pgserver";

try {

    function conexao() {
        $conexao = new PDO(DRIVE . ":host=" . ENDERECO . ";port=" . PORTA
                . ";dbname=" . DBNAME . ";user=" . USER . ";password=" . PASSWORD);

        $conexao->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);
        $conexao->setAttribute(PDO::ATTR_EMULATE_PREPARES, false);

        if ($conexao) {
            return $conexao;
        }
    }

} catch (PDOException $erro) {
    echo "Não foi possível realizar a conexão <br>";
    echo $erro->getMessage();
}
 function consulta($sql) {
            $conexao = conexao();
            $statement = $conexao->prepare($sql);
            $statement->execute();
            return $statement->fetchAll(PDO::FETCH_ASSOC);
        }
function console($msg) {
    echo "<script>";
    echo "console.log('" . $msg . "');";
    echo "</script>";
}

function produto($cod_produto, $desc_produto, $sen_produto, $id_user) {
    try {
        $conexao = conexao();
        
        $cod_produto = filter_var($cod_produto, FILTER_SANITIZE_STRING);
         $desc_produto = filter_var( $desc_produto, FILTER_SANITIZE_STRING);
         $sen_produto = filter_var($sen_produto, FILTER_SANITIZE_STRING);
          $id_user = filter_var($id_user, FILTER_SANITIZE_STRING);
  
          
        
        $sql = 'select * from produto where cod_produto = ? and senha_produto = ? id_user = ?';
        $statement = $conexao->prepare($sql);
        $statement->bindParam(1, $cod_produto);
        $statement->bindParam(2, $desc_produto);
         $statement->bindParam(3, $sen_produto);
        $statement->bindParam(4, $id_user);
        if ($statement->execute()) {
            $statement->fetchAll(PDO::FETCH_ASSOC);
            if ($statement->rowCount() > 0):
                echo "Produto Encontrado";

                inicia_sessao($cod_produto, $desc_produto, $sen_produto, $id_user);
            else:
                echo "Produto Não encontrado <br>";
                insert_pessoa($cod_produto, $desc_produto, $sen_produto, $id_user);
            endif;
        }
           
    } catch (Exception $exc) {
        echo $exc->getTraceAsString();
    }
}

function inicia_sessao($cod_produto, $desc_produto, $sen_produto, $id_user) {
    $_SESSION['cod_produto'] = $cod_produto;
    $_SESSION['$desc_produto'] = $desc_produto;
     $_SESSION['sen_produto'] = $sen_produto;
    $_SESSION['id_user'] = $id_user;
    header("Location: paginaInicial.php");
}

function insert_produto($cod_produto, $desc_produto, $sen_produto, $id_user) {
    echo "Inserindo produto <br>";
    $conexao = conexao();
    if (isset($cod_produto)) {
        $cod_produto = filter_var($cod_produto, FILTER_SANITIZE_STRING);
    }
    
    if (isset($desc_produto)) {
        $desc_produto = filter_var($desc_produto, FILTER_SANITIZE_STRING);
    }
      if (isset($sen_produto)) {
        $sen_produto = filter_var($sen_produto, FILTER_SANITIZE_STRING);
    }
      if (isset($id_user)) {
        $id_user = filter_var($id_user, FILTER_SANITIZE_STRING);
    }
     
    if (!empty($cod_produto) && !empty($desc_produto) && !empty($sen_produto) && !empty($id_user) ) {
        $cod_produto = 432798;
       
        $sql = "INSERT INTO produto ( cod_produto, desc_produto, sen_produto, id_user) VALUES (?,?,?,?);";
           $statement = $conexao->prepare($sql);
           $statement->bindParam(1, $cod_produto);
        $statement->bindParam(2, $desc_produto);
         $statement->bindParam(3, $sen_produto);
        $statement->bindParam(4, $id_user);
         $statement->execute();
      inicia_sessao($cod_produto, $desc_produto, $sen_produto, $id_user);
        echo "<script> alert('produto inserido' )</script>";
    } else {
        echo "<script> alert('É preciso informar o código do produto' )</script>";
    }
}
function limpar($campo, $int = false) {
    // Verifica se o campo não é inteiro
    if (!$int) {
        if (!empty($campo)) {
            return filter_var($campo, FILTER_SANITIZE_STRING);
        }
        return "";
    } else {
        if (!empty($campo)) {
            return filter_var($campo, FILTER_SANITIZE_NUMBER_INT);
        }
        return 0;
    }
}

?>

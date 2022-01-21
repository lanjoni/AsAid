<?php
        
//inclui a conexão com o banco se ainda não foi incluída
include_once '../config/bdconfig.php';

function login() {
    $conexao = conexao();
    $id_produto = "";
    $cod_produto = "";
    $sen_produto = "";
    $id_user = "";
    
        if (isset($_POST['id_produto'])) {
        $id_produto = filter_input(INPUT_POST, 'id_produto', FILTER_SANITIZE_STRING);
    }
    if (isset($_POST['cod_produto'])) {
        $cod_produto = filter_input(INPUT_POST, 'cod_produto', FILTER_SANITIZE_STRING);
    }
    if (isset($_POST['sen_produto'])) {
        $sen_produto = filter_input(INPUT_POST, 'sen_produto', FILTER_SANITIZE_STRING);
    }
     if (isset($_POST['id_user'])) {
        $id_user = filter_input(INPUT_POST, 'id_user', FILTER_SANITIZE_STRING);
    }

    if (!empty($cod_produto) && !empty($sen_produto)) {
        try {
            $sql = 'select * from produto where cod_produto = (?) and sen_produto = (?)';
            $statement = $conexao->prepare($sql);
            $statement->bindParam(1, $cod_produto);
            $statement->bindParam(2, $sen_produto);
            $statement->execute();
            
            if ($statement->rowCount() > 0) {
                str_split($cod_produto, 2);
                $valida = $cod_produto[0] . $cod_produto[1];
                if ($valida == "1" || "2" || "3" || "4") {
                    header("Location: ../view/paginaAcompanhamento.php");
                } else if ($valida == "5" || "6" || "7" || "8" || "9") {
                     header("Location: ../view/paginaAcompanhamento.php");
                } 
                
            }
            
        } catch (Exception $exc) {
            echo $exc->getMessage();
            return false;
        }
    }
    return false;
}





 /* function inicia_sessao() {
    $_SESSION['cod_produto'] = $cod_produto;
    $_SESSION['sen_produto'] = $sen_produto;
    header("Location: paginaAcompanhamento.php");
} */  


/*function apagar_produto() {
    $cod_produto = filter_input(INPUT_GET, 'apagar', FILTER_SANITIZE_NUMBER_INT);
    if (!empty($cod_produto)) {
        try {
//abre conexão              
            $conexao = conexao();
//Cria o script para apagar
            $sql = "DELETE from  produto where cod_produto=(?);";
//Prepara para apagar
            $statement = $conexao->prepare($sql);
//Informa qual o valor da primeira variável ?    cod_produto
            $statement->bindParam(1, $id);
//executa
            $statement->execute();
            //Verifica a quantidade de linhas afetadas    
            if ($statement->rowCount() > 0)
                return true;
        } catch (Exception $exc) {
            console($exc->getMessage());
            return false;
        }
    }
    return false;
}

function inserir_produto() {
    //inicia as variáveis com os valores eperados para dados em branco
    $conexao = conexao();
    $cod_produto = 0;
    $desc_produto = "";
    $sen_produto = "";
    $id_user = "";

    if (isset($_POST['cod_produto']) && empty($POST['cod_produto'])) {
        $cod_produto = filter_input(INPUT_POST, 'cod_produto', FILTER_SANITIZE_STRING);
    }
    if (isset($_POST['desc_produto'])) {
        $desc_produto = filter_input(INPUT_POST, 'desc_produto', FILTER_SANITIZE_STRING);
    }
    if (isset($_POST['sen_produto'])) {
        $sen_produto = filter_input(INPUT_POST, 'sen_produto', FILTER_SANITIZE_STRING);
    }
    if (isset($_POST['id_user'])) {
        $id_user = filter_input(INPUT_POST, 'id_user', FILTER_SANITIZE_STRING);
    }
    //verifica se realmente o Nome (dado que não pode estar em branco) está preenchido
    if (!empty($sen_produto)) {
        try {
            //Cria o script de insert             
            $sql = 'INSERT INTO public.produto(
	cod_produto, desc_produto, $sen_produto, senha, id_user)
	VALUES (?, ?, ?, ?, ?, ?)';
            //Prepara para inserir
            $statement = $conexao->prepare($sql);
            $statement->bindParam(1, $cod_produto);
            $statement->bindParam(2, $desc_produto);
            $statement->bindParam(3, $sen_produto);
            $statement->bindParam(4, $id_user);
            $statement->execute();
            //Verifica a quantidade de linhas afetadas
            if ($statement->rowCount() > 0) {
                $statement->bindParam(6, $cod_produto);
                return true;
            }
        } catch (Exception $exc) {
            echo $exc->getTraceAsString();
            return false;
        }
    }
    return false;
}

function atualizar_produto() {
    $conexao = conexao();
    $cod_produto = 0;
    $desc_produto = "";
    $sen_produto = "";
    $id_user = "";

    $cod_produto = limpar($_POST['cod_produto'], true);
    $desc_produto = limpar($_POST['desc_produto']);
    $sen_produto = limpar($_POST['sen_produto']);
    $id_user = limpar($_POST['id_user']);

    if (!empty($cod_produto) && !empty($sen_produto)) {
        try {
            $sql = 'UPDATE public.produto
	SET id_produto=?, cod_produto=?, desc_produto=?, sen_produto=?, id_user=?
	WHERE <condition>;';
            $statement = $conexao->prepare($sql);

            $statement->bindParam(1, $cod_produto);
            $statement->bindParam(2, $desc_produto);
            $statement->bindParam(3, $sen_produto);
            $statement->bindParam(4, $id_user);
            $statement->execute();
            //se a quantidade de registro for maior que 0 então eu consegui atualizar alguém
            if ($statement->rowCount() > 0) {
                return true;
            }
        } catch (Exception $exc) {
            echo $exc->getMessage();
            return false;
        }
    }
    //se os dados estavam em branco ou se nenhum registro foi atualizado informa que não foi possível fazer o update.
    return false;
}*/

//função padrão para consultar Pessoa, pode receber uma string com os campos (ex: id_pes as Nome) e os valores para o where
function consulta_produto($campos = '*', $add = '', $cod_produto = 'cod_produto', $sen_produto = 'sen_produto') {
    $sql = "select $campos from produto $add";
    $consulta = "select id_produto as id_produto, cod_produto as cod_produto, sen_produto as sen_produto from produto";
    $id_produto = "select id_produto where cod_produto = $cod_produto and sen_produto = $sen_produto";
    $conexao = conexao();
    $stmt = $conexao->prepare($sql);
    $stmt->execute();
    return $stmt->fetchAll(PDO::FETCH_ASSOC);
}

/* Método consulta_assistencia que é que realiza o select de todos os atributos da 
tabela assistencia. Esse método foi "reverenciado" na paginaAcompanhamento porém 
chamando os status e obs_assist para mostrar na tela. */
function consulta_assistencia($campos = '*', $id_produto = 'id_produto') {   
    $sql = "select $campos from assistencia where id_produto = $id_produto";
    $conexao = conexao();
    $stmt = $conexao->prepare($sql);
    $stmt->execute();
    return $stmt->fetchAll(PDO::FETCH_ASSOC);
}



/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.asaid.ctr;

import java.sql.*;
import br.com.asaid.dto.ProdutoDTO;
import br.com.asaid.dto.AdminDTO;
import br.com.asaid.dao.ProdutoDAO;
import br.com.asaid.dao.ConexaoDAO;

public class ProdutoCTR {
    ProdutoDAO produtoDAO = new ProdutoDAO();

    /**
     * Método construtor da classe
     */
    public ProdutoCTR() {
    }

    
    /**
     * Método utilizado para controlar o acesso ao método inserirProduto da classe
     * ProdutoDAO
     *
     * @param ProdutoDTO que vem da classe da página (VIEW)
     * @param AdminDTO que vem da classe da página (VIEW)
     * @return String contendo a mensagem
     */
    public String inserirProduto(ProdutoDTO produtoDTO, AdminDTO adminDTO) {
        try {
            //Chama o metodo que esta na classe DAO aguardando uma resposta (true ou false)
            if (produtoDAO.inserirProduto(produtoDTO, adminDTO)) {
                return "Produto Cadastrado com Sucesso!!!";
            } else {
                return "Produto NÃO Cadastrado!!!";
            }
        } //Caso tenha algum erro no codigo acima é enviado uma mensagem no console com o que esta acontecendo.
        catch (Exception e) {
            System.out.println(e.getMessage());
            return "Produto NÃO Cadastrado!!!";
        }
    }//Fecha o método inserirProduto

    
    /**
     * Método utilizado para controlar o acesso ao método alterarProduto da classe
     * ProdutoDAO
     *
     * @param ProdutoDTO que vem da classe da página (VIEW)
     * @return String contendo a mensagem
     */
    public String alterarProduto(ProdutoDTO produtoDTO) {
        try {
            //Chama o metodo que esta na classe DAO aguardando uma resposta (true ou false)
            if (produtoDAO.alterarProduto(produtoDTO)) {
                return "Produto Alterado com Sucesso!!!";
            } else {
                return "Produto NÃO Alterado!!!";
            }
        } //Caso tenha algum erro no codigo acima é enviado uma mensagem no console com o que esta acontecendo.
        catch (Exception e) {
            System.out.println(e.getMessage());
            return "Produto NÃO Alterado!!!";
        }
    }//Fecha o método alterarProduto
    
             
    /**
     * Método utilizado para controlar o acesso ao método consultarProdutoda
     * classe ProdutoDAO
     *
     * @param ProdutoDTO, opcao que vem da classe da página (VIEW)
     * @param adminDTO, opcao que vem da classe da página (VIEW)
     * @param opcao que vem da classe da página (VIEW)
     * @return ResultSet com os dados do locador
     */
    public ResultSet consultarProduto(ProdutoDTO produtoDTO, AdminDTO adminDTO, int opcao) {
        //É criado um atributo do tipo ResultSet, pois este método recebe o resultado de uma consulta.
        ResultSet rs = null;

        //O atributo rs recebe a consulta realizada pelo método da classe DAO
        rs = produtoDAO.consultarProduto(produtoDTO, adminDTO, opcao);

        return rs;
    }//Fecha o método consultarProduto

    public String excluirProduto(ProdutoDTO produtoDTO) {
        try {
            //Chama o metodo que esta na classe DAO aguardando uma resposta (true ou false)
            if (produtoDAO.excluirProduto(produtoDTO)) {
                return "Produto Excluído com Sucesso!!!";
            } else {
                return "Produto NÃO Excluído!!!";
            }
        } //Caso tenha algum erro no codigo acima é enviado uma mensagem no console com o que esta acontecendo.
        catch (Exception e) {
            System.out.println(e.getMessage());
            return "Produto NÃO Excluído!!!";
        }
    }//Fecha o método excluirCarro

    /**
     * Método utilizado para controlar o acesso ao método CloseDB da classe
     * ConexaoDAO
     */
    public void CloseDB() {
        ConexaoDAO.CloseDB();
    }//Fecha o método CloseDB

    

}//fecha a classe ProdutoCTR

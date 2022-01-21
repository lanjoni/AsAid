/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.asaid.dao;

import br.com.asaid.dto.ProdutoDTO;
import br.com.asaid.dto.AdminDTO;
import java.sql.*;
import java.sql.ResultSet;
import java.sql.Statement;

public class ProdutoDAO {

    public ProdutoDAO() {
    }

    //Atributo do tipo ResultSet utilizado para realizar consultas
    private ResultSet rs = null;
    //Manipular o banco de dados
    private Statement stmt = null;

    /**
     * Método utilizado para inserir um objeto ProdutoDTO no banco de dados
     *
     * @param ProdutoDAO, que vem da classe ProdutoCTR
     * @return Um boolean
     */
    public boolean inserirProduto(ProdutoDTO produtoDTO, AdminDTO adminDTO) {
        try {
            //Chama o metodo que esta na classe ConexaoDAO para abrir o banco de dados
            ConexaoDAO.ConectDB();
            //Cria o Statement que responsavel por executar alguma coisa no banco de dados
            stmt = ConexaoDAO.con.createStatement();
            //Comando SQL que sera executado no banco de dados
            String comando = "Insert into produto (cod_produto, "
                    + "desc_produto, sen_produto, id_user) values ( "
                    + produtoDTO.getCod_produto() + ", "
                    + "'" + produtoDTO.getDesc_produto() + "', "
                    + "'" + produtoDTO.getSenha_produto() + "', "
                    + adminDTO.getId_user() + ")";

            System.out.println(comando);
            //Executa o comando SQL no banco de Dados
            stmt.execute(comando.toUpperCase());
            //Da um commit no banco de dados
            ConexaoDAO.con.commit();
            //Fecha o statement
            stmt.close();
            return true;
        } //Caso tenha algum erro no codigo acima é enviado uma mensagem no console com o que esta acontecendo.
        catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        } //Independente de dar erro ou não ele vai fechar o banco de dados.
        finally {
            //Chama o metodo da classe ConexaoDAO para fechar o banco de dados
            ConexaoDAO.CloseDB();
        }
    }//Fecha o método inserirAdmin

    /**
     * Método utilizado para excluir um objeto adminDTO no banco de dados
     *
     * @param adminDTO que vem da classe CarroCTR
     * @return Um boolean
     */
    public boolean excluirProduto(ProdutoDTO produtoDTO) {
        try {
            //Chama o metodo que esta na classe ConexaoDAO para abrir o banco de dados
            ConexaoDAO.ConectDB();
            //Cria o Statement que responsavel por executar alguma coisa no banco de dados
            stmt = ConexaoDAO.con.createStatement();
            //Comando SQL que sera executado no banco de dados
            String comando = "Delete from produto where id_produto = " + produtoDTO.getId_produto();

            //Executa o comando SQL no banco de Dados
            stmt.execute(comando);
            //Da um commit no banco de dados
            ConexaoDAO.con.commit();
            //Fecha o statement
            stmt.close();
            return true;
        } //Caso tenha algum erro no codigo acima é enviado uma mensagem no console com o que esta acontecendo.
        catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        } //Independente de dar erro ou não ele vai fechar o banco de dados.
        finally {
            //Chama o metodo da classe ConexaoDAO para fechar o banco de dados
            ConexaoDAO.CloseDB();
        }
    }//Fecha o método excluirProduto

    /**
     * Método utilizado para alterar um objeto ProdutoDTO no banco de dados
     *
     * @param ProdutoDTO, que vem da classe ProdutoCTR
     * @return Um boolean
     */
    public boolean alterarProduto(ProdutoDTO produtoDTO) {
        try {
            //Chama o metodo que esta na classe ConexaoDAO para abrir o banco de dados
            ConexaoDAO.ConectDB();
            //Cria o Statement que responsavel por executar alguma coisa no banco de dados
            stmt = ConexaoDAO.con.createStatement();
            //Comando SQL que sera executado no banco de dados
            String comando = "Update produto set "
                    + "cod_produto = " + produtoDTO.getCod_produto() + ", "
                    + "desc_produto = '" + produtoDTO.getDesc_produto() + "', "
                    + "sen_produto = '" + produtoDTO.getSenha_produto() + "' "
                    + "where id_produto = " + produtoDTO.getId_produto();

            //Executa o comando SQL no banco de Dados
            stmt.execute(comando.toUpperCase());
            //Da um commit no banco de dados
            ConexaoDAO.con.commit();
            //Fecha o statement
            stmt.close();
            return true;
        } //Caso tenha algum erro no codigo acima é enviado uma mensagem no console com o que esta acontecendo.
        catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        } //Independente de dar erro ou não ele vai fechar o banco de dados.
        finally {
            //Chama o metodo da classe ConexaoDAO para fechar o banco de dados
            ConexaoDAO.CloseDB();
        }
    }//Fecha o método alterarProduto

    /**
     * Método utilizado para consultar um objeto adminDTO no banco de dados
     *
     * @param ProdutoDTO, que vem da classe ProdutoCTR
     * @param opcao, que vem da classe ProdutoCTR
     * @return Um ResultSet com os dados do produto
     */
    public ResultSet consultarProduto(ProdutoDTO produtoDTO, AdminDTO adminDTO, int opcao) {
        try {
            //Chama o metodo que esta na classe ConexaoDAO para abrir o banco de dados
            ConexaoDAO.ConectDB();
            //Cria o Statement que responsavel por executar alguma coisa no banco de dados
            stmt = ConexaoDAO.con.createStatement();
            //Comando SQL que sera executado no banco de dados
            String comando = "";
            switch (opcao) {
                case 1:
                    comando = "Select p.* "
                            + "from produto p "
                            + "where p.id_produto = " + produtoDTO.getId_produto()
                            + "order by p.id_produto";

                    break;
                case 2:
                    comando = "Select p.* "
                            + "from produto p "
                            + "where p.cod_produto = " + produtoDTO.getCod_produto();
                    break;
                case 3:
                    comando = "Select p.* "
                            + "from produto p "
                            + "where p.desc_produto = '" + produtoDTO.getDesc_produto() + "%'";
                    break;
                case 4:
                    comando = "Select p.* "
                            + "from produto p "
                            + "where p.sen_produto = '" + produtoDTO.getSenha_produto() + "%'";
                    break;
                case 5:
                    comando = "Select p.* "
                            + "from produto p "
                            + "where p.id_user = " + adminDTO.getId_user();
                    break;
                case 6:
                    comando = "Select p.* "
                            + "from produto p";
                    break;

            }
            //Executa o comando SQL no banco de Dados
            rs = stmt.executeQuery(comando.toUpperCase());
            return rs;
        } //Caso tenha algum erro no codigo acima é enviado uma mensagem no console com o que esta acontecendo.
        catch (Exception e) {
            System.out.println(e.getMessage());
            return rs;
        }
    }//Fecha o método consultar produto
}

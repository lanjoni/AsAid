/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.asaid.dao;

import br.com.asaid.dto.AdminDTO;
import java.sql.*;
import java.sql.ResultSet;
import java.sql.Statement;

public class AdminDAO {

    public AdminDAO() {
    }

    //Atributo do tipo ResultSet utilizado para realizar consultas
    private ResultSet rs = null;
    //Manipular o banco de dados
    private Statement stmt = null;

    /**
     * Método utilizado para inserir um objeto carroDTO no banco de dados
     *
     * @param carroDTO, que vem da classe CarroCTR
     * @return Um boolean
     */
    public boolean inserirAdmin(AdminDTO adminDTO) {
        try {
            //Chama o metodo que esta na classe ConexaoDAO para abrir o banco de dados
            ConexaoDAO.ConectDB();
            //Cria o Statement que responsavel por executar alguma coisa no banco de dados
            stmt = ConexaoDAO.con.createStatement();
            //Comando SQL que sera executado no banco de dados
            String comando = "Insert into Admin ( sen_user, "
                    + "nome_user) values ( "
                    
                    + "'" + adminDTO.getSen_user() + "', "
                    + "'" + adminDTO.getNome_user() + "')";

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
    public boolean excluirAdmin(AdminDTO adminDTO) {
        try {
            //Chama o metodo que esta na classe ConexaoDAO para abrir o banco de dados
            ConexaoDAO.ConectDB();
            //Cria o Statement que responsavel por executar alguma coisa no banco de dados
            stmt = ConexaoDAO.con.createStatement();
            //Comando SQL que sera executado no banco de dados
            String comando = "Delete from Admin where id_user = " + adminDTO.getId_user();
            

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
    }//Fecha o método excluirAdmin

    /**
     * Método utilizado para alterar um objeto adminDTO no banco de dados
     *
     * @param adminDTO, que vem da classe CarroCTR
     * @return Um boolean
     */
    public boolean alterarAdmin(AdminDTO adminDTO) {
        try {
            //Chama o metodo que esta na classe ConexaoDAO para abrir o banco de dados
            ConexaoDAO.ConectDB();
            //Cria o Statement que responsavel por executar alguma coisa no banco de dados
            stmt = ConexaoDAO.con.createStatement();
            //Comando SQL que sera executado no banco de dados
            String comando = "Update Admin set "
                    + "sen_user = '" + adminDTO.getSen_user() + "',"
                    + "nome_user = '" + adminDTO.getNome_user() + "' "
                    + "where id_user = " + adminDTO.getId_user();
            

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
    }//Fecha o método alterarCarro

    /**
     * Método utilizado para consultar um objeto adminDTO no banco de dados
     *
     * @param adminDTO, que vem da classe adminCTR
     * @param opcao, que vem da classe adminCTR
     * @return Um ResultSet com os dados do admin
     */
    public ResultSet consultarAdmin(AdminDTO adminDTO, int opcao) {
        try {
            //Chama o metodo que esta na classe ConexaoDAO para abrir o banco de dados
            ConexaoDAO.ConectDB();
            //Cria o Statement que responsavel por executar alguma coisa no banco de dados
            stmt = ConexaoDAO.con.createStatement();
            //Comando SQL que sera executado no banco de dados
            String comando = "";
            switch (opcao) {
                case 1:
                    comando = "Select a.* "
                            + "from Admin a "
                            + "where nome_user like '" + adminDTO.getNome_user() + "%' "
                            + "order by a.nome_user";

                    break; 
                case 2:
                    comando = "Select a.* "
                            + "from Admin a "
                            + "where a.id_user = " + adminDTO.getId_user();
                    break;
                case 3:
                    comando = "Select a.id_user, a.sen_user, a.nome_user "
                            + "from Admin a ";
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
    }//Fecha o método consultar admin
    

    public int logarAdmin(AdminDTO adminDTO) {
        try {
            //Chama o metodo que esta na classe ConexaoDAO para abrir o banco de dados
            ConexaoDAO.ConectDB();
            //Cria o Statement que responsavel por executar alguma coisa no banco de dados
            stmt = ConexaoDAO.con.createStatement();
            //Comando SQL que sera executado no banco de dados
            String comando = "Select a.id_user " +
                             "from Admin a " + 
                             "where a.nome_user = '" + adminDTO.getNome_user()+ "'" +
                             " and a.sen_user = '" + adminDTO.getSen_user() + "'";

            //Executa o comando SQL no banco de Dados
            rs = null;
            rs = stmt.executeQuery(comando);
            if(rs.next()){
                return rs.getInt("id_user");
            }
            else{
                return 0;
            }
                
        } //Caso tenha algum erro no codigo acima é enviado uma mensagem no console com o que esta acontecendo.
        catch (Exception e) {
            System.out.println(e.getMessage());
            return 0;
        }
        finally{
            ConexaoDAO.CloseDB();
        }
    }//Fecha o método logarFuncionario
}

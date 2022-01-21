package br.com.asaid.dao;

import br.com.asaid.dto.ClienteDTO;
import java.sql.*;
import java.sql.ResultSet;
import java.sql.Statement;

public class ClienteDAO {

    public ClienteDAO() {
    }

    //Atributo do tipo ResultSet utilizado para realizar consultas
    private ResultSet rs = null;
    //Manipular o banco de dados
    private Statement stmt = null;

    /**
     * Método utilizado para inserir um objeto ClienteDTO no banco de dados
     *
     * @param ClienteDTO, que vem da classe ClienteCTR
     * @return Um boolean
     */
    public boolean inserirCliente(ClienteDTO clienteDTO) {
        try {
            //Chama o metodo que esta na classe ConexaoDAO para abrir o banco de dados
            ConexaoDAO.ConectDB();
            //Cria o Statement que responsavel por executar alguma coisa no banco de dados
            stmt = ConexaoDAO.con.createStatement();
            //Comando SQL que sera executado no banco de dados
            String comando = "Insert into cliente (tel_cliente, email_cliente, "
                    + "rg_cliente, nome_cliente) values ( "
                    + clienteDTO.getTel_cliente() + ", "
                    + "'" + clienteDTO.getEmail_cliente() + "', "
                    + "'" + clienteDTO.getRg_cliente() + "', "
                    + "'" + clienteDTO.getNome_cliente() + "')";

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
     * Método utilizado para excluir um objeto ClienteDTO no banco de dados
     *
     * @param ClienteDTO que vem da classe ClienteCTR
     * @return Um boolean
     */
    public boolean excluirCliente(ClienteDTO clienteDTO) {
        try {
            //Chama o metodo que esta na classe ConexaoDAO para abrir o banco de dados
            ConexaoDAO.ConectDB();
            //Cria o Statement que responsavel por executar alguma coisa no banco de dados
            stmt = ConexaoDAO.con.createStatement();
            //Comando SQL que sera executado no banco de dados
            String comando = "Delete from cliente where id_cliente = " + clienteDTO.getId_cliente();

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
    }//Fecha o método excluirCliente

    /**
     * Método utilizado para alterar um objeto ClienteDTO no banco de dados
     *
     * @param ClienteDTO, que vem da classe ClienteCTR
     * @return Um boolean
     */
    public boolean alterarCliente(ClienteDTO clienteDTO) {
        try {
            //Chama o metodo que esta na classe ConexaoDAO para abrir o banco de dados
            ConexaoDAO.ConectDB();
            //Cria o Statement que responsavel por executar alguma coisa no banco de dados
            stmt = ConexaoDAO.con.createStatement();
            //Comando SQL que sera executado no banco de dados
            String comando = "Update cliente set "
                    + "tel_cliente = " + clienteDTO.getTel_cliente() + ", "
                    + "email_cliente = '" + clienteDTO.getEmail_cliente() + "', "
                    + "rg_cliente = '" + clienteDTO.getRg_cliente() + "', "
                    + "nome_cliente = '" + clienteDTO.getNome_cliente() + "' "
                    + "where id_cliente = " + clienteDTO.getId_cliente();

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
    }//Fecha o método alterarCliente

    /**
     * Método utilizado para consultar um objeto clienteDTO no banco de dados
     *
     * @param clienteDTO, que vem da classe clienteCTR
     * @param opcao, que vem da classe clienteCTR
     * @return Um ResultSet com os dados do cliente
     */
    public ResultSet consultarCliente(ClienteDTO clienteDTO, int opcao) {
        try {
            //Chama o metodo que esta na classe ConexaoDAO para abrir o banco de dados
            ConexaoDAO.ConectDB();
            //Cria o Statement que responsavel por executar alguma coisa no banco de dados
            stmt = ConexaoDAO.con.createStatement();
            //Comando SQL que sera executado no banco de dados
            String comando = "";
            switch (opcao) {
                case 1:
                        comando = "Select c.* "
                                + "from cliente c "
                                + "where nome_cliente like '" + clienteDTO.getNome_cliente() + "%' "
                                + "order by c.nome_cliente";

                        break;
                    case 2:
                        comando = "Select c.* "
                                + "from cliente c "
                                + "where c.tel_cliente = '" + clienteDTO.getTel_cliente() + "'";
                        break;
                    case 3:
                        comando = "Select c.* "
                                + "from cliente c "
                                + "where c.email_cliente = '" + clienteDTO.getEmail_cliente() + "'";
                        break;
                    case 4:
                        comando = "Select c.* "
                            + "from cliente c "
                            + "where c.rg_cliente = '" + clienteDTO.getRg_cliente() + "'";
                        break;
                    case 5:
                        comando = "Select c.id_cliente, c.nome_cliente,  c.tel_cliente, c.email_cliente, c.rg_cliente "
                                + "from cliente c ";
                        break;
                    case 6:
                        comando = "Select c.* "
                                + "from cliente c "
                                + "where c.id_cliente = " + clienteDTO.getId_cliente();
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

}

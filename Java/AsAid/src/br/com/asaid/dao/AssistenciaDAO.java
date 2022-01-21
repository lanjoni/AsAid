/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.asaid.dao;

import br.com.asaid.dto.AssistenciaDTO;
import br.com.asaid.dto.ProdutoDTO;
import br.com.asaid.dto.ClienteDTO;
import java.sql.ResultSet;
import java.sql.Statement;

public class AssistenciaDAO {
    
    public AssistenciaDAO() {
    }

    //Atributo do tipo ResultSet utilizado para realizar consultas
    private ResultSet rs = null;
    //Manipular o banco de dados
    private Statement stmt = null;

    /**
     * Método utilizado para inserir um objeto AssistenciaDTO no banco de dados
     *
     * @param AssistenciaDAO, que vem da classe AssistenciaCTR
     * @return Um boolean
     */
    public boolean inserirAssistencia(AssistenciaDTO assistenciaDTO, ProdutoDTO produtoDTO, ClienteDTO clienteDTO) {
        try {
            //Chama o metodo que esta na classe ConexaoDAO para abrir o banco de dados
            ConexaoDAO.ConectDB();
            //Cria o Statement que responsavel por executar alguma coisa no banco de dados
            stmt = ConexaoDAO.con.createStatement();
            //Comando SQL que sera executado no banco de dados
            String comando = "Insert into assistencia (status, "
                    + "dathor_ent, obs_assist, id_produto, id_cliente) values ( "
                    + "'" + assistenciaDTO.getStatus() + "', "
                    + "to_date('" + assistenciaDTO.getDathor_ent() + "','DD/MM/YYYY'), "
                    + "'" + assistenciaDTO.getObs_assist() + "', "
                     + produtoDTO.getId_produto() + ", "
                    + clienteDTO.getId_cliente() + ")";

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
    }//Fecha o método inserirAssistencia

    /**
     * Método utilizado para excluir um objeto AssistenciaDTO no banco de dados
     *
     * @param AssistenciaDTO que vem da classe AssistenciaCTR
     * @return Um boolean
     */
    public boolean excluirAssistencia(AssistenciaDTO assistenciaDTO) {
        try {
            //Chama o metodo que esta na classe ConexaoDAO para abrir o banco de dados
            ConexaoDAO.ConectDB();
            //Cria o Statement que responsavel por executar alguma coisa no banco de dados
            stmt = ConexaoDAO.con.createStatement();
            //Comando SQL que sera executado no banco de dados
            String comando = "Delete from assistencia where id_assist = " + assistenciaDTO.getId_assist();

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
    }//Fecha o método excluirAssistencia

    /**
     * Método utilizado para alterar o status da assistencia
     *
     * @param AssistenciaDTO, que vem da classe AssistenciaCTR
     * @return Um boolean
     */
    public boolean atualizarStatusAssistencia(AssistenciaDTO assistenciaDTO) {
        try {
            //Chama o metodo que esta na classe ConexaoDAO para abrir o banco de dados
            ConexaoDAO.ConectDB();
            //Cria o Statement que responsavel por executar alguma coisa no banco de dados
            stmt = ConexaoDAO.con.createStatement();
            //Comando SQL que sera executado no banco de dados
            String comando = "Update assistencia set "
                    + "status = '" + assistenciaDTO.getStatus() + "', "
                    + "obs_assist = '" + assistenciaDTO.getObs_assist() + "' "
                    + "where id_assist = " + assistenciaDTO.getId_assist();

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
    public ResultSet consultarAssistencia(AssistenciaDTO assistenciaDTO,ProdutoDTO produtoDTO, ClienteDTO clienteDTO, int opcao) {
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
                            + "from assistencia a "
                            + "where a.id_assist " + assistenciaDTO.getId_assist();
                    break;
                case 2:
                    comando = "Select a.* "
                            + "from assistencia a "
                            + "where a.status = '" + assistenciaDTO.getStatus() + "'";
                    break;
                case 3:
                    comando = "Select a.* "
                            + "from assistencia a "
                            + "where a.dathor_ent= '" + assistenciaDTO.getDathor_ent() + "'";
                    break;
                case 4:
                    comando = "Select a.* "
                            + "from assistencia a "
                            + "where a.obs_assist = '" + assistenciaDTO.getObs_assist() + "'";
                    break;
                case 5:
                    comando = "Select a.* "
                            + "from assistencia a "
                            + "where a.id_produto = " + assistenciaDTO.getId_produto();
                    break;
                case 6:
                    comando = "Select a.* "
                            + "from assistencia a "
                            + "where a.id_cliente = " + assistenciaDTO.getId_cliente();
                    break;
                case 7:
                    comando = "Select a.id_assist, to_char(dathor_ent, 'DD/MM/YYYY') as data, "
                            + "a.status, p.cod_produto, c.nome_cliente "
                            + "from assistencia a, produto p, cliente c "
                            + "where a.id_produto = p.id_produto and "
                            + "a.id_cliente = c.id_cliente and "
                            + "p.cod_produto = " + produtoDTO.getCod_produto();
                    break;
                case 8:
                    comando = "Select a.id_assist, a.status, a.dathor_ent, a.obs_assist, a.id_produto, a.id_cliente  "
                            + "from assistencia a ";
                    break;
                case 9:
                    comando = "Select a.*, to_char(dathor_ent, 'DD/MM/YYYY') as data, "
                            + "p.cod_produto, c.nome_cliente "
                            + "from assistencia a, produto p, cliente c "
                            + "where a.id_produto = p.id_produto and "
                            + "a.id_cliente = c.id_cliente and "
                            + "a.id_assist = " + assistenciaDTO.getId_assist();

            }
            System.out.println(comando);
            //Executa o comando SQL no banco de Dados
            rs = stmt.executeQuery(comando);
            return rs;
        } //Caso tenha algum erro no codigo acima é enviado uma mensagem no console com o que esta acontecendo.
        catch (Exception e) {
            System.out.println(e.getMessage());
            return rs;
        }
    }//Fecha o método consultar produto
    
}

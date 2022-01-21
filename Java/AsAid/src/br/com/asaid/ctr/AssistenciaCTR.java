/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.asaid.ctr;

import java.sql.*;
import br.com.asaid.dto.AssistenciaDTO;
import br.com.asaid.dto.ProdutoDTO;
import br.com.asaid.dto.ClienteDTO;
import br.com.asaid.dao.AssistenciaDAO;
import br.com.asaid.dao.ConexaoDAO;

public class AssistenciaCTR {
    AssistenciaDAO assistenciaDAO = new AssistenciaDAO();

    /**
     * Método construtor da classe
     */
    public AssistenciaCTR() {
    }

    
    /**
     * Método utilizado para controlar o acesso ao método inserirAssistencia da classe
     * AssistenciaDAO
     *
     * @param AssistenciaDTO que vem da classe da página (VIEW)
     * @param produtoDTO  que vem da classe da página (VIEW)
     * @param clienteDTO que vem da classe da página (VIEW)
     * @return String contendo a mensagem
     */
    public String inserirAssistencia(AssistenciaDTO assistenciaDTO, ProdutoDTO produtoDTO, ClienteDTO clienteDTO) {
        try {
            //Chama o metodo que esta na classe DAO aguardando uma resposta (true ou false)
            if (assistenciaDAO.inserirAssistencia(assistenciaDTO, produtoDTO, clienteDTO )) {
                return "Assistencia Cadastrada com Sucesso!!!";
            } else {
                return "Assistencia NÃO Cadastrada!!!";
            }
        } //Caso tenha algum erro no codigo acima é enviado uma mensagem no console com o que esta acontecendo.
        catch (Exception e) {
            System.out.println(e.getMessage());
            return "Assistencia NÃO Cadastrada!!!";
        }
    }//Fecha o método inserirAssistencia

    
    /**
     * Método utilizado para controlar o acesso ao método alterarLocacao da classe
     * LocacaoDAO
     *
     * @param assistenciaDTO que vem da classe da página (VIEW)
     * @return String contendo a mensagem
     */
    public String atualizarStatusAssistencia(AssistenciaDTO assistenciaDTO) {
        try {
            //Chama o metodo que esta na classe DAO aguardando uma resposta (true ou false)
            if (assistenciaDAO.atualizarStatusAssistencia(assistenciaDTO)) {
                return "Status da Assistencia Alterado com Sucesso!!!";
            } else {
                return "Status da Assistencia NÃO Alterado!!!";
            }
        } //Caso tenha algum erro no codigo acima é enviado uma mensagem no console com o que esta acontecendo.
        catch (Exception e) {
            System.out.println(e.getMessage());
            return "Assistencia NÃO Alterado!!!";
        }
    }//Fecha o método alterarLocacao
    
             
    /**
     * Método utilizado para controlar o acesso ao método consultarAssistencia da
     * classe AssistenciaDAO
     *
     * @param assistenciaDTO, opcao que vem da classe da página (VIEW)
     * @param produtoDTO, opcao que vem da classe da página (VIEW)
     * * @param produtoDTO, opcao que vem da classe da página (VIEW)
     * @param opcao que vem da classe da página (VIEW)
     * @return ResultSet com os dados do locador
     */
    public ResultSet consultarAssistencia(AssistenciaDTO assistenciaDTO, ProdutoDTO produtoDTO, ClienteDTO clienteDTO, int opcao) {
        //É criado um atributo do tipo ResultSet, pois este método recebe o resultado de uma consulta.
        ResultSet rs = null;

        //O atributo rs recebe a consulta realizada pelo método da classe DAO
        rs = assistenciaDAO.consultarAssistencia(assistenciaDTO, produtoDTO, clienteDTO, opcao);

        return rs;
    }//Fecha o método consultarAssistencia

    public String excluirAssistencia(AssistenciaDTO assistenciaDTO) {
        try {
            if (assistenciaDAO.excluirAssistencia(assistenciaDTO)) {
                return "Assistência Excluida com Sucesso!!!";
            } else {
                return "Assistência NÃO Excluido!!!";
            }
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            return "Assistência NÃO Excluido!!!";
        }
    }

    /**
     * Método utilizado para controlar o acesso ao método CloseDB da classe
     * ConexaoDAO
     */
    public void CloseDB() {
        ConexaoDAO.CloseDB();
    }//Fecha o método CloseDB

}//fecha a classe AssistenciaCTR


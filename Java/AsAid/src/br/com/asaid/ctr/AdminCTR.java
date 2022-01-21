/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.asaid.ctr;

import java.sql.*;
import br.com.asaid.dto.AdminDTO;
import br.com.asaid.dao.AdminDAO;
import br.com.asaid.dao.ConexaoDAO;

public class AdminCTR {
   AdminDAO adminDAO = new AdminDAO();

    /**
     * Método construtor da classe
     */
    public AdminCTR() {
    }

    
    /**
     * Método utilizado para controlar o acesso ao método inserirFuncionario da classe
     * AdminDAO
     *
     * @param adminDTO que vem da classe da página (VIEW)
     * @return String contendo a mensagem
     */
    public String inserirAdmin(AdminDTO adminDTO) {
        try {
            //Chama o metodo que esta na classe DAO aguardando uma resposta (true ou false)
            if (adminDAO.inserirAdmin(adminDTO)) {
                return "Admin Cadastrado com Sucesso!!!";
            } else {
                return "Admin NÃO Cadastrado!!!";
            }
        } //Caso tenha algum erro no codigo acima é enviado uma mensagem no console com o que esta acontecendo.
        catch (Exception e) {
            System.out.println(e.getMessage());
            return "Admin NÃO Cadastrado!!!";
        }
    }//Fecha o método inserirAdmin

    
    /**
     * Método utilizado para controlar o acesso ao método alterarAdmin da classe
     * AdminDAO
     *
     * @param AdminDTO que vem da classe da página (VIEW)
     * @return String contendo a mensagem
     */
    public String alterarAdmin(AdminDTO adminDTO) {
        try {
            //Chama o metodo que esta na classe DAO aguardando uma resposta (true ou false)
            if (adminDAO.alterarAdmin(adminDTO)) {
                return "Admin Alterado com Sucesso!!!";
            } else {
                return "Admin NÃO Alterado!!!";
            }
        } //Caso tenha algum erro no codigo acima é enviado uma mensagem no console com o que esta acontecendo.
        catch (Exception e) {
            System.out.println(e.getMessage());
            return "Admin NÃO Alterado!!!";
        }
    }//Fecha o método alterarAdmin
    
        
    /**
     * Método utilizado para controlar o acesso ao método excluirAdmin da classe
     * AdminDAO
     *
     * @param AdminDTO que vem da classe da página (VIEW)
     * @return String contendo a mensagem
     */
    public String excluirAdmin(AdminDTO adminDTO) {
        try {
            if (adminDAO.excluirAdmin(adminDTO)) {
                return "Admin Excluido com Sucesso!!!";
            } else {
                return "Admin NÃO Excluido!!!";
            }
        } //Caso tenha algum erro no codigo acima é enviado uma mensagem no console com o que esta acontecendo.
        catch (Exception e) {
            System.out.println(e.getMessage());
            return "Admin NÃO Excluido!!!";
        }
    }//Fecha o método excluirFuncionario

     
    /**
     * Método utilizado para controlar o acesso ao método consultarAdmin da
     * classe AdminDAO
     *
     * @param AdminDTO, opcao que vem da classe da página (VIEW)
     * @param opcao que vem da classe da página (VIEW)
     * @return ResultSet com os dados do Admin
     */
    public ResultSet consultarAdmin(AdminDTO adminDTO, int opcao) {
        //É criado um atributo do tipo ResultSet, pois este método recebe o resultado de uma consulta.
        ResultSet rs = null;

        //O atributo rs recebe a consulta realizada pelo método da classe DAO
        rs = adminDAO.consultarAdmin(adminDTO, opcao);

        return rs;
    }//Fecha o método consultarAdmin

    public int logarAdmin(AdminDTO adminDTO) {
        
        return adminDAO.logarAdmin(adminDTO);

    }
    
    
    /**
     * Método utilizado para controlar o acesso ao método CloseDB da classe
     * ConexaoDAO
     */
    public void CloseDB() {
        ConexaoDAO.CloseDB();
    }//Fecha o método CloseDB

}//fecha a classe AdminCTR


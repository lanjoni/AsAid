/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.asaid.dto;

public class AssistenciaDTO {
    private int id_assist, id_produto, id_cliente;
            private String dathor_ent, status, obs_assist;

            
             public AssistenciaDTO (){
    }
    /**
     * @return the id_assist
     */
    public int getId_assist() {
        return id_assist;
    }

    /**
     * @param id_assist the id_assist to set
     */
    public void setId_assist(int id_assist) {
        this.id_assist = id_assist;
    }

    /**
     * @return the status
     */
    public String getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * @return the dathor_ent
     */
    public String getDathor_ent() {
        return dathor_ent;
    }

    /**
     * @param dathor_ent the dathor_ent to set
     */
    public void setDathor_ent(String dathor_ent) {
        this.dathor_ent = dathor_ent;
    }

    /**
     * @return the id_produto
     */
    public int getId_produto() {
        return id_produto;
    }

    /**
     * @param id_produto the id_produto to set
     */
    public void setId_produto(int id_produto) {
        this.id_produto = id_produto;
    }

    /**
     * @return the id_cliente
     */
    public int getId_cliente() {
        return id_cliente;
    }

    /**
     * @param id_cliente the id_cliente to set
     */
    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    /**
     * @return the obs_assist
     */
    public String getObs_assist() {
        return obs_assist;
    }

    /**
     * @param obs_assist the obs_assist to set
     */
    public void setObs_assist(String obs_assist) {
        this.obs_assist = obs_assist;
    }
}




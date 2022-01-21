/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.asaid.dto;

public class ClienteDTO {
    private int id_cliente;
    private String email_cliente, rg_cliente, nome_cliente, tel_cliente;
    
    
    public ClienteDTO (){
    }
    
    public ClienteDTO (int id_cliente, String nome_cliente){
        this.id_cliente = id_cliente;
        this.nome_cliente = nome_cliente;
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

    public String getNome_cliente() {
        return nome_cliente;
    }

    /**
     * @param email_cliente the email_cliente to set
     */
    public void setNome_cliente(String nome_cliente) {
        this.nome_cliente = nome_cliente;
    }
    
    /**
     * @return the tel_cliente
     */
    public String getTel_cliente() {
        return tel_cliente;
    }

    /**
     * @param tel_cliente the tel_cliente to set
     */
    public void setTel_cliente(String tel_cliente) {
        this.tel_cliente = tel_cliente;
    }

    /**
     * @return the email_cliente
     */
    public String getEmail_cliente() {
        return email_cliente;
    }

    /**
     * @param email_cliente the email_cliente to set
     */
    public void setEmail_cliente(String email_cliente) {
        this.email_cliente = email_cliente;
    }

    /**
     * @return the rg_cliente
     */
    public String getRg_cliente() {
        return rg_cliente;
    }

    /**
     * @param rg_cliente the rg_cliente to set
     */
    public void setRg_cliente(String rg_cliente) {
        this.rg_cliente = rg_cliente;
    }
}


 
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.asaid.dto;

public class AdminDTO {

    private int id_user;
    private String sen_user, nome_user;
    
     public AdminDTO (){
    }

    /**
     * @return the id_user
     */
    public int getId_user() {
        return id_user;
    }

    /**
     * @param id_user the id_user to set
     */
    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    /**
     * @return the sen_user
     */
    public String getSen_user() {
        return sen_user;
    }

    /**
     * @param sen_user the sen_user to set
     */
    public void setSen_user(String sen_user) {
        this.sen_user = sen_user;
    }

    /**
     * @return the nome_user
     */
    public String getNome_user() {
        return nome_user;
    }

    /**
     * @param nome_user the nome_user to set
     */
    public void setNome_user(String nome_user) {
        this.nome_user = nome_user;
    }
}

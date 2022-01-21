/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.asaid.dto;

public class ProdutoDTO{
    private int id_produto, cod_produto;
    private String desc_produto, senha_produto, status_produto, tipo_produto;

    
    public ProdutoDTO(){
    }
    
    public ProdutoDTO(int id_produto, int cod_produto){
        this.id_produto = id_produto;
        this.cod_produto = cod_produto;
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
     * @return the cod_produto
     */
    public int getCod_produto() {
        return cod_produto;
    }

    
    public void setCod_produto(int cod_produto) {
        this.cod_produto = cod_produto;
    }
    
    public String getTipo_produto() {
        return tipo_produto;
    }

    
    public void setTipo_produto(String tipo_produto) {
        this.tipo_produto = tipo_produto;
    }

   public String getStatus_produto() {
        return status_produto;
    }

    
    public void setStatus_produto(String status_produto) {
        this.status_produto = status_produto;
    }
    
    /**
     * @return the desc_produto
     */
    public String getDesc_produto() {
        return desc_produto;
    }

    /**
     * @param desc_produto the desc_produto to set
     */
    public void setDesc_produto(String desc_produto) {
        this.desc_produto = desc_produto;
    }

    /**
     * @return the senha_produto
     */
    public String getSenha_produto() {
        return senha_produto;
    }

    /**
     * @param senha_produto the senha_produto to set
     */
    public void setSenha_produto(String senha_produto) {
        this.senha_produto = senha_produto;
    }

}



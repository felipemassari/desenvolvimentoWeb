/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ufabc.ecommerce.model;

/**
 *
 * @author francisco.massetto
 */
public class ItemCarrinho implements java.io.Serializable{
    private Produto produto;
    private float   qtde;

    /**
     * @return the produto
     */
    public Produto getProduto() {
        return produto;
    }

    /**
     * @param produto the produto to set
     */
    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    /**
     * @return the qtde
     */
    public float getQtde() {
        return qtde;
    }

    /**
     * @param qtde the qtde to set
     */
    public void setQtde(float qtde) {
        this.qtde = qtde;
    }
    
    
}

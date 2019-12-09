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
public class Produto implements java.io.Serializable {
    private int id;
    private String titulo;
    private String descricao;
    private float  preco;
    private String categoria;
    private String urlFoto1;
    private String urlFoto2;
    private String urlFoto3;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public float getPreco() {
        return preco;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getUrlFoto1() {
        return urlFoto1;
    }

    public void setUrlFoto1(String urlFoto1) {
        this.urlFoto1 = urlFoto1;
    }

    public String getUrlFoto2() {
        return urlFoto2;
    }

    public void setUrlFoto2(String urlFoto2) {
        this.urlFoto2 = urlFoto2;
    }

    public String getUrlFoto3() {
        return urlFoto3;
    }

    public void setUrlFoto3(String urlFoto3) {
        this.urlFoto3 = urlFoto3;
    }
    
    
}

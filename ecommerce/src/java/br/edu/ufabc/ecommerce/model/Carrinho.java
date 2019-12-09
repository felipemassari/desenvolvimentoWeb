/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ufabc.ecommerce.model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author francisco.massetto
 */
public class Carrinho {
    private float total;
    private ArrayList<ItemCarrinho> itens;
    
    public Carrinho(){
        itens = new ArrayList<>();
        total = 0.00f;                
    }
    
    public void add(Produto produto, float qtde){
        ItemCarrinho it = new ItemCarrinho();
        it.setProduto(produto);
        it.setQtde(qtde);
        
        itens.add(it);
        total+= it.getProduto().getPreco() * qtde;
    }
    public void remover(int idProduto){
        ItemCarrinho item=null;
        float qtde=0;
        for (ItemCarrinho it : itens){
            if (it.getProduto().getId() == idProduto){
                item = it;
                qtde = it.getQtde();
                break;
            }
        }
        total -= item.getProduto().getPreco() * qtde;
        itens.remove(item);
    }
    
    public void limpar(){
           this.itens.clear();
           this.total = 0;
    }
    
    public float getTotal(){
        return this.total;
    }
    public List<ItemCarrinho> getItens(){
        return this.itens;
    }
    
}

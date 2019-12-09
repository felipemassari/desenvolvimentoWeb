/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ufabc.ecommerce.dao;

import br.edu.ufabc.ecommerce.model.Produto;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author francisco.massetto
 */
public class ProdutoDAO implements GenericDAO{ 
    
    DataSource dataSource;
    
    public ProdutoDAO(DataSource dataSource){
        this.dataSource = dataSource;
    }

    @Override
    public void create(Object o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Object o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(Object o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Object> read() {
        List<Object> result = null;
        try{
            String sql = "SELECT * FROM tblProduto";
            PreparedStatement stm = dataSource.getConnection().prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            result = new ArrayList<>();
            while (rs.next()){
                Produto p= new Produto();
                p.setId(rs.getInt("idProd")); // aqui é o nome da coluna na tablea
                p.setTitulo(rs.getString("titulo"));
                p.setDescricao(rs.getString("descricao"));
                p.setPreco(rs.getFloat("preco"));
                p.setCategoria(rs.getString("categoria"));
                p.setUrlFoto1(rs.getString("urlFoto1"));
                p.setUrlFoto2(rs.getString("urlFoto2"));
                p.setUrlFoto3(rs.getString("urlFoto3"));
                result.add(p);
            }
            rs.close();
            stm.close();
        }
        catch(Exception ex){
            System.out.println("PRODUTODAO.READ - erro ao recuperar");
            System.out.println(ex.getMessage());
        }
        return result;
    }
    
    
   
    public List<Object> read(int id) {
        List<Object> result = null;
        try{
            String sql = "SELECT * FROM tblProduto WHERE idProd=?";
            PreparedStatement stm = dataSource.getConnection().prepareStatement(sql);
            stm.setInt(1, id);
            ResultSet rs = stm.executeQuery();
            result = new ArrayList<>();
            while (rs.next()){
                Produto p= new Produto();
                p.setId(rs.getInt("idProd")); // aqui é o nome da coluna na tablea
                p.setTitulo(rs.getString("titulo"));
                p.setDescricao(rs.getString("descricao"));
                p.setPreco(rs.getFloat("preco"));
                p.setCategoria(rs.getString("categoria"));
                p.setUrlFoto1(rs.getString("urlFoto1"));
                p.setUrlFoto2(rs.getString("urlFoto2"));
                p.setUrlFoto3(rs.getString("urlFoto3"));
                result.add(p);
            }
            rs.close();
            stm.close();
        }
        catch(Exception ex){
            System.out.println("PRODUTODAO.READ - erro ao recuperar");
            System.out.println(ex.getMessage());
        }
        return result;
    }
    
    
}

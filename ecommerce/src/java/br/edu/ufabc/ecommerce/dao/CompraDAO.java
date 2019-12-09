/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ufabc.ecommerce.dao;

import br.edu.ufabc.ecommerce.model.Carrinho;
import br.edu.ufabc.ecommerce.model.Cliente;
import br.edu.ufabc.ecommerce.model.Produto;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Felipe
 */
public class CompraDAO implements GenericDAO {
    
    DataSource dataSource;
    
    public CompraDAO(DataSource dataSource){
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public boolean comprar(String status, int clienteId, float valorBruto, float desconto, float valorTotal, Carrinho carrinho) {
        try {
            System.out.println("Comprar");
            String SQLinsertCompra = "INSERT INTO tblCompra values (null, null, ?, ?, ?, ?, ?)";
            PreparedStatement stmCompra = dataSource.getConnection().prepareStatement(SQLinsertCompra, Statement.RETURN_GENERATED_KEYS);
            stmCompra.setString(1, status);
            stmCompra.setInt(2, clienteId);
            stmCompra.setFloat(3, valorBruto);
            stmCompra.setFloat(4, desconto);
            stmCompra.setFloat(5, valorTotal);
            
            int idCompra = stmCompra.executeUpdate();
            if (idCompra == 0) {
                throw new RuntimeException("Falha ao inserir - registros duplicados");
            }
            
            for (int i = 0; i < carrinho.getItens().size(); i++) {
                String SQLinsertPedido = "INSERT INTO tblPedido values(?, ?)";
                PreparedStatement stmPedido = dataSource.getConnection().prepareStatement(SQLinsertPedido, Statement.RETURN_GENERATED_KEYS);
                stmPedido.setInt(1, idCompra);
                stmPedido.setInt(2, carrinho.getItens().get(i).getProduto().getId());
                stmPedido.executeUpdate();
            }
            
            return true;
    } catch (Exception ex) {
        System.out.println(ex);
        return false;
    }
    }
    
}

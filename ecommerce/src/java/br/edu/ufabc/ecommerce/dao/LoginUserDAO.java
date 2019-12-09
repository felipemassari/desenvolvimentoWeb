/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ufabc.ecommerce.dao;

import br.edu.ufabc.ecommerce.model.Cliente;
import br.edu.ufabc.ecommerce.model.Endereco;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;


/**
 *
 * @author Felipe
 */
public class LoginUserDAO implements GenericDAO{
    
    private DataSource dataSource;
    
    public LoginUserDAO(DataSource dataSource) {
        this.dataSource = dataSource;
    }
       
    public  Cliente checkUser(String email,String senha) 
    {
        try {
            
            PreparedStatement ps = dataSource.getConnection().prepareStatement("select * from tblCliente where email=? and senha=?");
            
            ps.setString(1, email);
            ps.setString(2, senha);
            ResultSet rs = ps.executeQuery();
            
            if (rs.next()){
                Cliente cli = new Cliente(rs.getInt("iduser"), rs.getString("email"), rs.getString("nome"));
                return cli;
            }
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        return null;                 
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

}

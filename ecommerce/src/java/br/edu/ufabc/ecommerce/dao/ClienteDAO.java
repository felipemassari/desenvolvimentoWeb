/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ufabc.ecommerce.dao;

import br.edu.ufabc.ecommerce.model.Cliente;
import br.edu.ufabc.ecommerce.model.Endereco;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

/**
 *
 * @author francisco.massetto
 */
public class ClienteDAO implements GenericDAO {

    private DataSource dataSource;

    public ClienteDAO(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public void create(Object o) {
        try {
            Cliente c = (Cliente) o;

            String SQLuser = "INSERT INTO tblCliente values (null, ?, ?, ?)";
            PreparedStatement stm = dataSource.getConnection().prepareStatement(SQLuser, Statement.RETURN_GENERATED_KEYS);
            stm.setString(1, c.getNome());
            stm.setString(2, c.getEmail());
            stm.setString(3, c.getSenha());

            int result = stm.executeUpdate();

            if (result == 0) {
                throw new RuntimeException("Falha ao inserir - registros duplicados");
            }

            String SQLend = "INSERT INTO tblendereco values (null, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement stmEnd = dataSource.getConnection().prepareStatement(SQLend, Statement.RETURN_GENERATED_KEYS);
            ResultSet rs = stm.getGeneratedKeys();
            
            if (rs.next()) {
                c.setId(rs.getInt(1));
                for (Endereco e : c.getEnderecos()) {
                    e.setCliente(c);
                    stmEnd = dataSource.getConnection().prepareStatement(SQLend);
                    stmEnd.setString(1, e.getTipoLogradouro());
                    stmEnd.setString(2, e.getLogradouro());
                    stmEnd.setString(3, e.getNumero());
                    stmEnd.setString(4, e.getComplemento());
                    stmEnd.setString(5, e.getCep());
                    stmEnd.setString(6, e.getCidade());
                    stmEnd.setString(7, e.getBairro());
                    stmEnd.setString(8, e.getEstado());
                    stmEnd.setInt(9, e.getCliente().getId());
                    stmEnd.executeUpdate();
                }
            }
            rs.close();
            stm.close();

        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println(ex);
        }

    }

    @Override
    public void delete(Object o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(Object o) {
        try {

            Cliente upCli = (Cliente) o;
            int id = upCli.getId();
            String SQLupdateUser = "UPDATE tblCliente SET (null, ?, ?, ?) WHERE idUser=" + id;
            PreparedStatement updataUser = dataSource.getConnection().prepareStatement(SQLupdateUser);
            updataUser.setString(1, upCli.getNome());
            updataUser.setString(2, upCli.getEmail());
            updataUser.setString(3, upCli.getSenha());
            
            int result = updataUser.executeUpdate();

            if (result == 0) {
                throw new RuntimeException("Falha ao inserir - registros duplicados");
            }

            int idCliEnd = upCli.getId();
            String SQLupdateEnd = "UPDATE tblendereco SET (null, ?, ?, ?, ?, ?, ?, ?, ?, ?) WHERE cliente=" + idCliEnd;
            PreparedStatement updateEnd = dataSource.getConnection().prepareStatement(SQLupdateEnd);
            
            if (upCli != null) {
                for (Endereco e : upCli.getEnderecos()) {
                    e.setCliente(upCli);
                    updateEnd = dataSource.getConnection().prepareStatement(SQLupdateEnd);
                    updateEnd.setString(1, e.getTipoLogradouro());
                    updateEnd.setString(2, e.getLogradouro());
                    updateEnd.setString(3, e.getNumero());
                    updateEnd.setString(4, e.getComplemento());
                    updateEnd.setString(5, e.getCep());
                    updateEnd.setString(6, e.getCidade());
                    updateEnd.setString(7, e.getBairro());
                    updateEnd.setString(8, e.getEstado());
                    updateEnd.setInt(9, e.getCliente().getId());
                    updateEnd.executeUpdate();
                }
            }
            updataUser.close();

        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println(ex);
        }

    }

    @Override
    public List<Object> read() {

        /*String SQLuser = "INSERT INTO tblusuario values (null, ?, ?, ?)";
        PreparedStatement stm = dataSource.getConnection().prepareStatement(SQLuser, Statement.RETURN_GENERATED_KEYS);
        stm.setString(1, c.getNome());*/
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}

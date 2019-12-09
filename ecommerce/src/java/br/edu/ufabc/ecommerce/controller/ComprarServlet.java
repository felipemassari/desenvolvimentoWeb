package br.edu.ufabc.ecommerce.controller;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import br.edu.ufabc.ecommerce.dao.CompraDAO;
import br.edu.ufabc.ecommerce.dao.DataSource;
import br.edu.ufabc.ecommerce.model.Carrinho;
import br.edu.ufabc.ecommerce.model.Cliente;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Felipe
 */
public class ComprarServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        Cliente clienteAtual = new Cliente();
        Carrinho carrinho = new Carrinho();
        try {
            if (((Cliente) request.getSession().getAttribute("Cliente")).getNome() != null) {
                clienteAtual = (Cliente) request.getSession().getAttribute("Cliente");
            } else {
                response.sendRedirect("/ecommerce/login.jsp");
            }
            carrinho = (Carrinho) request.getSession().getAttribute("Carrinho");            

            if (carrinho == null) {
                carrinho = new Carrinho();
            }
            DataSource ds = new DataSource();
            CompraDAO dao = new CompraDAO(ds);

            dao.comprar("Em envio", clienteAtual.getId(), carrinho.getTotal(), 0, carrinho.getTotal(), carrinho);
            
            System.out.println("comprarservlet");

        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println(ex);
        }
        finally {            
            try {
                System.out.println("request sucesso");
                RequestDispatcher rs = request.getRequestDispatcher("/sucesso.jsp");
                carrinho.limpar();
                rs.include(request, response);
                
            } catch (Exception ex) {
                System.out.println(ex);
            }
        }
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ufabc.ecommerce.controller;

import br.edu.ufabc.ecommerce.dao.DataSource;
import br.edu.ufabc.ecommerce.dao.GenericDAO;
import br.edu.ufabc.ecommerce.dao.ProdutoDAO;
import br.edu.ufabc.ecommerce.model.Cliente;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author francisco.massetto
 */
public class DetalheProdutoServlet extends HttpServlet {

   
   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        try{
            DataSource ds = new DataSource();
            ProdutoDAO dao = new ProdutoDAO(ds);
            List<Object> lista = dao.read(Integer.parseInt(request.getParameter("id")));
            ds.getConnection().close();
            Cliente clienteAtual = new Cliente();
            if (request.getSession().getAttribute("Cliente") != null) {
                clienteAtual = (Cliente) request.getSession().getAttribute("Cliente");
            } 
            if (!lista.isEmpty()){
                RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/detalheprod.jsp");
                request.getSession().setAttribute("DetalheProduto",lista.get(0));
                request.getSession().setAttribute("Cliente", clienteAtual);
                dispatcher.forward(request, response);
            }
            
        }
        catch(Exception ex){
            
        }
    }

  
}

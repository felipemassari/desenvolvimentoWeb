/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ufabc.ecommerce.controller;

import br.edu.ufabc.ecommerce.model.Carrinho;
import br.edu.ufabc.ecommerce.model.ItemCarrinho;
import br.edu.ufabc.ecommerce.model.Produto;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author francisco.massetto
 */
public class AdicionarCarrinhoServlet extends HttpServlet {

   
   

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
           throws ServletException, IOException {
        Carrinho carrinho;
        carrinho = (Carrinho)request.getSession().getAttribute("Carrinho");
        if (carrinho == null){
            carrinho = new Carrinho();
        }
        Produto produto = (Produto)request.getSession().getAttribute("DetalheProduto");
        float qtde = Float.parseFloat(request.getParameter("txtQtde"));
        carrinho.add(produto,qtde);
        request.getSession().setAttribute("Carrinho", carrinho);
        
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/carrinho.jsp");
        dispatcher.forward(request,response);            
    }
}

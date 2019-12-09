/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ufabc.ecommerce.controller;

import br.edu.ufabc.ecommerce.dao.LoginUserDAO;
import br.edu.ufabc.ecommerce.dao.DataSource;
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
public class LoginServlet extends HttpServlet {
    
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        String email = request.getParameter("txtEmail");        
        String senha = request.getParameter("txtSenha");
        DataSource ds = new DataSource();
        LoginUserDAO ldao = new LoginUserDAO(ds);
        Cliente cli = ldao.checkUser(email, senha);
        
        if(cli != null)
        {
            request.getSession().setAttribute("Cliente", cli);
            response.sendRedirect("/ecommerce"); 
        }
        else
        {
           RequestDispatcher rs = request.getRequestDispatcher("/erro.jsp");
           rs.include(request, response);
        }
    }  
    
    
}

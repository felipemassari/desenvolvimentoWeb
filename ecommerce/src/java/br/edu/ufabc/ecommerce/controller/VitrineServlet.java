package br.edu.ufabc.ecommerce.controller;

import br.edu.ufabc.ecommerce.dao.DataSource;
import br.edu.ufabc.ecommerce.dao.GenericDAO;
import br.edu.ufabc.ecommerce.dao.ProdutoDAO;
import br.edu.ufabc.ecommerce.model.Cliente;
import br.edu.ufabc.ecommerce.model.Produto;
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
public class VitrineServlet extends HttpServlet {

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/vitrine.jsp");
            /* business logic */
            DataSource ds = new DataSource();
            GenericDAO dao = new ProdutoDAO(ds);
            List<Object> lista = dao.read();
            ds.getConnection().close();
            System.out.println("Tamanho da lista = " + lista.size());
            request.getSession().setAttribute("Lista", lista);
            Cliente clienteAtual = new Cliente();
            if (request.getSession().getAttribute("Cliente") != null) {
                clienteAtual = (Cliente) request.getSession().getAttribute("Cliente");
            } 
            request.getSession().setAttribute("Cliente", clienteAtual);
            

            dispatcher.forward(request, response);
        } catch (Exception ex) {

        }

    }

}

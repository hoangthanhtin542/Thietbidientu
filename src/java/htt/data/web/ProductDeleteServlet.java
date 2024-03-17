/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package htt.data.web;

import htt.data.dao.ProductDao;
import htt.data.impl.ProductImpl;
import htt.data.model.Product;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.List;

/**
 *
 * @author Admin
 */
@WebServlet(name = "productDelete", urlPatterns = {"/productDelete"})
public class ProductDeleteServlet extends HttpServlet {

 
       
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            String $id = request.getParameter("pid");
            ProductImpl productI = new ProductImpl();
              PrintWriter out = response.getWriter();

            String a  = productI.deleteP($id);
            out.println("<p>Message: " + a + "</p>");

          
//          request.setAttribute("title", "Admin");
response.sendRedirect(request.getHeader("referer"));
    }

 
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package htt.data.web;

import htt.data.dao.ProductDao;
import htt.data.impl.CategoryImpl;
import htt.data.impl.ProductImpl;
import htt.data.model.Category;
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
@WebServlet(name = "AdminServlet", urlPatterns = {"/admin"})
public class AdminServlet extends HttpServlet {

 
       
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
            ProductImpl productI = new ProductImpl();
            CategoryImpl categoryI = new CategoryImpl();
            List<Product> listP = productI.findAll();
            List<Category> ListC = categoryI.findAll();
          request.setAttribute("title", "Admin");
          request.setAttribute("data", listP);
                    request.setAttribute("category", ListC);

        request.getRequestDispatcher("./views/admin.jsp").include(request, response);
    }

 
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

}

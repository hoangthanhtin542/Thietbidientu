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
@WebServlet(name = "productAdd", urlPatterns = {"/productAdd"})
public class ProductAddServlet extends HttpServlet {

 
       
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            String $name = request.getParameter("name");
            String $image = request.getParameter("image");
            String $price = request.getParameter("price");
            String $quality = request.getParameter("qty");
            String $title = request.getParameter("title");
            String $description = request.getParameter("description");
            String $category = request.getParameter("category");

            ProductImpl productI = new ProductImpl();
            productI.addProduct($name,$image,$price,$quality,$title,$description,$category);
          response.sendRedirect(request.getHeader("referer"));
    }

 
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            String $name = request.getParameter("name");
            String $image = request.getParameter("image");
            String $price = request.getParameter("price");
            String $quality = request.getParameter("qty");
            String $title = request.getParameter("title");
            String $description = request.getParameter("description");
            String $category = request.getParameter("category");

            ProductImpl productI = new ProductImpl();
            String a = productI.addProduct($name,$image,$price,$quality,$title,$description,$category);
                          PrintWriter out = response.getWriter();

//            out.println("<p>Message: " + a + "</p>");
            response.sendRedirect(request.getHeader("referer"));
    }

}

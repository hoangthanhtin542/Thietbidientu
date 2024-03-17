/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package htt.data.web;

import htt.data.model.Product;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.List;

/**
 *
 * @author Admin
 */
public class CartServlet extends HttpServlet {


    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setAttribute("title", "Cart Detail");
        request.getRequestDispatcher("./views/cart.jsp").include(request, response);
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        updateDelete(request, response);
    }
    void updateDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        String action = request.getParameter("action");
        int id_product = Integer.parseInt(request.getParameter("id_product"));
        switch(action){
            case "update":
                doUpdate(request, id_product); break;
            case "Delete":
                doDelete(request, id_product); break; 
                    
        }
        request.getRequestDispatcher("./views/cart.jsp").include(request, response);
    }
    void doUpdate(HttpServletRequest request, int id_product){
        List<Product> cart = (List<Product>)request.getSession().getAttribute("cart");
        int qty = Integer.parseInt(request.getParameter("qty"));
        for(Product pro: cart)
            if(pro.getId() == id_product && qty>0){
              pro.setQty(qty); break;
    }
        request.getSession().setAttribute("cart", cart);
    }
     void doDelete(HttpServletRequest request, int id_product){
        List<Product> cart = (List<Product>)request.getSession().getAttribute("cart");
        
        for(Product pro: cart)
            if(pro.getId() == id_product){
              cart.remove(pro); break;
    }
        request.getSession().setAttribute("cart", cart);
    }
}

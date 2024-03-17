package htt.data.web;


import java.io.IOException;
import java.util.List;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import htt.data.dao.Database;
import htt.data.model.Category;
import htt.data.model.Product;
import java.util.ArrayList;

public class HomeServlet extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse resp) 
            throws ServletException, IOException {
        List<Category> listCategory = Database.getCategoryDao().findAll();
        request.setAttribute("lstCategory", listCategory);
        List<Product> listProduct = Database.getProductDao().findAll();
        request.setAttribute("lstProduct", listProduct);
        String id_category = (String)request.getParameter("id_category");
        request.setAttribute("id_category", id_category);
        addProductToCart(request);
        request.setAttribute("title", "Home Page");
        request.getRequestDispatcher("./views/home.jsp").include(request, resp);
    }
        void addProductToCart(HttpServletRequest request ){
            int id_product;
            try{
            id_product = Integer.parseInt(request.getParameter("id_product"));
        }catch(Exception e){
            id_product = 0;
        }
            List<Product> cart = (List<Product>) request.getSession().getAttribute("cart");
            if (cart == null) cart = new ArrayList<>();
            if(id_product>0){
                Product product = Database.getProductDao().finProduct(id_product);
                boolean isProductInCart=false;
                for(Product pro: cart)
                    if(pro.getId()==id_product){
                        pro.setQty(pro.getQty()+1);
                        isProductInCart=true;  
                    }
                if(!isProductInCart)cart.add(product);
            }
            request.getSession().setAttribute("cart", cart);
        }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse response) 
            throws ServletException, IOException {
       
    }
    
    
}
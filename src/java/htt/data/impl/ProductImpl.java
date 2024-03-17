/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package htt.data.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import htt.data.dao.ProductDao;
import htt.data.driver.MySQLDriver;
import htt.data.model.Product;

/**
 *
 * @author Admin
 */
public class ProductImpl implements ProductDao{
    Connection con = MySQLDriver.getConnection();
    @Override
    public List<Product> findAll() {
        List<Product> listProduct = new ArrayList<>(); //Tạo biến lưu trữ danh sách Category
        String sql = "select * from products"; //Câu lệnh truy vấn
        try {
            PreparedStatement sttm = con.prepareStatement(sql); 
            ResultSet rs = sttm.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String image = rs.getString("image");
                double price = rs.getDouble("price");
                int quantity = rs.getInt("quantity");
                boolean status = rs.getBoolean("status");
                int id_category = rs.getInt("id_category");
                listProduct.add(new Product(id, name,image, price, quantity, status, id_category));
            }
        } catch (SQLException ex) {
            Logger.getLogger(CategoryImpl.class.getName()).log(Level.SEVERE, null, ex);
        }

        return listProduct;
    }
    @Override
    public Product finProduct(int id_product){
        String sql = "select * from products where id="+id_product;
        PreparedStatement sttm;
        try {
            sttm = con.prepareStatement(sql);
            ResultSet rs = sttm.executeQuery();
            if(rs.next()) return new Product(rs);
        } catch (SQLException ex) {
            Logger.getLogger(ProductImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public String addProduct(String $name,String $img,String $price,String $qty,String $title,String $des,String $cate){
        String sql = "INSERT INTO `products`(`name`,`image`, `price`,`quantity`,`status`,`id_category`) VALUES (?,?,?,?,?,?);";
        PreparedStatement sttm;
        try {
            sttm = con.prepareStatement(sql);
                    sttm.setString(1,$name);
                    sttm.setString(2,$img);
                    sttm.setString(3,$price);
                    sttm.setString(4,$qty);
                    sttm.setString(5,"1");
                    sttm.setString(6,$cate);

           sttm.executeUpdate();
        } catch (SQLException ex) {
            return ex.toString();
//            Logger.getLogger(ProductImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public String deleteP(String id_product){
        String sql = "delete from `products` where `id`="+id_product;
        
        PreparedStatement sttm;
        try {
            sttm = con.prepareStatement(sql);
            sttm.executeUpdate();
            return "ok";
         
        } catch (SQLException ex) {
            return ex.toString();
//            Logger.getLogger(ProductImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
//        return null;
    }
 
   
    
}

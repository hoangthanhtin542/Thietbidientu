/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package htt.data.model;

import java.sql.ResultSet;
import java.sql.SQLException;


public class Product {
    private int id;
    private String name;
    private String image;
    private double price;
    private int quantity;
    private boolean status;
    private int id_category;

    public Product(int id, String name, String image, double price, int qty, boolean status, int id_category) {
        this.id = id;
        this.name = name;
        this.image = image;
        this.price = price;
        this.quantity = qty;
        this.status = status;
        this.id_category = id_category;
    }
    public Product (ResultSet rs) throws SQLException{
        this.id = rs.getInt("id");
        this.name = rs.getString("name");
        this.image = rs.getString("image");
        this.price = rs.getDouble("price");
        this.quantity = 1;

        
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQty() {
        return quantity;
    }

    public void setQty(int qty) {
        this.quantity = qty;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public int getId_category() {
        return id_category;
    }

    public void setId_category(int id_category) {
        this.id_category = id_category;
    }
    
}

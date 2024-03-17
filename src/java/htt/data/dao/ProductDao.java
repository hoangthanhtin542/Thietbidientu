/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package htt.data.dao;

import java.util.List;
import htt.data.model.Product;

/**
 */
public interface ProductDao {
    public List<Product> findAll();
    public Product finProduct(int id_product);
}

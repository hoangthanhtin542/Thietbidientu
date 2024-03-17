/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package htt.data.dao;

import htt.data.model.User;

/**

 */
public interface UserDao {
    public User findUser(String email, String password);
    public User findUser(String emailphone);
    public void insertUser(String name, String email, String phone, String password);
}
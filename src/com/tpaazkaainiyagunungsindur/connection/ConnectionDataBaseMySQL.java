/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tpaazkaainiyagunungsindur.connection;

/**
 *
 * @author indrasudirman
 */

import java.sql.*;

public class ConnectionDataBaseMySQL {
    
    public Connection connection;
    public Statement statement;
    public ResultSet resultSet;
    
    public void connectionDataBase() {
        try {
            
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/TPAAzkaAiniya?zeroDateTimeBehavior=convertToNull","root","");
            System.out.println("Terhubung dengan Database");
        }
        catch (Exception e) {
            System.out.println("Gagal terhubung dengan database error + "+ e);
        }
    
    }
    
}

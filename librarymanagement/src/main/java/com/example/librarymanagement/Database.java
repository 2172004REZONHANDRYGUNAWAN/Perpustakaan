package com.example.librarymanagement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.TimeZone;

public class Database {
    public static Connection connect;
    public static Connection connectDB(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
//        MY DATABASE IS mData
            connect = DriverManager.getConnection("jdbc:mysql://localhost/mData", "root", "");
        }catch(Exception e){e.printStackTrace();}
        return connect;
    }

}


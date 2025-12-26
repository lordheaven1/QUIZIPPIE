package com.quiz;

import java.sql.*;
import com.mysql.cj.jdbc.MysqlDataSource;
import javax.sql.DataSource;

public class DBConnectionManager {
    private static DataSource dataSource;
    
    static {
        MysqlDataSource ds = new MysqlDataSource();
        ds.setURL("jdbc:mysql://localhost:3306/quizdb");
        ds.setUser("root");  // Change to your MySQL username
        ds.setPassword("Sah@123#ilsahoo");  // Change to your MySQL password
        dataSource = ds;
    }
    
    public static Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }
}

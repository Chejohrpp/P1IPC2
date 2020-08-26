/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ConnectionSQL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author chejohrpp
 */
public class ConnectionDB {
    private static Connection connection;
    
    public ConnectionDB(){
        String url = "jdbc:mysql://localhost:3306/P1IPC2?useSSL=false";
        String user = "usuario";
        String password = "usuario";
        try{
           connection = DriverManager.getConnection(url, user, password);
           
//           if (connection != null) {
//                System.out.println("Conexion Establecida....");
//            }
           
        }catch(SQLException e){
            System.out.println("Error: " + e.getMessage());
        }
    }
    public Connection getConnection(){
        return connection;
    }
    public void closeConnection() throws SQLException{
     connection.close();
     
            
    }
    
}
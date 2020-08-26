/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package source;
import ConnectionSQL.ConnectionDB;
import Frontend.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.*;

/**
 *
 * @author chejohrpp
 */
public class Main {
    
    
    
    public static void main(String args[]){
      try {
            // Set cross-platform Java L&F (also called "Metal")
         UIManager.setLookAndFeel("com.sun.java.swing.plaf.gtk.GTKLookAndFeel");
    } 
    catch (UnsupportedLookAndFeelException e) {
       // handle exception
    }
    catch (ClassNotFoundException e) {
       // handle exception
    }
    catch (InstantiationException e) {
       // handle exception
    }
    catch (IllegalAccessException e) {
       // handle exception
    }
      boolean db_empty = true;
      //conectaremos la DB sin la clase de ConnectionSQL.ConnectionDB por ser el main static 
       String url = "jdbc:mysql://localhost:3306/P1IPC2?useSSL=false";
        String user = "usuario";
        String password = "usuario";
      try (Connection connection = DriverManager.getConnection(url, user, password)) {
          db_empty = isEmptyDB(connection);          
        } catch (SQLException ex) {
            System.out.println("Error: " + ex.getMessage());
        }
      
        if (db_empty) {
            PreCargaDatos pre_carga = new PreCargaDatos();
            pre_carga.setLocationRelativeTo(null);      
            pre_carga.setVisible(true);
        }else{
            Inicio inicio = new Inicio();
            inicio.setLocationRelativeTo(null);      
            inicio.setVisible(true); 
        }
        
    }

    private static boolean isEmptyDB(Connection connection){
        String tienda_query = "SELECT COUNT(*) FROM tienda";
        String emp_query = "SELECT COUNT(*) FROM empleado";
        //vemos si tienen al menos una tienda
        try (PreparedStatement preSt = connection.prepareStatement(tienda_query);
             ResultSet result = preSt.executeQuery()) {
            if (result.next()) {
                if (Integer.parseInt(result.getString(1)) == 0) {
                    return true;
                }
            }
            result.close();
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
        //vemos si tenemos al menos un empleado
        try (PreparedStatement preSt = connection.prepareStatement(emp_query);
             ResultSet result = preSt.executeQuery()) {
            if (result.next()) {
                if (Integer.parseInt(result.getString(1)) == 0) {
                    return true;
                }
            }
            result.close();
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
        
        return false;
    }
    
    
}
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ConnectionSQL;

import Frontend.AddTimes;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @author chejohrpp
 */
public class ConClient {
    ConnectionDB con = new ConnectionDB();
    Connection connection;
    public ConClient(){
        connection = con.getConnection();
    }
    //metodos para el rastreo de pedido
    
    public void buscarPed(int cod,JLabel dias,JLabel total,JLabel anticipo,JLabel pago,JLabel TO,JLabel TD,LinkedList nombre,LinkedList precio,LinkedList cantidad){
        //Date fecha_a = java.sql.Date.valueOf(java.time.LocalDate.now());
        
        String query = "SELECT fecha_entrega,total,anticipo,SUM(total)-SUM(anticipo),tienda_o,tienda_d from pedido WHERE codigo=?";
        
         try (PreparedStatement preSt = connection.prepareStatement(query)) {

            preSt.setInt(1, cod);
            
             ResultSet result = preSt.executeQuery();
             if (result.next()) {
                 dias.setText("fecha de entrega: "+result.getString(1));
                 total.setText("Total: "+result.getString(2));
                 anticipo.setText("anticipo dado: "+result.getString(3));
                 pago.setText("El pago a recoger el pedido: "+result.getString(4));
                 TO.setText("La tienda de origen: "+result.getString(5));
                 TD.setText("La tienda de entrega: " +result.getString(6));
                 generarProd(cod,nombre,precio,cantidad);
             }else{
                 JOptionPane.showMessageDialog(null, "No se encontro el codigo", "ERORR", JOptionPane.ERROR_MESSAGE);
             }
            
           con.closeConnection();
            
            
            
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
            JOptionPane.showMessageDialog(null, "Ingrese bien los datos", "ERORR", JOptionPane.ERROR_MESSAGE);
                              
        }
       
    }
    
    private void generarProd(int cod,LinkedList nombre,LinkedList precio,LinkedList cantidad){
        String query = "select p.nombre,p.precio,c.cantidad from carro_compra c join producto p on c.pedido_cod=? and p.codigo=c.producto_cod";
        
         try (PreparedStatement preSt = connection.prepareStatement(query)) {

            preSt.setInt(1, cod);
            
             ResultSet result = preSt.executeQuery();
             while(result.next()){
                 nombre.offer(result.getString(1));
                 precio.offer(result.getString(2));
                 cantidad.offer(result.getString(3));
             } 
            
            
            
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
            JOptionPane.showMessageDialog(null, "producto no valido", "ERORR", JOptionPane.ERROR_MESSAGE);
                              
        }
        
    }
    
    //metodo para el catalogo del producto
    
    public void buscarProd(String colum, String name,LinkedList codigo,LinkedList nombre,LinkedList fab,LinkedList precio,LinkedList cant,LinkedList tienda){
        String query = "select p.codigo,p.nombre,p.fabricante,p.precio,pt.cantidad,pt.tienda_cod from producto p join producto_tienda pt on p.codigo=pt.producto_cod and p."+colum+ 
                " like ? ";
        try (PreparedStatement preSt = connection.prepareStatement(query)) {

            //preSt.setString(1, colum);
            
            preSt.setString(1,  "%" + name + "%");
            
             ResultSet result = preSt.executeQuery();
             while(result.next()){
                 codigo.offer(result.getString(1));
                 nombre.offer(result.getString(2));
                 fab.offer(result.getString(3));
                 precio.offer(result.getString(4));
                 cant.offer(result.getString(5));
                 tienda.offer(result.getString(6));                 
             }      
            
            
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
            JOptionPane.showMessageDialog(null, "producto no valido", "ERORR", JOptionPane.ERROR_MESSAGE);
                              
        }
        
    }
    
     public void ordenarProd(String order,String colum, String name,LinkedList codigo,LinkedList nombre,LinkedList fab,LinkedList precio,LinkedList cant,LinkedList tienda){
        String query = "select p.codigo,p.nombre,p.fabricante,p.precio,pt.cantidad,pt.tienda_cod from producto p join producto_tienda pt on p.codigo=pt.producto_cod and p."+colum+ 
                " like ? order by "+order;
        try (PreparedStatement preSt = connection.prepareStatement(query)) {
            
            
            preSt.setString(1,  "%" + name + "%");
            
             ResultSet result = preSt.executeQuery();
             while(result.next()){
                 codigo.offer(result.getString(1));
                 nombre.offer(result.getString(2));
                 fab.offer(result.getString(3));
                 precio.offer(result.getString(4));
                 cant.offer(result.getString(5));
                 tienda.offer(result.getString(6));                 
             }      
            
            
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
            JOptionPane.showMessageDialog(null, "No hay datos a ordenar", "ERORR", JOptionPane.ERROR_MESSAGE);
                              
        }
        
    }
     
     public void ordenarProdDesc(String order,String colum, String name,LinkedList codigo,LinkedList nombre,LinkedList fab,LinkedList precio,LinkedList cant,LinkedList tienda){
        String query = "select p.codigo,p.nombre,p.fabricante,p.precio,pt.cantidad,pt.tienda_cod from producto p join producto_tienda pt on p.codigo=pt.producto_cod and p."+colum+ 
                " like ? order by "+order+" DESC";
        try (PreparedStatement preSt = connection.prepareStatement(query)) {
            
            
            preSt.setString(1,  "%" + name + "%");
            
             ResultSet result = preSt.executeQuery();
             while(result.next()){
                 codigo.offer(result.getString(1));
                 nombre.offer(result.getString(2));
                 fab.offer(result.getString(3));
                 precio.offer(result.getString(4));
                 cant.offer(result.getString(5));
                 tienda.offer(result.getString(6));                 
             }      
            
            
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
            JOptionPane.showMessageDialog(null, "No hay datos a ordenar", "ERORR", JOptionPane.ERROR_MESSAGE);
                              
        }
        
    }
    
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ConnectionSQL;

import Frontend.OpcionEmp;
import static Frontend.SignEmp.nombre_tienda_a;
import static Frontend.SignEmp.tienda_actual;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author chejohrpp
 */
public class ModDB {
    private ConnectionDB con = new ConnectionDB();
    private Connection connection;
    public ModDB(){
        connection = con.getConnection();
    }
    //vemos si hay datos vacios para convertilos a null
    private String isEmptyString(String var){
        var = var.replaceAll("^\\s*","");
        var = var.replaceAll("\\s*$","");
        
        if (var.equalsIgnoreCase("")) {            
           return null;
        }
        return var;
    }
    public void modTienda(JFrame j,String codigo, String nombre, String telefono1, String telefono2,String email, String horario, String direccion){
        String query = "UPDATE tienda SET nombre = ?,direccion = ?,telefono1 = ?, telefono2 = ?,email=?,horario=? WHERE codigo=?";
        
        try (PreparedStatement preSt = connection.prepareStatement(query)) {
            
            preSt.setString(1, isEmptyString(nombre));
            preSt.setString(2, isEmptyString(direccion));
            preSt.setString(3, isEmptyString(telefono1));
            preSt.setString(4, isEmptyString(telefono2));
            preSt.setString(5, isEmptyString(email));
            preSt.setString(6, isEmptyString(horario));
            preSt.setString(7, isEmptyString(codigo));            
            preSt.executeUpdate();            
            JOptionPane.showMessageDialog(null, "Tienda Modificada", "Finalizado Exitoso", JOptionPane.INFORMATION_MESSAGE);
            if (codigo.equalsIgnoreCase(tienda_actual)) {
                nombre_tienda_a = nombre;
            }
            con.closeConnection();
            regresar(j);//regresar al menu principal
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
            JOptionPane.showMessageDialog(null, "No se logro actualizar", "ERORR", JOptionPane.ERROR_MESSAGE);
                              
        }
    }
    public void modEmp(JFrame j,String codigo, String nombre, String telefono, String dpi,String nit,String email,String dir){
        String query = "UPDATE empleado SET nombre=?,telefono=?,dpi=?,nit=?,email=?,direccion=? WHERE codigo=?";
            
            try (PreparedStatement preSt = connection.prepareStatement(query)) {

            preSt.setString(1, isEmptyString(nombre));
            
            preSt.setString(2, isEmptyString(telefono));
            preSt.setString(3, isEmptyString(dpi));
            preSt.setString(4, isEmptyString(nit));
            preSt.setString(5, isEmptyString(email));
            preSt.setString(6, isEmptyString(dir));
            preSt.setString(7, isEmptyString(codigo));

            preSt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Empleado Modificado", "Finalizado Exitoso", JOptionPane.INFORMATION_MESSAGE);
            con.closeConnection();
            regresar(j);//regresar al menu principal
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
           JOptionPane.showMessageDialog(null, "No se logro actualizar", "ERORR", JOptionPane.ERROR_MESSAGE);

        }
    }
    
     public void ModProducto(JFrame j,String  codigo, String nombre,String fab, double precio, int garantia, String descripcion ){
         String query = "UPDATE producto SET nombre=?,fabricante=?,precio=?,garantia=?,descripcion=? WHERE codigo=?";
            
            
            try (PreparedStatement preSt = connection.prepareStatement(query)) {

            preSt.setString(1, isEmptyString(nombre));
            preSt.setString(2, isEmptyString(fab));            
            preSt.setDouble(3, precio);
            preSt.setInt(4, garantia);
            preSt.setString(5, isEmptyString(descripcion));
            preSt.setString(6, isEmptyString(codigo));
            
            preSt.executeUpdate();
            JOptionPane.showMessageDialog(null, "producto Modificado", "Finalizado Exitoso", JOptionPane.INFORMATION_MESSAGE);
            
            regresar(j);//regresar al menu principal
        } catch (SQLException e) {            
            JOptionPane.showMessageDialog(null, "No se logro actualizar", "ERORR", JOptionPane.ERROR_MESSAGE);
            
        }
    }
     public void ModCliente(JFrame j,String nit, String nombre, String telefono, String dpi, String direccion, String email){
         String query = "UPDATE cliente SET nombre=?,telefono=?, dpi=?, direccion=?, email=? WHERE nit=?";
            
            try (PreparedStatement preSt = connection.prepareStatement(query)) {

            preSt.setString(1, isEmptyString(nombre));
            preSt.setString(2, isEmptyString(telefono));
            preSt.setString(3, isEmptyString(dpi));
            preSt.setString(4, isEmptyString(direccion));
            preSt.setString(5, isEmptyString(email));
            preSt.setString(6, isEmptyString(nit));


            preSt.executeUpdate();

           

            JOptionPane.showMessageDialog(null, "Cliente Modificado", "Finalizado Exitoso", JOptionPane.INFORMATION_MESSAGE);
            con.closeConnection();
            regresar(j);//regresar al menu principal
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
            JOptionPane.showMessageDialog(null, "No se logro actualizar", "ERORR", JOptionPane.ERROR_MESSAGE);          
        }
     }
     public void ModTiempo1(JFrame jframe,String tienda1,String tienda2,int tiempo){
          String query = "UPDATE tiempo_envio SET tiempo=? WHERE tienda1=? and tienda2=?";
        try (PreparedStatement preSt = connection.prepareStatement(query)) {
            
            preSt.setInt(1, tiempo);
            preSt.setString(2, tienda1);
            preSt.setString(3, tienda2);
            

            preSt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Tiempo actualizado", "Finalizado Exitoso", JOptionPane.INFORMATION_MESSAGE);
            con.closeConnection();
            regresar(jframe);//regresasmos al menu principal
            
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
            JOptionPane.showMessageDialog(null, "No se logro actualizar", "ERORR", JOptionPane.ERROR_MESSAGE);  

        }
     }
     public void ModTiempo2(JFrame jframe,String tienda1,String tienda2,int tiempo){
          String query = "UPDATE tiempo_envio SET tiempo=? WHERE tienda2=? and tienda1=?";
        try (PreparedStatement preSt = connection.prepareStatement(query)) {
            
            preSt.setInt(1, tiempo);
            preSt.setString(2, tienda1);
            preSt.setString(3, tienda2);
            

            preSt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Tiempo actualizado", "Finalizado Exitoso", JOptionPane.INFORMATION_MESSAGE);
            con.closeConnection();
            regresar(jframe);//regresamos al menu principal
            
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
            JOptionPane.showMessageDialog(null, "No se logro actualizar", "ERORR", JOptionPane.ERROR_MESSAGE);  

        }
     }
     public void ModArt(JFrame j, String tienda, String prod, int cant){
        String query = "UPDATE producto_tienda SET cantidad=? WHERE tienda_cod=? and producto_cod=?";
        try (PreparedStatement preSt = connection.prepareStatement(query)) {
            
            preSt.setInt(1, cant);
            preSt.setString(2, tienda);
            preSt.setString(3, prod);
            

            preSt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Cantidad actualizada", "Finalizado Exitoso", JOptionPane.INFORMATION_MESSAGE);
            con.closeConnection();
            regresar(j);//regresamos al menu principal
            
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
            JOptionPane.showMessageDialog(null, "No se logro actualizar", "ERORR", JOptionPane.ERROR_MESSAGE);  

        }
     }
     
     //pedidos
     public void RePedido(JFrame j,int codigo, int tiempo){
         String query = "UPDATE pedido SET recorrido_finalizado=1,tiempo_cumplido=? WHERE codigo=?";
        try (PreparedStatement preSt = connection.prepareStatement(query)) {
            
            preSt.setInt(1, tiempo);
            preSt.setInt(2, codigo);            
            

            preSt.executeUpdate();

            JOptionPane.showMessageDialog(null, "pedido actualizado", "Finalizado Exitoso", JOptionPane.INFORMATION_MESSAGE);
            con.closeConnection();
            regresar(j);//regresamos al menu principal
            
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
            JOptionPane.showMessageDialog(null, "No se logro actualizar", "ERORR", JOptionPane.ERROR_MESSAGE);  

        }         
     }
     
     public void conPedido(){
         
     }
     
     //modificar el credito del cliente
     public void modCred(double credito, String nit){
          String query = "UPDATE cliente SET credito=? WHERE nit=?";
        try (PreparedStatement preSt = connection.prepareStatement(query)) {
            
            preSt.setDouble(1, credito);
            preSt.setString(2, nit);            
            

            preSt.executeUpdate();

            //JOptionPane.showMessageDialog(null, "credito actualizado", "Finalizado Exitoso", JOptionPane.INFORMATION_MESSAGE);
            con.closeConnection();
            
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
            //JOptionPane.showMessageDialog(null, "No se logro actualizar", "ERORR", JOptionPane.ERROR_MESSAGE);  

        }  
         
     }
     
     
     private void regresar(JFrame jframe){
         OpcionEmp emp = new OpcionEmp();
         emp.setLocationRelativeTo(null);
         emp.setVisible(true);
         jframe.dispose();
     }
}

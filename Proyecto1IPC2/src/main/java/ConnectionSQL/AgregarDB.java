/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ConnectionSQL;

import Frontend.AddTimes;
import Frontend.OpcionEmp;
import static Frontend.SignEmp.tienda_actual;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import static source.CargarDatosEx.MYSQL_DUPLICATE_PK;

/**
 *
 * @author chejohrpp
 */
public class AgregarDB {
    ConnectionDB con = new ConnectionDB();
    Connection connection;
    public AgregarDB(){
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
    
    
    public void addTienda(JFrame tienda,String codigo, String nombre, String telefono1, String telefono2,String email, String horario, String direccion ){
        String query = "INSERT INTO tienda (codigo,nombre,direccion,telefono1,telefono2,email,horario,fecha_verificacion) VALUES (?,?,?,?,?,?,?,?)";
        
        try (PreparedStatement preSt = connection.prepareStatement(query)) {

            preSt.setString(1, isEmptyString(codigo));
            preSt.setString(2, isEmptyString(nombre));
            preSt.setString(3, isEmptyString(direccion));
            preSt.setString(4, isEmptyString(telefono1));
            preSt.setString(5, isEmptyString(telefono2));
            preSt.setString(6, isEmptyString(email));
            preSt.setString(7, isEmptyString(horario));
            preSt.setDate(8, java.sql.Date.valueOf(java.time.LocalDate.now()));
            
            preSt.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Tienda agregada \nConfigure los tiempos de envio para cada tienda", "Finalizado Exitoso", JOptionPane.INFORMATION_MESSAGE);
            con.closeConnection();
            tienda.setVisible(false);
            AddTimes addT = new AddTimes(codigo);
            addT.setLocationRelativeTo(null);
            addT.setVisible(true);
            
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
            JOptionPane.showMessageDialog(null, "No se registro a la base de datos", "ERORR", JOptionPane.ERROR_MESSAGE);
                              
        }
    }
    
    public void addTiempo(String tienda1, String tienda2, int tiempo){
        
        String query = "INSERT INTO tiempo_envio (tienda1,tienda2,tiempo) VALUES (?,?,?)";
        try (PreparedStatement preSt = connection.prepareStatement(query)) {

            preSt.setString(1, tienda1);
            preSt.setString(2, tienda2);
            preSt.setInt(3, tiempo);

            preSt.executeUpdate();


            con.closeConnection();
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());

        }

    }
    public void addEmp(JFrame j,String codigo, String nombre, String telefono, String dpi,String nit,String email,String dir){
         String query = "INSERT INTO empleado (nombre,codigo,telefono,dpi,nit,email,direccion) VALUES (?,?,?,?,?,?,?)";
            
            try (PreparedStatement preSt = connection.prepareStatement(query)) {

            preSt.setString(1, isEmptyString(nombre));
            preSt.setString(2, isEmptyString(codigo));
            preSt.setString(3, isEmptyString(telefono));
            preSt.setString(4, isEmptyString(dpi));
            preSt.setString(5, isEmptyString(nit));
            preSt.setString(6, isEmptyString(email));
            preSt.setString(7, isEmptyString(dir));
            

            preSt.executeUpdate();
           JOptionPane.showMessageDialog(null, "Empleado agregado", "Finalizado Exitoso", JOptionPane.INFORMATION_MESSAGE);
            con.closeConnection();
            regresar(j);//regresar al menu principal
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
           JOptionPane.showMessageDialog(null, "No se registro a la base de datos", "ERORR", JOptionPane.ERROR_MESSAGE);

        }
    }
    public void addProducto(JFrame j,String  codigo, String nombre,String fab, double precio, int garantia, String descripcion,int cantidad ){
         String query = "INSERT INTO producto (nombre,fabricante,codigo,precio,garantia,descripcion) VALUES (?,?,?,?,?,?)";
            
            
            try (PreparedStatement preSt = connection.prepareStatement(query)) {

            preSt.setString(1, isEmptyString(nombre));
            preSt.setString(2, isEmptyString(fab));
            preSt.setString(3, isEmptyString(codigo));
            preSt.setDouble(4, precio);
            preSt.setInt(5, garantia);
            preSt.setString(6, isEmptyString(descripcion));
            
            
            preSt.executeUpdate();
            
            addCant(j,cantidad,codigo);
            
            
        } catch (SQLException e) {            
                if (e.getErrorCode() ==MYSQL_DUPLICATE_PK) {
                    JOptionPane.showMessageDialog(null, "Producto existente \nSi desea agregar más productos dirijase a la seccion modificar->agregar existencia producto", "ERORR", JOptionPane.ERROR_MESSAGE);
                }else{
                    System.out.println("Error: " + e.getMessage());
                    JOptionPane.showMessageDialog(null, "No se registro a la base de datos", "ERORR", JOptionPane.ERROR_MESSAGE);
                    try{
                        con.closeConnection();
                    }catch(SQLException sql){
                        //solo es para cerrar la conexxion
                    }
                }
            
        }
    }
    private void addCant(JFrame j,int cantidad, String cod){
         String query = "INSERT INTO producto_tienda (cantidad, tienda_cod, producto_cod) VALUES (?,?,?)";

        try (PreparedStatement preSt = connection.prepareStatement(query)) {
            
            preSt.setInt(1, cantidad);
            preSt.setString(2, tienda_actual);
            preSt.setString(3, cod);  

            preSt.executeUpdate();
           


            JOptionPane.showMessageDialog(null, "Producto agregado", "Finalizado Exitoso", JOptionPane.INFORMATION_MESSAGE);
            con.closeConnection();
            regresar(j);//regresar al menu principal
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
           JOptionPane.showMessageDialog(null, "No se registro a la base de datos", "ERORR", JOptionPane.ERROR_MESSAGE);
                              
        }
    }
    
    public void addCliente(JFrame j,String nit, String nombre, String telefono, String dpi, String direccion, String email){
         String query = "INSERT INTO cliente (nombre,nit,telefono,credito, dpi, direccion, email) VALUES (?,?,?,?,?,?,?)";
            double credito = 0;
            
            try (PreparedStatement preSt = connection.prepareStatement(query)) {

            preSt.setString(1, isEmptyString(nombre));
            preSt.setString(2, isEmptyString(nit));
            preSt.setString(3, isEmptyString(telefono));
            preSt.setDouble(4, credito);
            preSt.setString(5, isEmptyString(dpi));
            preSt.setString(6, isEmptyString(direccion));
            preSt.setString(7, isEmptyString(email));

            preSt.executeUpdate();

           regresar(j);//regresar al menu principal

            JOptionPane.showMessageDialog(null, "Cliente agregado", "Finalizado Exitoso", JOptionPane.INFORMATION_MESSAGE);
            con.closeConnection();
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
            JOptionPane.showMessageDialog(null, "No se registro a la base de datos", "ERORR", JOptionPane.ERROR_MESSAGE);          
        }
        
    }
    public void addSign(String emp,String tienda){
        String query = "INSERT INTO ingreso_sistema (codigo_empleado,codigo_tienda) VALUES (?,?)";            
            try (PreparedStatement preSt = connection.prepareStatement(query)) {
            preSt.setString(1, isEmptyString(emp));
            preSt.setString(2, isEmptyString(tienda));

            preSt.executeUpdate();          

            System.out.println("Ingreso al sistema correcto");
            con.closeConnection();
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());          
        }   
     }
    public void addArt(JFrame j, String tienda, String prod, int cant){
         String query = "INSERT INTO producto_tienda (cantidad,tienda_cod,producto_cod) VALUES (?,?,?)";
        try (PreparedStatement preSt = connection.prepareStatement(query)) {
            
            preSt.setInt(1, cant);
            preSt.setString(2, tienda);
            preSt.setString(3, prod);
            

            preSt.executeUpdate();

            JOptionPane.showMessageDialog(null, "cantidad actualizada", "Finalizado Exitoso", JOptionPane.INFORMATION_MESSAGE);
            con.closeConnection();
            regresar(j);//regresamos al menu principal
            
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
            JOptionPane.showMessageDialog(null, "No se logro actualizar", "ERORR", JOptionPane.ERROR_MESSAGE);  

        }
    }
    
    //pedido
    public void addPedido(String TO,String TD, int dias,String nit,double total, double anticipo){
        String query = "INSERT INTO pedido (tienda_o,tienda_d,fecha_entrega,cliente_nit,total,anticipo) VALUES (?,?,?,?,?,?)";
        
//            java.util.Date utilStartDate = sumarRestarDiasFecha(dias);
//            java.sql.Date sqlStartDate = new java.sql.Date(utilStartDate.getTime());
            
            
            
            try (PreparedStatement preSt = connection.prepareStatement(query)) {

            preSt.setString(1, TO);
            preSt.setString(2, TD);
            preSt.setDate(3, java.sql.Date.valueOf(java.time.LocalDate.now()));
            preSt.setString(4, nit);
            preSt.setDouble(5, total);
            preSt.setDouble(6, anticipo);

            preSt.executeUpdate();
            
            
           JOptionPane.showMessageDialog(null, "Pedido confirmado", "Finalizado Exitoso", JOptionPane.INFORMATION_MESSAGE);
            con.closeConnection();
            
        } catch (SQLException e) {
                System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null, "Error al registar el pedido", "ERORR", JOptionPane.ERROR_MESSAGE);  
        }
    }
    //agregar dias
         private String sumarDias(int dias){
              String query = "select DATE_ADD(NOW(),INTERVAL ? DAY);";
           
            
            try (PreparedStatement preSt = connection.prepareStatement(query)) {
             preSt.setInt(1, dias);   

            ResultSet result = preSt.executeQuery();
            
                if (result.next()) {
                    return result.getString(1);
                }
            
            //con.closeConnection();
            
        } catch (SQLException e) {
                System.out.println(e.getMessage());
            //JOptionPane.showMessageDialog(null, "Error al registar el pedido", "ERORR", JOptionPane.ERROR_MESSAGE);  
        }
            
        return null;

 }
    
    public void addPedidoProducto(String producto_cod, int pedido_cod, int cantidad,int exist,String tienda){
            String query = "INSERT INTO carro_compra (cantidad,pedido_cod,producto_cod) VALUES (?,?,?)";
            
            
            try (PreparedStatement preSt = connection.prepareStatement(query)) {

            preSt.setInt(1, cantidad);
            preSt.setInt(2, pedido_cod);
            preSt.setString(3, producto_cod);

            preSt.executeUpdate();
           
            
            quitarExist(exist,tienda,producto_cod);
            con.closeConnection();
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
            //JOptionPane.showMessageDialog(null, "Error al los productos", "ERORR", JOptionPane.ERROR_MESSAGE);  
        }
    }
    
    private void quitarExist(int cant,String tienda, String prod){
        String query = "UPDATE producto_tienda SET cantidad=? WHERE tienda_cod=? and producto_cod=?";
        try (PreparedStatement preSt = connection.prepareStatement(query)) {
            
            preSt.setInt(1, cant);
            preSt.setString(2, tienda);
            preSt.setString(3, prod);
            

            preSt.executeUpdate();

            //JOptionPane.showMessageDialog(null, "Cantidad actualizada", "Finalizado Exitoso", JOptionPane.INFORMATION_MESSAGE);
            
            
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
            //JOptionPane.showMessageDialog(null, "No se logro actualizar", "ERORR", JOptionPane.ERROR_MESSAGE);  

        }
    }
    //ventas
    
    public void addVenta(String nit, double total){
        String query = "INSERT INTO venta (fecha,total,tienda_cod,cliente_nit) VALUES (?,?,?,?)";            
            
            
            try (PreparedStatement preSt = connection.prepareStatement(query)) {


            
            preSt.setDate(1, java.sql.Date.valueOf(java.time.LocalDate.now()));
            preSt.setDouble(2, total);
            preSt.setString(3, tienda_actual);
            preSt.setString(4, nit);
            

            preSt.executeUpdate();
            
            
           JOptionPane.showMessageDialog(null, "Venta confirmada", "Finalizado Exitoso", JOptionPane.INFORMATION_MESSAGE);
            con.closeConnection();
            
        } catch (SQLException e) {
                System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null, "Error al registar la venta", "ERORR", JOptionPane.ERROR_MESSAGE);  
        }
    }
    
    public void addArtVenta(int cant,int venta,String prod,int exist){
        String query = "INSERT INTO articulo_vendido (cantidad,venta_id,producto_codigo) VALUES (?,?,?)";
            
            
            try (PreparedStatement preSt = connection.prepareStatement(query)) {

            preSt.setInt(1, cant);
            preSt.setInt(2, venta);
            preSt.setString(3, prod);

            preSt.executeUpdate();
           
           quitarExist(exist,tienda_actual,prod); 
            con.closeConnection();
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
            JOptionPane.showMessageDialog(null, "Error al registrar los productos", "ERORR", JOptionPane.ERROR_MESSAGE);  
        }
        
    }
    
    
    
    
     private void regresar(JFrame jframe){
         OpcionEmp emp = new OpcionEmp();
         emp.setLocationRelativeTo(null);
         emp.setVisible(true);
         jframe.dispose();
     }
    
}

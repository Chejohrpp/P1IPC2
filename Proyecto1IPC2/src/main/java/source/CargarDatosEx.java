/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package source;

import ConnectionSQL.ConnectionDB;
import static Lectura.RCargaDatos.bien_registro;
import static Lectura.RCargaDatos.error_registro;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.Stack;

/**
 *
 * @author chejohrpp
 */
public class CargarDatosEx {
    public static final int MYSQL_DUPLICATE_PK = 1062;
    ConnectionDB con = new ConnectionDB();
    Connection connection;
    String[] registro;
    String resultado;
    int index;
    String linea;
    
    public CargarDatosEx(String[] registro, int index, String linea){
        this.registro = registro;
        connection = con.getConnection();
        this.index = index;
        this.linea = linea;
    }
    public void registrarDB(){
        coTabla();
    }
    private void coTabla(){
        
        String clasif = registro[0];
        if (clasif.equals("TIENDA")) {
           // System.out.println("tienda");
            ingresoTienda();
        }
        else if (clasif.equals("TIEMPO")) {
            //System.out.println("tiempo");
            ingresoTiempo();
        }
        else if (clasif.equals("PRODUCTO")) {
            //System.out.println("PRO");
            ingresoProducto();
        }
        else if (clasif.equals("EMPLEADO")) {
            //System.out.println("Emp");
            ingresoEmpleado();
        }
        else if (clasif.equals("CLIENTE")) {
            //System.out.println("CLI");
            ingresoCliente();
        }
        else if (clasif.equals("PEDIDO")) {
            //System.out.println("pedido");
            ingresoPedido();
        }
        else{
           resultado = linea + " No se ha identificado en la linea " + index;
           error_registro.offer(resultado);
        }
        
    }
    private void ingresoTienda(){
        if (registro.length == 5) {
            String query = "INSERT INTO tienda (nombre,direccion,codigo,telefono1) VALUES (?,?,?,?)";
            String nombre = registro[1];
            String direccion = registro[2];
            String codigo = registro[3];
            String telefono = registro[4];
            
            try (PreparedStatement preSt = connection.prepareStatement(query)) {

            preSt.setString(1, nombre);
            preSt.setString(2, direccion);
            preSt.setString(3, codigo);
            preSt.setString(4, telefono);

            preSt.executeUpdate();

           
            bien_registro.offer(linea);

            //preSt.close();
            con.closeConnection();
        } catch (SQLException e) {
            //System.out.println("Error: " + e.getMessage());
                resultado = linea + " Error en la linea " + index;
                error_registro.offer(resultado);                
        }
        }else{
            resultado = linea + " No se ha identificado en la linea " + index;
            error_registro.offer(resultado);
        }
    }
    
    private void ingresoTiempo(){
        if (registro.length == 4) {
            String query0 = "SELECT COUNT(*) FROM tiempo_envio WHERE tienda1 = ? AND tienda2 = ? OR  tienda1 = ? AND tienda2 = ?"; 
            String query = "INSERT INTO tiempo_envio (tienda1,tienda2,tiempo) VALUES (?,?,?)";
            String tienda1 = registro[1];
            String tienda2 = registro[2];
            int tiempo = Integer.parseInt(registro[3]);
            
            try(PreparedStatement consulta = connection.prepareStatement(query0)){
                consulta.setString(1, tienda1);
                consulta.setString(2, tienda2);
                consulta.setString(3, tienda2);
                consulta.setString(4, tienda1);
                ResultSet result = consulta.executeQuery();
                if (result.next()) {
                    if (Integer.parseInt(result.getString(1)) == 0) {
                        try (PreparedStatement preSt = connection.prepareStatement(query)) {

                            preSt.setString(1, tienda1);
                            preSt.setString(2, tienda2);
                            preSt.setInt(3, tiempo);

                            preSt.executeUpdate();

                            bien_registro.offer(linea);

                            //preSt.close();
                            con.closeConnection();
                        } catch (SQLException e) {
                            System.out.println("Error: " + e.getMessage());
                                resultado = linea + " Error en la linea " + index;
                                error_registro.offer(resultado);                
                        }
                        
                    } else{
                      resultado = linea + " Error en linea " + index + " ya esta en la base de datos";
                      error_registro.offer(resultado);  
                    }
                }
                
            }catch(SQLException ee){
                System.out.println("Error: " + ee.getMessage());
                resultado = linea + " Error en la linea " + index;
                error_registro.offer(resultado);   
            }
            
            
        }else{
            resultado = linea + " No se ha identificado en la linea " + index;
            error_registro.offer(resultado);
        }
        
    }
    
    private void ingresoEmpleado(){
         if (registro.length == 5) {
            String query = "INSERT INTO empleado (nombre,codigo,telefono,dpi) VALUES (?,?,?,?)";
            String nombre = registro[1];
            String codigo = registro[2];
            String telefono = registro[3];
            String dpi = registro[4];
            
            
            try (PreparedStatement preSt = connection.prepareStatement(query)) {

            preSt.setString(1, nombre);
            preSt.setString(2, codigo);
            preSt.setString(3, telefono);
            preSt.setString(4, dpi);

            preSt.executeUpdate();

           
            bien_registro.offer(linea);

            //preSt.close();
            con.closeConnection();
        } catch (SQLException e) {
            //System.out.println("Error: " + e.getMessage());
                resultado = linea + " Error en la linea " + index;
                error_registro.offer(resultado);                
        }
        }else{
            resultado = linea + " No se ha identificado en la linea " + index;
            error_registro.offer(resultado);
        }
    }
    
    private void ingresoProducto(){
         if (registro.length == 7) {
            String query = "INSERT INTO producto (nombre,fabricante,codigo,precio) VALUES (?,?,?,?)";
            String nombre = registro[1];
            String fabricante = registro[2];
            String codigo = registro[3];
            int cantidad = Integer.parseInt(registro[4]);
            double precio = Double.parseDouble(registro[5]);
            String tienda = registro[6];
            
            try (PreparedStatement preSt = connection.prepareStatement(query)) {

            preSt.setString(1, nombre);
            preSt.setString(2, fabricante);
            preSt.setString(3, codigo);
            preSt.setDouble(4, precio);

            preSt.executeUpdate();

           
            //bien_registro.offer(linea);

            //preSt.close();
        } catch (SQLException e) {            
                if (e.getErrorCode() ==MYSQL_DUPLICATE_PK) {
                    //System.out.println("Error, este esta bien producto");
                }else{
                    System.out.println("Error: " + e.getMessage());
                    resultado = linea + " Error en la linea " + index;
                    error_registro.offer(resultado);
                    try{
                        con.closeConnection();
                    }catch(SQLException sql){
                        //solo es para cerrar la conexxion
                    }
                }
            
        }finally{
                try{
                    inProductoTienda(cantidad,tienda,codigo);
                }catch(Exception e){
                    try{
                        con.closeConnection();
                    } catch (SQLException eSql){
                        //solo es para cerrar la conexxion
                    }   
                }                
                
            }
        }else{
            resultado = linea + " No se ha identificado en la linea " + index;
            error_registro.offer(resultado);
        }
    }
    
    private void inProductoTienda(int cantidad, String tienda_cod, String producto_cod){
        String query = "INSERT INTO producto_tienda (cantidad, tienda_cod, producto_cod) VALUES (?,?,?)";

        try (PreparedStatement preSt = connection.prepareStatement(query)) {

            preSt.setInt(1, cantidad);
            preSt.setString(2, tienda_cod);
            preSt.setString(3, producto_cod);
;

            preSt.executeUpdate();

           
            bien_registro.offer(linea);

            //preSt.close();
            con.closeConnection();
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
                resultado = linea + " Error en la linea " + index;
                error_registro.offer(resultado);                
        }
        
    }
    
    private void ingresoCliente(){
          if (registro.length == 5) {
            String query = "INSERT INTO cliente (nombre,nit,telefono,credito) VALUES (?,?,?,?)";
            String nombre = registro[1];
            String nit = registro[2];
            String telefono = registro[3];
            double credito = Double.parseDouble(registro[4]);

            
            try (PreparedStatement preSt = connection.prepareStatement(query)) {

            preSt.setString(1, nombre);
            preSt.setString(2, nit);
            preSt.setString(3, telefono);
            preSt.setDouble(4, credito);


            preSt.executeUpdate();

           
            bien_registro.offer(linea);

            //preSt.close();
            con.closeConnection();
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
                resultado = linea + " Error en la linea " + index;
                error_registro.offer(resultado);                
        }
        }else{
            resultado = linea + " No se ha identificado en la linea " + index;
            error_registro.offer(resultado);
        }
    }
    private void ingresoPedido(){
          if (registro.length == 10) {
            String query = "INSERT INTO pedido (codigo,tienda_o,tienda_d,fecha_entrega,cliente_nit,total,anticipo) VALUES (?,?,?,?,?,?,?)";
            
            int codigo = Integer.parseInt(registro[1]);
            String tienda_o = registro[2];
            String tienda_d = registro[3];
            String fecha = (registro[4]);
            String cliente = registro[5];
            double total = Double.parseDouble(registro[8]);
            double anticipo = Double.parseDouble(registro[9]);
            
            
            
            try (PreparedStatement preSt = connection.prepareStatement(query)) {

            preSt.setInt(1, codigo);
            preSt.setString(2, tienda_o);
            preSt.setString(3, tienda_d);
            preSt.setDate(4, java.sql.Date.valueOf(fecha));
            preSt.setString(5, cliente);
            preSt.setDouble(6, total);
            preSt.setDouble(7, anticipo);

            preSt.executeUpdate();

           
            //bien_registro.offer(linea);

            //preSt.close();
            
        } catch (SQLException e) {            
                if (e.getErrorCode() == MYSQL_DUPLICATE_PK) {
                   // System.out.println("llave primaria duplicada, tenia que pasar");
                } else{
                   System.out.println("Error: " + e.getMessage());
                   resultado = linea + " Error en la linea " + index;
                   error_registro.offer(resultado); 
                   try{
                        con.closeConnection();
                    } catch (SQLException eSql){
                        
                    }
                }                              
        } finally{
                try{
                    String producto_cod = registro[6];
                    int cantidad = Integer.parseInt(registro[7]);
                    inPedidoProducto(producto_cod,codigo,cantidad);
                } catch(Exception e){
                    resultado = linea + " error " + index;
                    error_registro.offer(resultado);
                    try{
                        con.closeConnection();
                    } catch (SQLException eSql){
                        
                    }
                    
                }
                
            }
        }else{
            resultado = linea + " No se ha identificado en la linea " + index;
            error_registro.offer(resultado);
        }
    }
    private void inPedidoProducto(String producto_cod, int pedido_cod, int cantidad){
            String query = "INSERT INTO carro_compra (cantidad,pedido_cod,producto_cod) VALUES (?,?,?)";
            
            
            try (PreparedStatement preSt = connection.prepareStatement(query)) {

            preSt.setInt(1, cantidad);
            preSt.setInt(2, pedido_cod);
            preSt.setString(3, producto_cod);

            preSt.executeUpdate();

           
            bien_registro.offer(linea);

            //preSt.close();
            con.closeConnection();
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
            System.out.println("Esto si es raro");
                //resultado = linea + " Error en la linea " + index;
                //error_registro.offer(resultado);                
        }
    }
}

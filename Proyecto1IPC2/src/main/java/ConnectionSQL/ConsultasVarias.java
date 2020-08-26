/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ConnectionSQL;

import Frontend.OpcionEmp;
import static Frontend.SignEmp.tienda_actual;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author chejohrpp
 */
public class ConsultasVarias {
//    ConnectionDB con = new ConnectionDB();
//    Connection connection;
    public ConsultasVarias(){

    }
    //cuantas tiendas hay, menos la actual
    public int cantTienda(String tienda_in){
        ConnectionDB con = new ConnectionDB();
        try( Connection connection = con.getConnection()){
            String query = "SELECT COUNT(*) FROM tienda"; 
            
            try(PreparedStatement preSt = connection.prepareStatement(query)){
                //preSt.setString(1, tienda_in);                
                ResultSet result = preSt.executeQuery();
                int cant_tienda = 1;
                if (result.next()) {
                    cant_tienda = Integer.parseInt(result.getString(1));
                }                
                result.close();
                con.closeConnection();//cerramos conexionS
                System.out.println(cant_tienda-1);
                return cant_tienda-1;
            }catch(SQLException e){
                System.out.println(e.getMessage());
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(OpcionEmp.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }
    //el array de todos las tiendas menos la actual o en uso
    public LinkedList codTiendas(String tienda_in){
        ConnectionDB con = new ConnectionDB();
        try( Connection connection = con.getConnection()){
            String query = "SELECT codigo FROM tienda WHERE codigo<>?"; 
            
            try(PreparedStatement preSt = connection.prepareStatement(query)){
                preSt.setString(1, tienda_in);
                ResultSet result = preSt.executeQuery();
                LinkedList list_cods = new LinkedList();
                while(result.next()){
                    list_cods.offer(result.getString(1));
                }
                result.close();
                con.closeConnection();//cerramos conexion
                return list_cods;
            }catch(SQLException e){
                System.out.println(e.getMessage());
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(OpcionEmp.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    //devuelve la fecha del tiempo de envio
    public int fechaE(String tienda_in){
        ConnectionDB con = new ConnectionDB();
        try( Connection connection = con.getConnection()){
            String query = "SELECT tiempo FROM tiempo_envio WHERE (tienda1=? and tienda2=?) or (tienda2=? and tienda1=?) "; 
            
            try(PreparedStatement preSt = connection.prepareStatement(query)){
                preSt.setString(1, tienda_in);
                preSt.setString(2, tienda_actual);
                preSt.setString(3, tienda_in);
                preSt.setString(4, tienda_actual);
                ResultSet result = preSt.executeQuery();
                int date = 0;
                if(result.next()){                    
                    date = Integer.parseInt(result.getString(1));
                }
                result.close();
                con.closeConnection();//cerramos conexion
                return date;
            }catch(SQLException e){
                System.out.println(e.getMessage());
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(OpcionEmp.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }
    
    //devuelve los codigos de prodcutos en la lista
    public LinkedList codProds(String codTienda){
         ConnectionDB con = new ConnectionDB();
        try( Connection connection = con.getConnection()){
            String query = "select producto_cod from producto_tienda where tienda_cod = ?"; 
            
            try(PreparedStatement preSt = connection.prepareStatement(query)){
                preSt.setString(1, codTienda);
                ResultSet result = preSt.executeQuery();
                LinkedList list_cods = new LinkedList();
                while(result.next()){
                    list_cods.offer(result.getString(1));
                }
                result.close();
                con.closeConnection();//cerramos conexion
                return list_cods;
            }catch(SQLException e){
                System.out.println(e.getMessage());
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(OpcionEmp.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    //devuelve la existencia de un producto
    public int exist(String tiendaCod,String proCod){
        ConnectionDB con = new ConnectionDB();
        try( Connection connection = con.getConnection()){
            String query = "select cantidad from producto_tienda where tienda_cod = ? and producto_cod=?"; 
            
            try(PreparedStatement preSt = connection.prepareStatement(query)){
                preSt.setString(1, tiendaCod);
                preSt.setString(2, proCod);
                ResultSet result = preSt.executeQuery();
                int cant = 0;
                if(result.next()){                    
                    cant = Integer.parseInt(result.getString(1));
                }
                result.close();
                con.closeConnection();//cerramos conexion
                return cant;
            }catch(SQLException e){
                System.out.println(e.getMessage());
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(OpcionEmp.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }
    //devuelve el precio al producto
    public double precio(String proCod){
        ConnectionDB con = new ConnectionDB();
        try( Connection connection = con.getConnection()){
            String query = "select precio from producto where codigo = ?"; 
            
            try(PreparedStatement preSt = connection.prepareStatement(query)){
                
                preSt.setString(1, proCod);
                
                ResultSet result = preSt.executeQuery();
                double cant = 0;
                if(result.next()){                    
                    cant = Double.parseDouble(result.getString(1));
                }
                result.close();
                con.closeConnection();//cerramos conexion
                return cant;
            }catch(SQLException e){
                System.out.println(e.getMessage());
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(OpcionEmp.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }
    //devuelve los nits de los clientes
    public LinkedList nitClient(){
         ConnectionDB con = new ConnectionDB();
        try( Connection connection = con.getConnection()){
            String query = "select nit from cliente";             
            try(PreparedStatement preSt = connection.prepareStatement(query)){                
                ResultSet result = preSt.executeQuery();
                LinkedList list_cods = new LinkedList();
                while(result.next()){
                    list_cods.offer(result.getString(1));
                }
                result.close();
                con.closeConnection();//cerramos conexion
                return list_cods;
            }catch(SQLException e){
                System.out.println(e.getMessage());
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(OpcionEmp.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    //devuelve el credito de los clientes
    public double cred(String nit){
        ConnectionDB con = new ConnectionDB();
        try( Connection connection = con.getConnection()){
            String query = "select credito from cliente where nit=?"; 
            
            try(PreparedStatement preSt = connection.prepareStatement(query)){
                preSt.setString(1, nit);
                
                ResultSet result = preSt.executeQuery();
                double cant = 0;
                while(result.next()){                    
                    cant = Double.parseDouble(result.getString(1));
                }
                result.close();
                con.closeConnection();//cerramos conexion
                return cant;
            }catch(SQLException e){
                System.out.println(e.getMessage());
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(OpcionEmp.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }
    
    
    public boolean colocTime(JTextField time,String tienda_d){
        
        //String query21 = "select count(*) from tiempo_envio where tienda2 = ? and tienda1 = ?;";
        
        ConnectionDB con = new ConnectionDB();
        try( Connection connection = con.getConnection()){
            String query12 = "select count(*) from tiempo_envio where tienda1 = ? and tienda2 = ?;";
            
            try(PreparedStatement preSt = connection.prepareStatement(query12)){
                preSt.setString(1, tienda_actual);
                preSt.setString(2, tienda_d);
                ResultSet result = preSt.executeQuery();
                int cant = 0;
                if(result.next()){
                    cant = Integer.parseInt(result.getString(1));
                }         
                
                result.close();
                con.closeConnection();//cerramos conexion
                if (cant == 1) {
                    time.setText(String.valueOf(time1(tienda_d)));
                    return true;
                }else{
                    time.setText(String.valueOf(time2(tienda_d)));
                    return false;
                }
                
                
            }catch(SQLException e){
                System.out.println(e.getMessage());
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(OpcionEmp.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    public int time1(String tienda_d){
        ConnectionDB con = new ConnectionDB();
        try( Connection connection = con.getConnection()){
            String query12 = "select tiempo from tiempo_envio where tienda1 = ? and tienda2 = ?;";
            
            try(PreparedStatement preSt = connection.prepareStatement(query12)){
                preSt.setString(1, tienda_actual);
                preSt.setString(2, tienda_d);
                ResultSet result = preSt.executeQuery();
                int cant = 0;
                if(result.next()){
                    cant = Integer.parseInt(result.getString(1));
                }                 
                result.close();
                con.closeConnection();//cerramos conexion
                return cant;
                
                
            }catch(SQLException e){
                System.out.println(e.getMessage());
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(OpcionEmp.class.getName()).log(Level.SEVERE, null, ex);
        }    
        
        return 0;
        
    }
    public int time2(String tienda_d){
        ConnectionDB con = new ConnectionDB();
        try( Connection connection = con.getConnection()){
            String query12 = "select tiempo from tiempo_envio where tienda2 = ? and tienda1 = ?;";
            
            try(PreparedStatement preSt = connection.prepareStatement(query12)){
                preSt.setString(1, tienda_actual);
                preSt.setString(2, tienda_d);
                ResultSet result = preSt.executeQuery();
                int cant = 0;
                if(result.next()){
                    cant = Integer.parseInt(result.getString(1));
                }                 
                result.close();
                con.closeConnection();//cerramos conexion
                return cant;
                
                
            }catch(SQLException e){
                System.out.println(e.getMessage());
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(OpcionEmp.class.getName()).log(Level.SEVERE, null, ex);
        }    
        
        return 0;
        
    }
    
    public boolean art(JTextField txt,String prod){
        
        ConnectionDB con = new ConnectionDB();
        try( Connection connection = con.getConnection()){
            String query = "select count(*) from producto_tienda where tienda_cod = ? and producto_cod = ?";
            
            try(PreparedStatement preSt = connection.prepareStatement(query)){
                preSt.setString(1, tienda_actual);
                preSt.setString(2, prod);
                ResultSet result = preSt.executeQuery();
                int cant = 0;
                if(result.next()){
                    cant = Integer.parseInt(result.getString(1));
                }                 
                result.close();
                con.closeConnection();//cerramos conexion
                if (cant == 0) {
                    txt.setText(String.valueOf(cant));
                    return false;
                }else{
                    txt.setText(String.valueOf(cant(prod)));
                    return true;
                }                
                
            }catch(SQLException e){
                System.out.println(e.getMessage());
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(OpcionEmp.class.getName()).log(Level.SEVERE, null, ex);
        } 
        
        return false;        
    }
    
    public int cant(String prod){
        ConnectionDB con = new ConnectionDB();
        try( Connection connection = con.getConnection()){
            String query12 = "select cantidad from producto_tienda where tienda_cod = ? and producto_cod = ?";
            
            try(PreparedStatement preSt = connection.prepareStatement(query12)){
                preSt.setString(1, tienda_actual);
                preSt.setString(2, prod);
                ResultSet result = preSt.executeQuery();
                int cant = 0;
                if(result.next()){
                    cant = Integer.parseInt(result.getString(1));
                }                 
                result.close();
                con.closeConnection();//cerramos conexion
                
                return cant;               
                
            }catch(SQLException e){
                System.out.println(e.getMessage());
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(OpcionEmp.class.getName()).log(Level.SEVERE, null, ex);
        }    
        
        return 0;        
    }
    //buscar pedidos por entregar al cliente
    public LinkedList conPedidos(){
        
        ConnectionDB con = new ConnectionDB();
        try( Connection connection = con.getConnection()){
            String query = "select codigo from pedido where tienda_d=? and recorrido_finalizado=1 and venta_id is null";
            
            try(PreparedStatement preSt = connection.prepareStatement(query)){
                preSt.setString(1, tienda_actual);
                ResultSet result = preSt.executeQuery();
                LinkedList list_cods = new LinkedList();
                while(result.next()){
                    list_cods.offer(result.getString(1));
                }
                result.close();
                con.closeConnection();//cerramos conexion
                return list_cods;
            }catch(SQLException e){
                System.out.println(e.getMessage());
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(OpcionEmp.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    //ultimo pedido creado
    public int lastPedido(){
        ConnectionDB con = new ConnectionDB();
        try( Connection connection = con.getConnection()){
            String query = "select codigo from pedido order by codigo desc limit 1;";
            
            try(PreparedStatement preSt = connection.prepareStatement(query)){
                ResultSet result = preSt.executeQuery();
                int cant = 0;
                if(result.next()){
                    cant = Integer.parseInt(result.getString(1));
                }                 
                result.close();
                con.closeConnection();//cerramos conexion
                
                return cant;               
                
            }catch(SQLException e){
                System.out.println(e.getMessage());
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(OpcionEmp.class.getName()).log(Level.SEVERE, null, ex);
        }    
        
        return 0; 
        
    }
    
    //ultima venta creada
    
    public int lastVenta(){
        ConnectionDB con = new ConnectionDB();
        try( Connection connection = con.getConnection()){
            String query = "select id from venta order by id desc limit 1;";
            
            try(PreparedStatement preSt = connection.prepareStatement(query)){
                ResultSet result = preSt.executeQuery();
                int cant = 0;
                if(result.next()){
                    cant = Integer.parseInt(result.getString(1));
                }                 
                result.close();
                con.closeConnection();//cerramos conexion
                
                return cant;               
                
            }catch(SQLException e){
                System.out.println(e.getMessage());
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(OpcionEmp.class.getName()).log(Level.SEVERE, null, ex);
        }    
        
        return 0; 
        
    
    }
        
  
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ConnectionSQL;

import Frontend.OpcionEmp;
import static Frontend.SignEmp.tienda_actual;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author chejohrpp
 */
public class Reportes {
    ConnectionDB con = new ConnectionDB();
    Connection connection;
    public Reportes(){
        connection = con.getConnection();
    }
    //Reporte de pedidos en la tienda
    public void report1PedTien(LinkedList cod,LinkedList TO,LinkedList nit,LinkedList total,LinkedList ant){
        String query = "select codigo,tienda_o,cliente_nit,total,anticipo from pedido where tienda_d = ? and (recorrido_finalizado = 0 or recorrido_finalizado is null)";
         try( Connection connection = con.getConnection()){
            try(PreparedStatement preSt = connection.prepareStatement(query)){
                preSt.setString(1, tienda_actual);
                ResultSet result = preSt.executeQuery();               
                while (result.next()) {
                    cod.offer(result.getString(1));
                    TO.offer(result.getString(2));
                    nit.offer(result.getString(3));
                    total.offer(result.getString(4));
                    ant.offer(result.getString(5));
                }               
                result.close();
                con.closeConnection();//cerramos conexionS
                
            }catch(SQLException e){
                System.out.println(e.getMessage());
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(OpcionEmp.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    //Reportes pedido que están en tiempo de estar en la tienda pero debe verificarse su ingreso.
    public void report2(){
        
    }
    //Reporte de todos los pedidos atrasados que llegarán a la tienda
    public void report3(LinkedList cod,LinkedList TO,LinkedList nit,LinkedList total,LinkedList ant){
        String query = "select codigo,tienda_o,cliente_nit,total,anticipo from pedido where tienda_d = ? and (tiempo_cumplido =0) and (recorrido_finalizado = 0 or recorrido_finalizado is null)";
         try( Connection connection = con.getConnection()){
            try(PreparedStatement preSt = connection.prepareStatement(query)){
                preSt.setString(1, tienda_actual);
                ResultSet result = preSt.executeQuery();               
                while (result.next()) {
                    cod.offer(result.getString(1));
                    TO.offer(result.getString(2));
                    nit.offer(result.getString(3));
                    total.offer(result.getString(4));
                    ant.offer(result.getString(5));
                }               
                result.close();
                con.closeConnection();//cerramos conexionS
                
            }catch(SQLException e){
                System.out.println(e.getMessage());
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(OpcionEmp.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    //Reporte  de todos los pedidos que salieron de la tienda y están en tránsito.
    public void report4(LinkedList cod,LinkedList TD,LinkedList nit,LinkedList total,LinkedList ant){
        String query = "select codigo,tienda_d,cliente_nit,total,anticipo from pedido where tienda_o = ? and (recorrido_finalizado = 0 or recorrido_finalizado is null)";
         try( Connection connection = con.getConnection()){
            try(PreparedStatement preSt = connection.prepareStatement(query)){
                preSt.setString(1, tienda_actual);
                ResultSet result = preSt.executeQuery();               
                while (result.next()) {
                    cod.offer(result.getString(1));
                    TD.offer(result.getString(2));
                    nit.offer(result.getString(3));
                    total.offer(result.getString(4));
                    ant.offer(result.getString(5));
                }               
                result.close();
                con.closeConnection();//cerramos conexionS
                
            }catch(SQLException e){
                System.out.println(e.getMessage());
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(OpcionEmp.class.getName()).log(Level.SEVERE, null, ex);
        }        
    }
    //Reporte todas las compras realizadas por un cliente.
    public void report5(String NIt,LinkedList nit,LinkedList nombre,LinkedList cant){
        String query = "select v.cliente_nit,p.nombre,av.cantidad from venta v,producto p,articulo_vendido av where v.cliente_nit=? and v.id=av.venta_id and p.codigo=av.producto_codigo;";
         try( Connection connection = con.getConnection()){
            try(PreparedStatement preSt = connection.prepareStatement(query)){
                preSt.setString(1, NIt);
                ResultSet result = preSt.executeQuery();               
                while (result.next()) {
                    nit.offer(result.getString(1));
                    nombre.offer(result.getString(2));
                    cant.offer(result.getString(3));
                }               
                result.close();
                con.closeConnection();//cerramos conexionS
                
            }catch(SQLException e){
                System.out.println(e.getMessage());
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(OpcionEmp.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    //Reporte  todos los pedidos en curso de un cliente.
    public void report6(String Nit,LinkedList nit,LinkedList cod,LinkedList TO,LinkedList TD,LinkedList total,LinkedList ant){
        String query = "select cliente_nit,codigo,tienda_o,tienda_d,total,anticipo from pedido where cliente_nit = ? and (recorrido_finalizado = 0 or recorrido_finalizado is null)";
         try( Connection connection = con.getConnection()){
            try(PreparedStatement preSt = connection.prepareStatement(query)){
                preSt.setString(1, Nit);
                ResultSet result = preSt.executeQuery();               
                while (result.next()) {
                    nit.offer(result.getString(1));
                    cod.offer(result.getString(2));
                    TO.offer(result.getString(3));
                    TD.offer(result.getString(4));
                    total.offer(result.getString(5));
                    ant.offer(result.getString(6));
                }               
                result.close();
                con.closeConnection();//cerramos conexionS
                
            }catch(SQLException e){
                System.out.println(e.getMessage());
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(OpcionEmp.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    //Reporte de los diez productos más vendidos en un intervalo de tiempo. 
    public void report7(){
        
    }
    
    //Reporte  de los productos más vendidos por tienda en un intervalo de tiempo. 
    public void report8(){
        
    }
    
    //Reportes de productos que nunca se han vendido por tienda.
    public void report9(){
        
    }
    
}

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
public class Listados {
    ConnectionDB con = new ConnectionDB();
    Connection connection;
    public Listados(){
        connection = con.getConnection();
    }
    //metodos para la lista de tienda
    public void listTiendas(LinkedList codigo,LinkedList nombre,LinkedList dir,LinkedList tel1,LinkedList tel2,LinkedList email,LinkedList hor){
        String query = "SELECT codigo,nombre,direccion,telefono1,telefono2,email,horario FROM tienda Order By nombre";
        
        try( Connection connection = con.getConnection()){            
            try(PreparedStatement preSt = connection.prepareStatement(query)){                           
                ResultSet result = preSt.executeQuery();               
                while (result.next()) {
                    codigo.offer(result.getString(1));
                    nombre.offer(result.getString(2));
                    dir.offer(result.getString(3));
                    tel1.offer(result.getString(4));
                    tel2.offer(result.getString(5));
                    email.offer(result.getString(6));
                    hor.offer(result.getString(7));
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
     public void listTiendasName(String name,LinkedList codigo,LinkedList nombre,LinkedList dir,LinkedList tel1,LinkedList tel2,LinkedList email,LinkedList hor){
        String query = "SELECT codigo,nombre,direccion,telefono1,telefono2,email,horario FROM tienda WHERE nombre like ? Order By nombre";
        
        try( Connection connection = con.getConnection()){            
            try(PreparedStatement preSt = connection.prepareStatement(query)){
                preSt.setString(1, "%" + name + "%");
                ResultSet result = preSt.executeQuery();               
                while (result.next()) {
                    codigo.offer(result.getString(1));
                    nombre.offer(result.getString(2));
                    dir.offer(result.getString(3));
                    tel1.offer(result.getString(4));
                    tel2.offer(result.getString(5));
                    email.offer(result.getString(6));
                    hor.offer(result.getString(7));
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
    public void listTiendasCod(String cod,LinkedList codigo,LinkedList nombre,LinkedList dir,LinkedList tel1,LinkedList tel2,LinkedList email,LinkedList hor){
        String query = "SELECT codigo,nombre,direccion,telefono1,telefono2,email,horario FROM tienda WHERE codigo like ? Order By nombre";
        
        try( Connection connection = con.getConnection()){            
            try(PreparedStatement preSt = connection.prepareStatement(query)){
                preSt.setString(1, "%" + cod + "%");
                ResultSet result = preSt.executeQuery();               
                while (result.next()) {
                    codigo.offer(result.getString(1));
                    nombre.offer(result.getString(2));
                    dir.offer(result.getString(3));
                    tel1.offer(result.getString(4));
                    tel2.offer(result.getString(5));
                    email.offer(result.getString(6));
                    hor.offer(result.getString(7));
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
    //metodos para la lista de los tiempos
    public void listTiemp(LinkedList tienda1,LinkedList tienda2,LinkedList tiempo){
        String query = "SELECT tienda1,tienda2,tiempo FROM tiempo_envio where tienda1 =? or tienda2=? Order By tiempo";
        
        try( Connection connection = con.getConnection()){            
            try(PreparedStatement preSt = connection.prepareStatement(query)){
                preSt.setString(1, tienda_actual);
                preSt.setString(2, tienda_actual);
                ResultSet result = preSt.executeQuery();        
                while (result.next()) {
                    tienda1.offer(result.getString(1));
                    tienda2.offer(result.getString(2));
                    tiempo.offer(result.getString(3));
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
    
    
    //metodos parar la lista cliente
    public void listCLiente(LinkedList nit,LinkedList nombre,LinkedList dir,LinkedList tel,LinkedList dpi,LinkedList email,LinkedList credito){
        String query = "SELECT nit,nombre,direccion,telefono,dpi,email,credito FROM cliente Order By nit";
        
        try( Connection connection = con.getConnection()){            
            try(PreparedStatement preSt = connection.prepareStatement(query)){                           
                ResultSet result = preSt.executeQuery();               
                while (result.next()) {
                    nit.offer(result.getString(1));
                    nombre.offer(result.getString(2));
                    dir.offer(result.getString(3));
                    tel.offer(result.getString(4));
                    dpi.offer(result.getString(5));
                    email.offer(result.getString(6));
                    credito.offer(result.getString(7));
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
    
    public void listCLienteName(String name,LinkedList nit,LinkedList nombre,LinkedList dir,LinkedList tel,LinkedList dpi,LinkedList email,LinkedList credito){
        String query = "SELECT nit,nombre,direccion,telefono,dpi,email,credito FROM cliente WHERE nombre like ? Order By nit";
        
        try( Connection connection = con.getConnection()){            
            try(PreparedStatement preSt = connection.prepareStatement(query)){
                preSt.setString(1, "%" + name + "%");
                ResultSet result = preSt.executeQuery();               
                while (result.next()) {
                    nit.offer(result.getString(1));
                    nombre.offer(result.getString(2));
                    dir.offer(result.getString(3));
                    tel.offer(result.getString(4));
                    dpi.offer(result.getString(5));
                    email.offer(result.getString(6));
                    credito.offer(result.getString(7));
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
    public void listCLienteNit(String NIT,LinkedList nit,LinkedList nombre,LinkedList dir,LinkedList tel,LinkedList dpi,LinkedList email,LinkedList credito){
        String query = "SELECT nit,nombre,direccion,telefono,dpi,email,credito FROM cliente WHERE nit like ? Order By nit";
        
        try( Connection connection = con.getConnection()){            
            try(PreparedStatement preSt = connection.prepareStatement(query)){
                preSt.setString(1, "%" + NIT + "%");
                ResultSet result = preSt.executeQuery();               
                while (result.next()) {
                    nit.offer(result.getString(1));
                    nombre.offer(result.getString(2));
                    dir.offer(result.getString(3));
                    tel.offer(result.getString(4));
                    dpi.offer(result.getString(5));
                    email.offer(result.getString(6));
                    credito.offer(result.getString(7));
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
    
    //metodos para la lista de productos
    public void listProd(LinkedList codigo,LinkedList nombre,LinkedList fab,LinkedList pre,LinkedList garant,LinkedList desc){
        String query = "SELECT codigo,nombre,fabricante,precio,garantia,descripcion FROM producto Order By codigo";
        
        try( Connection connection = con.getConnection()){            
            try(PreparedStatement preSt = connection.prepareStatement(query)){                           
                ResultSet result = preSt.executeQuery();               
                while (result.next()) {
                    codigo.offer(result.getString(1));
                    nombre.offer(result.getString(2));
                    fab.offer(result.getString(3));
                    pre.offer(result.getString(4));
                    garant.offer(result.getString(5));
                    desc.offer(result.getString(6));

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
    
    public void listProdName(String name,LinkedList codigo,LinkedList nombre,LinkedList fab,LinkedList pre,LinkedList garant,LinkedList desc){
        String query = "SELECT codigo,nombre,fabricante,precio,garantia,descripcion FROM producto WHERE nombre like ? Order By codigo";
        
        try( Connection connection = con.getConnection()){            
            try(PreparedStatement preSt = connection.prepareStatement(query)){ 
                preSt.setString(1, "%" + name + "%");
                ResultSet result = preSt.executeQuery();       
                while (result.next()) {
                    codigo.offer(result.getString(1));
                    nombre.offer(result.getString(2));
                    fab.offer(result.getString(3));
                    pre.offer(result.getString(4));
                    garant.offer(result.getString(5));
                    desc.offer(result.getString(6));

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
    
    public void listProdCod(String cod,LinkedList codigo,LinkedList nombre,LinkedList fab,LinkedList pre,LinkedList garant,LinkedList desc){
        String query = "SELECT codigo,nombre,fabricante,precio,garantia,descripcion FROM producto WHERE codigo like ? Order By codigo";
        
        try( Connection connection = con.getConnection()){            
            try(PreparedStatement preSt = connection.prepareStatement(query)){ 
                preSt.setString(1, "%" + cod + "%");
                ResultSet result = preSt.executeQuery();       
                while (result.next()) {
                    codigo.offer(result.getString(1));
                    nombre.offer(result.getString(2));
                    fab.offer(result.getString(3));
                    pre.offer(result.getString(4));
                    garant.offer(result.getString(5));
                    desc.offer(result.getString(6));

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
    
    
    
    //metodos para la lista de empleados
    public void listEmp(LinkedList codigo,LinkedList nombre,LinkedList dir,LinkedList tel,LinkedList dpi,LinkedList email,LinkedList nit){
        String query = "SELECT codigo,nombre,direccion,telefono,dpi,email,nit FROM empleado Order By codigo";
        
        try( Connection connection = con.getConnection()){            
            try(PreparedStatement preSt = connection.prepareStatement(query)){                           
                ResultSet result = preSt.executeQuery();               
                while (result.next()) {
                    codigo.offer(result.getString(1));
                    nombre.offer(result.getString(2));
                    dir.offer(result.getString(3));
                    tel.offer(result.getString(4));
                    dpi.offer(result.getString(5));
                    email.offer(result.getString(6));
                    nit.offer(result.getString(7));
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
    
    public void listEmpName(String name , LinkedList codigo,LinkedList nombre,LinkedList dir,LinkedList tel,LinkedList dpi,LinkedList email,LinkedList nit){
        String query = "SELECT codigo,nombre,direccion,telefono,dpi,email,nit FROM empleado WHERE nombre like ? Order By codigo";
        
        try( Connection connection = con.getConnection()){            
            try(PreparedStatement preSt = connection.prepareStatement(query)){
                preSt.setString(1, "%" + name + "%");
                ResultSet result = preSt.executeQuery();               
                while (result.next()) {
                    codigo.offer(result.getString(1));
                    nombre.offer(result.getString(2));
                    dir.offer(result.getString(3));
                    tel.offer(result.getString(4));
                    dpi.offer(result.getString(5));
                    email.offer(result.getString(6));
                    nit.offer(result.getString(7));
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
    public void listEmpCod(String cod , LinkedList codigo,LinkedList nombre,LinkedList dir,LinkedList tel,LinkedList dpi,LinkedList email,LinkedList nit){
        String query = "SELECT codigo,nombre,direccion,telefono,dpi,email,nit FROM empleado WHERE codigo like ? Order By codigo";
        
        try( Connection connection = con.getConnection()){            
            try(PreparedStatement preSt = connection.prepareStatement(query)){
                preSt.setString(1, "%" + cod + "%");
                ResultSet result = preSt.executeQuery();               
                while (result.next()) {
                    codigo.offer(result.getString(1));
                    nombre.offer(result.getString(2));
                    dir.offer(result.getString(3));
                    tel.offer(result.getString(4));
                    dpi.offer(result.getString(5));
                    email.offer(result.getString(6));
                    nit.offer(result.getString(7));
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
}

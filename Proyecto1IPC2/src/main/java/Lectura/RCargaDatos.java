/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lectura;

import Frontend.PostCargaDatos;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Stack;
import source.CargarDatosEx;

/**
 *
 * @author chejohrpp
 */
public class RCargaDatos {
     public static LinkedList error_registro = new LinkedList(); //se crea la cola para mostar los errores de registro
    public static LinkedList bien_registro = new LinkedList();;//creamos una cola para colocar los datos ingresados correctamente a laDB
    public RCargaDatos(){
        
    }
    //leera la base de datos
    public void readDatos(String path){
        BufferedReader reader;
        try {
                reader = new BufferedReader(new FileReader(path));
                String linea = reader.readLine();   
                int i = 1;
                while (linea != null) {
                        //System.out.println(linea);
                        String[] registro = linea.split(",");
                        CargarDatosEx dato = new CargarDatosEx(registro,i,linea);//creamos el objeto que clasificara al registro
                        dato.registrarDB(); // lo ingresara a la BD                        
                        linea = reader.readLine();  //lee la siguiente linea del txt 
                        i++;
                }                
                reader.close();
                PostCargaDatos resultado = new PostCargaDatos();
                resultado.setLocationRelativeTo(null);
                resultado.setVisible(true);
                
        } catch (IOException e) {
                e.printStackTrace();
        }
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package source;

import ConnectionSQL.AgregarDB;
import java.text.NumberFormat;
import javax.swing.JFormattedTextField;
import javax.swing.JTextField;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.NumberFormatter;

/**
 *
 * @author chejohrpp
 */
public class TimesUI {
    public final int ESPACIO_INGRESO_PIXELES = 40;
    public final int ESPACIO_INTERMEDIO = 50;
    public final int ALTO_TEXT = 30;
    public final int ANCHO_TEXT = 125;

    private JTextField cod_tienda;
    private JFormattedTextField tiempo;
    //nos servira para agregar los tiempos cuando creamos una tienda
    public TimesUI(String cod){
        this.cod_tienda =  new JTextField();
        this.tiempo =  new JFormattedTextField();
        tiempo.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(NumberFormat.getIntegerInstance())));
        cod_tienda.setEnabled(false);
        cod_tienda.setText(cod);
    }

    public JTextField getCod_tienda() {
        return cod_tienda;
    }    

    public JFormattedTextField getTiempo() {
        return tiempo;
    }
    
    //modificamos los objetos para que se vean mejor
        public void setBounds(int position) {
        int yPosition = (ESPACIO_INGRESO_PIXELES * position) + ESPACIO_INTERMEDIO;
        
        cod_tienda.setBounds(ESPACIO_INTERMEDIO * 2 + 75, yPosition, ANCHO_TEXT, ALTO_TEXT);
        tiempo.setBounds(ESPACIO_INTERMEDIO * 3 + ANCHO_TEXT +75, yPosition, ANCHO_TEXT / 2, ALTO_TEXT);
    }
        
    //verificamos que no este vacio
    public boolean isEmpty() {
        return (tiempo.getText().replaceAll(" ", "").isEmpty());
    }
    //agregamos los tiempos a la base de datos
    public void addTiempo(String tienda1){
        try{
             AgregarDB agregar = new AgregarDB();
            agregar.addTiempo(tienda1, cod_tienda.getText(), Integer.parseInt(tiempo.getText()));
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
       
    }
    
}

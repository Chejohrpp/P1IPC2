/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Frontend.Listados;

import ConnectionSQL.Listados;
import java.util.LinkedList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author chejohrpp
 */
public class ListTimes extends javax.swing.JInternalFrame {
     private DefaultTableModel dfm = new DefaultTableModel();
    private LinkedList tiempo = new LinkedList();
    private LinkedList tienda1 = new LinkedList();
    private LinkedList tienda2 = new LinkedList();
    /**
     * Creates new form ListTimes
     */
    public ListTimes() {
        initComponents();
        
        dfm = (DefaultTableModel) jList.getModel();
        Listados lista = new Listados();
        lista.listTiemp(tienda1, tienda2, tiempo);
        generar();
    }
    private void generar(){
         //Limpiar listado
       int cantRow = jList.getRowCount();
        for (int i = cantRow-1; i >= 0; i--) {
            dfm.removeRow(i);
        }
        
        //Agregar listado
        while (tiempo.peek() != null) {            
                String data[] = {(String)tiempo.poll(),(String)tienda1.poll(),(String)tienda2.poll()};
                dfm.addRow(data);
        }
        
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jList = new javax.swing.JTable();

        setClosable(true);
        setTitle("Listado tiempo");

        jList.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Tiempo", "tienda 1", "tienda 2"
            }
        ));
        jScrollPane1.setViewportView(jList);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 681, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 681, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable jList;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}

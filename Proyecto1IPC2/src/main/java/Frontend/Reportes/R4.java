/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Frontend.Reportes;

import ConnectionSQL.Reportes;
import java.util.LinkedList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author chejohrpp
 */
public class R4 extends javax.swing.JInternalFrame {
    private DefaultTableModel dfm = new DefaultTableModel();
    private LinkedList cod = new LinkedList();
    private LinkedList TO = new LinkedList();
    private LinkedList nit = new LinkedList();
    private LinkedList total = new LinkedList();
    private LinkedList ant = new LinkedList();
    /**
     * Creates new form R4
     */
    public R4() {
        initComponents();
    dfm = (DefaultTableModel) jList.getModel();
        Reportes rep = new Reportes();
        rep.report4(cod, TO, nit, total, ant);
        generar();
    }
    private void generar(){
         //Limpiar listado
       int cantRow = jList.getRowCount();
        for (int i = cantRow-1; i >= 0; i--) {
            dfm.removeRow(i);
        }
        
        //Agregar listado
        while (cod.peek() != null) {            
                String data[] = {(String)cod.poll(),(String)TO.poll(),(String)nit.poll(),(String)total.poll(),
                    (String)ant.poll()};
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
        setTitle("Reporte  de todos los pedidos que salieron de la tienda y están en tránsito.");

        jList.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo", "Tienda de destino", "NIT del cliente", "Total", "Anticipo"
            }
        ));
        jScrollPane1.setViewportView(jList);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 738, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 601, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable jList;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
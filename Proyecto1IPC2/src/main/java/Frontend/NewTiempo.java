/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Frontend;

import ConnectionSQL.ConsultasVarias;
import ConnectionSQL.ModDB;
import static Frontend.SignEmp.tienda_actual;
import java.text.NumberFormat;
import java.util.LinkedList;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.NumberFormatter;

/**
 *
 * @author chejohrpp
 */
public class NewTiempo extends javax.swing.JFrame {
    private boolean or;
    /**
     * Creates new form newTiempo
     */
    public NewTiempo() {
        initComponents();
        agregarTienda();
        colocarTime();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        btnIngresar = new javax.swing.JButton();
        cmbTienda = new javax.swing.JComboBox<>();
        btnCancelar = new javax.swing.JButton();
        txtTiempo = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jLabel1.setFont(new java.awt.Font("Ubuntu", 0, 36)); // NOI18N
        jLabel1.setText("Ingreso de tiempo entre tiendas");

        jLabel2.setFont(new java.awt.Font("Ubuntu", 0, 24)); // NOI18N
        jLabel2.setText("Tienda de destino");

        jLabel3.setFont(new java.awt.Font("Ubuntu", 0, 24)); // NOI18N
        jLabel3.setText("Tiempo(en dias)");

        btnIngresar.setFont(new java.awt.Font("Ubuntu", 0, 24)); // NOI18N
        btnIngresar.setText("Guardar");
        btnIngresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIngresarActionPerformed(evt);
            }
        });

        cmbTienda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbTiendaActionPerformed(evt);
            }
        });

        btnCancelar.setFont(new java.awt.Font("Ubuntu", 0, 24)); // NOI18N
        btnCancelar.setText("Regresar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(153, 153, 153)
                        .addComponent(jLabel1)
                        .addGap(204, 204, 204))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnIngresar)
                                .addGap(123, 123, 123)
                                .addComponent(btnCancelar))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel2))
                                .addGap(175, 175, 175)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cmbTienda, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtTiempo))))
                        .addGap(161, 161, 161))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(jLabel1)
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(cmbTienda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtTiempo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(11, 11, 11)))
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnIngresar)
                    .addComponent(btnCancelar))
                .addContainerGap(59, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        // TODO add your handling code here:
        OpcionEmp op_emp = new OpcionEmp();
        op_emp.setLocationRelativeTo(null);
        this.dispose();
        op_emp.setVisible(true);
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void cmbTiendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbTiendaActionPerformed
        // TODO add your handling code here:
        ConsultasVarias consulta = new ConsultasVarias();
        or = consulta.colocTime(txtTiempo,cmbTienda.getSelectedItem().toString());
    }//GEN-LAST:event_cmbTiendaActionPerformed

    private void btnIngresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIngresarActionPerformed
        // TODO add your handling code here:
        try{
            String tienda_d = cmbTienda.getSelectedItem().toString();
            int tiempo = Integer.parseInt(txtTiempo.getText());
            if (or) {
                ModDB mod = new ModDB();
                mod.ModTiempo1(this, tienda_actual, tienda_d, tiempo);
            }else{
                ModDB mod = new ModDB();
                mod.ModTiempo2(this, tienda_actual, tienda_d, tiempo);
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Ingrese bien el tiempo", "ERORR", JOptionPane.ERROR_MESSAGE);  
        }
        
    }//GEN-LAST:event_btnIngresarActionPerformed

    private void agregarTienda(){
        ConsultasVarias consulta = new ConsultasVarias();
        LinkedList tiendas = consulta.codTiendas(tienda_actual);
        while(tiendas.peek() != null){
            String data = (String) tiendas.poll();
            cmbTienda.addItem(data);
        }
    }
    private void colocarTime(){
        ConsultasVarias consulta = new ConsultasVarias();
        or = consulta.colocTime(txtTiempo,cmbTienda.getSelectedItem().toString());    
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnIngresar;
    private javax.swing.JComboBox<String> cmbTienda;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JTextField txtTiempo;
    // End of variables declaration//GEN-END:variables
}

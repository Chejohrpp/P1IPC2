/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Frontend;

import ConnectionSQL.AgregarDB;
import ConnectionSQL.ConnectionDB;
import ConnectionSQL.ConsultasVarias;
import ConnectionSQL.ModDB;
import static Frontend.SignEmp.tienda_actual;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

/**
 *
 * @author chejohrpp
 */
public class NewArt extends javax.swing.JFrame {
    private boolean or;
    private String prod;
    /**
     * Creates new form NewArt
     */
    public NewArt() {
        initComponents();
        buscarProduct();
        ConsultasVarias cons = new ConsultasVarias();
        or = cons.art(txtCant, prod);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblName = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        lblCod = new javax.swing.JLabel();
        txtCant = new javax.swing.JTextField();
        btnRegresar = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblName.setFont(new java.awt.Font("Ubuntu", 0, 36)); // NOI18N
        lblName.setText("Nombre");

        jLabel2.setFont(new java.awt.Font("Ubuntu", 0, 24)); // NOI18N
        jLabel2.setText("Cantidad");

        lblCod.setFont(new java.awt.Font("Ubuntu", 0, 48)); // NOI18N
        lblCod.setText("CODIGO");

        txtCant.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCantActionPerformed(evt);
            }
        });

        btnRegresar.setFont(new java.awt.Font("Ubuntu", 0, 24)); // NOI18N
        btnRegresar.setText("Regresar");
        btnRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarActionPerformed(evt);
            }
        });

        btnGuardar.setFont(new java.awt.Font("Ubuntu", 0, 24)); // NOI18N
        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblCod)
                .addGap(271, 271, 271))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(256, 256, 256)
                        .addComponent(lblName))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(52, 52, 52)
                        .addComponent(jLabel2)
                        .addGap(49, 49, 49)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtCant, javax.swing.GroupLayout.PREFERRED_SIZE, 324, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnGuardar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnRegresar)
                                .addGap(43, 43, 43)))))
                .addContainerGap(166, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(lblCod)
                .addGap(18, 18, 18)
                .addComponent(lblName)
                .addGap(78, 78, 78)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtCant, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 83, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRegresar)
                    .addComponent(btnGuardar))
                .addGap(50, 50, 50))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtCantActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCantActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCantActionPerformed

    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed
        // TODO add your handling code here:
        OpcionEmp emp = new OpcionEmp();
        emp.setLocationRelativeTo(null);
        emp.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnRegresarActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        // TODO add your handling code here:
        ModArt(prod);        
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void ModArt(String produc){
        try{
            int cant = Integer.parseInt(txtCant.getText());
            String tienda = tienda_actual;
            
            if (or) {
                ModDB mod = new ModDB();
                mod.ModArt(this, tienda, produc, cant);
            }else{
                AgregarDB agregar = new AgregarDB();
                agregar.addArt(this, tienda, produc, cant);
            }
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Ingrese bien la Cantidad", "ERORR", JOptionPane.ERROR_MESSAGE);
        }
    }
    private void buscarProduct(){
        ConnectionDB con = new ConnectionDB();       
        try( Connection connection = con.getConnection()){
            String query = "SELECT codigo FROM producto"; 
            
            try(PreparedStatement preSt = connection.prepareStatement(query)){
                ResultSet result = preSt.executeQuery();
                JComboBox camProduc = new JComboBox();//creamos un JComboBox
                //agregamos los nombres al JComboBox
                while(result.next()){
                    camProduc.addItem(result.getString(1));
                }
                //hacemos que el usuario seleccione el codigo del producto
                //camProduc.setEditable(true);
                JOptionPane.showMessageDialog(null, camProduc, "Seleccione el codigo del Producto", JOptionPane.QUESTION_MESSAGE);
                String codigo = camProduc.getSelectedItem().toString();
                //colocamos el codigo en la caja de texto
                lblCod.setText(codigo);
                prod = codigo;
                llenar(codigo,connection);
                result.close();
                con.closeConnection();//cerramos conexion
            }catch(SQLException e){
                System.out.println(e.getMessage());
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
    }
    private void llenar(String codigo,Connection connection){
        String query = "SELECT nombre from producto WHERE codigo= ?";
        try(PreparedStatement preSt = connection.prepareStatement(query)){
            preSt.setString(1, codigo);
            
            ResultSet result = preSt.executeQuery();            
            //agregamos los datos a los text Field
            if (result.next()) {
                lblName.setText(result.getString(1));
            } 
            result.close();
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
    }
    
    
    
    
    
    
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnRegresar;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel lblCod;
    private javax.swing.JLabel lblName;
    private javax.swing.JTextField txtCant;
    // End of variables declaration//GEN-END:variables
}

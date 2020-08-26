/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Frontend;

import ConnectionSQL.AgregarDB;
import ConnectionSQL.ConnectionDB;
import ConnectionSQL.ModDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

/**
 *
 * @author chejohrpp
 */
public class NewProducto extends javax.swing.JFrame {
    private boolean ingreso = true;
    /**
     * Creates new form NewProducto
     */
    public NewProducto() {
        ingreso = true;
        initComponents();
    }
    public NewProducto(String titulo) {
        ingreso = false;
        initComponents();
        lblTitulo.setText(titulo);
        txtCod.setEnabled(false);
        btnIngresar.setText("Guardar Cambios");
        lblCant.setVisible(false);
        txtCant.setVisible(false);
        buscarProduct();
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

        jLabel10 = new javax.swing.JLabel();
        lblCant = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        btnIngresar = new javax.swing.JButton();
        lblTitulo = new javax.swing.JLabel();
        txtDescripcion = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtCod = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtFabricante = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        btnCancelar = new javax.swing.JButton();
        txtPrecio = new javax.swing.JTextField();
        txtGarant = new javax.swing.JTextField();
        txtCant = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();

        jLabel10.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        jLabel10.setText("* campos obligatorios");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        lblCant.setFont(new java.awt.Font("Ubuntu", 0, 24)); // NOI18N
        lblCant.setText("Cantidad*");

        jLabel6.setFont(new java.awt.Font("Ubuntu", 0, 24)); // NOI18N
        jLabel6.setText("Precio*");

        btnIngresar.setFont(new java.awt.Font("Ubuntu", 0, 24)); // NOI18N
        btnIngresar.setText("Ingresar");
        btnIngresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIngresarActionPerformed(evt);
            }
        });

        lblTitulo.setFont(new java.awt.Font("Ubuntu", 0, 36)); // NOI18N
        lblTitulo.setText("Ingreso de nuevo Producto");

        jLabel2.setFont(new java.awt.Font("Ubuntu", 0, 24)); // NOI18N
        jLabel2.setText("Codigo*");

        jLabel7.setFont(new java.awt.Font("Ubuntu", 0, 24)); // NOI18N
        jLabel7.setText("Descripcion");

        jLabel3.setFont(new java.awt.Font("Ubuntu", 0, 24)); // NOI18N
        jLabel3.setText("Nombre*");

        jLabel9.setFont(new java.awt.Font("Ubuntu", 0, 24)); // NOI18N
        jLabel9.setText("Garantia");

        jLabel4.setFont(new java.awt.Font("Ubuntu", 0, 24)); // NOI18N
        jLabel4.setText("Fabricante*");

        jLabel11.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        jLabel11.setText("* campos obligatorios");

        btnCancelar.setFont(new java.awt.Font("Ubuntu", 0, 24)); // NOI18N
        btnCancelar.setText("Regresar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        txtPrecio.setText(" ");

        txtGarant.setText(" ");

        txtCant.setText(" ");

        jLabel1.setText("coloque 0 si no hay garantia");

        jLabel8.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        jLabel8.setText("meses");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(193, 193, 193)
                .addComponent(lblTitulo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel11)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel4)
                                        .addComponent(lblCant))
                                    .addGap(148, 148, 148))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addComponent(jLabel3)
                                    .addGap(175, 175, 175)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel9))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnIngresar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnCancelar))
                            .addComponent(txtFabricante)
                            .addComponent(txtName)
                            .addComponent(txtCod)
                            .addComponent(txtDescripcion)
                            .addComponent(txtPrecio)
                            .addComponent(txtGarant)
                            .addComponent(txtCant))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel8)
                        .addGap(158, 158, 158))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(lblTitulo))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel11)))
                .addGap(42, 42, 42)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel4)
                        .addGap(18, 18, 18))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtCod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtFabricante, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblCant)
                    .addComponent(txtCant, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(txtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txtGarant, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnIngresar)
                    .addComponent(btnCancelar))
                .addGap(85, 85, 85))
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

    private void btnIngresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIngresarActionPerformed
        // TODO add your handling code here:
        try{
            String cod = txtCod.getText();
            String nombre = txtName.getText();
            String fab = txtFabricante.getText();
            double precio = Double.parseDouble(txtPrecio.getText());
            int garantia = Integer.parseInt(txtGarant.getText());
            String desc = txtDescripcion.getText();            
            if (ingreso) {
                int cantidad = Integer.parseInt(txtCant.getText());
                ingresar(cod,nombre,fab,precio,garantia,desc,cantidad);
            }else{
                mod(cod,nombre,fab,precio,garantia,desc);
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null, "Ingrese bien los datos \n  sugerencia: quite los espacios en cantidad,precio o garantia", "ERORR", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnIngresarActionPerformed

    private void ingresar(String cod, String nombre, String fab, double precio, int garantia,String desc,int cantidad){
        try{
            AgregarDB agregar = new AgregarDB();
            agregar.addProducto(this,cod, nombre, fab, precio, garantia, desc, cantidad);
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        
    }
    private void mod(String cod, String nombre, String fab, double precio, int garantia,String desc){
        try{
            ModDB mod = new ModDB();
            mod.ModProducto(this,cod, nombre, fab, precio, garantia, desc);
        }catch(Exception e){
            System.out.println(e.getMessage());
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
                txtCod.setText(codigo);
                llenar(codigo,connection);
                result.close();
                con.closeConnection();//cerramos conexion
            }catch(SQLException e){
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(OpcionEmp.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
      private void llenar(String codigo,Connection connection){
        String query = "SELECT nombre,fabricante,precio,garantia,descripcion from producto WHERE codigo= ?";
        try(PreparedStatement preSt = connection.prepareStatement(query)){
            preSt.setString(1, codigo);
            
            ResultSet result = preSt.executeQuery();            
            //agregamos los datos a los text Field
            if (result.next()) {
                txtName.setText(result.getString(1));
                txtFabricante.setText(result.getString(2));
                txtPrecio.setText(result.getString(3));
                txtGarant.setText(result.getString(4));
                txtDescripcion.setText(result.getString(5));
                
            } 
            result.close();
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
    }
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnIngresar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel lblCant;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JTextField txtCant;
    private javax.swing.JTextField txtCod;
    private javax.swing.JTextField txtDescripcion;
    private javax.swing.JTextField txtFabricante;
    private javax.swing.JTextField txtGarant;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtPrecio;
    // End of variables declaration//GEN-END:variables
}

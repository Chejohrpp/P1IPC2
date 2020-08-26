/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Frontend;

/**
 *
 * @author chejohrpp
 */
public class OpcionCliente extends javax.swing.JFrame {

    /**
     * Creates new form OpcionCliente
     */
    public OpcionCliente() {
        initComponents();
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
        btnRastrear = new javax.swing.JButton();
        btnBack = new javax.swing.JButton();
        btnBusProducto = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Ubuntu", 0, 48)); // NOI18N
        jLabel1.setText("Cliente");

        btnRastrear.setFont(new java.awt.Font("Ubuntu", 0, 36)); // NOI18N
        btnRastrear.setText("Rastrear Pedido");
        btnRastrear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRastrearActionPerformed(evt);
            }
        });

        btnBack.setFont(new java.awt.Font("Ubuntu", 0, 24)); // NOI18N
        btnBack.setText("Regresar");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        btnBusProducto.setFont(new java.awt.Font("Ubuntu", 0, 36)); // NOI18N
        btnBusProducto.setText("Buscar Productos");
        btnBusProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBusProductoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnBack))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnBusProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 307, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(279, 279, 279)
                                    .addComponent(jLabel1))
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(203, 203, 203)
                                    .addComponent(btnRastrear, javax.swing.GroupLayout.PREFERRED_SIZE, 307, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 241, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 123, Short.MAX_VALUE)
                .addComponent(btnBusProducto)
                .addGap(81, 81, 81)
                .addComponent(btnRastrear)
                .addGap(43, 43, 43)
                .addComponent(btnBack)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRastrearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRastrearActionPerformed
        // TODO add your handling code here:
        RastreoP rastreo = new RastreoP();
        rastreo.setLocationRelativeTo(null);
        rastreo.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnRastrearActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        // TODO add your handling code here:
        Inicio inicio = new Inicio();
        inicio.setLocationRelativeTo(null);
        this.dispose();
        inicio.setVisible(true);
    }//GEN-LAST:event_btnBackActionPerformed

    private void btnBusProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBusProductoActionPerformed
        // TODO add your handling code here:
        CatalogoProd prod = new CatalogoProd();
        prod.setLocationRelativeTo(null);
        prod.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnBusProductoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnBusProducto;
    private javax.swing.JButton btnRastrear;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
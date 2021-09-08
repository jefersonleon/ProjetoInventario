/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ulbra.view;

import br.ulbra.classes.Categoria;
import br.ulbra.classes.Hardware;
import br.ulbra.classes.Marca;
import br.ulbra.classes.Usuario;
import br.ulbra.dao.HardwareDAO;
import br.ulbra.dao.MarcaDAO;
import br.ulbra.dao.UsuarioDAO;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Jeferson Leon
 */
public class FrmHardware extends javax.swing.JFrame {

    /**
     * Creates new form FrmUsuario
     */
    public FrmHardware() throws SQLException {
        initComponents();

        this.setLocationRelativeTo(null);//centraliza o formulario no centro da tela
        readJTable();
       /* HardwareDAO dao = new HardwareDAO();
        cbxCat.removeAll();

        List<Categoria> listaC = dao.listaCategoria();*/

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        SEXO = new javax.swing.ButtonGroup();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btEditar = new javax.swing.JButton();
        btExcluir = new javax.swing.JButton();
        btnSalvar = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        tabelaHardware = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jRadioButton3 = new javax.swing.JRadioButton();
        jRadioButton4 = new javax.swing.JRadioButton();
        jTextField1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtModelo = new javax.swing.JTextField();
        cbxEstado = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtCaracteristica = new javax.swing.JTextArea();
        jLabel8 = new javax.swing.JLabel();
        txtId = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        txtData = new javax.swing.JTextField();
        txtPreco = new javax.swing.JTextField();
        cbxCat = new javax.swing.JComboBox();
        cbxMarca = new javax.swing.JComboBox();
        jButton2 = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(255, 153, 153));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tempus Sans ITC", 1, 36)); // NOI18N
        jLabel1.setText("CADASTRO HARDWARE");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 10, -1, -1));

        btEditar.setBackground(new java.awt.Color(255, 153, 0));
        btEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/editarp.png"))); // NOI18N
        btEditar.setText("EDITAR");
        btEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btEditarActionPerformed(evt);
            }
        });
        jPanel2.add(btEditar, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 500, 110, 44));

        btExcluir.setBackground(new java.awt.Color(255, 0, 51));
        btExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/excluir.png"))); // NOI18N
        btExcluir.setText("EXCLUIR");
        btExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btExcluirActionPerformed(evt);
            }
        });
        jPanel2.add(btExcluir, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 500, 110, 44));

        btnSalvar.setBackground(new java.awt.Color(102, 255, 0));
        btnSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/salvarp.png"))); // NOI18N
        btnSalvar.setText("SALVAR");
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });
        jPanel2.add(btnSalvar, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 500, 110, 44));

        tabelaHardware.setBackground(new java.awt.Color(255, 153, 153));
        tabelaHardware.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "DESCRIÇÃO", "MODELO", "ESTADO", "DATA", "PREÇO", "CATEGORIA", "MARCA", "CARACTERISTICAS"
            }
        ));
        tabelaHardware.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelaHardwareMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tabelaHardware);

        jPanel2.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 410, 540, 70));

        jPanel1.setBackground(new java.awt.Color(255, 153, 153));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Pesquisar", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N

        jRadioButton1.setBackground(new java.awt.Color(255, 153, 153));
        jRadioButton1.setText("A-Z");

        jRadioButton2.setBackground(new java.awt.Color(255, 153, 153));
        jRadioButton2.setText("Z-A");

        jRadioButton3.setBackground(new java.awt.Color(255, 153, 153));
        jRadioButton3.setText("Por Descrição");

        jRadioButton4.setBackground(new java.awt.Color(255, 153, 153));
        jRadioButton4.setText("Por Modelo");

        jButton1.setBackground(new java.awt.Color(51, 102, 255));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/lupa.png"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jRadioButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jRadioButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jRadioButton3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jRadioButton4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jRadioButton1)
                        .addComponent(jRadioButton2)
                        .addComponent(jRadioButton3)
                        .addComponent(jRadioButton4)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(27, 27, 27))
        );

        jPanel2.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 330, 550, 70));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel7.setText("MARCA");
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 180, -1, -1));

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel10.setText("ESTADO");
        jPanel2.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 120, -1, -1));

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel11.setText("CATEGORIA");
        jPanel2.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 180, -1, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel5.setText("MODELO");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 120, -1, -1));

        txtModelo.setText("a");
        jPanel2.add(txtModelo, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 140, 170, 30));

        cbxEstado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Novo", "Usado", "Com defeito", "Sucata" }));
        jPanel2.add(cbxEstado, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 140, 150, 30));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setText("DATA");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 120, -1, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel6.setText("CARACTERISTICAS");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 240, -1, -1));

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel12.setText("PREÇO R$");
        jPanel2.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 180, -1, -1));

        txtCaracteristica.setColumns(20);
        txtCaracteristica.setRows(5);
        txtCaracteristica.setText("a");
        jScrollPane2.setViewportView(txtCaracteristica);

        jPanel2.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 260, 510, 60));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel8.setText("ID");
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 60, -1, -1));
        jPanel2.add(txtId, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 80, 70, 30));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText("DESCRIÇÃO");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 60, -1, -1));

        txtNome.setText("a");
        jPanel2.add(txtNome, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 80, 430, 30));

        txtData.setText("2000-01-01");
        jPanel2.add(txtData, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 140, 140, 30));

        txtPreco.setText("1000");
        jPanel2.add(txtPreco, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 200, 140, 30));

        cbxCat.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                cbxCatAncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        jPanel2.add(cbxCat, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 200, 180, 30));

        cbxMarca.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                cbxMarcaAncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        jPanel2.add(cbxMarca, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 200, 170, 30));

        jButton2.setText("...");
        jPanel2.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 210, 30, -1));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 650, 550));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel9.setText("ESTADO");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 200, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void readJTable() throws SQLException {
        //Puxa do banco os registros e coloca na tabela gerada
        DefaultTableModel modelo = (DefaultTableModel) tabelaHardware.getModel();
        modelo.setNumRows(0);
        HardwareDAO hDao = new HardwareDAO();
        for (Hardware h : hDao.read()) {
            modelo.addRow(new Object[]{
                h.getIdHard(),
                h.getNome(),
                h.getModelo(),
                h.getEstado(),
                h.getData(),
                h.getCarateristica(),
                h.getCategoria(),
                h.getMarca()
            });
        }
    }
    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        HardwareDAO dao = null;

        try {
            dao = new HardwareDAO();
            Hardware h = new Hardware();
            Categoria cat = new Categoria();
            Marca m = new Marca();
            h.setNome(txtNome.getText());
            h.setModelo(txtModelo.getText());
            h.setEstado((String) cbxEstado.getSelectedItem());
            h.setData(txtData.getText());
            h.setPreco(Double.parseDouble(txtPreco.getText()));
            h.setCarateristica(txtCaracteristica.getText());
            h.setCategoria((Categoria) cbxCat.getSelectedItem());
            h.setMarca((Marca) cbxMarca.getSelectedItem());
            dao.create(h);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro:" + ex.getMessage());
        }
     
        try {
            readJTable();
        } catch (SQLException ex) {
           Logger.getLogger(FrmHardware.class.getName()).log(Level.SEVERE, null, ex);
        }
     
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void tabelaHardwareMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaHardwareMouseClicked
        if (tabelaHardware.getSelectedRow() != -1) {

            txtId.setText(tabelaHardware.getValueAt(tabelaHardware.getSelectedRow(), 0).toString());
            txtNome.setText(tabelaHardware.getValueAt(tabelaHardware.getSelectedRow(), 1).toString());
            //  txtCelular.setText(tabelaUsuario.getValueAt(tabelaUsuario.getSelectedRow(), 2).toString());
            txtModelo.setText(tabelaHardware.getValueAt(tabelaHardware.getSelectedRow(), 3).toString());

        }

    }//GEN-LAST:event_tabelaHardwareMouseClicked

    private void btExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btExcluirActionPerformed
        if (tabelaHardware.getSelectedRow() != -1) {

            Usuario u = new Usuario();
            UsuarioDAO dao = null;
            try {
                dao = new UsuarioDAO();
            } catch (SQLException ex) {
                Logger.getLogger(FrmHardware.class.getName()).log(Level.SEVERE, null, ex);
            }

            u.setId((int) tabelaHardware.getValueAt(tabelaHardware.getSelectedRow(), 0));

            dao.delete(u);

            txtId.setText("");
            txtNome.setText("");
            txtModelo.setText("");
            txtData.setText("");
            //   txtCelular.setText("");

            try {
                readJTable();
            } catch (SQLException ex) {
                Logger.getLogger(FrmHardware.class.getName()).log(Level.SEVERE, null, ex);
            }

        } else {
            JOptionPane.showMessageDialog(null, "Selecione um produto para excluir.");
        }

    }//GEN-LAST:event_btExcluirActionPerformed

    private void btEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btEditarActionPerformed
        if (tabelaHardware.getSelectedRow() != -1) {

            Usuario u = new Usuario();
            UsuarioDAO dao = null;
            try {
                dao = new UsuarioDAO();
            } catch (SQLException ex) {
                Logger.getLogger(FrmHardware.class.getName()).log(Level.SEVERE, null, ex);
            }

            u.setNome(txtNome.getText());

            //  u.setCelular(txtCelular.getText());
            u.setEmail(txtModelo.getText());
            u.setId((int) tabelaHardware.getValueAt(tabelaHardware.getSelectedRow(), 0));
            dao.update(u);

            txtId.setText("");
            txtNome.setText("");
            txtModelo.setText("");
            txtData.setText("");

            //  txtCelular.setText("");
            try {
                readJTable();
            } catch (SQLException ex) {
                Logger.getLogger(FrmHardware.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

    }//GEN-LAST:event_btEditarActionPerformed

    private void cbxMarcaAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_cbxMarcaAncestorAdded
        HardwareDAO hdao;
        try {
            hdao = new HardwareDAO();
            List<Marca> marca = hdao.listaMarca();
            cbxMarca.removeAll();
            for (Marca m : marca) {
                cbxMarca.addItem(m);
            }
        } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null,"Erro:"+ex.getMessage());
        }

    }//GEN-LAST:event_cbxMarcaAncestorAdded

    private void cbxCatAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_cbxCatAncestorAdded
       HardwareDAO hdao;
        try {
            hdao = new HardwareDAO();
            List<Categoria> categoria = hdao.listaCategoria();
            cbxCat.removeAll();
            for (Categoria c : categoria) {
                cbxCat.addItem(c);
            }
        } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null,"Erro:"+ex.getMessage());
        }

    }//GEN-LAST:event_cbxCatAncestorAdded

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FrmHardware.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmHardware.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmHardware.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmHardware.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new FrmHardware().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(FrmHardware.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup SEXO;
    private javax.swing.JButton btEditar;
    private javax.swing.JButton btExcluir;
    private javax.swing.JButton btnSalvar;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox cbxCat;
    private javax.swing.JComboBox<String> cbxEstado;
    private javax.swing.JComboBox cbxMarca;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JRadioButton jRadioButton3;
    private javax.swing.JRadioButton jRadioButton4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTable tabelaHardware;
    private javax.swing.JTextArea txtCaracteristica;
    private javax.swing.JTextField txtData;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtModelo;
    private javax.swing.JTextField txtNome;
    private javax.swing.JTextField txtPreco;
    // End of variables declaration//GEN-END:variables
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package canvas;

import canvas.cadastro.CadastraVenda;
import canvas.cadastro.CadastroCliente;
import canvas.cadastro.CadastroItem;
import canvas.cadastro.ExcluiVenda;
import canvas.consulta.ConsultaCliente;
import canvas.consulta.ConsultaItem;
import canvas.consulta.ConsultaVenda;

/**
 *
 * @author tailon.prado
 */
public class Menu extends javax.swing.JFrame {

    /**
     * Creates new form Menu
     */
    public Menu() {
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

        jMenuBar2 = new javax.swing.JMenuBar();
        jMenu3 = new javax.swing.JMenu();
        jMenu4 = new javax.swing.JMenu();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenuCliente = new javax.swing.JMenu();
        jMenuItemCadastraCliente = new javax.swing.JMenuItem();
        jMenuItemConsultaCliente = new javax.swing.JMenuItem();
        jMenuItem = new javax.swing.JMenu();
        jMenuItemCadastraItem = new javax.swing.JMenuItem();
        jMenuItemConsultaItem = new javax.swing.JMenuItem();
        jMenuVenda = new javax.swing.JMenu();
        jMenuItemCadastraVenda = new javax.swing.JMenuItem();
        jMenuItemExcluienda = new javax.swing.JMenuItem();
        jMenuItemConsultaVenda = new javax.swing.JMenuItem();

        jMenu3.setText("File");
        jMenuBar2.add(jMenu3);

        jMenu4.setText("Edit");
        jMenuBar2.add(jMenu4);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jMenuCliente.setText("Cliente");

        jMenuItemCadastraCliente.setText("Alterar Cliente");
        jMenuItemCadastraCliente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenuItemCadastraClienteMouseClicked(evt);
            }
        });
        jMenuItemCadastraCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemCadastraClienteActionPerformed(evt);
            }
        });
        jMenuCliente.add(jMenuItemCadastraCliente);

        jMenuItemConsultaCliente.setText("Consultar");
        jMenuItemConsultaCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemConsultaClienteActionPerformed(evt);
            }
        });
        jMenuCliente.add(jMenuItemConsultaCliente);

        jMenuBar1.add(jMenuCliente);

        jMenuItem.setText("Item");

        jMenuItemCadastraItem.setText("Alterar Item");
        jMenuItemCadastraItem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenuItemCadastraItemMouseClicked(evt);
            }
        });
        jMenuItemCadastraItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemCadastraItemActionPerformed(evt);
            }
        });
        jMenuItem.add(jMenuItemCadastraItem);

        jMenuItemConsultaItem.setText("Consultar");
        jMenuItemConsultaItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemConsultaItemActionPerformed(evt);
            }
        });
        jMenuItem.add(jMenuItemConsultaItem);

        jMenuBar1.add(jMenuItem);

        jMenuVenda.setText("Venda");

        jMenuItemCadastraVenda.setText("Cadastrar");
        jMenuItemCadastraVenda.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenuItemCadastraVendaMouseClicked(evt);
            }
        });
        jMenuItemCadastraVenda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemCadastraVendaActionPerformed(evt);
            }
        });
        jMenuVenda.add(jMenuItemCadastraVenda);

        jMenuItemExcluienda.setText("Excluir");
        jMenuItemExcluienda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemExcluiendaActionPerformed(evt);
            }
        });
        jMenuVenda.add(jMenuItemExcluienda);

        jMenuItemConsultaVenda.setText("Consultar");
        jMenuItemConsultaVenda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemConsultaVendaActionPerformed(evt);
            }
        });
        jMenuVenda.add(jMenuItemConsultaVenda);

        jMenuBar1.add(jMenuVenda);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 298, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItemCadastraClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemCadastraClienteActionPerformed
        CadastroCliente cadastroCliente = new CadastroCliente();
        cadastroCliente.setTitle("Cadastro de Cliente");
        cadastroCliente.setDefaultCloseOperation(cadastroCliente.HIDE_ON_CLOSE);
        cadastroCliente.setVisible(true);
    }//GEN-LAST:event_jMenuItemCadastraClienteActionPerformed

    private void jMenuItemConsultaClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemConsultaClienteActionPerformed
        ConsultaCliente consultaCliente = new ConsultaCliente();
        consultaCliente.setTitle("Consulta Clintes");
        consultaCliente.setDefaultCloseOperation(consultaCliente.HIDE_ON_CLOSE);
        consultaCliente.setVisible(true);
    }//GEN-LAST:event_jMenuItemConsultaClienteActionPerformed

    private void jMenuItemCadastraVendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemCadastraVendaActionPerformed
        CadastraVenda cadastraVenda = new CadastraVenda();
        cadastraVenda.setTitle("Cadastro de Vendas");
        cadastraVenda.setDefaultCloseOperation(cadastraVenda.HIDE_ON_CLOSE);
        cadastraVenda.setVisible(true);
    }//GEN-LAST:event_jMenuItemCadastraVendaActionPerformed

    private void jMenuItemCadastraClienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuItemCadastraClienteMouseClicked
        
    }//GEN-LAST:event_jMenuItemCadastraClienteMouseClicked

    private void jMenuItemCadastraItemMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuItemCadastraItemMouseClicked
    }//GEN-LAST:event_jMenuItemCadastraItemMouseClicked

    private void jMenuItemCadastraVendaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuItemCadastraVendaMouseClicked
    }//GEN-LAST:event_jMenuItemCadastraVendaMouseClicked

    private void jMenuItemCadastraItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemCadastraItemActionPerformed
        CadastroItem cadastroItem = new CadastroItem();
        cadastroItem.setTitle("Cadastro de Item");
        cadastroItem.setDefaultCloseOperation(cadastroItem.HIDE_ON_CLOSE);
        cadastroItem.setVisible(true);
    }//GEN-LAST:event_jMenuItemCadastraItemActionPerformed

    private void jMenuItemConsultaItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemConsultaItemActionPerformed
        ConsultaItem consultaItem = new ConsultaItem();
        consultaItem.setTitle("Consultar Itens");
        consultaItem.setDefaultCloseOperation(consultaItem.HIDE_ON_CLOSE);
        consultaItem.setVisible(true);
    }//GEN-LAST:event_jMenuItemConsultaItemActionPerformed

    private void jMenuItemConsultaVendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemConsultaVendaActionPerformed
        ConsultaVenda consultaVenda = new ConsultaVenda();
        consultaVenda.setTitle("Consultar Vendas");
        consultaVenda.setDefaultCloseOperation(consultaVenda.HIDE_ON_CLOSE);
        consultaVenda.setVisible(true);
    }//GEN-LAST:event_jMenuItemConsultaVendaActionPerformed

    private void jMenuItemExcluiendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemExcluiendaActionPerformed
        ExcluiVenda excluirVenda = new ExcluiVenda();
        excluirVenda.setTitle("Excluir Venda");
        excluirVenda.setDefaultCloseOperation(excluirVenda.HIDE_ON_CLOSE);
        excluirVenda.setVisible(true);
    }//GEN-LAST:event_jMenuItemExcluiendaActionPerformed

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
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Menu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JMenu jMenuCliente;
    private javax.swing.JMenu jMenuItem;
    private javax.swing.JMenuItem jMenuItemCadastraCliente;
    private javax.swing.JMenuItem jMenuItemCadastraItem;
    private javax.swing.JMenuItem jMenuItemCadastraVenda;
    private javax.swing.JMenuItem jMenuItemConsultaCliente;
    private javax.swing.JMenuItem jMenuItemConsultaItem;
    private javax.swing.JMenuItem jMenuItemConsultaVenda;
    private javax.swing.JMenuItem jMenuItemExcluienda;
    private javax.swing.JMenu jMenuVenda;
    // End of variables declaration//GEN-END:variables
}

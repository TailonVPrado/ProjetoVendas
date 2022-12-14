/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package canvas.cadastro;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.TableColumn;
import models.Cliente;
import models.Item;
import models.ItemVenda;
import models.Venda;
import service.ClienteService;
import service.ItemService;
import service.ItemVendaService;
import service.VendaService;

/**
 *
 * @author tailon.prado
 */
public class CadastraVenda extends javax.swing.JFrame {

    /**
     * Creates new form CadastraVenda
     */
    private ArrayList<ItemVenda> gridItemVenda = new ArrayList<>();
    
    
    public CadastraVenda() {
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

        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        idClienteVenda = new javax.swing.JTextField();
        nomeClienteVenda = new javax.swing.JTextField();
        idItemVenda = new javax.swing.JTextField();
        descricaoItemVenda = new javax.swing.JTextField();
        qtdeVenda = new javax.swing.JTextField();
        botaoAdicionaItemVenda = new javax.swing.JButton();
        valotTotalVenda = new javax.swing.JTextField();
        botaoFinalizaCompra = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tableItemVenda = new javax.swing.JTable();
        removeItem = new javax.swing.JButton();

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

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
        jScrollPane2.setViewportView(jTable1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        idClienteVenda.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                idClienteVendaFocusLost(evt);
            }
        });
        idClienteVenda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                idClienteVendaActionPerformed(evt);
            }
        });
        idClienteVenda.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                idClienteVendaKeyReleased(evt);
            }
        });

        nomeClienteVenda.setEditable(false);
        nomeClienteVenda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nomeClienteVendaActionPerformed(evt);
            }
        });

        idItemVenda.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                idItemVendaFocusLost(evt);
            }
        });
        idItemVenda.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                idItemVendaKeyReleased(evt);
            }
        });

        descricaoItemVenda.setEditable(false);
        descricaoItemVenda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                descricaoItemVendaActionPerformed(evt);
            }
        });

        qtdeVenda.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                qtdeVendaKeyReleased(evt);
            }
        });

        botaoAdicionaItemVenda.setText("Adicionar Item");
        botaoAdicionaItemVenda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoAdicionaItemVendaActionPerformed(evt);
            }
        });

        valotTotalVenda.setEditable(false);
        valotTotalVenda.setText("0.00");
        valotTotalVenda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                valotTotalVendaActionPerformed(evt);
            }
        });

        botaoFinalizaCompra.setText("FINALIZAR VENDA");
        botaoFinalizaCompra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoFinalizaCompraActionPerformed(evt);
            }
        });

        jLabel1.setText("Id Cliente");

        jLabel2.setText("Nome Cliente");

        jLabel3.setText("Id Item");

        jLabel4.setText("Descri????o Item");

        jLabel5.setText("Valor Total");

        jLabel6.setText("Quantidade");

        tableItemVenda = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex){
                return false;
            }
        };
        tableItemVenda.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {},
            new String [] {
                "Id Item", "Descri????o", "Quantidade", "Valor"
            }
        ));
        tableItemVenda.setToolTipText("");
        TableColumn colId = tableItemVenda.getColumnModel().getColumn(0);
        TableColumn colDescricao = tableItemVenda.getColumnModel().getColumn(1);
        TableColumn colqtde = tableItemVenda.getColumnModel().getColumn(2);
        TableColumn colvalor = tableItemVenda.getColumnModel().getColumn(3);

        colId.setPreferredWidth(60);
        colDescricao.setPreferredWidth(225);
        colqtde.setPreferredWidth(70);
        colvalor.setPreferredWidth(100);
        tableItemVenda.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_LAST_COLUMN);
        tableItemVenda.setFocusable(false);
        tableItemVenda.setShowGrid(false);
        tableItemVenda.getTableHeader().setResizingAllowed(false);
        tableItemVenda.getTableHeader().setReorderingAllowed(false);
        tableItemVenda.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                tableItemVendaFocusGained(evt);
            }
        });
        tableItemVenda.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableItemVendaMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tableItemVenda);

        removeItem.setText("remover ultimo item adic.");
        removeItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeItemActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(idItemVenda, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(descricaoItemVenda)))
                    .addComponent(jLabel6)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(botaoFinalizaCompra, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(valotTotalVenda, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(idClienteVenda, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(12, 12, 12)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(nomeClienteVenda, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(qtdeVenda, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(removeItem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(botaoAdicionaItemVenda, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(26, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addGap(4, 4, 4)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(idClienteVenda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nomeClienteVenda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addGap(5, 5, 5)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(idItemVenda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(descricaoItemVenda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel6)
                .addGap(4, 4, 4)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(qtdeVenda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botaoAdicionaItemVenda)
                    .addComponent(removeItem))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 428, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(valotTotalVenda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botaoFinalizaCompra))
                .addGap(36, 36, 36))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    private void botaoAdicionaItemVendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoAdicionaItemVendaActionPerformed
        try {
            if (idItemVenda.getText().equals("")) {
                throw new Exception("O item deve ser informado.");
            }
            if(qtdeVenda.getText().equals("")){
                throw new Exception("A quantidade deve ser informada.");
            }else if (!(Double.parseDouble(qtdeVenda.getText()) > 0.00)){
                throw new Exception("A quantidade n??o pode ser zero.");
            }
            ItemVenda itemVenda = new ItemVenda();
            Item item = new Item();
            ItemService itemService = new ItemService();

            try {
                item = itemService.findById(Integer.parseInt(idItemVenda.getText()));
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Erro ao buscar item. Erro: " + ex.getMessage());
            }

            itemVenda.setItem(item);
            itemVenda.setQtde(Double.parseDouble(qtdeVenda.getText()));

            gridItemVenda.add(itemVenda);

            preencheGrid();
            
            String vlTotalVenda = (Double.parseDouble(valotTotalVenda.getText()) + (gridItemVenda.get(gridItemVenda.size()-1).getItem().getVlItem() * gridItemVenda.get(gridItemVenda.size()-1).getQtde()))+"";
            if(vlTotalVenda.contains(".")){
                vlTotalVenda += "000";
                vlTotalVenda = vlTotalVenda.substring(0, vlTotalVenda.indexOf(".") +3);
            }
            valotTotalVenda.setText(vlTotalVenda);
            
            idItemVenda.setText("");
            descricaoItemVenda.setText("");
            qtdeVenda.setText("");
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }//GEN-LAST:event_botaoAdicionaItemVendaActionPerformed
    private void preencheGrid(){
        
        Object[][] obj = new Object[gridItemVenda.size()][4];
        
        int linha = 0;
        for (ItemVenda itemVenda : gridItemVenda) {
            obj[linha][0] = gridItemVenda.get(linha).getItem().getId();
            obj[linha][1] = gridItemVenda.get(linha).getItem().getDescricao();
            obj[linha][2] = gridItemVenda.get(linha).getQtde();
            String vlItemCompra = (gridItemVenda.get(linha).getItem().getVlItem() * gridItemVenda.get(linha).getQtde())+"";
            if(vlItemCompra.contains(".")){
                vlItemCompra += "000";
                vlItemCompra = vlItemCompra.substring(0, vlItemCompra.indexOf(".") +3);
            }   
            obj[linha][3] = vlItemCompra;
            linha++;
        }
        
        tableItemVenda.setModel(new javax.swing.table.DefaultTableModel(
            obj,
             new String [] {
                "Id Item", "Descri????o", "Quantidade", "Valor"
            }

        ));
        TableColumn colId = tableItemVenda.getColumnModel().getColumn(0);
        TableColumn colDescricao = tableItemVenda.getColumnModel().getColumn(1);
        TableColumn colqtde = tableItemVenda.getColumnModel().getColumn(2);
        TableColumn colvalor = tableItemVenda.getColumnModel().getColumn(3);

        colId.setPreferredWidth(60);
        colDescricao.setPreferredWidth(225);
        colqtde.setPreferredWidth(70);
        colvalor.setPreferredWidth(100);
    }
    
    
    private void botaoFinalizaCompraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoFinalizaCompraActionPerformed
        try {
            if(idClienteVenda.getText().equals("")){
                throw new Exception("Informe o cliente para efetuar a venda.");
            }else if(gridItemVenda.size() == 0){
                throw new Exception("Informe ao menos um item para realizar a venda");
            }
            gravaVenda();
            limpaTela();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        } 
            
    }//GEN-LAST:event_botaoFinalizaCompraActionPerformed

    private void limpaTela(){
        int linha = gridItemVenda.size()-1;
        
        while (linha >= 0) {            
            gridItemVenda.remove(linha);
            linha--;
        }
        tableItemVenda.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {},
            new String [] {
                "Id Item", "Descri????o", "Quantidade", "Valor"
            }
        ));
        
        idClienteVenda.setText("");
        nomeClienteVenda.setText("");
        idItemVenda.setText("");
        descricaoItemVenda.setText("");
        valotTotalVenda.setText("0.00");
    }
    private void gravaVenda() throws SQLException, Exception{
        VendaService vendaService = new VendaService();
        Venda venda = new Venda();
        
        ClienteService clienteService = new ClienteService();
        Cliente cliente = new Cliente();
        
        cliente = clienteService.findById(Integer.parseInt(idClienteVenda.getText()));
        
        venda.setCliente(cliente);
        venda.setVlTotal(Double.parseDouble(valotTotalVenda.getText()));
        
        vendaService.insert(venda);
        
        ItemVendaService itemVendaService = new ItemVendaService();
        for (ItemVenda itemVenda : gridItemVenda) {
            itemVenda.setVenda(venda);
            itemVendaService.insert(itemVenda);
        }

        JOptionPane.showMessageDialog(null, "Venda ("+ venda.getId() +") finalizada com sucesso!");
        
    }
    
    private void idClienteVendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_idClienteVendaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_idClienteVendaActionPerformed

    private void nomeClienteVendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nomeClienteVendaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nomeClienteVendaActionPerformed

    private void idClienteVendaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_idClienteVendaKeyReleased
        idClienteVenda.setText(idClienteVenda.getText().replaceAll("[^0-9]+", ""));
    }//GEN-LAST:event_idClienteVendaKeyReleased

    private void idItemVendaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_idItemVendaKeyReleased
        idItemVenda.setText(idItemVenda.getText().replaceAll("[^0-9]+", ""));
    }//GEN-LAST:event_idItemVendaKeyReleased

    private void qtdeVendaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_qtdeVendaKeyReleased
        if(evt.getKeyCode() != 44)
            if(evt.getKeyCode() != 110)
                if(evt.getKeyCode() != 46)
                    qtdeVenda.setText(qtdeVenda.getText().replaceAll("[^0-9.]+", ""));
        if(qtdeVenda.getText().contains(",")||qtdeVenda.getText().contains(".")){
            String var = (qtdeVenda.getText().replaceAll("[^,.]+", ""));
            if(var.length() > 1)
                qtdeVenda.setText(qtdeVenda.getText().substring(0, qtdeVenda.getText().length()-1));
        }
        qtdeVenda.setText(qtdeVenda.getText().replaceAll("[,]+", "."));
    }//GEN-LAST:event_qtdeVendaKeyReleased

    private void descricaoItemVendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_descricaoItemVendaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_descricaoItemVendaActionPerformed

    private void idItemVendaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_idItemVendaFocusLost
        if(!idItemVenda.getText().equals("")){
            ItemService itemService = new ItemService();
            Item item = new Item();
            try {
                item = itemService.findById(Integer.parseInt(idItemVenda.getText()));
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Ocorreu um erro ao buscar o item. Erro: "+ex.getMessage());
            }
            
            if(item.getId() == null){
                JOptionPane.showMessageDialog(null, "Item com id ("+idItemVenda.getText()+") n??o encontrado.");
                idItemVenda.setText("");
            }
            descricaoItemVenda.setText(item.getDescricao());
        }else{
            descricaoItemVenda.setText("");
        }
    }//GEN-LAST:event_idItemVendaFocusLost

    private void removeItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeItemActionPerformed
        int linha = gridItemVenda.size() - 1;
        if(linha >= 0){
            tableItemVenda.setValueAt("", linha, 0);
            tableItemVenda.setValueAt("", linha, 1);
            tableItemVenda.setValueAt("", linha, 2);
            tableItemVenda.setValueAt("", linha, 3);
            
            String vlTotalVenda = (Double.parseDouble(valotTotalVenda.getText()) - (gridItemVenda.get(gridItemVenda.size()-1).getItem().getVlItem() * gridItemVenda.get(gridItemVenda.size()-1).getQtde()))+"";
            if(vlTotalVenda.contains(".")){
                vlTotalVenda += "000";
                vlTotalVenda = vlTotalVenda.substring(0, vlTotalVenda.indexOf(".") +3);
            }
            valotTotalVenda.setText(vlTotalVenda);
            
            gridItemVenda.remove(linha);
        }
    }//GEN-LAST:event_removeItemActionPerformed

    private void valotTotalVendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_valotTotalVendaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_valotTotalVendaActionPerformed

    private void idClienteVendaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_idClienteVendaFocusLost
        if(!idClienteVenda.getText().equals("")){
            ClienteService clienteService = new ClienteService();
            Cliente cliente = new Cliente();
            try {
                cliente = clienteService.findById(Integer.parseInt(idClienteVenda.getText()));
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Ocorreu um erro ao buscar o cliente. Erro: "+ex.getMessage());
            }
            
            if(cliente.getId() == null){
                JOptionPane.showMessageDialog(null, "Cliente com id ("+idClienteVenda.getText()+") n??o encontrado.");
                idClienteVenda.setText("");
            }
            nomeClienteVenda.setText(cliente.getNome());
        }else{
            nomeClienteVenda.setText("");
        }
    }//GEN-LAST:event_idClienteVendaFocusLost

    private void tableItemVendaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tableItemVendaFocusGained
    }//GEN-LAST:event_tableItemVendaFocusGained

    private void tableItemVendaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableItemVendaMouseClicked

    }//GEN-LAST:event_tableItemVendaMouseClicked

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
            java.util.logging.Logger.getLogger(CadastraVenda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CadastraVenda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CadastraVenda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CadastraVenda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CadastraVenda().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botaoAdicionaItemVenda;
    private javax.swing.JButton botaoFinalizaCompra;
    private javax.swing.JTextField descricaoItemVenda;
    private javax.swing.JTextField idClienteVenda;
    private javax.swing.JTextField idItemVenda;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField nomeClienteVenda;
    private javax.swing.JTextField qtdeVenda;
    private javax.swing.JButton removeItem;
    public javax.swing.JTable tableItemVenda;
    private javax.swing.JTextField valotTotalVenda;
    // End of variables declaration//GEN-END:variables
}

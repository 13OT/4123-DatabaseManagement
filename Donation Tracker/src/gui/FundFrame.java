/*
* Author(s): Tellon Smith, Johann Readhead
*/


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import core.Fund;
import dao.DBConnection;
import dao.FundDAO;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author legen
 */
public class FundFrame extends javax.swing.JFrame {
    private DBConnection conn;
    private FundDAO fundDAO;
    private List<Fund> fundList;
    FundTableModel model;
    /**
     * Creates new form FundFrame
     */
    public FundFrame(DBConnection myConn) {
        initComponents();
        // enable column sorting in the table
        fund_table.setAutoCreateRowSorter(true);
       
        this.conn = myConn;
        fundDAO = new FundDAO(this.conn);
        
        try
        {
            fundList = fundDAO.getAllFunds();
            model = new FundTableModel(fundList);
            fund_table.setModel(model);            
        } 
        catch(Exception ex)
        {
            Logger.getLogger(ContributionFrame.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, "Error 2: " + ex, "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    //Searches table by filtering out string or parts of things that don't match
    private void searchFundTable(String query)
    {
        TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(model);
        fund_table.setRowSorter(sorter);        
        sorter.setRowFilter(RowFilter.regexFilter("(?i)" + query));
    }
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        fundTable_scrollPane = new javax.swing.JScrollPane();
        fund_table = new javax.swing.JTable();
        addUpdateDelete_panel = new javax.swing.JPanel();
        fundName_label = new javax.swing.JLabel();
        quickbooksAccNo_label = new javax.swing.JLabel();
        fundName_textField = new javax.swing.JTextField();
        quickbooksAccNo_textfield = new javax.swing.JTextField();
        add_button = new javax.swing.JButton();
        update_button = new javax.swing.JButton();
        Reset = new javax.swing.JButton();
        delete_button = new javax.swing.JButton();
        search_textField = new javax.swing.JTextField();
        search_label = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        fund_table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"", ""},
                {"", ""},
                {"", ""}
            },
            new String [] {
                "Fund Name", "QuickBooks Account No."
            }
        ));
        fund_table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                fund_tableMouseClicked(evt);
            }
        });
        fundTable_scrollPane.setViewportView(fund_table);

        addUpdateDelete_panel.setBorder(javax.swing.BorderFactory.createTitledBorder("Add/Update/Delete Fund"));

        fundName_label.setText("Fund Name:");

        quickbooksAccNo_label.setText("QuickBooks Account No.:");

        add_button.setText("Add");
        add_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                add_buttonActionPerformed(evt);
            }
        });

        update_button.setText("Update");
        update_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                update_buttonActionPerformed(evt);
            }
        });

        Reset.setText("Reset");
        Reset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ResetActionPerformed(evt);
            }
        });

        delete_button.setText("Delete");
        delete_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                delete_buttonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout addUpdateDelete_panelLayout = new javax.swing.GroupLayout(addUpdateDelete_panel);
        addUpdateDelete_panel.setLayout(addUpdateDelete_panelLayout);
        addUpdateDelete_panelLayout.setHorizontalGroup(
            addUpdateDelete_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(addUpdateDelete_panelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(addUpdateDelete_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(addUpdateDelete_panelLayout.createSequentialGroup()
                        .addGroup(addUpdateDelete_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(quickbooksAccNo_label)
                            .addComponent(fundName_label))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(addUpdateDelete_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(fundName_textField, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
                            .addComponent(quickbooksAccNo_textfield)))
                    .addGroup(addUpdateDelete_panelLayout.createSequentialGroup()
                        .addComponent(add_button, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(update_button, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(addUpdateDelete_panelLayout.createSequentialGroup()
                        .addComponent(Reset, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(delete_button, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        addUpdateDelete_panelLayout.setVerticalGroup(
            addUpdateDelete_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(addUpdateDelete_panelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(addUpdateDelete_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fundName_label)
                    .addComponent(fundName_textField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(addUpdateDelete_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(quickbooksAccNo_label)
                    .addComponent(quickbooksAccNo_textfield, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36)
                .addGroup(addUpdateDelete_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(add_button)
                    .addComponent(update_button))
                .addGap(30, 30, 30)
                .addGroup(addUpdateDelete_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Reset)
                    .addComponent(delete_button))
                .addContainerGap(24, Short.MAX_VALUE))
        );

        search_textField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                search_textFieldKeyReleased(evt);
            }
        });

        search_label.setText("Search");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(search_label)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(search_textField, javax.swing.GroupLayout.PREFERRED_SIZE, 317, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(fundTable_scrollPane, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 1144, Short.MAX_VALUE)
                    .addComponent(addUpdateDelete_panel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(41, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(search_textField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(search_label))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(fundTable_scrollPane)
                .addGap(18, 18, 18)
                .addComponent(addUpdateDelete_panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void search_textFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_search_textFieldKeyReleased
        String query = search_textField.getText();
        searchFundTable(query);
    }//GEN-LAST:event_search_textFieldKeyReleased

    private void fund_tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_fund_tableMouseClicked
       int selectedRowIndex = fund_table.getSelectedRow();
       int selectedRowModel = fund_table.convertRowIndexToModel(selectedRowIndex);
       
       TableModel fund_model = fund_table.getModel();
       fundName_textField.setText(fund_model.getValueAt(selectedRowModel, 0).toString());
       quickbooksAccNo_textfield.setText(fund_model.getValueAt(selectedRowModel, 1).toString());
       
       //disable add button
       add_button.setEnabled(false);
       
       //set focus to fund name
       fundName_textField.requestFocus();
    }//GEN-LAST:event_fund_tableMouseClicked

    private void ResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ResetActionPerformed
        fundName_textField.setText("");
        quickbooksAccNo_textfield.setText("");
        
        //enable add button
        add_button.setEnabled(true);
    }//GEN-LAST:event_ResetActionPerformed

    private void add_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_add_buttonActionPerformed
        try{
        Fund fund = new Fund(fundName_textField.getText(),quickbooksAccNo_textfield.getText());
        fundDAO.addFund(fund);
        
         }catch (NumberFormatException ex){
            JOptionPane.showMessageDialog(this, "Value Error : " + ex, "Error", JOptionPane.ERROR_MESSAGE);

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Database Error : " + ex, "Error", JOptionPane.ERROR_MESSAGE);
        }
        finally{
                    reset();
        }
    }//GEN-LAST:event_add_buttonActionPerformed

    private void delete_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_delete_buttonActionPerformed
        // TODO add your handling code here:
        try{
        Fund fund = new Fund(fundName_textField.getText(),quickbooksAccNo_textfield.getText());
        fundDAO.deleteFund(fund);
        
         }catch (NumberFormatException ex){
            JOptionPane.showMessageDialog(this, "Value Error : " + ex, "Error", JOptionPane.ERROR_MESSAGE);

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Database Error : " + ex, "Error", JOptionPane.ERROR_MESSAGE);
        }
        finally{
                    reset();
        }
    }//GEN-LAST:event_delete_buttonActionPerformed

    private void update_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_update_buttonActionPerformed
        try{
        Fund x = new Fund(fundName_textField.getText(),quickbooksAccNo_textfield.getText());
        fundDAO.updateFund(x);
         }
        catch (NumberFormatException ex){
            JOptionPane.showMessageDialog(this, "Value Error : " + ex, "Error", JOptionPane.ERROR_MESSAGE);

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Database Error : " + ex, "Error", JOptionPane.ERROR_MESSAGE);
        }
        finally{
                    reset();
        } 
    }//GEN-LAST:event_update_buttonActionPerformed

        private void reset(){   
    try{
            fundList = fundDAO.getAllFunds();
            model = new FundTableModel(fundList);
            fund_table.setModel(model);            
        } catch (Exception ex)
        {
            JOptionPane.showMessageDialog(this, "Error : " + ex, "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
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
            java.util.logging.Logger.getLogger(FundFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FundFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FundFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FundFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FundFrame(null).setVisible(true);
            }
        });
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Reset;
    private javax.swing.JPanel addUpdateDelete_panel;
    private javax.swing.JButton add_button;
    private javax.swing.JButton delete_button;
    private javax.swing.JLabel fundName_label;
    private javax.swing.JTextField fundName_textField;
    private javax.swing.JScrollPane fundTable_scrollPane;
    private javax.swing.JTable fund_table;
    private javax.swing.JLabel quickbooksAccNo_label;
    private javax.swing.JTextField quickbooksAccNo_textfield;
    private javax.swing.JLabel search_label;
    private javax.swing.JTextField search_textField;
    private javax.swing.JButton update_button;
    // End of variables declaration//GEN-END:variables
}

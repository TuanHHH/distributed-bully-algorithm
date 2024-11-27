/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.ptithcm.bully.algorithm.ui;

import com.ptithcm.bully.algorithm.model.TransactionHistoryModel;
import com.ptithcm.bully.algorithm.util.DBConnection;

import javax.swing.table.DefaultTableModel;
import java.sql.Connection;
import java.util.List;

/**
 *
 * @author acer
 */
public class TransactionHistory extends javax.swing.JFrame {

    /**
     * Creates new form TransactionHistory
     */
    public TransactionHistory() {
        initComponents();
    }
    public TransactionHistory(int id){
        DBConnection connectionService = new DBConnection();
        Connection conn = connectionService.getConnection();
        initComponents();
        //lấy số dư
        int money = connectionService.getAccountMoney(id);
        //set tiền
        lbAccountMoney.setText(String.format("Số dư: %d", money));
        lbAccountId.setText(String.format("Tài khoản: %d", id));
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        List<TransactionHistoryModel> allTrans = connectionService.getHistoryTransact(id);
        String tranType = "";
        if(allTrans != null){
            for(TransactionHistoryModel t:allTrans){
                if(t.getSendId() == id) tranType="Gửi tiền";
                else tranType="Nhận tiền";
                model.addRow(new Object[]{t.getId(),tranType,t.getSendId(),t.getReceiveId(),t.getMoney(),t.getDate(),t.getMsg()});
            }
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

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        lbAccountId = new javax.swing.JLabel();
        lbAccountMoney = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Lịch sử giao dịch");
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 102, 51));
        jLabel1.setText("LỊCH SỬ GIAO DỊCH");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "ID gửi", "ID nhận", "Số tiền", "Thời gian", "Lời nhắn", "Loại giao dịch"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);

        lbAccountId.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbAccountId.setForeground(new java.awt.Color(255, 153, 51));

        lbAccountMoney.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbAccountMoney.setForeground(new java.awt.Color(255, 153, 51));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lbAccountId, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lbAccountMoney, javax.swing.GroupLayout.PREFERRED_SIZE, 460, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 764, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(19, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lbAccountId, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbAccountMoney, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 390, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(14, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel lbAccountId;
    private javax.swing.JLabel lbAccountMoney;
    // End of variables declaration//GEN-END:variables
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Db.DBConnection;
import Models.CustomTable;
import Models.SinhVien;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author HuyenDau
 */
public class QLBaoLuuKQHT extends javax.swing.JFrame {

    /**
     * Creates new form XemDiem
     */
    DefaultTableModel tableModel = new DefaultTableModel();
    ArrayList<SinhVien> lstSinhVien = new ArrayList<>();
    public QLBaoLuuKQHT() {
        initComponents();
        loadData();
    }

    DBConnection db = new DBConnection();
    Connection con = db.getConnection();
    PreparedStatement ps;
    ResultSet rs;
    public void loadData(){
        try {
            int countColumn;
            Vector row, column;
            column = new Vector();
            Statement st = con.createStatement();
            rs=st.executeQuery("Select *from SINHVIEN");
            ResultSetMetaData metaData = rs.getMetaData();
            countColumn = metaData.getColumnCount(); // số cột
            
            column.add("Mã sinh viên");
            column.add("Mã lớp");
            column.add("Họ tên sinh viên");
            column.add("Ngày sinh");
            column.add("Giới tính");
            column.add("Địa chỉ");
            column.add("Mật khẩu");
            column.add("Tình trạng");
            tableModel.setColumnIdentifiers(column);
             
            while (rs.next()) {
                row = new Vector();
                for(int i = 1; i <= countColumn; i++){
                    row.addElement(rs.getString(i));
                }
                tableModel.addRow(row);
                tbSinhVien.setModel(tableModel);
            }
                ps = con.prepareStatement("select * from SINHVIEN");
                rs = ps.executeQuery();
                while (rs.next()) {
                SinhVien c = new SinhVien(rs.getString("MaSV"),rs.getString("MaLop"),rs.getString("TenSV"),rs.getString("NgaySinh"),rs.getString("GioiTinh"),rs.getString("DiaChi"),rs.getNString("MatKhau"),rs.getString("TinhTrang"));
                lstSinhVien.add(c);
            }
        } 
        catch (Exception ex) {
            System.out.println(ex.toString());
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbSinhVien = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        txtMaSV = new javax.swing.JTextField();
        btnBaoLuu = new javax.swing.JButton();
        btnHuyBaoLuu = new javax.swing.JButton();
        btnDSBaoLuu = new javax.swing.JButton();
        btnThoat = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(153, 153, 255));
        setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(204, 204, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Quản lý bảo lưu kết quả học tập"));
        jPanel1.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel1.setText("Quản lý bảo lưu kết quả học tập");

        tbSinhVien.setModel(new javax.swing.table.DefaultTableModel(
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
        tbSinhVien.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbSinhVienMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbSinhVien);

        jLabel6.setText("Nhập mã sinh viên cần bảo lưu");

        txtMaSV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMaSVActionPerformed(evt);
            }
        });

        btnBaoLuu.setText("Bảo lưu");
        btnBaoLuu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBaoLuuActionPerformed(evt);
            }
        });

        btnHuyBaoLuu.setText("Hủy bảo lưu");
        btnHuyBaoLuu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHuyBaoLuuActionPerformed(evt);
            }
        });

        btnDSBaoLuu.setText("DS sinh viên bảo lưu kết quả HT");
        btnDSBaoLuu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDSBaoLuuActionPerformed(evt);
            }
        });

        btnThoat.setText("Thoát");
        btnThoat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThoatActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(127, 127, 127)
                        .addComponent(btnBaoLuu)
                        .addGap(92, 92, 92)
                        .addComponent(btnHuyBaoLuu)
                        .addGap(59, 59, 59)
                        .addComponent(btnDSBaoLuu)
                        .addGap(91, 91, 91)
                        .addComponent(btnThoat))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(189, 189, 189)
                        .addComponent(jLabel6)
                        .addGap(87, 87, 87)
                        .addComponent(txtMaSV, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(193, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(300, 300, 300))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addComponent(jLabel1)
                .addGap(36, 36, 36)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtMaSV, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnBaoLuu)
                    .addComponent(btnHuyBaoLuu)
                    .addComponent(btnDSBaoLuu)
                    .addComponent(btnThoat))
                .addGap(39, 39, 39)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(89, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 980, 500));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtMaSVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMaSVActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMaSVActionPerformed

    private void btnBaoLuuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBaoLuuActionPerformed
        // TODO add your handling code here:
        if(txtMaSV.getText().trim().equals("")){
            JOptionPane.showMessageDialog(null, "Vui lòng nhập mã sinh viên cần bảo lưu");
            return;
        }
        try{
            int dem=0;
            Iterator<SinhVien> it = lstSinhVien.iterator();
            while (it.hasNext()) {
                SinhVien next = it.next();
                if(next.getMaSV().trim().equals(txtMaSV.getText().trim())){
                    dem++;
                }
            }
            if(dem==0){
                JOptionPane.showMessageDialog(null, "Mã sinh viên cần bảo lưu không tồn tại trong hệ thống");
                return;
            }
            else{
                ps=con.prepareStatement("Update SinhVien set TinhTrang=? where MaSV=?");
                String bl = "Đã bảo lưu KQHT";
                ps.setString(1, bl);
                ps.setString(2, txtMaSV.getText().trim());
                if(JOptionPane.showConfirmDialog(this, "Xác nhận", "Bảo lưu sinh viên này", JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION){
                    ps.executeUpdate();
                    tableModel.setRowCount(0);
                    loadData();
                    JOptionPane.showMessageDialog(null, "Bảo lưu thành công");
                }
            }
        }
        catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex.toString());
        }
    }//GEN-LAST:event_btnBaoLuuActionPerformed

    private void tbSinhVienMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbSinhVienMouseClicked
        // TODO add your handling code here:
        int row=tbSinhVien.getSelectedRow();
        txtMaSV.setText((tbSinhVien.getValueAt(row, 0) + "").trim());
        
    }//GEN-LAST:event_tbSinhVienMouseClicked

    private void btnDSBaoLuuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDSBaoLuuActionPerformed
        try {
            // TODO add your handling code here:
            ps=con.prepareStatement("Select * from SINHVIEN where TinhTrang=?");
            String tt="Đã bảo lưu KQHT";
            ps.setString(1, tt);
            while(tableModel.getRowCount()>0){
                tableModel.removeRow(0);
            }
            rs=ps.executeQuery();
            int countColumn;
            ResultSetMetaData metaData = rs.getMetaData();
            countColumn = metaData.getColumnCount(); // số cột
            while (rs.next()) {
                Vector row = new Vector();
                for(int i = 1; i <= countColumn; i++){
                    row.addElement(rs.getString(i));
                }
                tableModel.addRow(row);
                tbSinhVien.setModel(tableModel);
            }
            //loadData();
        } 
        catch (Exception ex) {
           JOptionPane.showMessageDialog(null, ex.toString());
        }
    }//GEN-LAST:event_btnDSBaoLuuActionPerformed

    private void btnHuyBaoLuuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHuyBaoLuuActionPerformed
        // TODO add your handling code here:
        if(txtMaSV.getText().trim().equals("")){
            JOptionPane.showMessageDialog(null, "Vui lòng chọn 1 sinh viên đang bảo lưu");
            return;
        }
        try{
            
                ps=con.prepareStatement("Update SinhVien set TinhTrang=? where MaSV=?");
                String bl = "Đang học";
                ps.setString(1, bl);
                ps.setString(2, txtMaSV.getText().trim());
                if(JOptionPane.showConfirmDialog(this, "Xác nhận", "Hủy bảo lưu sinh viên này", JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION){
                    ps.executeUpdate();
                    tableModel.setRowCount(0);
                    loadData();
                    JOptionPane.showMessageDialog(null, "Hủy bảo lưu thành công");
                }
            }
        catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex.toString());
        }
    }//GEN-LAST:event_btnHuyBaoLuuActionPerformed

    private void btnThoatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThoatActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
    }//GEN-LAST:event_btnThoatActionPerformed

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
            java.util.logging.Logger.getLogger(QLBaoLuuKQHT.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(QLBaoLuuKQHT.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(QLBaoLuuKQHT.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(QLBaoLuuKQHT.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new QLBaoLuuKQHT().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBaoLuu;
    private javax.swing.JButton btnDSBaoLuu;
    private javax.swing.JButton btnHuyBaoLuu;
    private javax.swing.JButton btnThoat;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbSinhVien;
    private javax.swing.JTextField txtMaSV;
    // End of variables declaration//GEN-END:variables
}

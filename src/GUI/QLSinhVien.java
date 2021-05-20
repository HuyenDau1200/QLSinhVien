/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Db.DBConnection;
import Models.SinhVien;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.sql.*;
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
public class QLSinhVien extends javax.swing.JFrame {

    /**
     * Creates new form QLSinhVien
     */
    DefaultTableModel tableModel = new DefaultTableModel();
    ArrayList<SinhVien> lstSinhVien = new ArrayList<>();
    public QLSinhVien() {
        initComponents();
        loadCbbLop();
        loadData();
    }
    DBConnection db = new DBConnection();
    Connection con = db.getConnection();
    PreparedStatement ps;
    ResultSet rs;
    public void loadCbbLop(){
        try{
            ps = con.prepareStatement("select MaLop from LOP");
            rs = ps.executeQuery();
            while (rs.next()) {
                cbbLop.addItem(rs.getString("MaLop"));
            }
        }
        catch(Exception ex){
            System.out.println(ex.toString());
        }
    }
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
               // c.setMaSV(rs.getString("MaSV"));
                lstSinhVien.add(c);
            }
        } 
        catch (Exception ex) {
            System.out.println(ex.toString());
        }
    }
    public void xoaTrang(){
        txtMaSV.setText("");
        txtHoTen.setText("");
        txtNgaySinh.setText("");
        txtDiaChi.setText("");
        txtMatKhau.setText("");
        txtTinhTrang.setText("");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtHoTen = new javax.swing.JTextField();
        txtMaSV = new javax.swing.JTextField();
        txtMatKhau = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbSinhVien = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        cbbLop = new javax.swing.JComboBox<>();
        btnThem = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        btnThoat = new javax.swing.JButton();
        btnSua = new javax.swing.JButton();
        radioNam = new javax.swing.JRadioButton();
        radioNu = new javax.swing.JRadioButton();
        btnTim = new javax.swing.JButton();
        txtDiaChi = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtNgaySinh = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtTinhTrang = new javax.swing.JTextField();
        btnHienThi = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 51));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(204, 204, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Quản lý thông tin sinh viên"));
        jPanel1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Quản lý thông tin sinh viên");

        jLabel2.setText("Mã sinh viên");

        jLabel3.setText("Họ tên sinh viên");

        jLabel4.setText("Ngày sinh");

        jLabel5.setText("Giới tính");

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

        jLabel6.setText("Địa chỉ");

        jLabel7.setText("Mã lớp");

        cbbLop.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbLopActionPerformed(evt);
            }
        });

        btnThem.setText("Thêm");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        btnXoa.setText("Xóa");
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });

        btnThoat.setText("Thoát");
        btnThoat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThoatActionPerformed(evt);
            }
        });

        btnSua.setText("Sửa");
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });

        buttonGroup1.add(radioNam);
        radioNam.setText("Nam");

        buttonGroup1.add(radioNu);
        radioNu.setText("Nữ");

        btnTim.setText("Tìm");
        btnTim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimActionPerformed(evt);
            }
        });

        jLabel8.setText("Mật khẩu");

        jLabel9.setText("Tình trạng");

        btnHienThi.setText("Hiển thị");
        btnHienThi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHienThiActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(62, 62, 62)
                        .addComponent(txtMaSV, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(394, 394, 394))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5))
                        .addGap(44, 44, 44)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(txtNgaySinh, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel6)
                                            .addComponent(jLabel8))
                                        .addGap(21, 21, 21)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtMatKhau, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtDiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel9)
                                            .addComponent(jLabel7))
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(cbbLop, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtTinhTrang, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGap(89, 89, 89))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(txtHoTen, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(radioNam)
                                        .addGap(153, 153, 153))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(btnHienThi)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(btnTim)
                                        .addGap(27, 27, 27)))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(51, 51, 51)
                                        .addComponent(btnThem)
                                        .addGap(78, 78, 78)
                                        .addComponent(btnSua)
                                        .addGap(75, 75, 75)
                                        .addComponent(btnXoa)
                                        .addGap(65, 65, 65)
                                        .addComponent(btnThoat)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(radioNu)
                                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 928, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 50, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtMaSV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(txtDiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtHoTen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(txtMatKhau, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtNgaySinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4)
                            .addComponent(txtTinhTrang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9))
                        .addGap(17, 17, 17)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(radioNam)
                            .addComponent(radioNu)
                            .addComponent(cbbLop, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(113, 113, 113)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnTim)
                            .addComponent(btnThem)
                            .addComponent(btnSua)
                            .addComponent(btnXoa)
                            .addComponent(btnThoat)
                            .addComponent(btnHienThi))))
                .addGap(31, 31, 31)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(81, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1000, 540));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cbbLopActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbLopActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbbLopActionPerformed

    private void tbSinhVienMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbSinhVienMouseClicked
        // TODO add your handling code here:
      int row=tbSinhVien.getSelectedRow();
        txtMaSV.setText((tbSinhVien.getValueAt(row, 0)+"").trim());
        cbbLop.setSelectedItem(tbSinhVien.getValueAt(row, 1) + "");
        txtHoTen.setText(tbSinhVien.getModel().getValueAt(row, 2) + "");
        txtNgaySinh.setText(tbSinhVien.getValueAt(row, 3) + "");
        String gt=(tbSinhVien.getValueAt(row, 4)+"").trim();
        if(gt.equalsIgnoreCase("Nam"))
            radioNam.setSelected(true);
        if(gt.equalsIgnoreCase("Nữ"))
            radioNu.setSelected(true);
        txtDiaChi.setText((tbSinhVien.getValueAt(row, 5) + "").trim());
        txtMatKhau.setText((tbSinhVien.getValueAt(row, 6) + "").trim());
        txtTinhTrang.setText((tbSinhVien.getValueAt(row, 7) + "").trim());
        
    }//GEN-LAST:event_tbSinhVienMouseClicked

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        try {
            if(txtMaSV.getText().trim().equals("")||txtHoTen.getText().trim().equals("")||txtNgaySinh.getText().trim().equals("")||txtDiaChi.getText().equals("")||txtMatKhau.getText().equals("")||txtTinhTrang.getText().equals("")){
                JOptionPane.showMessageDialog(null, "Các trường mã sinh viên, họ tên, ngày sinh, địa chỉ, mật khẩu, tình trạng không được để trống");
                return;
            }
            // TODO add your handling code here:
            ps = con.prepareStatement("Insert into SinhVien values(?,?,?,?,?,?,?,?)");
            int dem=0;
            Iterator<SinhVien> it = lstSinhVien.iterator();
            while (it.hasNext()) {
                SinhVien next = it.next();
                if(next.getMaSV().trim().equals(txtMaSV.getText().trim())){
                    dem++;
                }
            }
            if(dem==0){
                ps.setString(1, txtMaSV.getText().trim());
                    ps.setString(2, cbbLop.getSelectedItem().toString().trim());
                    ps.setString(3, txtHoTen.getText().trim());
                    ps.setString(4, txtNgaySinh.getText().trim());
                    String gt ="";
                    if(radioNam.isSelected())
                        gt="Nam";
                    else if(radioNu.isSelected())
                        gt="Nữ";
                    ps.setString(5, gt);
                    ps.setString(6, txtDiaChi.getText().trim()); 
                    ps.setString(7, txtMatKhau.getText().trim()); 
                    ps.setString(8, txtTinhTrang.getText().trim()); 
                    ps.executeUpdate();
                    tableModel.setRowCount(0);
                    loadData();
                    JOptionPane.showMessageDialog(null, "Thêm thành công");
            }
            else{
                JOptionPane.showMessageDialog(null, "Mã sinh viên đã tồn tại");
            }
        }
        catch (Exception ex) {
           JOptionPane.showMessageDialog(null, ex.toString());
        }
        
    }//GEN-LAST:event_btnThemActionPerformed

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        // TODO add your handling code here:
        try {
            if(txtMaSV.getText().trim().equals("")){
                JOptionPane.showMessageDialog(null, "Vui lòng nhập mã sv cần sửa hoặc click vào 1 dòng để sửa");
                return;
            }
            if(txtHoTen.getText().trim().equals("")||txtNgaySinh.getText().trim().equals("")||txtDiaChi.getText().equals("")||txtMatKhau.getText().equals("")||txtTinhTrang.getText().equals("")){
                JOptionPane.showMessageDialog(null, "Các trường họ tên, ngày sinh, địa chỉ, mật khẩu, tình trạng không được để trống");
                return;
            }
            // TODO add your handling code here:
            ps = con.prepareStatement("Update SINHVIEN set MaLop=?, TenSV=?, NgaySinh=?, GioiTinh=?, DiaChi=?, MatKhau=?, TinhTrang=? where MaSV=?");
            int dem=0;
            Iterator<SinhVien> it = lstSinhVien.iterator();
            while (it.hasNext()) {
                SinhVien next = it.next();
                if(next.getMaSV().trim().equals(txtMaSV.getText().trim())){
                    dem++;
                }
            }
            if(dem>0){
                    ps.setString(1, cbbLop.getSelectedItem().toString().trim());
                    ps.setString(2, txtHoTen.getText().trim());
                    ps.setString(3, txtNgaySinh.getText().trim());
                    String gt ="";
                    if(radioNam.isSelected())
                        gt="Nam";
                    else if(radioNu.isSelected())
                        gt="Nữ";
                    ps.setString(4, gt);
                    ps.setString(5, txtDiaChi.getText().trim()); 
                    ps.setString(6, txtMatKhau.getText().trim()); 
                    ps.setString(7, txtTinhTrang.getText().trim()); 
                    ps.setString(8, txtMaSV.getText().trim());
                    ps.executeUpdate();
                    tableModel.setRowCount(0);
                    loadData();
                    JOptionPane.showMessageDialog(null, "Sửa thành công");
            }
            else{
                JOptionPane.showMessageDialog(null, "Không tồn tại mã sinh viên cần sửa");
            }
        }
        catch (Exception ex) {
           JOptionPane.showMessageDialog(null, ex.toString());
        }
    }//GEN-LAST:event_btnSuaActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        try {
            // TODO add your handling code here:
            if(txtMaSV.getText().trim().equals("")){
                JOptionPane.showMessageDialog(null, "Vui lòng nhập mã sv cần xóa hoặc click vào 1 dòng để xóa");
                return;
            }
            ps=con.prepareStatement("Delete from SinhVien where MaSV=?");
            int dem=0;
            Iterator<SinhVien> it = lstSinhVien.iterator();
            while (it.hasNext()) {
                SinhVien next = it.next();
                if(next.getMaSV().trim().equals(txtMaSV.getText().trim())){
                    dem++;
                }
            }
            if(dem>0){
                ps.setString(1, txtMaSV.getText().trim());
                if(JOptionPane.showConfirmDialog(this, "Xác nhận", "Xóa sinh viên này", JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION){
                    ps.executeUpdate();
                    tableModel.setRowCount(0);
                    loadData();
                    JOptionPane.showMessageDialog(null, "Xóa thành công");
                }
            }
            else{
                JOptionPane.showMessageDialog(null, "Mã sinh viên cần xóa không tồn tại");
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.toString());
        }
    }//GEN-LAST:event_btnXoaActionPerformed

    private void btnTimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimActionPerformed
        try {
            // TODO add your handling code here
            if(txtMaSV.getText().trim().equals("")){
                JOptionPane.showMessageDialog(null, "Vui lòng nhập mã sv cần tìm");
                return;
            }
            while(tableModel.getRowCount()>0){
                tableModel.removeRow(0);
            }
            
            ps=con.prepareStatement("Select * from SINHVIEN where MaSV=?");
            ps.setString(1, txtMaSV.getText().trim());
            rs=ps.executeQuery();
            int dem=0;
            Iterator<SinhVien> it = lstSinhVien.iterator();
            while (it.hasNext()) {
                SinhVien next = it.next();
                if(next.getMaSV().trim().equals(txtMaSV.getText().trim())){
                    dem++;
                }
            }
            if(dem>0){
                while(rs.next()){
                    Vector row = new Vector();
                    row.add(rs.getString("MaSV"));
                    row.add(rs.getString("MaLop"));
                    row.add(rs.getString("TenSV"));
                    row.add(rs.getString("NgaySinh"));
                    row.add(rs.getString("GioiTinh"));
                    row.add(rs.getString("DiaChi"));
                    row.add(rs.getString("TinhTrang"));
                    row.add(rs.getString("MatKhau"));
                    tableModel.addRow(row);
                    JOptionPane.showMessageDialog(null, "Có mã sv cần tìm");
                    xoaTrang();
                }
            }
            else{
                JOptionPane.showMessageDialog(null, "Không tìm thấy mã sinh viên này");
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.toString());
        }
        
    }//GEN-LAST:event_btnTimActionPerformed

    private void btnThoatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThoatActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
    }//GEN-LAST:event_btnThoatActionPerformed

    private void btnHienThiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHienThiActionPerformed
        // TODO add your handling code here:
        if(tableModel.getRowCount()>0){
            tableModel.removeRow(0);
        }
        loadData();
    }//GEN-LAST:event_btnHienThiActionPerformed

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
            java.util.logging.Logger.getLogger(QLSinhVien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(QLSinhVien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(QLSinhVien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(QLSinhVien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new QLSinhVien().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnHienThi;
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnThoat;
    private javax.swing.JButton btnTim;
    private javax.swing.JButton btnXoa;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JComboBox<String> cbbLop;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton radioNam;
    private javax.swing.JRadioButton radioNu;
    private javax.swing.JTable tbSinhVien;
    private javax.swing.JTextField txtDiaChi;
    private javax.swing.JTextField txtHoTen;
    private javax.swing.JTextField txtMaSV;
    private javax.swing.JTextField txtMatKhau;
    private javax.swing.JTextField txtNgaySinh;
    private javax.swing.JTextField txtTinhTrang;
    // End of variables declaration//GEN-END:variables
}

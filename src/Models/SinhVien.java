/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import java.util.logging.Logger;

/**
 *
 * @author admin
 */
public class SinhVien {
    protected String maSV, maLop, hoTen, ngaySinh, gioiTinh, diaChi, matKhau, tinhTrang;
    public SinhVien(){
        
    }
    public SinhVien(String msv, String ml, String ht, String ns, String gt, String dc, String mk, String tt){
        this.maSV=msv;
        this.maLop=ml;
        this.hoTen=ht;
        this.ngaySinh=ns;
        this.gioiTinh=gt;
        this.diaChi=dc;
        this.matKhau=mk;
        this.tinhTrang=tt;
    }

    public void setMaLop(String maLop) {
        this.maLop = maLop;
    }

    public String getMaLop() {
        return maLop;
    }

    public String getMaSV() {
        return maSV;
    }

    public String getHoTen() {
        return hoTen;
    }

    public String getNgaySinh() {
        return ngaySinh;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public String getMatKhau() {
        return matKhau;
    }

    public String getTinhTrang() {
        return tinhTrang;
    }

    public void setMaSV(String maSV) {
        this.maSV = maSV;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public void setNgaySinh(String ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }

    public void setTinhTrang(String tinhTrang) {
        this.tinhTrang = tinhTrang;
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

/**
 *
 * @author admin
 */
public class TaiKhoan {
    private String tenDangNhap;
    private String MatKhau;
    private String loaiTaiKhoan;
    public TaiKhoan(){
        
    }
    public TaiKhoan(String tdn, String mk, String ltk){
        tenDangNhap=tdn;
        MatKhau=mk;
        loaiTaiKhoan=ltk;
        
    }

    public void setTenDangNhap(String tenDangNhap) {
        this.tenDangNhap = tenDangNhap;
    }

    public void setMatKhau(String MatKhau) {
        this.MatKhau = MatKhau;
    }

    public void setLoaiTaiKhoan(String loaiTaiKhoan) {
        this.loaiTaiKhoan = loaiTaiKhoan;
    }

    public String getTenDangNhap() {
        return tenDangNhap;
    }

    public String getMatKhau() {
        return MatKhau;
    }

    public String getLoaiTaiKhoan() {
        return loaiTaiKhoan;
    }
    
}

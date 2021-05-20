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
public class MonHoc {
    private String maMH, tenMH;
    private int soTC, hocKy;

    public String getMaMH() {
        return maMH;
    }

    public String getTenMH() {
        return tenMH;
    }

    public int getSoTC() {
        return soTC;
    }

    public int getHocKy() {
        return hocKy;
    }

    public void setMaMH(String maMH) {
        this.maMH = maMH;
    }

    public void setTenMH(String tenMH) {
        this.tenMH = tenMH;
    }

    public void setSoTC(int soTC) {
        this.soTC = soTC;
    }

    public void setHocKy(int hocKy) {
        this.hocKy = hocKy;
    }
    
}

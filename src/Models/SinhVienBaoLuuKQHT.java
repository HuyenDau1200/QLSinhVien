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
public class SinhVienBaoLuuKQHT extends SinhVien{
    private String maBL, lyDoBaoLuu;
    public SinhVienBaoLuuKQHT(){
        super();
    }
    public SinhVienBaoLuuKQHT(String msv, String ml, String ht, String ns, String gt, String dc, String mk, String tt, String ldbl){
        super(msv, ml, ht, ns, gt, dc, mk, tt);
        this.lyDoBaoLuu=ldbl;
    }

    public String getMaBL() {
        return maBL;
    }

    public String getLyDoBaoLuu() {
        return lyDoBaoLuu;
    }

    public void setMaBL(String maBL) {
        this.maBL = maBL;
    }

    public void setLyDoBaoLuu(String lyDoBaoLuu) {
        this.lyDoBaoLuu = lyDoBaoLuu;
    }
}

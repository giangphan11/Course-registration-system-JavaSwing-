/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nhom5.show.gv;

import java.util.Date;

/**
 *
 * @author Giang Phan
 */
public class GVMonHocShow {
    
    private String maLop;
    private String maMH;
    private String tenMH;
    private Date ngayHoc;
    private int soSv;

    public GVMonHocShow() {
    }

    public GVMonHocShow(String maLop, String maMH, String tenMH, Date ngayHoc, int soSv) {
        this.maLop = maLop;
        this.maMH = maMH;
        this.tenMH = tenMH;
        this.ngayHoc = ngayHoc;
        this.soSv = soSv;
    }

    public String getMaLop() {
        return maLop;
    }

    public void setMaLop(String maLop) {
        this.maLop = maLop;
    }

    public String getMaMH() {
        return maMH;
    }

    public void setMaMH(String maMH) {
        this.maMH = maMH;
    }

    public String getTenMH() {
        return tenMH;
    }

    public void setTenMH(String tenMH) {
        this.tenMH = tenMH;
    }

    public Date getNgayHoc() {
        return ngayHoc;
    }

    public void setNgayHoc(Date ngayHoc) {
        this.ngayHoc = ngayHoc;
    }

    public int getSoSv() {
        return soSv;
    }

    public void setSoSv(int soSv) {
        this.soSv = soSv;
    }
    
    
}

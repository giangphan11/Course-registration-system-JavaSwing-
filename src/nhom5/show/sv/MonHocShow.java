/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nhom5.show.sv;

import java.util.Date;

/**
 *
 * @author Giang Phan
 */
public class MonHocShow {
    private String maMH;
    private String tenMH;
    private String tenLop;
    private String tenGV;
    private Date ngayHoc;
    private String diaDiem;
    private String thoiGian;
    private int sl;
    private double hocPhi;

    public MonHocShow() {
    }

    public MonHocShow(String ma,String tenMH, String tenLop, String tenGV, Date ngayHoc, String diaDiem, String thoiGian, int sl, double hocPhi) {
        this.maMH=ma;
        this.tenMH = tenMH;
        this.tenLop = tenLop;
        this.tenGV = tenGV;
        this.ngayHoc = ngayHoc;
        this.diaDiem = diaDiem;
        this.thoiGian = thoiGian;
        this.sl = sl;
        this.hocPhi = hocPhi;
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

    public String getTenLop() {
        return tenLop;
    }

    public void setTenLop(String tenLop) {
        this.tenLop = tenLop;
    }

    public String getTenGV() {
        return tenGV;
    }

    public void setTenGV(String tenGV) {
        this.tenGV = tenGV;
    }

    public Date getNgayHoc() {
        return ngayHoc;
    }

    public void setNgayHoc(Date ngayHoc) {
        this.ngayHoc = ngayHoc;
    }

    public String getDiaDiem() {
        return diaDiem;
    }

    public void setDiaDiem(String diaDiem) {
        this.diaDiem = diaDiem;
    }

    public String getThoiGian() {
        return thoiGian;
    }

    public void setThoiGian(String thoiGian) {
        this.thoiGian = thoiGian;
    }

    public int getSl() {
        return sl;
    }

    public void setSl(int sl) {
        this.sl = sl;
    }

    public double getHocPhi() {
        return hocPhi;
    }

    public void setHocPhi(double hocPhi) {
        this.hocPhi = hocPhi;
    }
    
    
}

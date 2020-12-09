/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nhom5.model;

import java.util.Date;

/**
 *
 * @author Giang Phan
 */
public class MonHoc {
    private String maMH;
    private String tenMH;
    private String maGV;
    private String thoiGian;
    private Date ngayHoc;
    private double hocPhi;
    private String diaDiem;
    private String maLop;

    public MonHoc() {
    }

    public MonHoc(String maMH, String tenMH, String maGV, String thoiGian, Date ngayHoc, double hocPhi, String diaDiem, String maLop) {
        this.maMH = maMH;
        this.tenMH = tenMH;
        this.maGV = maGV;
        this.thoiGian = thoiGian;
        this.ngayHoc = ngayHoc;
        this.hocPhi = hocPhi;
        this.diaDiem = diaDiem;
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

    public String getMaGV() {
        return maGV;
    }

    public void setMaGV(String maGV) {
        this.maGV = maGV;
    }

    public String getThoiGian() {
        return thoiGian;
    }

    public void setThoiGian(String thoiGian) {
        this.thoiGian = thoiGian;
    }

    public Date getNgayHoc() {
        return ngayHoc;
    }

    public void setNgayHoc(Date ngayHoc) {
        this.ngayHoc = ngayHoc;
    }

    public double getHocPhi() {
        return hocPhi;
    }

    public void setHocPhi(double hocPhi) {
        this.hocPhi = hocPhi;
    }

    public String getDiaDiem() {
        return diaDiem;
    }

    public void setDiaDiem(String diaDiem) {
        this.diaDiem = diaDiem;
    }

    public String getMaLop() {
        return maLop;
    }

    public void setMaLop(String maLop) {
        this.maLop = maLop;
    }

    @Override
    public String toString() {
        return this.tenMH ;
    }
}

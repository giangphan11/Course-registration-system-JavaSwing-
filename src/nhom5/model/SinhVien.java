/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nhom5.model;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author Giang Phan
 */
public class SinhVien implements Serializable{
    private String maSV;
    private String tenSV;
    private String gioiTinh;
    private String queQuan;
    private Date ngaySinh;
    private String xepLoai;
    private double tien;
    private String user;
    private String pass;

    public SinhVien() {
    }
    public SinhVien(String maSV, String tenSV, String gioiTinh, String queQuan, Date ngaySinh){
        this.maSV = maSV;
        this.tenSV = tenSV;
        this.gioiTinh = gioiTinh;
        this.queQuan = queQuan;
        this.ngaySinh = ngaySinh;
    }
    public SinhVien(String maSV, String tenSV, String gioiTinh, String queQuan, Date ngaySinh, String xepLoai, double tien, String user, String pass) {
        this.maSV = maSV;
        this.tenSV = tenSV;
        this.gioiTinh = gioiTinh;
        this.queQuan = queQuan;
        this.ngaySinh = ngaySinh;
        this.xepLoai = xepLoai;
        this.tien = tien;
        this.user = user;
        this.pass = pass;
    }

    public String getMaSV() {
        return maSV;
    }

    public void setMaSV(String maSV) {
        this.maSV = maSV;
    }

    public String getTenSV() {
        return tenSV;
    }

    public void setTenSV(String tenSV) {
        this.tenSV = tenSV;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public String getQueQuan() {
        return queQuan;
    }

    public void setQueQuan(String queQuan) {
        this.queQuan = queQuan;
    }

    public Date getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(Date ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public String getXepLoai() {
        return xepLoai;
    }

    public void setXepLoai(String xepLoai) {
        this.xepLoai = xepLoai;
    }

    public double getTien() {
        return tien;
    }

    public void setTien(double tien) {
        this.tien = tien;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    
}

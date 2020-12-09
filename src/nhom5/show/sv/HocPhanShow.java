/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nhom5.show.sv;

/**
 *
 * @author Giang Phan
 */
public class HocPhanShow {
    private int maHP;
    private String tenLop;
    private String tenMH;
    private String thoiGian;
    private String diaDiem;

    public HocPhanShow() {
    }

    public HocPhanShow( int maHP,String tenLop, String tenMH, String thoiGian, String diaDiem) {
        this.maHP=maHP;
        this.tenLop = tenLop;
        this.tenMH = tenMH;
        this.thoiGian = thoiGian;
        this.diaDiem = diaDiem;
    }

    public int getMaHP() {
        return maHP;
    }

    public void setMaHP(int maHP) {
        this.maHP = maHP;
    }

    public String getTenLop() {
        return tenLop;
    }

    public void setTenLop(String tenLop) {
        this.tenLop = tenLop;
    }

    public String getTenMH() {
        return tenMH;
    }

    public void setTenMH(String tenMH) {
        this.tenMH = tenMH;
    }

    public String getThoiGian() {
        return thoiGian;
    }

    public void setThoiGian(String thoiGian) {
        this.thoiGian = thoiGian;
    }

    public String getDiaDiem() {
        return diaDiem;
    }

    public void setDiaDiem(String diaDiem) {
        this.diaDiem = diaDiem;
    }
    
}

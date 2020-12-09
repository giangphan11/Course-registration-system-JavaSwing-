/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nhom5.model;

/**
 *
 * @author Giang Phan
 */
public class Lop {
    private String maLop;
    private String tenLop;
    private int slSv;

    public Lop() {
    }

    public Lop(String maLop, String tenLop, int slSv) {
        this.maLop = maLop;
        this.tenLop = tenLop;
        this.slSv = slSv;
    }

    public String getMaLop() {
        return maLop;
    }

    public void setMaLop(String maLop) {
        this.maLop = maLop;
    }

    public String getTenLop() {
        return tenLop;
    }

    public void setTenLop(String tenLop) {
        this.tenLop = tenLop;
    }

    public int getSlSv() {
        return slSv;
    }

    public void setSlSv(int slSv) {
        this.slSv = slSv;
    }

    @Override
    public String toString() {
        return this.tenLop; //To change body of generated methods, choose Tools | Templates.
    }
    
}

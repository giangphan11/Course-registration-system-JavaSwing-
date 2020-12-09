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
public class GiaoVien {
    private String maGV;
    private String tenGV;
    private String user;
    private String pass;

    public GiaoVien() {
    }

    public GiaoVien(String maGV, String tenGV, String user, String pass) {
        this.maGV = maGV;
        this.tenGV = tenGV;
        this.user = user;
        this.pass = pass;
    }

    public String getMaGV() {
        return maGV;
    }

    public void setMaGV(String maGV) {
        this.maGV = maGV;
    }

    public String getTenGV() {
        return tenGV;
    }

    public void setTenGV(String tenGV) {
        this.tenGV = tenGV;
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

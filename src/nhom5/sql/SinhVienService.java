/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nhom5.sql;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import nhom5.model.MonHoc;
import nhom5.model.SinhVien;
import nhom5.show.sv.HocPhanShow;
import nhom5.show.sv.MonHocShow;

/**
 *
 * @author Giang Phan
 */
public class SinhVienService extends SqlServerConnected{
    PreparedStatement pre=null;
    ResultSet result=null;
    public SinhVienService(){
        super();
    }
    public ArrayList<HocPhanShow>dsHocPhanTheoMaSV(String ma){
        ArrayList<HocPhanShow>dsHP=new ArrayList<>();
        try{
            String sql="{call PROC_HPTHEOMASV(?)}";
            CallableStatement callableStatement=conn.prepareCall(sql);
            callableStatement.setString(1, ma);
            ResultSet rs=callableStatement.executeQuery();
            while(rs.next()){
                int maHP=rs.getInt(1);
                String tenLop=rs.getString(2);
                String tenMH=rs.getString(3);
                String thoiGian=rs.getString(4);
                String diaDiem=rs.getString(5);
                HocPhanShow hp=new HocPhanShow(maHP,tenLop, tenMH, thoiGian, diaDiem);
                dsHP.add(hp);
            }
            rs.close();
        }
        catch(Exception ex){
            System.out.println("Lỗi: "+ex.getMessage());
        }
        return dsHP;
    }
    public boolean dangKyHP(String maMH,String maHS){
        try{
            String sql="INSERT INTO HOCPHAN VALUES(?,?)";
            PreparedStatement pre=conn.prepareStatement(sql);
            pre.setString(1, maMH);
            pre.setString(2, maHS);
            pre.executeUpdate();
            return true;
        }
        catch(Exception ex){
            System.out.println("Lỗi: "+ex.getMessage());
            return false;
        }
    }
    public ArrayList<MonHocShow>dsMonHocShow(){
        ArrayList<MonHocShow>dsM=new ArrayList<>();
        try{
            String sql="{call PROC_SHOWMONHOC}";
            CallableStatement callableStatement=conn.prepareCall(sql);
            ResultSet rs=callableStatement.executeQuery();
            while(rs.next()){
                String ma=rs.getString(1);
                String tenMH=rs.getString(2);
                String tenLop=rs.getString(3);
                String tenGV=rs.getString(4);
                Date ngayHoc=rs.getDate(5);
                String diaDiem=rs.getString(6);
                String thoiGian=rs.getString(7);
                int soSV=rs.getInt(8);
                double hocPhi=rs.getDouble(9);
                MonHocShow mh=new MonHocShow(ma,tenMH, tenLop, tenGV, ngayHoc, diaDiem, thoiGian, soSV, hocPhi);
                dsM.add(mh);
            }
            rs.close();
        }
        catch(Exception ex){
            System.out.println("Lỗi: "+ex.getMessage());
        }
        return dsM;
    }
    public boolean xoaHocPhan(int maHP, String maSV){
        try{
            String sql="DELETE HOCPHAN WHERE MAHP= ? AND MASV=?";
            PreparedStatement pre=conn.prepareStatement(sql);
            pre.setInt(1, maHP);
            pre.setString(2, maSV);
            pre.executeUpdate();
            return true;
        }
        catch(Exception ex){
            System.out.println("Lỗi: "+ex.getMessage());
        }
        return false;
    }
    public ArrayList<SinhVien>dsSinhVien(){
        ArrayList<SinhVien>dsSV=new ArrayList<>();
        try{
            String sql="SELECT * FROM SINHVIEN";
            PreparedStatement pre=conn.prepareStatement(sql);
            ResultSet rs=pre.executeQuery();
            while(rs.next()){
                String ma=rs.getString(1);
                String ten=rs.getString(2);
                String gt=rs.getString(3);
                String queQuan=rs.getString(4);
                Date ngaySinh=rs.getDate(5);
                String xepLoai=rs.getString(6);
                double tien=rs.getDouble(7);
                String user=rs.getString(8);
                String pass=rs.getString(9);
                SinhVien sv=new SinhVien(ma, ten, gt, queQuan, ngaySinh, xepLoai, tien, user, pass);
                dsSV.add(sv);
            }
            rs.close();
        }
        catch(Exception ex){
            System.out.println("Lỗi "+ex.getMessage());
        }
        return dsSV;
    }
}

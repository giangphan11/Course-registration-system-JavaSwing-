/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nhom5.sql;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.Stack;
import java.util.Vector;
import nhom5.model.GiaoVien;
import nhom5.model.Lop;
import nhom5.model.MonHoc;
import nhom5.model.SinhVien;
import nhom5.show.gv.GVMonHocShow;

/**
 *
 * @author Giang Phan
 */
public class GiaoVienService extends SqlServerConnected{
    public GiaoVienService(){
        super();
    }
    public boolean xoaHocPhanTheoMaMH(String maMH){
        try{
            String sql="DELETE HOCPHAN WHERE MAMH=?";
            PreparedStatement pre=conn.prepareStatement(sql);
            pre.setString(1, maMH);
            pre.executeUpdate();
            return true;
        }
        catch(Exception ex){
            System.out.println("Err: "+ex.getMessage());
        }
        return false;
    }
    public boolean xoaMonHoc(String maMH,String maGV){
        try{
            String sql="DELETE MONHOC WHERE MAMH=? AND MAGV=?";
            PreparedStatement pre=conn.prepareStatement(sql);
            pre.setString(1, maMH);
            pre.setString(2, maGV);
            pre.executeUpdate();
            return true;
        }
        catch(Exception ex){
            System.out.println("ERR: "+ex.getMessage());
        }
        return false;
    }
    public ArrayList<SinhVien>dsChiTietSVTheoMa(String maGV, String maMH){
        ArrayList<SinhVien>dsSV=new ArrayList<>();
        try{
            //HOCPHAN.MASV,TENSV,GT,QUEQUAN,NGAYSINH
            String sql="{call PROC_GV_CHITIETSV(?,?)}";
            CallableStatement call=conn.prepareCall(sql);
            call.setString(1, maGV);
            call.setString(2, maMH);
            ResultSet rs=call.executeQuery();
            while(rs.next()){
                String ma=rs.getString(1);
                String ten=rs.getString(2);
                String gt=rs.getString(3);
                String que=rs.getString(4);
                Date ngay=rs.getDate(5);
                SinhVien sv=new SinhVien(ma, ten, gt, que, ngay);
                dsSV.add(sv);
            }
            rs.close();
        }
        catch(Exception ex){
            System.out.println("Lỗi: "+ex.getMessage());
        }
        return dsSV;
    }
    public boolean suaMonHoc(String maMH,String tenMH,String maGV,double hp,String ngayHoc,String tg,String diaDiem,String maLop){
        try{
            String sql="UPDATE dbo.MONHOC SET TENMH=N'"+tenMH+"',HOCPHI= "+hp+",NGAYHOC='"+ngayHoc+"',THOIGIAN=N'"+tg+"',DIADIEM=N'"+diaDiem+"',MALOP='"+maLop+"'\n" +
                "WHERE MAMH='"+maMH+"' AND MAGV='"+maGV+"'";
            Statement sta=conn.createStatement();
            sta.executeUpdate(sql);
            return true;
        }
        catch(Exception ex){
            System.out.println("Lỗi: "+ex.getMessage());
        }
        return false;
    }
    public boolean themMonHoc(String maMH,String tenMH,String maGV,double hp,String ngayHoc,String tg,String diaDiem,String maLop){
        try{
            String sql="INSERT INTO MONHOC VALUES( N'"+maMH+"' , \n" +
"          N'"+tenMH+"' ,\n" +
"          N'"+maGV+"' ,\n" +
"          "+hp+" ,\n" +
"          '"+ngayHoc+"' ,\n" +
"          N'"+tg+"' ,\n" +
"          N'"+diaDiem+"' ,\n" +
"          N'"+maLop+"')";
            Statement sta=conn.createStatement();
            sta.executeUpdate(sql);
            return true;
        }
        catch(Exception ex){
            System.out.println("Lỗi: "+ex.getMessage());
        }
        return false;
    }
    public ArrayList<Lop>layDanhSachLop(){
        ArrayList<Lop>dsLop=new ArrayList<>();
        try{
            String sql="SELECT * FROM LOP";
            PreparedStatement pre=conn.prepareStatement(sql);
            ResultSet rs=pre.executeQuery();
            while(rs.next()){
                String maLop=rs.getString(1);
                String tenLop =rs.getString(2);
                int sv=rs.getInt(3);
                Lop lop=new Lop(maLop, tenLop, sv);
                dsLop.add(lop);
            }
            rs.close();
        }
        catch(Exception ex){
            System.out.println("Lỗi: "+ex.getMessage());
        }
        return dsLop;
    }
    public ArrayList<GVMonHocShow>dsMonHocTheoMa(String maGV, String maMH){
        ArrayList<GVMonHocShow>dsMH=new ArrayList<>();
        try{
            //LOP.MALOP,MAMH,TENMH,NGAYHOC,SOSV
            String sql="{call PROC_GV_THONGTINMH(?,?)}";
            CallableStatement call=conn.prepareCall(sql);
            call.setString(1, maGV);
            call.setString(2, maMH);
            ResultSet res=call.executeQuery();
            while(res.next()){
                String maLop=res.getString(1);
                String maM=res.getString(2);
                String tenM=res.getString(3);
                Date ngayHoc=res.getDate(4);
                int sv=res.getInt(5);
                GVMonHocShow mh=new GVMonHocShow(maLop, maM, tenM, ngayHoc, sv);
                dsMH.add(mh);
            }
            res.close();
        }
        catch(Exception ex){
            System.out.println("Lỗi: "+ex.getMessage());
        }
        return dsMH;
    }
    public Vector<MonHoc>dsMonHoc(String maGV){
        try{
            Vector<MonHoc>dsMon=new Vector<>();
            String sql="SELECT * FROM MONHOC WHERE MAGV= ?";
            PreparedStatement pre= conn.prepareStatement(sql);
            pre.setString(1, maGV);
            ResultSet rs=pre.executeQuery();
            while(rs.next()){
                String maMH=rs.getString(1);
                String tenMh=rs.getString(2);
                String maG=rs.getString(3);
                double hocPhi=rs.getDouble(4);
                Date ngayHoc=rs.getDate(5);
                String thoiGian=rs.getString(6);
                String diaDiem=rs.getString(7);
                String maLop=rs.getString(8);
                MonHoc mh=new MonHoc(maMH, tenMh, maG, thoiGian, ngayHoc, hocPhi, diaDiem, maLop);
                dsMon.add(mh);
            }
            rs.close();
            return dsMon;
        }
        catch(Exception ex){
            System.out.println("Lỗi: "+ex.getMessage());
        }
        return null;
    }
    public ArrayList<GiaoVien>dsGiaoVien(){
        ArrayList<GiaoVien>dsGV=new ArrayList<>();
        try{
            String sql="SELECT * FROM GIAOVIEN";
            PreparedStatement pre=conn.prepareStatement(sql);
            ResultSet rs=pre.executeQuery();
            while(rs.next()){
                String ma=rs.getString(1);
                String ten=rs.getString(2);
                String user=rs.getString(3);
                String pass=rs.getString(4);
                
                GiaoVien gv=new GiaoVien(ma, ten, user, pass);
                dsGV.add(gv);
            }
            rs.close();
        }
        catch(Exception ex){
            System.out.println("Lỗi: "+ex.getMessage());
        }
        return dsGV;
    }
}

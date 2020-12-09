/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nhom5.gui;

import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Date;
import java.util.Vector;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import nhom5.dialog.KiemTraUI;
import nhom5.model.SinhVien;
import nhom5.show.sv.MonHocShow;
import nhom5.sql.SinhVienService;

/**
 *
 * @author Giang Phan
 */
public class SinhVienUI extends javax.swing.JFrame {
    int rowSelected=0;
    DefaultTableModel dtm=null;
    SinhVienService sinhVienService=new SinhVienService();
    SinhVien sinhVIen;
    ArrayList<SinhVien>dsSV=LoginFrm.dsSV;
    MonHocShow monHocShowSelected=null;
    /**
     * Creates new form SinhVienUI
     */
    public SinhVienUI() {
    }
    public SinhVienUI(SinhVien sv) {
        this.sinhVIen=sv;
        initComponents();
        addControls();
        addEvents();
        
    }
    private void addControls(){
        
        LoginFrm.FrameDragListener frameDragListener = new LoginFrm.FrameDragListener(this);
        this.addMouseListener(frameDragListener);
        this.addMouseMotionListener(frameDragListener);
        
        dtm=(DefaultTableModel) tblMonHoc.getModel();
        dtm.addColumn("Mã");
        dtm.addColumn("Tên môn");
        dtm.addColumn("Tên lớp");
        dtm.addColumn("Giáo viên");
        dtm.addColumn("Ngày học");
        dtm.addColumn("Địa điểm");
        dtm.addColumn("Thời gian");
        dtm.addColumn("Số lượng");
        dtm.addColumn("Học phí");
        TableColumnModel colummodel=tblMonHoc.getColumnModel();
        colummodel.getColumn(0).setPreferredWidth(40);
        colummodel.getColumn(1).setPreferredWidth(130);
        colummodel.getColumn(2).setPreferredWidth(190);
        colummodel.getColumn(3).setPreferredWidth(170);
        Font f=new Font("Arial", Font.BOLD, 24);
        Border bf=(Border) BorderFactory.createLineBorder(Color.yellow);
        
        
        TitledBorder ttbd=new TitledBorder(bf, "Thông tin sinh viên",TitledBorder.CENTER,TitledBorder.CENTER, new Font("Arial", Font.BOLD, 24), Color.yellow);
        pnThongTin.setBorder(ttbd);
        txtTen.setText(sinhVIen.getTenSV());
        txtMa.setText(sinhVIen.getMaSV());
        txtXL.setText(sinhVIen.getXepLoai());
        txtTien.setText(sinhVIen.getTien()+"");
        txtQueQuan.setText(sinhVIen.getQueQuan());
        loadData();
    }
    private void loadData(){
        for(int i=tblMonHoc.getRowCount()-1; i>=0; i--){
            dtm.removeRow(i);
        }
        ArrayList<MonHocShow>dsMon=sinhVienService.dsMonHocShow();
        System.out.println(dsMon.size()+"");
        for(MonHocShow mh:dsMon){
            Vector<Object>vec=new Vector<>();
            vec.add(mh.getMaMH());
            vec.add(mh.getTenMH());
            vec.add(mh.getTenLop());
            vec.add(mh.getTenGV());
            vec.add(mh.getNgayHoc());
            vec.add(mh.getDiaDiem());
            vec.add(mh.getThoiGian());
            vec.add(mh.getSl());
            vec.add(mh.getHocPhi());
            dtm.addRow(vec);
        }
    }
    private void addEvents(){
        tblMonHoc.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                 int row=tblMonHoc.getSelectedRow();
                 if(row!=-1){
                     rowSelected=tblMonHoc.getSelectedRow();
                     String ma=tblMonHoc.getValueAt(row,0).toString();
                     String tenMon=tblMonHoc.getValueAt(row, 1).toString();
                     String tenLop=tblMonHoc.getValueAt(row, 2).toString();
                     String tengv=tblMonHoc.getValueAt(row, 3).toString();
                     Date ngayHoc=(Date) tblMonHoc.getValueAt(row, 4);
                     String diaDiem=tblMonHoc.getValueAt(row, 5).toString();
                     String thoiGian=tblMonHoc.getValueAt(row, 6).toString();
                     int sl=Integer.parseInt(tblMonHoc.getValueAt(row, 7).toString());
                     double tien=Double.parseDouble(tblMonHoc.getValueAt(row, 8).toString());
                     monHocShowSelected=new MonHocShow(ma,tenMon, tenLop, tengv, ngayHoc, diaDiem, thoiGian, sl, tien);
                 }
            }

            @Override
            public void mousePressed(MouseEvent e) {
                //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                 //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                 //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void mouseExited(MouseEvent e) {
                 //To change body of generated methods, choose Tools | Templates.
            }
        });
        
    }
    public static class FrameDragListener extends MouseAdapter {

        private final JFrame frame;
        private Point mouseDownCompCoords = null;

        public FrameDragListener(JFrame frame) {
            this.frame = frame;
        }

        public void mouseReleased(MouseEvent e) {
            mouseDownCompCoords = null;
        }

        public void mousePressed(MouseEvent e) {
            mouseDownCompCoords = e.getPoint();
        }

        public void mouseDragged(MouseEvent e) {
            Point currCoords = e.getLocationOnScreen();
            frame.setLocation(currCoords.x - mouseDownCompCoords.x, currCoords.y - mouseDownCompCoords.y);
        }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btnClose = new javax.swing.JLabel();
        btnHide = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblMonHoc = new javax.swing.JTable();
        pnThongTin = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtMa = new javax.swing.JLabel();
        txtTen = new javax.swing.JLabel();
        txtTien = new javax.swing.JLabel();
        txtXL = new javax.swing.JLabel();
        txtQueQuan = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        btnSVThoat = new javax.swing.JButton();
        btnDangKy = new javax.swing.JButton();
        btnKiemTra = new javax.swing.JButton();
        btnReLoad = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(108, 92, 231));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Đăng ký học phần");

        btnClose.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        btnClose.setForeground(new java.awt.Color(255, 255, 255));
        btnClose.setText("X");
        btnClose.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnClose.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCloseMouseClicked(evt);
            }
        });

        btnHide.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        btnHide.setForeground(new java.awt.Color(255, 255, 255));
        btnHide.setText("-");
        btnHide.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnHide.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnHideMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 685, Short.MAX_VALUE)
                .addComponent(btnHide)
                .addGap(18, 18, 18)
                .addComponent(btnClose)
                .addGap(25, 25, 25))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(btnClose)
                    .addComponent(btnHide))
                .addContainerGap(19, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(12, 36, 97));

        tblMonHoc.setBackground(new java.awt.Color(130, 204, 221));
        tblMonHoc.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        tblMonHoc.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tblMonHoc.setGridColor(new java.awt.Color(255, 255, 0));
        tblMonHoc.setRowHeight(30);
        tblMonHoc.setSelectionBackground(new java.awt.Color(255, 204, 0));
        tblMonHoc.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane2.setViewportView(tblMonHoc);

        pnThongTin.setBackground(new java.awt.Color(12, 36, 97));

        jLabel2.setBackground(new java.awt.Color(246, 185, 59));
        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(246, 185, 59));
        jLabel2.setText("Họ và tên:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(246, 185, 59));
        jLabel3.setText("Mã:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(246, 185, 59));
        jLabel4.setText("Quê quán:");

        jLabel5.setBackground(new java.awt.Color(246, 185, 59));
        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(246, 185, 59));
        jLabel5.setText("Số tiền trong tài khoản:");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(246, 185, 59));
        jLabel6.setText("Khoa:");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(246, 185, 59));
        jLabel7.setText("Xếp hạng:");

        txtMa.setBackground(new java.awt.Color(246, 185, 59));
        txtMa.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        txtMa.setForeground(new java.awt.Color(116, 185, 255));
        txtMa.setText("2017603673");

        txtTen.setBackground(new java.awt.Color(246, 185, 59));
        txtTen.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        txtTen.setForeground(new java.awt.Color(116, 185, 255));
        txtTen.setText("Phan Bá Giang");

        txtTien.setBackground(new java.awt.Color(246, 185, 59));
        txtTien.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        txtTien.setForeground(new java.awt.Color(116, 185, 255));
        txtTien.setText("txtTien");

        txtXL.setBackground(new java.awt.Color(246, 185, 59));
        txtXL.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        txtXL.setForeground(new java.awt.Color(116, 185, 255));
        txtXL.setText("Giỏi");

        txtQueQuan.setBackground(new java.awt.Color(246, 185, 59));
        txtQueQuan.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        txtQueQuan.setForeground(new java.awt.Color(116, 185, 255));
        txtQueQuan.setText("Nghệ An");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(116, 185, 255));
        jLabel8.setText("Công nghệ thông tin");

        javax.swing.GroupLayout pnThongTinLayout = new javax.swing.GroupLayout(pnThongTin);
        pnThongTin.setLayout(pnThongTinLayout);
        pnThongTinLayout.setHorizontalGroup(
            pnThongTinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnThongTinLayout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(pnThongTinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnThongTinLayout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(18, 18, 18)
                        .addComponent(txtQueQuan, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnThongTinLayout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(77, 77, 77)
                        .addComponent(txtMa, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnThongTinLayout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(txtTen, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 201, Short.MAX_VALUE)
                .addGroup(pnThongTinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(jLabel7)
                    .addComponent(jLabel6))
                .addGap(26, 26, 26)
                .addGroup(pnThongTinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtXL, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTien, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(93, 93, 93))
        );
        pnThongTinLayout.setVerticalGroup(
            pnThongTinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnThongTinLayout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(pnThongTinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnThongTinLayout.createSequentialGroup()
                        .addGroup(pnThongTinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(txtTien))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnThongTinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(jLabel8))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnThongTinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(txtXL)))
                    .addGroup(pnThongTinLayout.createSequentialGroup()
                        .addGroup(pnThongTinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtTen))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnThongTinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtMa))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnThongTinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txtQueQuan))))
                .addContainerGap(37, Short.MAX_VALUE))
        );

        btnSVThoat.setBackground(new java.awt.Color(234, 32, 39));
        btnSVThoat.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        btnSVThoat.setForeground(new java.awt.Color(255, 255, 255));
        btnSVThoat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/nhom5/gui/logout32.png"))); // NOI18N
        btnSVThoat.setText("Thoát");
        btnSVThoat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSVThoatActionPerformed(evt);
            }
        });

        btnDangKy.setBackground(new java.awt.Color(6, 82, 221));
        btnDangKy.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        btnDangKy.setForeground(new java.awt.Color(255, 255, 255));
        btnDangKy.setIcon(new javax.swing.ImageIcon(getClass().getResource("/nhom5/gui/add.png"))); // NOI18N
        btnDangKy.setText("Đăng ký");
        btnDangKy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDangKyActionPerformed(evt);
            }
        });

        btnKiemTra.setBackground(new java.awt.Color(87, 88, 187));
        btnKiemTra.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        btnKiemTra.setForeground(new java.awt.Color(255, 255, 255));
        btnKiemTra.setIcon(new javax.swing.ImageIcon(getClass().getResource("/nhom5/gui/check32.png"))); // NOI18N
        btnKiemTra.setText("Kiểm tra");
        btnKiemTra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKiemTraActionPerformed(evt);
            }
        });

        btnReLoad.setBackground(new java.awt.Color(6, 82, 221));
        btnReLoad.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        btnReLoad.setForeground(new java.awt.Color(255, 255, 255));
        btnReLoad.setIcon(new javax.swing.ImageIcon(getClass().getResource("/nhom5/gui/reload32.png"))); // NOI18N
        btnReLoad.setText("ReLoad");
        btnReLoad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReLoadActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(65, 65, 65)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 1090, Short.MAX_VALUE)
                    .addComponent(pnThongTin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnReLoad, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(75, 75, 75)
                .addComponent(btnDangKy, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(72, 72, 72)
                .addComponent(btnKiemTra, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(69, 69, 69)
                .addComponent(btnSVThoat, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(150, 150, 150))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnThongTin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnDangKy, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnKiemTra, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSVThoat, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnReLoad, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(60, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnHideMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnHideMouseClicked
        this.setState(JFrame.ICONIFIED);
    }//GEN-LAST:event_btnHideMouseClicked

    private void btnCloseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCloseMouseClicked
        int cf=JOptionPane.showConfirmDialog(this, "Bạn chắc chắn muốn thoát?", "Xác nhận thoát", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, new ImageIcon("images/ques.png"));
        if(cf==JOptionPane.YES_OPTION){
            System.exit(0);
        }
        else{
            return;
        }   
    }//GEN-LAST:event_btnCloseMouseClicked

    private void btnSVThoatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSVThoatActionPerformed
        int cf=JOptionPane.showConfirmDialog(this, "Bạn chắc chắn muốn thoát?", "Xác nhận thoát", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, new ImageIcon("images/ques.png"));
        if(cf==JOptionPane.YES_OPTION){
            LoginFrm login=new LoginFrm();
            login.setVisible(true);
            login.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            login.pack();
            this.dispose();
        }
        else{
            return;
        }
        
    }//GEN-LAST:event_btnSVThoatActionPerformed

    private void btnKiemTraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKiemTraActionPerformed
        KiemTraUI ui=new KiemTraUI(sinhVIen);
        ui.setVisible(true);

    }//GEN-LAST:event_btnKiemTraActionPerformed

    private void btnDangKyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDangKyActionPerformed
        int row=tblMonHoc.getSelectedRow();
        if(row!=-1){
            if(sinhVienService.dangKyHP(monHocShowSelected.getMaMH(), sinhVIen.getMaSV())){
               JOptionPane.showMessageDialog(null, "Đăng ký học phần thành công !");
               dtm.removeRow(rowSelected);
               ArrayList<SinhVien>dsSinhVien=sinhVienService.dsSinhVien();
        for(SinhVien sv : dsSinhVien){
            if(sv.getMaSV().equals(sinhVIen.getMaSV())){
                txtTien.setText(sv.getTien()+"");
            }
        }
           }
           else{
               JOptionPane.showMessageDialog(null, "Đăng ký thất bại!");
               return;
           }
        }
        else{
            return;
        }
        
    }//GEN-LAST:event_btnDangKyActionPerformed

    private void btnReLoadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReLoadActionPerformed
        ArrayList<SinhVien>dsSinhVien=sinhVienService.dsSinhVien();
        for(SinhVien sv : dsSinhVien){
            if(sv.getMaSV().equals(sinhVIen.getMaSV())){
                txtTien.setText(sv.getTien()+"");
            }
        }
        
    }//GEN-LAST:event_btnReLoadActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(SinhVienUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SinhVienUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SinhVienUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SinhVienUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SinhVienUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btnClose;
    private javax.swing.JButton btnDangKy;
    private javax.swing.JLabel btnHide;
    private javax.swing.JButton btnKiemTra;
    private javax.swing.JButton btnReLoad;
    private javax.swing.JButton btnSVThoat;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JPanel pnThongTin;
    private javax.swing.JTable tblMonHoc;
    private javax.swing.JLabel txtMa;
    private javax.swing.JLabel txtQueQuan;
    private javax.swing.JLabel txtTen;
    private javax.swing.JLabel txtTien;
    private javax.swing.JLabel txtXL;
    // End of variables declaration//GEN-END:variables
}

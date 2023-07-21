/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package view;

import ViewModel.QLChucVu;
<<<<<<< HEAD
import ViewModel.QLNhanVien;
import java.awt.Color;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import service.InterfaceChucVu;
import service.InterfaceNV;
import service.NV_impl;
import service.ServiceChucVu;
=======
import domainModel.ChucVu;
import domainModel.NhanVien;
import java.awt.Color;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import service.ServiceChucVu;
import service.ServiceNhanVien;
>>>>>>> 793e3ff4757eb36426a620cc58ad082748016e18
import swing.swing.ScrollBar;

/**
 *
 * @author sethk
 */
public class FormQLNV extends javax.swing.JPanel {
<<<<<<< HEAD

    int index = -1;
    DefaultTableModel model = new DefaultTableModel();
    DefaultComboBoxModel CBOModel;
    InterfaceNV sv = new NV_impl();
    InterfaceChucVu sv_CV = new ServiceChucVu();

=======
    
    DefaultTableModel model = new DefaultTableModel();
    ServiceNhanVien service = new ServiceNhanVien();
    int index;
>>>>>>> 793e3ff4757eb36426a620cc58ad082748016e18
    /**
     * Creates new form FormQLNV
     */
    public FormQLNV() {
        initComponents();
        rdonam.setBackground(new Color(0, 0, 0, 0));
        spTable.setVerticalScrollBar(new ScrollBar());
        spTable.getVerticalScrollBar().setBackground(Color.WHITE);
        spTable.getViewport().setBackground(Color.WHITE);
        this.setBackground(new Color(0, 0, 0, 0));
        cboCV.setBackground(new Color(0, 0, 0, 0));
        panelButton.setBackground(new Color(0, 0, 0, 0));

        JPanel p = new JPanel();
        p.setBackground(Color.WHITE);
        spTable.setCorner(JScrollPane.UPPER_RIGHT_CORNER, p);
<<<<<<< HEAD

        loadData(sv.getAllNV());
        loadCBO_CV(sv_CV.getList());
        rdonam.setSelected(true);
    }

    public void loadCBO_CV(ArrayList<QLChucVu> lstQLCV) {
        CBOModel = new DefaultComboBoxModel();
        CBOModel = (DefaultComboBoxModel) cboCV.getModel();
        for (QLChucVu qLChucVu : lstQLCV) {
            CBOModel.addElement(qLChucVu.getTenQLChucVu());
        }
    }

    public void loadData(ArrayList<QLNhanVien> lstQLNV) {
        model = (DefaultTableModel) tblNV.getModel();
        model.setRowCount(0);
        for (QLNhanVien qlNV : lstQLNV) {
            model.addRow(new Object[]{
                qlNV.getMa(),
                qlNV.getHoTen(),
                qlNV.getGioiTinh(),
                qlNV.getMaCv().equalsIgnoreCase("NV") ? "Nhân Viên" : "Quản Lý",
                qlNV.getEmail(),
                qlNV.getCmt(),
                qlNV.getSdt(),
                qlNV.getDiaChi(),
                qlNV.getNgaySinh()
            });
        }
    }

    public void clear() {
        txtma.setText("");
        txtten.setText("");
        txtemail.setText("");
        txtCCCD.setText("");
        txtsdt.setText("");
        txtdc.setText("");
        txtns.setText("");
        rdonam.setSelected(true);
        cboCV.setSelectedIndex(0);
    }

    public void showIndex() {
        QLNhanVien nv = sv.getAllNV().get(index);
        txtma.setText(nv.getMa());
        txtten.setText(nv.getHoTen());
        txtemail.setText(nv.getEmail());
        txtCCCD.setText(nv.getCmt());
        txtsdt.setText(nv.getSdt());
        txtdc.setText(nv.getDiaChi());
        txtns.setText(nv.getNgaySinh() + "");
        if (nv.getGioiTinh().equalsIgnoreCase("nam")) {
            rdonam.setSelected(true);
        } else {
            rdonu.setSelected(true);
        }
        cboCV.setSelectedItem(nv.getMaCv());
        tblNV.setRowSelectionInterval(index, index);
    }

    public boolean check() {
        if (txtma.getText().trim().isEmpty()
                || txtten.getText().trim().isEmpty()
                || txtsdt.getText().trim().isEmpty()
                || txtemail.getText().trim().isEmpty()
                || txtCCCD.getText().trim().isEmpty()
                || txtdc.getText().trim().isEmpty()
                || txtns.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Không được để trống thông tin");
            return false;
        }
        if (txtma.getText().length() < 51
                || txtten.getText().length() < 51
                || txtsdt.getText().length() < 51
                || txtemail.getText().length() < 51
                || txtCCCD.getText().length() < 51
                || txtdc.getText().length() < 51
                || txtns.getText().length() < 51) {
            JOptionPane.showMessageDialog(this, "Không được vượt quá 50 ký tự");
            return false;
        }
        String email = "^([a-z0-9_\\.-]+)@([\\da-z\\.-]+)\\.([a-z\\.]{2,6})$";
        Matcher match = Pattern.compile(email).matcher(txtemail.getText());
        if (!match.matches()) {
            JOptionPane.showMessageDialog(this, "Email không đúng định dạng");
            return false;
        }
        if (txtsdt.getText().length() != 10) {
            JOptionPane.showMessageDialog(this, "sdt phải đủ 10 số");
            return false;
        }
        if (txtCCCD.getText().length() != 12) {
            JOptionPane.showMessageDialog(this, "CCCD phải đủ 12 số");
            return false;
        }
        try {
            String getNS = txtns.getText();
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            sdf.parse(getNS);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Ngày không đúng định dạng: dd/MM/yyyy");
            return false;
        }
        ArrayList<QLNhanVien> lstnv = sv.getAllNV();
        for (QLNhanVien qLNhanVien : lstnv) {
            if (txtma.getText().equalsIgnoreCase(qLNhanVien.getMa())) {
                JOptionPane.showMessageDialog(this, "Trùng mã NV");
                return false;
            }
        }

        return true;
=======
        loadToTable(service.getAllNV());
     
       
>>>>>>> 793e3ff4757eb36426a620cc58ad082748016e18
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
        panelBorder1 = new swing.swing.PanelBorder();
        panelSeth4 = new swing.component.PanelSeth();
        jLabel2 = new javax.swing.JLabel();
<<<<<<< HEAD
=======
        spTable = new javax.swing.JScrollPane();
        tblNV = new swing.swing.Table();
>>>>>>> 793e3ff4757eb36426a620cc58ad082748016e18
        jLabel1 = new javax.swing.JLabel();
        txtma = new swing.controls.TextField();
        jLabel3 = new javax.swing.JLabel();
        txtemail = new swing.controls.TextField();
        jLabel4 = new javax.swing.JLabel();
        txtten = new swing.controls.TextField();
        jLabel5 = new javax.swing.JLabel();
        txtsdt = new swing.controls.TextField();
        jLabel6 = new javax.swing.JLabel();
        cboCV = new swing.controls.Combobox();
        jLabel7 = new javax.swing.JLabel();
        txtdc = new swing.controls.TextField();
        jLabel8 = new javax.swing.JLabel();
        txtCCCD = new swing.controls.TextField();
        jLabel9 = new javax.swing.JLabel();
        txtns = new swing.controls.TextField();
        panelButton = new swing.swing.PanelBorder();
        button3 = new swing.controls.Button();
        button4 = new swing.controls.Button();
        button5 = new swing.controls.Button();
        rdonam = new swing.RadioButtonCustom();
        rdonu = new swing.RadioButtonCustom();
        spTable = new javax.swing.JScrollPane();
        tblNV = new swing.swing.Table();

        setPreferredSize(new java.awt.Dimension(1079, 586));

        panelSeth4.setColor1(new java.awt.Color(28, 181, 224));
        panelSeth4.setColor2(new java.awt.Color(0, 0, 70));

        jLabel2.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/staff.png"))); // NOI18N
        jLabel2.setText("  Quản Lý Nhân Viên");

<<<<<<< HEAD
=======
        spTable.setBorder(null);

        tblNV.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã NV", "Họ Tên", "Giới Tính", "MA.CV", "Email", "CCCD", "SĐT", "Địa Chỉ", "Ngày Sinh"
            }
        ));
        spTable.setViewportView(tblNV);

>>>>>>> 793e3ff4757eb36426a620cc58ad082748016e18
        jLabel1.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Mã NV");

        txtma.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N

        jLabel3.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Họ & Tên");

        txtemail.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N

        jLabel4.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("E-mail");

        txtten.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N

        jLabel5.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("SĐT");

        txtsdt.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N

        jLabel6.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
<<<<<<< HEAD
        jLabel6.setText("Mã_CV");
=======
        jLabel6.setText("MACV");
>>>>>>> 793e3ff4757eb36426a620cc58ad082748016e18

        jLabel7.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Đ/C");

        txtdc.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N

        jLabel8.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("CCCD");

        txtCCCD.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N

        jLabel9.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("N/S");

        txtns.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N

        button3.setForeground(new java.awt.Color(102, 102, 102));
        button3.setText("Thêm");
        button3.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        button3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button3ActionPerformed(evt);
            }
        });

        button4.setForeground(new java.awt.Color(102, 102, 102));
        button4.setText("Sửa");
        button4.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        button4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button4ActionPerformed(evt);
            }
        });

        button5.setForeground(new java.awt.Color(102, 102, 102));
        button5.setText("Xóa");
        button5.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        button5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelButtonLayout = new javax.swing.GroupLayout(panelButton);
        panelButton.setLayout(panelButtonLayout);
        panelButtonLayout.setHorizontalGroup(
            panelButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelButtonLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(panelButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(button5, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(button4, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(button3, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(18, Short.MAX_VALUE))
        );
        panelButtonLayout.setVerticalGroup(
            panelButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelButtonLayout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(button3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(button4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(button5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(63, Short.MAX_VALUE))
        );

        buttonGroup1.add(rdonam);
        rdonam.setForeground(new java.awt.Color(255, 255, 255));
        rdonam.setText("Nam");
        rdonam.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        rdonam.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdonamActionPerformed(evt);
            }
        });

        buttonGroup1.add(rdonu);
        rdonu.setForeground(new java.awt.Color(255, 255, 255));
        rdonu.setText("Nữ");
        rdonu.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        rdonu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdonuActionPerformed(evt);
            }
        });

        tblNV.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5", "Title 6", "Title 7", "Title 8", "Title 9"
            }
        ));
        tblNV.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblNVMouseClicked(evt);
            }
        });
        spTable.setViewportView(tblNV);

        javax.swing.GroupLayout panelSeth4Layout = new javax.swing.GroupLayout(panelSeth4);
        panelSeth4.setLayout(panelSeth4Layout);
        panelSeth4Layout.setHorizontalGroup(
            panelSeth4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelSeth4Layout.createSequentialGroup()
                .addGroup(panelSeth4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelSeth4Layout.createSequentialGroup()
                        .addGap(313, 313, 313)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 353, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelSeth4Layout.createSequentialGroup()
                        .addGap(356, 356, 356)
                        .addComponent(rdonam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(rdonu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 243, Short.MAX_VALUE))
            .addGroup(panelSeth4Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(panelSeth4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addGroup(panelSeth4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(spTable, javax.swing.GroupLayout.PREFERRED_SIZE, 654, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panelSeth4Layout.createSequentialGroup()
                        .addGroup(panelSeth4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtma, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtten, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtemail, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtCCCD, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(140, 140, 140)
                        .addGroup(panelSeth4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addGap(45, 45, 45)
                        .addGroup(panelSeth4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtns, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtdc, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(panelSeth4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(cboCV, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtsdt, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(78, 78, 78)
                        .addComponent(panelButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(133, Short.MAX_VALUE))
        );
        panelSeth4Layout.setVerticalGroup(
            panelSeth4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelSeth4Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(panelSeth4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelSeth4Layout.createSequentialGroup()
                        .addGroup(panelSeth4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelSeth4Layout.createSequentialGroup()
                                .addGap(24, 24, 24)
                                .addGroup(panelSeth4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtma, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(21, 21, 21)
                                .addGroup(panelSeth4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtten, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(21, 21, 21)
                                .addGroup(panelSeth4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtemail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(28, 28, 28)
                                .addGroup(panelSeth4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtCCCD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(panelSeth4Layout.createSequentialGroup()
                                .addGap(35, 35, 35)
                                .addGroup(panelSeth4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(panelSeth4Layout.createSequentialGroup()
                                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(31, 31, 31)
                                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(32, 32, 32)
                                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(41, 41, 41)
                                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(panelSeth4Layout.createSequentialGroup()
                                        .addComponent(txtsdt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(21, 21, 21)
                                        .addComponent(cboCV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtdc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(21, 21, 21)
                                        .addComponent(txtns, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(18, 18, 18)
                        .addGroup(panelSeth4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(rdonu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(rdonam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 76, Short.MAX_VALUE)
                        .addComponent(spTable, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(197, 197, 197))
                    .addGroup(panelSeth4Layout.createSequentialGroup()
                        .addGap(58, 58, 58)
                        .addComponent(panelButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        javax.swing.GroupLayout panelBorder1Layout = new javax.swing.GroupLayout(panelBorder1);
        panelBorder1.setLayout(panelBorder1Layout);
        panelBorder1Layout.setHorizontalGroup(
            panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelSeth4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        panelBorder1Layout.setVerticalGroup(
            panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelSeth4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelBorder1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelBorder1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void button3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button3ActionPerformed
        // TODO add your handling code here:
        try {
            if (check()) {
                String ma = txtma.getText();
                String ten = txtten.getText();
                String email = txtemail.getText();
                String cmt = txtCCCD.getText();
                String sdt = txtsdt.getText();
                String dc = txtdc.getText();
                String getNS = txtns.getText();
                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                Date ns = sdf.parse(getNS);
                String gt;
                if (rdonam.isSelected()) {
                    gt = "nam";
                } else {
                    gt = "nữ";
                }
                String macv = sv_CV.getList().get(cboCV.getSelectedIndex()).getMa();
                QLNhanVien nv = new QLNhanVien(ma, ten, email, sdt, macv, dc, cmt, ns, gt);
                JOptionPane.showMessageDialog(this, sv.addNew(nv));
                clear();
                loadData(sv.getAllNV());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_button3ActionPerformed

    private void button4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button4ActionPerformed
        // TODO add your handling code here:
        try {
            if (check()) {
                String id = sv.getAllNV().get(index).getId();
                String ma = txtma.getText();
                String ten = txtten.getText();
                String email = txtemail.getText();
                String cmt = txtCCCD.getText();
                String sdt = txtsdt.getText();
                String dc = txtdc.getText();
                String getNS = txtns.getText();
                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                Date ns = sdf.parse(getNS);
                String gt;
                if (rdonam.isSelected()) {
                    gt = "nam";
                } else {
                    gt = "nữ";
                }
                String macv = sv_CV.getList().get(cboCV.getSelectedIndex()).getMa();
                QLNhanVien nv = new QLNhanVien(ma, ten, email, sdt, macv, dc, cmt, ns, gt);
                JOptionPane.showMessageDialog(this, sv.updateNV(id, nv));
                clear();
                loadData(sv.getAllNV());
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "chọn nhân viên muốn sửa");
            return;
        }
    }//GEN-LAST:event_button4ActionPerformed

    private void button5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button5ActionPerformed
        // TODO add your handling code here:
        try {
            String id = sv.getAllNV().get(index).getId();
            JOptionPane.showMessageDialog(this, sv.deleteNV(id));
            clear();
            loadData(sv.getAllNV());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "chọn nhân viên muốn xóa");
            return;
        }
    }//GEN-LAST:event_button5ActionPerformed

    private void rdonamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdonamActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rdonamActionPerformed

    private void rdonuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdonuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rdonuActionPerformed

    private void tblNVMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblNVMouseClicked
        // TODO add your handling code here:
        index = tblNV.getSelectedRow();
        showIndex();
    }//GEN-LAST:event_tblNVMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private swing.controls.Button button3;
    private swing.controls.Button button4;
    private swing.controls.Button button5;
    private javax.swing.ButtonGroup buttonGroup1;
    private swing.controls.Combobox cboCV;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private swing.swing.PanelBorder panelBorder1;
    private swing.swing.PanelBorder panelButton;
    private swing.component.PanelSeth panelSeth4;
    private swing.RadioButtonCustom rdonam;
    private swing.RadioButtonCustom rdonu;
    private javax.swing.JScrollPane spTable;
    private swing.swing.Table tblNV;
<<<<<<< HEAD
=======
    private swing.controls.TextField textField1;
    private swing.controls.TextField textField2;
    private swing.controls.TextField textField3;
    private swing.controls.TextField textField4;
    private swing.controls.TextField textField5;
    private swing.controls.TextField textField7;
>>>>>>> 793e3ff4757eb36426a620cc58ad082748016e18
    private swing.controls.TextField txtCCCD;
    private swing.controls.TextField txtdc;
    private swing.controls.TextField txtemail;
    private swing.controls.TextField txtma;
    private swing.controls.TextField txtns;
    private swing.controls.TextField txtsdt;
    private swing.controls.TextField txtten;
    // End of variables declaration//GEN-END:variables

    private void loadToTable(ArrayList<NhanVien> nv) {
        model = (DefaultTableModel) tblNV.getModel();
        model.setRowCount(0);
        for (NhanVien nhanVien : nv) {
            model.addRow(new Object[]{nhanVien.getMa(),nhanVien.getHoTen(),nhanVien.getGioiTinh(),nhanVien.getMaCv(),nhanVien.getEmail(),nhanVien.getCmt(),nhanVien.getSdt(),nhanVien.getDiaChi(),nhanVien.getNgaySinh()});
        }
    }
}

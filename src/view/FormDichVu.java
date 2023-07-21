/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package view;

import java.awt.Color;
import java.util.*;
import ViewModel.QLDichVu;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import repository.RPDichVu;
import service.InterfaceDichVu;
import service.ServiceDichVu;

/**
 *
 * @author sethk
 */
public class FormDichVu extends javax.swing.JPanel {

    private RPDichVu repo = new RPDichVu();
    private DefaultTableModel model = new DefaultTableModel();
    private InterfaceDichVu service = new ServiceDichVu();
    private int Index, click;

    /**
     * Creates new form FormDichVu
     */
    public FormDichVu() {
        initComponents();
        setBackground(new Color(0, 0, 0, 0));
        fillToTable(service.getListDichVu());
//        showIndex();
    }

    public void clean() {
        txtDVT.setText("");
        txtTenDichVu.setText("");
        txtGia.setText("");
        txtSoLuong.setText("");
    }

    public boolean checkText() {
        if (txtDVT.getText().trim().equalsIgnoreCase("") || txtGia.getText().trim().equalsIgnoreCase("") || txtSoLuong.getText().trim().equalsIgnoreCase("") || txtTenDichVu.getText().trim().equalsIgnoreCase("")) {
            JOptionPane.showMessageDialog(null, "Bạn không được để trắng thông tin ở trên");
            return false;
        }

        try {
            Double.parseDouble(txtGia.getText());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Giá phải là số");
            return false;
        }

        try {
            Integer.parseInt(txtSoLuong.getText());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Số lượng phải là số");
            return false;
        }

        if (Double.parseDouble(txtGia.getText()) < 0 || Double.parseDouble(txtGia.getText()) < 10000.0) {
            JOptionPane.showMessageDialog(null, "Giá không được bé hơn 0 và 10000");
            return false;
        }

        if (Integer.parseInt(txtSoLuong.getText()) < 0) {
            JOptionPane.showMessageDialog(null, "Số lượng không bé hơn 0");
            return false;
        }

        if (txtGia.getText().length() > 1000000) {
            JOptionPane.showMessageDialog(null, "Giá không được vượt quá 1000000");
            return false;
        }

        if (txtSoLuong.getText().length() > 200) {
            JOptionPane.showMessageDialog(null, "Số lượng không được vượt quá 200");
            return false;
        }

        if (Double.parseDouble(txtGia.getText()) == 0) {
            JOptionPane.showMessageDialog(null, "Giá không được là 0");
            return false;
        }

        if (Integer.parseInt(txtSoLuong.getText()) == 0) {
            JOptionPane.showMessageDialog(null, "Số lượng không là 0");
            return false;
        }
        return true;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelSeth4 = new swing.component.PanelSeth();
        jLabel2 = new javax.swing.JLabel();
        spTable = new javax.swing.JScrollPane();
        tblBang = new swing.swing.Table();
        jLabel1 = new javax.swing.JLabel();
        txtTenDichVu = new swing.controls.TextField();
        jLabel3 = new javax.swing.JLabel();
        txtGia = new swing.controls.TextField();
        jLabel4 = new javax.swing.JLabel();
        txtDVT = new swing.controls.TextField();
        jLabel8 = new javax.swing.JLabel();
        panelButton = new swing.swing.PanelBorder();
        btnThem = new swing.controls.Button();
        btnSua = new swing.controls.Button();
        btnXoa = new swing.controls.Button();
        txtSoLuong = new swing.controls.TextField();

        panelSeth4.setColor1(new java.awt.Color(28, 181, 224));
        panelSeth4.setColor2(new java.awt.Color(0, 0, 70));

        jLabel2.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/sv.png"))); // NOI18N
        jLabel2.setText(" Quản Lý Dịch Vụ");

        spTable.setBorder(null);

        tblBang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Tên DV", "Đơn Vị Tính", "Số Lượng", "Giá"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblBang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblBangMouseClicked(evt);
            }
        });
        spTable.setViewportView(tblBang);

        jLabel1.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Tên Dịch Vụ");

        txtTenDichVu.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        txtTenDichVu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTenDichVuActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Đ VT");

        txtGia.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N

        jLabel4.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Giá");

        txtDVT.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N

        jLabel8.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Số Lượng");

        btnThem.setForeground(new java.awt.Color(102, 102, 102));
        btnThem.setText("Thêm");
        btnThem.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        btnSua.setForeground(new java.awt.Color(102, 102, 102));
        btnSua.setText("Sửa");
        btnSua.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });

        btnXoa.setForeground(new java.awt.Color(102, 102, 102));
        btnXoa.setText("Xóa");
        btnXoa.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelButtonLayout = new javax.swing.GroupLayout(panelButton);
        panelButton.setLayout(panelButtonLayout);
        panelButtonLayout.setHorizontalGroup(
            panelButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelButtonLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(panelButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSua, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(18, Short.MAX_VALUE))
        );
        panelButtonLayout.setVerticalGroup(
            panelButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelButtonLayout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(btnSua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(40, Short.MAX_VALUE))
        );

        txtSoLuong.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N

        javax.swing.GroupLayout panelSeth4Layout = new javax.swing.GroupLayout(panelSeth4);
        panelSeth4.setLayout(panelSeth4Layout);
        panelSeth4Layout.setHorizontalGroup(
            panelSeth4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelSeth4Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(panelSeth4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(spTable)
                    .addGroup(panelSeth4Layout.createSequentialGroup()
                        .addGroup(panelSeth4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelSeth4Layout.createSequentialGroup()
                                .addGroup(panelSeth4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel1))
                                .addGap(31, 31, 31)
                                .addGroup(panelSeth4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtDVT, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtTenDichVu, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(130, 130, 130)
                                .addGroup(panelSeth4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel8))
                                .addGap(18, 18, 18)
                                .addGroup(panelSeth4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtGia, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(panelSeth4Layout.createSequentialGroup()
                                .addGap(314, 314, 314)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 93, Short.MAX_VALUE)
                        .addComponent(panelButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(62, 62, 62))
        );
        panelSeth4Layout.setVerticalGroup(
            panelSeth4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelSeth4Layout.createSequentialGroup()
                .addGroup(panelSeth4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelSeth4Layout.createSequentialGroup()
                        .addGap(87, 87, 87)
                        .addGroup(panelSeth4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtTenDichVu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtGia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(21, 21, 21)
                        .addGroup(panelSeth4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtDVT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(panelSeth4Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(panelButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelSeth4Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                .addComponent(spTable, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelSeth4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelSeth4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        try {
            if (checkText()) {
                QLDichVu qldv = new QLDichVu();
                qldv.setTenDV(txtTenDichVu.getText());
                qldv.setDvt(txtDVT.getText());
                qldv.setGiaTien(Double.parseDouble(txtGia.getText()));
                qldv.setSoLuong(Integer.parseInt(txtSoLuong.getText()));
                service.themDichVu(qldv);
                fillToTable(service.getListDichVu());
                clean();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_btnThemActionPerformed

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        try {
            if (service.getListDichVu().size() == 0) {
                JOptionPane.showMessageDialog(null, "Danh sách đã trống");
                return;
            }
            if (click == 1) {
                if (checkText()) {
                    QLDichVu qldv = service.getListDichVu().get(Index);
                    qldv.setTenDV(txtTenDichVu.getText());
                    qldv.setDvt(txtDVT.getText());
                    qldv.setGiaTien(Double.parseDouble(txtGia.getText()));
                    qldv.setSoLuong(Integer.parseInt(txtSoLuong.getText()));
                    service.suaDichVu(qldv);
                    fillToTable(service.getListDichVu());
                    showIndex();
                    click = 0;
                    clean();
                }
            } else {
                JOptionPane.showMessageDialog(null, "Vui lòng lick vào vị trí sản phẩm trên bảng để sửa đổi thông tin");
                return;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_btnSuaActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        try {
            if (service.getListDichVu().size() == 0) {
                JOptionPane.showMessageDialog(null, "Danh sách đã trống");
                return;
            }
            if (click == 1) {
                QLDichVu qldv = service.getListDichVu().get(Index);
                service.xoaDichVu(qldv);
                fillToTable(service.getListDichVu());
                click = 0;
                if (service.getListDichVu().size() == 0) {
                    clean();
                }
                clean();
            } else {
                JOptionPane.showMessageDialog(null, "Vui lòng lick vào vị trí sản phẩm trên bảng để xóa thông tin");
                return;
            }
        } catch (Exception e) {
            return;
        }

    }//GEN-LAST:event_btnXoaActionPerformed

    private void tblBangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblBangMouseClicked
        Index = tblBang.getSelectedRow();
        showIndex();
        click = 1;
    }//GEN-LAST:event_tblBangMouseClicked

    private void txtTenDichVuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTenDichVuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTenDichVuActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private swing.controls.Button btnSua;
    private swing.controls.Button btnThem;
    private swing.controls.Button btnXoa;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel8;
    private swing.swing.PanelBorder panelButton;
    private swing.component.PanelSeth panelSeth4;
    private javax.swing.JScrollPane spTable;
    private swing.swing.Table tblBang;
    private swing.controls.TextField txtDVT;
    private swing.controls.TextField txtGia;
    private swing.controls.TextField txtSoLuong;
    private swing.controls.TextField txtTenDichVu;
    // End of variables declaration//GEN-END:variables

    private void fillToTable(ArrayList<QLDichVu> listDichVu) {
        model = (DefaultTableModel) tblBang.getModel();
        model.setRowCount(0);
        for (QLDichVu qLDichVu : listDichVu) {
            model.addRow(new Object[]{
                qLDichVu.getTenDV(), qLDichVu.getDvt(), qLDichVu.getSoLuong(), qLDichVu.getGiaTien()
            });
        }
    }

    private void showIndex() {
        try {
            QLDichVu qldv = service.getListDichVu().get(Index);
            txtTenDichVu.setText(qldv.getTenDV());
            txtDVT.setText(qldv.getDvt());
            txtGia.setText(qldv.getGiaTien() + "");
            txtSoLuong.setText(qldv.getSoLuong() + "");
        } catch (Exception e) {
            return;
        }
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import java.util.*;
import java.sql.*;
import domainModel.DichVu;
import dbConnection.DbConnection;
import javax.swing.JOptionPane;

public class RPDichVu {
    
    private Connection con = DbConnection.getConnection();
    private PreparedStatement pre;
    private String sql;
    
    public ArrayList<DichVu> getList() {
        ArrayList<DichVu> list = new ArrayList<>();
        try {
            sql = "Select * from DichVu";
            pre = con.prepareStatement(sql);
            ResultSet re = pre.executeQuery();
            while (re.next()) {
                DichVu dv = new DichVu();
                dv.setId(re.getString("ID"));
                dv.setTenDV(re.getString("Ten_Dv"));
                dv.setDvt(re.getString("DVT"));
                dv.setGiaTien(re.getDouble("Gia_Tien"));
                dv.setSoLuong(re.getInt("So_Luong"));
                list.add(dv);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    
    public void themDichVu(DichVu dv) {
        ArrayList<DichVu> list = new ArrayList<>();
        try {
            if (kiemTraTenDichVu(dv.getTenDV())) {
                sql = "INSERT INTO DichVu(Ten_Dv,DVT,Gia_Tien,So_Luong)\n"
                        + "VALUES(?,?,?,?)";
                pre = con.prepareStatement(sql);
                pre.setObject(1, dv.getTenDV());
                pre.setObject(2, dv.getDvt());
                pre.setObject(3, dv.getGiaTien());
                pre.setObject(4, dv.getSoLuong());
                int i = pre.executeUpdate();
                if (i > 0) {
                    JOptionPane.showMessageDialog(null, "Thêm dịch vụ thành công");
                } else {
                    JOptionPane.showMessageDialog(null, "Thêm dịch vụ không thành công");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Đã có tên dịch vụ rồi");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void suaDichVu(DichVu dv) {
        ArrayList<DichVu> list = new ArrayList<>();
        try {
            for (DichVu dichVu : getList()) {
                if (dichVu.getTenDV().equalsIgnoreCase(dv.getTenDV())) {
                    sql = "Update DichVu\n"
                            + "set Ten_Dv = ? , DVT = ?, Gia_Tien = ? , So_Luong = ?\n"
                            + " WHERE ID = ?";
                    pre = con.prepareStatement(sql);
                    pre.setObject(1, dv.getTenDV());
                    pre.setObject(2, dv.getDvt());
                    pre.setObject(3, dv.getGiaTien());
                    pre.setObject(4, dv.getSoLuong());
                    pre.setObject(5, dv.getId());
                    int n = pre.executeUpdate();
                    if (n > 0) {
                        JOptionPane.showMessageDialog(null, "Sửa dịch vụ thành công");
                        return;
                    } else {
                        JOptionPane.showMessageDialog(null, "Sửa dịch vụ không thành công");
                    }
                }
            }
            JOptionPane.showMessageDialog(null, "Tên sản phẩm không có trong danh sách vui lòng diền đúng");
            return;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void xoaDichVu(DichVu dv) {
        try {
            sql = "Delete DichVu where ID = ?";
            pre = con.prepareStatement(sql);
            pre.setObject(1, dv.getId());
            int i = pre.executeUpdate();
            if (i > 0) {
                JOptionPane.showMessageDialog(null, "Xóa dịch vụ thành công");
            } else {
                JOptionPane.showMessageDialog(null, "Xóa dịch vụ không thành công");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public boolean kiemTraTenDichVu(String tenDV) {
        sql = "Select * from DichVu where Ten_Dv = ?";
        try {
            pre = con.prepareStatement(sql);
            pre.setObject(1, tenDV);
            ResultSet re = pre.executeQuery();
            while (re.next()) {
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }
}

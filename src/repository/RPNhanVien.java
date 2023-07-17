/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import dbConnection.DbConnection;
import domainModel.NhanVien;
import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author chung
 */
public class RPNhanVien {

    DbConnection dbConnection;

    public ArrayList<NhanVien> getListNV() {
        String sql = "select * from NhanVien";
        ArrayList<NhanVien> lstNV = new ArrayList<>();
        try {
            Connection con = dbConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                NhanVien nv = new NhanVien();
                nv.setId(rs.getString("Id"));
                nv.setMa(rs.getString("Ma"));
                nv.setMaCv(rs.getString("Ma_CV"));
                nv.setHoTen(rs.getString("Ten"));
                nv.setSdt(rs.getString("SDT"));
                nv.setEmail(rs.getString("Email"));
                nv.setGioiTinh(rs.getString("GioiTinh"));
                nv.setDiaChi(rs.getString("Diachi"));
                nv.setCmt(rs.getString("CMT"));
                nv.setNgaySinh(rs.getDate("NgaySinh"));
                lstNV.add(nv);
            }
            return lstNV;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean insertNV(NhanVien nv) {
        String sql = "insert into NhanVien(Ma,Ma_CV,Ten,SDT,Email,GioiTinh,Diachi,CMT,NgaySinh) values(?,?,?,?,?,?,?,?,?)";
        try {
            Connection con = dbConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setObject(1, nv.getMa());
            ps.setObject(2, nv.getMaCv());
            ps.setObject(3, nv.getHoTen());
            ps.setObject(4, nv.getSdt());
            ps.setObject(5, nv.getEmail());
            ps.setObject(6, nv.getGioiTinh());
            ps.setObject(7, nv.getDiaChi());
            ps.setObject(8, nv.getCmt());
            ps.setObject(9, nv.getNgaySinh());
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean updateNV(String id, NhanVien nv) {
        String sql = "update NhanVien Ma_CV=?,Ten=?,SDT=?,Email=?,GioiTinh=?,Diachi=?,CMT=?,NgaySinh=? where Ma = ?";
        try {
            Connection con = dbConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setObject(1, nv.getMaCv());
            ps.setObject(2, nv.getHoTen());
            ps.setObject(3, nv.getSdt());
            ps.setObject(4, nv.getEmail());
            ps.setObject(5, nv.getGioiTinh());
            ps.setObject(6, nv.getDiaChi());
            ps.setObject(7, nv.getCmt());
            ps.setObject(8, nv.getNgaySinh());
            ps.setObject(9, id);
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean deleteNV(String id) {
        String sql = "DELETE FROM NhanVien WHERE ma = ?";
        try {
            Connection con = dbConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setObject(1, id);
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
//    public boolean getIdCv()
}

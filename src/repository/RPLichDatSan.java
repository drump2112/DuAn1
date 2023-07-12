/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import dbConnection.DbConnection;
import domainModel.KhachHang;
import domainModel.LichDatSanCT;
import domainModel.LichDatSanBong;
import java.util.ArrayList;
import java.util.List;
import java.sql.*;

/**
 *
 * @author sethk
 */
public class RPLichDatSan {

    RPKhachHang repoKH = new RPKhachHang();

    public List<LichDatSanCT> getList() {
        ArrayList<LichDatSanCT> lst = new ArrayList<>();
        String sql = "SELECT a.ma AS madS, b.ten AS tenSan ,b.LoaiSan AS loaiSan ,c.Ten AS tenKH,"
                + " c.SDT,a.GioKetThuc,a.GioBatDau,a.NgayDat, a.TrangThai FROM "
                + " dbo.LichDat_SanBong a LEFT JOIN dbo.SanBong b ON b.ID = a.ID_SB "
                + "left JOIN dbo.KhachHang c ON c.ID = a.ID_KH";
        try (Connection con = DbConnection.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                LichDatSanCT lsd = new LichDatSanCT();
                lsd.setMaDS(rs.getString("madS"));
                lsd.setTenSan(rs.getString("tenSan"));
                lsd.setLoai(rs.getInt("loaiSan"));
                lsd.setTenKh(rs.getString("tenKH"));
                lsd.setGioBD(rs.getTime("GioBatDau"));
                lsd.setGioKT(rs.getTime("GioBatDau"));
                lsd.setNgay(rs.getDate("NgayDat"));
                lsd.setTrangThai(rs.getInt("trangThai"));

                lst.add(lsd);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return lst;
    }

    public String selectIDKH(String sdt) {
        String sql = "SELECT ID FROM dbo.KhachHang WHERE sdt = ?";
        String id = null;
        try (Connection con = DbConnection.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setObject(1, sdt);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                id = rs.getString("ID");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return id;
    }

    public boolean addLichDatSan(LichDatSanBong lds, KhachHang kh) {
        repoKH.addKhachHang(kh);

        String sql = "INSERT INTO LichDat_SanBong(Ma,ID_SB,ID_NV,ID_KH,GioBatDau, "
                + " GioKetThuc,TienDatCoc,TrangThai,NgayDat) VALUES(?,?,?,?,?,?,?,?,?)";
        try (Connection con = DbConnection.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setObject(1, lds.getMaDatSan());
            ps.setObject(2, lds.getIdSb());
            ps.setObject(3, selectIDKH(kh.getSDT()));
            ps.setObject(4, lds.getGioBD());
            ps.setObject(5, lds.getGioKT());
            ps.setObject(6, lds.getTienCoc());
            ps.setObject(7, 2);
            ps.setObject(8, lds.getNgayDat());

            int result = ps.executeUpdate();

            return result > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean nhanSan(String id) {
        String sql = "UPDATE dbo.LichDat_SanBong Set trangthai = 2 WHERE Ma = ? ";
        try (Connection con = DbConnection.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setObject(1, id);
            int result = ps.executeUpdate();
            return result > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean huySan(String id) {
        String sql = "DELETE FROM dbo.LichDat_SanBong WHERE Ma = ? ";
        try (Connection con = DbConnection.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setObject(1, id);
            int result = ps.executeUpdate();
            return result > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

}

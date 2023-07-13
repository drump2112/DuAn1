/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import dbConnection.DbConnection;
import domainModel.SanBong;
import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author Quan Lew
 */
public class RPSanBong {
    DbConnection dbConnection;
    public ArrayList<SanBong> getListSB(){
        String sql = "select * from sanbong";
        ArrayList<SanBong> lstSB = new ArrayList<>();
        try(Connection con = dbConnection.getConnection();
                PreparedStatement ps = con.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {                
                SanBong sb = new SanBong();
                sb.setMa(rs.getString("ma"));
                sb.setTenSan(rs.getString("ten"));
                sb.setGia(rs.getDouble("gia"));
                sb.setGia2(rs.getDouble("gia2"));
                sb.setLoaiSan(rs.getInt("loaisan"));
                sb.setTrangThai(rs.getInt("trangthai"));
                lstSB.add(sb);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return lstSB;
    }
    
    public boolean addSB(SanBong sb){
        String sql = "insert into SanBong(ten,loaisan,gia,gia2) values(?,?,?,?)";
        try (Connection con = dbConnection.getConnection();
                PreparedStatement ps= con.prepareStatement(sql)){
            ps.setObject(1, sb.getTenSan());
            ps.setObject(2, sb.getLoaiSan());
            ps.setObject(3, sb.getGia());
            ps.setObject(4, sb.getGia2());
            int rs = ps.executeUpdate();
            return rs >0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}

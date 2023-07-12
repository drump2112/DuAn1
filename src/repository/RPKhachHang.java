/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import dbConnection.DbConnection;
import domainModel.KhachHang;
import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 *
 * @author sethk
 */
public class RPKhachHang {
 private DbConnection db;
    public boolean addKhachHang(KhachHang kh) {
        String sql = "INSERT INTO dbo.KhachHang(Ma,Ten,SDT)VALUES(?,?,?)";

        try (Connection con = DbConnection.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setObject(1, kh.getMa());
            ps.setObject(2, kh.getTen());
            ps.setObject(3, kh.getSDT());
            int result = ps.executeUpdate();

            return result > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
//test commit
    
    
}

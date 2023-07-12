/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import dbConnection.DbConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author sethk
 */

public class RPTaiKhoan {

    public String dangNhap(String user, String pass) {
        Connection c = DbConnection.getConnection();
        String maCv;
        String sql = " SELECT ma FROM dbo.TaiKhoan WHERE tenDangNhap COLLATE SQL_Latin1_General_Cp850_CS_AS LIKE  ? COLLATE SQL_Latin1_General_Cp850_CS_AS AND matKhau COLLATE SQL_Latin1_General_Cp850_CS_AS LIKE ? COLLATE SQL_Latin1_General_Cp850_CS_AS";
        try {
            PreparedStatement pts = c.prepareStatement(sql);
            pts.setString(1, user);
            pts.setString(2, pass);
            ResultSet rs = pts.executeQuery();
            if (rs.next()) {
                maCv = rs.getString("ma");
                return maCv;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}

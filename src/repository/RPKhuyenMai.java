/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import java.sql.*;
import dbConnection.DbConnection;
import domainModel.KhuyenMai;
import java.util.ArrayList;

/**
 *
 * @author toi84
 */
public class RPKhuyenMai {

    Connection con = DbConnection.getConnection();

    public ArrayList<KhuyenMai> getListKM() {
        String sql = "";
        ArrayList<KhuyenMai> list = new ArrayList<>();
        try {
            PreparedStatement pre = con.prepareStatement(sql);
            ResultSet re = pre.executeQuery();
            while (re.next()) {
                KhuyenMai km = new KhuyenMai();
                km.setMa(re.getString("Ma"));
                km.setTenKm(re.getString("TenKM"));
                km.setGiaKm(re.getDouble("GiaKM"));
                list.add(km);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}

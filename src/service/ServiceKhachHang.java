/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import domainModel.KhachHang;
import java.util.ArrayList;
import repository.RPKhachHang;

/**
 *
 * @author sethk
 */
public class ServiceKhachHang {

    RPKhachHang repo = new RPKhachHang();

    public String addKhachHang(KhachHang kh) {
        if (repo.addKhachHang(kh)) {
            return "Thêm Khách hàng Thành Công";
        }
        return "them khong thanh cong";
    }

    public ArrayList<KhachHang> getAllKH() {
        return repo.getListKH();
    }

    public String insertKH(KhachHang kh) {
        if (repo.insertKH(kh)) {
            return "thêm khách hàng thành công";
        }
        return "thêm khách hàng thất bại";
    }

    public String updateKH(String id, KhachHang kh) {
        if (repo.updateKH(id, kh)) {
            return "thêm khách hàng thành công";
        }
        return "thêm khách hàng thất bại";
    }

    public String delteteKH(String id) {
        if (repo.deleteKH(id)) {
            return "thêm khách hàng thành công";
        }
        return "thêm khách hàng thất bại";
    }
}

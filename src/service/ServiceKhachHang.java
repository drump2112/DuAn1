/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import domainModel.KhachHang;
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
}

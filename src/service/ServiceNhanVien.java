/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import domainModel.NhanVien;
import java.util.ArrayList;
import repository.RPNhanVien;

/**
 *
 * @author chung
 */
public class ServiceNhanVien {

    RPNhanVien repo = new RPNhanVien();

    public ArrayList<NhanVien> getAllNV() {
        return repo.getListNV();
    }

    public String insertNV(NhanVien nv) {
        if (repo.insertNV(nv)) {
            return "thêm nhân viên thành công";
        }
        return "thêm nhân viên thất bại";
    }

    public String updateNV(String id, NhanVien nv) {
        if (repo.updateNV(id, nv)) {
            return "thêm nhân viên thành công";
        }
        return "thêm nhân viên thất bại";
    }

    public String delteteNV(String id) {
        if (repo.deleteNV(id)) {
            return "thêm nhân viên thành công";
        }
        return "thêm nhân viên thất bại";
    }
}

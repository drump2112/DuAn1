/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import ViewModel.QLNhanVien;
import domainModel.NhanVien;
import java.util.ArrayList;
import repository.RPNhanVien;

/**
 *
 * @author chung
 */
public class NV_impl implements InterfaceNV {

    RPNhanVien repo = new RPNhanVien();

    @Override
    public ArrayList<QLNhanVien> getAllNV() {
        ArrayList<QLNhanVien> lstQLNV = new ArrayList<>();
        ArrayList<NhanVien> lstNV = new ArrayList<>();
        for (NhanVien nv : lstNV) {
            QLNhanVien qlnv = new QLNhanVien(
                    nv.getId(),
                    nv.getMa(),
                    nv.getHoTen(), nv.getEmail(),
                    nv.getSdt(), nv.getMaCv(),
                    nv.getDiaChi(), nv.getCmt(),
                    nv.getNgaySinh(), nv.getGioiTinh());
            lstQLNV.add(qlnv);
        }
        return lstQLNV;
    }

    @Override
    public String addNew(QLNhanVien QLNV) {
        NhanVien nv = new NhanVien(QLNV.getMa(),
                QLNV.getHoTen(),
                QLNV.getEmail(),
                QLNV.getSdt(),
                QLNV.getMaCv(),
                QLNV.getDiaChi(),
                QLNV.getCmt(),
                QLNV.getNgaySinh(),
                QLNV.getGioiTinh());
        if (repo.insertNV(nv)) {
            return "Success";
        } else {
            return "failed";
        }
    }

    @Override
    public String updateNV(String id, QLNhanVien QLNV) {
        NhanVien nv = new NhanVien(
                QLNV.getHoTen(),
                QLNV.getEmail(),
                QLNV.getSdt(),
                QLNV.getMaCv(),
                QLNV.getDiaChi(),
                QLNV.getCmt(),
                QLNV.getNgaySinh(),
                QLNV.getGioiTinh());
        if (repo.updateNV(id, nv)) {
            return "Success";
        } else {
            return "failed";
        }
    }

    @Override
    public String deleteNV(String id) {
        if (repo.deleteNV(id)) {
            return "Success";
        } else {
            return "failed";
        }
    }

}

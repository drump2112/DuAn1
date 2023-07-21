/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import ViewModel.QLKhachHang;
import domainModel.KhachHang;
import java.util.ArrayList;
import repository.RPKhachHang;

/**
 *
 * @author sethk
 */
public class KH_impl implements InterfaceKH {

    private RPKhachHang repo = new RPKhachHang();

    @Override
    public ArrayList<QLKhachHang> getAllKH() {
        ArrayList<QLKhachHang> lstQLKH = new ArrayList<>();
        ArrayList<KhachHang> lstkh = repo.getListKH();
        for (KhachHang kh : lstkh) {
            QLKhachHang qlkh = new QLKhachHang(kh.getId(), kh.getMa(), kh.getTen(), kh.getSDT());
            lstQLKH.add(qlkh);
        }
        return lstQLKH;
    }

    @Override
    public String addNew(QLKhachHang QLkH) {
        KhachHang kh = new KhachHang(QLkH.getMa(), QLkH.getTen(), QLkH.getSDT());
        if (repo.addKhachHang(kh)) {
            return "Success";
        } else {
            return "failed";
        }
    }

    @Override
    public String updateKH(String id, QLKhachHang QLkH) {
         KhachHang kh = new KhachHang(QLkH.getMa(), QLkH.getTen(), QLkH.getSDT());
        if (repo.updateKH(id, kh)) {
            return "Success";
        } else {
            return "failed";
        }
    }

    @Override
    public String deleteKH(String id) {
        if (repo.deleteKH(id)) {
            return "Success";
        } else {
            return "failed";
        }
    }

}

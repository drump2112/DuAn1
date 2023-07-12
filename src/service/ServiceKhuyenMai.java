/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import ViewModel.QLKhuyenMai;
import domainModel.KhuyenMai;
import java.util.ArrayList;
import repository.RPKhuyenMai;

/**
 *
 * @author toi84
 */
public class ServiceKhuyenMai implements InterfaceKhuyenMai {

    private RPKhuyenMai repo = new RPKhuyenMai();

    @Override
    public ArrayList<QLKhuyenMai> getListKM() {
        ArrayList<QLKhuyenMai> list = new ArrayList<>();
        for (KhuyenMai KM : repo.getListKM()) {
            QLKhuyenMai qLKhuyenMai = new QLKhuyenMai(KM.getMa(), KM.getTenKm(), KM.getGiaKm());
            list.add(qLKhuyenMai);
        }
        return list;
    }

}

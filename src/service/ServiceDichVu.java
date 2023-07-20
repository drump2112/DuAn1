/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import ViewModel.QLDichVu;
import domainModel.DichVu;
import java.util.ArrayList;
import repository.RPDichVu;
import domainModel.DichVu;

/**
 *
 * @author toi84
 */
public class ServiceDichVu implements InterfaceDichVu {

    private RPDichVu repo = new RPDichVu();

    @Override
    public ArrayList<QLDichVu> getListDichVu() {
        ArrayList<QLDichVu> list = new ArrayList<>();
        for (DichVu dv : repo.getList()) {
            QLDichVu qldv = new QLDichVu(dv.getId(), dv.getTenDV(), dv.getDvt(), dv.getGiaTien(), dv.getSoLuong());
            list.add(qldv);
        }
        return list;
    }

    @Override
    public void themDichVu(QLDichVu dv) {
        DichVu dichVu = new DichVu(dv.getId(), dv.getTenDV(), dv.getDvt(), dv.getGiaTien(), dv.getSoLuong());
        repo.themDichVu(dichVu);
    }

    @Override
    public void suaDichVu(QLDichVu dv) {
        DichVu dichVu = new DichVu(dv.getId(), dv.getTenDV(), dv.getDvt(), dv.getGiaTien(), dv.getSoLuong());
        repo.suaDichVu(dichVu);
    }

    @Override
    public void xoaDichVu(QLDichVu dv) {
        DichVu dichVu = new DichVu(dv.getId(), dv.getTenDV(), dv.getDvt(), dv.getGiaTien(), dv.getSoLuong());
        repo.xoaDichVu(dichVu);
    }

}

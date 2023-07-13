/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import ViewModel.QLChucVu;
import domainModel.ChucVu;
import java.util.ArrayList;
import repository.RPChucVu;

/**
 *
 * @author toi84
 */
public class ServiceChucVu implements service.InterfaceChucVu {

    private RPChucVu repo = new RPChucVu();

    @Override
    public ArrayList<QLChucVu> getList() {
        ArrayList<QLChucVu> list = new ArrayList<>();
        for (ChucVu cv : repo.getListCV()) {
            QLChucVu qLChucVu = new QLChucVu(cv.getMa(), cv.getTenChucVu());
            list.add(qLChucVu);
        }
        return list;
    }

}

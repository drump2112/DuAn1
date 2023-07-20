/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package service;

import java.util.*;
import ViewModel.QLDichVu;

/**
 *
 * @author toi84
 */
public interface InterfaceDichVu {

    ArrayList<QLDichVu> getListDichVu();

    void themDichVu(QLDichVu dv);

    void suaDichVu(QLDichVu dv);

    void xoaDichVu(QLDichVu dv);

}

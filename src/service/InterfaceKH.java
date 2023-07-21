/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package service;

import ViewModel.QLKhachHang;
import java.util.ArrayList;

/**
 *
 * @author chung
 */
public interface InterfaceKH {
    public ArrayList<QLKhachHang> getAllKH();

    public String addNew(QLKhachHang QLkH);

    public String updateKH(String id, QLKhachHang QLkH);

    public String deleteKH(String id);
}

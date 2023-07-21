/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package service;

import ViewModel.QLNhanVien;
import java.util.ArrayList;

/**
 *
 * @author chung
 */
public interface InterfaceNV {

    public ArrayList<QLNhanVien> getAllNV();

    public String addNew(QLNhanVien QLNV);

    public String updateNV(String id, QLNhanVien QLNV);

    public String deleteNV(String id);
}

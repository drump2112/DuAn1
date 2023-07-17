/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import domainModel.SanBong;
import java.util.ArrayList;
import repository.RPSanBong;

/**
 *
 * @author Quan Lew
 */
public class ServiceSanBong {

    RPSanBong repo = new RPSanBong();

    public ArrayList<SanBong> getList() {
        return repo.getListSB();

    }
    
    public String addSB(SanBong sb){
        if (repo.addSB(sb)) {
            return "Thêm sân bóng thành công";
        }
        return "Thêm sân bóng thất bại";
    }
    
     public String updateSB(SanBong sb,String id){
        if (repo.updateSB(sb, id)) {
            return "Sửa sân bóng thành công";
        }
        else{
            return "Sửa sân bóng thất bại";
        }

    }
     
     public String deleteSB(String id){
         if (repo.deleteSB(id)) {
             return "Xóa sân bóng thành công";
         }
         return "Xóa sân bóng thất bại";
     }
}

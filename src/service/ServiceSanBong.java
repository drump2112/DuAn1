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
            return "Them san bong thanh cong";
        }
        return "Them san bong that bai";
    }
}

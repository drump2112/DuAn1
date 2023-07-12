/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import repository.RPTaiKhoan;

/**
 *
 * @author sethk
 */
public class ServiceTaiKhoan {

    RPTaiKhoan RP = new RPTaiKhoan();

    public String DangNhap(String user, String pass) {
        return RP.dangNhap(user, pass);
    }
}

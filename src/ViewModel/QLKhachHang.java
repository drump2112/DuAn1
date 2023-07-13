/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ViewModel;

import domainModel.*;

/**
 *
 * @author sethk
 */
public class QLKhachHang {

    private String id;
    private String ma;
    private String ten;
    private String SDT;
    private String email;

    public QLKhachHang() {
    }

    public QLKhachHang(String id, String ma, String ten, String SDT, String email) {
        this.id = id;
        this.ma = ma;
        this.ten = ten;
        this.SDT = SDT;
        this.email = email;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMa() {
        return ma;
    }

    public void setMa(String ma) {
        this.ma = ma;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getSDT() {
        return SDT;
    }

    public void setSDT(String SDT) {
        this.SDT = SDT;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}

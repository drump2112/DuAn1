/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domainModel;

import java.util.Date;

/**
 *
 * @author sethk
 */
public class NhanVien {

    private String id;
    private String ma;
    private String hoTen;
    private String Email;
    private String sdt;
    private String idCV;
    private String diaChi;
    private String cmt;
    private Date ngaySinh;
    private String gioiTinh;

    public NhanVien() {
    }

    public NhanVien(String id, String ma, String hoTen, String Email, String sdt, String idCV, String diaChi, String cmt, Date ngaySinh, String gioiTinh) {
        this.id = id;
        this.ma = ma;
        this.hoTen = hoTen;
        this.Email = Email;
        this.sdt = sdt;
        this.idCV = idCV;
        this.diaChi = diaChi;
        this.cmt = cmt;
        this.ngaySinh = ngaySinh;
        this.gioiTinh = gioiTinh;
    }

}

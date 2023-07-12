/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domainModel;

import java.sql.Time;
import java.util.Date;

/**
 *
 * @author sethk
 */
public class LichDatSanCT {

    private String maDS;
    private String tenSan;
    private Integer loai;
    private String tenKh;
    private String sdt;
    private Time gioBD;
    private Time gioKT;
    private Date ngay;
    private Integer trangThai;

    public LichDatSanCT() {
    }

    public LichDatSanCT(String maDS, String tenSan, Integer loai, String tenKh, String sdt, Time gioBD, Time gioKT, Date ngay, Integer trangThai) {
        this.maDS = maDS;
        this.tenSan = tenSan;
        this.loai = loai;
        this.tenKh = tenKh;
        this.sdt = sdt;
        this.gioBD = gioBD;
        this.gioKT = gioKT;
        this.ngay = ngay;
        this.trangThai = trangThai;
    }

    public String getMaDS() {
        return maDS;
    }

    public void setMaDS(String maDS) {
        this.maDS = maDS;
    }

    public String getTenSan() {
        return tenSan;
    }

    public void setTenSan(String tenSan) {
        this.tenSan = tenSan;
    }

    public Integer getLoai() {
        return loai;
    }

    public void setLoai(Integer loai) {
        this.loai = loai;
    }

    public String getTenKh() {
        return tenKh;
    }

    public void setTenKh(String tenKh) {
        this.tenKh = tenKh;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public Time getGioBD() {
        return gioBD;
    }

    public void setGioBD(Time gioBD) {
        this.gioBD = gioBD;
    }

    public Time getGioKT() {
        return gioKT;
    }

    public void setGioKT(Time gioKT) {
        this.gioKT = gioKT;
    }

    public Date getNgay() {
        return ngay;
    }

    public void setNgay(Date ngay) {
        this.ngay = ngay;
    }

    public Integer getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(Integer trangThai) {
        this.trangThai = trangThai;
    }

}

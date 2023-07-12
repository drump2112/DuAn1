/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package viewModel;

import java.sql.Time;
import java.util.Date;

/**
 *
 * @author Quan Lew
 */
public class QLLichDatSanBong {
    
    private String id;
    private String maDatSan;
    private String idSb;
    private String idNv;
    private String idKh;
    private Double tienCoc;
    private Time gioBD;
    private Time gioKT;
    private Date ngayDat;

    public QLLichDatSanBong() {
    }

    public QLLichDatSanBong(String id, String maDatSan, String idSb, String idNv, String idKh, Double tienCoc, Time gioBD, Time gioKT, Date ngayDat) {
        this.id = id;
        this.maDatSan = maDatSan;
        this.idSb = idSb;
        this.idNv = idNv;
        this.idKh = idKh;
        this.tienCoc = tienCoc;
        this.gioBD = gioBD;
        this.gioKT = gioKT;
        this.ngayDat = ngayDat;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMaDatSan() {
        return maDatSan;
    }

    public void setMaDatSan(String maDatSan) {
        this.maDatSan = maDatSan;
    }

    public String getIdSb() {
        return idSb;
    }

    public void setIdSb(String idSb) {
        this.idSb = idSb;
    }

    public String getIdNv() {
        return idNv;
    }

    public void setIdNv(String idNv) {
        this.idNv = idNv;
    }

    public String getIdKh() {
        return idKh;
    }

    public void setIdKh(String idKh) {
        this.idKh = idKh;
    }

    public Double getTienCoc() {
        return tienCoc;
    }

    public void setTienCoc(Double tienCoc) {
        this.tienCoc = tienCoc;
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

    public Date getNgayDat() {
        return ngayDat;
    }

    public void setNgayDat(Date ngayDat) {
        this.ngayDat = ngayDat;
    }

    @Override
    public String toString() {
        return "VmLichDatSanBong{" + "id=" + id + ", maDatSan=" + maDatSan + ", idSb=" + idSb + ", idNv=" + idNv + ", idKh=" + idKh + ", tienCoc=" + tienCoc + ", gioBD=" + gioBD + ", gioKT=" + gioKT + ", ngayDat=" + ngayDat + '}';
    }
    
    
}

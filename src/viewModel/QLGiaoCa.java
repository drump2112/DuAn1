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
public class QLGiaoCa {
        private String id;
    private String ma;
    private String nguoiGiao;
    private String nguoiNhan;
    private Time gioiVao;
    private Time gioRa;
    private Double tienTrongCa;
    private Date NgayTruc;

    public QLGiaoCa() {
    }

    public QLGiaoCa(String id, String ma, String nguoiGiao, String nguoiNhan, Time gioiVao, Time gioRa, Double tienTrongCa, Date NgayTruc) {
        this.id = id;
        this.ma = ma;
        this.nguoiGiao = nguoiGiao;
        this.nguoiNhan = nguoiNhan;
        this.gioiVao = gioiVao;
        this.gioRa = gioRa;
        this.tienTrongCa = tienTrongCa;
        this.NgayTruc = NgayTruc;
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

    public String getNguoiGiao() {
        return nguoiGiao;
    }

    public void setNguoiGiao(String nguoiGiao) {
        this.nguoiGiao = nguoiGiao;
    }

    public String getNguoiNhan() {
        return nguoiNhan;
    }

    public void setNguoiNhan(String nguoiNhan) {
        this.nguoiNhan = nguoiNhan;
    }

    public Time getGioiVao() {
        return gioiVao;
    }

    public void setGioiVao(Time gioiVao) {
        this.gioiVao = gioiVao;
    }

    public Time getGioRa() {
        return gioRa;
    }

    public void setGioRa(Time gioRa) {
        this.gioRa = gioRa;
    }

    public Double getTienTrongCa() {
        return tienTrongCa;
    }

    public void setTienTrongCa(Double tienTrongCa) {
        this.tienTrongCa = tienTrongCa;
    }

    public Date getNgayTruc() {
        return NgayTruc;
    }

    public void setNgayTruc(Date NgayTruc) {
        this.NgayTruc = NgayTruc;
    }

    @Override
    public String toString() {
        return "VmGiaoCa{" + "id=" + id + ", ma=" + ma + ", nguoiGiao=" + nguoiGiao + ", nguoiNhan=" + nguoiNhan + ", gioiVao=" + gioiVao + ", gioRa=" + gioRa + ", tienTrongCa=" + tienTrongCa + ", NgayTruc=" + NgayTruc + '}';
    }
    
    
}

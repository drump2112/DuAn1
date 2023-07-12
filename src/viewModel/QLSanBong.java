/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package viewModel;

/**
 *
 * @author Quan Lew
 */
public class QLSanBong {
      private String id;
    private String ma;
    private String tenSan;
    private Double gia;
    private Double gia2;
    private Integer loaiSan;
    private Integer trangThai;

    public QLSanBong() {
    }

    public QLSanBong(String id, String ma, String tenSan, Double gia, Double gia2, Integer loaiSan, Integer trangThai) {
        this.id = id;
        this.ma = ma;
        this.tenSan = tenSan;
        this.gia = gia;
        this.gia2 = gia2;
        this.loaiSan = loaiSan;
        this.trangThai = trangThai;
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

    public String getTenSan() {
        return tenSan;
    }

    public void setTenSan(String tenSan) {
        this.tenSan = tenSan;
    }

    public Double getGia() {
        return gia;
    }

    public void setGia(Double gia) {
        this.gia = gia;
    }

    public Double getGia2() {
        return gia2;
    }

    public void setGia2(Double gia2) {
        this.gia2 = gia2;
    }

    public Integer getLoaiSan() {
        return loaiSan;
    }

    public void setLoaiSan(Integer loaiSan) {
        this.loaiSan = loaiSan;
    }

    public Integer getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(Integer trangThai) {
        this.trangThai = trangThai;
    }

    @Override
    public String toString() {
        return "VmSanBong{" + "id=" + id + ", ma=" + ma + ", tenSan=" + tenSan + ", gia=" + gia + ", gia2=" + gia2 + ", loaiSan=" + loaiSan + ", trangThai=" + trangThai + '}';
    }
    
    
}

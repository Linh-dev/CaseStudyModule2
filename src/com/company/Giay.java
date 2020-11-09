package com.company;

import java.io.Serializable;

public class Giay implements Serializable {
    private String loaiGiay, id, mauSac, ngayNhapVe;
    private int gia, soLuong;

    public Giay(){}

    public Giay(String loaiGiay, String id, String mauSac, String ngayNhapVe, int gia, int soLuong) {
        this.loaiGiay = loaiGiay;
        this.id = id;
        this.mauSac = mauSac;
        this.ngayNhapVe = ngayNhapVe;
        this.gia = gia;
        this.soLuong = soLuong;
    }

    public String getLoaiGiay() {
        return loaiGiay;
    }

    public void setLoaiGiay(String loaiGiay) {
        this.loaiGiay = loaiGiay;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMauSac() {
        return mauSac;
    }

    public void setMauSac(String mauSac) {
        this.mauSac = mauSac;
    }

    public String getNgayNhapVe() {
        return ngayNhapVe;
    }

    public void setNgayNhapVe(String ngayNhapVe) {
        this.ngayNhapVe = ngayNhapVe;
    }

    public int getGia() {
        return gia;
    }

    public void setGia(int gia) {
        this.gia = gia;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    @Override
    public String toString() {
        return
                "Loại giày:'" + loaiGiay + '\'' +
                ", Mã:'" + id + '\'' +
                ", Màu Sắc:'" + mauSac + '\'' +
                ", Ngày nhập về:'" + ngayNhapVe + '\'' +
                ", Giá:" + gia +
                ", Số lượng:" + soLuong +
                '}';
    }
}

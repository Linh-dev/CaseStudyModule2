package com.company;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

public class HoaDon implements Serializable {
    private String loaiHoaDon;
    private String id;
    private String ngayLap;
    //Map bao gom key: ten cua giay(id), value: so luong
    private HashMap<String, Giay> danhSachGiay = new HashMap<>();

    public HoaDon(){}

    public HoaDon(String loaiHoaDon, String id, String ngayLap, HashMap<String, Giay> danhSachGiay) {
        this.loaiHoaDon = loaiHoaDon;
        this.id = id;
        this.ngayLap = ngayLap;
        this.danhSachGiay = danhSachGiay;
    }
    public String getNgayLap() {
        return ngayLap;
    }
    public void setNgayLap(String ngayLap) {
        this.ngayLap = ngayLap;
    }

    public String getLoaiHoaDon() {
        return loaiHoaDon;
    }
    public void setLoaiHoaDon(String loaiHoaDon) {
        this.loaiHoaDon = loaiHoaDon;
    }

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }

    public HashMap<String, Giay> getDanhSachGiay() {
        return danhSachGiay;
    }
    public void setDanhSachGiay(HashMap<String, Giay> danhSachGiay) {
        this.danhSachGiay = danhSachGiay;
    }

    @Override
    public String toString() {
        Set<String> keyID = danhSachGiay.keySet();
        String content = "";
        int tongtien = 0;
        for (String id : keyID){
            Giay g = danhSachGiay.get(id);
            content +="loại giày: "+g.getLoaiGiay()+", mã giày: "+ id +", số lương: "+ g.getSoLuong()+"\n";
            tongtien += g.getGia()*g.getSoLuong();
        }

        return "-- Hóa Đơn{" +
                "loại hóa đơn:'" + loaiHoaDon + '\'' +
                ", mã hóa đơn:'" + id + '\'' +
                ", ngày lập:'" + ngayLap + '\'' +
                ", danh sách giày:\n" + content +
                '}'+ "*** Tổng tiền = " + tongtien;
    }
}

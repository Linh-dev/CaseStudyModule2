package com.company;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

public class DanhSachHoaDon {
    ArrayList<HoaDon> danhSachHoaDon = new ArrayList<>();

    public void them(HoaDon hd){
        docHoaDon();
        String loai = hd.getLoaiHoaDon();
        if (loai.equals("N")){
            NhapDB(hd);
        }else {
            XuatDB(hd);
        }
        danhSachHoaDon.add(hd);
        ghiHoaDon();
    }


    public void hienthi(){
        docHoaDon();
        if (danhSachHoaDon.size()>0){
            for (HoaDon hd : danhSachHoaDon){
                System.out.println(hd);
            }
            danhSachHoaDon.clear();
        }else {
            System.out.println("Chưa có hóa đơn được lập");
        }
    }

    // doc file hoa don
    public ArrayList<HoaDon> docHoaDon(){
        danhSachHoaDon.clear();
        danhSachHoaDon = DocGhiFile.docFileDSHoaDon();
        return danhSachHoaDon;
    }

    // ghi file hoa don
    public void ghiHoaDon(){
        DocGhiFile.ghiFileDSHoaDon(danhSachHoaDon);
        danhSachHoaDon.clear();
    }


    //Dong bo Hoa Don Nhap = N
    private void NhapDB(HoaDon hd){
        ArrayList<Giay> dsKho1 = DocGhiFile.docFileDSKho();
        ArrayList<Giay> dsKho2 = new ArrayList<>();

        HashMap<String, Giay> dsGiayTrongHD = hd.getDanhSachGiay();
        Set<String> setID = dsGiayTrongHD.keySet();


        for (String id: setID){
            int count = 0;
            Giay giayTrongHD = dsGiayTrongHD.get(id);
            int slGiayTrongHD = giayTrongHD.getSoLuong();
            for (Giay g : dsKho1){
                if (g.getId().equals(id)){
                    g.setSoLuong(g.getSoLuong()+slGiayTrongHD);
                    count++;
                    break;
                }
            }
            if (count == 0){
                dsKho2.add(giayTrongHD);
            }else {
                count = 0;
            }
        }

        for (Giay g : dsKho2){
            dsKho1.add(g);
        }
        DocGhiFile.ghiFileDSKho(dsKho1);
    }

    //Dong bo Hoa Don Xuat = X
    private void XuatDB(HoaDon hd){
        ArrayList<Giay> dsKho1 = DocGhiFile.docFileDSKho();
        ArrayList<Giay> dsKho2 = new ArrayList<>();
        HashMap<String, Giay> dsGiayTrongHD = hd.getDanhSachGiay();
        Set<String> setID = dsGiayTrongHD.keySet();
        for (String id : setID){
            Giay giayTrongHD = dsGiayTrongHD.get(id);
            int slGiayTrongHD = giayTrongHD.getSoLuong();
            for (int i = 0; i < dsKho1.size(); i++){
                if (dsKho1.get(i).getId().equals(id)){
                    dsKho1.get(i).setSoLuong(dsKho1.get(i).getSoLuong() - slGiayTrongHD);
                    if (dsKho1.get(i).getSoLuong()==0){
                        dsKho2.add(dsKho1.get(i));
                    }
                }
            }
        }
        for (Giay g : dsKho2){
            dsKho1.remove(g);
        }
        DocGhiFile.ghiFileDSKho(dsKho1);
    }
    public void xoaHet(){
        danhSachHoaDon.clear();
        ghiHoaDon();
    }
}

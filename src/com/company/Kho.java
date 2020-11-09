package com.company;


import java.util.ArrayList;
import java.util.Calendar;

public class Kho {
    private ArrayList<Giay> danhSachGiay = new ArrayList<>();

    public void them(Giay g){
        doc();
        danhSachGiay.add(g);
        System.out.println("Thêm sản phẩm vào kho thành công!");
        ghi();
    }

    public void hienThiAll(){
        doc();
        boolean kt = danhSachGiay.isEmpty();
        if (!kt){
            for (Giay g : danhSachGiay){
                System.out.println(g);
            }
            danhSachGiay.clear();
        }else {
            System.out.println("Trong kho không có hàng!");
        }
    }

    public void xoa(String id) {
        doc();
        ArrayList<Giay> arr = timkiem(id);
        if (arr.size()>0) {
            for (Giay g : arr) {
                boolean isKt = g.getId().equals(id);
                if (isKt) {
                    danhSachGiay.remove(g);
                    System.out.println("Đã xóa sản phẩm!");
                }
            }
            ghi();
        }
        danhSachGiay.clear();
    }
    // hien thi theo ten hoac ma san pham
    public void hienThi(String a) {
//        doc();
        ArrayList<Giay> arr = timkiem(a);

        boolean kt = arr.size() == 0;
        if (!kt){
            for (Giay g : arr){
                System.out.println(g);
            }
        }else {
            System.out.println("Không tìm thấy sản phẩm!");
        }
        danhSachGiay.clear();
    }

    // tim kiem - tra ve theo ten(id) hoac danh sach loai giay.
    private ArrayList<Giay> timkiem(String a) {
        ArrayList<Giay> arr = new ArrayList<>();
        doc();
        boolean kt = danhSachGiay.isEmpty();
        if (!kt){
            for (Giay g : danhSachGiay) {
                boolean kt1 = g.getLoaiGiay().equals(a);
                boolean kt2 = g.getId().equals(a);
                if (kt1 || kt2){
                    arr.add(g);
                }
            }
        }return arr;
    }
    public Giay timkiem1(String a) {
        doc();
        boolean kt = danhSachGiay.isEmpty();
        if (!kt){
            for (Giay g : danhSachGiay) {
                boolean kt2 = g.getId().equals(a);
                if (kt2){
                    return g;
                }
            }
        }return null;
    }

    // doc file
    private ArrayList<Giay> doc(){
        danhSachGiay.clear();
        danhSachGiay = DocGhiFile.docFileDSKho();
        return danhSachGiay;
    }
    // ghi file
    private void ghi(){
        DocGhiFile.ghiFileDSKho(danhSachGiay);
        danhSachGiay.clear();
    }
    // kiem tra hang ton kho tren 6 thang
    private ArrayList<Giay> ktHangTonKho(){
        doc();
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.MONTH, -6);// lay thoi gian 6 thang truoc
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH)+1;
        int date = calendar.get(Calendar.DATE);
        ArrayList<Giay> arr = new ArrayList<>();

        for (Giay g : danhSachGiay){
            String time = g.getNgayNhapVe();
            String[] arrGTime = time.split("(\\/|-|\\.)");
            int gYear = Integer.parseInt(arrGTime[2]);
            int gMonth = Integer.parseInt(arrGTime[1]);
            int gDate = Integer.parseInt(arrGTime[0]);
            if (gYear > year){
                continue;
            }else {
                if (gMonth > month){
                    continue;
                }else if (gMonth == month){
                    if (gDate > date){
                        continue;
                    }else {
                        arr.add(g);
                    }
                }else {
                    arr.add(g);
                }
            }
        }
        danhSachGiay.clear();
        return arr;
    }
    // hien thi danh sach hang ton kho
    public void hienThiHangTonKho(){
        ArrayList<Giay> arr = ktHangTonKho();
        if (arr.size()>0){
            System.out.println("Danh sách hàng tồn kho:");
            for (Giay g : arr){
                System.out.println(g);
            }
        }else {
            System.out.println("Không có hàng tồn kho!");
        }
    }

    // kiem tra hang new chua den 20 ngay
    private ArrayList<Giay> ktHangNew(){
        doc();
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE, -20);// lay thoi gian 20 ngay truoc
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH)+1;
        int date = calendar.get(Calendar.DATE);
        ArrayList<Giay> arr = new ArrayList<>();

        for (Giay g : danhSachGiay){
            String time = g.getNgayNhapVe();
            String[] arrGTime = time.split("(\\/|-|\\.)");
            int gYear = Integer.parseInt(arrGTime[2]);
            int gMonth = Integer.parseInt(arrGTime[1]);
            int gDate = Integer.parseInt(arrGTime[0]);
            if (gYear < year){
                continue;
            }else {
                if (gMonth < month){
                    continue;
                }else if (gMonth == month){
                    if (gDate < date){
                        continue;
                    }else {
                        arr.add(g);
                    }
                }else {
                    arr.add(g);
                }
            }
        }
        danhSachGiay.clear();
        return arr;
    }
    // hien thi danh sach hang new
    public void hienThiHangNew(){
        ArrayList<Giay> arr = ktHangNew();
        if (arr.size()>0){
            System.out.println("Danh sách hàng New:");
            for (Giay g : arr){
                System.out.println(g);
            }
        }else {
            System.out.println("Không có hàng New!");
        }
    }

    public void xoaHet(){
        danhSachGiay.clear();
        ghi();
    }
}

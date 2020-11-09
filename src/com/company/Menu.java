package com.company;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Menu {
    Scanner sc = new Scanner(System.in);
    Kho khoTong = new Kho();
    DanhSachHoaDon dsHoaDon = new DanhSachHoaDon();
    // tao moi giay trong hoa don nhap
    public Giay taoMoiGiayNhap(){
        String loaiGiay;
        String id ;
        String mauSac;
        String ngayNhapVe;
        int gia;
        int soLuong;
        boolean checkNhapAll = true;

        do {
            System.out.println("Nhập loại giầy - tên hãng hoặc kiểu giầy");
            loaiGiay = sc.nextLine();
            if (!loaiGiay.equals("")){
                checkNhapAll = false;
            }
        }while (checkNhapAll);
        checkNhapAll = true;

        do {
            System.out.println("Nhập mã của giầy");
            id = sc.nextLine();
            if (!id.equals("")){
                checkNhapAll = false;
            }
        }while (checkNhapAll);
        checkNhapAll = true;

        Giay giayNhap = khoTong.timkiem1(id);
        ArrayList<Giay> nhap_dsKho = DocGhiFile.docFileDSKho();
        boolean checkNhap = false;

        for (Giay gn : nhap_dsKho){
            if (gn.getId().equals(id)){
                checkNhap = true;
                break;
            }
        }
        if (checkNhap){
            mauSac = giayNhap.getMauSac();
            ngayNhapVe = giayNhap.getNgayNhapVe();
            gia = giayNhap.getGia();
        }else {
            do {
                System.out.println("Nhập mầu");
                mauSac = sc.nextLine();
                if (!mauSac.equals("")){
                    checkNhapAll = false;
                }
            }while (checkNhapAll);
            checkNhapAll = true;

            System.out.println("Nhập ngày về");
            ngayNhapVe  = KieuNhapLieu.ngayThang();
            String gia1;
            do {
                System.out.println("Nhập giá");
                gia1 = sc.nextLine();
                if (!gia1.equals("")){
                    checkNhapAll = false;
                }
            }while (checkNhapAll);
            gia=Integer.parseInt(gia1);
            checkNhapAll = true;
        }
        String sl1;
        do {
            System.out.println("Nhập số lượng");
            sl1 = sc.nextLine();
            if (!sl1.equals("")){
                checkNhapAll = false;
            }
        }while (checkNhapAll);
        soLuong = Integer.parseInt(sl1);
        checkNhapAll = true;


        Giay g = new Giay(loaiGiay,id,mauSac,ngayNhapVe,gia,soLuong);
        return g;
    }

    // tao moi giay trong hoa don xuat
    public Giay taoMoiGiayXuat(){

        String loaiGiay;
        String id;
        String mauSac;
        String ngayNhapVe;
        int gia;
        int soLuong;
        boolean checkAll = true;

        ArrayList<Giay> dsKho = DocGhiFile.docFileDSKho();
        ArrayList<String> maGiayDaCo = new ArrayList<>();
        for (Giay g : dsKho){
            maGiayDaCo.add(g.getId());
        }
        do {
            System.out.println("Nhập loại giầy - tên hãng hoặc kiểu giầy");
            loaiGiay = sc.nextLine();
            if (!loaiGiay.equals("")){
                checkAll = false;
            }
        }while (checkAll);
        checkAll = true;


        boolean checkID = true;
        Giay giay = null;
        id = "";
        do {
            System.out.println("Nhập đúng mã của giầy hiện có trong kho");
            id = sc.nextLine();
            for (String idGiayDaCo : maGiayDaCo){
                if (idGiayDaCo.equals(id)){
                    checkID = false;
                    giay = khoTong.timkiem1(id);
                    break;
                }
            }
        }while (checkID);


        mauSac = giay.getMauSac();
        ngayNhapVe  = giay.getNgayNhapVe();
        gia = giay.getGia();
        int soLuongHienCo = khoTong.timkiem1(id).getSoLuong();
        soLuong = 0;
        boolean checkSoLuong = true;
        do {
            System.out.println("Nhập số lượng yêu cầu nhỏ hơn hoặc bằng lượng số lượng đang có trong kho");
            soLuong = Integer.parseInt(sc.nextLine());
            if(soLuong <= soLuongHienCo){
                checkSoLuong = false;
            }
        }while (checkSoLuong);


        Giay g = new Giay(loaiGiay,id,mauSac,ngayNhapVe,gia,soLuong);
        return g;
    }
    // tao moi hoa don
    public HoaDon taoMoiHoaDon() {
        String loaiHoaDon;
        String id;
        String ngayLap;
        int soLuongLoaiGiay;
        boolean checkALL = true;

        HashMap<String, Giay> dsGiay = new HashMap<>();
        System.out.println("Nhập loại hóa đơn");
        loaiHoaDon = KieuNhapLieu.loaiHoaDon();

        do {
            System.out.println("Nhập mã hóa đơn");
            id = sc.nextLine();
            if (!id.equals("")) {
                checkALL = false;
            }
        } while (checkALL);
        checkALL = true;

        System.out.println("Nhập ngày lập hóa đơn");
        ngayLap = KieuNhapLieu.ngayThang();

        String sllg;
        do {
            System.out.println("Trong hóa đơn có bao nhiêu kiểu giày?");
            sllg = sc.next();
            if (!sllg.equals("")) {
                checkALL = false;
            }
        } while (checkALL);
        checkALL = true;
        soLuongLoaiGiay = Integer.parseInt(sllg);

            for (int i = 0; i < soLuongLoaiGiay; i++) {
                if (loaiHoaDon.equals("N")) {
                    Giay g = taoMoiGiayNhap();
                    String idG = g.getId();
                    dsGiay.put(idG, g);
                } else {
                    Giay g = taoMoiGiayXuat();
                    String idG = g.getId();
                    dsGiay.put(idG, g);
                }
            }
            HoaDon hd = new HoaDon(loaiHoaDon, id, ngayLap, dsGiay);
            return hd;
    }
    public void tuyChon(){
        do {
            System.out.println(".....Tùy Chọn.....");
            System.out.println("1. Hiển thị danh sách kho giày");
            System.out.println("2. Hiển thị danh sách hóa đơn");
            System.out.println("3. Tạo mới hóa đơn Nhập(N), Xuất(X)");
            System.out.println("4. tìm kiếm giày trong kho");
            System.out.println("5. Xóa giày không cần thiết hoặc không tồn tại trong danh sách kho");
            System.out.println("6. Hiển thị hàng tồn kho trên 6 tháng");
            System.out.println("7. Hiển thị hàng mới về dưới 20 ngày");
            System.out.println("8. Xóa hết data");
            System.out.println("0. Exit");
            System.out.println("..................");
            int choose = Integer.parseInt(sc.nextLine());
            switch (choose){
                case 1:
                    khoTong.hienThiAll();
                    break;
                case 2:
                    dsHoaDon.hienthi();
                    break;
                case 3:
                    dsHoaDon.them(taoMoiHoaDon());
                    break;
                case 4:
                    System.out.println("Nhâp mã giày hoặc loại giày cần tìm");
                    String name = sc.nextLine();
                    khoTong.hienThi(name);
                    break;
                case 5:
                    System.out.println("Nhâp mã giầy cần xóa");
                    String name1 = sc.nextLine();
                    khoTong.xoa(name1);
                    break;
                case 6:
                    khoTong.hienThiHangTonKho();
                    break;
                case 7:
                    khoTong.hienThiHangNew();
                    break;
                case 8:
                    String mk;
                    boolean checkMK = true;
                    do {
                        System.out.println("Yêu cầu nhập đúng mật khẩu");
                        mk = sc.nextLine();
                         if (mk.equals("123456")){
                             checkMK = false;
                         }
                    }while (checkMK);
                    dsHoaDon.xoaHet();
                    khoTong.xoaHet();
                    System.out.println("Đã Xóa hết data");
                    break;
                case 0:
                    System.exit(0);
            }
        }while (true);
    }
}

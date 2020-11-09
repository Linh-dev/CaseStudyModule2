package com.company;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Scanner;

// định dạng các kiểu nhập liệu
public class KieuNhapLieu {
    static Scanner sc = new Scanner(System.in);
    static DanhSachHoaDon hoaDon = new DanhSachHoaDon();

    public static String ngayThang(){
        String regexDate = "^(?:(?:31(\\/|-|\\.)(?:0?[13578]|1[02]))\\1|(?:(?:29|30)(\\/|-|\\.)(?:0?[13-9]|1[0-2])\\2))(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$|^(?:29(\\/|-|\\.)0?2\\3(?:(?:(?:1[6-9]|[2-9]\\d)?(?:0[48]|[2468][048]|[13579][26])|(?:(?:16|[2468][048]|[3579][26])00))))$|^(?:0?[1-9]|1\\d|2[0-8])(\\/|-|\\.)(?:(?:0?[1-9])|(?:1[0-2]))\\4(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$";
        boolean isNgayThang = false;
        String ngayThang = null;
        do {
            System.out.println("Nhập ngày tháng theo định dạng: dd.MM.yyy");

            ngayThang = sc.nextLine();
            isNgayThang = ngayThang.matches(regexDate);
        }while (!isNgayThang);
        return ngayThang;
    }

    public static String loaiHoaDon(){
        String regexHoaDon = "^[N|X]$";
        String loaiHoaDon = null;
        boolean ischeck = false;
        do {
            System.out.println("Nhập loại hóa đơn theo định dạng: Nhập = 'N' // Xuất = 'X'");
            loaiHoaDon = sc.nextLine();
            ischeck = loaiHoaDon.matches(regexHoaDon);
        }while (!ischeck);
        return loaiHoaDon;
    }

}

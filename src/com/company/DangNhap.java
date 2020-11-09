package com.company;

import java.sql.SQLOutput;
import java.util.HashMap;
import java.util.Scanner;

public class DangNhap {
    public static void main(String[] args) {
        boolean check;
        Scanner sc = new Scanner(System.in);
        Menu menu = new Menu();
        Kho dsKho = new Kho();
        DanhSachHoaDon dsHoaDon = new DanhSachHoaDon();
        do {
            System.out.println("_________Đăng nhâp_______");
            System.out.println("Nhập tài khoản:");
            String tk = sc.nextLine();
            System.out.println("Nhâp mật khẩu:");
            String mk = sc.nextLine();
            String[] arr = new String[2];
            arr[0] = tk;
            arr[1] = mk;
            boolean check1 = tk.equals("admin");
            boolean check2 = mk.equals("123456");
            if (check1 && check2){
                check = false;
            }else {
                check = true;
            }
        }while (check);
        menu.tuyChon();
    }
}

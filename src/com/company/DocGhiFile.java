package com.company;

import java.io.*;
import java.util.ArrayList;

public class DocGhiFile {
    public static ArrayList<Giay> docFileDSKho(){
        ArrayList<Giay> arr = new ArrayList<>();
        File file = new File("DanhSachKho.dat");
        long kt = file.length(); // kiem tra kich thuoc cua file co rong hay khong
        if (kt>0){
            try {
                FileInputStream fis = new FileInputStream(file);
                ObjectInputStream ois = new ObjectInputStream(fis);
                while (fis.available()>0){
                    Object obj = ois.readObject();
                    Giay obj1 = (Giay) obj;
                    arr.add(obj1);
                }
                fis.close();
                ois.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }catch (IOException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        return arr;
    }

    public static void ghiFileDSKho(ArrayList<Giay> arr){
        try {
            FileOutputStream fos = new FileOutputStream("DanhSachKho.dat");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            for (Giay g : arr){
                oos.writeObject(g);
            }
            fos.close();
            oos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<HoaDon> docFileDSHoaDon(){
        ArrayList<HoaDon> arr = new ArrayList<>();
        File file = new File("DanhSachHoaDon.dat");
        long kt = file.length(); // kiem tra kich thuoc cua file co rong hay khong
        if (kt>0){
            try {
                FileInputStream fis = new FileInputStream(file);
                ObjectInputStream ois = new ObjectInputStream(fis);
                while (fis.available()>0){
                    Object obj = ois.readObject();
                    HoaDon obj1 = (HoaDon) obj;
                    arr.add(obj1);
                }
                fis.close();
                ois.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        return arr;
    }

    public static void ghiFileDSHoaDon(ArrayList<HoaDon> arr){
        try {
            FileOutputStream fos = new FileOutputStream("DanhSachHoaDon.dat");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            for (HoaDon hd : arr){
                oos.writeObject(hd);
            }
            fos.close();
            oos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

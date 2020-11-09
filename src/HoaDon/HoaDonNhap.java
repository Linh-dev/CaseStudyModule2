package HoaDon;

import com.company.Giay;

import java.util.ArrayList;
import java.util.HashMap;

public class HoaDonNhap extends HoaDon {
    private final String loai = "N";
    private HashMap<String, Giay> dsGiay = new HashMap<>();

    public HoaDonNhap(){
        super();
    }

    public String getLoai() {
        return loai;
    }
    public HashMap<String, Giay> getDsGiay() {
        return dsGiay;
    }

    public void setDsGiay(HashMap<String, Giay> dsGiay) {
        this.dsGiay = dsGiay;
    }
    public HoaDonNhap(String id, String ngayLap, HashMap<String, Giay> dsGiay) {
        super(id, ngayLap);
        this.dsGiay = dsGiay;
    }

//    @Override
//    public String toString() {
//
//        String content =  "Hóa Đơn Nhập{"+ " mã: "+getId()+ '\'' +" ngày lập: "+getNgayLap()+
//                "\nDanh Sách:" + dsGiay +
//                '}';
//    }
}

package HoaDon;

public class HoaDon {
    private String id;
    private String ngayLap;

    public HoaDon() {
    }

    public HoaDon(String id, String ngayLap) {
        this.id = id;
        this.ngayLap = ngayLap;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNgayLap() {
        return ngayLap;
    }

    public void setNgayLap(String ngayLap) {
        this.ngayLap = ngayLap;
    }
}

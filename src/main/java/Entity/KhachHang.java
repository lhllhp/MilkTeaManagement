package Entity;

public class KhachHang {
    private int maKhachHang;
    private String sdt;
    private int diem;

    public KhachHang(){}

    public KhachHang(int maKhachHang, String sdt, int diem) {
        this.maKhachHang = maKhachHang;
        this.sdt = sdt;
        this.diem = diem;
    }

    public int getMaKhachHang() {
        return maKhachHang;
    }

    public void setMaKhachHang(int maKhachHang) {
        this.maKhachHang = maKhachHang;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public int getDiem() {
        return diem;
    }

    public void setDiem(int diem) {
        this.diem = diem;
    }

    @Override
    public String toString() {
        return "KhachHang{" +
                "maKhach=" + maKhachHang +
                ", sdt='" + sdt + '\'' +
                ", diem=" + diem +
                '}';
    }
}

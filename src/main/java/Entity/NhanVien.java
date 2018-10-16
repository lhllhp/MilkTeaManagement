package Entity;

public class NhanVien {
    private int maNV;
    private String ten;
    private Boolean ca;
    private String sdt;
    private int luong;
    private int thuong;

    public NhanVien(){}

    public NhanVien(int maNV, String ten, Boolean ca, String sdt, int luong, int thuong) {
        this.maNV = maNV;
        this.ten = ten;
        this.ca = ca;
        this.sdt = sdt;
        this.luong = luong;
        this.thuong = thuong;
    }

    public int getMaNV() {
        return maNV;
    }

    public void setMaNV(int maNV) {
        this.maNV = maNV;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public Boolean getCa() {
        return ca;
    }

    public void setCa(Boolean ca) {
        this.ca = ca;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public int getLuong() {
        return luong;
    }

    public void setLuong(int luong) {
        this.luong = luong;
    }

    public int getThuong() {
        return thuong;
    }

    public void setThuong(int thuong) {
        this.thuong = thuong;
    }

    @Override
    public String toString() {
        return "NhanVien{" +
                "maNV=" + maNV +
                ", ten='" + ten + '\'' +
                ", ca=" + (ca) +
                ", sdt='" + sdt + '\'' +
                ", luong=" + luong +
                ", thuong=" + thuong +
                '}';
    }
}

package Entity;

public class MonChinh {
    private int maChinh;
    private String ten;
    private Boolean tinhTrang;
    private int gia;

    public MonChinh(){}

    public MonChinh(int maChinh, String ten, Boolean tinhTrang, int gia) {
        this.maChinh = maChinh;
        this.ten = ten;
        this.tinhTrang = tinhTrang;
        this.gia = gia;
    }

    public int getMaChinh() {
        return maChinh;
    }

    public void setMaChinh(int maChinh) {
        this.maChinh = maChinh;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public Boolean getTinhTrang() {
        return tinhTrang;
    }

    public void setTinhTrang(Boolean tinhTrang) {
        this.tinhTrang = tinhTrang;
    }

    public int getGia() {
        return gia;
    }

    public void setGia(int gia) {
        this.gia = gia;
    }

    @Override
    public String toString() {
        return "MonChinh{" +
                "maChinh=" + maChinh +
                ", ten='" + ten + '\'' +
                ", tinhTrang=" + (tinhTrang?"Còn":"Hết") +
                ", gia=" + gia +
                '}';
    }
}

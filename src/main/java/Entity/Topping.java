package Entity;

public class Topping {
    private int maTop;
    private String ten;
    private Boolean tinhTrang;
    private int gia;

    public Topping(){}

    public Topping(int maTop, String ten, Boolean tinhTrang, int gia) {
        this.maTop = maTop;
        this.ten = ten;
        this.tinhTrang = tinhTrang;
        this.gia = gia;
    }

    public int getMaTop() {
        return maTop;
    }

    public void setMaTop(int maTop) {
        this.maTop = maTop;
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
        return "Topping{" +
                "maTop=" + maTop +
                ", ten='" + ten + '\'' +
                ", tinhTrang=" + (tinhTrang?"Còn":"Hết") +
                ", gia=" + gia +
                '}';
    }
}

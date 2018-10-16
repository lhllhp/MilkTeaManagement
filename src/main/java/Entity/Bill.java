package Entity;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Bill {
    private int maBill;
    private int maChinh;
    private int maTop;
    private int sl;
    private int maNV;
    private Date ngay;
    private int maKhach;
    private int tongTien;

    public Bill(){}

    public Bill(int maBill, int maChinh, int maTop, int sl, int maNV, Date ngay, int maKhach, int tongTien) {
        this.maBill = maBill;
        this.maChinh = maChinh;
        this.maTop = maTop;
        this.sl = sl;
        this.maNV = maNV;
        this.ngay = ngay;
        this.maKhach = maKhach;
        this.tongTien = tongTien;
    }

    public int getMaBill() {
        return maBill;
    }

    public void setMaBill(int maBill) {
        this.maBill = maBill;
    }

    public int getMaChinh() {
        return maChinh;
    }

    public void setMaChinh(int maChinh) {
        this.maChinh = maChinh;
    }

    public int getMaTop() {
        return maTop;
    }

    public void setMaTop(int maTop) {
        this.maTop = maTop;
    }

    public int getSl() {
        return sl;
    }

    public void setSl(int sl) {
        this.sl = sl;
    }

    public int getMaNV() {
        return maNV;
    }

    public void setMaNV(int maNV) {
        this.maNV = maNV;
    }

    public Date getNgay() {
        return ngay;
    }

    public void setNgay(Date ngay) {
        this.ngay = ngay;
    }

    public int getMaKhach() {
        return maKhach;
    }

    public void setMaKhach(int maKhach) {
        this.maKhach = maKhach;
    }

    public int getTongTien() {
        return tongTien;
    }

    public void setTongTien(int tongTien) {
        this.tongTien = tongTien;
    }

    @Override
    public String toString() {
        return "Bill{" +
                "maBill=" + maBill +
                ", maChinh=" + maChinh +
                ", maTop=" + maTop +
                ", sl=" + sl +
                ", maNV=" + maNV +
                ", ngay=" + (new SimpleDateFormat("dd-MM-yyyy").format(ngay)) +
                ", maKhach=" + maKhach +
                ", tongTien=" + tongTien +
                '}';
    }
}

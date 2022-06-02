package com.example;


import java.io.Serializable;
import java.util.Formatter;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;

public class SinhVien implements Comparable<SinhVien>, Serializable, Cloneable {
    private String mssv;
    private String ten;

    private Set<Diem> monDaHoc = new HashSet<>();

    public String getMssv() {
        return mssv;
    }

    public void setMssv(String mssv) {
        this.mssv = mssv;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public Set<Diem> getMonDaHoc() {
        return monDaHoc;
    }

    public void setMonDaHoc(Set<Diem> monDaHoc) {
        this.monDaHoc = monDaHoc;
    }

    public SinhVien(String mssv, String ten) {
        this.mssv = mssv;
        this.ten = ten;
    }

    public SinhVien(String mssv, String ten, Set<Diem> monDaHoc) {
        this.mssv = mssv;
        this.ten = ten;
        this.monDaHoc = monDaHoc;
    }

    @Override
    public String toString() {
        return "SinhVien{" +
                "mssv='" + mssv + '\'' +
                ", ten='" + ten + '\'' +
                ", monDaHoc=" + monDaHoc +
                '}';
    }

    public boolean themDiem(Diem diemMoi) {
        return this.monDaHoc.add(diemMoi);
    }

    //TODO Cau 1
    public double tinhDiemTrungBinh() {
        //Giong nhu cach tinh hien tai cua truong
        double total = this.monDaHoc.stream().
                mapToDouble(diem -> diem.getDiem()*(diem.getMon().getTcTH() + diem.getMon().getTcTH())).sum();
        int tinchi = this.monDaHoc.stream().
                mapToInt(value -> value.getMon().getTcLT() + value.getMon().getTcTH()).sum();

        return total / tinchi;
    }


    //TODO Cau 2
    public String bangDiem() {
    /*
     MSSV : 0203044
     Ten  : Nguyen Van A
     Danh Sach Diem
     STT  Ten Mon             Diem       So Tin Chi
     1    Cau Truc Du Lieu 1  8          3
     2    Cau Truc Du Lieu 2  8          3
     Diem Trung Binh   8.0
    */
        //...
        //StringBuilder
        StringBuilder str = new StringBuilder();
        Formatter formatter = new Formatter(str, Locale.US);
        str.append("MSSV : " + this.mssv + "\n");
        str.append("Ten : " + this.ten + "\n");
        str.append("Danh Sanh Diem\n");
        str.append("STT    Ten Mon           Diem       So Tin Chi \n");
        int i = 0;
        for (Diem diem : monDaHoc) {
            formatter.format("%d%9s%17d%13d\n", ++i, diem.getMon().getTen(), diem.getDiem(), (diem.getMon().getTcLT() + diem.getMon().getTcTH()));
        }
        formatter.format("Diem Trung Binh : %f", this.tinhDiemTrungBinh());

        return str.toString();
    }


    //TODO Cau 3
    public String xepLoai() {
    /*
    Quy tac xep loai nhu sau
        DiemTB < 5 -> YEU
        DiemTB >= 5 va DiemTB < 6 -> TB
        DiemTB >= 6 va DiemTB < 7 -> TB-KHA
        DiemTB >= 7 va DiemTB < 8 -> KHA
        DiemTB >= 8 -> GIOI
    */

        String xepLoai = "";
        double diemTB = this.tinhDiemTrungBinh();
        if (diemTB < 5) xepLoai = "YEU";
        else if (diemTB < 6) xepLoai = "TB";
        else if (diemTB < 7) xepLoai = "TB-KHA";
        else if (diemTB < 8) xepLoai = "KHA";
        else if (diemTB >= 8) xepLoai = "GIOI";
        return xepLoai;

    }

    @Override
    public int compareTo(SinhVien o) {
        return 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SinhVien)) return false;

        SinhVien sinhVien = (SinhVien) o;

        if (!getMssv().equals(sinhVien.getMssv())) return false;
        if (!getTen().equals(sinhVien.getTen())) return false;
        return getMonDaHoc() != null ? getMonDaHoc().equals(sinhVien.getMonDaHoc()) : sinhVien.getMonDaHoc() == null;
    }

    @Override
    public int hashCode() {
        int result = getMssv().hashCode();
        result = 31 * result + getTen().hashCode();
        result = 31 * result + (getMonDaHoc() != null ? getMonDaHoc().hashCode() : 0);
        return result;
    }
}

package com.example;

import java.util.*;
import java.util.stream.Collectors;

public class LopHoc {
    private String ten;
    private String giaoVien;
    private List<SinhVien> dsLop = new ArrayList<SinhVien>();

    public LopHoc(String ten, String giaoVien) {
        this.ten = ten;
        this.giaoVien = giaoVien;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getGiaoVien() {
        return giaoVien;
    }

    public void setGiaoVien(String giaoVien) {
        this.giaoVien = giaoVien;
    }

    public List<SinhVien> getDsLop() {
        return dsLop;
    }

    public void setDsLop(List<SinhVien> dsLop) {
        this.dsLop = dsLop;
    }

    public boolean them(SinhVien svMoi) {
        return dsLop.add(svMoi);
    }

    //TODO Cau 4
    public String inDiem() {
    /*
    Danh Sach Diem Lop : ten
    Giao Vien Chu Nhiem : giaoVien
    STT      MSSV        Ten              Diem TB   XepLoai
    1        123456      Nguyen Van A     8.4       GIOI
    2        678919      Nguyen Van B     6         TB-KHA
    3        112456      Nguyen Van C     7         KHA
    */
        StringBuilder str = new StringBuilder();
        Formatter formatter = new Formatter(str, Locale.US);
        formatter.format("Danh Sach Diem Lop : " + this.ten + "\n");
        formatter.format("Giao Vien Chu Nhiem : " + this.giaoVien + "\n");
        formatter.format("STT    MSSV      Ten       Diem TB      XepLoai \n");

        for (int i = 0; i < this.dsLop.size(); i++) {
            formatter.format("%d %12s %5s %14f %10s\n",
                    (i + 1), this.dsLop.get(i).getMssv(),
                    this.dsLop.get(i).getTen(),
                    this.dsLop.get(i).tinhDiemTrungBinh(),
                    this.dsLop.get(i).xepLoai());
        }
        return str.toString();
    }

    //TODO Cau 5
    public List<SinhVien> top10() {
        //Tra ve danh sach 10 sinh vien co diem trung binh lon nhat lop
        //...
//        Collections.sort(this.dsLop, (o1, o2) -> {
//            Double d1 = o1.tinhDiemTrungBinh();
//            Double d2 = o2.tinhDiemTrungBinh();
//            return d2.compareTo(d1);
//        });
//        List<SinhVien> list = new ArrayList<>();
//        if (dsLop.size() > 10) {
//            for (int i = 0; i < 10; i++) {
//                list.add(this.dsLop.get(i));
//            }
//        } else {
//            list = dsLop;
//        }
        List<SinhVien> list = this.dsLop.stream().sorted((o1, o2) ->
                        ((Double) o1.tinhDiemTrungBinh()).compareTo((Double) o2.tinhDiemTrungBinh())).
                limit(10).collect(Collectors.toList());
        return list;
    }

    //TODO Cau 6
    public List<SinhVien> sinhVienYeu() {
        //Tra ve danh sach vien vien xep loai YEU
        //...
        List<SinhVien> list = this.dsLop.stream().filter(sinhVien -> sinhVien.xepLoai().equals("YEU")).collect(Collectors.toList());
        return list;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof LopHoc)) return false;

        LopHoc lopHoc = (LopHoc) o;

        if (!getTen().equals(lopHoc.getTen())) return false;
        if (!getGiaoVien().equals(lopHoc.getGiaoVien())) return false;
        return getDsLop().equals(lopHoc.getDsLop());
    }

    @Override
    public int hashCode() {
        int result = getTen().hashCode();
        result = 31 * result + getGiaoVien().hashCode();
        result = 31 * result + getDsLop().hashCode();
        return result;
    }
}

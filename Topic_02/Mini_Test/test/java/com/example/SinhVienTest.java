package test.java.com.example;


import com.example.Diem;
import com.example.MonHoc;
import com.example.SinhVien;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

class SinhVienTest {
    SinhVien sv;
    public SinhVienTest(){
         sv = new SinhVien("Ph16402","Duc");
        Set<Diem> diems = new HashSet<>();
        diems.add(new Diem(new MonHoc("Tin",1,2),7));
        diems.add(new Diem(new MonHoc("Van",2,3),7));
        diems.add(new Diem(new MonHoc("Anh",5,4),7));
        sv.setMonDaHoc(diems);
    }
    @Test
    void themDiem() {
        sv.getMonDaHoc().add( new Diem(new MonHoc("Hoa",1,1),7));
        this.bangDiem();
    }

    @Test
    void tinhDiemTrungBinh() {

        Assertions.assertEquals(7,sv.tinhDiemTrungBinh());
    }

    @Test
    void bangDiem() {
        System.out.println(sv.bangDiem());
    }

    @Test
    void xepLoai() {
        String xepLoai = sv.xepLoai();
        Assertions.assertSame("KHA",xepLoai);
    }
}
package test.java.com.example;

import com.example.Diem;
import com.example.LopHoc;
import com.example.MonHoc;
import com.example.SinhVien;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class LopHocTest {
    LopHoc lopHoc;
    Set<Diem> diems;
    public LopHocTest(){
        lopHoc = new LopHoc("FIS_RA","Phuoc");
        List<SinhVien> sinhViens  = new ArrayList<>();
        diems = new HashSet<>();
        diems.add(new Diem(new MonHoc("Tin",1,2),7));
        diems.add(new Diem(new MonHoc("Van",2,3),6));
        diems.add(new Diem(new MonHoc("Anh",5,4),5));
        sinhViens.add(new SinhVien("Ph16402","Duc",diems));
        sinhViens.add(new SinhVien("Ph16403","Anh",diems));
        lopHoc.setDsLop(sinhViens);


    }
    @Test
    void them() {
        lopHoc.them(new SinhVien("Ph16403","Quynh",diems));
        SinhVien sv = lopHoc.getDsLop().get(lopHoc.getDsLop().size()-1);
        assertEquals(sv,lopHoc.getDsLop().get(lopHoc.getDsLop().size()-1));
    }

    @Test
    void inDiem() {
        System.out.println(lopHoc.inDiem());
    }

    @Test
    void top10() {
        for(SinhVien sv : lopHoc.getDsLop()){
            System.out.println(sv);
        }
    }

    @Test
    void sinhVienYeu() {
        this.lopHoc.top10().forEach(sinhVien -> System.out.println(sinhVien));
    }
}
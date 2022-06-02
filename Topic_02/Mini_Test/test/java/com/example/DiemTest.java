package com.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DiemTest {

    @Test
    void getMon() {
        Diem diem = new Diem(new MonHoc("Mh1",1,1),9);
        MonHoc mh = new MonHoc("Mh1",1,1);
        assertTrue(diem.getMon().equals(mh));
    }

    @Test
    void getDiem() {
        //a
        Diem diem = new Diem(new MonHoc("Mh1",1,1),9);
        //action

        int d = diem.getDiem();
        //
        assertEquals(d,diem.getDiem());
    }

    @Test
    void testEquals() {
        Diem diem = new Diem(new MonHoc("Mh1",1,1),9);
        Diem diem1 = new Diem(new MonHoc("Mh1",2,3),4);
        assertTrue(diem.equals(diem1));
    }

    @Test
    void compareTo() {
        Diem diem = new Diem(new MonHoc("Mh1",1,1),9);
        Diem diem1 = new Diem(new MonHoc("Mh1",2,3),9);
        assertEquals(0,diem.compareTo(diem1));
    }

    @Test
    void testHashCode() {
        Diem diem = new Diem(new MonHoc("Mh1",1,1),9);
        Diem diem1 = new Diem(new MonHoc("Mh1",1,1),9);
        assertTrue(diem.hashCode() == diem1.hashCode());
    }

}
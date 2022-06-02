package com.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MonHocTest {

    @Test
    void testEquals() {
        MonHoc mh1 = new MonHoc("MH1",1,1);
        MonHoc mh2 = new MonHoc("MH1",1,1);
        assertTrue(mh1.equals(mh2));
    }

    @Test
    void getTcLT() {
    }

    @Test
    void getTcTH() {
    }
}
package com.example;

import java.io.Serializable;
import java.util.Objects;

public class Diem implements Comparable<Diem>, Serializable,Cloneable {
    private MonHoc mon;
    private int diem;

    @Override
    public String toString() {
        return "Diem{" +
                "mon=" + mon +
                ", diem=" + diem +
                '}';
    }

    public Diem(MonHoc mon, int diem) {
        this.mon = mon;
        this.diem = diem;
    }

    public MonHoc getMon() {
        return mon;
    }

    public void setMon(MonHoc mon) {
        this.mon = mon;
    }

    public int getDiem() {
        return diem;
    }

    public void setDiem(int diem) {
        this.diem = diem;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Diem)) return false;

        Diem diem1 = (Diem) o;

        if (getDiem() != diem1.getDiem()) return false;
        return getMon().equals(diem1.getMon());
    }

    @Override
    public int hashCode() {
        return getDiem();
    }

    @Override
    public int compareTo(Diem o) {
        if(this.getDiem() > o.getDiem()) return 1;
        else if(this.getDiem() < o.getDiem()) return -1;
        else return 0;
    }



    @Override
    public Diem clone() {
        Diem diem = new Diem(new MonHoc(this.getMon().getTen(),this.getMon().getTcLT(),this.getMon().getTcTH()),this.getDiem());
        return diem;
    }


}

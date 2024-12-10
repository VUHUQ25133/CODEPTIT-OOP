package com.example.ptit;
import java.io.*;
import java.util.*;
import java.math.*;
import java.text.*;

class monHoc {
    private String maMon, tenMon, hinhThuc;

    public monHoc() {}
    public monHoc(String maMon, String tenMon, String hinhThuc) {
        this.maMon = maMon;
        this.tenMon = tenMon;
        this.hinhThuc = hinhThuc;
    }
    public String getMaMon() {
        return maMon;
    }
    public String toString() {
        return this.maMon + " " + this.tenMon + " " + this.hinhThuc;
    }
}
public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("MONHOC.in"));
        HashSet<String> set = new HashSet<>();
        ArrayList<monHoc> mh = new ArrayList<>();
        while (sc.hasNextLine()) {
            monHoc x = new monHoc(sc.nextLine(), sc.nextLine(), sc.nextLine());
            if (!set.contains(x.getMaMon())) {
                mh.add(x);
            }
            set.add(x.getMaMon());
        }
        Collections.sort(mh, new Comparator<monHoc>() {
            @Override
            public int compare(monHoc o1, monHoc o2) {
                return o1.getMaMon().compareTo(o2.getMaMon());
            }
        });
        for (monHoc x : mh) {
            System.out.println(x);
        }
    }
}

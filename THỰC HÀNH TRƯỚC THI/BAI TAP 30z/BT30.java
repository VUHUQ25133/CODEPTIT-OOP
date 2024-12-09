package com.example.ptit;
import java.io.*;
import java.util.*;
import java.math.*;

class matHang {
    private String maMH, tenMH, donVi;
    private int giaMua, giaBan;

    public matHang(String maMH, String tenMH, String donVi, int giaMua, int giaBan) {
        this.maMH = maMH;
        this.tenMH = tenMH;
        this.donVi = donVi;
        this.giaMua = giaMua;
        this.giaBan = giaBan;
    }

    public String getMaMH() {
        return maMH;
    }

    public String getTenMH() {
        return tenMH;
    }

    public String getDonVi() {
        return donVi;
    }

    public int getGiaMua() {
        return giaMua;
    }

    public int getGiaBan() {
        return giaBan;
    }
}
class khachHang {
    private String maKH, hoTen, gioiTinh, ngaySinh, diaChi;

    public khachHang(String maKH, String hoTen, String gioiTinh, String ngaySinh, String diaChi) {
        this.maKH = maKH;
        this.hoTen = hoTen;
        this.gioiTinh = gioiTinh;
        this.ngaySinh = ngaySinh;
        this.diaChi = diaChi;
    }

    public String getMaKH() {
        return maKH;
    }

    public String getHoTen() {
        return hoTen;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public String getNgaySinh() {
        return ngaySinh;
    }

    public String getDiaChi() {
        return diaChi;
    }
}
class hoaDon {
    private String maHD, maKH, maMH;
    private int soLuong;

    private ArrayList<khachHang> kh;
    private ArrayList<matHang> mh;

    public hoaDon(String maHD, String maKH, String maMH, int soLuong) {
        this.maHD = maHD;
        this.maKH = maKH;
        this.maMH = maMH;
        this.soLuong = soLuong;
    }

    public String getMaHD() {
        return maHD;
    }

    public String getMaKH() {
        return maKH;
    }

    public String getMaMH() {
        return maMH;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setKh(ArrayList<khachHang> kh) {
        this.kh = kh;
    }

    public void setMh(ArrayList<matHang> mh) {
        this.mh = mh;
    }
}

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("KH.in"));
        ArrayList<khachHang> kh = new ArrayList<>();
        int t = Integer.parseInt(sc.nextLine());
        for (int i = 1; i <= t; i++) {
            khachHang x = new khachHang("KH" + String.format("%03d", i), sc.nextLine(), sc.nextLine(), sc.nextLine(), sc.nextLine());
            kh.add(x);
        }
        sc = new Scanner(new File("MH.in"));
        int n = Integer.parseInt(sc.nextLine());
        ArrayList<matHang> mh = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            matHang x = new matHang("MH" + String.format("%03d", i), sc.nextLine(), sc.nextLine(), Integer.parseInt(sc.nextLine()), Integer.parseInt(sc.nextLine()));
            mh.add(x);
        }
        sc = new Scanner(new File("HD.in"));
        int m = Integer.parseInt(sc.nextLine());
        ArrayList<hoaDon> hd = new ArrayList<>();
        for (int i = 1; i <= m; i++) {
            String[] s = (sc.nextLine()).trim().split("\\s+");
            hoaDon x = new hoaDon("HD" + String.format("%03d", i), s[0], s[1], Integer.parseInt(s[2]));
            x.setKh(kh);
            x.setMh(mh);
            hd.add(x);
        }
        for (hoaDon h : hd) {
            System.out.print(h.getMaHD() + " ");
            for (khachHang x : kh) {
                if (h.getMaKH().equals(x.getMaKH())) {
                    System.out.print(x.getHoTen() + " " + x.getDiaChi() + " ");
                    for (matHang y : mh) {
                        if (h.getMaMH().equals(y.getMaMH())) {
                            System.out.print(y.getTenMH() + " " + y.getDonVi() + " ");
                            System.out.println(y.getGiaMua() + " " + y.getGiaBan() + " " + h.getSoLuong() + " " + (y.getGiaBan() * h.getSoLuong()));
                        }
                    }
                }
            }
        }
    }
}

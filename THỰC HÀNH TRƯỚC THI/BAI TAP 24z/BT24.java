package com.example.ptit;
import java.io.*;
import java.util.*;
import java.math.*;

import java.time.*;
import java.time.format.DateTimeFormatter;

class khachHang {
    private String maKH, hoTen, diaChi, maSP, ngayMua, hetHan;
    private int soLuong, tongTien;

    public khachHang(String maKH, String hoTen, String diaChi, String maSP, int soLuong, String ngayMua) {
        this.maKH = maKH;
        this.hoTen = hoTen;
        this.diaChi = diaChi;
        this.maSP = maSP;
        this.soLuong = soLuong;
        this.ngayMua = ngayMua;
    }

    public void tinhToan(ArrayList<sanPham> sp) {
        this.tongTien = 0;
        for (sanPham x : sp) {
            if (x.getMaSP().compareTo(this.maSP) == 0) {
                this.tongTien += x.getGiaBan() * this.soLuong;

            }
        }
    }

    public String getNgayMua() {
        return ngayMua;
    }

    public void setTongTien(int tongTien) {
        this.tongTien = tongTien;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setHetHan(String hetHan) {
        this.hetHan = hetHan;
    }

    public String getMaSP() {
        return maSP;
    }

    public String getMaKH() {
        return maKH;
    }

    public String ngay() {
        String day = "" + this.hetHan.charAt(0) + this.hetHan.charAt(1);
        String month = "" + this.hetHan.charAt(3) + this.hetHan.charAt(4);
        String year = "" + this.hetHan.charAt(6) + this.hetHan.charAt(7) + this.hetHan.charAt(8) + this.hetHan.charAt(9);
        return year + month + day;
    }

    public String toString() {
        return this.maKH + " " + this.hoTen + " " + this.diaChi + " " + this.maSP + " " + this.tongTien + " " + this.hetHan;
    }
}
class sanPham {
    private String maSP, tenSP;
    private int giaBan, baoHanh;

    public sanPham(String maSP, String tenSP, int giaBan, int baoHanh) {
        this.maSP = maSP;
        this.tenSP = tenSP;
        this.giaBan = giaBan;
        this.baoHanh = baoHanh;
    }

    public String getMaSP() {
        return maSP;
    }

    public int getGiaBan() {
        return giaBan;
    }

    public int getBaoHanh() {
        return baoHanh;
    }
}



public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("MUAHANG.in"));
        int n = Integer.parseInt(sc.nextLine());
        ArrayList<sanPham> sp = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            sanPham x = new sanPham(sc.nextLine(), sc.nextLine(), Integer.parseInt(sc.nextLine()), Integer.parseInt(sc.nextLine()));
            sp.add(x);
        }
        int t = Integer.parseInt(sc.nextLine());
        ArrayList<khachHang> kh = new ArrayList<>();
        for (int j = 0; j < t; j++) {
            khachHang x = new khachHang("KH" + String.format("%02d", j + 1), sc.nextLine(), sc.nextLine(), sc.nextLine(), Integer.parseInt(sc.nextLine()), sc.nextLine());
            kh.add(x);
        }
        for (int i = 0; i < kh.size(); i++) {
            khachHang x = kh.get(i);
            for (int j = 0; j < sp.size(); j++) {
                sanPham y = sp.get(j);
                if (x.getMaSP().compareTo(y.getMaSP()) == 0) {
                    int tien = x.getSoLuong() * y.getGiaBan();
                    x.setTongTien(tien);
                    LocalDate mua = LocalDate.parse(x.getNgayMua(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                    LocalDate newDate = mua.plusMonths(y.getBaoHanh());
                    String dateStr = newDate.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                    x.setHetHan(dateStr);
                }
            }
        }
        Collections.sort(kh, new Comparator<khachHang>() {
            @Override
            public int compare(khachHang o1, khachHang o2) {
                if (o1.ngay().compareTo(o2.ngay()) != 0) {
                    return o1.ngay().compareTo(o2.ngay());
                }
                return o1.getMaKH().compareTo(o2.getMaKH());
            }
        });
        for (khachHang x : kh) {
            System.out.println(x);
        }
    }
}
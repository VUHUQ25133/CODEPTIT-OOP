package com.example.ptit;
import java.io.*;
import java.util.*;
import java.math.*;
import java.text.*;

class SinhVien {
    private String maSV, hoTen, lop;
    private Date ngaySinh;
    private double gpa;

    public SinhVien(String maSV, String hoTen, String lop, String ngaySinh, double gpa) throws ParseException {
        this.maSV = maSV;
        this.hoTen = hoTen;
        this.lop = lop;
        this.ngaySinh = new SimpleDateFormat("dd/MM/yyyy").parse(ngaySinh);
        this.gpa = gpa;
        chuanHoa();
    }

    public void chuanHoa() {                                // nếu bài ko yêu cầu chuẩn hóa thì ko cần
        String[] x = this.hoTen.trim().split("\\s+");
        StringBuilder sb = new StringBuilder("");
        for (int i = 0; i < x.length; i++) {
            sb.append(Character.toUpperCase(x[i].charAt(0)));
            for (int j = 1; j < x[i].length(); j++) {
                sb.append(Character.toLowerCase(x[i].charAt(j)));
            }
            if (i != x.length - 1) {
                sb.append(" ");
            }
        }
        this.hoTen = sb.toString();
    }
    @Override
    public String toString() {
        String ngaySinh = new SimpleDateFormat("dd/MM/yyyy").format(this.ngaySinh);
        return this.maSV + " " + this.hoTen + " " + this.lop + " " + ngaySinh + " " + String.format("%.2f", this.gpa);
    }
}
public class Main {
    public static void main(String[] args) throws FileNotFoundException, ParseException {
        Scanner sc = new Scanner(new File("SINHVIEN.in"));
        int n = Integer.parseInt(sc.nextLine());
        ArrayList<SinhVien> sv = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            SinhVien x = new SinhVien("B20DCCN" + String.format("%03d", i), sc.nextLine(), sc.nextLine(), sc.nextLine(), Double.parseDouble(sc.nextLine()));
            sv.add(x);
        }
        for (SinhVien x : sv) {
            System.out.println(x);
        }
    }
}

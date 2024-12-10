package com.example.ptit;
import java.io.*;
import java.util.*;
import java.math.*;
import java.text.*;

class sinhVien {
    private String hoTen;
    private int soBai, submit;

    public sinhVien(String hoTen, int soBai, int submit) {
        this.hoTen = hoTen;
        this.soBai = soBai;
        this.submit = submit;
    }

    public String getHoTen() {
        return hoTen;
    }

    public int getSoBai() {
        return soBai;
    }

    public int getSubmit() {
        return submit;
    }

    public String toString() {
        return this.hoTen.trim() + " " + this.soBai + " " + this.submit;
    }
}
public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(new File("LUYENTAP.in"));
        int n = sc.nextInt();
        sinhVien[] sv = new sinhVien[n];
        for (int i = 0; i < n; i++) {
            sc.nextLine();
            sv[i] = new sinhVien(sc.nextLine(), sc.nextInt(), sc.nextInt());
        }
        Arrays.sort(sv, new Comparator<sinhVien>() {
            @Override
            public int compare(sinhVien o1, sinhVien o2) {
                if (o1.getSoBai() != o2.getSoBai()) {
                    return o2.getSoBai() - o1.getSoBai();
                } else if (o1.getSubmit() != o2.getSubmit()) {
                    return o1.getSubmit() - o2.getSubmit();
                } else {
                    return o1.getHoTen().compareTo(o2.getHoTen());
                }
            }
        });
        for (sinhVien x : sv)
            System.out.println(x);
    }
}
//Cách 2
// class sinhVien implements Comparable<sinhVien> {
//     private String hoTen;
//     private int soBai, submit;

//     public sinhVien(String hoTen, int soBai, int submit) {
//         this.hoTen = hoTen;
//         this.soBai = soBai;
//         this.submit = submit;
//     }

//     public String getHoTen() {
//         return hoTen;
//     }

//     public int getSoBai() {
//         return soBai;
//     }

//     public int getSubmit() {
//         return submit;
//     }

//     @Override
//     public String toString() {
//         return this.hoTen.trim() + " " + this.soBai + " " + this.submit;
//     }
//     @Override
//     public int compareTo(sinhVien o) {
//         if (this.soBai != o.soBai) {
//             return o.soBai - this.soBai;
//         }
//         if (this.submit != o.submit) {
//             return this.submit - o.submit;
//         }
//         return this.hoTen.compareTo(o.hoTen);
//     }
// }

// public class Main {
//     public static void main(String[] args) throws IOException {
//         Scanner sc = new Scanner(new File("LUYENTAP.in"));
//         int n = sc.nextInt();
//         sinhVien[] sv = new sinhVien[n];
//         for (int i = 0; i < n; i++) {
//             sc.nextLine(); 
//             sv[i] = new sinhVien(sc.nextLine(), sc.nextInt(), sc.nextInt());
//         }
//         Arrays.sort(sv);
//         for (sinhVien x : sv) {
//             System.out.println(x);
//         }
//     }
// }

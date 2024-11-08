    // Để chuẩn bị cho đợt thực tập tốt nghiệp của sinh viên năm cuối, 
    // Khoa CNTT1 trao đổi với các doanh nghiệp đối tác và chốt số lượng sinh viên có thể nhận thực tập.
    // Hãy đọc danh sách doanh nghiệp từ file và hiển thị danh sách theo thứ tự mã tăng dần (thứ tự từ điển).
    // Input : DN.in
    //     Dòng đầu ghi số doanh nghiệp.
    //     Mỗi doanh nghiệp ghi trên 3 dòng:
    //         Mã doanh nghiệp (xâu ký tự không có dấu cách, độ dài không quá 10)
    //         Tên doanh nghiệp (xâu ký tự độ dài không quá 150)
    //         Số sinh viên có thể nhận: giá trị nguyên không quá 1000
    // Output
    // G   hi ra danh sách được sắp xếp theo mã tăng dần, mỗi thông tin ghi trên một dòng.
    // Ví dụ
    // Input : DN.in
    //     4
    //     VIETTEL
    //     TAP DOAN VIEN THONG QUAN DOI VIETTEL
    //     40
    //     FSOFT
    //     CONG TY TNHH PHAN MEM FPT - FPT SOFTWARE
    //     300
    //     VNPT
    //     TAP DOAN BUU CHINH VIEN THONG VIET NAM
    //     200
    //     SUN
    //     SUN*
    //     50
    // Output
    //     FSOFT CONG TY TNHH PHAN MEM FPT - FPT SOFTWARE 300
    //     SUN SUN* 50
    //     VIETTEL TAP DOAN VIEN THONG QUAN DOI VIETTEL 40
    //     VNPT TAP DOAN BUU CHINH VIEN THONG VIET NAM 200

// ptit/Company.java
package com.example.ptit;

public class Company implements Comparable<Company> {

    private String id, name;
    private int count;

    public Company(String id, String name, int count) {
        this.id = id;
        this.name = name;
        this.count = count;
    }

    public String getId() {
        return id;
    }

    @Override
    public String toString() {
        return id + " " + name + " " + count;
    }

    @Override
    public int compareTo(Company o) {
        return id.compareTo(o.getId());
    }
}

// ptit/Main.java
package com.example.ptit;


import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("DN.in"));
        int n = Integer.parseInt(sc.nextLine());
        Company[] companies = new Company[n];
        for (int i = 0; i < n; i++) {
            String id = sc.nextLine();
            String name = sc.nextLine();
            int stc = Integer.parseInt(sc.nextLine());
            companies[i] = new Company(id, name, stc);
        }
        Arrays.sort(companies);
        for (Company i : companies) {
            System.out.println(i);
        }
    }
}



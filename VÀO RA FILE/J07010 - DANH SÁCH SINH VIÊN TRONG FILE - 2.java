// Khai báo lớp Sinh Viên gồm các thông tin: Mã SV, Họ tên, Ngày sinh, Lớp và Điểm GPA (dạng số thực). 

// Đọc thông tin N sinh viên từ file văn bản SV.in (không có mã sinh viên) và in ra lần lượt màn hình mỗi dòng 1 sinh viên theo đúng thứ tự ban đầu. 
// Trong đó Mã SV được tự tạo ra theo quy tắc thêm mã B20DCCN sau đó là giá trị nguyên tự động tăng tính từ 001 (tối đa là 099). 
// Ngày sinh được chuẩn hóa về dạng dd/mm/yyyy

// Input (file SV.in)
//     Dòng đầu tiên ghi số sinh viên N (0 < N < 50).
//     Mỗi sinh viên ghi trên 4 dòng lần lượt là Họ tên, Lớp, Ngày sinh và Điểm GPA.
//     Trong đó:
//         Họ tên không quá 30 chữ cái.
//         Lớp theo đúng định dạng thường dùng ở PTIT
//         Ngày sinh có đủ 3 phần ngày tháng năm nhưng có thể chưa đúng chuẩn dd/mm/yyyy.
//         Điểm GPA đảm bảo trong thang điểm 4 với 2 nhiều nhất 2 số sau dấu phẩy.  
// Output
//     Ghi ra màn hình danh sách lần lượt các sinh viên có đầy đủ 
//     Mã sinh viên, Họ tên, Lớp, Ngày sinh (đã chuẩn hóa về dạng dd/mm/yyyy), Điểm GPA (với đúng 2 số sau dấu phẩy).
//     Mỗi sinh viên ghi trên 1 dòng, mỗi thông tin cách nhau 1 khoảng trống.

// Ví dụ
// SV.in
//     1
//     Nguyen Van An
//     D20CQCN01-B
//     2/12/2002
//     3.19
// Output
//     B20DCCN001 Nguyen Van An D20CQCN01-B 02/12/2002 3.19

ptit/Main.java
package com.example.ptit;


import java.io.*;
import java.text.ParseException;
import java.util.*;

public class Main {

    public static void main(String[] args) throws FileNotFoundException, ParseException {
        Scanner sc = new Scanner(new File("SV.in"));
        int n = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < n; i++) {
            String name = sc.nextLine();
            String lop = sc.nextLine();
            String dob = sc.nextLine();
            float gpa = Float.parseFloat(sc.nextLine());
            Student stu = new Student(name, lop, dob, gpa);
            System.out.println(stu);
        }
    }
}

ptit/Student.java
package com.example.ptit;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Student {

    public static int NUM_STUDENT = 1;
    private String id, name, lop, dob;
    private float gpa;

    public Student(String name, String lop, String dob, float gpa) throws ParseException {
        this.id = "B20DCCN" + String.format("%03d", NUM_STUDENT++);
        this.name = name;
        this.lop = lop;
        this.gpa = gpa;

        SimpleDateFormat formatter = new SimpleDateFormat("dd/mm/yyyy");
        this.dob = formatter.format(formatter.parse(dob));
    }

    @Override
    public String toString() {
        return id + " " + name + " " + lop + " " + dob + " " + String.format("%.2f", gpa);
    }
}


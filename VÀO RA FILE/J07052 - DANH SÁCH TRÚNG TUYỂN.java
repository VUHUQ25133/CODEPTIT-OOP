// Trường Đại học XYZ tuyển sinh theo hình thức xét điểm thi ba môn Toán - Lý - Hóa, trong đó điểm Toán được nhân đôi. 
// Để đơn giản, khu vực tuyển sinh được quy định luôn bởi ba chữ cái đầu tiên trong mã thí sinh. 
// Do rất thích các thí sinh đến từ Khu vực 3 nên trường XYZ tự quy định giá trị điểm ưu tiên Khu vực như trong bảng sau:

//             BẢNG ƯU TIEN KHU VỰC
//             MÃ KHU VỰC      ĐIỂM ƯU TIÊN
//                 KV1             0.5
//                 KV2             1.0
//                 KV3             2.5

// Cho trước số chỉ tiêu. Hãy xác định mức điểm chuẩn và kết quả của từng thí sinh sau đó sắp xếp theo điểm xét tuyển giảm dần. 
// Chú ý: tất cả thí sinh bằng điểm chuẩn trở lên đều được coi là trúng tuyển, kể cả khi số thí sinh trúng tuyển nhiều hơn chỉ tiêu.
// Input - file THISINH.in
//     Dòng đầu tiên ghi số thí sinh (nhỏ hơn 100), thông tin của một thí sinh trên 5 dòng lần lượt là:
//         Mã thí sinh
//         Họ tên - có thể chưa ở dạng chuẩn
//         Điểm toán
//         Điểm lý
//         Điểm hóa
//     Các giá trị điểm đều đảm bảo trong phạm vi [0,10] và có thể có 1 chữ số phần thập phân.  
//     Dòng cuối ghi giá trị số chỉ tiêu.
// Output
//     Dòng đầu tiên ghi ra giá trị điểm chuẩn xác định được (có 1 chữ số phần thập phân)
//     Tiếp theo in ra danh sách đã sắp xếp theo điểm xét tuyển giảm dần, nếu điểm xét tuyển bằng nhau thì sắp xếp theo mã thí sinh (thứ tự từ điển) .
//     Với mỗi thí sinh ghi ra các thông tin:
//         Mã thí sinh
//         Họ tên - đã được chuẩn hóa
//         Điểm ưu tiên (có thể có 1 số phần thập phân)
//         Điểm xét tuyển - có ưu tiên (có thể có 1 số phần thập phân)
//         Trạng thái: TRUNG TUYEN hoac TRUOT (sau khi đã tính cả điểm ưu tiên)
// Ví dụ
// Input - THISINH.in
//     2
//     KV2A002
//     Hoang THAnh tuan
//     5
//     6
//     5
//     KV3B123
//     LY Thi   THU ha
//     8
//     6.5
//     7
//     1
//     32.0
// Output    
//     KV3B123 Ly Thi Thu Ha 2.5 32 TRUNG TUYEN
//     KV2A002 Hoang Thanh Tuan 1 22 TRUOT



// ptit/Main.java
package com.example.ptit;

import java.text.DecimalFormat;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("THISINH.in"));
        int t = Integer.parseInt(scanner.nextLine());
        List<Student> students = new ArrayList<>();
        while (t-- > 0) {
            students.add(new Student(scanner.nextLine(), scanner.nextLine(),
                    Double.parseDouble(scanner.nextLine()), Double.parseDouble(scanner.nextLine()), Double.parseDouble(scanner.nextLine())));
        }
        Collections.sort(students);

        int n = Integer.parseInt(scanner.nextLine());
        double mark = students.get(n - 1).getSumMark();

        for (Student student : students) {
            if (student.getSumMark() >= mark) {
                student.setStatus("TRUNG TUYEN");
            } else {
                student.setStatus("TRUOT");
            }
        }

        System.out.println(String.format("%.1f", mark));
        for (Student student : students) {
            System.out.println(student);
        }
    }
}
// ptit/Student.java
package com.example.ptit;

import java.text.DecimalFormat;

public class Student implements Comparable<Student> {

    private String id;
    private String name;
    private double math;
    private double physic;
    private double chemistry;
    private String status;

    public Student(String id, String name, double math, double physic, double chemistry) {
        this.id = id;
        this.name = name;
        this.math = math;
        this.physic = physic;
        this.chemistry = chemistry;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        name = name.trim().replaceAll("\\s+", " ");
        String[] tmp = name.split(" ");
        name = "";
        for (int i = 0; i < tmp.length; i++) {
            name += Character.toUpperCase(tmp[i].charAt(0)) + tmp[i].substring(1).toLowerCase() + " ";
        }
        name = name.trim();
        return name;
    }

    public double getSumMark() {
        return math * 2 + physic + chemistry + getBonus();
    }

    public double getBonus() {
        String s = id.substring(0, 3);
        if (s.equals("KV1")) {
            return 0.5;
        }
        if (s.equals("KV2")) {
            return 1.0;
        }
        if (s.equals("KV3")) {
            return 2.5;
        }
        return 0;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public static String removeZero(double number) {
        DecimalFormat format = new DecimalFormat("#.#");
        return format.format(number);
    }

    @Override
    public String toString() {
        return id + " " + getName() + " " + removeZero(getBonus()) + " " + removeZero(getSumMark()) + " " + getStatus();
    }

    @Override
    public int compareTo(Student o) {
        if (this.getSumMark() == o.getSumMark()) {
            return this.getId().compareTo(o.getId());
        }
        return this.getSumMark() < o.getSumMark() ? 1 : -1;
    }
}

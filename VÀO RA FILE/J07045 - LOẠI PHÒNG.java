// Khách sạn ABC có nhiều loại phòng khác nhau, mỗi loại phòng có các thông tin:
//     Ký hiệu loại phòng (là một chữ cái viết hoa)
//     Tên loại phòng: dãy ký tự viết hoa, không có khoảng trống
//     Đơn giá ngày
//     Phí phục vụ
// Viết chương trình khai báo lớp LoaiPhong và đọc thông tin danh sách từ file PHONG.in sau đó in ra màn hình theo thứ tự sắp xếp theo tên.
// Input : file PHONG.in
//     Dòng đầu ghi số loại phòng.
//     Mỗi loại ghi trên một dòng với lần lượt các thông tin ký hiệu, tên, đơn giá, phí phục vụ. Mỗi thông tin cách nhau một khoảng trống.
// Output
//     Ghi ra danh sách đã sắp xếp theo tên, mỗi loại phòng ghi trên một dòng.
// Ví dụ
//     Input : PHONG.in
//     2
//     C THUONG 150 0.03
//     B VIP 200 0.05
//     Output
//     C THUONG 150 0.03
//     B VIP 200 0.05

// ptit/LoaiPhong.java
package com.example.ptit;

public class LoaiPhong implements Comparable<LoaiPhong> {

    private String line, name;

    public LoaiPhong(String line) {
        this.line = line;
        this.name = line.trim().split("\\s+")[1];
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return line;
    }

    @Override
    public int compareTo(LoaiPhong o) {
        return name.compareTo(o.getName());
    }
}


// ptit/Main.java
package com.example.ptit;


import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        ArrayList<LoaiPhong> ds = new ArrayList<>();
        Scanner in = new Scanner(new File("PHONG.in"));
        int n = Integer.parseInt(in.nextLine());
        while(n-->0){
            ds.add(new LoaiPhong(in.nextLine()));
        }
        Collections.sort(ds);
        for(LoaiPhong tmp : ds){
            System.out.println(tmp);
        }
    }
    public static void main5595186(String[] args) throws IOException {
        ArrayList<LoaiPhong> ds = new ArrayList<>();
        Scanner in = new Scanner(new File("PHONG.in"));
        int n = Integer.parseInt(in.nextLine());
        while (n-- > 0) {
            ds.add(new LoaiPhong(in.nextLine()));
        }
        Collections.sort(ds);
        for (LoaiPhong tmp : ds) {
            System.out.println(tmp);
        }
    }
}


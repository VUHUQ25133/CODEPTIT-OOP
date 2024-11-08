// Khách sạn ABC lưu thông tin về các khách hàng đến lưu trú gồm các thông tin sau:
//     Mã khách hàng, tự động tăng tính từ KH01
//     Họ và tên
//     Mã phòng (dãy ký tự)
//     Ngày đến
//     Ngày đi
// Hãy nhập thông tin lưu trú từ file KHACH.in và sắp xếp theo số ngày lưu trú giảm dần.
// Dữ liệu đảm bảo không có hai khách hàng nào có cùng số ngày lưu trú.
// Input : KHACH.in
//     Dòng đầu ghi số lượng khách hàng
//     Mỗi khách hàng ghi trên 4 dòng gồm: họ tên, mã phòng, ngày đến, ngày đi.
// Output
//     Ghi ra danh sách khách hàng sắp xếp theo thứ tự số ngày lưu trú giảm dần.
//     Các thông tin cần liệt kê gồm:
//         Mã khách hàng
//         Họ tên
//         Mã phòng
//         Số ngày lưu trú
//     Chú ý: nếu ngày đến và đi là bằng nhau thì số ngày lưu trú bằng 0
// Ví dụ
// Input : KHACH.in
//     2
//     Nguyen Van Hoang
//     55B1
//     01/01/2021
//     05/01/2021
//     Nguyen Trung Dung
//     04C6
//     01/01/2021
//     10/01/2021
// Output
//     KH02 Nguyen Trung Dung 04C6 9
//     KH01 Nguyen Van Hoang 55B1 4

// ptit/Customer.java
package com.example.ptit;

public class Customer implements Comparable<Customer> {

    public static int NUM_CUSTOMER = 1;
    private String id, name, roomId;
    private Long duration;

    public Customer(String name, String roomId, Long duration) {
        this.id = "KH" + String.format("%02d", NUM_CUSTOMER++);
        this.name = name;
        this.roomId = roomId;
        this.duration = duration;
    }

    public Long getDuration() {
        return duration;
    }

    @Override
    public String toString() {
        return id + " " + name + " " + roomId + " " + duration;
    }

    @Override
    public int compareTo(Customer other) {
        return -duration.compareTo(other.getDuration());
    }
}

// ptit/Main.java
package com.example.ptit;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException, ParseException {
        Scanner sc = new Scanner(new File("KHACH.in"));
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        int n = Integer.parseInt(sc.nextLine());
        List<Customer> ds = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String name = sc.nextLine();
            String roomId = sc.nextLine();
            Date startDay = sdf.parse(sc.nextLine());
            Date lastDay = sdf.parse(sc.nextLine());
            Long duration = (lastDay.getTime() - startDay.getTime()) / (1000L * 60 * 60 * 24); // convert second -> day
            ds.add(new Customer(name, roomId, duration));
        }
        Collections.sort(ds);
        ds.forEach(System.out::println);
    }
}

// Khách sạn XYZ có đơn giá (theo ngày) được quy định khác nhau theo từng tầng. 
// Khách hàng đến thuê phòng sẽ được tính tổng số tiền ở theo đơn giá cộng thêm chi phí dịch vụ phát sinh nếu có.

//         ĐƠN GIÁ THEO TẦNG
//         TẦNG    1   2   3   4
//         GIÁ     25  34  50  80

// Hãy giúp khách sạn tính tiền phải trả cho từng khách hàng và sắp xếp theo thứ tự tổng tiền giảm dần.
// Input - file KHACHHANG.in
//     Dòng đầu ghi số khách hàng (không quá 50)
//     Mỗi khách hàng ghi trên 4 dòng gồm:
//         Tên khách hàng (xâu ký tự độ dài không quá 100, có thể chưa chuẩn)
//         Số phòng
//         Ngày nhận phòng (có thể chưa đúng định dạng dd/mm/yyyy)
//         Ngày trả phòng (có thể chưa đúng định dạng dd/mm/yyyy)
//         Tiền dịch vụ phát sinh (số nguyên dương nhỏ hơn 100)
// Output
//     Ghi ra danh sách đã được sắp xếp theo tổng tiền giảm dần bao gồm lần lượt các thông tin:
//         Mã khách hàng (tự động tăng theo thứ tự nhập, tính từ KH01)
//         Tên khách hàng - đã được chuẩn hóa
//         Số phòng
//         Số ngày ở
//         Thành tiền
// Ví dụ
// Input - KHACHHANG.in
//     3
//     Huynh VAN Thanh   
//     103 
//     5/6/2010   
//     5/6/2010   
//     15
//     le   DUC cong  
//     106 
//     08/3/2010   
//     1/5/2010   
//     220
//     Tran Thi Bich Tuyen   
//     207 
//     10/4/2010   
//     21/4/2010   
//     96
// Output
//     KH02 Le Duc Cong 106 55 1595
//     KH03 Tran Thi Bich Tuyen 207 12 504
//     KH01 Huynh Van Thanh 103 1 40

// ptit/Customer.java
package com.example.ptit;
import java.util.*;

public class Customer implements Comparable<Customer> {
    public static int NUM_ID = 1;
    private String id, name, roomId;
    private int timeByDay, price, totalCost;

    public Customer(String name, String roomId, Date checkInDate, Date checkOutDate, int serviceFee) {
        this.id = String.format("KH%02d", NUM_ID++);
        this.name = normalizeName(name);
        this.roomId = roomId;
        switch (roomId.substring(0, 1)) {
            case "1":
                price = 25;
                break;
            case "2":
                price = 34;
                break;
            case "3":
                price = 50;
                break;
            case "4":
                price = 80;
                break;
        }
        this.timeByDay = calculateTime(checkInDate, checkOutDate);
        this.totalCost = price * timeByDay + serviceFee;
    }

    private String normalizeName(String s) {
        String[] words = s.split("\\s+");
        String res = "";
        for (int i = 0; i < words.length; i++) {
            res += words[i].substring(0, 1).toUpperCase() + words[i].substring(1).toLowerCase();
            if (i != words.length - 1) {
                res += " ";
            }
        }
        return res;
    }

    private int calculateTime(Date checkIn, Date checkOut) {
        long in = checkIn.getTime();
        long out = checkOut.getTime();
        return (int) ((out - in) / (1000 * 60 * 60 * 24)) + 1;
    }

    public Integer getTotalCost() {
        return totalCost;
    }

    @Override
    public String toString() {
        return id + " " + name + " " + roomId + " " + timeByDay + " " + totalCost;
    }

    @Override
    public int compareTo(Customer other) {
        return -(this.getTotalCost().compareTo(other.getTotalCost()));
    }
}

// ptit/Main.java
package com.example.ptit;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws FileNotFoundException, ParseException {
        Scanner sc = new Scanner(new File("KHACHHANG.in"));
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        int n = Integer.parseInt(sc.nextLine());
        List<Customer> customers = new ArrayList<>();
        while (n-- > 0) {
            String name = sc.nextLine().trim();
            String roomId = sc.nextLine().trim();
            Date checkInDate = sdf.parse(sc.nextLine());
            Date checkOutDate = sdf.parse(sc.nextLine());
            int serviceFee = Integer.parseInt(sc.nextLine());
            Customer customer = new Customer(name, roomId, checkInDate, checkOutDate, serviceFee);
            customers.add(customer);
        }

        Collections.sort(customers);
        for (Customer customer : customers) {
            System.out.println(customer);
        }
    }
}

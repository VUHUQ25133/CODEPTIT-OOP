// Thông tin mặt hàng được mô tả gồm các thông tin: 
//     Mã hàng: tự động tăng, tính từ MH01
//     Tên hàng: xâu ký tự độ dài không quá 100
//     Nhóm hàng: xâu ký tự độ dài không quá 50
//     Giá mua: số thực
//     Giá bán: số thực
// Hãy nhập thông tin khách hàng từ file văn bản MATHANG.in sắp xếp theo lợi nhuận giảm dần. 
// Input - MATHANG.in
//     Dòng đầu chứa số mặt hàng. Mỗi mặt hàng viết trên 4 dòng: Dòng 1: Tên mặt hàng. Dòng 2: Nhóm hàng. Dòng 3: Giá mua. Dòng 4: Giá bán
// Output
//     Ghi ra danh sách mặt hàng đã sắp xếp theo lợi nhuận giảm dần (lợi nhuận tính bằng giá bán trừ đi giá mua).
//     Mỗi mặt hàng viết trên một dòng gồm: mã, tên, nhóm hàng và lợi nhuận (với 2 chữ số sau dấu phẩy).
//     Các thông tin cách nhau đúng 1 khoảng trống.
// Ví dụ:
// Input - MATHANG.in	
//     3
//     May tinh SONY VAIO
//     Dien tu
//     16400
//     17699
//     Tu lanh Side by Side
//     Dien lanh
//     18300
//     25999
//     Banh Chocopie
//     Tieu dung
//     27.5
//     37
// Output
//     MH02 Tu lanh Side by Side Dien lanh 7699.00
//     MH01 May tinh SONY VAIO Dien tu 1299.00
//     MH03 Banh Chocopie Tieu dung 9.50

// ptit/Item.java
package com.example.ptit;

public class Item implements Comparable<Item> {

    public static int NUM_ITEM = 1;
    private String id, name, type;
    private Float cost, price, profit;

    public Item(String name, String type, Float cost, Float price) {
        this.id = "MH" + String.format("%02d", NUM_ITEM++);
        this.name = name;
        this.type = type;
        this.cost = cost;
        this.price = price;
        this.profit = price - cost;
    }

    public float getProfit() {
        return profit;
    }

    @Override
    public String toString() {
        return id + " " + name + " " + type + " " + String.format("%.2f", profit);
    }

    @Override
    public int compareTo(Item other) {
        return -profit.compareTo(other.getProfit());
    }
}

// ptit/Main.java
package com.example.ptit;


import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("MATHANG.in"));
        int n = Integer.parseInt(sc.nextLine());
        Item[] items = new Item[n];
        for (int i = 0; i < n; i++) {
            String name = sc.nextLine();
            String type = sc.nextLine();
            Float cost = Float.parseFloat(sc.nextLine());
            Float price = Float.parseFloat(sc.nextLine());
            items[i] = new Item(name, type, cost, price);
        }
        Arrays.sort(items);
        for (Item i : items) {
            System.out.println(i);
        }
    }
}


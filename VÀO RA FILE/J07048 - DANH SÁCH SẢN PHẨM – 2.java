// Cửa hàng bán sản phẩm điện máy, công cụ cơ khí mô tả thông tin mỗi sản phẩm gồm các thông tin:
//     Mã sản phẩm
//     Tên sản phẩm
//     Giá bán (USD)
//     Thời hạn bảo hành (tính theo tháng).
// Hãy nhập thông tin sản phẩm và in danh sách sắp xếp theo giá bán giảm dần. Nếu giá bán bằng nhau thì sắp theo mã sản phẩm (thứ tự từ điển)
// Input - file SANPHAM.in
//     Dòng đầu ghi số sản phẩm.
//     Mỗi sản phẩm ghi trên 4 dòng lần lượt là mã, tên, giá bán, thời hạn.
// Output
//     Ghi ra danh sách sắp xếp theo yêu cầu. Mỗi sản phẩm ghi trên một dòng với đầy đủ: mã, tên, giá bán, thời hạn.
// Ví dụ
// Input - file SANPHAM.in
//     2
//     KC740
//     May khoan KC1
//     39
//     18
//     KC742
//     May cat KC2
//     46
//     12
// Output
//     KC742 May cat KC2 46 12
//     KC740 May khoan KC1 39 18

// ptit/Main.java
package com.example.ptit;


import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("SANPHAM.in"));
        int n = Integer.parseInt(sc.nextLine());
        Product[] products = new Product[n];
        for (int i = 0; i < n; i++) {
            String id = sc.nextLine();
            String name = sc.nextLine();
            int price = Integer.parseInt(sc.nextLine());
            int warrantyPeriod = Integer.parseInt(sc.nextLine());
            products[i] = new Product(id, name, price, warrantyPeriod);
        }
        Arrays.sort(products);
        for (Product item : products) {
            System.out.println(item);
        }
    }
}

// ptit/Product.java
package com.example.ptit;

public class Product implements Comparable<Product> {

    private String id, name;
    private int price, warrantyPeriod;

    public Product(String id, String name, int price, int warrantyPeriod) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.warrantyPeriod = warrantyPeriod;
    }

    public String getId() {
        return id;
    }

    public int getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return id + " " + name + " " + price + " " + warrantyPeriod;
    }

    @Override
    public int compareTo(Product other) {
        if (this.price == other.getPrice()) {
            return id.compareTo(other.getId());
        }
        return -(this.price - other.getPrice());
    }
}


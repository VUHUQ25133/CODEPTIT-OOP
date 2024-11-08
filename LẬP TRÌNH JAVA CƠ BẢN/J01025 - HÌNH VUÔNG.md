Cho 2 hình chữ nhật trên mặt phẳng Oxy. 
Cần tìm hình vuông có kích thước nhỏ nhất sao cho phủ kín được 2 hình chữ nhật đã cho.
**Input:**
2 dòng, mỗi dòng gồm 4 số nguyên lần lượt mô tả điểm trái dưới và phải trên của hình chữ nhật. 
Các tọa độ có giá trị tuyệt đối không vượt quá 1000.
**Output:**
In ra diện tích của hình vuông tìm được.

|Input|Output|
|-----|------|
|6 6 8 8
1 8 4 9|49|

```java
package com.example.ptit;

import java.util.*;

public class Main {
    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int[] x = new int[4];
        int[] y = new int[4];
        for (int i = 0; i < 4; i++) {
            x[i] = sc.nextInt();
            y[i] = sc.nextInt();
        }
        Arrays.sort(x);
        Arrays.sort(y);
        // tính khoảng cách lớn nhất giữa 2 điểm theo trục x hoặc y
        int a = Math.max(x[3] - x[0], y[3] - y[0]);
        System.out.println(a * a);
    }
}

```


Cho độ dài hai cạnh của hình chữ nhật. Giá trị không quá 1e4. 
Viết chương trình tính chu vi và diện tích của hình chữ nhật đó. 
Nếu dữ liệu không hợp lệ (chiều dài hoặc chiều rộng ≤ 0 thì in ra số 0) 

**Input:**
Có duy nhất một dòng ghi hai số nguyên, cách nhau một khoảng trống.

**Output:**
In kết quả trên một dòng, chu vi rồi đến diện tích, cách nhau một khoảng trống.

**Ví dụ**
|Input|Output|
|-----|------|
| 10 2| 24 20|

```java
package com.example.ptit;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        if (a <= 0 || b <= 0) System.out.println(0);
        else System.out.println(2*(a+b) + " " + a*b);
    }
}

```


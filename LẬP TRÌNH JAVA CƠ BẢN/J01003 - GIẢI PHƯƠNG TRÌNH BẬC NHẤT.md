Phương trình bậc nhất là phương trình dạng *ax + b = 0*.
Viết chương trình nhập vào hệ số a,b là các số thực và thực hiện giải phương trình bậc nhất.

- Nếu phương trình vô nghiệm thì in ra **VN**
- Nếu phương trình có vô số nghiệm thì in ra **VSN**
- Nếu phương trình có nghiệm duy nhất thì in ra với định dạng luôn 2 chữ số thập phân. 

**Input:**
- 2 số thực a, b

**Output:**
- Ghi kết quả.

**Ví dụ**
|Input|Output|
|-----|------|
| 2 -1| 0.50 |

```java
package com.example.ptit;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        float a = sc.nextFloat();
        float b = sc.nextFloat();
        if (a == 0f) {
            if (b == 0f) {
                System.out.println("VSN");
            } else {
                System.out.println("VN");
            }
        } else {
            System.out.println(String.format("%.2f", -b / a));
        }
    }
}

```


Cho số nguyên dương N có không quá 18 chữ số. Hãy đếm xem số chữ số 4 cộng với số chữ số 7 trong N có phải bằng 4 hay bằng 7 hay không.
**Input:** Chỉ có số N
**Output:** Ghi ra YES hoặc NO tùy thuộc kết quả kiểm tra

```java
package com.example.ptit;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        Set<Character> filter = new HashSet<>(Arrays.asList('4', '7'));
        long len = s.chars().filter(c -> filter.contains((char) c)).count();
        if (len == 4 || len == 7) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}

```


Cho một biểu thức trong phạm vi hai chữ số với các phép toán cộng trừ nhân chia. 
Các toán hạng và kết quả đảm bảo là số nguyên dương có hai chữ số, nếu có phép chia thì phải thỏa mãn tính chia hết.
Người ta có thể ẩn đi một số chữ số hoặc phép toán bằng cách điền dấu chấm hỏi (?). 
Nhiệm vụ của bạn là khôi phục các dấu chấm hỏi và in ra phép toán chính xác ban đầu. Nếu không thể có kết quả đúng thì ghi ra WRONG PROBLEM!
**Dữ liệu vào**
Dòng đầu ghi số bộ test T (1 ≤ T ≤ 100).
T dòng tiếp theo, mỗi dòng là một biểu thức có thể có các dấu ?.
Dữ liệu vào đảm bảo chỉ có duy nhất một kết quả đúng hoặc không thể có kết quả đúng.
**Kết quả**
Với mỗi bộ test, ghi ra biểu thức đúng tìm được. Hoặc WRONG PROBLEM!

|Input|Output|
|-----|------|
|2||
|?0 ? 12 = 28|40 - 12 = 28|
|40 / ?3 = ??|WRONG PROBLEM!|
```java
package com.example.ptit;

import java.util.Scanner;

public class Main {
    public static String exp;
    public static boolean hasAnswer;
    public static char[] signs = {'+', '-'};

    public static boolean isValid() {
        int a = Integer.parseInt(exp.substring(0, 2));
        int b = Integer.parseInt(exp.substring(5, 7));
        int c = Integer.parseInt(exp.substring(10));

        if (a < 10 || b < 10 || c < 10) {
            return false;
        }

        if (exp.charAt(3) == '+') {
            return a + b == c;
        } else {
            return a - b == c;
        }
    }

    public static String changeChar(String src, int index, char expect) {
        return src.substring(0, index) + expect + src.substring(index + 1);
    }

    public static void Try(int index) {
        if (hasAnswer) {
            return;
        }

        if (index == exp.length()) {
            if (isValid()) {
                hasAnswer = true;
                System.out.println(exp);
            }
            return;
        }

        if (exp.charAt(index) == '?') {
            if (index == 3) {
                for (int i = 0; i < 2; i++) {
                    exp = changeChar(exp, index, signs[i]);
                    Try(index + 1);
                }
            } else {
                for (int i = '0'; i <= '9'; i++) {
                    exp = changeChar(exp, index, (char) (i));
                    Try(index + 1);
                }
            }
            exp = changeChar(exp, index, '?');
        } else {
            Try(index + 1);
        }
    }

    public static void testCase() {
        // không tồn tại phép nhân hay chia giữa 2 số có 2 cs mà ra kqua là 1 số có 2 cs
        for (int i = 0; i < exp.length(); i++) {
            if (exp.charAt(i) == '*' || exp.charAt(i) == '/') {
                System.out.println("WRONG PROBLEM!");
                return;
            }
        }

        hasAnswer = false;
        Try(0);

        if (!hasAnswer) {
            System.out.println("WRONG PROBLEM!");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = Integer.parseInt(sc.nextLine());
        while (T-- > 0) {
            exp = sc.nextLine();
            testCase();
        }
    }
}
```


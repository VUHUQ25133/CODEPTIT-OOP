// Thông tin về mỗi môn học bao gồm:
//     Mã môn (không quá 10 ký tự)
//     Tên môn (không quá 100 ký tự)
//     Số tín chỉ: giá trị số nguyên dương không quá 6.
// Viết chương trình nhập danh sách môn học và in ra danh sách đã sắp xếp theo tên môn (thứ tự từ điển).
// Input: file MONHOC.in
//     Dòng đầu ghi số N là số môn học. Mỗi môn học ghi trên 3 dòng lần lượt là mã, tên và số tín chỉ
// Output
//     Ghi ra danh sách đã sắp xếp theo tên môn, mỗi môn trên một dòng. Các thông tin cách nhau một khoảng trống.
// Ví dụ
// MONHOC.in
//     2
//     INT1155
//     Tin hoc co so 2
//     2
//     SKD1103
//     Ky nang tao lap Van ban
//     1
// Output    
//     SKD1103 Ky nang tao lap Van ban 1
//     INT1155 Tin hoc co so 2 2


// ptit/Main.java
package com.example.ptit;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("MONHOC.in"));
        int n = Integer.parseInt(sc.nextLine());
        Subject[] subjects = new Subject[n];
        for (int i = 0; i < n; i++) {
            String id = sc.nextLine();
            String name = sc.nextLine();
            int stc = Integer.parseInt(sc.nextLine());
            subjects[i] = new Subject(id, name, stc);
        }
        Arrays.sort(subjects);
        for (Subject i : subjects) {
            System.out.println(i);
        }
    }
}

// ptit/Subject.java
package com.example.ptit;

public class Subject implements Comparable<Subject> {

    private String id, name;
    private int stc;

    public Subject(String id, String name, int stc) {
        this.id = id;
        this.name = name;
        this.stc = stc;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return id + " " + name + " " + stc;
    }

    @Override
    public int compareTo(Subject o) {
        return name.compareTo(o.getName());
    }
}

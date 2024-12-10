package com.example.ptit;
import java.io.*;
import java.util.*;
import java.math.*;
import java.text.*;


import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // Tạo đối tượng đọc file
        BufferedReader br = new BufferedReader(new FileReader("DATA.in"));
        String line;
        long sum = 0;

        // Đọc từng dòng trong file
        while ((line = br.readLine()) != null) {
            // Tách chuỗi thành các từ, sử dụng dấu cách làm dấu phân cách
            String[] tokens = line.split("\\s+");

            for (String token : tokens) {
                try {// Kiểm tra nếu chuỗi là số
                    long number = Long.parseLong(token);
                    if (number > Integer.MAX_VALUE) {
                        sum += number;
                    }
                } catch (NumberFormatException e) {
                    // Nếu không phải là số, bỏ qua
                }
            }
        }
        System.out.println(sum);

        br.close();
    }
}

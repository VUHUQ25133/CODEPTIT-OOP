package com.example.ptit;
import java.io.*;
import java.util.*;
import java.math.*;
import java.text.*;


import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        // Đọc dữ liệu từ file nhị phân
        FileInputStream fis = new FileInputStream("DATA.in");
        ObjectInputStream ois = new ObjectInputStream(fis);

        ArrayList<String> dataList = (ArrayList<String>) ois.readObject();
        Set<Integer> result = new TreeSet<>();

        for (String line : dataList) {
            String[] words = line.split("\\s+");

            for (String word : words) {
                try {
                    int number = Integer.parseInt(word);
                    result.add(number);
                } catch (NumberFormatException e) {
                    // Nếu không phải số nguyên thì bỏ qua
                }
            }
        }
        for (int num : result) {
            System.out.println(num);
        }
        ois.close();
        fis.close();
    }
}

package com.example.ptit;
import java.io.*;
import java.util.*;


class Time implements Comparable<Time> {
    int hour, minute, second;

    public Time(int hour, int minute, int second) {
        this.hour = hour;
        this.minute = minute;
        this.second = second;
    }

    // So sánh theo thứ tự tăng dần
    @Override
    public int compareTo(Time other) {
        if (this.hour != other.hour) {
            return this.hour - other.hour;
        }
        if (this.minute != other.minute) {
            return this.minute - other.minute;
        }
        return this.second - other.second;
    }

    @Override
    public String toString() {
        return hour + " " + minute + " " + second;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        // Đọc dữ liệu đầu vào
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine().trim());

        List<Time> times = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String[] parts = br.readLine().trim().split("\\s+");
            int hour = Integer.parseInt(parts[0]);
            int minute = Integer.parseInt(parts[1]);
            int second = Integer.parseInt(parts[2]);
            times.add(new Time(hour, minute, second));
        }

        // Sắp xếp danh sách
        Collections.sort(times);

        // In kết quả
        for (Time time : times) {
            System.out.println(time);
        }
    }
}

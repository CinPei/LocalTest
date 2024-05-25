package com.cin.interview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class huaweiOD {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        String[] strings = line.split(" ");

        int count = 0;
        for (String s : strings) {
            count += Integer.parseInt(s);
        }

        int[] corrects = new int[strings.length];
        int number = 1;
        while (count > 0) {

            for (int i = 0; i < corrects.length; i++) {
                if ((number + "").contains("7") || number % 7 == 0) {
                    corrects[i]++;
                    count--;
                }
                if (count == 0) {
                    break;
                }
                number++;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int correct : corrects) {
            sb.append(correct).append(" ");
        }

        System.out.println(sb.toString().trim());

        ArrayList<Integer> integers = new ArrayList<>();
        integers.add(number);
        while (true) {
            number++;
            if ((number + "").contains("7") || number % 7 == 0) break;
            integers.add(number);
        }
    }
}

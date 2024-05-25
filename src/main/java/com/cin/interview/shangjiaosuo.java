package com.cin.interview;

import java.util.Arrays;
import java.util.Comparator;

public class shangjiaosuo {

    public static void main(String[] args) {
        int[][] input = new int[][]{{2,3,5},{3,4,5},{2,6,7},{2,2,3}};
        int box = box(input);
        System.out.println(box);
    }
    public static int box(int[][] box) {

        Arrays.sort(box, (a, b) -> a[0] - b[0]);
        int result = 1;
        for (int i = 1; i < box.length; i++) {
            for (int j = 0; j < i; j++) {
                if (box[i][0] > box[j][0] && box[i][1] > box[j][1] && box[i][2] > box[j][2]) {
                    result++;
                    break;
                }
            }
        }
        return result;
    }
}

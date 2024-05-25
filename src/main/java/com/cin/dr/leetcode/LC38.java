package com.cin.dr.leetcode;

public class LC38 {
    public static void main(String[] args) {
        System.out.println(countAndSay(4));
    }

    public static String countAndSay(int n) {
        return test("1", n);
    }

    private static String test(String str, int n) {
        if (n == 1) {
            return str;
        }
        int length = str.length();
        int count = 1;
        int cursor = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < length; i++) {
            if (str.charAt(i) != str.charAt(i - 1)) {
                sb.append(count).append(str.charAt(i - 1));
                count = 1;
            } else {
                count++;
            }
        }
        sb.append(count).append(str.charAt(length-1));
        return test(sb.toString(), n - 1);
    }

}

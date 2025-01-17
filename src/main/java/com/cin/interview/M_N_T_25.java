package com.cin.interview;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * 标题：英文输入法 | 时间限制：1秒 | 内存限制：262144K | 语言限制：不限
 * 主管期望你来实现英文输入法单词联想功能。需求如下：
 * 依据用户输入的单词前缀，从已输入的英文语句中联想出用户想输入的单词，按字典序输出联想到的单词序列，如果联想不到，请输出用户输入的单词前缀。
 * 注意：
 * 1. 英文单词联想时，区分大小写
 * 2. 缩略形式如”don't”，判定为两个单词，”don”和”t”
 * 3. 输出的单词序列，不能有重复单词，且只能是英文单词，不能有标点符号
 * 输入描述: 输入为两行。首行输入一段由英文单词word和标点符号组成的语句str； 接下来一行为一个英文单词前缀pre。 0 < word.length() <= 20 0 < str.length <= 10000 0 < pre <= 20
 * 输出描述: 输出符合要求的单词序列或单词前缀，存在多个时，单词之间以单个空格分割
 * 示例1
 * 输入
 * I love you
 * He
 * 输出
 * He
 * 说明
 * 从用户已输入英文语句”I love you”中提炼出“I”、“love”、“you”三个单词，接下来用户输入“He”，从已输入信息中无法联想到任何符合要求的单词，因此输出用户输入的单词前缀。
 * 示例2
 * 输入
 * The furthest distance in the world, Is not between life and death, But when I stand in front of you, Yet you don't know that I love you.
 * f
 * 输出
 * front furthest
 * 说明
 * 从用户已输入英文语句”The furthestdistance in the world, Is not between life and death, But when I stand in frontof you, Yet you dont know that I love you.”中提炼出的单词，
 * 符合“f”作为前缀的，有“furthest”和“front”，按字典序排序并在单词间添加空格后输出，结果为“frontfurthest”。
 */
public class M_N_T_25 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        char[] chars = line.toCharArray();
        ArrayList<String> strings = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < chars.length; i++) {
            char aChar = chars[i];
            if ((65 <= aChar && aChar <= 90) || (97 <= aChar && aChar <= 122)) {
                sb.append(aChar);
                if (i == chars.length - 1) {
                    strings.add(sb.toString());
                }
            } else {
                if (i != 0 && (65 <= chars[i - 1] && chars[i - 1] <= 90) || (97 <= chars[i - 1] && chars[i - 1] <= 122)) {
                    strings.add(sb.toString());
                    sb.setLength(0);
                }
            }
        }

        String inputStr = scanner.nextLine();

        ArrayList<String> lianxiangs = new ArrayList<>();
        for (int i = 0; i < strings.size(); i++) {
            String str = strings.get(i);
            if (str.length() < inputStr.length()) {
                continue;
            }
            boolean isMatch = true;
            for (int j = 0; j < inputStr.length(); j++) {
                if (inputStr.charAt(j) != str.charAt(j)) {
                    isMatch = false;
                    break;
                }
            }

            if (isMatch) {
                lianxiangs.add(str);
            }
        }

        if (lianxiangs.size() == 0) {
            System.out.println(inputStr);
            return;
        }

        // 排序
        List<String> stringList = lianxiangs.stream().distinct().sorted((o1, o2) -> {
            for (int i = inputStr.length(); i < Math.min(o1.length(), o2.length()); i++) {
                if (o1.charAt(i) != o2.charAt(i)) {
                    return o1.charAt(i) - o2.charAt(i);
                }
            }
            return o1.length() < o2.length() ? -1 : 1;
        }).collect(Collectors.toList());
        for (int i = 0; i < stringList.size(); i++) {
            if (i == stringList.size() - 1) {
                System.out.println(stringList.get(i));
                break;
            }
            System.out.print(stringList.get(i) + " ");
        }
    }
}

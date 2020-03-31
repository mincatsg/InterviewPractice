package BigBig;

import java.util.Scanner;

public class test31 {
    //编一个程序，从 string 对象中去掉标点符号。
    // 要求输入到程序的字符串必须含 有标点符号，输出结果则是去掉标点符号后的 string 对象

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        char[] chars = str.toCharArray();
        String newStr = "";
        for (int i= 0; i < chars.length; i++) {
            if ((chars[i] >= 65 && chars[i] <= 90) || (chars[i] >= 97 && chars[i] <= 122) || (chars[i] >='0' && chars[i] <='9') || chars[i] == ' ') {
                newStr = newStr + chars[i];
            }
        }
        System.out.println("Enter a string:");
        if (str.equals(newStr)) {
            System.out.println("No punctuation character in the string?!");
        } else {
            System.out.println("Result:");
            System.out.println(newStr);
        }
    }
}
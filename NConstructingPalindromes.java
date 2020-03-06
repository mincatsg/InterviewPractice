package NKTest;

import java.util.Scanner;

public class NConstructingPalindromes {

//    构造回文
//
//    给定一个字符串s，你可以从中删除一些字符，使得剩下的串是一个回文串。如何删除才能使得回文串最长呢？
//    输出需要删除的字符个数。

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);

        //反转字符串,与开始字符串找最大公共序列,找到最大值就是回文数值,用字符串长度减去最大值即可
        while(in.hasNextLine()){
            String line = in.nextLine();
            String reverse = "";
            int len = line.length();
            for(int i = len - 1; i >= 0; i--){
                reverse += line.charAt(i);
            }
            int[][] dp = new int[len + 1][len + 1];
            for(int i = 1; i <= len; i++){
                for(int j = 1; j <= len; j++){
                    if(line.charAt(i - 1) == reverse.charAt(j - 1)){
                        dp[i][j] = dp[i - 1][j - 1] + 1;
                    }else{
                        dp[i][j] = Math.max(dp[i][j - 1], dp[i -1][j]);
                    }
                }
            }
            System.out.println( len - dp[len][len]);
        }
    }
}

package InterviewTraining2;

public class LongestCommon {
//    最长公共子序列
//    给定两个字符串 text1 和 text2，返回这两个字符串的最长公共子序列。
//
//    一个字符串的 子序列 是指这样一个新的字符串：它是由原字符串在不改变字符的相对顺序的情况下删除某些字符
//    （也可以不删除任何字符）后组成的新字符串。
//    例如，"ace" 是 "abcde" 的子序列，但 "aec" 不是 "abcde" 的子序列。
//    两个字符串的「公共子序列」是这两个字符串所共同拥有的子序列。
//
//    若这两个字符串没有公共子序列，则返回 0。


    public int longestCommonSubsequence(String text1, String text2) {
       int text1len = text1.length();
       int text2len = text2.length();
        //头一列头一行肯定为 0  "" 与 非空肯定无子序列
       int[][] dp = new int[text1len + 1][text2len + 1];
       for(int i = 1; i <= text1len; i++){
          for(int j = 1; j <= text2len; j++){
              if(text1.charAt(i - 1) == text2.charAt(j - 1)){
                  dp[i][j] = dp[i - 1][j - 1] + 1;
              }else{
                  dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
              }
          }
       }
       return dp[text1len][text2len];
    }
}
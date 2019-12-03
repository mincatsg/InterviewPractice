package InterviewTraining;

import java.util.Arrays;
import java.util.Stack;

public class Demon7 {
//   一.“气球” 的最大数量
//    给你一个字符串 text，你需要使用 text 中的字母来拼凑尽可能多的单词 "balloon"（气球）。
//
//    字符串 text 中的每个字母最多只能被使用一次。请你返回最多可以拼凑出多少个单词 "balloon"。
//
//    输入：text = "nlaebolko"
//    输出：1

    public int maxNumberOfBalloons(String text) {
        int[] arr = new int[5];
        //去统计字符串里有多少b,a,l,o,n.
        for(int i = 0; i < text.length(); i++){
            char s = text.charAt(i);
            if(s == 'b'){
                arr[0]++;
            }
            else if(s == 'a'){
                arr[1]++;
            }
            else if(s == 'l'){
                arr[2]++;
            }
            else if(s == 'o'){
                arr[3]++;
            }
            else if(s == 'n'){
                arr[4]++;
            }
        }

        //去判断最小的数,去返回他.
        arr[2] = arr[2] / 2;
        arr[3] = arr[3] / 2;
        Arrays.sort(arr);
        return arr[0];
    }
//    二.反转每对括号间的子串
//
//    给出一个字符串 s（仅含有小写英文字母和括号）。
//
//    请你按照从括号内到外的顺序，逐层反转每对匹配括号中的字符串，并返回最终的结果。
//
//    注意，您的结果中 不应 包含任何括号。
//
//    输入：s = "(ed(et(oc))el)"
//    输出："leetcode"

    public String reverseParentheses(String s) {
        Stack<Integer> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        char[] arr = s.toCharArray();

        //遍历字符数组,遇见左括号就入栈,右括号就出来翻转,用栈记住前一个左括号的下标.
        for(int i = 0; i < arr.length; i++){
            if(arr[i] == '('){
                stack.push(i);
            }
            if(arr[i] == ')'){
                reserve(arr, stack.pop(), i);
            }
        }
        //不是括号就添加
        for(int i = 0; i < arr.length; i++){
            if(arr[i] != '(' && arr[i] != ')'){
                sb.append(arr[i]);
            }
        }
        return sb.toString();
    }
    //翻转
    public void reserve(char[] arr, int left, int right){
        while(left < right){
            char tem = arr[left];
            arr[left] = arr[right];
            arr[right] = tem;
            left++;
            right--;
        }
    }
}

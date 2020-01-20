import java.util.Stack;

public class test14 {
    //给定一个字符串 S，返回 “反转后的” 字符串，其中不是字母的字符都保留在原地，而所有字母的位置发生反转。
    public String reverseOnlyLetters(String S) {
        //字母大写65 ~ 90 小写97 ~ 122.
        Stack<Character> stack = new Stack<>();
        for(char c : S.toCharArray()){  //是字母就入栈
            if(Character.isLetter(c)){  //这函数判断是否是字母
                stack.push(c);
            }
        }
        StringBuilder ans = new StringBuilder();
        for(char c : S.toCharArray()){
            if(Character.isLetter(c)){
                ans.append(stack.pop());
            }else{
                ans.append(c);
            }
        }

        return ans.toString();
    }
}

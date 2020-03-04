package NKTest;
import java.util.Stack;

public class NLegalParenthesis {
    //合法序列括号判断

    public boolean chkParenthesis(String A, int n) {
        Stack<Character> stack = new Stack<>();
        boolean jude = false; //判断左括号开启,可以向里加字母,遇到右括号关闭.
        for(int i = 0; i < n; i++){
            char c = A.charAt(i);
            if(c == '('){
                stack.push(c);
                jude = true;  //开启状态
            }else if(c == ')'){
                if(stack.isEmpty()){
                    return false;
                }
                stack.pop();
                jude = false;  //关闭状态
            }
            else{
                if(!jude){  //状态外直接返回。
                    return false;
                }
            }
        }
        return (stack.isEmpty())? true : false;
    }
}

package InterviewTraining;

import java.util.LinkedList;

public class RemoveDigits {
//    给定一个以字符串表示的非负整数 num，移除这个数中的 k 位数字，使得剩下的数字最小。
//
//    注意:
//
//    num 的长度小于 10002 且 ≥ k。
//    num 不会包含任何前导零。
public String removeKdigits(String num, int k) {
    LinkedList<Character> stack = new LinkedList<>();

    for(char x : num.toCharArray()){
        while(!stack.isEmpty() && k > 0 && stack.peekLast() > x){
            k--;
            stack.removeLast();
        }
        stack.addLast(x);
    }

    for(int i = 0; i < k; i++){
        stack.removeLast();
    }

    StringBuilder ans = new StringBuilder();
    boolean judge = true;
    for(char x : stack){
        if(judge == true && x == '0'){
            continue;
        }
        judge = false;
        ans.append(x);
    }
    if(ans.length() == 0) {
        return "0";
    }
    return ans.toString();
}

}

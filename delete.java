package Map;

import java.util.Stack;

public class delete {
//        给出由小写字母组成的字符串 S，重复项删除操作会选择两个相邻且相同的字母，并删除它们。
//
//        在 S 上反复执行重复项删除操作，直到无法继续删除。
//
//        在完成所有重复项删除操作后返回最终的字符串。答案保证唯一。
    public String removeDuplicates(String S) {
        if(S.length() == 1){
            return S;
        }
        Stack<Character> stack = new Stack<>();
        StringBuilder  ans = new StringBuilder();
        for(int i = 0; i < S.length(); i++){
            if(stack.isEmpty()){
                stack.push(S.charAt(i));
            }
            else if(S.charAt(i) == stack.peek()){
                stack.pop();
            }else{
                stack.push(S.charAt(i));
            }
        }
        while(!stack.isEmpty()){
            ans.append(stack.pop());
        }

        return ans.reverse().toString();
    }
}

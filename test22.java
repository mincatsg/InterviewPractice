import java.util.Stack;

public class test22 {
    //给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。

    public boolean isPalindrome(String s) {
        if(s == null || s.length() == 0 || s.length() == 1){
            return true;
        }
        s = s.toLowerCase();
        Stack<Character> stack = new Stack<>();
        for(char c : s.toCharArray()){
            if(Character.isLetter(c) || (c >= '0' && c <= '9')){
                stack.push(c);
            }
        }
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(Character.isLetter(c) || (c >= '0' && c <= '9')){
                if(c != stack.pop()){
                    return false;
                }
            }else{
                continue;
            }
        }

        return true;
    }
}

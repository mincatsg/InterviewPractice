package InterviewTraining;

import java.util.HashSet;
import java.util.Set;

public class InvertsVowels {
//    编写一个函数，以字符串作为输入，反转该字符串中的元音字母。
public String reverseVowels(String s) {
    int left = 0;
    int right = s.length() - 1;
    Set<Character> set = new HashSet<>();
    set.add('a');
    set.add('e');
    set.add('i');
    set.add('o');
    set.add('u');
    set.add('A');
    set.add('E');
    set.add('I');
    set.add('O');
    set.add('U');
    char[] arr = s.toCharArray();
    while(left < right){
        while(left < right && !set.contains(arr[left])){
            left++;
        }
        while(left < right && !set.contains(arr[right])){
            right--;
        }
        if(left < right){
            char tem = arr[left];
            arr[left] = arr[right];
            arr[right] = tem;
            left++;
            right--;
        }
    }
    String ss = "";
    for(char c : arr){
        ss = ss + c;
    }
    return ss;
}
}

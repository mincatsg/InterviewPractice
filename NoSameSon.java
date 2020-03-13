package InterviewTraining2;

import java.util.Set;

public class NoSameSon {
//    无重复字符的最长子串
//    给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
public int lengthOfLongestSubstring(String s) {
    int count = 0;
    for(int i = 0; i < s.length(); i++){
        Set<Character> set = new HashSet<>();
        for(int j = i; j < s.length(); j++){
            if(!set.contains(s.charAt(j))){
                set.add(s.charAt(j));
            }else{
                break;
            }
        }
        if(count < set.size()){
            count = set.size();
        }
    }
    return count;
}
}

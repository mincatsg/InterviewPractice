package InterviewTraining;

import java.util.ArrayList;
import java.util.List;

public class WordSubset {
//    我们给出两个单词数组 A 和 B。每个单词都是一串小写字母。
//
//    现在，如果 b 中的每个字母都出现在 a 中，包括重复出现的字母，那么称单词 b 是单词 a 的子集。 例如，“wrr” 是 “warrior” 的子集，但不是 “world” 的子集。
//
//    如果对 B 中的每一个单词 b，b 都是 a 的子集，那么我们称 A 中的单词 a 是通用的。
//
//    你可以按任意顺序以列表形式返回 A 中所有的通用单词。
public List<String> wordSubsets(String[] A, String[] B) {
    //遍历B字符串数组，将B中字符串出现次数统计一下,找每个字符出现最大值
    //再去遍历A字符串,统计字符出现次数,和B的统计字符次数比较。
    //所有大于则满足.
    int[] B1 = new int[26];
    for(int i = 0; i < B.length; i++){
        int[] A1 = new int[26];
        for(char x : B[i].toCharArray()){
            A1[x - 'a']++;
        }
        for(int j = 0; j < 26; j++){
            if(A1[j] > B1[j]){
                B1[j] = A1[j];
            }
        }
    }

    List<String> result = new ArrayList<>();
    for(int i = 0; i < A.length; i++){
        int[] A1 = new int[26];
        for(char x : A[i].toCharArray()){
            A1[x - 'a']++;
        }
        //检查这个字符串各个字符数是否满足B字符串组的.
        int j = 0;
        while(j < 26 && A1[j] >= B1[j]){
            j++;
        }
        if(j == 26){
            result.add(A[i]);
        }
    }
    return result;

}

}

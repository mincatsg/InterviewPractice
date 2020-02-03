package Map;

import java.util.*;

public class DifferChar {
//    给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。
public List<List<String>> groupAnagrams(String[] strs) {
    // List<List<String>> ans = new ArrayList<>();
    // int[] arr = new int[strs.length];
    // int[] sum = new int[strs.length];
    // for(int i = 0; i < strs.length; i++){
    //     for(int j = 0; j < strs[i].length(); j++){
    //         arr[i] += strs[i].charAt(j);
    //     }
    // }

    // for(int i = 0; i < arr.length; i++){
    //     if(sum[i] == 0){
    //     List<String> res = new ArrayList<>();
    //     res.add(strs[i]);
    //     sum[i] = 1;
    //       for(int j = i + 1; j < arr.length; j++){
    //         if(arr[i] == arr[j] && sum[j] != 1){
    //             res.add(strs[j]);
    //             sum[j] = 1;
    //         }
    //     }
    //     ans.add(res);
    //     }else{
    //         continue;
    //     }
    // }

    // return ans;
    if(strs.length == 0){
        return new ArrayList();
    }
    Map<String, List> map = new HashMap<String, List>();
    for(String s : strs){
        char[] ca = s.toCharArray();
        Arrays.sort(ca);
        String key = String.valueOf(ca);
        if(!map.containsKey(key)){
            map.put(key, new ArrayList());
        }
        map.get(key).add(s);
    }
    return new ArrayList(map.values());
}
}

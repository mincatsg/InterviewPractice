package InterviewTraining;

import java.util.HashMap;
import java.util.Map;

public class MajorityElements {
//    给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。
//
//    你可以假设数组是非空的，并且给定的数组总是存在多数元素。
public int majorityElement(int[] nums) {
    Map<Integer, Integer> map = new HashMap<>();
    for(int i = 0; i < nums.length; i++){
        int value = map.getOrDefault(nums[i], 0);
        map.put(nums[i], ++value);
    }
    for(Integer key : map.keySet()){
        if(map.get(key) > nums.length / 2){
            return key;
        }
    }
    return 0;
}
}

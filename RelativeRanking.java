package InterviewTraining;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class RelativeRanking {
//    给出 N 名运动员的成绩，找出他们的相对名次并授予前三名对应的奖牌。
//    前三名运动员将会被分别授予 “金牌”，“银牌” 和“ 铜牌”（"Gold Medal", "Silver Medal", "Bronze Medal"）。
//
//            (注：分数越高的选手，排名越靠前。)
public String[] findRelativeRanks(int[] nums) {
    String[] result = new String[nums.length];
    Map<Integer, Integer> map = new HashMap<>();
    for(int i = 0; i < nums.length; i++){
        map.put(nums[i], i);
    }
    Arrays.sort(nums);
    int count = 1;
    for(int i = nums.length - 1; i >= 0; i--){
        if(count == 1){
            result[map.get(nums[i])] = "Gold Medal";
        }
        else if(count == 2){
            result[map.get(nums[i])] =  "Silver Medal";
        }
        else if(count == 3){
            result[map.get(nums[i])] =  "Bronze Medal";
        }
        else{
            result[map.get(nums[i])] = "" + count;
        }
        count++;
    }
    return result;
}
}

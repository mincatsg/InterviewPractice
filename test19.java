import java.util.HashMap;
import java.util.Map;

public class test19 {
    //给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。

    public int[] twoSum(int[] nums, int target) {
        //  for(int i = 0; i < nums.length - 1; i++ ){
        //     for(int j = i + 1; j < nums.length; j++){
        //         if(nums[i] + nums[j] == target){
        //            return new int[]{i, j};
        //         }
        //     }
        // }
        //  throw new IllegalArgumentException("No two sum solution");

        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            int complement = target - nums[i];
            if(map.containsKey(complement)){
                return new int[]{map.get(complement), i};
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }
}

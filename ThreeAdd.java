package InterviewTraining2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeAdd {
//    三数之和
//给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？
//    找出所有满足条件且不重复的三元组。
//
//    注意：答案中不可以包含重复的三元组。

//给定数组 nums = [-1, 0, 1, 2, -1, -4]，
//
//    满足要求的三元组集合为：
//            [
//            [-1, 0, 1],
//            [-1, -1, 2]
//            ]

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        //如果数组为null或者数组长度小于3直接返回空集合。
        if(nums == null || nums.length < 3){
            return ans;
        }
        Arrays.sort(nums);
        //从开始遍历
        // 1.先看这个值是否大于0 大于0 没必要继续了,因为有序.
        // 2.选他的下一个和最后一个看和大小,大了肯定最后一个往前走, 小了 下一个往后走.并且排除重复数据.
        // 3.直至选到合适的.
        for(int i = 0; i < nums.length - 2; i++){
            if(nums[i] >= 0){
                break;
            }
            if(i > 0 && nums[i] == nums[i - 1]){
                continue;
            }
            int L = i + 1;
            int R = nums.length - 1;
            while(L < R){
                int sum = nums[L] + nums[R] + nums[i];
                if(sum == 0){
                    ans.add(Arrays.asList(nums[i], nums[L], nums[R]));
                    while(L < R && nums[L] == nums[L + 1]) L++;
                    while(L < R && nums[R] == nums[R - 1]) R--;
                    L++;
                    R--;
                }else if(sum > 0){
                    while(L < R && nums[R] == nums[R - 1]) R--;
                    R--;
                }else{
                    while(L < R && nums[L] == nums[L + 1]) L++;
                    L++;
                }
            }
        }
        return ans;
    }
}

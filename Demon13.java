import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Demon13 {
//    三数之和
public List<List<Integer>> threeSum(int[] nums) {
    List<List<Integer>> ans = new ArrayList<>();
    Arrays.sort(nums);
    if(nums.length < 3 || nums == null){
        return ans;
    }
    for(int i = 0; i < nums.length - 2; i++){
        if(nums[i] > 0) {break;}
        if(i > 0 && nums[i] == nums[i - 1]) {continue;}
        int L = i + 1;
        int R = nums.length - 1;
        while(L < R){
            int sum = nums[L] + nums[R] + nums[i];
            if(sum == 0){
                ans.add(Arrays.asList(nums[i],nums[L],nums[R]));  //给顺序表中加顺序表。
                while(L < R && nums[L] == nums[L + 1]) ++L;
                while(L < R && nums[R] == nums[R - 1]) --R;
                L++;
                R--;
            }
            else if(sum > 0){  //数太大了 R往前（也要判断重复）
                while(L < R && nums[R] == nums[R - 1]) --R;
                R--;
            }
            else if(sum < 0){ //数小了 L得往后 变大点（也要判重复）要不没有意义
                while(L < R && nums[L] == nums[L + 1]) ++L;
                L++;
            }
        }
    }
    return ans;
}







}

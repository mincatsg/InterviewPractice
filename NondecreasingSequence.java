package InterviewTraining;

public class NondecreasingSequence {
//    非递减数列
//    给定一个长度为 n 的整数数组，你的任务是判断在最多改变 1 个元素的情况下，该数组能否变成一个非递减数列。
//
//    我们是这样定义一个非递减数列的： 对于数组中所有的 i (1 <= i < n)，满足 array[i] <= array[i + 1]。

    public boolean checkPossibility(int[] nums) {
        int count = 0;
        for(int i = 0; i < nums.length - 1; i++){
            int tem = nums[i];
            //先和前一个对齐 ，不行就让后一个和他对齐
            if(nums[i] > nums[i + 1]){
                if(i >= 1){
                    nums[i] = nums[i - 1];
                }else{
                    nums[i] = nums[i + 1];
                }
                //判断前对齐满足不
                if(nums[i] > nums[i + 1]){
                    nums[i] = tem;
                    nums[i + 1] = nums[i];
                }
                count++;
                if(count == 2){
                    return false;
                }
            }
        }
        return true;
    }
}

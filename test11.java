public class test11 {

    //给定一个整数数组，判断是否存在重复元素。
    public boolean containsDuplicate(int[] nums) {
        for(int i = 0; i < nums.length; i++){
            for(int j = 0; j < i; j++){
                if(nums[i] == nums[j]){
                    return true;
                }
            }
        }
        return false;
    }
}

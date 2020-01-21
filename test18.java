public class test18 {
    //第三大的数
    public int thirdMax(int[] nums) {
        long first =  Long.MIN_VALUE,  second = Long.MIN_VALUE, third = Long.MIN_VALUE;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] > third){
                first = second;
                second = third;
                third = nums[i];
            }else if(nums[i] > second && nums[i] < third){
                first = second;
                second = nums[i];
            }else if(nums[i] > first && nums[i] < second){
                first = nums[i];
            }
        }
        return (first == Long.MIN_VALUE)? (int)third : (int)first;
    }
}

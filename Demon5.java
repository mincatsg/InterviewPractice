package InterviewTraining;

import java.util.HashMap;
import java.util.Map;

public class Demon5 {
//  一.玩筹码
//    数轴上放置了一些筹码，每个筹码的位置存在数组 chips 当中。
//
//    你可以对 任何筹码 执行下面两种操作之一（不限操作次数，0 次也可以）：
//
//    将第 i 个筹码向左或者右移动 2 个单位，代价为 0。
//    将第 i 个筹码向左或者右移动 1 个单位，代价为 1。
//    最开始的时候，同一位置上也可能放着两个或者更多的筹码。
//
//    返回将所有筹码移动到同一位置（任意位置）上所需要的最小代价。
//
//    输入：chips = [1,2,3]
//    输出：1
//    解释：第二个筹码移动到位置三的代价是 1，第一个筹码移动到位置三的代价是 0，总代价为 1。

    public int minCostToMoveChips(int[] chips) {
        //看奇数多还是偶数多,少的就是答案.
        //谁多选谁为基准就是移动2的代价,少的就是移动1的代价.
        int evenNumber = 0;  //偶数个数
        int oddNumber = 0;  //奇数个数
        for(int i = 0; i < chips.length; i++){
            if(chips[i] % 2 == 0){
                evenNumber++;
            }else{
                oddNumber++;
            }
        }
        return (evenNumber >= oddNumber)?  oddNumber:evenNumber;
    }

//    二.最长定差子序列
//
//    给你一个整数数组 arr 和一个整数 difference，
//    请你找出 arr 中所有相邻元素之间的差等于给定 difference 的等差子序列，并返回其中最长的等差子序列的长度。
//
//    输入：arr = [1,2,3,4], difference = 1
//    输出：4
//    解释：最长的等差子序列是 [1,2,3,4]。

    public int longestSubsequence(int[] arr, int difference) {
        int result = 1; //他每次都会多一个,提前加1.
        Map<Integer, Integer> map = new HashMap<>();
        for(int i : arr){
            int tem = map.getOrDefault(i - difference, 0) + 1;  //获取之前的存好的map值,没有就设置为1.有值就说明前面有一个满足的.获取到他的值 + 1存到这个map里,供下次遍历.
            map.put(i, tem);
            result = Math.max(result, tem);
        }

        return result;
    }

}

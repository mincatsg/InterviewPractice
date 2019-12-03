package InterviewTraining;

import java.util.*;

public class Demon6 {
//   一. 独一无二的出现次数
////    给你一个整数数组 arr，请你帮忙统计数组中每个数的出现次数。
////    如果每个数的出现次数都是独一无二的，就返回 true；否则返回 false。
////
////    输入：arr = [1,2,2,1,1,3]
////    输出：true
////    解释：在该数组中，1 出现了 3 次，2 出现了 2 次，3 只出现了 1 次。没有两个数的出现次数相同。

    public boolean uniqueOccurrences(int[] arr) {
        //创建一个哈希表,统计一下每个数字出现次数
        Map<Integer, Integer> map = new HashMap<>();
        //去判断是不是唯一的
        Set<Integer> set = new HashSet<>();
        //遍历数组,用map存值没出现过就先设为  1  出现过 原先次数 + 1.
        for(int x : arr){
            int tem = map.getOrDefault(x, 0) + 1;
            map.put(x, tem);
        }
        //遍历map存的次数
        for(Integer key : map.values()){
            //如果包含就返回false
            if(set.contains(key)){
                return false;
            }
            //不包含就加
            set.add(key);
        }
        return true;
    }

//  二.删除字符串中的所有相邻重复项
//
//    给出由小写字母组成的字符串 S，重复项删除操作会选择两个相邻且相同的字母，并删除它们。
//
//    在 S 上反复执行重复项删除操作，直到无法继续删除。
//
//    在完成所有重复项删除操作后返回最终的字符串。答案保证唯一。
//    输入："abbaca"
//    输出："ca"
//    解释：
//    例如，在 "abbaca" 中，我们可以删除 "bb" 由于两字母相邻且相同，这是此时唯一可以执行删除操作的重复项。之后我们得到字符串 "aaca"，
//    其中又只有 "aa" 可以执行重复项删除操作，所以最后的字符串为 "ca"。

    public String removeDuplicates(String S) {

        //  只需删除重复项即可，因此可以使用栈实现
        //   每次添加时比较是否与栈顶元素相同
        //     - 若相同则删除栈顶元素且不插入
        //    -   若不相同则插入新元素


        Stack<Character> stack = new Stack<>();
        char[] arr = S.toCharArray();

        for(int i = 0; i < arr.length; i++){
            //为空或者与栈中元素不相等就入栈
            if(stack.isEmpty() || arr[i] != stack.peek()){
                stack.push(arr[i]);
            }else{
                stack.pop();
            }
        }

        //建立一个可变对象去添加栈中元素
        StringBuilder sb = new StringBuilder();

        for(Character x : stack){
            sb.append(x);
        }

        return sb.toString();
    }
}

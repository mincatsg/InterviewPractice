package InterviewTraining;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SubtreeElements {

//    给出二叉树的根，找出出现次数最多的子树元素和。一个结点的子树元素和定义为以该结点为根的二叉树上所有结点的元素之和
//    （包括结点本身）。然后求出出现次数最多的子树元素和。如果有多个元素出现的次数相同，返回所有出现次数最多的元素（不限顺序）。

    private int sum = 0;

    //递归过程中记录出现的最大次数
    private int max = 1;

//递归过程中录入map供之后过滤

    private Map<Integer, Integer> ans = new HashMap<>();
    private List<Integer> result = new ArrayList<>();
    public int[] findFrequentTreeSum(TreeNode root) {
        if(root == null){
            return new int[0];
        }
        find(root);

        for(Integer key : ans.keySet()){
            if(ans.get(key) == max){
                result.add(key);
            }
        }
        int[] ints = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            ints[i] = result.get(i);
        }
        return ints;
    }

    public int find(TreeNode root){
        if(root == null){
            return 0;
        }
        int left = 0;

        int right = 0;

        if(root.left != null){
            left =  find(root.left);
        }
        if(root.right != null){
            right = find(root.right);
        }

        sum = root.val + left + right;

        Integer value = ans.get(sum);
        if(value != null){
            ans.put(sum, ++value);
            max = Math.max(max, value);
        }else{
            ans.put(sum, 1);
        }

        return sum;
    }
}

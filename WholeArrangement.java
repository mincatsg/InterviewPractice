package InterviewTraining2;

import java.util.*;

public class WholeArrangement {
    //全排列
    public List<List<Integer>> permute(int[] nums) {
        int len = nums.length;

        List<List<Integer>> res = new ArrayList<>();
        if (len == 0) {
            return res;
        }

        // 使用哈希表检测一个数字是否使用过
        Set<Integer> used = new HashSet<>(len);
        Deque<Integer> path = new ArrayDeque<>(len);

        dfs(nums, len, 0, path, used, res);
        return res;
    }


    private void dfs(int[] nums, int len, int depth,
                     Deque<Integer> path, Set<Integer> used,
                     List<List<Integer>> res) {
        if (depth == len) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i < len; i++) {
            if (!used.contains(i)) {
                used.add(i);
                path.addLast(nums[i]);

                dfs(nums, len, depth + 1, path, used, res);

                path.removeLast();
                used.remove(i);
            }
        }

    }
}

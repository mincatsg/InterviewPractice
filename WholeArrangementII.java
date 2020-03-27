package InterviewTraining2;
import java.util.*;
public class WholeArrangementII {
    //全排列II
    public List<List<Integer>> permuteUnique(int[] nums) {
        int len = nums.length;

        List<List<Integer>> res = new ArrayList<>();
        if (len == 0) {
            return res;
        }

        Arrays.sort(nums);
        // 使用哈希表检测一个数字是否使用过
        boolean[] used = new boolean[len];
        Deque<Integer> path = new ArrayDeque<>(len);

        dfs(nums, len, 0, path, used, res);
        return res;
    }


    private void dfs(int[] nums, int len, int depth,
                     Deque<Integer> path, boolean[] used,
                     List<List<Integer>> res) {
        if (depth == len) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i < len; i++) {
            if (used[i]) {
                continue;
            }

            if(i > 0 && nums[i] == nums[i - 1] && !used[i - 1]){
                continue;
            }
            used[i] = true;
            path.addLast(nums[i]);

            dfs(nums, len, depth + 1, path, used, res);

            path.removeLast();
            used[i] = false;
        }

    }
}

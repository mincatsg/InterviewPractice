package InterviewTraining;

import java.util.ArrayList;
import java.util.List;

public class TreesSimilar {
//    请考虑一颗二叉树上所有的叶子，这些叶子的值按从左到右的顺序排列形成一个 叶值序列 。
//    举个例子，如上图所示，给定一颗叶值序列为 (6, 7, 4, 9, 8) 的树。
//
//    如果有两颗二叉树的叶值序列是相同，那么我们就认为它们是 叶相似 的。
//
//    如果给定的两个头结点分别为 root1 和 root2 的树是叶相似的，则返回 true；否则返回 false 。

    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> tree1 = new ArrayList<>();
        List<Integer> tree2 = new ArrayList<>();
        HelpleafSimilar(root1, tree1);
        HelpleafSimilar(root2, tree2);
        return tree1.equals(tree2);
    }

    public void HelpleafSimilar(TreeNode root, List<Integer> ans) {
        if (root != null) {
            if (root.left == null && root.right == null) {
                ans.add(root.val);
            }
            HelpleafSimilar(root.left, ans);
            HelpleafSimilar(root.right, ans);
        }
    }
}

package InterviewTraining;
class TreeNode1 {
  int val;
    TreeNode1 left;
     TreeNode1 right;
     TreeNode1(int x) { val = x; }
  }
public class RangeTree {
//    给定二叉搜索树的根结点 root，返回 L 和 R（含）之间的所有结点的值的和。
//
//    二叉搜索树保证具有唯一的值。
int ans = 0;
    public int rangeSumBST(TreeNode1 root, int L, int R) {
        //二叉搜索树特性：左子树小于结点,右子树大于结点。
        //所以遍历结点时,结点大于L直接去遍历左子树.结点小于R直接去遍历右子树.
        if(root == null){
            return 0;
        }
        ans = HelprangSumBST(root, L, R);
        return ans;
    }

    public int HelprangSumBST(TreeNode1 root, int L, int R){
        if(root == null){
            return 0;
        }
        if(root.val >= L && root.val <= R){
            ans += root.val;
        }
        if(root.val > L){
            HelprangSumBST(root.left, L, R);
        }
        if(root.val < R){
            HelprangSumBST(root.right, L, R);
        }
        return ans;
    }
}

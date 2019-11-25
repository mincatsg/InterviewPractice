package InterviewTraining;

class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
public class TreeDemon2 {
//    一.在受污染的二叉树中查找元素
//    给出一个满足下述规则的二叉树：
//
//    root.val == 0
//    如果 treeNode.val == x 且 treeNode.left != null，那么 treeNode.left.val == 2 * x + 1
//    如果 treeNode.val == x 且 treeNode.right != null，那么 treeNode.right.val == 2 * x + 2
//    现在这个二叉树受到「污染」，所有的 treeNode.val 都变成了 -1。
//
//    请你先还原二叉树，然后实现 FindElements 类：
//
//    FindElements(TreeNode* root) 用受污染的二叉树初始化对象，你需要先把它还原。
//    bool find(int target) 判断目标值 target 是否存在于还原后的二叉树中并返回结果。

//    输入：
//            ["FindElements","find","find"]
//            [[[-1,null,-1]],[1],[2]]
//    输出：
//            [null,false,true]
//    解释：
//    FindElements findElements = new FindElements([-1,null,-1]);
//    findElements.find(1); // return False
//    findElements.find(2); // return True

    class FindElements {
        TreeNode root2;

        //其实还原二叉树就是去遍历二叉树的过程再去修改他的值
        //先修改根节点值，再去遍历左子树和右子树
        public FindElements(TreeNode root) {
            root2 = root;
            root2.val = 0;
            init(root2.left, 0 * 2 + 1);
            init(root2.right, 0 * 2 + 2);
        }
      //遍历这个子树
        private void init(TreeNode t, int k) {
            if (t == null)
                return;
            t.val = k;
            init(t.left, k * 2 + 1);
            init(t.right, k * 2 + 2);
        }
    //查找也是在遍历
        public boolean find(int target) {
            return check(root2, target);
        }
        private boolean check(TreeNode r, int target) {
            if (r == null || r.val > target)
                return false;
            if (target == r.val)
                return true;
            return check(r.left, target) || check(r.right, target);
        }
    }
}

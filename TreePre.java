package InterviewTraining2;
import java.util.*;

public class AddBinaryTree {
//    非递归访问二叉树的先序遍历

    class TreeNode {
     int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

public void preOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        // 1. 先创建一个栈
        Stack<TreeNode> stack = new Stack<>();
        // 2. 把根节点入栈
        stack.push(root);
        // 3. 循环取栈顶元素, 访问之
        while (!stack.isEmpty()) {
            TreeNode cur = stack.pop();
            System.out.println(cur.val);
            // 4. 把当前元素的右子树和左子树分别入栈
            if (cur.right != null) {
                stack.push(cur.right);
            }
            if (cur.left != null) {
                stack.push(cur.left);
            }
        }
    }

}

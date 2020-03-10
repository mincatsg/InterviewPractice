package InterviewTraining2;
import java.util.*;

public class AddBinaryTree {
//    非递归访问二叉树的中序遍历

    class TreeNode {
     int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

 public  void inOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        // 1. 创建一个栈
        Stack<TreeNode> stack = new Stack<>();
        // 2. 创建一个 cur 变量从 root 出发
        TreeNode cur = root;
        while (true) {
            // 3. 只要 cur 遇到的节点非 null, 就入栈, cur = cur.left
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            // 4. 当 cur 遇到 null 的, 就出栈一个元素, 访问这个元素
            if (stack.isEmpty()) {
                // 遍历结束了
                break;
            }
            TreeNode top = stack.pop();
            System.out.println(top.val);
            // 5. cur 指向当前元素的右子树
            cur = top.right;
        }
    }

}

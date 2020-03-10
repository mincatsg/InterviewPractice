package InterviewTraining2;
import java.util.*;

public class AddBinaryTree {
//    非递归访问二叉树的后序遍历

    class TreeNode {
     int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

   public  void postOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        // 1. 创建一个栈
        Stack<TreeNode> stack = new Stack<>();
        // 2. 创建一个 cur 从 root 出发
        TreeNode cur = root;
        // prev 永远指向上次访问的节点
        TreeNode prev = null;
        while (true) {
            // 3. 借助 cur 循环往左找, 如果该节点不为 null, 入栈
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            // 4. 如果 cur 为 null, 取栈顶元素, 准备访问.
            //    要是 top 能访问, 再 pop, 否则还得在栈里待一会
            if (stack.isEmpty()) {
                // 遍历结束
                break;
            }
            TreeNode top = stack.peek();
            // 5. 到底能不能访问栈顶元素, 有两种情况:
            //  a) 栈顶元素没有右子树, 就可以访问
            //  b) 栈顶元素的右子树刚刚已经访问过, 也可以访问
            if (top.right == null || prev == top.right) {
                // 这种情况说明可以访问 top 节点
                System.out.print(top.val);
                stack.pop();
                // 同时要更新 prev
                prev = top;
            } else {
                // 此时这个节点还不能访问
                // 6. cur 指向 栈顶元素的 右子树,
                cur = top.right;
            }
        }
    }
}

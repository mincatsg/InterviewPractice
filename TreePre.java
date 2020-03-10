package InterviewTraining2;
import java.util.*;

public class AddBinaryTree {
//    �ǵݹ���ʶ��������������

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
        // 1. �ȴ���һ��ջ
        Stack<TreeNode> stack = new Stack<>();
        // 2. �Ѹ��ڵ���ջ
        stack.push(root);
        // 3. ѭ��ȡջ��Ԫ��, ����֮
        while (!stack.isEmpty()) {
            TreeNode cur = stack.pop();
            System.out.println(cur.val);
            // 4. �ѵ�ǰԪ�ص����������������ֱ���ջ
            if (cur.right != null) {
                stack.push(cur.right);
            }
            if (cur.left != null) {
                stack.push(cur.left);
            }
        }
    }

}

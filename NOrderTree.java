package InterviewTraining2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class NOrderTree {
//    N叉树的层序遍历
//    给定一个 N 叉树，返回其节点值的层序遍历。 (即从左到右，逐层遍历)。

    class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    // 把一层加到队列 去遍历那一层的节点时加入他们那一层顺序表,并且把这个节点下层儿子节点也加到队列中。
        public List<List<Integer>> levelOrder(Node root) {
            List<List<Integer>>  ans = new ArrayList<>();
            if(root == null){
                return ans;
            }
            Queue<Node> queue = new LinkedList<>();
            queue.add(root);
            while(!queue.isEmpty()){
                List<Integer> a = new ArrayList<>();
                int size = queue.size();
                for(int i = 0; i < size; i++){
                    Node node = queue.poll();
                    a.add(node.val);
                    queue.addAll(node.children);
                }
                ans.add(a);
            }
            return ans;
        }
}

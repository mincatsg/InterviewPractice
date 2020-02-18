package InterviewTraining2;

public class DeleteBinaryNodes {
    //删除二叉搜索树中的节点
//    给定一个二叉搜索树的根节点 root 和一个值 key，删除二叉搜索树中的 key 对应的节点，
//    并保证二叉搜索树的性质不变。返回二叉搜索树（有可能被更新）的根节点的引用。
//
//    一般来说，删除节点可分为两个步骤：
//
//    首先找到需要删除的节点；
//    如果找到了，删除它。
    class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
    public TreeNode deleteNode(TreeNode root, int key) {
        TreeNode cur = root;
        TreeNode parent = null;
        while(cur != null){
            if(cur.val == key){
                root = deleteNodeHelper(cur, parent, root);
                break;
            }
            else if(cur.val > key){
                parent = cur;
                cur = cur.left;
            }
            else{
                parent = cur;
                cur = cur.right;
            }
        }
        return root;
    }
    public TreeNode deleteNodeHelper(TreeNode cur, TreeNode parent, TreeNode root) {
        if(cur.left == null){
            if(cur == root){
                root = cur.right;
            }else if(parent.left == cur){
                parent.left = cur.right;
            }else{
                parent.right = cur.right;
            }
        }
        else if(cur.right == null){
            if(cur == root){
                root = cur.left;
            }
            else if(cur == parent.left){
                parent.left = cur.left;
            }else{
                parent.right = cur.left;
            }
        }
        else{
            TreeNode goatParent = cur;
            TreeNode scapegoat = cur.right;
            while(scapegoat.left != null){
                goatParent = scapegoat;
                scapegoat = goatParent.left;
            }
            cur.val = scapegoat.val;
            if(goatParent.left == scapegoat){
                goatParent.left = scapegoat.right;
            }
            if(goatParent.right == scapegoat){
                goatParent.right = scapegoat.right;
            }
        }
        return root;
    }
}

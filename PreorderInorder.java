public class PreorderInorder{
    static class TreeNode {
        public char val;
        public TreeNode left;
        public TreeNode right;

        public TreeNode(char val) {
            this.val = val;
        }
    }
  private int index = 0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {  //根据中序遍历和先序遍历建造树
     index = 0;
     return buildTreeHelper(preorder, inorder, 0, inorder.length);
    }

    public TreeNode buildTreeHelper(int[] preorder, int[] inorder, int inorderLeft, int inorderRight){
        if(inorderLeft >= inorderRight){
            return null;
        }
        if(index >= preorder.length){
            return null;
        }
        TreeNode root = new TreeNode(preorder[index]);
        index++;
        int pos = find(inorder, inorderLeft, inorderRight, root.val);
        root.left = buildTreeHelper(preorder, inorder, inorderLeft, pos);
        root.right = buildTreeHelper(preorder, inorder, pos + 1, inorderRight);
        return root;
    }
    public int find(int[] inorder, int inorderLeft, int inorderRight, int val){
        for(int i = inorderLeft; i < inorderRight; i++){
            if(inorder[i] == val){
                return i;
            }
        }
        return - 1;
    }
}
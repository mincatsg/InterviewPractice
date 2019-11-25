package Tree;

import sun.reflect.generics.tree.Tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

class TreeNode{
    int val;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(Integer val) {
        this.val = val;
    }
}
public class AdvancedTree {

//        static int index = 0;
//    //构建树
//    public static TreeNode buildTree(String str){
//        char c = str.charAt(index);
//        if(c == '#'){
//            return null;
//        }
//        TreeNode root = new TreeNode(c);
//        index++;
//        root.left = buildTree(str);
//        index++;
//        root.right = buildTree(str);
//        return root;
//    }
//    //中序遍历
//    public static void inOrder(TreeNode root){
//        if(root == null){
//            return;
//        }
//        inOrder(root.left);
//        System.out.print(root.val + " ");
//        inOrder(root.right);
//    }
    List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> levelOrder(TreeNode root) {  //层次遍历
        if (root == null) {
            return null;
        }
        helper(root, 0);
        return ans;
    }

    public void helper(TreeNode root, int level) {
        if (level == ans.size()) {
            ans.add(new ArrayList<>());
        }
        ans.get(level).add(root.val);
        if (root.left != null) {
            helper(root.left, level + 1);
        }
        if (root.right != null) {
            helper(root.right, level + 1);
        }
    }

    private TreeNode lca = null; //记录最近公共祖先

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        find(root, p, q);
        return lca;
    }

    public boolean find(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return false;
        }
        int left = find(root.left, p, q) ? 1 : 0;
        int right = find(root.right, p, q) ? 1 : 0;
        int mid = (root == q || root == p) ? 1 : 0;
        if (left + right + mid >= 2) {
            lca = root;
        }
        return (left + right + mid) > 0;
    }

    public TreeNode Convert(TreeNode pRootOfTree) {//把二叉搜索树变成有序双向链表
        if (pRootOfTree == null) {
            return null;
        }
        if (pRootOfTree.left == null && pRootOfTree.right == null) {
            return pRootOfTree;
        }
        //其实二叉搜索树的中序遍历是有序的,他的left指向前一个元素，right指向后一个。
        TreeNode left = Convert(pRootOfTree.left);
        TreeNode leftTail = left;
        while (leftTail != null && leftTail.right != null) {
            leftTail = leftTail.right;
        }
        if (left != null) {
            leftTail.right = pRootOfTree;
            pRootOfTree.left = leftTail;
        }
        TreeNode right = Convert(pRootOfTree.right);
        if (right != null) {
            pRootOfTree.right = right;
            right.left = pRootOfTree;
        }
        //如果left为null；
        return (left != null) ? left : pRootOfTree;
    }

    static int index = 0;

    public TreeNode buildTree(int[] preorder, int[] inorder) {  //根据中序遍历和先序遍历建造树
        index = 0;
        return buildTreeHelper(preorder, inorder, 0, inorder.length);
    }

    public TreeNode buildTreeHelper(int[] preorder, int[] inorder, int inorderLeft, int inorderRight) {
        if (inorderLeft >= inorderRight) {
            return null;
        }
        if (index >= preorder.length) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[index]);
        index++;
        //找index在inorder中的位置.
        int pos = find(inorder, inorderLeft, inorderRight, root.val);
        root.left = buildTreeHelper(preorder, inorder, inorderLeft, pos);
        root.right = buildTreeHelper(preorder, inorder, pos + 1, inorderRight);
        return root;
    }

    public int find(int[] inorder, int inorderLeft, int inorderRight, int val) {
        for (int i = inorderLeft; i < inorderRight; i++) {
            if (inorder[i] == val) {
                return i;
            }
        }
        return -1;
    }

    StringBuffer sd = new StringBuffer();

    public String tree2str(TreeNode t) {  //根据二叉树构建字符串
        if (t == null) {
            return "";
        }
        tree2strHelper(t);
        sd.deleteCharAt(0);
        sd.deleteCharAt(sd.length() - 1);
        return sd.toString();
    }

    public void tree2strHelper(TreeNode t) {
        if (t == null) {
            return;
        }
        sd.append("(");
        sd.append(t.val);
        tree2strHelper(t.left);
        if (t.left == null && t.right != null) {
            sd.append("()");
        }
        tree2strHelper(t.right);
        sd.append(")");
    }

    public  List<Integer> preorderTraversal(TreeNode root) { //迭代实现前序遍历
        List<Integer> preorder = new ArrayList<>();
        if (root == null) {
            return preorder;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode cur = stack.pop();
            preorder.add(cur.val);
            if(cur.right != null){
                stack.push(cur.right);
            }
            if(cur.left != null){
                stack.push(cur.right);
            }
        }
        return preorder;
    }

     public static void inOrder(TreeNode root) {  //迭代实现中序遍历
        if(root == null){
            return;
        }
        Stack<TreeNode>  stack = new Stack<>();
        TreeNode cur = root;
        while(true){
            if(cur != null){
                stack.push(cur);
                cur = cur.left;
            }
            if(stack.isEmpty()){
                break;
            }
            TreeNode top = stack.pop();
            System.out.println(top.val);
            cur = cur.right;
        }
    }
    public static void postOrder(TreeNode root) {  //迭代实现后序遍历
        if(root == null){
            return;
        }
        Stack<TreeNode>  stack = new Stack<>();
        TreeNode cur= root;
        TreeNode prev = null;
        while(true){
            if(cur != null){
                stack.push(cur);
                cur = cur.left;
            }
            if(stack.isEmpty()){
                break;
            }
            TreeNode top = stack.peek();
            if(top.right == null || top.right == prev){
                System.out.println(top.val);
                stack.pop();
            }else{
                cur = top.right;
            }
        }
    }
        public static void main (String[]args){
//        Scanner scanner = new Scanner(System.in);
//        while(scanner.hasNext()){
//            String str = scanner.next();
//            TreeNode root = buildTree(str);
//            inOrder(root);
//            index = 0;
        }
    }
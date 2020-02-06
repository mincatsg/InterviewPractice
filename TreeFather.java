public class TreeFather {
    static class TreeNode {
        public char val;
        public TreeNode left;
        public TreeNode right;

        public TreeNode(char val) {
            this.val = val;
        }
    }
private TreeNode lca = null;  // �������յĹ������Ƚڵ�
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // 1. ����һ����������, �� root �еݹ���� p �� q.
        //    �趨���������ķ���ֵ, ����ҵ����� 1(�ҵ�һ��������������), û�ҵ� ���� 0
        // 2. ����ݹ���ҵĹ��̽�һ����⿪. �ݹ����������в��� + �ݹ����������в��� + �Աȸ��ڵ�
        // 3. ���������λ����, �������ط��ҵ���, �����ǰ�ڵ����Ҫ�ҵ������������
        if (root == null) {
            return null;
        }
        // ��������
        findNode(root, p, q);
        return lca;
    }

    private boolean findNode(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return false;
        }
        // �ݹ����������г����� p ���� q
        int left = findNode(root.left, p, q) ? 1 : 0;
        // �ݹ����������г��Բ��� p ���� q
        int right = findNode(root.right, p, q) ? 1 : 0;
        // �Ա�һ�µ�ǰ�ڵ���û���ҵ�
        int mid = (root == p || root == q) ? 1 : 0;
        if (left + right + mid >= 2) {
            // �ҵ� lca, ���ǵ�ǰ�� root
            lca = root;
        }
        return (left + right + mid) > 0;
    }
}
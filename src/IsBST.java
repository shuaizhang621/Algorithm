import myClass.TreeNode;

public class IsBST {
    public boolean isBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private boolean isBST(TreeNode root, int min, int max) {
        if (root == null) {
            return true;
        }
        if (min < root.key && root.key < max) {
            return isBST(root.left, min, root.key) && isBST(root.right, root.key, max);
        }
        return false;
    }
}

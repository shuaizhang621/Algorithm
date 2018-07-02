import myClass.TreeNode;

public class isBalanced {
    // O(nlogn)
    //			root        O(n/2) + O(n/2) = O(n)
    //     /    \
    //    l       r   O(n/4) + O(n/4) = O(n/2)  + O(n/4) + O(n/4) = O(n/2) = o(n)
    //        .             .
    //        .             .
    //       ...           O(n*logn)
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (Math.abs(getHeight(root.left) - getHeight(root.right)) > 1) {
            return false;
        }
        return isBalanced(root.left) && isBalanced(root.right);
    }

    private int getHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(getHeight(root.left), getHeight(root.right)) + 1;
    }


}

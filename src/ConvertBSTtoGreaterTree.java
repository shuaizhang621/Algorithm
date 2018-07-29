import myClass.TreeNode;

public class ConvertBSTtoGreaterTree {
    public TreeNode convertBST(TreeNode root) {
        if (root == null) {
            return null;
        }
        helper(root, 0);
        return root;
    }

    private int helper(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        int rightSum = helper(root.right, sum);
        int leftSum = helper(root.left, sum + root.key + rightSum);
        int ret = root.key + leftSum + rightSum;
        root.key += rightSum + sum;
        return ret;
    }

    // inorder with a field.
    int sum;
    public TreeNode convertBST1(TreeNode root) {
        if (root == null) {
            return null;
        }
        convertBST1(root.right);
        root.key += sum;
        sum = root.key;
        convertBST1(root.left);
        return root;
    }
}

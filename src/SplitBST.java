import myClass.TreeNode;

public class SplitBST {
    // LC776
    // Time: O(height)
    // space: O(height)
    public TreeNode[] splitBST(TreeNode root, int V) {
        if (root == null) {
            return new TreeNode[2];
        }
        TreeNode[] response = new TreeNode[2];
        if (root.key == V) {
            response[1] = root.right;
            response[0] = root;
            root.right = null;
        } else if (root.key < V) {
            response = splitBST(root.right, V);
            root.right = response[0];
            response[0] = root;
        } else {
            response = splitBST(root.left, V);
            root.left = response[1];
            response[1] = root;
        }
        return response;
    }
}

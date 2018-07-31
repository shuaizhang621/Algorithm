import myClass.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class SerializeAndDeserilizeBST {

    // LC449

    // Encodes a tree to a single string.

    // Time O(n)
    // Space O(height)
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        serialize(root, sb);
        return sb.toString();
    }

    private void serialize(TreeNode root, StringBuilder sb) {
        if (root == null) {
            return;
        }
        sb.append(root.key);
        sb.append(',');
        serialize(root.left, sb);
        serialize(root.right, sb);
    }

    // Decodes your encoded data to tree.

    // Time O(n);
    // Space O(n);
    public TreeNode deserialize(String data) {
        if (data == null || data.length() == 0) {
            return null;
        }
        String[] array = data.split(",");
        Queue<TreeNode> q = new LinkedList<>();
        for (String s : array) {
            q.offer(new TreeNode(Integer.valueOf(s)));
        }
        TreeNode root = q.poll();
        deserialize(root, q, Integer.MIN_VALUE, Integer.MAX_VALUE);
        return root;
    }

    private TreeNode deserialize(TreeNode root, Queue<TreeNode> q, int min, int max) {
        if (q.isEmpty()) {
            return root;
        }
        TreeNode cur = q.peek();
        if (cur.key < max && cur.key > min && cur.key < root.key) {
            q.poll();
            root.left = deserialize(cur, q, min, root.key);
            if (q.isEmpty()) {
                return root;
            }
            cur = q.peek();
        }
        if (cur.key < max && cur.key > min && cur.key > root.key) {
            q.poll();
            root.right = deserialize(cur, q, root.key, max);
        }
        return root;
    }
}

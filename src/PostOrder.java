import myClass.TreeNode;

import java.util.*;

public class PostOrder {
    public List<Integer> postOrder1(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()) {
            if (cur != null) {
                stack.push(cur);
                result.add(cur.key);
                cur = cur.right;
            } else {
                cur = stack.poll().left;
            }
        }
        Collections.reverse(result);
        return result;
    }

    public List<Integer> postOrder2(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Deque<TreeNode> stack = new ArrayDeque<>();

        if (root == null) {
            return result;
        }
        TreeNode prev = null;
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode cur = stack.peek();
            // 1. prev is parent of cur
            if (prev == null || prev.left == cur || prev.right == cur) {
                // try to go down, try left first;
                if (cur.left != null) {
                    stack.push(cur.left);
                    // then try to go right;
                } else if (cur.right != null) {
                    stack.push(cur.right);
                    // can not go right or left, then cur is a leaf node. Add it to result.
                } else {
                    stack.poll();
                    result.add(cur.key);
                }
                // 2. cur is right child
            } else if (prev == cur.right) {
                // print
                stack.poll();
                result.add(cur.key);
                // 3. cur is left child
            } else {
                if (cur.right == null) {
                    //print
                    stack.poll();
                    result.add(cur.key);
                } else {
                    // go right
                    stack.push(cur.right);
                }
            }
            prev = cur;
        }
        return result;
    }
}

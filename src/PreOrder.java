import myClass.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class PreOrder {
    public List<Integer> preOrder(TreeNode root) {
        List<Integer> result = new LinkedList<>();
        Deque<TreeNode> stack = new ArrayDeque<>();

        TreeNode cur = root;
        while(cur != null || !stack.isEmpty())  {
            if (cur != null) {
                stack.push(cur);
                result.add(cur.key);
                cur = cur.left;
            } else {
                cur = stack.poll().right;
            }
        }
        return result;
    }
}

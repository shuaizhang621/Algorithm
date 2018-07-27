import myClass.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class RightSideView {
  // BFS, when the tree is tall.
  // Time complexity: O(n), Space complexity: O(n)
  public List<Integer> rightSideView1(TreeNode root) {
    List<Integer> result = new ArrayList<>();
    if (root == null) {
      return result;
    }
    Queue<TreeNode> q = new LinkedList<>();
    q.offer(root);
    while (!q.isEmpty()) {
      int size = q.size();
      for (int i = 0; i < size; i++) {
        TreeNode cur = q.poll();
        if (cur.left != null) {
          q.offer(cur.left);
        }
        if (cur.right != null) {
          q.offer(cur.right);
        }
        if (i == size - 1) {
          result.add(cur.key);
        }
      }
    }
    return result;
  }
  
  // BFS, when the tree is wide. It can save space
  // Time complexity: O(n), Space complexity: O(log(n))
  public List<Integer> rightSideView2(TreeNode root) {
    List<Integer> result = new ArrayList<>();
    rightSideView(root, 0, result);
    return result;
  }
  
  private void rightSideView(TreeNode root, int depth, List<Integer> result) {
    if (root == null) {
      return;
    }
    if (result.size() == depth) {
      result.add(root.key);
    }
    rightSideView(root.right, depth + 1, result);
    rightSideView(root.left, depth + 1, result);
  }
}

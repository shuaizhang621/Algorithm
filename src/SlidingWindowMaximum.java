import java.util.ArrayDeque;
import java.util.Deque;

public class SlidingWindowMaximum {
    // Time Complexity: O(n)
    // Space Complexity: O(k)
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return new int[0];
        }
        int[] result = new int[nums.length - k + 1];
        Deque<Integer> dq = new ArrayDeque<>();
        for (int i = 0; i < nums.length; i++) {
            // poll out all out of range element from head.
            while (!dq.isEmpty() && dq.peekLast() <= i - k) {
                dq.pollLast();
            }
            // poll out all element that smaller than the incoming element from tail.
            // the rest will be promising element which has the protential to be tha max in window.
            while (!dq.isEmpty() && nums[dq.peekFirst()] < nums[i]) {
                dq.pollFirst();
            }
            dq.offerFirst(i);
            if (i >= k - 1) {
                result[i - k + 1] = nums[dq.peekLast()];
            }
        }
        return result;
    }
}

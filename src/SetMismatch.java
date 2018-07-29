public class SetMismatch {
    // LC645
    // Time O(n)
    // Space O(n)
    public int[] findErrorNums(int[] nums) {
        int[] freq = new int[nums.length];
        int[] res = new int[2];
        for (int i : nums) {
            freq[i - 1]++;
            if (freq[i - 1] == 2) {
                res[0] = i;
            }
        }
        for (int i = 0; i < freq.length; i++) {
            if (freq[i] == 0) {
                res[1] = i + 1;
            }
        }
        return res;
    }
}

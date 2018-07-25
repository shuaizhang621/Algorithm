public class ProductOfArrayExceptSelf {
    // LC238
    // Time complexity: O(n)
    // Space complexity: O(1)
    public int[] productExceptSelf(int[] nums) {
        if (nums == null) {
            return null;
        }
        int[] result = new int[nums.length];
        if (nums.length == 0) {
            return result;
        }
        result[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            result[i] = result[i - 1] * nums[i - 1];
        }
        int temp = 1;
        for (int k = nums.length - 2; k >= 0; k--) {
            temp *= nums[k + 1];
            result[k] *= temp;
        }
        return result;
    }
}

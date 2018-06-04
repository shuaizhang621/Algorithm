public class ClosestNum {
    public int closest(int[] array, int target) {
        if (array == null || array.length == 0) {
            return -1;
        }
        int left = 0;
        int right = array.length - 1;
        while (left < right - 1) {
            int mid = left + (right - left) / 2;
            if (array[mid] > target) {
                right = mid;
            } else {
                left = mid;
            }
        }
        if (target - array[left] <= array[right] - target) {
            return left;
        } else {
            return right;
        }
    }
}

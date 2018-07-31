public class MonotoneIncreasingDigits {
    // LC738
    // Time: O(n) n is the number of digits.
    // space: O(n).
    public int monotoneIncreasingDigits(int N) {
        char[] array = Integer.toString(N).toCharArray();
        for (int i = array.length - 1; i > 0; i--) {
            if (array[i] < array[i - 1]) {
                array[i - 1]--;
                for (int j = i; j < array.length; j++) {
                    array[j] = '9';
                }
            }
        }
        return Integer.valueOf(new String(array));
    }
}

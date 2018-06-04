public class BinarySearchInSortedMatrix {
    public int[] search(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return new int[] {-1, -1};
        }
        int M = matrix.length;
        int N = matrix[0].length;

        int left = 0;
        int right = M * N - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int row = mid / N;  // divide by column!
            int col = mid % N;
            if (matrix[row][col] < target) {
                left = mid + 1;
            } else if (matrix[row][col] > target) {
                right = mid - 1;
            } else {
                return new int[] {row, col};
            }
        }
        return new int[] {-1, -1};
    }
}

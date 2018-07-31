public class SetMatrixZeroes {
    // LC73
    // Time O(mn)
    // Space O(1)
    public void setZeroes(int[][] matrix) {
        int M = matrix.length;
        int N = matrix[0].length;
        int row0 = 1;
        for (int i = 0; i < M; i++) {
            if (matrix[i][0] == 0) row0 = 0;
            for (int j = 1; j < N; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
        for (int i = M - 1; i >= 0; i--) {
            for (int j = 1; j < N; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }
        if (row0 == 0) {
            for (int i = 0; i < M; i++) {
                matrix[i][0] = 0;
            }
        }
    }
}

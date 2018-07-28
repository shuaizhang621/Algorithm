public class ImageSmoother {
    public int[][] imageSmoother(int[][] M) {
        if (M == null) {
            return null;
        }
        int w = M.length;
        int h = M[0].length;
        int[][] res = new int[w][h];
        for (int i = 0; i < w; i++) {
            for (int j = 0; j < h; j++) {
                int count = 1;
                int sum = M[i][j];
                if (i - 1 >= 0 && j - 1 >= 0) {
                    sum += M[i - 1][j - 1];
                    count++;
                }
                if (j - 1 >= 0) {
                    sum += M[i][j - 1];
                    count++;
                }
                if (i + 1 < w && j - 1 >= 0) {
                    sum += M[i + 1][j - 1];
                    count++;
                }
                if (i - 1 >= 0) {
                    sum += M[i - 1][j];
                    count++;
                }
                if (i + 1 < w) {
                    sum += M[i + 1][j];
                    count++;
                }
                if (i - 1 >= 0 && j + 1 < h) {
                    sum += M[i - 1][j + 1];
                    count++;
                }
                if (j + 1 < h) {
                    sum += M[i][j + 1];
                    count++;
                }
                if (i + 1 < w && j + 1 < h) {
                    sum += M[i + 1][j + 1];
                    count++;
                }
                res[i][j] = sum / count;
            }
        }
        return res;
    }
}

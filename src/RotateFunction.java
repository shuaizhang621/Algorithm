public class RotateFunction {
    // LC396
    // Time O(n)
    // Space O(1)
    // This is a mathematical problem. 错位相减 Orz...Boring
    public int maxRotateFunction(int[] A) {
        if (A == null || A.length <= 1) {
            return 0;
        }
        int N = A.length;
        int sum = 0;
        int F = 0;
        for (int i = 0; i < N; i++) {
            F += i * A[i];
            sum += A[i];
        }
        int max = F;
        for (int k = 1; k < N; k++) {
            F = F + sum - N * A[N - k];
            max = Math.max(F, max);
        }
        return max;
    }
}

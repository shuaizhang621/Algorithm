import java.util.Arrays;
import java.util.Comparator;

public class MaximumLengthOfPairChain {
    // DP
    // Time: O(n^2)
    // Space: O(n)
    public int findLongestChain(int[][] pairs) {
        if (pairs == null || pairs.length == 0) {
            return 0;
        }
        Arrays.sort(pairs, (a, b) -> (a[0] - b[0]));
        int[] m = new int[pairs.length];
        Arrays.fill(m, 1);
        for (int i = 1; i < pairs.length; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (pairs[i][0] > pairs[j][1] && m[j] > m[i] - 1) {
                    m[i] = m[j] + 1;
                }
            }
        }
        return m[m.length - 1];
    }


    // Strategy: find the shortest possible pair.
    // O(n) time O(1) space.
    public int findLongestChainGreedy(int[][] pairs) {
        if (pairs == null || pairs.length == 0) {
            return 0;
        }
        Arrays.sort(pairs, new Comparator<int[]>() {
            @Override
            public int compare(int[] i1, int[] i2) {
                return i1[1] - i2[1];
            }
        });
        int end = pairs[0][1];
        int count = 1;
        for (int i = 1; i < pairs.length; i++) {
            if (pairs[i][0] > end) {
                count++;
                end = pairs[i][1];
            }
        }
        return count;
    }
}

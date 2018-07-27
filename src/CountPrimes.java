import java.util.Comparator;
import java.util.PriorityQueue;

public class CountPrimes {
    // Time complexity O(nloglogn)
    // Space complexity O(n)
    public int countPrimes(int n) {
        boolean[] notPrimes = new boolean[n];
        int count = 0;
        for (int i = 2; i * i < n; i++) {
            if (notPrimes[i]) continue;
            for (int j = i * i; j < n; j += i) {
                notPrimes[j] = true;
            }
        }
        for (int i = 2; i < n; i++) {
            if (!notPrimes[i]) count++;
        }
        int k = 4;
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(k, new Comparator<Integer>(){
            @Override
            public int compare(Integer i1, Integer i2) {
                if (i1.equals(i2)) {
                    return 0;
                }
                return i1 < i2 ? -1 : 1;
            }
        });
        return count;
    }
}

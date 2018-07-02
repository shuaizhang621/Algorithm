import java.util.Comparator;
import java.util.PriorityQueue;

public class KSmallest {
    public int[] kSmallest(int[] array, int k) {
        int[] result = new int[k];
        if (array.length == 0 || k == 0) {
            return result;
        }
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(k, new Comparator<Integer>() {
            @Override
            public int compare(Integer n1, Integer n2) {
                // not == !
                if (n1.equals(n2)) {
                    return 0;
                }
                return n1 > n2 ? -1 : 1;
            }
        });
//        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(k, Comparator.reverseOrder());

        for (int i = 0; i < array.length; i++) {
            if (i < k) {
                maxHeap.offer(array[i]);
            } else if (array[i] < maxHeap.peek()) {
                maxHeap.poll();
                maxHeap.offer(array[i]);
            }
        }
        for (int j = k - 1; j >= 0; j--) {
            result[j] = maxHeap.poll();
        }
        return result;
    }
}
}

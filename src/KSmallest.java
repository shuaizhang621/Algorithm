import java.util.Arrays;
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

    public int[] kSmallestWithQuikSelect(int[] array, int k) {
        if (array.length == 0 || k == 0) {
            return new int[0];
        }
        quikSelect(array, 0, array.length - 1, k - 1);
        int[] result = Arrays.copyOf(array, k);
        Arrays.sort(result);
        return result;
    }

    private void quikSelect(int[] array, int left, int right, int target) {
        int mid = partition(array, left, right);
        if (target == mid) {
            return;
        } else if (target < mid) {
            quikSelect(array, left, mid - 1, target);
        } else {
            quikSelect(array, mid + 1, right, target);
        }
    }

    private int partition(int[] array, int left, int right) {
        int pivot = array[right];
        int start = left;
        int end = right - 1;
        while (start <= end) {
            if (array[start] < pivot) {
                start++;
            } else if (array[end] > pivot) {
                end--;
            } else {
                swap(array, start++, end--);
            }
        }
        swap(array, right, start);
        return start;
    }

    private void swap(int[] array, int left, int right) {
        int temp = array[left];
        array[left] = array[right];
        array[right] = temp;
    }
}


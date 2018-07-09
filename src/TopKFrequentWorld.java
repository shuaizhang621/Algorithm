import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class TopKFrequentWorld {
    public String[] topKFrequent(String[] combo, int k) {
        if (combo.length == 0) {
            return combo;
        }
        Map<String, Integer> map = new HashMap<>();
        for (String s : combo) {
            if (map.containsKey(s)) {
                map.put(s, map.get(s) + 1);
            } else {
                map.put(s, 1);
            }
        }
        PriorityQueue<Map.Entry<String, Integer>> minHeap = new PriorityQueue<>(k, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> e1, Map.Entry<String, Integer> e2) {
                if (e1.getValue() == e2.getValue()) {
                    return 0;
                }
                return e1.getValue() < e2.getValue() ? -1 : 1;
            }
        });

        for (Map.Entry<String, Integer> e : map.entrySet()) {
            if (minHeap.size() < k) {
                minHeap.offer(e);
            } else {
                if (e.getValue() >= minHeap.peek().getValue()) {
                    minHeap.poll();
                    minHeap.offer(e);
                }
            }
        }
        String[] result = new String[minHeap.size()];  // must minHeap.size() here. Otherwise, when k > combo.length, NPE will occur.
        for (int i = minHeap.size() - 1; i >= 0; i--) {
            result[i] = minHeap.poll().getKey();
        }
        return result;
    }
}

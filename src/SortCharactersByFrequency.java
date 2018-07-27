import java.util.*;

public class SortCharactersByFrequency {
    // priorityQueue solution:
    // Time complexity: nlogn
    // Space complexity: n
    public String frequencySort0(String s) {
        char[] array = s.toCharArray();
        Map<Character, Integer> freq = new HashMap<>(); // n
        for (char c : array) {
            if (freq.containsKey(c)) {
                freq.put(c, freq.get(c) + 1);
            } else {
                freq.put(c, 1);
            }
        }

        PriorityQueue<Map.Entry<Character, Integer>> pq = new PriorityQueue<>(
                new Comparator<Map.Entry<Character, Integer>>() {
                    @Override
                    public int compare(Map.Entry<Character, Integer> e1, Map.Entry<Character, Integer> e2) {
                        if (e1.getValue() == e2.getValue()) {
                            return e1.getKey() - e2.getKey();
                        }
                        return e1.getValue() < e2.getValue() ? 1 : -1;
                    }
                });

        pq.addAll(freq.entrySet());

        StringBuilder sb = new StringBuilder();
        while (!pq.isEmpty()) { // nlogn
            Map.Entry<Character, Integer> cur = pq.poll();
            for (int i = 0; i < cur.getValue(); i++) {
                sb.append(cur.getKey());
            }
        }
        return sb.toString();
    }

    // bucket sort:
    // Time: O(n)
    // space: O(1);
    public String frequencySort(String s) {
//        List<Character>[] bucket = new List[s.length()];
        List<List<Character>> bucket = new ArrayList<>(s.length());
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            bucket.add(new ArrayList<>());
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }
        }
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            int index = entry.getValue() - 1;
            char c = entry.getKey();
            bucket.get(index).add(c);
        }
        StringBuilder sb = new StringBuilder();
        for (int i = s.length() - 1; i >= 0; i--) {
            if (bucket.get(i).size() == 0) {
                continue;
            }
            for (Character c : bucket.get(i)) {
                for (int j = 0; j <= i; j++) {
                    sb.append(c);
                }
            }
        }
        return sb.toString();
    }

    public String frequencySort2(String s) {
        List<Character>[] bucket = new List[s.length()];
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }
        }
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            int index = entry.getValue() - 1;
            char c = entry.getKey();
            if (bucket[index] == null) {
                bucket[index] = new ArrayList<>();
            }
            bucket[index].add(c);
        }
        StringBuilder sb = new StringBuilder();
        for (int i = s.length() - 1; i >= 0; i--) {
            if (bucket[i] == null) {
                continue;
            }
            for (Character c : bucket[i]) {
                for (int j = 0; j <= i; j++) {
                    sb.append(c);
                }
            }
        }
        return sb.toString();
    }

    // optimization, did use List
    public String frequencySort3(String s) {
        int[] freq = new int[256];
        char[] array = s.toCharArray();
        for (char c : array) {
            freq[c]++;
        }
        int max = 0;
        int i = 0;
        while (i < array.length) {
            for (int j = 0; j < 256; j++) {
                if (freq[j] > freq[max]) {
                    max = j;
                }
            }
            for (int k = 0; k < freq[max]; k++) {
                array[i++] = (char) max;
            }
            freq[max] = 0;
        }
        return new String(array);
    }
}

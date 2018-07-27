import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MostCommonWord {
    // LC819
    // Time O(n)
    // Space O(n)
    public String mostCommonWord(String paragraph, String[] banned) {
        String[] words = paragraph.toLowerCase().replaceAll("\\pP", " ").split(" +");
        Set<String> set = new HashSet<>();
        for (String ban : banned) set.add(ban);
        Map<String, Integer> map = new HashMap<>();
        for (String word : words) {
            if (set.contains(word)) {
                continue;
            }
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        String res = "";
        int max = 0;
        for (Map.Entry<String, Integer> e : map.entrySet()) {
            if (e.getValue() > max) {
                max = e.getValue();
                res = e.getKey();
            }
        }
        return res;
    }
}

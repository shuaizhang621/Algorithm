import java.util.*;

public class WordBreak {
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] visited = new boolean[s.length()];
        Set<String> set = new HashSet<>(wordDict);
        int maxLen = -1;
        for (String word : wordDict) {
            maxLen = Math.max(maxLen, word.length());
        }
        Queue<Integer> q = new LinkedList<>();
        q.add(0);
        visited[0] = true;
        while (!q.isEmpty()) {
            int start = q.poll();
            for (int end = start + 1; end <= s.length() && end - start <= maxLen; end++) {
                if (set.contains(s.substring(start, end)) && !(end < s.length() && visited[end])) {
                    if (end == s.length()) {
                        return true;
                    }
                    q.add(end);
                    visited[end] = true;
                }
            }
        }
        return false;
    }
}

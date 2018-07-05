import java.util.ArrayList;
import java.util.List;

public class AllSubset {
    public List<String> subSets(String set) {
        List<String> result = new ArrayList<>();
        if (set == null) {
            return result;
        }
        StringBuilder sb = new StringBuilder();
        DFS(set, result, sb, 0);
        return result;
    }

    private void DFS(String set, List<String> result, StringBuilder sb, int level) {
        if (level == set.length()) {
            result.add(new String(sb));
            return;
        }
        DFS(set, result, sb, level + 1);

        sb.append(set.charAt(level));
        DFS(set, result, sb, level + 1);
        sb.deleteCharAt(sb.length() - 1);
    }
}

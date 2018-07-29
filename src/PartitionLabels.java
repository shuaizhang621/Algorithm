import java.util.ArrayList;
import java.util.List;

public class PartitionLabels {
    public List<Integer> partitionLabels(String S) {
        int[] maxPosition = new int[26];
        for (int i = 0; i < S.length(); i++) {
            maxPosition[S.charAt(i) - 'a'] = i;
        }
        List<Integer> result = new ArrayList<>();
        int lastEnd = -1;
        int curEnd = 0;
        for (int i = 0; i < S.length(); i++) {
            curEnd = Math.max(maxPosition[S.charAt(i) - 'a'], curEnd);
            if (curEnd == i) {
                result.add(curEnd - lastEnd);
                lastEnd = curEnd;
            }
        }
        return result;
    }
}

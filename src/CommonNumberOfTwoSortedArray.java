import java.util.ArrayList;
import java.util.List;

public class CommonNumberOfTwoSortedArray {
    public List<Integer> common(List<Integer> A, List<Integer> B) {
        List<Integer> common = new ArrayList<>();
        int i = 0;
        int j = 0;
        while (i < A.size() && j < B.size()) {
            if (A.get(i) == B.get(j)) {
                common.add(A.get(i));
                i++;
                j++;
            } else if (A.get(i) < B.get(j)) {
                i++;
            } else {
                j++;
            }
        }
        return common;
    }
}

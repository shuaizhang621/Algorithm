import java.util.ArrayList;
import java.util.List;

public class PascalTriangleII {
    public List<Integer> getRow(int rowIndex) {
        int[] a = new int[rowIndex + 1];
        a[0] = 1;
        for (int i = 1; i < rowIndex + 1; i++) {
            for (int j = i; j > 0; j--) {
                a[j] += a[j - 1];
            }
        }
        List<Integer> res = new ArrayList<>();
        for (int i : a) {
            res.add(i);
        }
        return res;
    }
}

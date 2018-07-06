import java.util.ArrayList;
import java.util.List;

public class AllPermutation {
    public List<String> permutations(String set) {
        List<String> result = new ArrayList<>();
        if (set == null) {
            return result;
        }
        char[] array = set.toCharArray();
        DFS(array, 0, result);
        return null;
    }

    private void DFS(char[] array, int index, List<String> result) {
        if (index == array.length) {
            result.add(new String(array));
        }
        for (int i = index; i < array.length; i++) {
            swap(array, i, index);
            DFS(array, index + 1, result);
            swap(array, i, index);
        }
    }

    private void swap(char[] array, int a, int b) {
        char temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }
}

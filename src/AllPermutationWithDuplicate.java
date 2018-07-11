import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class AllPermutationWithDuplicate {
    public List<String> permutations1(String set) {
        List<String> result = new ArrayList<>();
        if (set == null) {
            return result;
        }
        Set<String> dedup = new HashSet<>();
        char[] array = set.toCharArray();
        permutation1(array, 0, result, dedup);
        return result;
    }

    private void permutation1(char[] array, int index, List<String> result, Set<String> dedup) {
        if (index == array.length) {
            String s = new String(array);
            if (dedup.add(s)) {
                result.add(s);
            }
            return;
        }
        for (int i = index; i < array.length; i++) {
            swap(array, i, index);
            permutation1(array, index + 1, result, dedup);
            swap(array, i, index);
        }
    }

    //       /      |     \
    //      a--    b--
    //     /\       /\
    //  ab- aa-   ba-
    // aba aab   baa
    public List<String> permutations2(String set) {

        List<String> result = new ArrayList<>();
        if (set == null) {
            return result;
        }
        char[] array = set.toCharArray();
        permutation2(array, 0, result);
        return result;
    }

    private void permutation2(char[] array, int index, List<String> result) {
        if (index == array.length) {
            result.add(new String(array));
            return;
        }
        Set<Character> used = new HashSet<>();
        for (int i = index; i < array.length; i++) {
            if (used.add(array[i])) {
                swap(array, i, index);
                permutation2(array, index + 1, result);
                swap(array, i, index);
            }
        }
    }

    private void swap(char[] array, int i, int j) {
        char temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}

import java.util.HashSet;
import java.util.Set;

public class RemoveCertainChar {
    public String remove(String input, String t) {
        if (input.length() == 0 || t.length() == 0) {
            return input;
        }
        char[] array = input.toCharArray();
        Set<Character> set = new HashSet<>();
        for (int c = 0; c < t.length(); c++) {
            set.add(t.charAt(c));
        }
        int end = 0;
        for (int i = 0; i < array.length; i++) {
            if (!set.contains(array[i])) {
                array[end++] = array[i];
            }
        }
        return new String(array, 0, end);
    }
}

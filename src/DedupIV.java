import java.util.ArrayDeque;
import java.util.Deque;

public class DedupIV {
    public String deDupUseStack(String input) {
        if (input == null || input.length() <= 1) {
            return input;
        }
        Deque<Character> stack = new ArrayDeque<>();
        for (int i = 0; i < input.length(); i++) {
            if (stack.isEmpty() || stack.peek() != input.charAt(i)) {
                stack.push(input.charAt(i));
            } else {
                while (i + 1 < input.length() && stack.peek() == input.charAt(i + 1)) {
                    i++;
                }
                stack.pop();
            }
        }
        int size = stack.size();
        char[] result = new char[size];
        for (int j = size - 1; j >= 0; j--) {
            result[j] = stack.pop();
        }
        return new String(result);
    }

    // Use left part of array to simulate stack.
    // what in the stack is that we need to return.
    public String deDup(String input) {
        if (input == null || input.length() <= 1) {
            return input;
        }
        char[] array = input.toCharArray();
        int end = -1;
        for (int i = 0; i < input.length(); i++) {
            if (end == -1 || array[end] != array[i]) {
                array[++end] = array[i];
            } else {
                while (i + 1 < array.length && array[end] == array[i + 1]) {
                    i++;
                }
                end--;
            }
        }
        return new String(array, 0, end + 1);
    }
}

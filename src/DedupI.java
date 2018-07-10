public class DedupI {
    public String deDup1(String input) {
        if (input == null || input.length() == 0) {
            return input;
        }
        char[] array = input.toCharArray();
        int slow = 0;
        int fast = 0;
        while (fast < array.length) {
            if (array[slow] != array[fast]) {
                array[++slow] = array[fast];
            }
            fast++;
        }
        return new String(array, 0, slow + 1);
    }

    public String deDup(String input) {
        if (input == null) {
            return input;
        }
        char[] array = input.toCharArray();
        int end = 0;
        for (int i = 0; i < array.length; i++) {
            if (end == 0 || array[i] != array[end - 1]) {
                array[end++] = array[i];
            }
        }
        return new String(array, 0, end);
    }
}

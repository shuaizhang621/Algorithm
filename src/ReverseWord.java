public class ReverseWord {
    public String reverseWords(String input) {
        if (input == null || input.length() == 0) {
            return input;
        }
        char[] array = input.toCharArray();
        int start = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] != ' ') {
                continue;
            }
            reverse(array, start, i - 1);
            start = i + 1;
        }
        reverse(array, start, array.length - 1);
        reverse(array, 0, array.length - 1);
        return new String(array);
    }

    private void reverse(char[] array, int start, int end) {
        while (start < end) {
            swap(array, start++, end--);
        }
    }

    private void swap(char[] array, int i, int j) {
        char temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}

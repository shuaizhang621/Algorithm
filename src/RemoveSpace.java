public class RemoveSpace {
    public String removeSpaces(String input) {
        if (input.length() == 0) {
            return input;
        }
        char[] array = input.toCharArray();
        int i = 0;
        int end = 0;
        while (i < array.length) {
            while (i < array.length && array[i] == ' ') {
                i++;
            }
            while (i < array.length && array[i] != ' ') {
                array[end++] = array[i++];
            }
            if (i < array.length) {
                array[end++] = ' ';
                i++;
            }
        }
        if (end > 0 && array[end - 1] == ' ') {
            return new String(array, 0, end - 1);
        }
        return new String(array, 0, end);
    }

    public String removeSpaces2(String input) {
        if (input.length() == 0) {
            return input;
        }
        char[] array = input.toCharArray();
        int end = 0;
        for (int i = 0; i < array.length; i++) {
            // 1. space at the head need to be delete
            // 2. space not close following a word need to be delete
            if (array[i] == ' ' && (i == 0 || array[i - 1] == ' ')) {
                continue;
            }
            array[end++] = array[i];
        }
        if (end > 0 && array[end - 1] == ' ') {
            return new String(array, 0, end - 1);
        }
        return new String(array, 0, end);
    }
}

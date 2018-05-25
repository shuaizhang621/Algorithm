public class RainbowSort {
    public int[] rainbowSort(int[] array) {
        if (array == null || array.length == 0) {
            return array;
        }
        int neg = 0;
        int zero = 0;
        int one = array.length - 1;
        while (zero <= one) {
            if (array[zero] == -1) {
                swap(array, neg++, zero++);
            } else if (array[zero] == 0) {
                zero++;
            } else if (array[zero] == 1) {
                swap(array, one--, zero);
            }
        }
        return array;
    }

    private void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}

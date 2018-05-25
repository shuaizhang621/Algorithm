public class MoveZeroToEndI {
    public int[] moveZero(int[] array) {
        if (array.length <= 1) {
            return array;
        }
        int slow = 0;
        int fast = 0;
        while (fast < array.length) {
            if (array[fast] != 0) {
                swap(array, slow++, fast);
            }
            fast++;
        }
        return array;
    }

    private void swap(int[] array, int left, int right) {
        int temp = array[left];
        array[left] = array[right];
        array[right] = temp;
    }
}

public class MissingNumberI {
    public int missing(int[] array) {
        int res = 0;
        for (int i = 0; i < array.length; i++) {
            res ^= array[i] ^ (i + 1);
        }
        return res ^ array.length + 1;
    }
}

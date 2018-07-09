public class MissingNumberI {
    public int missing(int[] array) {
        int res = 0;
        for (int i = 0; i < array.length; i++) {
            res ^= array[i] ^ (i + 1);
        }
        return res ^ array.length + 1;
    }

    public int missingUseMap(int[] array) {
        int[] map = new int[array.length + 1];
        for (int i : array) {
            map[i - 1] = 1;
        }
        for (int j = 0; j < map.length; j++) {
            if (map[j] != 1) {
                return j + 1;
            }
        }
        return -1;
    }
}

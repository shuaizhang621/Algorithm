public class Subsub {
    public int strstr(String large, String small) {
        if (small.length() == 0) {
            return 0;
        }
        if (small.length() > large.length()) {
            return -1;
        }
        for (int i = 0; i <= large.length() - small.length(); i++) {
            if (compare(large, small, i)) {
                return i;
            }
        }
        return -1;
    }

    private boolean compare(String large, String small, int index) {
        for (int i = 0; i < small.length(); i++) {
            if (large.charAt(index + i) != small.charAt(i)) {
                return false;
            }
        }
        return true;
    }
}

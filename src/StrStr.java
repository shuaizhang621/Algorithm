public class StrStr {
    public int strStr1(String haystack, String needle) {
        if (haystack == null || needle == null || haystack.length() < needle.length()) {
            return -1;
        }
        if (needle.length() == 0) {
            return 0;
        }
        int slow = 0;
        int fast = 0;
        int s = 0;
        while (fast < haystack.length()) {
            if (haystack.charAt(slow) != needle.charAt(s)) {
                slow++;
                fast++;
                continue;
            }
            while (s < needle.length() && fast < haystack.length() && haystack.charAt(fast) == needle.charAt(s)) {
                fast++;
                s++;
            }
            if (s == needle.length()) {
                return slow;
            }
            s = 0;
            slow++;
            fast = slow;
        }
        return -1;
    }

    public int strStr(String haystack, String needle) {
        if (haystack == null || needle == null || haystack.length() < needle.length()) {
            return -1;
        }
        if (haystack.length() == 0) {
            return 0;
        }
        for (int i = 0; i < haystack.length(); i++) {
            if (equal(haystack, needle, i)) {
                return i;
            }
        }
        return -1;
    }

    private boolean equal(String haystack, String needle, int i) {
        if (haystack.length() - i < needle.length()) {
            return false;
        }
        for (int j = 0; j < needle.length(); j++) {
            if (haystack.charAt(i + j) != needle.charAt(j)) {
                return false;
            }
        }
        return true;
    }
}

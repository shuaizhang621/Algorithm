public class CustomSortString {
    // LC791
    // Time O(mn), m is the length of S, n is the length of T.
    // Space O(1), if we don't take the char array into consideration.
    public String customSortString(String S, String T) {
        if (S == null || S.length() == 0) {
            return T;
        }
        char[] s = S.toCharArray();
        char[] t = T.toCharArray();
        int slow = 0;
        for (char c : s) {
            int fast = slow;
            while (fast < t.length) {
                if (t[fast] == c) {
                    char temp = t[slow];
                    t[slow++] = t[fast];
                    t[fast] = temp;
                }
                fast++;
            }
        }
        return new String(t);
    }
}

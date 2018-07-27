public class ThirdMaximumNumber {
    public int thirdMax(int[] nums) {
        Integer first = null;
        Integer second = null;
        Integer third = null;
        for (Integer i : nums) {
            // i == first not working!
            if (i.equals(first) || i.equals(second) || i.equals(third)) {
                continue;
            } else if (first == null || i > first) {
                third = second;
                second = first;
                first = i;
            } else if (second == null || i > second) {
                third = second;
                second = i;
            } else if (third == null || i > third) {
                third = i;
            }
        }
        return third == null ? first : third;

    }
}

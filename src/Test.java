import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        int[] input = {3,5,1,2,4,3};
        QuickSort qs = new QuickSort();
        System.out.println(Arrays.toString(qs.quickSort(input)
        ));
    }
}

import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        int[] input = {1,1,0,-1,0,1,-1};
        MoveZeroToEndI testClass = new MoveZeroToEndI();
        System.out.println(Arrays.toString(testClass.moveZero(input)
        ));
    }
}

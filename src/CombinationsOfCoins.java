import java.util.ArrayList;
import java.util.List;

public class CombinationsOfCoins {
    public List<List<Integer>> combinations(int target, int[] coins) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> comb = new ArrayList<>();
        combinations(target, coins, 0, 0, comb, result);
        return result;
    }

    private void combinations(int target, int[] coins, int index, int curValue, List<Integer> comb, List<List<Integer>> result) {
        if (index == coins.length - 1) {
            if ((target - curValue) % coins[coins.length - 1] == 0) {
                comb.add((target - curValue) / coins[coins.length - 1]);
                result.add(new ArrayList<>(comb));
                comb.remove(comb.size() - 1);
            }
            return;
        }
        for (int i = 0; i * coins[index] <= target - curValue; i++) {
            comb.add(i);
            combinations(target, coins, index + 1, curValue + i * coins[index], comb, result);
            comb.remove(comb.size() - 1);
        }
    }

    //this is a test
}

package combinations;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Question 216: Combination Sum III
 *
 * Find all possible combinations of k numbers that add up to a number n, given that only numbers from 1 to 9 can be used and each combination should be a unique set of numbers.
 *
 * Note:
 *      All numbers will be positive integers.
 *      The solution set must not contain duplicate combinations.
 *
 * Example 1:
 *
 * Input: k = 3, n = 7
 * Output: [[1,2,4]]
 *
 * Example 2:
 *
 * Input: k = 3, n = 9
 * Output: [[1,2,6], [1,3,5], [2,3,4]]
 *
 */
public class CombinationSumIII {
    public List<List<Integer>> combinationSum3(int number, int target) {

        List<Integer> current = new LinkedList<Integer>();
        List<List<Integer>> solution = new LinkedList<>();
        boolean[] usedArray = new boolean[9];
        int[] candidates = {1, 2, 3, 4, 5, 6, 7, 8, 9};

        dfs(candidates, target, 0, current, solution, usedArray, number);
        return solution;
    }

    private void dfs(int[] candidates, int target, int start, List<Integer> current, List<List<Integer>> solution, boolean[] usedArray, int number) {

        if (target < 0)
            return;
        if (target == 0 && current.size() == number) {
            solution.add(new LinkedList<>(current));
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            if (!usedArray[i]) {
                if (i > start && candidates[i] == candidates[i - 1] && usedArray[i-1] == false) continue;
                current.add(candidates[i]);
                usedArray[i] = true;
                dfs(candidates, target - candidates[i], i + 1, current, solution, usedArray, number);
                usedArray[i] = false;
                current.remove(current.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        CombinationSumIII combinationSumIII = new CombinationSumIII();
        System.out.println(combinationSumIII.combinationSum3(2, 8));
    }
}

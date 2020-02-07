package combinations;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Question 39: Combination Sum
 *
 * Given a set of candidate numbers (candidates) (without duplicates) and a target number (target),
 * find all unique combinations in candidates where the candidate numbers sums to target.
 *
 * The same repeated number may be chosen from candidates unlimited number of times.
 *
 *
 * Example 1:
 *
 * Input: candidates = [2,3,6,7], target = 7,
 * A solution set is:
 * [
 *   [7],
 *   [2,2,3]
 * ]
 *
 * Example 2:
 *
 * Input: candidates = [2,3,5], target = 8,
 * A solution set is:
 * [
 *   [2,2,2,2],
 *   [2,3,3],
 *   [3,5]
 * ]
 *
 */

public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        List<Integer> current = new LinkedList<Integer>();
        List<List<Integer>> solution = new LinkedList<>();

        if(candidates == null || candidates.length==0)
            return solution;

        Arrays.sort(candidates);
        dfs(candidates, target, 0, current, solution);
        return solution;
    }

    private void dfs(int[] candidates, int target, int start, List<Integer> current, List<List<Integer>> solution) {
        if (target == 0) {
            if (solution.size() == 0) {
                solution.add(new LinkedList<>(current));
                return;
            }
            else if (solution.get(solution.size()-1) != current) {
                solution.add(new LinkedList<>(current));
                return;
            }
        }

        for (int i = start; i < candidates.length; i++) {
            if (candidates[i] > target) break;
            current.add(candidates[i]);
            dfs(candidates, target - candidates[i], i, current, solution);
            current.remove(current.size()-1);
        }
    }

    public static void main(String[] args) {
        CombinationSum combinationSum = new CombinationSum();
        int[] array = new int[] {2,3,5};
        System.out.println(combinationSum.combinationSum(array, 8));
    }

}

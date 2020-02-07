package combinations;

import java.util.*;

/**
 * Question 40: Combination Sum II
 *
 * Given a collection of candidate numbers (candidates) and a target number (target),
 * find all unique combinations in candidates where the candidate numbers sums to target.
 *
 * Each number in candidates may only be used once in the combination.
 *
 * Note:
 *
 * All numbers (including target) will be positive integers.
 * The solution set must not contain duplicate combinations.
 * Example 1:
 *
 * Input: candidates = [10,1,2,7,6,1,5], target = 8,
 * A solution set is:
 * [
 *   [1, 7],
 *   [1, 2, 5],
 *   [2, 6],
 *   [1, 1, 6]
 * ]
 * Example 2:
 *
 * Input: candidates = [2,5,2,1,2], target = 5,
 * A solution set is:
 * [
 *   [1,2,2],
 *   [5]
 * ]
 *
 */

public class CombinationSum_II {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        List<Integer> current = new LinkedList<Integer>();
        List<List<Integer>> solution = new LinkedList<>();
        boolean[] usedArray = new boolean[candidates.length];

        if(candidates == null || candidates.length==0)
            return solution;

        Arrays.sort(candidates);
        dfs(candidates, target, 0, current, solution, usedArray);
        return solution;
    }

    private void dfs(int[] candidates, int target, int start, List<Integer> current, List<List<Integer>> solution, boolean[] usedArray) {
//        if (target == 0) {
//            if (solution.size() == 0) {
//                // 此处为何进行一个new操作
//                solution.add(new LinkedList<>(current));
//                return;
//            }
//            else if (solution.get(solution.size()-1) != current) {
//                solution.add(new LinkedList<>(current));
//                return;
//            }
//        }

        if (target < 0)
            return;
        if (target == 0) {
            solution.add(new LinkedList<>(current));
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            if (!usedArray[i]) {
                if (i > start && candidates[i] == candidates[i - 1] && usedArray[i-1] == false) continue;
                current.add(candidates[i]);
                usedArray[i] = true;
                dfs(candidates, target - candidates[i], i + 1, current, solution, usedArray);
                usedArray[i] = false;
                current.remove(current.size() - 1);
            }
        }
    }
    public static void main(String[] args) {
        CombinationSum combinationSum = new CombinationSum();
        int[] array = new int[] {10,1,2,7,6,1,5};
        System.out.println(combinationSum.combinationSum(array, 8));
    }
}

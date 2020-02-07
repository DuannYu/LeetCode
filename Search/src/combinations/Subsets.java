package combinations;

import java.util.ArrayList;
import java.util.List;

/**
 * Question 78 Subsets
 *
 * Given a set of distinct integers, nums, return all possible subsets (the power set).
 *
 * Note: The solution set must not contain duplicate subsets.
 *
 * Example:
 *
 * Input: nums = [1,2,3]
 * Output:
 * [
 *   [3],
 *   [1],
 *   [2],
 *   [1,2,3],
 *   [1,3],
 *   [2,3],
 *   [1,2],
 *   []
 * ]
 *
 */
public class Subsets {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> solution = new ArrayList<>();
        List<Integer> current = new ArrayList<>();
        for (int k = 0; k <= nums.length; k++)
            dfs(0, nums, k, 0, current, solution);
        return solution;
    }

    private void dfs(int start, int[] candidates, int number, int depth, List<Integer> current, List<List<Integer>> solution) {
        if (depth == number) {
            solution.add(new ArrayList<>(current));
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            current.add(candidates[i]);
            dfs(i + 1, candidates, number, depth + 1, current, solution);
            current.remove(current.size() - 1);
        }
    }

    public static void main(String[] args) {
        Subsets subsets = new Subsets();
        int nums[] = {1, 2, 3, 4};
        System.out.println(subsets.subsets(nums));
    }
}

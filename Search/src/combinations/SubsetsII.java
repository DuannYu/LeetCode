package combinations;

import java.util.*;

/**
 * Question 90: Subset II
 *
 * Given a collection of integers that might contain duplicates, nums, return all possible subsets (the power set).
 *
 * Note: The solution set must not contain duplicate subsets.
 *
 * Example:
 *
 * Input: [1,2,2]
 * Output:
 * [
 *   [2],
 *   [1],
 *   [1,2,2],
 *   [2,2],
 *   [1,2],
 *   []
 * ]
 *
 */
public class SubsetsII {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> solution = new ArrayList<>();
        List<Integer> current = new ArrayList<>();
        boolean[] usedArray = new boolean[nums.length];

        if (nums == null || nums.length == 0)
            return solution;

        Arrays.sort(nums);
//        for (int k = 1; k < nums.length; k++)
        dfs(0, nums, 0, current, solution, usedArray);
        return solution;
    }

    private void dfs(int start, int[] nums, int depth, List<Integer> current, List<List<Integer>> solution, boolean[] usedArray) {
        solution.add(new ArrayList<>(current));

        for (int i = start; i < nums.length; i++) {
            if (!usedArray[i]) {
                if (i > start && nums[i] == nums[i - 1] && usedArray[i-1] == false) continue;
                current.add(nums[i]);
                usedArray[i] = true;
                dfs(i + 1, nums, depth + 1, current, solution, usedArray);
                usedArray[i] = false;
                current.remove(current.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        Subsets subsets = new Subsets();
        int nums[] = {1, 2, 3, 3};
        System.out.println(subsets.subsets(nums));
    }
}

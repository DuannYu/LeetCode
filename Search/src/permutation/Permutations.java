package permutation;

import java.util.ArrayList;
import java.util.List;

/**
 * Question 46: Permutations
 * Given a collection of distinct integers, return all possible permutations.
 *
 * Example:
 *
 * Input: [1,2,3]
 * Output:
 * [
 *   [1,2,3],
 *   [1,3,2],
 *   [2,1,3],
 *   [2,3,1],
 *   [3,1,2],
 *   [3,2,1]
 * ]
 */
public class Permutations {
    public List<List<Integer>> permute(int[] nums) {
        if (nums.length == 0 || nums == null)
            return null;
        List<List<Integer>> permutations = new ArrayList<>();
        List<Integer> permutation = new ArrayList<>();
        boolean[] usedArray = new boolean[nums.length];
        backtracking(0, nums, usedArray, permutation, permutations);
        return permutations;

    }

    private void backtracking ( int depth, int[] nums, boolean[] usedArray, List<Integer > permutation, List < List < Integer >> permutations) {


        if (depth == nums.length) {
            permutations.add(new ArrayList<>(permutation));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (usedArray[i] == true) continue;
            permutation.add(nums[i]);
            usedArray[i] = true;
            backtracking(depth + 1, nums, usedArray, permutation, permutations);
            permutation.remove(permutation.size() - 1);
            usedArray[i] = false;

        }
    }


    public static void main(String[] args) {
        Permutations permutations = new Permutations();
        System.out.println(permutations.permute(new int[]{1,2,3}));
    }
}

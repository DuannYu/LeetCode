package combinations;

import java.util.ArrayList;
import java.util.List;

/**
 * Question 77: Combinations
 *
 * Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.
 *
 * Example:
 *
 * Input: n = 4, k = 2
 * Output:
 * [
 *   [2,4],
 *   [3,4],
 *   [2,3],
 *   [1,2],
 *   [1,3],
 *   [1,4],
 * ]
 *
 */
public class Combinations {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> solution = new ArrayList<>();
        List<Integer> current = new ArrayList<>();
        dfs(0, n, k, 0, current, solution);
        return solution;
    }

    private void dfs(int start, int end, int number, int depth, List<Integer> current, List<List<Integer>> solution) {
        if (depth == number) {
            solution.add(new ArrayList<>(current));
            return;
        }

        for (int i = start; i < end; i++) {
            current.add(i+1);
            dfs(i + 1, end, number, depth + 1, current, solution);
            current.remove(current.size() - 1);

        }
    }

    public static void main(String[] args) {
        Combinations combinations = new Combinations();
        System.out.println(combinations.combine(4, 2));
    }
}

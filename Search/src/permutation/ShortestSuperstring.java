package permutation;

/**
 * Question 943:  Find the Shortest Superstring
 *
 * Given an array A of strings, find any smallest string that contains each string in A as a substring.
 *
 * We may assume that no string in A is substring of another string in A.
 *
 *
 * Example 1:
 *
 * Input: ["alex","loves","leetcode"]
 * Output: "alexlovesleetcode"
 * Explanation: All permutations of "alex","loves","leetcode" would also be accepted.
 *
 * Example 2:
 *
 * Input: ["catg","ctaagt","gcta","ttca","atgcatc"]
 * Output: "gctaagttcatgcatc"
 */
public class ShortestSuperstring {
    private int bestLen = 0;
    int[] bestPath;
    int[][] cost;
    public String shortestSuperstring(String[] A) {
        String solution = new String();
        cost = new int[A.length][A.length];
        return solution;
    }

    private void dfs(String[] A, int depth, int used, int currentLen, int[] path) {
        if (currentLen >= bestLen) return;
        if (depth == A.length) {
            bestLen = currentLen;
            bestPath = path;
            return;
        }
    }
}

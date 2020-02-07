import java.util.Arrays;

/**
 * Question 62: Unique Paths
 *
 * A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
 *
 * The robot can only move either down or right at any point in time.
 * The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).
 *
 * How many possible unique paths are there?
 *
 * Note: m and n will be at most 100.
 *
 * Example 1:
 *
 * Input: m = 3, n = 2
 * Output: 3
 * Explanation:
 * From the top-left corner, there are a total of 3 ways to reach the bottom-right corner:
 * 1. Right -> Right -> Down
 * 2. Right -> Down -> Right
 * 3. Down -> Right -> Right
 * Example 2:
 *
 * Input: m = 7, n = 3
 * Output: 28
 *
 */
public class UniquePaths {

    public int uniquePaths(int m, int n) {
        if (m <= 0 || n <= 0) return 0;
        if (m == 1 && n == 1) return 1;

//        int[][] path = new int[m+1][n+1];
//        for (int i = 0; i < m; i++)
//            path[i][0] = 0;
//        for (int j = 0; j < n; j++)
//            path[0][j] = 0;
//
//        path[1][1] = 1;

//        for (int i = 1; i <= m; i++)
//            for (int j = 1; j <= n; j++)
//                if (path[i][j] == 0)
//                    path[i][j] = path[i - 1][j] + path[i][j - 1];
        int cur = 0;
        int up = 0;
        int left = 0;

        for (int i = 1; i <= m; i++)
            for (int j = 1; j <= n; j++) {
                cur = up + left;

            }

        return cur;

    }

    public static void main(String[] args) {
        UniquePaths up = new UniquePaths();
        System.out.println(up.uniquePaths(3, 7));
    }
}
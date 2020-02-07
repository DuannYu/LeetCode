package search;

import java.util.Arrays;

/**
 * Question 52 N-Queens II
 *
 * The n-queens puzzle is the problem of placing n queens on an n×n chessboard such that no two queens attack each other.
 *
 * Given an integer n, return the number of distinct solutions to the n-queens puzzle.
 *
 * Example:
 *
 * Input: 4
 * Output: 2
 * Explanation: There are two distinct solutions to the 4-queens puzzle as shown below.
 * [
 *  [".Q..",  // Solution 1
 *   "...Q",
 *   "Q...",
 *   "..Q."],
 *
 *  ["..Q.",  // Solution 2
 *   "Q...",
 *   "...Q",
 *   ".Q.."]
 * ]
 */
public class NQueens2 {


    private boolean[] columns;
    private boolean[] diag1;
    private boolean[] diag2;

    private int count = 0;
    int len;
    public int totalNQueens(int n) {
        len = n;
        columns = new boolean[n]; Arrays.fill(columns, false);
        diag1 = new boolean[2*n-1]; Arrays.fill(diag1, false);
        diag2 = new boolean[2*n-1]; Arrays.fill(diag2, false);

        backTracking(0);
        return count;
    }

    private boolean available(int x, int y) {
        return !columns[x] && !diag1[x+y] && !diag2[x-y+len-1];
    }

    private void updateBoard(int x, int y, boolean isPut) {
        columns[x] = isPut;
        diag1[x+y] = isPut;
        diag2[x-y+len-1] = isPut;

    }

    private void backTracking(int y) {
        if (y == len) {
            count++;
            return;
        }

        for (int x = 0; x < len; x++) {
            if (!available(x, y)) continue;
            columns[x] = true;
            diag1[x+y] = true;
            diag2[x-y+len-1] = true;
//            updateBoard(x, y, true);
            backTracking(y+1);
            columns[x] = false;
            diag1[x+y] = false;
            diag2[x-y+len-1] = false;
//            updateBoard(x, y, false);
        }
    }



    public static void main(String[] args) {
        NQueens2 nQueens = new NQueens2();
        System.out.println(nQueens.totalNQueens(4));
    }
}

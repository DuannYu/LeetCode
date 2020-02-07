package search;

import org.omg.CORBA.MARSHAL;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

/**
 *
 * Question 51: N-Queens
 *
 * Given an integer n, return all distinct solutions to the n-queens puzzle.
 *
 * Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.' both indicate a queen and an empty space respectively.
 *
 * Example:
 *
 * Input: 4
 * Output: [
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
 * Explanation: There exist two distinct solutions to the 4-queens puzzle as shown above.
 */
public class NQueens {

    private List<String> board;
    private boolean[] columns;
    private boolean[] diag1;
    private boolean[] diag2;
    private List<List<String>> solutions;

    public List<List<String>> solveNQueens(int n) {

        board = new ArrayList<>();

        columns = new boolean[n]; Arrays.fill(columns, false);
        diag1 = new boolean[2*n-1]; Arrays.fill(diag1, false);
        diag2 = new boolean[2*n-1]; Arrays.fill(diag2, false);
        solutions = new ArrayList<>();

        backTracking(n, 0);
        return solutions;
    }

    private boolean available(int x, int y, int n) {
        return !columns[x] && !diag1[x+y] && !diag2[x-y+n-1];
    }

    private void updateBoard(int x, int y, int n, boolean isPut) {
        columns[x] = isPut;
        diag1[x+y] = isPut;
        diag2[x-y+n-1] = isPut;

    }

    private void backTracking(int n, int y) {
        if (y == n) {
            solutions.add(new ArrayList<>(board));
            return;
        }

        char[] cur = new char[n];
        Arrays.fill(cur, '.');
        for (int x = 0; x < n; x++) {
            if (!available(x, y, n)) continue;
            updateBoard(x, y, n, true);
            cur[x] = 'Q';
            board.add(new String(cur));
            backTracking(n, y+1);
            updateBoard(x, y, n, false);
            cur[x] = '.';
            board.remove(board.size() - 1);
        }
    }



    public static void main(String[] args) {
        NQueens nQueens = new NQueens();
        System.out.println(nQueens.solveNQueens(4));
    }


}

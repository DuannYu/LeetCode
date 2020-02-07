package search;


/**
 * Question 79: Word Search
 *
 * Given a 2D board and a word, find if the word exists in the grid.
 *
 * The word can be constructed from letters of sequentially adjacent cell,
 * where "adjacent" cells are those horizontally or vertically neighboring.
 * The same letter cell may not be used more than once.
 *
 * Example:
 *
 * board =
 * [
 *   ['A','B','C','E'],
 *   ['S','F','C','S'],
 *   ['A','D','E','E']
 * ]
 *
 * Given word = "ABCCED", return true.
 * Given word = "SEE", return true.
 * Given word = "ABCB", return false.
 */
public class WordSearch {

//    boolean result = false;

    public boolean exist(char[][] board, String word) {

        for (int i = 0; i < board.length; i++)
            for (int j = 0; j < board[0].length; j++)
                if (dfs(board, word, i,j, 0)) return true;
        return false;
    }

    private boolean dfs(char[][] board, String word, int x, int y, int depth) {
        if (!available(board, word, x, y, depth)) return false;

        if (depth == word.length() - 1) {
            return true;
        }

        char cur = board[x][y];
        board[x][y] = '*';
        boolean found = dfs(board, word, x - 1, y, depth + 1)
                || dfs(board, word, x + 1, y, depth + 1)   // right
                || dfs(board, word, x, y-1, depth + 1)   // up
                || dfs(board, word, x, y+1, depth + 1);   // down
        board[x][y] = cur;
        return found;
    }

    private boolean available(char[][] board, String word, int x, int y, int depth) {
        if (x < 0 || y < 0 || x >= board.length || y >= board[0].length || word.charAt(depth) != board[x][y])
            return false;
        return true;
    }

    public static void main(String[] args) {
        char[][] board = {
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        };

        WordSearch wordSearch = new WordSearch();
        System.out.println(wordSearch.exist(board, "ABCCED"));


    }
}

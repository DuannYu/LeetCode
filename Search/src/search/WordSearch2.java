package search;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordSearch2 {
    Set<String> result;
    public List<String> findWords(char[][] board, String[] words) {
        result = new HashSet<>();
        WordSearchFor:
        for (String word : words)
            for (int i = 0; i < board.length; i++)
                for (int j = 0; j < board[0].length; j++)
                    if (dfs(board, word, i,j, 0)) continue WordSearchFor;

        return new ArrayList<>(result);
    }

    private boolean dfs(char[][] board, String word, int x, int y, int depth) {
        if (!available(board, word, x, y, depth)) return false;

        if (depth == word.length() - 1) {
            result.add(new String(word));
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

        String[] words = {"ABF", "ASF", "ASA"};
        WordSearch2 wordSearch = new WordSearch2();
        System.out.println(wordSearch.findWords(board, words));


    }
}

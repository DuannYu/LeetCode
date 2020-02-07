package permutation;

import java.util.ArrayList;
import java.util.List;

/**
 * Question 784: Letter Case Permutation
 *
 * Given a string S, we can transform every letter individually to be lowercase or uppercase to create another string.
 * Return a list of all possible strings we could create.
 *
 * Examples:
 * Input: S = "a1b2"
 * Output: ["a1b2", "a1B2", "A1b2", "A1B2"]
 *
 * Input: S = "3z4"
 * Output: ["3z4", "3Z4"]
 *
 * Input: S = "12345"
 * Output: ["12345"]
 */
public class LetterCasePermutation {
    public List<String> letterCasePermutation(String S) {
        List<String> solution = new ArrayList<>();
        char[] array = S.toCharArray();
        backtracking(array, 0, solution);
        return solution;
    }

    private void backtracking(char[] array, int start, List<String> solution) {
        for (int i = start; i < array.length; i++) {
            char ch = array[i];
            if (Character.isDigit(ch)) continue;
            backtracking(array, i + 1, solution);
            array[i] = invertChar(array[i]);
        }
        solution.add(new String(array));
    }

    private char invertChar(char ch) {
        if (Character.isLowerCase(ch))
            return Character.toUpperCase(ch);
        return Character.toLowerCase(ch);
    }

    public static void main(String[] args) {
        LetterCasePermutation l = new LetterCasePermutation();
        String s = new String("a1b2");
        System.out.println(l.letterCasePermutation(s));
    }
}

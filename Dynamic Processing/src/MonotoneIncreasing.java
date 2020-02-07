/**
 * Question 926: Flip String to Monotone Increasing
 *
 * A string of '0's and '1's is monotone increasing if it consists of some number of '0's (possibly 0),
 * followed by some number of '1's (also possibly 0.)
 *
 * We are given a string S of '0's and '1's, and we may flip any '0' to a '1' or a '1' to a '0'.
 *
 * Return the minimum number of flips to make S monotone increasing.
 *
 *
 *
 * Example 1:
 *
 * Input: "00110"
 * Output: 1
 * Explanation: We flip the last digit to get 00111.
 * Example 2:
 *
 * Input: "010110"
 * Output: 2
 * Explanation: We flip to get 011111, or alternatively 000111.
 * Example 3:
 *
 * Input: "00011000"
 * Output: 2
 * Explanation: We flip to get 00000000.
 *
 */
public class MonotoneIncreasing {
    public int minFlipsMonoIncr(String S) {
        // dp[i][0]: 前S[i]个字串的结果，且最后一位为0
        // dp[i][1]: 前S[i]个字串的结果，且最后一位为1
        int[][] dp = new int[S.length()+1][2];


        for (int i = 1; i <= S.length(); i++) {
            if (S.charAt(i-1) == '0') {
                dp[i][0] = dp[i-1][0];  // do not change
                dp[i][1] = Math.min(dp[i-1][0], dp[i-1][1]) + 1;
            } else {
                dp[i][0] = dp[i-1][0] + 1;
                dp[i][1] = Math.min(dp[i-1][0], dp[i-1][1]);
            }
        }

        return Math.min(dp[S.length()][0], dp[S.length()][1]);
    }

    public static void main(String[] args) {
        MonotoneIncreasing m = new MonotoneIncreasing();
        System.out.println(m.minFlipsMonoIncr("00110"));
    }
}

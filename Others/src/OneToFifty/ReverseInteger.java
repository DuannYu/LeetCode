package OneToFifty;

/**
 * Question 7: Reverse Integer
 * Given a 32-bit signed integer, reverse digits of an integer.
 *
 * Example 1:
 *
 * Input: 123
 * Output: 321
 * Example 2:
 *
 * Input: -123
 * Output: -321
 * Example 3:
 *
 * Input: 120
 * Output: 21
 */

public class ReverseInteger {
    public int reverse(int x) {
        int abs = Math.abs(x);
        if (Integer.MAX_VALUE / 10 < abs) return 0;
        StringBuilder sb = new StringBuilder(String.valueOf(Math.abs(x)));
        return isInt(sb.reverse().toString()) * (x >= 0 ? 1 : -1);
    }

    public int isInt(String val) {
        try {
            int ans = Integer.parseInt(val);
            return ans;
        } catch (NumberFormatException e) {
            return 0;
        }
    }
}

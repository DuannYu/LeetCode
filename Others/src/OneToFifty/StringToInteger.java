package OneToFifty;

/**
 * Question 8: String to Integer
 *
 * Implement atoi which converts a string to an integer.
 */
public class StringToInteger {
    public int myAtoi(String str) {
        if (str.length() == 0)
            return 0;
        str = str.trim();
        if (str.length() == 0)
            return 0;

        String[] s = str.split(" ");
        str = s[0];
        long ans = 0;

        int start = 0, sign = 1;
        if (str.charAt(start) == '-') {
            sign = -1;
            start++;
        }
        else if (str.charAt(start) == '+') {
            start++;
        }

        if (start >= str.length())
            return 0;

        if (str.charAt(start) < '0' || str.charAt(start) > '9')
            return 0;

        while (start < str.length() && str.charAt(start) >= '0' && str.charAt(start) <= '9'){
            int result = str.charAt(start) - '0';
            ans = ans * 10 + sign * result;
            if (ans > Integer.MAX_VALUE)
                return Integer.MAX_VALUE;
            if (ans < Integer.MIN_VALUE)
                return Integer.MIN_VALUE;
            start++;
        }

        return (int)ans;
    }
}

package OneToFifty;

/**
 *
 * Question 6: ZigZag Conversion
 *
 * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this:
 * (you may want to display this pattern in a fixed font for better legibility)
 *
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 *
 */
public class ZigZagConversion {
    public static String  convert(String s, int numRows) {
        if (numRows == 1) return s;
        int interval = 2 * numRows - 2, y = 0;
        boolean flag = true;

        StringBuilder ans = new StringBuilder();

        for (int i = 0; i < numRows; i++) {
            int index = i;
            int x = interval - y;

            while (index < s.length()) {
                ans.append(s.charAt(index));
                if (y == 0) {
                    index += x;
                }
                else if (x == 0) {
                    index += y;
                }
                else {
                    index += flag ? x : y;
                    flag = !flag;
                }
            }

            flag = true;
            y += 2;
        }

        return ans.toString();
    }

    public static void main(String[] args) {
        System.out.println(ZigZagConversion.convert("123456789", 4));
    }
}

package OneToFifty;

public class LongestPalindromicSubstring {
    public String longestPalindrome(String s) {
        if (s.length() < 2)
            return s;
        String even = "", odd = "", max = "", ans = s.substring(0, 1);
        for (int i = 0; i < s.length()-1; i++) {
            odd = spread(s, i, i);
            even = spread(s, i, i+1);
            max = odd.length() > even.length() ? odd : even;

            ans = max.length() > ans.length() ? max : ans;
        }

        return ans;
    }

    public String spread(String s, int left, int right) {
        while (left >= 0 && right < s.length()) {
            if (s.charAt(left) == s.charAt(right)) {
                left--;
                right++;
            }
            else break;
        }

        return s.substring(left+1, right);
    }

    public static void main(String[] args) {
        LongestPalindromicSubstring l = new LongestPalindromicSubstring();
        System.out.println(l.longestPalindrome("bb"));
    }
}

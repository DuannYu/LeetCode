package OneToFifty;

/**
 * Question 9: Palindrome Number
 */
public class PalindromeNumber {
    public boolean isPalindrome(int x) {
        String pre = String.valueOf(x);
        StringBuilder sb = new StringBuilder(pre);
        String ans = sb.reverse().toString();

        if (pre == ans)
            return true;
        return false;
    }
}

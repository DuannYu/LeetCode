package BinarySearch;

/**
 * Question 69: Sqrt(x)
 *
 * Implement int sqrt(int x).
 *
 * Compute and return the square root of x, where x is guaranteed to be a non-negative integer.
 *
 * Since the return type is an integer,
 * the decimal digits are truncated and only the integer part of the result is returned.
 *
 */
public class Sqrt {
    public int mySqrt(int x) {
        if (x == 0 || x == 1)
            return x;
        double root = x / 2;
        for (int i = 0; i < 100; i++) {
            root = root - (root*root - x) / (2*root);
        }
        return (int)root;
    }
}

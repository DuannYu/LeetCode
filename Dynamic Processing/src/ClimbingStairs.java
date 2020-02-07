import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Question 70: Climbing Stairs
 *
 * You are climbing a stair case. It takes n steps to reach to the top.
 *
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 *
 * Note: Given n will be a positive integer.
 *
 * Example 1:
 *
 * Input: 2
 * Output: 2
 * Explanation: There are two ways to climb to the top.
 * 1. 1 step + 1 step
 * 2. 2 steps
 * Example 2:
 *
 * Input: 3
 * Output: 3
 * Explanation: There are three ways to climb to the top.
 * 1. 1 step + 1 step + 1 step
 * 2. 1 step + 2 steps
 * 3. 2 steps + 1 step
 */
public class ClimbingStairs {
    private int[] solutions;
    public int climbStairs(int n) {
        solutions = new int[n+1];
        Arrays.fill(solutions, 0);
        return numOfSolutions(n);
    }

    private int numOfSolutions(int n) {
        if (n <= 1) return 1;
        if (solutions[n] > 0) return solutions[n];
        solutions[n] = numOfSolutions(n-1) + numOfSolutions(n-2);
        return solutions[n];
    }

    public static void main(String[] args) {
        ClimbingStairs combinationSum = new ClimbingStairs();
        System.out.println(combinationSum.climbStairs(2));
    }
}

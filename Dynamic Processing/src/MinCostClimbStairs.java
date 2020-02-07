import java.util.Arrays;

/**
 * Question 746: Min Cost Climbing Stairs
 *
 * On a staircase, the i-th step has some non-negative cost cost[i] assigned (0 indexed).
 *
 * Once you pay the cost, you can either climb one or two steps. You need to find minimum cost to reach the top of the floor,
 * and you can either start from the step with index 0, or the step with index 1.
 *
 * Example 1:
 * Input: cost = [10, 15, 20]
 * Output: 15
 * Explanation: Cheapest is start on cost[1], pay that cost and go to the top.
 * Example 2:
 * Input: cost = [1, 100, 1, 1, 1, 100, 1, 1, 100, 1]
 * Output: 6
 * Explanation: Cheapest is start on cost[0], and only step on 1s, skipping cost[3].
 *
 * Note:
 *  - cost will have a length in the range [2, 1000].
 *  - Every cost[i] will be an integer in the range [0, 999].
 */
public class MinCostClimbStairs {
    public int minCostClimbingStairs(int[] cost) {
        if (cost.length == 0 || cost == null) return 0;
        if (cost.length == 1) return cost[0];

        int two = cost[0];
        int one = cost[1];
        int cur = 0;

        for (int i = 2; i < cost.length; i++) {
            cur = Math.min(cost[i] + two, cost[i] + one);
            two = one;
            one = cur;
        }


        return Math.min(one, two);
    }

    public static void main(String[] args) {
        int[] array = new int[] {0,0,0,1};

        MinCostClimbStairs m = new MinCostClimbStairs();
        System.out.println(m.minCostClimbingStairs(array));

    }
}

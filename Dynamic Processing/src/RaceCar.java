import java.awt.event.MouseAdapter;
import java.util.Arrays;

/**
 * Question 818: Race Car
 * Your car starts at position 0 and speed +1 on an infinite number line.  (Your car can go into negative positions.)
 *
 * Your car drives automatically according to a sequence of instructions A (accelerate) and R (reverse).
 *
 * When you get an instruction "A", your car does the following: position += speed, speed *= 2.
 *
 * When you get an instruction "R", your car does the following: if your speed is positive then speed = -1 ,
 * otherwise speed = 1.  (Your position stays the same.)
 *
 * For example, after commands "AAR", your car goes to positions 0->1->3->3, and your speed goes to 1->2->4->-1.
 *
 * Now for some target position, say the length of the shortest sequence of instructions to get there.
 *
 * Example 1:
 * Input:
 * target = 3
 * Output: 2
 *
 * Explanation:
 * The shortest instruction sequence is "AA".
 * Your position goes from 0->1->3.
 *
 * Example 2:
 * Input:
 * target = 6
 * Output: 5
 *
 * Explanation:
 * The shortest instruction sequence is "AAARA".
 * Your position goes from 0->1->3->7->7->6.
 *
 */
public class RaceCar {

    private int[] mem;

    public int racecar(int target) {
        mem = new int[target+1];
        return dp(target);
    }

    private int dp(int target) {


        Arrays.fill(mem, 0);

        if (mem[target] > 0) return mem[target];
        // ceil: 向上取整
        int n = (int) Math.ceil(Math.log(target+1)/Math.log(2));
        // AA...A(nA) best case
        if (1 << n == target + 1) return mem[target] = n;
        // AA...AR(nA + 1R) + dp(left)
        mem[target] = n + 1 + dp((1<<n)-1-target);
        for (int m = 0; m < n - 1; m++) {
            int cur = (1 << (n - 1)) - (1 << m);
            //AA...ARA...AR(n-1A + 1R + mA + 1R) + dp(left)
            mem[target] = Math.min(mem[target], n + m + 1 + dp(target-cur));
        }
        return mem[target];
    }

    public static void main(String[] args) {
        RaceCar rc = new RaceCar();
        System.out.println(rc.racecar(6));
    }
}

import java.awt.event.MouseAdapter;
import java.util.Arrays;
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

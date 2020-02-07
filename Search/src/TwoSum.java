
import java.util.HashMap;

/**
 * Question 1
 */

public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

        for (int i = 0; i < nums.length; i++)
            map.put(nums[i], i);

        for (int i = 0; i < nums.length; i++) {
            int left = target - nums[i];
            if (map.containsKey(left) && map.get(left) != i)
                return new int[] {i, map.get(left)};
        }
        throw new IllegalArgumentException("No two sum solution");
    }
}

import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;

/**
 * Question 169: Majority Element
 * Given an array of size n, find the majority element.
 * The majority element is the element that appears more than ⌊ n/2 ⌋ times.
 *
 * You may assume that the array is non-empty and the majority element always exist in the array.
 */
public class MajorityElement {
    public static int majorityElement(int[] nums) {
        Map<Integer, Integer> counter = new TreeMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (!counter.containsKey(nums[i])) {
                counter.put(nums[i], 0);
                continue;
            }


            int value = counter.get(nums[i]);
            value++;
            counter.put(nums[i], value);
        }

        int maxkey = nums[0], maxvalue = counter.get(nums[0]);

        for (Integer key : counter.keySet()) {
            if (maxvalue > counter.get(key)) {
                continue;
            }

            maxvalue = counter.get(key);
            maxkey = key;

        }

        return maxkey;
    }

}

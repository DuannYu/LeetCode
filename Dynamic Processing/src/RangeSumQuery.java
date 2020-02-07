import java.util.Random;

/**
 * Question 303: Range Sum Query - Immutable
 *
 * Given an integer array nums, find the sum of the elements between indices i and j (i ≤ j), inclusive.
 *
 * Example:
 * Given nums = [-2, 0, 3, -5, 2, -1]
 *
 * sumRange(0, 2) -> 1
 * sumRange(2, 5) -> -1
 * sumRange(0, 5) -> -3
 */
public class RangeSumQuery {

    private int[] sums;
    public RangeSumQuery(int[] nums) {
        sums = new int[nums.length + 1];
        sums[0] = 0;
        for (int i = 1; i < sums.length; i++)
            sums[i] = nums[i - 1] + sums[i - 1];
    }

    public int sumRange(int i, int j) {
        return sums[j + 1] - sums[i];
    }

    public static void main(String[] args) {
        RangeSumQuery r = new RangeSumQuery(new int[]{-2,0,3,-5,2,-1});
        System.out.println(r.sumRange(2,5));
    }
}
// 0,2,3,5,8
/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(i,j);
 *
 * NumArray is equal to RangeSumQuery.
 */

package BST;

/**
 * Question 108:
 * Given an array where elements are sorted in ascending order,
 * convert it to a height balanced BST.
 *
 * For this problem,
 * a height-balanced binary tree is
 * defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.
 *
 */
public class BuildBST {
    public TreeNode sortedArrayToBST(int[] nums) {
        return buildTree(nums, 0, nums.length-1);
    }

    public TreeNode buildTree(int[] nums, int l, int r) {
        if (l > r)
            return null;
        if (l == r) {
            return new TreeNode(nums[l]);
        }

        int mid = (r - l) / 2 + l;

        TreeNode node = new TreeNode(nums[mid]);
        node.left = buildTree(nums, l, mid-1);
        node.right = buildTree(nums, mid+1, r);
        return node;
    }
}

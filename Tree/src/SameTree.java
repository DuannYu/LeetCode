/**
 * Question 100: Same Tree
 *
 * Given two binary trees, write a function to check if they are the same or not.
 *
 * Two binary trees are considered the same if they are structurally identical and the nodes have the same value.
 */
public class SameTree {
    public boolean isSameTree(TreeNode s, TreeNode t) {
        if (s == null && t == null)
            return true;
        if (s != null && t == null)
            return false;
        if (s == null && t != null)
            return false;
        if (s.val != t.val)
            return false;
        return isSameTree(s.left, t.left) && isSameTree(s.right, t.right);
    }
}

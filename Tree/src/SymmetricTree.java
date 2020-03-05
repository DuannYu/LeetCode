import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Question 101: Symmetric Tree
 *
 * Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).
 *
 * For example, this binary tree [1,2,2,3,4,4,3] is symmetric
 *
 * But the following [1,2,2,null,3,null,3] is not
 */

public class SymmetricTree {
    List<Integer> leftList, rightList;

    public boolean isSymmetric(TreeNode root) {
        leftList = new LinkedList<>();
        rightList = new LinkedList<>();

        left(root.left);
        right(root.right);

        for (int elem : leftList) {
            System.out.print(elem);
        }

        for (int elem : rightList) {
            System.out.print(elem);
        }
        return Arrays.equals(leftList.toArray(), rightList.toArray());
    }

    private int left(TreeNode root) {
        if (root == null)
            return 0;
        leftList.add(left(root.left));
        leftList.add(left(root.right));
        leftList.add(root.val);
        return root.val;
    }

    private int right(TreeNode root) {
        if (root == null)
            return 0;
        rightList.add(right(root.right));
        rightList.add(right(root.left));
        rightList.add(root.val);
        return root.val;
    }
}

package BST;

import java.util.ArrayList;
import java.util.List;

/**
 * Question 99: Recover Binary Search Tree
 *
 * Two elements of a binary search tree (BST) are swapped by mistake.
 *
 * Recover the tree without changing its structure.
 */
public class RecoverBST {
    int x = -1, y = -1;
    List<Integer> result = new ArrayList<>();
    public void recoverTree(TreeNode root) {
        inorder(root);
        findTwoErrorNumber(result);
        recover(root);
    }

    private void inorder(TreeNode root) {
        if (root == null)
            return;

        inorder(root.left);
        result.add(root.val);
        inorder(root.right);
    }

    private void findTwoErrorNumber(List<Integer> list) {
        for (int i = 0; i < list.size()-1; i++) {
            if (list.get(i) > list.get(i+1)) {
                y = list.get(i+1);
                if (x == -1)
                    x = list.get(i);
                else
                    break;
            }
        }
    }

    private void recover(TreeNode root) {
        if (root == null)
            return;

        if (root.val == x) {
            root.val = y;
        }
        else if (root.val == y){
            root.val = x;
        }

        recover(root.left);
        recover(root.right);
    }

}

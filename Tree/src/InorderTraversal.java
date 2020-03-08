import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Question 94: Binary Tree Inorder Traversal
 *
 * Example:
 *
 * Input: [1,null,2,3]
 *    1
 *     \
 *      2
 *     /
 *    3
 *
 * Output: [1,3,2]
 * Follow up: Recursive solution is trivial, could you do it iteratively?
 */

public class InorderTraversal {
    public List<Integer> inorderTraversal(TreeNode root) {
        List answer = new ArrayList();
        Stack<TreeNode> stack = new Stack<>();

        while (!stack.isEmpty() || root != null) {
            if (root != null) {
                stack.push(root);
                root = root.left;
            }
            else {
                root = stack.pop();
                answer.add(root.val);
                root = root.right;
            }
        }
        return answer;
    }
}

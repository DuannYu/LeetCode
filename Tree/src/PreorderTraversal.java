import java.util.*;

/**
 * Question 144: Binary Tree Preorder Traversal
 *
 * Given a binary tree, return the preorder traversal of its nodes' values.
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
 * Output: [1,2,3]
 */
public class PreorderTraversal {
    public List<Integer> preorderTraversal(TreeNode root) {
        List answer = new ArrayList();

        if (root == null)
            return new ArrayList<>();

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while (!stack.empty()) {
            TreeNode treeNode = stack.peek();
            answer.add(treeNode.val);
            stack.pop();

            if (treeNode.left != null) stack.push(treeNode.right);
            if (treeNode.right != null) stack.push(treeNode.left);
        }

        return answer;
    }

}

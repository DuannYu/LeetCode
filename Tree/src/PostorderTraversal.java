import java.util.*;

/**
 * Question 145: Binary Tree Postorder Traversal
 *
 * Given a binary tree, return the postorder traversal of its nodes' values.
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
 * Output: [3,2,1]
 */
public class PostorderTraversal {
    public List<Integer> postorderTraversal(TreeNode root) {

        List<Integer> answer = new LinkedList<>();

//         1. recursive
//
//        if (root == null)
//            return new ArrayList<>();
//
//        answer.addAll(postorderTraversal(root.left));
//        answer.addAll(postorderTraversal(root.right));
//        answer.add(root.val);
//        return answer;

        // 2. iterative method using stack

        if (root == null)
            return new ArrayList<>();

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while (!stack.empty()) {
            TreeNode treeNode = stack.peek();
            answer.add(treeNode.val);
            stack.pop();

            if (treeNode.left != null) stack.push(treeNode.left);
            if (treeNode.right != null) stack.push(treeNode.right);
        }

        Collections.reverse(answer);
        return answer;
    }
}

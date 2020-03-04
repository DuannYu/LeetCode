import java.util.*;

/**
 * Question 590: N-ary Tree Postorder Traversal
 *
 * Given an n-ary tree, return the postorder traversal of its nodes' values.
 *
 * Nary-Tree input serialization is represented in their level order traversal,
 * each group of children is separated by the null value (See examples).
 *
 */
public class NaryTreePostorderTraversal {
    public List<Integer> postorder(Node root) {
        if (root == null)
            return new LinkedList<>();

        List<Integer> answerList = new LinkedList<>();
        Stack<Node> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            Node node = stack.pop();
            answerList.add(node.val);

            for (Node child : node.children) {
                stack.add(child);
            }
        }

        Collections.reverse(answerList);
        return answerList;
    }
}

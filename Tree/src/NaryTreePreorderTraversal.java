import java.util.*;

/**
 * Question 489: N-ary Tree Preorder Traversal
 *
 * Given an n-ary tree, return the preorder traversal of its nodes' values.
 *
 * Nary-Tree input serialization is represented in their level order traversal,
 * each group of children is separated by the null value (See examples).
 *
 */
public class NaryTreePreorderTraversal {
    public List<Integer> preorder(Node root) {
        List<Integer> answerList = new LinkedList<>();

        // Solution 1: recursion
//        if (root == null)
//            return new LinkedList<>();
//
//        answerList.add(root.val);
//        for (Node child: root.children) {
//            answerList.addAll(preorder(child));
//        }

        // Solution 2: iteration using stack
        Stack<Node> stack = new Stack<>();

        stack.push(root);
        while (!stack.isEmpty()) {
            Node node = stack.pop();
            answerList.add(node.val);

            for (int i = node.children.size()-1; i >= 0; i--) {
                stack.push(node.children.get(i));
            }
        }

        return answerList;
    }
}

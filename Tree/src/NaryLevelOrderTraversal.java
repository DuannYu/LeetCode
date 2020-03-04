import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Question 429: N-ary Tree Level Order Traversal
 *
 * Given an n-ary tree, return the level order traversal of its nodes' values.
 *
 * Nary-Tree input serialization is represented in their level order traversal,
 * each group of children is separated by the null value (See examples).
 *
 * Example 1:
 * Input: root = [1,null,3,2,4,null,5,6]
 * Output: [[1],[3,2,4],[5,6]]
 *
 * Example 2:
 * Input: root = [1,null,2,3,4,5,null,null,6,7,null,8,null,9,10,null,null,11,null,12,null,13,null,null,14]
 * Output: [[1],[2,3,4,5],[6,7,8,9,10],[11,12,13],[14]]
 */
public class NaryLevelOrderTraversal {
    public List<List<Integer>> levelOrder(Node root) {
        if (root == null)
            return new LinkedList<>();

        int currentLevelCount = 1;
        int nextLevelCount = 0;
        List<List<Integer>> answer = new LinkedList<>();
        List<Integer> levelAnswer = new LinkedList<>();

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (queue.size() != 0) {
            while (currentLevelCount != 0) {
                Node node = queue.peek();
                levelAnswer.add(node.val);
                queue.poll();
                currentLevelCount--;
                for (Node child : node.children) {
                    queue.add(child);
                    nextLevelCount++;
                }
            }


            currentLevelCount = nextLevelCount;
            nextLevelCount = 0;
            if (levelAnswer == null)
                answer.add(new LinkedList());
            answer.add(levelAnswer);
            levelAnswer = new LinkedList<>();
        }

        return answer;
    }
}

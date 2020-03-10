import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Question 102: Binary Tree Level Order Traversal
 *
 * Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).
 *
 * For example:
 * Given binary tree [3,9,20,null,null,15,7],
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * return its level order traversal as:
 * [
 *   [3],
 *   [9,20],
 *   [15,7]
 * ]
 *
 */
public class LevelOrderTraversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null)
            return new LinkedList<>();

        int currentLevelCount = 1;
        int nextLevelCount = 0;
        List<List<Integer>> answer = new LinkedList<>();
        List<Integer> levelAnswer = new LinkedList<>();

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (queue.size() != 0) {
            while (currentLevelCount != 0) {
                TreeNode node = queue.poll();
                levelAnswer.add(node.val);
                currentLevelCount--;

                if (node.left != null) {
                    queue.add(node.left);
                    nextLevelCount++;
                }

                if (node.right != null) {
                    queue.add(node.right);
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

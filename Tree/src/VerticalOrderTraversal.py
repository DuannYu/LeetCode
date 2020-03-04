'''
Question 987: Vertical Order Traversal of a Binary Tree

Given a binary tree, return the vertical order traversal of its nodes values.

For each node at position (X, Y), its left and right children respectively will be at positions (X-1, Y-1) and (X+1, Y-1).

Running a vertical line from X = -infinity to X = +infinity, whenever the vertical line touches some nodes,

we report the values of the nodes in order from top to bottom (decreasing Y coordinates).

If two nodes have the same position, then the value of the node that is reported first is the value that is smaller.

Return an list of non-empty reports in order of X coordinate.  Every report will have a list of values of nodes.
'''

# Definition for a binary tree node.
class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

class Solution:
    def verticalTraversal(self, root: TreeNode) -> List[List[int]]:

        maps = collections.defaultdict(
                          lambda: collections.defaultdict(list))

        def dfs(node, x=0, y=0):
            if node:
                maps[x][y].append(node)
                dfs(node.left, x-1, y+1)
                dfs(node.right, x+1, y+1)
        
        dfs(root)
        ans = []

        sorted(maps)

        for key in sorted(maps):
            temp = []
            for value in sorted[maps[key]]:
                temp.extend(sorted(node.val for node in maps[x][y]))
            
            ans.append(temp)
        
        return ans

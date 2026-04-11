# https://neetcode.io/problems/balanced-binary-tree/question?list=neetcode150
from typing import Optional

# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

class Solution:
    def isBalanced(self, root: Optional[TreeNode]) -> bool:
        def dfs(node: TreeNode) -> int:
            if node is None:
                print(f"node is None")
                height = 0
                return height
            if node.left is None and node.right is None:
                print("node left and right is None")
                print(f"at Node val {node.val}, height is 1")
                height = 1
                return height
            
            left_height = dfs(node.left)
            right_height = dfs(node.right)
            print(f"at Node val {node.val}, left_height: {left_height} & right_height: {right_height}")
            return max(left_height, right_height) + 1
        if root is not None:
            left_depth = dfs(root.left)
            right_depth = dfs(root.right)
            print(left_depth)
            print(right_depth)
            if abs(left_depth - right_depth) > 1:
                return False
            else:
                return True
        else:
            return True
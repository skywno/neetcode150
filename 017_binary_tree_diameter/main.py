from typing import Optional


class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

class Solution:
    def diameterOfBinaryTree(self, root: Optional[TreeNode]) -> int:
        s   elf.diameter = 0

        def depth(node) -> int:
            if not node:
                return 0
            
            left_depth = depth(node.left)
            right_depth = depth(node.right)

            self.diameter = max(self.diameter, left_depth + right_depth)

            return 1 + max(left_depth, right_depth)
        
        depth(root)
        return self.diameter
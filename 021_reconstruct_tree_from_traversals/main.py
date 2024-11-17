from typing import List, Optional


class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

class Solution:
    def buildTree(self, preorder: List[int], inorder: List[int]) -> Optional[TreeNode]:

        if not preorder or not inorder:
            return None
        
        root_val = preorder[0]
        root = TreeNode(root_val)

        root_idx_in_inorder = inorder.index(root_val)
        
        # Calculate lengths and slices based on root's index in inorder
        left_inorder = inorder[:root_idx_in_inorder]
        right_inorder = inorder[root_idx_in_inorder + 1:]
        
        # The length of left_inorder gives us the correct range in preorder
        left_preorder = preorder[1:1 + len(left_inorder)]
        right_preorder = preorder[1 + len(left_inorder):]

        root.left = self.buildTree(left_preorder, left_inorder)
        root.right = self.buildTree(right_preorder, right_inorder)

        return root

from collections import deque
from typing import List, Optional


class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

class Solution:

    # NAIVE BRUTEFORCE
    def rightSideView(self, root: Optional[TreeNode]) -> List[int]:
        q = deque()
        if root:
            q.append(root)
        
        ret = []
        while q:

                len_q = len(q)
                for i in range(len_q):
                    node = q.popleft()
                    if node.left:
                        q.append(node.left)
                    if node.right:
                        q.append(node.right)
                    if i == len_q - 1:
                        ret.append(node.val)
        return ret

    #DFS
    def rightSideView2(self, root: Optional[TreeNode]) -> List[int]:
        ret = []

        def dfs(node, depth):
            if not node:
                return None
            if depth == len(ret):
                ret.append(node.val)
            
            dfs(node.right, depth + 1)
            dfs(node.left, depth + 1)
        
        dfs(root, 0)

        return ret
    
    #BFS
    def rightSideView2(self, root: Optional[TreeNode]) -> List[int]:
        ret = []
        q = deque([root])
    
        def dfs(node, depth):
            if not node:
                return None
            if depth == len(ret):
                ret.append(node.val)
            
            dfs(node.right, depth + 1)
            dfs(node.left, depth + 1)
        
        dfs(root, 0)

        return ret
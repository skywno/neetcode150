#https://neetcode.io/problems/clone-graph/question?list=neetcode150
from ast import Set
from typing import Optional, List

# Definition for a Node.
class Node:
    def __init__(self, val = 0, neighbors = None):
        self.val = val
        self.neighbors = neighbors if neighbors is not None else []

class Solution:
    def cloneGraph(self, node: Optional['Node']) -> Optional['Node']:
        visited = {}
        def visit(node: Optional[Node]):
            if node is None:
                return None
            if node in visited:
                return visited[node]  
            else:
                clone = Node(node.val)
                visited[node] = clone
                clone.neighbors = [c for c in (visit(n) for n in node.neighbors) if c is not None]
                return clone

        return visit(node)
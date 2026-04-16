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
            if node not in visited.keys():
                clone = Node(node.val)
                visited[node] = clone
                # we don't know the neighbors yet.
                for neighbor in node.neighbors:
                    neighbor_clone = visit(neighbor)
                    if neighbor_clone is not None:
                        clone.neighbors.append(neighbor_clone) 
                return clone
            else:
                return visited[node]

        return visit(node)
from typing import List

class Solution:
    def minCostClimbingStairs(self, cost: List[int]) -> int:
        cache: List[int] = [None] * len(cost)
        def dfs(step: int):
            if step >= len(cost):
                return 0

            if cache[step] is None:
                min_cost = cost[step] + min(dfs(step + 1), dfs(step + 2))
                cache[step] = min_cost
            return cache[step]
        
        return min(dfs(0), dfs(1))
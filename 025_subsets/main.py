from typing import List


class Solution:

    #backtracking
    def subsets(self, nums: List[int]) -> List[List[int]]:
        res = []

        subset = []
        def dfs(i):
            if i >= len(nums):
                res.append(subset.copy())
                return
            subset.append(nums[i])
            dfs(i+1)
            subset.pop()
            dfs(i+1)

        dfs(0)

        return res
    

    def subsets1(self, nums:List[int]) -> List[List[int]]:
        res = [[]]

        for num in nums:
            res += [[num] + subset for subset in res]

        return res
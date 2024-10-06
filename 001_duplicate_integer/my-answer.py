from typing import List

class Solution:
    def hasDuplicate(self, nums: List[int]) -> bool:
        for num_1 in nums:
            count = 0
            for num_2 in nums:
                if num_1 == num_2:
                    count += 1
                if count > 1:
                    return True
        return False

print(Solution().hasDuplicate([1,1,1,2,2,2]))
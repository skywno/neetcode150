from typing import List

class Solution:
    def threeSum(self, nums: List[int]) -> List[List[int]]:
        #BruteForce
        # three nested loops

        # two pointers
        res = []
        nums.sort()

        for i, num in enumerate(nums):
            if num > 0:
                break
            
            # The output should not contain any duplicate triplets. 
            if i > 0 and num == nums[i-1]:
                continue

            l, r = i + 1, len(nums) - 1
            while l < r:
                threeSum = num + nums[l] + nums[r]
                if threeSum > 0:
                    r -= 1
                elif threeSum < 0:
                    l += 1
                else:
                    res.append([a, nums[l], nums[r]])
                    l += 1
                    r-= 1
                    while nums[l] == nums[l-1] and l < r:
                        l += 1
        return res
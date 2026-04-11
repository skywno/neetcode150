from typing import List
from math import ceil

class Solution:
    def minEatingSpeed(self, piles: List[int], h: int) -> int:
        l, r = 1, max(piles)
        while l < r:
            mid = (l + r) // 2
            hours = sum([ceil(pile / mid) for pile in piles])
            if hours < h:
                r = mid
            else:
                l = mid + 1
        return l
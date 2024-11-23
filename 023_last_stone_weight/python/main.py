from typing import List


class Solution:
    def lastStoneWeight(self, stones: List[int]) -> int:
        maxStone = max(stones)
        buckets = [0] * (maxStone + 1)
        for stone in stones:
            buckets[stone] += 1
        
        first = second = maxStone
        while first > 0:
            if buckets[first] % 2 == 0:
                first -= 1
                continue
            # else current bucket has the odd number of stones
            # then check the stone from the previous buckets and the current bucket
            j = min(first - 1, second)
            while (buckets[j] == 0 and j > 0):
                j -= 1
            if (j == 0):
                return first # we already have found the last heaviest stone
            
            second = j
            buckets[first] -= 1
            buckets[second] -= 1
            buckets[first-second] += 1
            first = max(first-second, second)
        return first


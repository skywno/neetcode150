from typing import List
import heapq as hq 


class KthLargest:
    def __init__(self, k: int, nums: List[int]):
        self.minheap, self.k = nums, k
        hq.heapify(self.minheap)
        while len(self.minheap) > k:
            hq.heappop(self.minheap)

    def add(self, val: int) -> int:
        hq.heappush(self.minheap, val)
        if len(self.minheap) > self.k:
            hq.heappop(self.minheap)
        return self.minheap[0]




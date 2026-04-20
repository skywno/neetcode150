from typing import List

class Solution:
    def insert(self, intervals: List[List[int]], newInterval: List[int]) -> List[List[int]]:
        newIntervals: List[List[int]] = []

        i = 0 
        n = len(intervals)

        while i < len(intervals) and intervals[i][1] < newInterval[0]:
            newIntervals.append(intervals[i])
            i += 1

        newCandidateInterval = newInterval
        while i < len(intervals) and newInterval[1] >= intervals[i][0]:
            newCandidateInterval[0] = min(newCandidateInterval[0], intervals[i][0])
            newCandidateInterval[1] = max(newCandidateInterval[1], intervals[i][1])
            i += 1
        
        newIntervals.append(newCandidateInterval)

        while i < len(intervals):
            newIntervals.append(intervals[i])
            i+=1
        return newIntervals
from typing import List

class Solution:
	# Run time: 31ms, beating 36.21%
	# Memory: 8.0 MB: beating 96.05%
    def generateParenthesis(self, n: int) -> List[str]:
        def dfs(candidates: str, open: int, close: int) -> List[str]:
            if len(candidates) == 2*n and open == close:
                return [candidates]
            if len(candidates) == 2*n and open > close:
                return []
            elif open < close:
                return []
            else:
                temp_1 = dfs(candidates + "(", open + 1, close)
                temp_2 = dfs(candidates + ")", open, close + 1)
                return [*temp_1, *temp_2]

        resp = dfs("", 0, 0)
        return resp


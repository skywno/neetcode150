class Solution:
    def isAnagram(self, s: str, t: str) -> bool:
        if len(s) != len(t):
            return False

        s_count, t_count ={}, {}
        for i in len(s):
            s_count[s[i]] += s_count.get(s[i], 0)
            t_count[t[i]] += t_count.get(t[i], 0)
        if s_count == t_count:
              return True
        else:
            return False
        
    def isAnagram2(self, s: str, t:str) -> bool:
        if len(s) != len(t):
            return False
            
        return sorted(s) == sorted(t)
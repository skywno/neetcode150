class Solution:
    def isPalindrome(self, s: str) -> bool:
            s = ''.join([x for x in s.lower() if x.isalnum()])
            
            i = 0;
            j = len(s)
            while (i < j):
                if s[i] != s[j]:
                    return False
                i = i + 1
                j = j - 1
            return True
    
    def isPalindrome_refactored(self, s: str) -> bool:
        s = ''.join([x for x in s.lower() if x.isalnum()])
        return s == s[::-1]
from pickle import FALSE


class Solution:

    # First try
    def isValid(self, s: str) -> bool:
        opening_brackets = {'(', '{', '['}
        closing_brackets = {')', '}', ']'}
        parenthesis = []
        
        for p in s:
            if p in opening_brackets:
                parenthesis.append(p)
            else:
                if not parenthesis:
                    return False
                opening_brakcet = parenthesis.pop()
                if p == ")" and opening_brakcet != "(":
                        return False
                elif p == "]" and opening_brakcet != "[":
                        return False
                elif p == "{" and opening_brakcet != "}":
                    return False
        if parenthesis:
            return False
        return True

    # Second try
    def isValid2(self, s: str) -> bool:
        while '()' in s or '{}' in s or '[]' in s:
            s = s.replace('()', "")
            s = s.replace('[]', "")
            s = s.replace('{}', "")
        return s == ""
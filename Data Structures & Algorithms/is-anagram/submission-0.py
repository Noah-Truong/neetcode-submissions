class Solution:
    def isAnagram(self, s: str, t: str) -> bool:
        if len(s) != len(t):
            return False
        i = 0

        while i > len(s) or t:
            if not s[i] in t: 
                return False
            for j in range(len(t)):
                if s[i] == t[j]:
                    t = t[:j] + t[j + 1:] 
                    break
            i += 1
        return True

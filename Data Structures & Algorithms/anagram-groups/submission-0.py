class Solution:
    def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
        result = []
        def isAnagram(n, m):
            n = str(n)
            m = str(m)
            if len(n) != len(m):
                return False
            i = 0
            while i < len(n) or m:
                if n[i] in m:
                    for j in range(len(m)):
                        if n[i] == m[j]:
                            m = m[:j] + m[j+1:]
                            break
                else: 
                    return False
                i += 1
            return True
        def exist(word):
            for l in result:
                if word in l:
                    return True
            return False

        for i in range(len(strs)):
            if not exist(strs[i]):
                sub = []
                for j in range(len(strs)):
                    if isAnagram(strs[i],strs[j]):
                        sub.append(strs[j])
                result.append(sub)
        return result
        
        return result
        
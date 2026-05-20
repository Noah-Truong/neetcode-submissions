class Solution:

    def encode(self, strs: List[str]) -> str:
        msg = ''
        for s in strs:
            msg = msg + str(len(s)) + ' '
            msg = msg + s
        return msg

    def decode(self, s: str) -> List[str]:
        msg = []
        word = ''
        i = 0
        while i < len(s):
            numString = ''
            while s[i] != ' ':
                numString += s[i]
                i += 1
            length = int(numString)
            for j in range(length):
                i += 1
                word += s[i]
            msg.append(word)
            word = ''
            i += 1
                
        return msg
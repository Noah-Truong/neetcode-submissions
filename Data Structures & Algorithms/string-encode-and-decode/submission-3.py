class Solution:

    def encode(self, strs: List[str]) -> str:
        msg = ''
        for s in strs:
            msg = msg + s 
            msg = msg + '私'
        return msg

    def decode(self, s: str) -> List[str]:
        msg = []
        word = ''
        for char in s:
            if not char == '私':
                word = word + char
            else:
                msg.append(str(word))
                word = '' 
        return msg
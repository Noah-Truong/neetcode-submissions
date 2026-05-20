class Solution:
    def hasDuplicate(self, nums: List[int]) -> bool:
        past = []
        for i in nums:
            if not i in past:
                past.append(i)
            else:
                return True
        return False
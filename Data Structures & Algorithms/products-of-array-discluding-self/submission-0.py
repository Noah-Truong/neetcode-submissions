class Solution:
    def productExceptSelf(self, nums: List[int]) -> List[int]:
        result = []
        for i in range(len(nums)):
            mult = 1
            for j in range(len(nums)):
                if j != i:
                    mult *= nums[j]
            result.append(mult)
            mult = 1
        return result
            
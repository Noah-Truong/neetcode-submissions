class Solution:
    def combinationSum(self, nums: List[int], target: int) -> List[List[int]]:
        res = []
        if (nums == []):
            return []
        curr = []
        for i in range(0, target//nums[0]):
            curr.append(nums[0])
            sub = (i + 1) * nums[0]
            n = self.combinationSum(nums[1:], target - sub)

            if (target - sub == 0):
                res.append(curr)
            if (n != []):
                for s in n:
                    res.append(curr + s)
            
        
        res += self.combinationSum(nums[1:], target)
        return res
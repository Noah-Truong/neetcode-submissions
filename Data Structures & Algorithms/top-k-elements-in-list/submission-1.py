class Solution:
    def topKFrequent(self, nums: List[int], k: int) -> List[int]:
        cache = {}
        result = []
        for i in nums:
            if not i in cache.keys():
                count = 0
                for j in nums:
                    if i == j:
                        count += 1
                cache[i] = count
        cache = dict(sorted(cache.items(), key=lambda item: item[1], reverse=True))
        keys = list(cache.keys())
        for i in range(k):
            result.append(keys[i])
        return result
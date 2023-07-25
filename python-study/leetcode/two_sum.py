from typing import List


class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        return Solution.twoSum2(self, nums, target)

    def twoSum1(self, nums: List[int], target: int) -> List[int]:
        idx = {}  # 创建一个空哈希表（字典）
        for j, x in enumerate(nums):  # x=nums[j]
            jindex = idx.get(target - x, None)
            if jindex is not None:
                return [idx[int(target - x)], j]
            idx[x] = j  # 保存 nums[j] 和 j

class Solution {
    public int search(int[] nums, int target) {
        if (nums.length == 1 && nums[0] != target) {
            return -1;
        }
        if (nums.length == 2 && nums[1] != target && nums[0] != target) {
            return -1;
        }

        if (nums[0] > target && nums[nums.length -1] > nums[0]) {
            return -1;
        }

        if (nums[0] == target) {
            return 0;
        }
        if (nums[nums.length -1] == target) {
            return nums.length -1;
        }
        
        for (int i = 0; i < (nums.length -1)/2; i++) {
            if (nums[nums.length/2 + i] == target) {
                return nums.length/2 + i;
            }
            if (nums[nums.length/2 -1 -i] == target) {
                return nums.length/2 -1 -i;
            }
        }
        return -1;

        

    }
}

class Solution {
    public int findMin(int[] nums) {
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        if (nums.length == 1) {
            return nums[0];
        }
        for (int i = 0; i < nums.length/2; i++) {
            if (nums[i] < nums[i + nums.length/2]) {
                heap.add(nums[i]);
            } else {
                heap.add(nums[i + nums.length/2]);
            }
        }
        if (nums.length % 2 != 0) {
            heap.add(nums[nums.length-1]);
        }
        return heap.poll();
        
    }

    
}

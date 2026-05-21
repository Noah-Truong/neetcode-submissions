class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> result = new HashSet<>();
        
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    if (nums[i] + nums[j] + nums[k] == 0) {
                        List<Integer> in = new ArrayList<>(List.of(nums[i], nums[j], nums[k]));
                        in.sort(null);
                        result.add(in);
                    }
                }
            }
        }

        List<List<Integer>> result2 = new ArrayList<>(result);
        return result2;
        

    }
}

class Solution {
    public int maxArea(int[] heights) {
        int result = 0; 
        for (int i = 0; i < heights.length; i++) {
            for (int j = i + 1; j < heights.length; j++) {
                int test = Math.min(heights[i], heights[j]) * (j - i);
                result = Math.max(test, result);
            }
        }
        return result;
    }
}

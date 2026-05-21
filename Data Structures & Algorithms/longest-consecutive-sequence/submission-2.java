class Solution {
    public int longestConsecutive(int[] nums) {
        int result = 0;
        int curr = 0;
        Set<Integer> s = new TreeSet<>();
        for (int n: nums) {
            s.add(n);
        }
       
        for (int n: s) {
            int p = n;
            curr++;
            while (s.contains(p+1)) {
                curr++;
                p++;
            }
            result = Math.max(curr, result);
            curr = 0;
        }

        return result;
    }
}

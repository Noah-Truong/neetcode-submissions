class Solution {
    public int lengthOfLongestSubstring(String s) {
        char[] arr = s.toCharArray();
        int result = 0;
        for (int i = 0; i < arr.length; i++) {
            Set<Character> hs = new HashSet<>();
            hs.add(arr[i]);
            int j = i + 1;
            while (j < arr.length && !hs.contains(arr[j])) {
                hs.add(arr[j]);
                j++;
            }
            result = Math.max(result, hs.size());
        }
        return result;
    }
}

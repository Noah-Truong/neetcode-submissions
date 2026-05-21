class Solution {
    public boolean isPalindrome(String s) {
        List<Character> condensed = new ArrayList<>();
        for (char c: s.toCharArray()) {
            if (Character.isLetterOrDigit(c)) {
            condensed.add(Character.toLowerCase(c));
            }

        }
        for (int i = 0; i < condensed.size()/2; i++) {
            if (condensed.get(i) != condensed.get(condensed.size() -1 -i)) {
                return false;
            }
        }
        return true;
    }
}

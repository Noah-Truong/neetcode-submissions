class Solution {
    

    public String minWindow(String s, String t) {

        
        
        Map<Character, Integer> sub_freq = new HashMap<>();
        int[] res = {-1, -1};
        int reslen = Integer.MAX_VALUE;
        for (int i = 0; i < t.length(); i++) {
            if (!sub_freq.containsKey(t.charAt(i))) {
                sub_freq.put(t.charAt(i), 1);
            } else {
                sub_freq.put(t.charAt(i), 1+sub_freq.get(t.charAt(i)));
            }
        }

        for (int i = 0; i < s.length(); i++) {
            Map<Character, Integer> temp = new HashMap<>();
            for (int j = i;j < s.length(); j++) {
                if (!temp.containsKey(s.charAt(j))) {
                    temp.put(s.charAt(j), 1);
                } else {
                    temp.put(s.charAt(j), 1+temp.get(s.charAt(j)));
                }

                if (compFreq(temp, sub_freq) && j - i < reslen) {
                    reslen = j-i;
                    res[0] = i;
                    res[1] = j;
                }

            }
        }

        if (reslen != Integer.MAX_VALUE) {
            return s.substring(res[0], res[1] + 1);
        } else {
            return "";
        }
                
    }

    private Boolean compFreq(Map<Character, Integer> main, Map<Character, Integer> sub) {
        for (char c: sub.keySet()) {
            if (!main.containsKey(c) || main.get(c) < sub.get(c)) {
                return false;
            } 
        }
        return true;
    }
}

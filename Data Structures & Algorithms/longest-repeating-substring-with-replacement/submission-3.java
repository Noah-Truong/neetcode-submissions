class Solution {
    public int characterReplacement(String s, int k) {
        char[] arr = s.toCharArray();
        int result = 0;
        for (int i = 0; i < arr.length; i++) {
            int health = k;
            int j = i + 1;
            int l = i - 1;
            int curr = 1;
            
            while (health >= 0 && (j < arr.length || l >=0)) {
                if (j < arr.length) {
                    if (arr[i] != arr[j]) {
                        health--;
                    }

                    if (health >= 0) {
                        j++;
                        curr++;
                    }
                }
                if (l >= 0) {
                    if (arr[i] != arr[l]) {
                        health--;
                    }
                    if (health >= 0) {
                        l--;
                        curr++;
                    }
                   
                }

                
            }
            result = Math.max(result, curr);
            health = k;
            j = i + 1;
            curr = 1;

            while (health >= 0 && j < arr.length) {
                if (arr[j] != arr[i]) {
                    health--;
                }
                if (health >= 0) {
                    j++;
                    curr++;
                }
            }
            result = Math.max(result, curr);

            health = k;
            l = i - 1;
            curr = 1;
            while (health >= 0 && l >= 0) {
                if (arr[l] != arr[i]) {
                    health--;
                }
                if (health >= 0) {
                    l--;
                    curr++;
                }
            }
            result = Math.max(result, curr);
        
        }
        return result;
    }
}

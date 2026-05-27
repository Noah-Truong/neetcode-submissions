class Solution {
    public boolean isValid(String s) {
        char[] c = s.toCharArray();
        Map<Integer, Boolean> closed = new HashMap<>();
        
        for (int i = 0; i < c.length; i++) {
           closed.put(i, false);
        }

        for (int j = 0; j < c.length; j++) {

            if (!closed.get(j)) {

                if (c[j] == '(') {
                    for (int k = j; k < c.length; k++){
                        if (closed.get(k) == false && c[k] == ')') {
                            closed.put(j, true);
                            closed.put(k, true);
                            k = c.length;
                        } else if (closed.get(k)) {
                            return false;
                        }
                    }
                }

                if (c[j] == '[') {
                    for (int k = j; k < c.length; k++){
                        if (closed.get(k) == false && c[k] == ']') {
                            closed.put(j, true);
                            closed.put(k, true);
                            k = c.length;
                        } else if (closed.get(k)) {
                            return false;
                        }
                    }
                }

                if (c[j] == '{') {
                    for (int k = j; k < c.length; k++){
                        if (closed.get(k) == false && c[k] == '}') {
                            closed.put(j, true);
                            closed.put(k, true);
                            k = c.length;
                        } else if (closed.get(k)) {
                            return false;
                        }
                    }
                }
            }
        }

        for (Boolean l: closed.values()){ 
            if (l == false) {
                return false;
            }
        }

        return true;

        
    }
}

class Solution {
   
    public Map<Integer, Integer> shortestPath(int n, List<List<Integer>> edges, int src) {
        Map<Integer, Integer> result = new HashMap<>();
        Map<Integer, List<List<Integer>>> adj = new HashMap<>();
        for (int i = 0; i<n; i++) {
            result.put(i, -1);
        }
        
        for (List<Integer> e: edges) {
            int v1 = e.get(0);
            int v2 = e.get(1);
            int w = e.get(2);
            List<Integer> pair = new ArrayList<>(List.of(v2, w));
            if (adj.containsKey(e.get(0))) {
                adj.get(v1).add(pair);
            } else {
                adj.put(v1, new ArrayList<>(List.of(pair)));
            }

        }

        PriorityQueue<Integer> fringe = new PriorityQueue<>((e1, e2) -> Integer.compare(result.get(e1), result.get(e2)));
        result.put(src, 0);
        int curr = src;

        

        while (curr != -1) {

            if (adj.containsKey(curr)) {

                for (List<Integer> e: adj.get(curr)) {
                    int v2 = e.get(0);
                    int w = e.get(1);
                    
                    if (result.get(v2).equals(-1) || result.get(curr) + w < result.get(v2)) {
                        fringe.add(v2);
                        result.put(v2, w + result.get(curr));
                    }
                }

            }
            if (!fringe.isEmpty()){
                curr = fringe.poll();
            } else {
                curr = -1;
            }
            
        }
        return result;
        

    }  
}

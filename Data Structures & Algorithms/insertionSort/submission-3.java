// Definition for a pair
// class Pair {
//     int key;
//     String value;
//
//     Pair(int key, String value) {
//         this.key = key;
//         this.value = value;
//     }
// }
public class Solution {
    public List<List<Pair>> insertionSort(List<Pair> pairs) {
        List<List<Pair>> result = new ArrayList<>();
        
        for (int i = 0; i < pairs.size(); i++) {
            
            for (int j = i; j > 0; j--) {
                if (pairs.get(j).key < pairs.get(j-1).key){
                    Collections.swap(pairs, j, j-1);
                }
            }
            result.add(new ArrayList<>(pairs));

        }
        return result;
    }
}

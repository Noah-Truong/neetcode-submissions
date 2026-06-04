/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        Queue<TreeNode> v = new LinkedList<>();

        v.add(root);

        while (!v.isEmpty()) {
            List<Integer> level = new ArrayList<>();
            int level_len = v.size();
            
            for (int i = 0; i < level_len; i++) {
                TreeNode curr = v.poll();
                level.add(curr.val);

                if (curr.left != null) {
                    v.add(curr.left);
                }
                if (curr.right != null) {
                    v.add(curr.right);
                }

            }
            result.add(level);


        }
        return result;
        

        
    }

    
}

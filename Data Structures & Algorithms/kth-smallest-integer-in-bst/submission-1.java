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
    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> nodes = new Stack<>();
        ArrayList<Integer> vals = new ArrayList<>();
        TreeNode curr = root;
        while (curr != null) {
            nodes.push(curr);
            curr = curr.left;
        }

        while (!nodes.isEmpty()) {
            TreeNode p = nodes.pop();
            vals.add(p.val);
            if (p.right != null) {
                TreeNode inner_curr = p.right;
                while (inner_curr != null) {
                    nodes.push(inner_curr);
                    inner_curr = inner_curr.left; 
                }
            }
            
        }

        if (k <= vals.size()) {
            return vals.get(k-1);
        } else {
            return kthSmallest(root.right, k - vals.size());
        }

        
    }
}

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
    int res = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        dfs(root);
        return res;
        
        
    }

    private int maxPath(TreeNode root) {
        if (root == null) {return 0;}
        int left = maxPath(root.left);
        int right = maxPath(root.right);
        int path = root.val + Math.max(right, left);
        return Math.max(0, path);
    }

    private void dfs(TreeNode root) {
        if (root != null) {
        int maxleft = maxPath(root.left);
        int maxright = maxPath(root.right);
        res = Math.max(res, root.val + maxright + maxleft);

        dfs(root.right);
        dfs(root.left);
        }
    }
    
}

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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        if (contains(root.left, p) && contains(root.left, q)) {
            return lowestCommonAncestor(root.left, p, q);
        }
        if (contains(root.right, p) && contains(root.right, q)) {
            return lowestCommonAncestor(root.right, p, q);
        }
        return root;
    }

    private Boolean contains(TreeNode root, TreeNode other) {
        if (root == null) {
            return false;
        }
        if (root.val == other.val) {
            return true;
        }

        return contains(root.right, other) || contains(root.left, other);
        
    }
}

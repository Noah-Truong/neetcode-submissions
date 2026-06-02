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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (root == null ) {
            return false;
        }
        if (compare(root, subRoot)) {
            return true;
        }
        
        return isSubtree(root.right, subRoot) || isSubtree(root.left, subRoot);
    }

    private boolean compare(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) {
            return true;
        }
        if ((t1 != null && t2 == null) || (t1 == null && t2 != null)) {
            return false;
        }
        return t1.val == t2.val && compare(t1.right, t2.right) && compare(t1.left, t2.left);
    }
}

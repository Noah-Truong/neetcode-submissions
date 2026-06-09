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
    public boolean isValidBST(TreeNode root) {
        if (root == null) { return true;}
        if (root.left != null && root.left.val >= root.val || root.left != null && !check_left(root.left, root.val)) {
            return false;
        }
        if (root.right != null && root.right.val <= root.val || root.right != null && !check_right(root.right, root.val)) {
            return false;
        }

        return isValidBST(root.left) && isValidBST(root.right);
    }
    private boolean check_left(TreeNode left, Integer val) {
        if (left == null){
            return true;
        }
        if (left.val >= val) {
            return false;
        }
        return check_left(left.left, val) && check_left(left.right, val);
    }

    private boolean check_right(TreeNode right, Integer val) {
        if (right == null){
            return true;
        }
        if (right.val <= val) {
            return false;
        }
        return check_right(right.right, val) && check_right(right.left, val);

    }
}

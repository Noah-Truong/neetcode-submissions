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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0) {
            return null;
        }
        if (preorder.length == 1) {
            return new TreeNode(preorder[0]);
        }
        int root_idx = 0;
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == preorder[0]) {
                root_idx = i;
            }
        }
        int preorder_split = 0;

        for (int j = 1; j < preorder.length; j++) {
            for (int k = 0; k < inorder.length; k++) {
                
                if (preorder[j] == inorder[k] && k < root_idx) {
                    preorder_split = j;
                }
            }
        }



       
        return new TreeNode(preorder[0], buildTree(Arrays.copyOfRange(preorder, 1, preorder_split + 1), 
        Arrays.copyOfRange(inorder, 0, root_idx)) , 
        buildTree(Arrays.copyOfRange(preorder, preorder_split+1, preorder.length), 
        Arrays.copyOfRange(inorder, root_idx + 1, inorder.length)
        ));
    }
  
}
